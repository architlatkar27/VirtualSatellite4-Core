/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.concept.project.filecontent

import de.dlr.sc.virsat.model.concept.project.filecontent.IFileContentGenerator
import de.dlr.sc.virsat.model.concept.project.IProjectBuilderInfo
/**
 * Class to create the content for the Manifest of the Concept Plugin
 */
class ConceptPluginExampleConceptGenerator implements IFileContentGenerator {
	
	override generateContent(IProjectBuilderInfo projectBuilderInfo) {
		return conceptExampleContent(projectBuilderInfo).toString;
	}
	
	def conceptExampleContent(IProjectBuilderInfo builderInfo) '''
	Concept «builderInfo.projectName» description "Example Concept for Interface Architecture" 
	{
		
		Category InterfaceEnd {
		}	
		
		Category Interface {
			Reference ifEndFrom of Type InterfaceEnd;
			Reference ifEndTo of Type InterfaceEnd;
		
		}
	}
	
	'''
}