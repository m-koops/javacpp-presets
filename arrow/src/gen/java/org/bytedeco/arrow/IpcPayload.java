// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Intermediate data structure with metadata header, and zero
 *  or more buffers for the message body. */
@Namespace("arrow::ipc") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class IpcPayload extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public IpcPayload() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IpcPayload(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IpcPayload(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public IpcPayload position(long position) {
        return (IpcPayload)super.position(position);
    }
    @Override public IpcPayload getPointer(long i) {
        return new IpcPayload((Pointer)this).offsetAddress(i);
    }

  public native MessageType type(); public native IpcPayload type(MessageType setter);
  public native @SharedPtr ArrowBuffer metadata(); public native IpcPayload metadata(ArrowBuffer setter);
  public native @ByRef BufferVector body_buffers(); public native IpcPayload body_buffers(BufferVector setter);
  public native @Cast("int64_t") long body_length(); public native IpcPayload body_length(long setter);
}
