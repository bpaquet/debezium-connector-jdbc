/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.jdbc.junit.jupiter;

import org.testcontainers.utility.DockerImageName;

/**
 * An implementation of {@link AbstractSinkDatabaseContextProvider} for PostgreSQL.
 *
 * @author Chris Cranford
 */
public class Postgres15SinkDatabaseContextProvider extends PostgresSinkDatabaseContextProvider {

    public Postgres15SinkDatabaseContextProvider() {
        super(DockerImageName.parse("debezium/postgres:15-alpine")
                .asCompatibleSubstituteFor("postgres"));
    }
}
