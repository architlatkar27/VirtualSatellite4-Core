/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.dvlm.qudv;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quantity Kind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dlr.sc.virsat.model.dvlm.qudv.QuantityKind#getGeneral <em>General</em>}</li>
 * </ul>
 *
 * @see de.dlr.sc.virsat.model.dvlm.qudv.QudvPackage#getQuantityKind()
 * @model
 * @generated
 */
public interface QuantityKind extends AQuantityKind {
	/**
	 * Returns the value of the '<em><b>General</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General</em>' reference.
	 * @see #setGeneral(AQuantityKind)
	 * @see de.dlr.sc.virsat.model.dvlm.qudv.QudvPackage#getQuantityKind_General()
	 * @model required="true"
	 * @generated
	 */
	AQuantityKind getGeneral();

	/**
	 * Sets the value of the '{@link de.dlr.sc.virsat.model.dvlm.qudv.QuantityKind#getGeneral <em>General</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General</em>' reference.
	 * @see #getGeneral()
	 * @generated
	 */
	void setGeneral(AQuantityKind value);

} // QuantityKind
