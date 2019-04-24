/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.dvlm.calculation.provider;

import de.dlr.sc.virsat.model.dvlm.calculation.util.CalculationAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CalculationItemProviderAdapterFactory extends CalculationAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalculationItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(IItemFontProvider.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.EquationSection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquationSectionItemProvider equationSectionItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.EquationSection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEquationSectionAdapter() {
		if (equationSectionItemProvider == null) {
			equationSectionItemProvider = new EquationSectionItemProvider(this);
		}

		return equationSectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.Import} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportItemProvider importItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.Import}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createImportAdapter() {
		if (importItemProvider == null) {
			importItemProvider = new ImportItemProvider(this);
		}

		return importItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.Equation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquationItemProvider equationItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.Equation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEquationAdapter() {
		if (equationItemProvider == null) {
			equationItemProvider = new EquationItemProvider(this);
		}

		return equationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.EquationDefinition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquationDefinitionItemProvider equationDefinitionItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.EquationDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEquationDefinitionAdapter() {
		if (equationDefinitionItemProvider == null) {
			equationDefinitionItemProvider = new EquationDefinitionItemProvider(this);
		}

		return equationDefinitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.EquationIntermediateResult} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquationIntermediateResultItemProvider equationIntermediateResultItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.EquationIntermediateResult}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEquationIntermediateResultAdapter() {
		if (equationIntermediateResultItemProvider == null) {
			equationIntermediateResultItemProvider = new EquationIntermediateResultItemProvider(this);
		}

		return equationIntermediateResultItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.TypeInstanceResult} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeInstanceResultItemProvider typeInstanceResultItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.TypeInstanceResult}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTypeInstanceResultAdapter() {
		if (typeInstanceResultItemProvider == null) {
			typeInstanceResultItemProvider = new TypeInstanceResultItemProvider(this);
		}

		return typeInstanceResultItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.TypeDefinitionResult} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeDefinitionResultItemProvider typeDefinitionResultItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.TypeDefinitionResult}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTypeDefinitionResultAdapter() {
		if (typeDefinitionResultItemProvider == null) {
			typeDefinitionResultItemProvider = new TypeDefinitionResultItemProvider(this);
		}

		return typeDefinitionResultItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.AdditionAndSubtraction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdditionAndSubtractionItemProvider additionAndSubtractionItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.AdditionAndSubtraction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAdditionAndSubtractionAdapter() {
		if (additionAndSubtractionItemProvider == null) {
			additionAndSubtractionItemProvider = new AdditionAndSubtractionItemProvider(this);
		}

		return additionAndSubtractionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.MultiplicationAndDivision} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicationAndDivisionItemProvider multiplicationAndDivisionItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.MultiplicationAndDivision}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMultiplicationAndDivisionAdapter() {
		if (multiplicationAndDivisionItemProvider == null) {
			multiplicationAndDivisionItemProvider = new MultiplicationAndDivisionItemProvider(this);
		}

		return multiplicationAndDivisionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.PowerFunction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerFunctionItemProvider powerFunctionItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.PowerFunction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPowerFunctionAdapter() {
		if (powerFunctionItemProvider == null) {
			powerFunctionItemProvider = new PowerFunctionItemProvider(this);
		}

		return powerFunctionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.Function} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionItemProvider functionItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionAdapter() {
		if (functionItemProvider == null) {
			functionItemProvider = new FunctionItemProvider(this);
		}

		return functionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.AdvancedFunction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdvancedFunctionItemProvider advancedFunctionItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.AdvancedFunction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAdvancedFunctionAdapter() {
		if (advancedFunctionItemProvider == null) {
			advancedFunctionItemProvider = new AdvancedFunctionItemProvider(this);
		}

		return advancedFunctionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.SetFunction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetFunctionItemProvider setFunctionItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.SetFunction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSetFunctionAdapter() {
		if (setFunctionItemProvider == null) {
			setFunctionItemProvider = new SetFunctionItemProvider(this);
		}

		return setFunctionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.Parenthesis} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParenthesisItemProvider parenthesisItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.Parenthesis}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParenthesisAdapter() {
		if (parenthesisItemProvider == null) {
			parenthesisItemProvider = new ParenthesisItemProvider(this);
		}

		return parenthesisItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.ValuePi} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValuePiItemProvider valuePiItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.ValuePi}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createValuePiAdapter() {
		if (valuePiItemProvider == null) {
			valuePiItemProvider = new ValuePiItemProvider(this);
		}

		return valuePiItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.ValueE} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueEItemProvider valueEItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.ValueE}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createValueEAdapter() {
		if (valueEItemProvider == null) {
			valueEItemProvider = new ValueEItemProvider(this);
		}

		return valueEItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.NumberLiteral} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumberLiteralItemProvider numberLiteralItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.NumberLiteral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNumberLiteralAdapter() {
		if (numberLiteralItemProvider == null) {
			numberLiteralItemProvider = new NumberLiteralItemProvider(this);
		}

		return numberLiteralItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.ReferencedInput} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferencedInputItemProvider referencedInputItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.ReferencedInput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReferencedInputAdapter() {
		if (referencedInputItemProvider == null) {
			referencedInputItemProvider = new ReferencedInputItemProvider(this);
		}

		return referencedInputItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dlr.sc.virsat.model.dvlm.calculation.ReferencedDefinitionInput} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferencedDefinitionInputItemProvider referencedDefinitionInputItemProvider;

	/**
	 * This creates an adapter for a {@link de.dlr.sc.virsat.model.dvlm.calculation.ReferencedDefinitionInput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReferencedDefinitionInputAdapter() {
		if (referencedDefinitionInputItemProvider == null) {
			referencedDefinitionInputItemProvider = new ReferencedDefinitionInputItemProvider(this);
		}

		return referencedDefinitionInputItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (equationSectionItemProvider != null) equationSectionItemProvider.dispose();
		if (importItemProvider != null) importItemProvider.dispose();
		if (equationItemProvider != null) equationItemProvider.dispose();
		if (equationDefinitionItemProvider != null) equationDefinitionItemProvider.dispose();
		if (equationIntermediateResultItemProvider != null) equationIntermediateResultItemProvider.dispose();
		if (typeInstanceResultItemProvider != null) typeInstanceResultItemProvider.dispose();
		if (typeDefinitionResultItemProvider != null) typeDefinitionResultItemProvider.dispose();
		if (additionAndSubtractionItemProvider != null) additionAndSubtractionItemProvider.dispose();
		if (multiplicationAndDivisionItemProvider != null) multiplicationAndDivisionItemProvider.dispose();
		if (powerFunctionItemProvider != null) powerFunctionItemProvider.dispose();
		if (functionItemProvider != null) functionItemProvider.dispose();
		if (advancedFunctionItemProvider != null) advancedFunctionItemProvider.dispose();
		if (setFunctionItemProvider != null) setFunctionItemProvider.dispose();
		if (parenthesisItemProvider != null) parenthesisItemProvider.dispose();
		if (valuePiItemProvider != null) valuePiItemProvider.dispose();
		if (valueEItemProvider != null) valueEItemProvider.dispose();
		if (numberLiteralItemProvider != null) numberLiteralItemProvider.dispose();
		if (referencedInputItemProvider != null) referencedInputItemProvider.dispose();
		if (referencedDefinitionInputItemProvider != null) referencedDefinitionInputItemProvider.dispose();
	}

}
