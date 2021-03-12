/*
 * Copyright <2021> Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */

package software.amazon.documentdb.jdbc.common.test;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.BsonDocument;

public interface DocumentDbTestEnvironment {

    /**
     * Starts the test environment and preforms any initialization.
     *
     * @return true, if the environment starts a new instance, otherwise false, if the
     * environment was already started.
     */
    boolean start() throws Exception;

    /**
     * Stops the test environment and cleans up any temporary collections.
     *
     * @return true, if the environment stops an instance, otherwise false, if the
     * environment was already stopped or could not be stopped.
     */
    boolean stop() throws Exception;

    /**
     * Creates a new collection name for the database.
     *
     * @param isTemporary an indicator of whether the collection is temporary. If true, then the
     *                   collection will be removed when the environment is stopped.
     * @return a new collection name.
     */
    String newCollectionName(final boolean isTemporary);

    /**
     * Gets the database name.
     * @return the database name.
     */
    String getDatabaseName();

    /**
     * Gets the JDBC connection string for this environment.
     *
     * @return the JDBC connection string.
     */
    String getJdbcConnectionString();

    /**
     * Creates a new {@link MongoClient} object with default username and password.
     *
     * @return a new {@link MongoClient} object.
     */
    MongoClient createMongoClient();

    /**
     * Prepares simple consistent data records for the given collections.
     * @param collection the collection to populate.
     * @param recordCount the number or records to add.
     */
    void prepareSimpleConsistentData(
            final MongoCollection<BsonDocument> collection,
            final int recordCount);
}
