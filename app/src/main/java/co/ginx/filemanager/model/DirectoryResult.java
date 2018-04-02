package co.ginx.filemanager.model;

import android.content.ContentProviderClient;
import android.database.Cursor;

import java.io.Closeable;

import co.ginx.filemanager.libcore.io.IoUtils;
import co.ginx.filemanager.misc.ContentProviderClientCompat;

import static co.ginx.filemanager.BaseActivity.State.MODE_UNKNOWN;
import static co.ginx.filemanager.BaseActivity.State.SORT_ORDER_UNKNOWN;

public class DirectoryResult implements Closeable {
	public ContentProviderClient client;
    public Cursor cursor;
    public Exception exception;

    public int mode = MODE_UNKNOWN;
    public int sortOrder = SORT_ORDER_UNKNOWN;

    @Override
    public void close() {
        IoUtils.closeQuietly(cursor);
        ContentProviderClientCompat.releaseQuietly(client);
        cursor = null;
        client = null;
    }
}