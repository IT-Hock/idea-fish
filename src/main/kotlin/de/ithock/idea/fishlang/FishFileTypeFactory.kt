/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

/**
 * TODO: This class is only used with the `com.intellij.fileTypeFactory` extension point
 * for versions of the IntelliJ Platform prior to v2019.2.
 *
 * @see [Custom Language Tutorial](https://plugins.jetbrains.com/docs/intellij/language-and-filetype.html.register-the-filetype)
 */
class FishFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(FishFileType.Companion.INSTANCE)
    }
}