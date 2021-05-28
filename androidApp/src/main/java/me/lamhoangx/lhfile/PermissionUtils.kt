package me.lamhoangx.lhfile

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionUtils {
    companion object {

        val STORAGE_PERMISSIONS = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        @JvmStatic
        fun checkPermissionIsGranted(
            context: Context,
            permissions: Array<String>
        ): Boolean {
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(context, permission)
                    != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
            return true
        }

        @JvmStatic
        fun verifyPermissionAndRequestIfNecessary(
            activity: Activity,
            permission: String,
            requestCode: Int = 1
        ): Boolean {
            if (ContextCompat.checkSelfPermission(activity, permission)
                != PackageManager.PERMISSION_GRANTED
            ) {
                val permissions = arrayOf(permission)
                ActivityCompat.requestPermissions(activity, permissions, requestCode)
                return false
            }
            return true
        }

        @JvmStatic
        fun verifyPermissionAndRequestIfNecessary(
            activity: Activity,
            permissions: Array<String>,
            requestCode: Int = 1
        ): Boolean {
            var locationPer = false
            val listPermissionsNeeded = ArrayList<String>()
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(activity, permission)
                    != PackageManager.PERMISSION_GRANTED
                ) {
                    listPermissionsNeeded.add(permission)
                }
            }

            ActivityCompat.requestPermissions(
                activity,
                listPermissionsNeeded.toTypedArray(),
                requestCode
            )

            return true
        }

        @JvmStatic
        fun rationalRequestStoragePermission(activity: Activity): Boolean {
            if (!checkPermissionIsGranted(
                    activity,
                    STORAGE_PERMISSIONS
                )
            ) {

                verifyPermissionAndRequestIfNecessary(
                    activity,
                    STORAGE_PERMISSIONS,
                    1
                )
                return true
            }
            return false
        }
    }
}