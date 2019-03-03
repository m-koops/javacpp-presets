// Targeted by JavaCPP version 1.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.spinnaker.Spinnaker_C;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.spinnaker.global.Spinnaker_C.*;


/**
* Handle for image functionality. Created by calling
* spinCameraGetNextImage() or spinCameraGetNextImageEx(), which require
* a call to spinImageRelease() to remove from buffer, or
* spinImageCreateEmpty(), spinImageCreateEx(), or spinImageCreate(),
* which require a call to spinImageDestroy() to destroy.
*/
@Namespace @Name("void") @Opaque @Properties(inherit = org.bytedeco.spinnaker.presets.Spinnaker_C.class)
public class spinImage extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public spinImage() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public spinImage(Pointer p) { super(p); }
}