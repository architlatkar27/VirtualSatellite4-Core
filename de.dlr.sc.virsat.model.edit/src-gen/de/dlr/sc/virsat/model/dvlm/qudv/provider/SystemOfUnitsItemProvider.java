

/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.dvlm.qudv.provider;



import de.dlr.sc.virsat.model.dvlm.command.UndoableAddCommand;

import de.dlr.sc.virsat.model.dvlm.general.GeneralPackage;

import de.dlr.sc.virsat.model.dvlm.provider.DVLMEditPlugin;

import de.dlr.sc.virsat.model.dvlm.qudv.QudvFactory;
import de.dlr.sc.virsat.model.dvlm.qudv.QudvPackage;
import de.dlr.sc.virsat.model.dvlm.qudv.SystemOfUnits;

import de.dlr.sc.virsat.model.dvlm.roles.RoleManagementCheckCommand;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.command.CommandParameter;

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
 * This is the item provider adapter for a {@link de.dlr.sc.virsat.model.dvlm.qudv.SystemOfUnits} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemOfUnitsItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemOfUnitsItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addUuidPropertyDescriptor(object);
			addSymbolPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addDefinitionURIPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
	 * This adds a property descriptor for the Symbol feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSymbolPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemOfUnits_symbol_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemOfUnits_symbol_feature", "_UI_SystemOfUnits_type"),
				 QudvPackage.Literals.SYSTEM_OF_UNITS__SYMBOL,
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
				 getString("_UI_SystemOfUnits_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemOfUnits_description_feature", "_UI_SystemOfUnits_type"),
				 QudvPackage.Literals.SYSTEM_OF_UNITS__DESCRIPTION,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Definition URI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefinitionURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemOfUnits_definitionURI_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemOfUnits_definitionURI_feature", "_UI_SystemOfUnits_type"),
				 QudvPackage.Literals.SYSTEM_OF_UNITS__DEFINITION_URI,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(QudvPackage.Literals.SYSTEM_OF_UNITS__PREFIX);
			childrenFeatures.add(QudvPackage.Literals.SYSTEM_OF_UNITS__UNIT);
			childrenFeatures.add(QudvPackage.Literals.SYSTEM_OF_UNITS__BASE_UNIT);
			childrenFeatures.add(QudvPackage.Literals.SYSTEM_OF_UNITS__SYSTEM_OF_QUANTITIES);
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
	 * This returns SystemOfUnits.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
	
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SystemOfUnits")); 
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

		
		
	
	
  	
    	
      	
			String label = ((SystemOfUnits)object).getName();
      	
    	
			return label == null || label.length() == 0 ?
				getString("_UI_SystemOfUnits_type") :
				getString("_UI_SystemOfUnits_type") + " " + label;
  	
	
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

		switch (notification.getFeatureID(SystemOfUnits.class)) {
			case QudvPackage.SYSTEM_OF_UNITS__NAME:
			case QudvPackage.SYSTEM_OF_UNITS__UUID:
			case QudvPackage.SYSTEM_OF_UNITS__SYMBOL:
			case QudvPackage.SYSTEM_OF_UNITS__DESCRIPTION:
			case QudvPackage.SYSTEM_OF_UNITS__DEFINITION_URI:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case QudvPackage.SYSTEM_OF_UNITS__PREFIX:
			case QudvPackage.SYSTEM_OF_UNITS__UNIT:
			case QudvPackage.SYSTEM_OF_UNITS__BASE_UNIT:
			case QudvPackage.SYSTEM_OF_UNITS__SYSTEM_OF_QUANTITIES:
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
				(QudvPackage.Literals.SYSTEM_OF_UNITS__PREFIX,
				 QudvFactory.eINSTANCE.createPrefix()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__UNIT,
				 QudvFactory.eINSTANCE.createLinearConversionUnit()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__UNIT,
				 QudvFactory.eINSTANCE.createAffineConversionUnit()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__UNIT,
				 QudvFactory.eINSTANCE.createPrefixedUnit()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__UNIT,
				 QudvFactory.eINSTANCE.createSimpleUnit()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__UNIT,
				 QudvFactory.eINSTANCE.createDerivedUnit()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__BASE_UNIT,
				 QudvFactory.eINSTANCE.createLinearConversionUnit()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__BASE_UNIT,
				 QudvFactory.eINSTANCE.createAffineConversionUnit()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__BASE_UNIT,
				 QudvFactory.eINSTANCE.createPrefixedUnit()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__BASE_UNIT,
				 QudvFactory.eINSTANCE.createSimpleUnit()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__BASE_UNIT,
				 QudvFactory.eINSTANCE.createDerivedUnit()));

		newChildDescriptors.add
			(createChildParameter
				(QudvPackage.Literals.SYSTEM_OF_UNITS__SYSTEM_OF_QUANTITIES,
				 QudvFactory.eINSTANCE.createSystemOfQuantities()));
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
		
	    		
		// For all other commands get the original one
		Command originalCommand = super.createCommand(object, domain, commandClass, commandParameter);
				
	    
	    
	    		
	    	
		// A RolemanagementCheckCommand should not necessarily be wrapped into another RoleManagementCheck Command
		if (originalCommand instanceof RoleManagementCheckCommand) {
			return originalCommand;
		} else {
			// And wrap it into our command checking for the proper access rights
			return new RoleManagementCheckCommand(originalCommand, commandParameter);	
		}
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == QudvPackage.Literals.SYSTEM_OF_UNITS__UNIT ||
			childFeature == QudvPackage.Literals.SYSTEM_OF_UNITS__BASE_UNIT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
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
