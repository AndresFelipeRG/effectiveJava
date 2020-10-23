package com.effectivejava.items.item3.builders;

import java.util.Objects;

public class NyPizza extends Pizza{
    
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;
   
    
    public static class Builder extends Pizza.Builder<Builder>{
        
        private final Size size; //not a default parameter therefore it's not initialized by a chained method in the builder
        
        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        Pizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    
    private NyPizza(Builder builder){
        super(builder);
        size = builder.size;
    }
}
