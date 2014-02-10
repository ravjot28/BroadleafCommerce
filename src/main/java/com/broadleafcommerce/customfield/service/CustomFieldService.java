/*
 * #%L
 * BroadleafCommerce Custom Field
 * %%
 * Copyright (C) 2009 - 2014 Broadleaf Commerce
 * %%
 * NOTICE:  All information contained herein is, and remains
 * the property of Broadleaf Commerce, LLC
 * The intellectual and technical concepts contained
 * herein are proprietary to Broadleaf Commerce, LLC
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Broadleaf Commerce, LLC.
 * #L%
 */

package com.broadleafcommerce.customfield.service;

import com.broadleafcommerce.customfield.domain.CustomField;

import java.util.List;

/**
 * @author Jeff Fischer
 */
public interface CustomFieldService {
    CustomField findById(Long id);

    List<CustomField> findByTargetEntityName(String targetEntityName);
}