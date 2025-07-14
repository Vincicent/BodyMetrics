package org.verb.bodymetrics.di

import org.koin.core.module.Module
import org.koin.dsl.module
import org.verb.bodymetrics.measure.data.local.DatabaseDriverFactory

actual fun platformModule(): Module {
    return module {
        single {
            DatabaseDriverFactory().create()
        }
    }
}