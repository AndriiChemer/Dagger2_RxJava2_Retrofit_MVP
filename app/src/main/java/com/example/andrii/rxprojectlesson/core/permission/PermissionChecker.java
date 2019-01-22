package com.example.andrii.rxprojectlesson.core.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import javax.inject.Inject;
import javax.inject.Named;

public class PermissionChecker {

    private static final int REQUEST_CODE = 10;
    private final Activity activity;
    private String permission;

    @Inject
    public PermissionChecker(Activity activity, @Named("Permission") String permission) {
        this.activity = activity;
        this.permission = permission;
    }

    public boolean nasPermission() {
        int permissionCheckResult = ContextCompat.checkSelfPermission(activity, permission);
        return permissionCheckResult == PackageManager.PERMISSION_GRANTED;
    }

    public void requestPermission() {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, REQUEST_CODE);
    }

    public boolean resultGranted(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CODE) {
            return false;
        }

        if (grantResults.length < 1) {
            return false;
        }

        if (!(permissions[0].equals(permission))) {
            return false;
        }

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            return false;
        }

        return false;
    }
}
