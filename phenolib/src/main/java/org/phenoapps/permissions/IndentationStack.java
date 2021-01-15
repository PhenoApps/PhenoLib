package org.phenoapps.permissions;

@java.lang.SuppressWarnings({"ClassExplicitlyExtendsObject"})
class IndentationStack extends java.lang.Object
{
    @java.lang.SuppressWarnings({"Convert2Diamond"})
    private final java.util.ArrayList<java.lang.String> arrayList =
        new java.util.ArrayList<java.lang.String>();

    // region Package Methods
    void push(final java.lang.String name) { this.arrayList.add(name)                           ; }
    void pop()                             { this.arrayList.remove(this.arrayList.size() - 1); }

    java.lang.String label()
    {
        final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
        for (final java.lang.String name: this.arrayList) stringBuilder.append(name).append(": ");
        return stringBuilder.toString();
    }
    // endregion
}