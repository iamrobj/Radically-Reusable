package com.robj.radicallyreusable.base.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;

/**
 * Created by Rob J on 25/09/16.
 */
public class PermissionsUtil {

    public static boolean hasPermission(Context context, String permission) {
        if(VersionUtils.isMarshmallow())
            return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, permission);
        return true;
    }

    public static void showPermissionPopup(Fragment fragment, String permission, int request, int message,
                                           @StyleRes int styleResId, @StringRes int titleResId, @StringRes int acceptBtnResId, @StringRes int rejectBtnResId) {
        if(!ActivityCompat.shouldShowRequestPermissionRationale(fragment.getActivity(), permission)) {
            fragment.requestPermissions(new String[]{permission}, request);
            return;
        }
        showPermissionRationale(fragment, permission, request, message, styleResId, titleResId, acceptBtnResId, rejectBtnResId);
    }

    public static void showPermissionPopup(Fragment fragment, String permission, int request, String message,
                                           @StyleRes int styleResId, @StringRes int titleResId, @StringRes int acceptBtnResId, @StringRes int rejectBtnResId) {
        if(!ActivityCompat.shouldShowRequestPermissionRationale(fragment.getActivity(), permission)) {
            fragment.requestPermissions(new String[]{permission}, request);
            return;
        }
        showPermissionRationale(fragment, permission, request, message, styleResId, titleResId, acceptBtnResId, rejectBtnResId);
    }

    private static void showPermissionRationale(final Fragment fragment, final String permission, final int request, int message,
                                                @StyleRes int styleResId, @StringRes int titleResId, @StringRes int acceptBtnResId, @StringRes int rejectBtnResId) {
        showPermissionRationale(fragment, permission, request, fragment.getString(message), styleResId, titleResId, acceptBtnResId, rejectBtnResId);
    }

    private static void showPermissionRationale(final Fragment fragment, final String permission, final int request, String message,
                                                @StyleRes int styleResId, @StringRes int titleResId, @StringRes int acceptBtnResId, @StringRes int rejectBtnResId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getActivity(), styleResId);
        builder.setTitle(titleResId);
        builder.setMessage(message);
        builder.setPositiveButton(acceptBtnResId, (dialog, which) -> fragment.requestPermissions(new String[]{permission}, request));
        builder.setCancelable(false);
        builder.setNegativeButton(rejectBtnResId, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            fragment.onRequestPermissionsResult(request, new String[]{ permission }, new int[]{ PackageManager.PERMISSION_DENIED });
        });
        builder.show();
    }

}
