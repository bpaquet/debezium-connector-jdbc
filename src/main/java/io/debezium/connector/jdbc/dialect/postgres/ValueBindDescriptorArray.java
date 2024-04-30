/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.jdbc.dialect.postgres;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import io.debezium.connector.jdbc.ValueBindDescriptor;

/**
 * ValueBindDescriptor which handles ARRAY column types.
 *
 * @author Bertrand Paquet
 */

public class ValueBindDescriptorArray extends ValueBindDescriptor {

    private String subType;

    public ValueBindDescriptorArray(int index, Object value) {
        super(index, value);
    }

    public ValueBindDescriptorArray(int index, Object value, Integer targetSqlType, String subType) {
        super(index, value, targetSqlType);
        this.subType = subType;
    }

    @Override
    public Array getArray(Connection connection) throws SQLException {
        Collection<Object> values = (Collection<Object>) getValue();
        return connection.createArrayOf(subType, values.toArray());
    }
}
