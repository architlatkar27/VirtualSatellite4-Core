

/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.dvlm.structural.provider;



import de.dlr.sc.virsat.model.dvlm.categories.ATypeInstance;
import de.dlr.sc.virsat.model.dvlm.categories.CategoriesFactory;
import de.dlr.sc.virsat.model.dvlm.categories.CategoriesPackage;

import de.dlr.sc.virsat.model.dvlm.categories.Category;
import de.dlr.sc.virsat.model.dvlm.command.UndoableAddCommand;

import de.dlr.sc.virsat.model.dvlm.general.GeneralPackage;
import de.dlr.sc.virsat.model.dvlm.general.IQualifiedName;

import de.dlr.sc.virsat.model.dvlm.inheritance.InheritancePackage;

import de.dlr.sc.virsat.model.dvlm.provider.DVLMEditPlugin;

import de.dlr.sc.virsat.model.dvlm.roles.IUserContext;
import de.dlr.sc.virsat.model.dvlm.roles.RoleManagementCheckCommand;

import de.dlr.sc.virsat.model.dvlm.roles.UserRegistry;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralElement;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralElementInstance;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralFactory;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralPackage;

import de.dlr.sc.virsat.model.dvlm.util.DVLMCommandParameterApplicableForCheck;

import java.net.URL;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.CreateCopyCommand;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.command.InitializeCopyCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.dlr.sc.virsat.model.dvlm.structural.StructuralElementInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StructuralElementInstanceItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralElementInstanceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addUuidPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addAssignedDisciplinePropertyDescriptor(object);
			addSuperSeisPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Uuid feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUuidPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IUuid_uuid_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IUuid_uuid_feature", "_UI_IUuid_type"),
				 GeneralPackage.Literals.IUUID__UUID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IDescription_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IDescription_description_feature", "_UI_IDescription_type"),
				 GeneralPackage.Literals.IDESCRIPTION__DESCRIPTION,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IName_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IName_name_feature", "_UI_IName_type"),
				 GeneralPackage.Literals.INAME__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Assigned Discipline feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAssignedDisciplinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IAssignedDiscipline_assignedDiscipline_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IAssignedDiscipline_assignedDiscipline_feature", "_UI_IAssignedDiscipline_type"),
				 GeneralPackage.Literals.IASSIGNED_DISCIPLINE__ASSIGNED_DISCIPLINE,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Super Seis feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperSeisPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IInheritsFrom_superSeis_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IInheritsFrom_superSeis_feature", "_UI_IInheritsFrom_type"),
				 InheritancePackage.Literals.IINHERITS_FROM__SUPER_SEIS,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StructuralElementInstance_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StructuralElementInstance_type_feature", "_UI_StructuralElementInstance_type"),
				 StructuralPackage.Literals.STRUCTURAL_ELEMENT_INSTANCE__TYPE,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CategoriesPackage.Literals.ICATEGORY_ASSIGNMENT_CONTAINER__CATEGORY_ASSIGNMENTS);
			childrenFeatures.add(StructuralPackage.Literals.STRUCTURAL_ELEMENT_INSTANCE__RELATION_INSTANCES);
			childrenFeatures.add(StructuralPackage.Literals.STRUCTURAL_ELEMENT_INSTANCE__CHILDREN);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * *********************************
	 * VirSat Specific Code Generation
	 * *********************************
	 * This returns StructuralElementInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) { 
		Object rtrnObj = overlayImage(object, getResourceLocator().getImage("full/obj16/StructuralElementInstance")); 
		
		// In case we can find a trace to an object typed by IQualifedName we might have an alternative image
		IQualifiedName qualifiedNameObject = null;
		if (object instanceof ATypeInstance) {
			ATypeInstance typeInstance = (ATypeInstance) object;
			qualifiedNameObject = typeInstance.getType();
		} else if (object instanceof StructuralElementInstance) { 
			StructuralElementInstance structuralElementInstance = (StructuralElementInstance) object;
			qualifiedNameObject = structuralElementInstance.getType();			
		} else if (object instanceof StructuralElement) { 
			qualifiedNameObject = (StructuralElement) object;		
		} else if (object instanceof Category) { 
			qualifiedNameObject = (Category) object;		
		}
		
		// In case we could trace an object of IQualifedName we now ask the image registry for an alternative image
		if (qualifiedNameObject != null) {
			String fullQualifiedID = qualifiedNameObject.getFullQualifiedName();
			URL imageUrl = DVLMEditPlugin.getImageRegistry().get(fullQualifiedID);
			if (imageUrl != null) {
				rtrnObj = overlayImage(object, imageUrl);
			}
		}
		return rtrnObj;
	}
	
	/**
	 * *********************************
	 * VirSat Specific Code Generation
	 * *********************************
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {

			String label = ((StructuralElementInstance)object).getName();
			return label == null || label.length() == 0 ?
				getString("_UI_StructuralElementInstance_type") :
				getString("_UI_StructuralElementInstance_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(StructuralElementInstance.class)) {
			case StructuralPackage.STRUCTURAL_ELEMENT_INSTANCE__UUID:
			case StructuralPackage.STRUCTURAL_ELEMENT_INSTANCE__DESCRIPTION:
			case StructuralPackage.STRUCTURAL_ELEMENT_INSTANCE__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case StructuralPackage.STRUCTURAL_ELEMENT_INSTANCE__CATEGORY_ASSIGNMENTS:
			case StructuralPackage.STRUCTURAL_ELEMENT_INSTANCE__RELATION_INSTANCES:
			case StructuralPackage.STRUCTURAL_ELEMENT_INSTANCE__CHILDREN:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CategoriesPackage.Literals.ICATEGORY_ASSIGNMENT_CONTAINER__CATEGORY_ASSIGNMENTS,
				 CategoriesFactory.eINSTANCE.createCategoryAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(StructuralPackage.Literals.STRUCTURAL_ELEMENT_INSTANCE__RELATION_INSTANCES,
				 StructuralFactory.eINSTANCE.createRelationInstance()));

		newChildDescriptors.add
			(createChildParameter
				(StructuralPackage.Literals.STRUCTURAL_ELEMENT_INSTANCE__CHILDREN,
				 StructuralFactory.eINSTANCE.createStructuralElementInstance()));
	}
	
	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Collection<?> collection) {
		// In case that a Type Instance is inherited it will have some Super TIs being set.
		// Then the command for removing the TI should fail, because the inheritance
		// builder would regenerate it anyway
		for (Object obj : collection) {
			if (obj instanceof ATypeInstance) {
				ATypeInstance ti = (ATypeInstance) obj;
				if (!ti.getSuperTis().isEmpty()) {
					return UnexecutableCommand.INSTANCE;
				}
			}
		}
		
		// In all other cases create the usual command
		return super.createRemoveCommand(domain, owner, feature, collection);
	}
	
	/**
	 * *********************************
	 * VirSat Specific Code Generation
	 * *********************************
 	 * Override to the createAddCommand Method
 	 * <!-- begin-user-doc -->
 	 * <!-- end-user-doc -->
 	 * @generated
 	*/
	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,	Collection<?> collection, int index) {
		// Override functionality with the undoable ADD Command that performs undo by taking out the collection from the containing list
		// rather than reducing the index and assuming the last objects on the list have been added by the current command
		return new UndoableAddCommand(domain, owner, feature, collection, index);
	}
	
	/**
	 * *********************************
	 * VirSat Specific Code Generation
	 * *********************************
 	 * This pipes the command through our RoleManagmentCheckCommand, so we can check directly if a user is allowed to modify
 	 * <!-- begin-user-doc -->
 	 * <!-- end-user-doc -->
 	 * @generated
 	*/
	@Override
	public Command createCommand(Object object, EditingDomain domain, Class<? extends Command> commandClass, CommandParameter commandParameter) {
		
		// Set the UserContext either from the SystemUserRegistry or
		// from the Domain if it exists
		IUserContext userContext = UserRegistry.getInstance();
		if (domain instanceof IUserContext) {
			userContext = (IUserContext) domain;
		}
		
		
		// For the Repository and StructuralElementInstances we prefer the command for the aplicablefor paradigm
		// If the requested command is not valid for the current obejcts an unexecutable command will be handed back instead
		DVLMCommandParameterApplicableForCheck commandParameterCheck = new DVLMCommandParameterApplicableForCheck(commandParameter);
		if ((commandClass == SetCommand.class)
			|| (commandClass == CopyCommand.class)
			|| (commandClass == CreateCopyCommand.class)
			|| (commandClass == InitializeCopyCommand.class)
			|| (commandClass == AddCommand.class)
			|| (commandClass == MoveCommand.class)
			|| (commandClass == ReplaceCommand.class)
			|| (commandClass == DragAndDropCommand.class)
			|| (commandClass == CreateChildCommand.class)) {
			
			if (!commandParameterCheck.isValidCommandParameter(commandParameter)) {
				return new RoleManagementCheckCommand(UnexecutableCommand.INSTANCE, commandParameter, userContext);
			}
		}
		// For all other commands get the original one
		Command originalCommand = super.createCommand(object, domain, commandClass, commandParameter);
		// A RolemanagementCheckCommand should not necessarily be wrapped into another RoleManagementCheck Command
		if (originalCommand instanceof RoleManagementCheckCommand) {
			return originalCommand;
		} else {
			// And wrap it into our command checking for the proper access rights
			return new RoleManagementCheckCommand(originalCommand, commandParameter, userContext);	
		}
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DVLMEditPlugin.INSTANCE;
	}

}
