package com.biosimilarity.lift.lib.kvdbJSON.Absyn; // Java Package generated by the BNF Converter.

public class KVDBPublishRsp extends TellRsp {

  public KVDBPublishRsp() { }

  public <R,A> R accept(com.biosimilarity.lift.lib.kvdbJSON.Absyn.TellRsp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.lift.lib.kvdbJSON.Absyn.KVDBPublishRsp) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}
