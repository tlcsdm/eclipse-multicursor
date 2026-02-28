package com.tlcsdm.eclipse.multicursor.common;

import java.lang.reflect.Method;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.AbstractTextEditor;

/**
 * Uses hacky reflection techniques to find the source viewer for a given thing.
 * <a href="https://github.com/caspark/eclipse-multicursor"> Copied from
 * caspark</a>
 */
public class ISourceViewerFinder {

	private ISourceViewerFinder() {
	}

	public static ISourceViewer fromEditorPart(IEditorPart editorPart) {
		Object activeEditor = editorPart;
		if (editorPart instanceof MultiPageEditorPart multiPageEditorPart) {
			activeEditor = multiPageEditorPart.getSelectedPage();
		}
		if (activeEditor instanceof AbstractTextEditor textEditor) {
			return fromAbstractTextEditor(textEditor);
		} else {
			return null;
		}
	}

	/**
	 * Relies on protected final method
	 * {@link AbstractTextEditor#getSourceViewer()}.
	 */
	private static ISourceViewer fromAbstractTextEditor(AbstractTextEditor editor) {
		try {
			Method getSourceViewerMethod = null;
			Class<?> clazz = editor.getClass();
			while (clazz != null && getSourceViewerMethod == null) {
				if (clazz.equals(AbstractTextEditor.class)) {
					getSourceViewerMethod = clazz.getDeclaredMethod("getSourceViewer");
				} else {
					clazz = clazz.getSuperclass();
				}
			}
			if (getSourceViewerMethod == null) {
				throw new NoSuchMethodException("getSourceViewer method not found in class hierarchy");
			}
			getSourceViewerMethod.setAccessible(true);
			return (ISourceViewer) getSourceViewerMethod.invoke(editor);
		} catch (Exception e) {
			return null;
		}
	}

}
