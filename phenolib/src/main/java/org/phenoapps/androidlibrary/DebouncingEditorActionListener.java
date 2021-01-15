package org.phenoapps.androidlibrary;

/**
 * When Ruban barcode scanners are in automatic mode and the user scans barcodes quickly the scanner
 * sometimes produces truncated/incorrect text.  This class decreases the occurrence of this problem
 * by building in a delay.
 *
 * Uses:
 * android.os.Handler
 * android.widget.EditText
 *
 * androidx.annotation.IntRange
 * androidx.annotation.NonNull
 * androidx.annotation.Nullable
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.androidlibrary.EditorActionListener
 */
public class DebouncingEditorActionListener
extends org.phenoapps.androidlibrary.EditorActionListener
{
    @java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
    private static class TextAccumulator extends java.lang.Object
    {
        @java.lang.SuppressWarnings({"UnnecessaryInterfaceModifier"}) private interface Logger
        { public void log(java.lang.String msg); }

        // region Fields
        @androidx.annotation.Nullable private final
            org.phenoapps.androidlibrary.DebouncingEditorActionListener.Receiver receiver   ;
                                                private final boolean                debug      ;
        @androidx.annotation.IntRange(from = 0) private final long                   delayMillis;
        @androidx.annotation.NonNull            private final
            org.phenoapps.androidlibrary.DebouncingEditorActionListener.TextAccumulator.Logger
            logger;

        private boolean accumulating = false;

        @java.lang.SuppressWarnings({"Convert2Diamond"}) private final java.util.ArrayList<
            java.lang.String> arrayList = new java.util.ArrayList<java.lang.String>();

        private final java.lang.Runnable runnable = new java.lang.Runnable()
            {
                @java.lang.Override public void run()
                {
                    org.phenoapps.androidlibrary.DebouncingEditorActionListener
                        .TextAccumulator.this.stop();
                }
            };
        private final android.os.Handler handler = new android.os.Handler();
        // endregion

        private void stop()
        {
            this.accumulating = false;

            if (this.debug)
            {
                final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                {
                    boolean firstText = true;
                    for (final java.lang.String text: this.arrayList)
                    {
                        if (firstText) firstText = false; else stringBuilder.append(", ");
                        stringBuilder.append(text);
                    }
                }
                this.logger.log(stringBuilder.toString());
            }

            if (null != this.receiver)
            {
                int longest;
                {
                    final int first = 0, last = this.arrayList.size() - 1;
                    @androidx.annotation.IntRange(from = 0) int maxLength = 0;

                    longest = first;
                    for (int i = first; i <= last; i++)
                    {
                        final int length = this.arrayList.get(i).length();
                        if (length > maxLength) { maxLength = length; longest = i; }
                    }
                }
                this.receiver.receiveText(this.arrayList.get(longest));
            }
        }

        private TextAccumulator(@androidx.annotation.Nullable
            final org.phenoapps.androidlibrary.DebouncingEditorActionListener.Receiver receiver,
        final boolean debug, @androidx.annotation.IntRange(from = 0) final long delayMillis,
        @androidx.annotation.NonNull final
            org.phenoapps.androidlibrary.DebouncingEditorActionListener.TextAccumulator.Logger
            logger)
        {
            super();

            this.receiver    = receiver   ; this.debug  = debug ;
            this.delayMillis = delayMillis; this.logger = logger;
        }

        private void accumulate(final java.lang.String text)
        {
            if (!this.accumulating)
            {
                this.arrayList.clear();
                this.accumulating = true;
                this.handler.postDelayed(this.runnable, /* delayMillis => */ this.delayMillis);
            }
            this.arrayList.add(text);
        }
    }

    private final org.phenoapps.androidlibrary.DebouncingEditorActionListener.TextAccumulator
        textAccumulator;

    public DebouncingEditorActionListener(
    @androidx.annotation.NonNull  final android.widget.EditText editText,
    @androidx.annotation.Nullable final
        org.phenoapps.androidlibrary.DebouncingEditorActionListener.Receiver receiver,
    final boolean debug, @androidx.annotation.IntRange(from = 0) final long delayMillis)
    {
        super(editText, receiver, debug);
        this.textAccumulator =
            new org.phenoapps.androidlibrary.DebouncingEditorActionListener.TextAccumulator(
                receiver, debug, delayMillis, new org.phenoapps.androidlibrary
                .DebouncingEditorActionListener.TextAccumulator.Logger()
                {
                    @java.lang.Override public void log(final java.lang.String msg)
                    { org.phenoapps.androidlibrary.DebouncingEditorActionListener.log(msg); }
                });
    }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override
    protected void sendText(final java.lang.String text) { this.textAccumulator.accumulate(text); }
}