/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Using: out/host/linux-x86/bin/aidl --lang=java --structured --version 2 --hash c32ddfdeb69c6e4a8a45519e6f9a39c4b66fd99f --stability vintf --min_sdk_version current --ninja -d out/soong/.intermediates/hardware/interfaces/common/aidl/android.hardware.common-V2-java-source/gen/android/hardware/common/NativeHandle.java.d -o out/soong/.intermediates/hardware/interfaces/common/aidl/android.hardware.common-V2-java-source/gen -Nhardware/interfaces/common/aidl/aidl_api/android.hardware.common/2 hardware/interfaces/common/aidl/aidl_api/android.hardware.common/2/android/hardware/common/NativeHandle.aidl
 */
package android.hardware.common;
public class NativeHandle implements android.os.Parcelable
{
  public android.os.ParcelFileDescriptor[] fds;
  public int[] ints;
  @Override
   public final int getStability() { return android.os.Parcelable.PARCELABLE_STABILITY_VINTF; }
  public static final android.os.Parcelable.Creator<NativeHandle> CREATOR = new android.os.Parcelable.Creator<NativeHandle>() {
    @Override
    public NativeHandle createFromParcel(android.os.Parcel _aidl_source) {
      NativeHandle _aidl_out = new NativeHandle();
      _aidl_out.readFromParcel(_aidl_source);
      return _aidl_out;
    }
    @Override
    public NativeHandle[] newArray(int _aidl_size) {
      return new NativeHandle[_aidl_size];
    }
  };
  @Override public final void writeToParcel(android.os.Parcel _aidl_parcel, int _aidl_flag)
  {
    int _aidl_start_pos = _aidl_parcel.dataPosition();
    _aidl_parcel.writeInt(0);
    _aidl_parcel.writeTypedArray(fds, _aidl_flag);
    _aidl_parcel.writeIntArray(ints);
    int _aidl_end_pos = _aidl_parcel.dataPosition();
    _aidl_parcel.setDataPosition(_aidl_start_pos);
    _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
    _aidl_parcel.setDataPosition(_aidl_end_pos);
  }
  public final void readFromParcel(android.os.Parcel _aidl_parcel)
  {
    int _aidl_start_pos = _aidl_parcel.dataPosition();
    int _aidl_parcelable_size = _aidl_parcel.readInt();
    try {
      if (_aidl_parcelable_size < 4) throw new android.os.BadParcelableException("Parcelable too small");;
      if (_aidl_parcel.dataPosition() - _aidl_start_pos >= _aidl_parcelable_size) return;
      fds = _aidl_parcel.createTypedArray(android.os.ParcelFileDescriptor.CREATOR);
      if (_aidl_parcel.dataPosition() - _aidl_start_pos >= _aidl_parcelable_size) return;
      ints = _aidl_parcel.createIntArray();
    } finally {
      if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) {
        throw new android.os.BadParcelableException("Overflow in the size of parcelable");
      }
      _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
    }
  }
  @Override
  public int describeContents() {
    int _mask = 0;
    _mask |= describeContents(fds);
    return _mask;
  }
  private int describeContents(Object _v) {
    if (_v == null) return 0;
    if (_v instanceof Object[]) {
      int _mask = 0;
      for (Object o : (Object[]) _v) {
        _mask |= describeContents(o);
      }
      return _mask;
    }
    if (_v instanceof android.os.Parcelable) {
      return ((android.os.Parcelable) _v).describeContents();
    }
    return 0;
  }
}