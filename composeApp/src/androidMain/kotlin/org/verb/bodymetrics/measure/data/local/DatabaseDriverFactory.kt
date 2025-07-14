package org.verb.bodymetrics.measure.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.verb.bodymetrics.database.BodyMetricsDatabase

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(BodyMetricsDatabase.Schema, context, "translate.db")
    }
}