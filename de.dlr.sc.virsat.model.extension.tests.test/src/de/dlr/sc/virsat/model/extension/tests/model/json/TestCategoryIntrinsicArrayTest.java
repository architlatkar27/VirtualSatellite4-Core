/*******************************************************************************
 * Copyright (c) 2020 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.extension.tests.model.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;

import de.dlr.sc.virsat.model.concept.list.IBeanList;
import de.dlr.sc.virsat.model.concept.types.property.BeanPropertyString;
import de.dlr.sc.virsat.model.dvlm.categories.propertyinstances.ArrayInstance;
import de.dlr.sc.virsat.model.dvlm.json.JAXBUtility;
import de.dlr.sc.virsat.model.dvlm.types.impl.VirSatUuid;
import de.dlr.sc.virsat.model.extension.tests.model.ATestCategoryIntrinsicArrayTest;
import de.dlr.sc.virsat.model.extension.tests.model.TestCategoryIntrinsicArray;
import de.dlr.sc.virsat.model.extension.tests.test.TestActivator;

public class TestCategoryIntrinsicArrayTest extends ATestCategoryIntrinsicArrayTest {
	
	private JAXBUtility jaxbUtility;
	private BeanPropertyString bpString;
	private TestCategoryIntrinsicArray tcIntrinsicArray;
	
	private static final String RESOURCE = "/resources/json/TestCategoryIntrinsicArray_Marshaling.json";
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		jaxbUtility = new JAXBUtility(new Class[] {TestCategoryIntrinsicArray.class});
		
		bpString = JsonTestHelper.createTestStringBean(concept);

		tcIntrinsicArray = new TestCategoryIntrinsicArray(concept);
		tcIntrinsicArray.getTypeInstance().setUuid(new VirSatUuid("f34d30b0-80f5-4c96-864f-29ab4d3ae9f2"));
		tcIntrinsicArray.getTestStringArrayDynamicBean().getArrayInstance().setUuid(new VirSatUuid("ee6e1025-4a77-4b32-9c62-cb459ed76ce8"));		
		IBeanList<BeanPropertyString> list = tcIntrinsicArray.getTestStringArrayStaticBean();
		JsonTestHelper.setStaticIBeanListUuids(list);
	}
	
	@Test
	public void testJsonMarshalling() throws JAXBException, IOException {
		bpString.setValue(JsonTestHelper.TEST_STRING);
		
		tcIntrinsicArray.getTestStringArrayStaticBean().get(0).setValue(JsonTestHelper.TEST_STRING);
		tcIntrinsicArray.getTestStringArrayDynamicBean().add(bpString);
		
		JsonTestHelper.assertMarshall(jaxbUtility, RESOURCE, tcIntrinsicArray);
	}
	
	@Test
	public void testJsonUnmarshalling() throws JAXBException, IOException {
		ArrayInstance originalArrayInstance = tcIntrinsicArray.getTestStringArrayStaticBean().getArrayInstance();
		
		// Quick mock setup to embed the model into a resource set
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resourceImpl = new ResourceImpl();
		resourceSet.getResources().add(resourceImpl);
		resourceImpl.getContents().add(tcIntrinsicArray.getATypeInstance());
		resourceImpl.getContents().add(originalArrayInstance);
		resourceImpl.getContents().add(bpString.getATypeInstance());
		
		Unmarshaller jsonUnmarshaller = jaxbUtility.getJsonUnmarshaller(resourceSet);
		
		assertNull(tcIntrinsicArray.getTestStringArrayStaticBean().get(0).getValue());
		assertEquals(tcIntrinsicArray.getTestStringArrayDynamicBean().size(), 0);
		
		String inputJson = TestActivator.getResourceContentAsString(RESOURCE);
		StringReader sr = new StringReader(inputJson);

		jsonUnmarshaller.unmarshal(new StreamSource(sr), TestCategoryIntrinsicArray.class);
		assertEquals("Element in static element changed", JsonTestHelper.TEST_STRING, tcIntrinsicArray.getTestStringArrayStaticBean().get(0).getValue());
		assertEquals("Successfully added an element", 1, tcIntrinsicArray.getTestStringArrayDynamicBean().size());
	}
}
