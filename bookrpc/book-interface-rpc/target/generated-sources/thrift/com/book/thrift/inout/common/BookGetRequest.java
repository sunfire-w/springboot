/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.book.thrift.inout.common;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2019-12-27")
public class BookGetRequest implements org.apache.thrift.TBase<BookGetRequest, BookGetRequest._Fields>, java.io.Serializable, Cloneable, Comparable<BookGetRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BookGetRequest");

  private static final org.apache.thrift.protocol.TField BASE_REQ_FIELD_DESC = new org.apache.thrift.protocol.TField("baseReq", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField BOOK_MODEL_FIELD_DESC = new org.apache.thrift.protocol.TField("BookModel", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BookGetRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BookGetRequestTupleSchemeFactory());
  }

  /**
   * 基础返回参数
   */
  public com.book.thrift.inout.common.BaseRequest baseReq; // required
  /**
   *  
   */
  public BookEntity BookModel; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 基础返回参数
     */
    BASE_REQ((short)1, "baseReq"),
    /**
     *  
     */
    BOOK_MODEL((short)2, "BookModel");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // BASE_REQ
          return BASE_REQ;
        case 2: // BOOK_MODEL
          return BOOK_MODEL;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BASE_REQ, new org.apache.thrift.meta_data.FieldMetaData("baseReq", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.book.thrift.inout.common.BaseRequest.class)));
    tmpMap.put(_Fields.BOOK_MODEL, new org.apache.thrift.meta_data.FieldMetaData("BookModel", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BookEntity.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BookGetRequest.class, metaDataMap);
  }

  public BookGetRequest() {
  }

  public BookGetRequest(
    com.book.thrift.inout.common.BaseRequest baseReq,
    BookEntity BookModel)
  {
    this();
    this.baseReq = baseReq;
    this.BookModel = BookModel;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BookGetRequest(BookGetRequest other) {
    if (other.isSetBaseReq()) {
      this.baseReq = new com.book.thrift.inout.common.BaseRequest(other.baseReq);
    }
    if (other.isSetBookModel()) {
      this.BookModel = new BookEntity(other.BookModel);
    }
  }

  public BookGetRequest deepCopy() {
    return new BookGetRequest(this);
  }

  @Override
  public void clear() {
    this.baseReq = null;
    this.BookModel = null;
  }

  /**
   * 基础返回参数
   */
  public com.book.thrift.inout.common.BaseRequest getBaseReq() {
    return this.baseReq;
  }

  /**
   * 基础返回参数
   */
  public BookGetRequest setBaseReq(com.book.thrift.inout.common.BaseRequest baseReq) {
    this.baseReq = baseReq;
    return this;
  }

  public void unsetBaseReq() {
    this.baseReq = null;
  }

  /** Returns true if field baseReq is set (has been assigned a value) and false otherwise */
  public boolean isSetBaseReq() {
    return this.baseReq != null;
  }

  public void setBaseReqIsSet(boolean value) {
    if (!value) {
      this.baseReq = null;
    }
  }

  /**
   *  
   */
  public BookEntity getBookModel() {
    return this.BookModel;
  }

  /**
   *  
   */
  public BookGetRequest setBookModel(BookEntity BookModel) {
    this.BookModel = BookModel;
    return this;
  }

  public void unsetBookModel() {
    this.BookModel = null;
  }

  /** Returns true if field BookModel is set (has been assigned a value) and false otherwise */
  public boolean isSetBookModel() {
    return this.BookModel != null;
  }

  public void setBookModelIsSet(boolean value) {
    if (!value) {
      this.BookModel = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BASE_REQ:
      if (value == null) {
        unsetBaseReq();
      } else {
        setBaseReq((com.book.thrift.inout.common.BaseRequest)value);
      }
      break;

    case BOOK_MODEL:
      if (value == null) {
        unsetBookModel();
      } else {
        setBookModel((BookEntity)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BASE_REQ:
      return getBaseReq();

    case BOOK_MODEL:
      return getBookModel();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BASE_REQ:
      return isSetBaseReq();
    case BOOK_MODEL:
      return isSetBookModel();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BookGetRequest)
      return this.equals((BookGetRequest)that);
    return false;
  }

  public boolean equals(BookGetRequest that) {
    if (that == null)
      return false;

    boolean this_present_baseReq = true && this.isSetBaseReq();
    boolean that_present_baseReq = true && that.isSetBaseReq();
    if (this_present_baseReq || that_present_baseReq) {
      if (!(this_present_baseReq && that_present_baseReq))
        return false;
      if (!this.baseReq.equals(that.baseReq))
        return false;
    }

    boolean this_present_BookModel = true && this.isSetBookModel();
    boolean that_present_BookModel = true && that.isSetBookModel();
    if (this_present_BookModel || that_present_BookModel) {
      if (!(this_present_BookModel && that_present_BookModel))
        return false;
      if (!this.BookModel.equals(that.BookModel))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_baseReq = true && (isSetBaseReq());
    list.add(present_baseReq);
    if (present_baseReq)
      list.add(baseReq);

    boolean present_BookModel = true && (isSetBookModel());
    list.add(present_BookModel);
    if (present_BookModel)
      list.add(BookModel);

    return list.hashCode();
  }

  @Override
  public int compareTo(BookGetRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetBaseReq()).compareTo(other.isSetBaseReq());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBaseReq()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.baseReq, other.baseReq);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBookModel()).compareTo(other.isSetBookModel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBookModel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.BookModel, other.BookModel);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BookGetRequest(");
    boolean first = true;

    sb.append("baseReq:");
    if (this.baseReq == null) {
      sb.append("null");
    } else {
      sb.append(this.baseReq);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("BookModel:");
    if (this.BookModel == null) {
      sb.append("null");
    } else {
      sb.append(this.BookModel);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (baseReq != null) {
      baseReq.validate();
    }
    if (BookModel != null) {
      BookModel.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BookGetRequestStandardSchemeFactory implements SchemeFactory {
    public BookGetRequestStandardScheme getScheme() {
      return new BookGetRequestStandardScheme();
    }
  }

  private static class BookGetRequestStandardScheme extends StandardScheme<BookGetRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BookGetRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BASE_REQ
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.baseReq = new com.book.thrift.inout.common.BaseRequest();
              struct.baseReq.read(iprot);
              struct.setBaseReqIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BOOK_MODEL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.BookModel = new BookEntity();
              struct.BookModel.read(iprot);
              struct.setBookModelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BookGetRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.baseReq != null) {
        oprot.writeFieldBegin(BASE_REQ_FIELD_DESC);
        struct.baseReq.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.BookModel != null) {
        oprot.writeFieldBegin(BOOK_MODEL_FIELD_DESC);
        struct.BookModel.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BookGetRequestTupleSchemeFactory implements SchemeFactory {
    public BookGetRequestTupleScheme getScheme() {
      return new BookGetRequestTupleScheme();
    }
  }

  private static class BookGetRequestTupleScheme extends TupleScheme<BookGetRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BookGetRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetBaseReq()) {
        optionals.set(0);
      }
      if (struct.isSetBookModel()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetBaseReq()) {
        struct.baseReq.write(oprot);
      }
      if (struct.isSetBookModel()) {
        struct.BookModel.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BookGetRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.baseReq = new com.book.thrift.inout.common.BaseRequest();
        struct.baseReq.read(iprot);
        struct.setBaseReqIsSet(true);
      }
      if (incoming.get(1)) {
        struct.BookModel = new BookEntity();
        struct.BookModel.read(iprot);
        struct.setBookModelIsSet(true);
      }
    }
  }

}

