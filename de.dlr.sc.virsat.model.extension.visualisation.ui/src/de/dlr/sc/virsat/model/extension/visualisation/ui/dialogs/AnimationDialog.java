/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.extension.visualisation.ui.dialogs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import de.dlr.sc.virsat.model.extension.visualisation.ui.Activator;
import de.dlr.sc.virsat.project.resources.VirSatProjectResource;
import de.dlr.sc.virsat.project.ui.navigator.contentProvider.VirSatWorkspaceContentProvider;
import de.dlr.sc.virsat.project.ui.navigator.labelProvider.VirSatWorkspaceLabelProvider;

/**
 * Simple Dialog to select projects for animation
 * @author liu_yg
 *
 */
public class AnimationDialog extends TitleAreaDialog {

	protected static final int VIEWER_HEIGHT = 150;
	
	protected List<VirSatProjectResource> listProjectSelected = new ArrayList<VirSatProjectResource>();
	private TableViewer viewerProjectSelected;
	private ProjectSelectionPart projectSelectionPart;
	
	/**
	 * Constructor for the simple comparison dialog
	 * @param parentShell the parent shell in which to create the dialog
	 */
	public AnimationDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Animation for Satellite Models");
		setMessage("Select the Model to animation!", IMessageProvider.INFORMATION);
		getButton(IDialogConstants.OK_ID).setEnabled(false);
		try {
			setTitleImage(new Image(null, Activator.getFileFromPlugin("/resources/icons/VirSat64.gif").openStream()));
		} catch (IOException e) {
			Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.getPluginId(), "CompareModelPropertyDialog: Failed to load image", e));
		}	
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		
		projectSelectionPart = new ProjectSelectionPart(area) {
			@Override
			public void validateProject() {
				validateInput();
			}
			
			@Override
			public void extractUserSelection() {
				super.extractUserSelection();
				addSelection();
			}
		};
		
		Composite container2 = new Composite(area, SWT.NONE);
		container2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout2 = new GridLayout(1, false);
		container2.setLayout(layout2);
		createProjectSelected(container2);
		
		return area;
	}
	
	/**
	 * Creates the dialog area where put the selected project
	 * @param container the main container where to create the dialog area
	 */
	private void createProjectSelected(Composite container) {
		Label labelProjectCompareTo = new Label(container, SWT.NONE);
		labelProjectCompareTo.setText("Selected projects for animation:");
	
		viewerProjectSelected = new TableViewer(container);
		viewerProjectSelected.setContentProvider(new VirSatWorkspaceContentProvider());
		viewerProjectSelected.setLabelProvider(new VirSatWorkspaceLabelProvider());
			
		GridData gridDataViewer = new GridData();
		gridDataViewer.grabExcessHorizontalSpace = true;
		gridDataViewer.grabExcessVerticalSpace = true;
		gridDataViewer.horizontalAlignment = GridData.FILL;
		gridDataViewer.verticalAlignment = GridData.FILL;
		gridDataViewer.heightHint = VIEWER_HEIGHT;
		
		viewerProjectSelected.getControl().setLayoutData(gridDataViewer);
		viewerProjectSelected.addSelectionChangedListener((obj) -> {
			deleteSelection();
			validateInput();
		});
		
	}

	/**
	 * This method validates the inputs
	 * @return returns true in case inputs are valid
	 */
	protected boolean validateInput() {
		boolean inputsValid = false;
		
		if (listProjectSelected.size() > 1) {
			inputsValid = true;
			setMessage("Selections are all fine!", IMessageProvider.INFORMATION);
		} else {
			setMessage("Select the Model to animation!", IMessageProvider.ERROR);
		}
	
		getButton(IDialogConstants.OK_ID).setEnabled(inputsValid);
		return inputsValid;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	/**
	 * This method stores the selected project into animation list
	 */
	protected void addSelection() {
		VirSatProjectResource selectedProject = projectSelectionPart.getProjectResource();
		if (!listProjectSelected.contains(selectedProject)) {
			listProjectSelected.add(selectedProject);	
			viewerProjectSelected.add(selectedProject);
		}
	}
	
	/**
	 * This method delete the selected project in the animation list
	 */
	protected void deleteSelection() {
		IStructuredSelection selection = (IStructuredSelection) viewerProjectSelected.getSelection();

		if (!selection.isEmpty()) {
			VirSatProjectResource selectedProject = (VirSatProjectResource) selection.getFirstElement();
			
			listProjectSelected.remove(selectedProject);
			viewerProjectSelected.remove(selectedProject);	
		}
	}

	/**
	 * Call this method to get the project that was selected for comparison
	 * @return the selected project as VirSatProjectResource
	 */
	public List<VirSatProjectResource> getProjectsResource() {
		return listProjectSelected;
	}
}