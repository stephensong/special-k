package com.biosimilarity.seleKt.model.ill.vm.illvm.Absyn; // Java Package generated by the BNF Converter.

public class MDUMP extends Dump {
  public final ListFrame listframe_;

  public MDUMP(ListFrame p1) { listframe_ = p1; }

  public <R,A> R accept(com.biosimilarity.seleKt.model.ill.vm.illvm.Absyn.Dump.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.seleKt.model.ill.vm.illvm.Absyn.MDUMP) {
      com.biosimilarity.seleKt.model.ill.vm.illvm.Absyn.MDUMP x = (com.biosimilarity.seleKt.model.ill.vm.illvm.Absyn.MDUMP)o;
      return this.listframe_.equals(x.listframe_);
    }
    return false;
  }

  public int hashCode() {
    return this.listframe_.hashCode();
  }


}