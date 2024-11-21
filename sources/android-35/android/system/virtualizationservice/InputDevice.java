/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Using: out/host/linux-x86/bin/aidl --lang=java -Weverything -Wno-missing-permission-annotation --min_sdk_version current -pout/soong/.intermediates/packages/modules/Virtualization/virtualizationservice/aidl/android.system.virtualizationcommon_interface/preprocessed.aidl --ninja -d out/soong/.intermediates/packages/modules/Virtualization/virtualizationservice/aidl/android.system.virtualizationservice-java-source/gen/android/system/virtualizationservice/InputDevice.java.d -o out/soong/.intermediates/packages/modules/Virtualization/virtualizationservice/aidl/android.system.virtualizationservice-java-source/gen -Npackages/modules/Virtualization/virtualizationservice/aidl packages/modules/Virtualization/virtualizationservice/aidl/android/system/virtualizationservice/InputDevice.aidl
 */
package android.system.virtualizationservice;
// Refer to https://crosvm.dev/book/devices/input.html
public final class InputDevice implements android.os.Parcelable {
  // tags for union fields
  public final static int singleTouch = 0;  // android.system.virtualizationservice.InputDevice.SingleTouch singleTouch;
  public final static int evDev = 1;  // android.system.virtualizationservice.InputDevice.EvDev evDev;
  public final static int keyboard = 2;  // android.system.virtualizationservice.InputDevice.Keyboard keyboard;

  private int _tag;
  private Object _value;

  public InputDevice() {
    android.system.virtualizationservice.InputDevice.SingleTouch _value = null;
    this._tag = singleTouch;
    this._value = _value;
  }

  private InputDevice(android.os.Parcel _aidl_parcel) {
    readFromParcel(_aidl_parcel);
  }

  private InputDevice(int _tag, Object _value) {
    this._tag = _tag;
    this._value = _value;
  }

  public int getTag() {
    return _tag;
  }

  // android.system.virtualizationservice.InputDevice.SingleTouch singleTouch;

  public static InputDevice singleTouch(android.system.virtualizationservice.InputDevice.SingleTouch _value) {
    return new InputDevice(singleTouch, _value);
  }

  public android.system.virtualizationservice.InputDevice.SingleTouch getSingleTouch() {
    _assertTag(singleTouch);
    return (android.system.virtualizationservice.InputDevice.SingleTouch) _value;
  }

  public void setSingleTouch(android.system.virtualizationservice.InputDevice.SingleTouch _value) {
    _set(singleTouch, _value);
  }

  // android.system.virtualizationservice.InputDevice.EvDev evDev;

  public static InputDevice evDev(android.system.virtualizationservice.InputDevice.EvDev _value) {
    return new InputDevice(evDev, _value);
  }

  public android.system.virtualizationservice.InputDevice.EvDev getEvDev() {
    _assertTag(evDev);
    return (android.system.virtualizationservice.InputDevice.EvDev) _value;
  }

  public void setEvDev(android.system.virtualizationservice.InputDevice.EvDev _value) {
    _set(evDev, _value);
  }

  // android.system.virtualizationservice.InputDevice.Keyboard keyboard;

  public static InputDevice keyboard(android.system.virtualizationservice.InputDevice.Keyboard _value) {
    return new InputDevice(keyboard, _value);
  }

  public android.system.virtualizationservice.InputDevice.Keyboard getKeyboard() {
    _assertTag(keyboard);
    return (android.system.virtualizationservice.InputDevice.Keyboard) _value;
  }

  public void setKeyboard(android.system.virtualizationservice.InputDevice.Keyboard _value) {
    _set(keyboard, _value);
  }

  public static final android.os.Parcelable.Creator<InputDevice> CREATOR = new android.os.Parcelable.Creator<InputDevice>() {
    @Override
    public InputDevice createFromParcel(android.os.Parcel _aidl_source) {
      return new InputDevice(_aidl_source);
    }
    @Override
    public InputDevice[] newArray(int _aidl_size) {
      return new InputDevice[_aidl_size];
    }
  };

  @Override
  public final void writeToParcel(android.os.Parcel _aidl_parcel, int _aidl_flag) {
    _aidl_parcel.writeInt(_tag);
    switch (_tag) {
    case singleTouch:
      _aidl_parcel.writeTypedObject(getSingleTouch(), _aidl_flag);
      break;
    case evDev:
      _aidl_parcel.writeTypedObject(getEvDev(), _aidl_flag);
      break;
    case keyboard:
      _aidl_parcel.writeTypedObject(getKeyboard(), _aidl_flag);
      break;
    }
  }

  public void readFromParcel(android.os.Parcel _aidl_parcel) {
    int _aidl_tag;
    _aidl_tag = _aidl_parcel.readInt();
    switch (_aidl_tag) {
    case singleTouch: {
      android.system.virtualizationservice.InputDevice.SingleTouch _aidl_value;
      _aidl_value = _aidl_parcel.readTypedObject(android.system.virtualizationservice.InputDevice.SingleTouch.CREATOR);
      _set(_aidl_tag, _aidl_value);
      return; }
    case evDev: {
      android.system.virtualizationservice.InputDevice.EvDev _aidl_value;
      _aidl_value = _aidl_parcel.readTypedObject(android.system.virtualizationservice.InputDevice.EvDev.CREATOR);
      _set(_aidl_tag, _aidl_value);
      return; }
    case keyboard: {
      android.system.virtualizationservice.InputDevice.Keyboard _aidl_value;
      _aidl_value = _aidl_parcel.readTypedObject(android.system.virtualizationservice.InputDevice.Keyboard.CREATOR);
      _set(_aidl_tag, _aidl_value);
      return; }
    }
    throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
  }

  @Override
  public int describeContents() {
    int _mask = 0;
    switch (getTag()) {
    case singleTouch:
      _mask |= describeContents(getSingleTouch());
      break;
    case evDev:
      _mask |= describeContents(getEvDev());
      break;
    case keyboard:
      _mask |= describeContents(getKeyboard());
      break;
    }
    return _mask;
  }
  private int describeContents(Object _v) {
    if (_v == null) return 0;
    if (_v instanceof android.os.Parcelable) {
      return ((android.os.Parcelable) _v).describeContents();
    }
    return 0;
  }

  private void _assertTag(int tag) {
    if (getTag() != tag) {
      throw new IllegalStateException("bad access: " + _tagString(tag) + ", " + _tagString(getTag()) + " is available.");
    }
  }

  private String _tagString(int _tag) {
    switch (_tag) {
    case singleTouch: return "singleTouch";
    case evDev: return "evDev";
    case keyboard: return "keyboard";
    }
    throw new IllegalStateException("unknown field: " + _tag);
  }

  private void _set(int _tag, Object _value) {
    this._tag = _tag;
    this._value = _value;
  }
  // Add a single-touch touchscreen virtio-input device.
  public static class SingleTouch implements android.os.Parcelable
  {
    public android.os.ParcelFileDescriptor pfd;
    // Default values come from https://crosvm.dev/book/devices/input.html#single-touch
    public int width = 1280;
    public int height = 1080;
    public java.lang.String name = "";
    public static final android.os.Parcelable.Creator<SingleTouch> CREATOR = new android.os.Parcelable.Creator<SingleTouch>() {
      @Override
      public SingleTouch createFromParcel(android.os.Parcel _aidl_source) {
        SingleTouch _aidl_out = new SingleTouch();
        _aidl_out.readFromParcel(_aidl_source);
        return _aidl_out;
      }
      @Override
      public SingleTouch[] newArray(int _aidl_size) {
        return new SingleTouch[_aidl_size];
      }
    };
    @Override public final void writeToParcel(android.os.Parcel _aidl_parcel, int _aidl_flag)
    {
      int _aidl_start_pos = _aidl_parcel.dataPosition();
      _aidl_parcel.writeInt(0);
      _aidl_parcel.writeTypedObject(pfd, _aidl_flag);
      _aidl_parcel.writeInt(width);
      _aidl_parcel.writeInt(height);
      _aidl_parcel.writeString(name);
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
        pfd = _aidl_parcel.readTypedObject(android.os.ParcelFileDescriptor.CREATOR);
        if (_aidl_parcel.dataPosition() - _aidl_start_pos >= _aidl_parcelable_size) return;
        width = _aidl_parcel.readInt();
        if (_aidl_parcel.dataPosition() - _aidl_start_pos >= _aidl_parcelable_size) return;
        height = _aidl_parcel.readInt();
        if (_aidl_parcel.dataPosition() - _aidl_start_pos >= _aidl_parcelable_size) return;
        name = _aidl_parcel.readString();
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
      _mask |= describeContents(pfd);
      return _mask;
    }
    private int describeContents(Object _v) {
      if (_v == null) return 0;
      if (_v instanceof android.os.Parcelable) {
        return ((android.os.Parcelable) _v).describeContents();
      }
      return 0;
    }
  }
  // Passes an event device node into the VM. The device will be grabbed (unusable from the host)
  // and made available to the guest with the same configuration it shows on the host.
  public static class EvDev implements android.os.Parcelable
  {
    public android.os.ParcelFileDescriptor pfd;
    public static final android.os.Parcelable.Creator<EvDev> CREATOR = new android.os.Parcelable.Creator<EvDev>() {
      @Override
      public EvDev createFromParcel(android.os.Parcel _aidl_source) {
        EvDev _aidl_out = new EvDev();
        _aidl_out.readFromParcel(_aidl_source);
        return _aidl_out;
      }
      @Override
      public EvDev[] newArray(int _aidl_size) {
        return new EvDev[_aidl_size];
      }
    };
    @Override public final void writeToParcel(android.os.Parcel _aidl_parcel, int _aidl_flag)
    {
      int _aidl_start_pos = _aidl_parcel.dataPosition();
      _aidl_parcel.writeInt(0);
      _aidl_parcel.writeTypedObject(pfd, _aidl_flag);
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
        pfd = _aidl_parcel.readTypedObject(android.os.ParcelFileDescriptor.CREATOR);
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
      _mask |= describeContents(pfd);
      return _mask;
    }
    private int describeContents(Object _v) {
      if (_v == null) return 0;
      if (_v instanceof android.os.Parcelable) {
        return ((android.os.Parcelable) _v).describeContents();
      }
      return 0;
    }
  }
  // Keyboard input
  public static class Keyboard implements android.os.Parcelable
  {
    public android.os.ParcelFileDescriptor pfd;
    public static final android.os.Parcelable.Creator<Keyboard> CREATOR = new android.os.Parcelable.Creator<Keyboard>() {
      @Override
      public Keyboard createFromParcel(android.os.Parcel _aidl_source) {
        Keyboard _aidl_out = new Keyboard();
        _aidl_out.readFromParcel(_aidl_source);
        return _aidl_out;
      }
      @Override
      public Keyboard[] newArray(int _aidl_size) {
        return new Keyboard[_aidl_size];
      }
    };
    @Override public final void writeToParcel(android.os.Parcel _aidl_parcel, int _aidl_flag)
    {
      int _aidl_start_pos = _aidl_parcel.dataPosition();
      _aidl_parcel.writeInt(0);
      _aidl_parcel.writeTypedObject(pfd, _aidl_flag);
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
        pfd = _aidl_parcel.readTypedObject(android.os.ParcelFileDescriptor.CREATOR);
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
      _mask |= describeContents(pfd);
      return _mask;
    }
    private int describeContents(Object _v) {
      if (_v == null) return 0;
      if (_v instanceof android.os.Parcelable) {
        return ((android.os.Parcelable) _v).describeContents();
      }
      return 0;
    }
  }
  public static @interface Tag {
    public static final int singleTouch = 0;
    public static final int evDev = 1;
    public static final int keyboard = 2;
  }
}