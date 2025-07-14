package org.verb.bodymetrics.measure.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.verb.bodymetrics.database.BodyMetricsDatabase

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(BodyMetricsDatabase.Schema, "translate.db")
    }
}