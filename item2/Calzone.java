package com.effectivejava.items.item3.builders;

public class Calzone extends Pizza{
    
    private final boolean sauceInside;
    
    public static class Builder extends Pizza.Builder<Builder>{
        
        private boolean sauceInside = false; //default value
        
        public Builder sauceInside(){
            sauceInside = true;
            return this;
        }

        @Override
        Pizza build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    
    private Calzone(Builder builder){
        super(builder);
        this.sauceInside = builder.sauceInside;
    }
}
