package org.wheatgenetics.brapi1_3.studies.nour;

/**
 * Uses:
 * android.app.Activity
 * android.app.Application
 *
 * org.wheatgenetics.brapi1_3.Application
 *
 * org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest
 */
@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"}) class Utils extends java.lang.Object
{
    static void setNewObservationUnitRequestPosition(final android.app.Activity activity, final
    org.wheatgenetics.brapi1_3.studies.nour.NewObservationUnitRequest newObservationUnitRequest)
    {
        if (null != activity && null != newObservationUnitRequest)
        {
            final android.app.Application androidApplication = activity.getApplication();
            if (androidApplication instanceof org.wheatgenetics.brapi1_3.Application)
            {
                final org.wheatgenetics.brapi1_3.Application brapi1_3Application =
                    (org.wheatgenetics.brapi1_3.Application) androidApplication;
                brapi1_3Application.setNewObservationUnitRequestPosition(
                    newObservationUnitRequest.getPosition());
            }
        }
    }
}