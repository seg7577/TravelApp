/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Using: out/host/linux-x86/bin/aidl --lang=java --structured --version 3 --hash 4f1c704008e5687ed0d6f1590464aed39fc7f64e -t --stability vintf --min_sdk_version platform_apis -pout/soong/.intermediates/hardware/interfaces/security/keymint/aidl/android.hardware.security.keymint_interface/3/preprocessed.aidl --ninja -d out/soong/.intermediates/system/hardware/interfaces/keystore2/aidl/android.system.keystore2-V3-java-source/gen/android/system/keystore2/KeyDescriptor.java.d -o out/soong/.intermediates/system/hardware/interfaces/keystore2/aidl/android.system.keystore2-V3-java-source/gen -Nsystem/hardware/interfaces/keystore2/aidl/aidl_api/android.system.keystore2/3 system/hardware/interfaces/keystore2/aidl/aidl_api/android.system.keystore2/3/android/system/keystore2/KeyDescriptor.aidl
 */
package android.system.keystore2;
/** @hide */
public class KeyDescriptor implements android.os.Parcelable
{
  public int domain = android.system.keystore2.Domain.APP;
  public long nspace = 0L;
  public java.lang.String alias;
  public byte[] blob;
  @Override
   public final int getStability() { return android.os.Parcelable.PARCELABLE_STABILITY_VINTF; }
  public static final android.os.Parcelable.Creator<KeyDescriptor> CREATOR = new android.os.Parcelable.Creator<KeyDescriptor>() {
    @Override
    public KeyDescriptor createFromParcel(android.os.Parcel _aidl_source) {
      KeyDescriptor _aidl_out = new KeyDescriptor();
      _aidl_out.readFromParcel(_aidl_source);
      return _aidl_out;
    }
    @Override
    public KeyDescriptor[] newArray(int _aidl_size) {
      return new KeyDescriptor[_aidl_size];
    }
  };
  @Override public final void writeToParcel(android.os.Parcel _aidl_parcel, int _aidl_flag)
  {
    int _aidl_start_pos = _aidl_parcel.dataPosition();
    _aidl_parcel.writeInt(0);
    _aidl_parcel.writeInt(domain);
    _aidl_parcel.writeLong(nspace);
    _aidl_parcel.writeString(alias);
    _aidl_parcel.writeByteArray(blob);
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
      domain = _aidl_parcel.readInt();
      if (_aidl_parcel.dataPosition() - _aidl_start_pos >= _aidl_parcelable_size) return;
      nspace = _aidl_parcel.readLong();
      if (_aidl_parcel.dataPosition() - _aidl_start_pos >= _aidl_parcelable_size) return;
      alias = _aidl_parcel.readString();
      if (_aidl_parcel.dataPosition() - _aidl_start_pos >= _aidl_parcelable_size) return;
      blob = _aidl_parcel.createByteArray();
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
    return _mask;
  }
}
