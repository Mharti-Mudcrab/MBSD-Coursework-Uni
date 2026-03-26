package LanguageModel;

import java.lang.IllegalStateException;

public class Requirement {

        protected String item;
        protected int amount;
        

        public Requirement(String item, int amount) {
            this.item = item;
            this.amount = amount;
        }

        public boolean isSatisfied(SystemState systemState) {
            int currentAmount = systemState.getItemAmount(item);
           
        }  
}
