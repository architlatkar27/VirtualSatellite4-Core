/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.server.dataaccess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.junit.Before;
import org.junit.Test;

import de.dlr.sc.virsat.model.concept.types.property.BeanPropertyInt;
import de.dlr.sc.virsat.model.concept.types.structural.BeanStructuralElementInstance;
import de.dlr.sc.virsat.model.dvlm.DVLMPackage;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralElement;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralElementInstance;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralFactory;
import de.dlr.sc.virsat.project.editingDomain.VirSatTransactionalEditingDomain;
import de.dlr.sc.virsat.project.resources.command.CreateSeiResourceAndFileCommand;
import de.dlr.sc.virsat.server.test.AServerRepositoryTest;

public class CustomJsonProviderTest extends AServerRepositoryTest {

	private CustomJsonProvider provider;
	private BeanStructuralElementInstance testBean;
	private Class<?> type;
	private Set<Class<?>> beanClass = new HashSet<>();
	private MediaType mediaType;
	private String testString = "test";

	// TODO: test changes for sei
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		provider = new CustomJsonProvider();
		provider.setServerRepository(testServerRepository);
		VirSatTransactionalEditingDomain ed = testServerRepository.getEd();
		
		StructuralElement testSe = StructuralFactory.eINSTANCE.createStructuralElement();
		testSe.setIsRootStructuralElement(true);
		testSe.setName("testSe");

		StructuralElementInstance testSei = StructuralFactory.eINSTANCE.createStructuralElementInstance();
		testSei.setType(testSe);
		testSei.setName(testString);
		
		Command addSeiToRepo = AddCommand.create(ed, ed.getResourceSet().getRepository(), 
				DVLMPackage.eINSTANCE.getRepository_RootEntities(), testSei);
		ed.getCommandStack().execute(addSeiToRepo);
		
		Command createSei = new CreateSeiResourceAndFileCommand(ed.getResourceSet(), testSei);
		ed.getCommandStack().execute(createSei);

		ed.getResourceSet().saveAllResources(new NullProgressMonitor(), ed);

		testBean = new BeanStructuralElementInstance(testSei);

		type = BeanStructuralElementInstance.class;
		beanClass.add(type);
		
		mediaType = MediaType.APPLICATION_JSON_TYPE;
		
		// Initial commit to have a valid HEAD
		Git git = Git.open(testServerRepository.getLocalRepositoryPath());
		git.add().addFilepattern(".").call();
		git.commit().setAll(true).setMessage("Initial commit").call();
		git.push().call();
	}

	/**
	 * Call writeTo and assert that the the output String is as expected
	 * @return the output String
	 * @throws WebApplicationException
	 * @throws IOException
	 */
	private String writeToAndAssert() throws WebApplicationException, IOException {
		OutputStream entityStream = new ByteArrayOutputStream();
		provider.writeTo(testBean, type, type, null, mediaType, (MultivaluedMap<String, Object>) null, entityStream);
		
		String output = entityStream.toString();
		assertTrue(output.contains(testString));
		
		return output;
	}

	// Test the marshalling
	@Test
	public void testWriteTo() throws WebApplicationException, IOException {
		writeToAndAssert();
	}
	
	private int countCommits() throws IOException, NoHeadException, GitAPIException, InterruptedException {
		Git git = Git.open(pathRepoRemote.toFile());
		Iterator<RevCommit> iterator = git.log().call().iterator();
		int commits = 0;
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getFullMessage());
			commits++;
		}
		git.close();
		return commits;
	}
	
	// Test the unmarshalling
	@SuppressWarnings("unchecked")
	@Test
	public void testReadFrom() throws Exception {
		
		int initialCommits = countCommits();
		
		String output = writeToAndAssert();
		
		// No changes
		StringBuffer buf = new StringBuffer(output);
		InputStream entityStream = new ByteArrayInputStream(buf.toString().getBytes());
		provider.readFrom((Class<Object>) type, type, null, mediaType, null, entityStream);
		
		assertEquals(testString, testBean.getName());
		assertEquals("No new commit", initialCommits, countCommits());
		
		// changes
		// TODO: the name is not present on the fs, why???
		String newValue = "new";
		output = output.replace(testString, newValue);
		buf = new StringBuffer(output);
		entityStream = new ByteArrayInputStream(buf.toString().getBytes());
		provider.readFrom((Class<Object>) type, type, null, mediaType, null, entityStream);
		
		assertEquals(newValue, testBean.getName());
		assertEquals("One new commit", initialCommits + 1, countCommits());
	}

	@Test
	public void testGetJAXBContext() throws JAXBException {
		JAXBContext context = provider.getJAXBContext(beanClass, null, mediaType, null);
		assertNotNull(context);
		
		JAXBContext context2 = provider.getJAXBContext(beanClass, null, mediaType, null);
		assertSame("Context got cashed", context, context2);
		
		beanClass.add(BeanPropertyInt.class);
		JAXBContext context3 = provider.getJAXBContext(beanClass, null, mediaType, null);
		assertNotSame("New context because the classes to register changed", context, context3);
	}

}
