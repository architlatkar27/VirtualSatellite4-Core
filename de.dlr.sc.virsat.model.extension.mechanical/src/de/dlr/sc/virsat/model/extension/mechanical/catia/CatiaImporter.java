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
import de.dlr.sc.virsat.model.extension.mechanical.catia.util.CatiaHelper;

/**
 * This class imports a JSON representation of a product tree
 *
 */
public class CatiaImporter {

	/**
	 * Main method that imports a JSON representation of our system and updates the
	 * model accordingly
	 * 
	 * @param jsonObject
	 *            the JSON Object
	 * @param mapJsonUuidToSEI
	 *            the mapping of JSON element IDs to the existing trees
	 */
	public void transform(JsonObject jsonObject, Map<String, StructuralElementInstance> mapJsonUuidToSEI) {

	}

	/**
	 * Maps from the IDs of JSON elements to existing model elements in the Virtual
	 * Satellite model 
	 * 
	 * @param jsonContent
	 *            the JSON content to be imported
	 * @param existingTree
	 *            a tree element the imported JSON should be mapped to
	 * @return a map from UUID in the JSON file to their existing tree elements in the model
	 */
	public Map<String, StructuralElementInstance> mapJsonUuidToSEI(JsonObject jsonContent,
			IBeanStructuralElementInstance existingTree) {

		Map<String, StructuralElementInstance> mapExisitingElementToUUID = new HashMap<String, StructuralElementInstance>();
		Map<String, IBeanStructuralElementInstance> mapSEIsToUuid = createMapOfTreeSEIsToUuid(existingTree);

		for (JsonObject object : CatiaHelper.getListOfAllJSONElements(jsonContent)) {
			String uuid = object.getString(CatiaProperties.UUID);
			IBeanStructuralElementInstance mappedElement = mapSEIsToUuid.get(uuid);
			if (mapSEIsToUuid.containsKey(uuid) && mappedElement != null) {
				mapExisitingElementToUUID.put(uuid, mappedElement.getStructuralElementInstance());
			}

		}

		return mapExisitingElementToUUID;

	}

	/**
	 * Method to get all unmapped JSON elements that do not have a representation in
	 * the existing trees
	 * 
	 * @param jsonRoot
	 *            the JSON root element to look for unmapped elements in
	 * @param mapJSONtoSEI
	 *            the Map of JSONObject IDs to SEIs in the model created by method
	 *            {@link #mapJSONtoSEI(JsonObject, IBeanStructuralElementInstance)}
	 * @return a list of unmapped elements
	 */
	public List<JsonObject> getUnmappedJSONObjects(JsonObject jsonRoot,
			Map<String, StructuralElementInstance> mapJSONtoSEI) {

		List<JsonObject> unmappedElements = new ArrayList<>();

		for (JsonObject object : CatiaHelper.getListOfAllJSONElements(jsonRoot)) {
			String uuid = object.getString(CatiaProperties.UUID);
			if (!mapJSONtoSEI.containsKey(uuid)) {
				unmappedElements.add(object);
			}
		}

		return unmappedElements;

	}

	/**
	 * Create a map of all UUIDs to their structural element instances in a tree and their super instances
	 * 
	 * @param existingTree
	 *            the existing tree element in the Virtual Satellite model
	 * @return a map that maps the UUID to all SEIs
	 */
	private Map<String, IBeanStructuralElementInstance> createMapOfTreeSEIsToUuid(
			IBeanStructuralElementInstance existingTree) {

		Map<String, IBeanStructuralElementInstance> mapSEIsToUuid = new HashMap<String, IBeanStructuralElementInstance>();

		for (IBeanStructuralElementInstance sei : existingTree.getDeepChildren(IBeanStructuralElementInstance.class)) {
			mapSEIsToUuid.put(sei.getUuid(), sei);

			// Also add relevant elements in other trees (the super elements) to the map
			for (IBeanStructuralElementInstance superSei : sei.getAllSuperSeis(IBeanStructuralElementInstance.class)) {
				mapSEIsToUuid.put(superSei.getUuid(), superSei);
			}
		}

		return mapSEIsToUuid;

	}

}