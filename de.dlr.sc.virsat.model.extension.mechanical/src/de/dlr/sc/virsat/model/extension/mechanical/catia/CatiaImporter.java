/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.extension.mechanical.catia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.cliftonlabs.json_simple.JsonObject;

import de.dlr.sc.virsat.model.concept.types.structural.IBeanStructuralElementInstance;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralElementInstance;

/**
 * This class imports a JSON representation of a product tree
 *
 */
public class CatiaImporter {

	/**
	 * Main method that creates the JSON representation of a configuration tree
	 * 
	 * @param jsonObject
	 *            the Json Object
	 * @param mapJSONtoSEI
	 *            the mapping of JSON elements to the existing trees
	 */
	public void transform(JsonObject jsonObject, Map<String, StructuralElementInstance> mapJSONtoSEI) {

	}

	/**
	 * Map the imported JSON elements to existing model elements in the Virtual
	 * Satellite model and return the ones for which no mapping can be found
	 * 
	 * @param jsonContent
	 *            the JSON content to be imported
	 * @param existingTree
	 *            a tree element the imported JSON should be mapped to
	 * @return a map of existing tree elements to their UUID in the JSON file
	 */
	public Map<String, StructuralElementInstance> mapJSONtoSEI(JsonObject jsonContent,
			IBeanStructuralElementInstance existingTree) {

		Map<String, StructuralElementInstance> mapUUIDtoExisitingElement = new HashMap<String, StructuralElementInstance>();

		return mapUUIDtoExisitingElement;

	}

	
	/**
	 * Method to get all unmapped JSON elements that do not have a repesentation in the existing trees
	 * @param jsonRoot the JSON root element to look for
	 * @param mapJSONtoSEI the Map of SEIs to JSONObjects created by method {@link #mapJSONtoSEI(JsonObject, IBeanStructuralElementInstance)} 
	 * @return a list of unmapped elements
	 */
	public List<JsonObject> getUnmappedJSONObjects(JsonObject jsonRoot,
			Map<String, StructuralElementInstance> mapJSONtoSEI) {

		List<JsonObject> unmappedElements = new ArrayList<>();
		
		return unmappedElements;
		
	}

}
