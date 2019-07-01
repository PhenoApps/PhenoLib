package org.wheatgenetics.brapi1_3.studies.nour;

/**
 * Uses:
 * android.app.Activity
 * android.app.Application
 *
 * org.wheatgenetics.brapi1_3.studies.Application
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"}) class Utils extends java.lang.Object
{
    static void setNewObservationUnitRequestPosition(final android.app.Activity activity, final
    org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest newObservationUnitRequest)
    {
        if (null != activity && null != newObservationUnitRequest)
        {
            final android.app.Application androidApplication = activity.getApplication();
            if (androidApplication instanceof org.wheatgenetics.brapi1_3.studies.Application)
            {
                final org.wheatgenetics.brapi1_3.studies.Application studiesApplication =
                    (org.wheatgenetics.brapi1_3.studies.Application) androidApplication;
                studiesApplication.setNewObservationUnitRequestPosition(
                    newObservationUnitRequest.getPosition());
            }
        }
    }
}