/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.server.data;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

import de.dlr.sc.virsat.apps.api.external.ModelAPI;
import de.dlr.sc.virsat.model.concept.types.structural.ABeanStructuralElementInstance;
import de.dlr.sc.virsat.model.concept.types.structural.IBeanStructuralElementInstance;

public class ModelAccess {

	private static ModelAccess modelAccess = null;

	private ModelAccess() {
	}

	public static ModelAccess getInstance() {
		if (modelAccess == null) {
			modelAccess = new ModelAccess();
		}

		return modelAccess;
	}

	/**
	 * Takes the current VirSat repository and converts the rootSeis to json, which is then returned.
	 * @param projectdirectory directory of the VirSat project
	 * @return json-string of the rootSeis of the VirSat repository at the given directory
	 */
	public String showRepository(String projectdirectory) {
		ModelAPI modelAPI = new ModelAPI(projectdirectory);
		List<ABeanStructuralElementInstance> rootBeanSeis = modelAPI.getRootSeis(ABeanStructuralElementInstance.class);
		
		JsonArray list = new JsonArray();
		for (ABeanStructuralElementInstance rootBeanSei : rootBeanSeis) {
			list.add(rootBeanSei.toJson());
		}
        JsonObject obj = new JsonObject();
        obj.put("rootBeanSeis", list);
		return obj.toJson();
	}
	
	/**
	 * Gets the {@link IBeanStructuralElementInstance} from the given UUID and converts it to a json structure, which is then
	 * returned.
	 * @param projectdirectory the directory of the local VirSat project (for context)
	 * @param uuid the UUID for which the {@link IBeanStructuralElementInstance} is wanted
	 * @return json string of the {@link IBeanStructuralElementInstance} that belongs to the given UUID
	 */
	public String showBeanSeiFromUuid(String projectdirectory, String uuid) {
		String result = "null";
		
		ModelAPI modelAPI = new ModelAPI(projectdirectory);
		IBeanStructuralElementInstance beanSei;
		try {
			beanSei = modelAPI.findBeanSeiByUuid(uuid);
			if (beanSei != null) {
				result = beanSei.toJson().toJson();
			}
		} catch (CoreException e) {
			result = e.getMessage();
			e.printStackTrace();
		}
		
		return result;
	}
}