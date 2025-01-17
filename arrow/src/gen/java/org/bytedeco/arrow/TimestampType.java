// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Concrete type class for datetime data (as number of seconds, milliseconds,
 *  microseconds or nanoseconds since UNIX epoch)
 * 
 *  If supplied, the timezone string should take either the form (i) "Area/Location",
 *  with values drawn from the names in the IANA Time Zone Database (such as
 *  "Europe/Zurich"); or (ii) "(+|-)HH:MM" indicating an absolute offset from GMT
 *  (such as "-08:00").  To indicate a native UTC timestamp, one of the strings "UTC",
 *  "Etc/UTC" or "+00:00" should be used.
 * 
 *  If any non-empty string is supplied as the timezone for a TimestampType, then the
 *  Arrow field containing that timestamp type (and by extension the column associated
 *  with such a field) is considered "timezone-aware".  The integer arrays that comprise
 *  a timezone-aware column must contain UTC normalized datetime values, regardless of
 *  the contents of their timezone string.  More precisely, (i) the producer of a
 *  timezone-aware column must populate its constituent arrays with valid UTC values
 *  (performing offset conversions from non-UTC values if necessary); and (ii) the
 *  consumer of a timezone-aware column may assume that the column's values are directly
 *  comparable (that is, with no offset adjustment required) to the values of any other
 *  timezone-aware column or to any other valid UTC datetime value (provided all values
 *  are expressed in the same units).
 * 
 *  If a TimestampType is constructed without a timezone (or, equivalently, if the
 *  timezone supplied is an empty string) then the resulting Arrow field (column) is
 *  considered "timezone-naive".  The producer of a timezone-naive column may populate
 *  its constituent integer arrays with datetime values from any timezone; the consumer
 *  of a timezone-naive column should make no assumptions about the interoperability or
 *  comparability of the values of such a column with those of any other timestamp
 *  column or datetime value.
 * 
 *  If a timezone-aware field contains a recognized timezone, its values may be
 *  localized to that locale upon display; the values of timezone-naive fields must
 *  always be displayed "as is", with no localization performed on them. */
@Namespace("arrow") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class TimestampType extends TemporalType {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TimestampType(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TimestampType(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public TimestampType position(long position) {
        return (TimestampType)super.position(position);
    }
    @Override public TimestampType getPointer(long i) {
        return new TimestampType((Pointer)this).offsetAddress(i);
    }
    public ParametricType asParametricType() { return asParametricType(this); }
    @Namespace public static native @Name("static_cast<arrow::ParametricType*>") ParametricType asParametricType(TimestampType pointer);


  @MemberGetter public static native @Cast("const arrow::Type::type") int type_id();
  public static final int type_id = type_id();

  public static native String type_name();

  public native int bit_width();

  public TimestampType(TimeUnit.type unit/*=arrow::TimeUnit::MILLI*/) { super((Pointer)null); allocate(unit); }
  private native void allocate(TimeUnit.type unit/*=arrow::TimeUnit::MILLI*/);
  public TimestampType() { super((Pointer)null); allocate(); }
  private native void allocate();
  public TimestampType(@Cast("arrow::TimeUnit::type") int unit/*=arrow::TimeUnit::MILLI*/) { super((Pointer)null); allocate(unit); }
  private native void allocate(@Cast("arrow::TimeUnit::type") int unit/*=arrow::TimeUnit::MILLI*/);

  public TimestampType(TimeUnit.type unit, @StdString String timezone) { super((Pointer)null); allocate(unit, timezone); }
  private native void allocate(TimeUnit.type unit, @StdString String timezone);
  public TimestampType(@Cast("arrow::TimeUnit::type") int unit, @StdString BytePointer timezone) { super((Pointer)null); allocate(unit, timezone); }
  private native void allocate(@Cast("arrow::TimeUnit::type") int unit, @StdString BytePointer timezone);

  public native @StdString String ToString();
  public native @StdString String name();

  public native TimeUnit.type unit();
  public native @StdString String timezone();
}
