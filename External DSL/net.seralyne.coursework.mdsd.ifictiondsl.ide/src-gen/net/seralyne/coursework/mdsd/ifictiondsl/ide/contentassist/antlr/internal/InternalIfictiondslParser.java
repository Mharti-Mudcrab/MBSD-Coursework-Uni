package net.seralyne.coursework.mdsd.ifictiondsl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import net.seralyne.coursework.mdsd.ifictiondsl.services.IfictiondslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIfictiondslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+='", "'-='", "'Story'", "'ChoiceNode'", "'{'", "'choices'", "':'", "'['", "']'", "'}'", "','", "'ChoiceOption'", "'displayText'", "'->'", "'with'", "'priority'", "'condition'", "'StartNode'", "'DialogueNode'", "'or'", "'and'", "'('", "')'", "'SystemStateChangeNode'", "'EndNode'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalIfictiondslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIfictiondslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIfictiondslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalIfictiondsl.g"; }


    	private IfictiondslGrammarAccess grammarAccess;

    	public void setGrammarAccess(IfictiondslGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleStory"
    // InternalIfictiondsl.g:53:1: entryRuleStory : ruleStory EOF ;
    public final void entryRuleStory() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:54:1: ( ruleStory EOF )
            // InternalIfictiondsl.g:55:1: ruleStory EOF
            {
             before(grammarAccess.getStoryRule()); 
            pushFollow(FOLLOW_1);
            ruleStory();

            state._fsp--;

             after(grammarAccess.getStoryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStory"


    // $ANTLR start "ruleStory"
    // InternalIfictiondsl.g:62:1: ruleStory : ( ( rule__Story__Group__0 ) ) ;
    public final void ruleStory() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:66:2: ( ( ( rule__Story__Group__0 ) ) )
            // InternalIfictiondsl.g:67:2: ( ( rule__Story__Group__0 ) )
            {
            // InternalIfictiondsl.g:67:2: ( ( rule__Story__Group__0 ) )
            // InternalIfictiondsl.g:68:3: ( rule__Story__Group__0 )
            {
             before(grammarAccess.getStoryAccess().getGroup()); 
            // InternalIfictiondsl.g:69:3: ( rule__Story__Group__0 )
            // InternalIfictiondsl.g:69:4: rule__Story__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Story__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStory"


    // $ANTLR start "entryRuleNode"
    // InternalIfictiondsl.g:78:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:79:1: ( ruleNode EOF )
            // InternalIfictiondsl.g:80:1: ruleNode EOF
            {
             before(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getNodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalIfictiondsl.g:87:1: ruleNode : ( ( rule__Node__Alternatives ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:91:2: ( ( ( rule__Node__Alternatives ) ) )
            // InternalIfictiondsl.g:92:2: ( ( rule__Node__Alternatives ) )
            {
            // InternalIfictiondsl.g:92:2: ( ( rule__Node__Alternatives ) )
            // InternalIfictiondsl.g:93:3: ( rule__Node__Alternatives )
            {
             before(grammarAccess.getNodeAccess().getAlternatives()); 
            // InternalIfictiondsl.g:94:3: ( rule__Node__Alternatives )
            // InternalIfictiondsl.g:94:4: rule__Node__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Node__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleChoiceNode"
    // InternalIfictiondsl.g:103:1: entryRuleChoiceNode : ruleChoiceNode EOF ;
    public final void entryRuleChoiceNode() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:104:1: ( ruleChoiceNode EOF )
            // InternalIfictiondsl.g:105:1: ruleChoiceNode EOF
            {
             before(grammarAccess.getChoiceNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleChoiceNode();

            state._fsp--;

             after(grammarAccess.getChoiceNodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleChoiceNode"


    // $ANTLR start "ruleChoiceNode"
    // InternalIfictiondsl.g:112:1: ruleChoiceNode : ( ( rule__ChoiceNode__Group__0 ) ) ;
    public final void ruleChoiceNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:116:2: ( ( ( rule__ChoiceNode__Group__0 ) ) )
            // InternalIfictiondsl.g:117:2: ( ( rule__ChoiceNode__Group__0 ) )
            {
            // InternalIfictiondsl.g:117:2: ( ( rule__ChoiceNode__Group__0 ) )
            // InternalIfictiondsl.g:118:3: ( rule__ChoiceNode__Group__0 )
            {
             before(grammarAccess.getChoiceNodeAccess().getGroup()); 
            // InternalIfictiondsl.g:119:3: ( rule__ChoiceNode__Group__0 )
            // InternalIfictiondsl.g:119:4: rule__ChoiceNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChoiceNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChoiceNode"


    // $ANTLR start "entryRuleChoiceOption"
    // InternalIfictiondsl.g:128:1: entryRuleChoiceOption : ruleChoiceOption EOF ;
    public final void entryRuleChoiceOption() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:129:1: ( ruleChoiceOption EOF )
            // InternalIfictiondsl.g:130:1: ruleChoiceOption EOF
            {
             before(grammarAccess.getChoiceOptionRule()); 
            pushFollow(FOLLOW_1);
            ruleChoiceOption();

            state._fsp--;

             after(grammarAccess.getChoiceOptionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleChoiceOption"


    // $ANTLR start "ruleChoiceOption"
    // InternalIfictiondsl.g:137:1: ruleChoiceOption : ( ( rule__ChoiceOption__Group__0 ) ) ;
    public final void ruleChoiceOption() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:141:2: ( ( ( rule__ChoiceOption__Group__0 ) ) )
            // InternalIfictiondsl.g:142:2: ( ( rule__ChoiceOption__Group__0 ) )
            {
            // InternalIfictiondsl.g:142:2: ( ( rule__ChoiceOption__Group__0 ) )
            // InternalIfictiondsl.g:143:3: ( rule__ChoiceOption__Group__0 )
            {
             before(grammarAccess.getChoiceOptionAccess().getGroup()); 
            // InternalIfictiondsl.g:144:3: ( rule__ChoiceOption__Group__0 )
            // InternalIfictiondsl.g:144:4: rule__ChoiceOption__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChoiceOptionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChoiceOption"


    // $ANTLR start "entryRuleTransition"
    // InternalIfictiondsl.g:153:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:154:1: ( ruleTransition EOF )
            // InternalIfictiondsl.g:155:1: ruleTransition EOF
            {
             before(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getTransitionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalIfictiondsl.g:162:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:166:2: ( ( ( rule__Transition__Group__0 ) ) )
            // InternalIfictiondsl.g:167:2: ( ( rule__Transition__Group__0 ) )
            {
            // InternalIfictiondsl.g:167:2: ( ( rule__Transition__Group__0 ) )
            // InternalIfictiondsl.g:168:3: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // InternalIfictiondsl.g:169:3: ( rule__Transition__Group__0 )
            // InternalIfictiondsl.g:169:4: rule__Transition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleStartNode"
    // InternalIfictiondsl.g:178:1: entryRuleStartNode : ruleStartNode EOF ;
    public final void entryRuleStartNode() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:179:1: ( ruleStartNode EOF )
            // InternalIfictiondsl.g:180:1: ruleStartNode EOF
            {
             before(grammarAccess.getStartNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleStartNode();

            state._fsp--;

             after(grammarAccess.getStartNodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStartNode"


    // $ANTLR start "ruleStartNode"
    // InternalIfictiondsl.g:187:1: ruleStartNode : ( ( rule__StartNode__Group__0 ) ) ;
    public final void ruleStartNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:191:2: ( ( ( rule__StartNode__Group__0 ) ) )
            // InternalIfictiondsl.g:192:2: ( ( rule__StartNode__Group__0 ) )
            {
            // InternalIfictiondsl.g:192:2: ( ( rule__StartNode__Group__0 ) )
            // InternalIfictiondsl.g:193:3: ( rule__StartNode__Group__0 )
            {
             before(grammarAccess.getStartNodeAccess().getGroup()); 
            // InternalIfictiondsl.g:194:3: ( rule__StartNode__Group__0 )
            // InternalIfictiondsl.g:194:4: rule__StartNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StartNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStartNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStartNode"


    // $ANTLR start "entryRuleDialogueNode"
    // InternalIfictiondsl.g:203:1: entryRuleDialogueNode : ruleDialogueNode EOF ;
    public final void entryRuleDialogueNode() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:204:1: ( ruleDialogueNode EOF )
            // InternalIfictiondsl.g:205:1: ruleDialogueNode EOF
            {
             before(grammarAccess.getDialogueNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleDialogueNode();

            state._fsp--;

             after(grammarAccess.getDialogueNodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDialogueNode"


    // $ANTLR start "ruleDialogueNode"
    // InternalIfictiondsl.g:212:1: ruleDialogueNode : ( ( rule__DialogueNode__Group__0 ) ) ;
    public final void ruleDialogueNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:216:2: ( ( ( rule__DialogueNode__Group__0 ) ) )
            // InternalIfictiondsl.g:217:2: ( ( rule__DialogueNode__Group__0 ) )
            {
            // InternalIfictiondsl.g:217:2: ( ( rule__DialogueNode__Group__0 ) )
            // InternalIfictiondsl.g:218:3: ( rule__DialogueNode__Group__0 )
            {
             before(grammarAccess.getDialogueNodeAccess().getGroup()); 
            // InternalIfictiondsl.g:219:3: ( rule__DialogueNode__Group__0 )
            // InternalIfictiondsl.g:219:4: rule__DialogueNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DialogueNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDialogueNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDialogueNode"


    // $ANTLR start "entryRuleCondition"
    // InternalIfictiondsl.g:228:1: entryRuleCondition : ruleCondition EOF ;
    public final void entryRuleCondition() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:229:1: ( ruleCondition EOF )
            // InternalIfictiondsl.g:230:1: ruleCondition EOF
            {
             before(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalIfictiondsl.g:237:1: ruleCondition : ( ruleOrCondition ) ;
    public final void ruleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:241:2: ( ( ruleOrCondition ) )
            // InternalIfictiondsl.g:242:2: ( ruleOrCondition )
            {
            // InternalIfictiondsl.g:242:2: ( ruleOrCondition )
            // InternalIfictiondsl.g:243:3: ruleOrCondition
            {
             before(grammarAccess.getConditionAccess().getOrConditionParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleOrCondition();

            state._fsp--;

             after(grammarAccess.getConditionAccess().getOrConditionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleOrCondition"
    // InternalIfictiondsl.g:253:1: entryRuleOrCondition : ruleOrCondition EOF ;
    public final void entryRuleOrCondition() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:254:1: ( ruleOrCondition EOF )
            // InternalIfictiondsl.g:255:1: ruleOrCondition EOF
            {
             before(grammarAccess.getOrConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleOrCondition();

            state._fsp--;

             after(grammarAccess.getOrConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrCondition"


    // $ANTLR start "ruleOrCondition"
    // InternalIfictiondsl.g:262:1: ruleOrCondition : ( ( rule__OrCondition__Group__0 ) ) ;
    public final void ruleOrCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:266:2: ( ( ( rule__OrCondition__Group__0 ) ) )
            // InternalIfictiondsl.g:267:2: ( ( rule__OrCondition__Group__0 ) )
            {
            // InternalIfictiondsl.g:267:2: ( ( rule__OrCondition__Group__0 ) )
            // InternalIfictiondsl.g:268:3: ( rule__OrCondition__Group__0 )
            {
             before(grammarAccess.getOrConditionAccess().getGroup()); 
            // InternalIfictiondsl.g:269:3: ( rule__OrCondition__Group__0 )
            // InternalIfictiondsl.g:269:4: rule__OrCondition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrCondition"


    // $ANTLR start "entryRuleAndCondition"
    // InternalIfictiondsl.g:278:1: entryRuleAndCondition : ruleAndCondition EOF ;
    public final void entryRuleAndCondition() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:279:1: ( ruleAndCondition EOF )
            // InternalIfictiondsl.g:280:1: ruleAndCondition EOF
            {
             before(grammarAccess.getAndConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleAndCondition();

            state._fsp--;

             after(grammarAccess.getAndConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAndCondition"


    // $ANTLR start "ruleAndCondition"
    // InternalIfictiondsl.g:287:1: ruleAndCondition : ( ( rule__AndCondition__Group__0 ) ) ;
    public final void ruleAndCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:291:2: ( ( ( rule__AndCondition__Group__0 ) ) )
            // InternalIfictiondsl.g:292:2: ( ( rule__AndCondition__Group__0 ) )
            {
            // InternalIfictiondsl.g:292:2: ( ( rule__AndCondition__Group__0 ) )
            // InternalIfictiondsl.g:293:3: ( rule__AndCondition__Group__0 )
            {
             before(grammarAccess.getAndConditionAccess().getGroup()); 
            // InternalIfictiondsl.g:294:3: ( rule__AndCondition__Group__0 )
            // InternalIfictiondsl.g:294:4: rule__AndCondition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AndCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndCondition"


    // $ANTLR start "entryRulePrimary"
    // InternalIfictiondsl.g:303:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:304:1: ( rulePrimary EOF )
            // InternalIfictiondsl.g:305:1: rulePrimary EOF
            {
             before(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getPrimaryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalIfictiondsl.g:312:1: rulePrimary : ( ( rule__Primary__Alternatives ) ) ;
    public final void rulePrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:316:2: ( ( ( rule__Primary__Alternatives ) ) )
            // InternalIfictiondsl.g:317:2: ( ( rule__Primary__Alternatives ) )
            {
            // InternalIfictiondsl.g:317:2: ( ( rule__Primary__Alternatives ) )
            // InternalIfictiondsl.g:318:3: ( rule__Primary__Alternatives )
            {
             before(grammarAccess.getPrimaryAccess().getAlternatives()); 
            // InternalIfictiondsl.g:319:3: ( rule__Primary__Alternatives )
            // InternalIfictiondsl.g:319:4: rule__Primary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleComparison"
    // InternalIfictiondsl.g:328:1: entryRuleComparison : ruleComparison EOF ;
    public final void entryRuleComparison() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:329:1: ( ruleComparison EOF )
            // InternalIfictiondsl.g:330:1: ruleComparison EOF
            {
             before(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getComparisonRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalIfictiondsl.g:337:1: ruleComparison : ( ( rule__Comparison__Group__0 ) ) ;
    public final void ruleComparison() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:341:2: ( ( ( rule__Comparison__Group__0 ) ) )
            // InternalIfictiondsl.g:342:2: ( ( rule__Comparison__Group__0 ) )
            {
            // InternalIfictiondsl.g:342:2: ( ( rule__Comparison__Group__0 ) )
            // InternalIfictiondsl.g:343:3: ( rule__Comparison__Group__0 )
            {
             before(grammarAccess.getComparisonAccess().getGroup()); 
            // InternalIfictiondsl.g:344:3: ( rule__Comparison__Group__0 )
            // InternalIfictiondsl.g:344:4: rule__Comparison__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleOperator"
    // InternalIfictiondsl.g:353:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:354:1: ( ruleOperator EOF )
            // InternalIfictiondsl.g:355:1: ruleOperator EOF
            {
             before(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalIfictiondsl.g:362:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:366:2: ( ( ( rule__Operator__Alternatives ) ) )
            // InternalIfictiondsl.g:367:2: ( ( rule__Operator__Alternatives ) )
            {
            // InternalIfictiondsl.g:367:2: ( ( rule__Operator__Alternatives ) )
            // InternalIfictiondsl.g:368:3: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // InternalIfictiondsl.g:369:3: ( rule__Operator__Alternatives )
            // InternalIfictiondsl.g:369:4: rule__Operator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Operator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleSystemStateChangeNode"
    // InternalIfictiondsl.g:378:1: entryRuleSystemStateChangeNode : ruleSystemStateChangeNode EOF ;
    public final void entryRuleSystemStateChangeNode() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:379:1: ( ruleSystemStateChangeNode EOF )
            // InternalIfictiondsl.g:380:1: ruleSystemStateChangeNode EOF
            {
             before(grammarAccess.getSystemStateChangeNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleSystemStateChangeNode();

            state._fsp--;

             after(grammarAccess.getSystemStateChangeNodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSystemStateChangeNode"


    // $ANTLR start "ruleSystemStateChangeNode"
    // InternalIfictiondsl.g:387:1: ruleSystemStateChangeNode : ( ( rule__SystemStateChangeNode__Group__0 ) ) ;
    public final void ruleSystemStateChangeNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:391:2: ( ( ( rule__SystemStateChangeNode__Group__0 ) ) )
            // InternalIfictiondsl.g:392:2: ( ( rule__SystemStateChangeNode__Group__0 ) )
            {
            // InternalIfictiondsl.g:392:2: ( ( rule__SystemStateChangeNode__Group__0 ) )
            // InternalIfictiondsl.g:393:3: ( rule__SystemStateChangeNode__Group__0 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getGroup()); 
            // InternalIfictiondsl.g:394:3: ( rule__SystemStateChangeNode__Group__0 )
            // InternalIfictiondsl.g:394:4: rule__SystemStateChangeNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSystemStateChangeNode"


    // $ANTLR start "entryRuleStateUpdate"
    // InternalIfictiondsl.g:403:1: entryRuleStateUpdate : ruleStateUpdate EOF ;
    public final void entryRuleStateUpdate() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:404:1: ( ruleStateUpdate EOF )
            // InternalIfictiondsl.g:405:1: ruleStateUpdate EOF
            {
             before(grammarAccess.getStateUpdateRule()); 
            pushFollow(FOLLOW_1);
            ruleStateUpdate();

            state._fsp--;

             after(grammarAccess.getStateUpdateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStateUpdate"


    // $ANTLR start "ruleStateUpdate"
    // InternalIfictiondsl.g:412:1: ruleStateUpdate : ( ( rule__StateUpdate__Group__0 ) ) ;
    public final void ruleStateUpdate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:416:2: ( ( ( rule__StateUpdate__Group__0 ) ) )
            // InternalIfictiondsl.g:417:2: ( ( rule__StateUpdate__Group__0 ) )
            {
            // InternalIfictiondsl.g:417:2: ( ( rule__StateUpdate__Group__0 ) )
            // InternalIfictiondsl.g:418:3: ( rule__StateUpdate__Group__0 )
            {
             before(grammarAccess.getStateUpdateAccess().getGroup()); 
            // InternalIfictiondsl.g:419:3: ( rule__StateUpdate__Group__0 )
            // InternalIfictiondsl.g:419:4: rule__StateUpdate__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StateUpdate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStateUpdateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStateUpdate"


    // $ANTLR start "entryRuleEndNode"
    // InternalIfictiondsl.g:428:1: entryRuleEndNode : ruleEndNode EOF ;
    public final void entryRuleEndNode() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:429:1: ( ruleEndNode EOF )
            // InternalIfictiondsl.g:430:1: ruleEndNode EOF
            {
             before(grammarAccess.getEndNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleEndNode();

            state._fsp--;

             after(grammarAccess.getEndNodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEndNode"


    // $ANTLR start "ruleEndNode"
    // InternalIfictiondsl.g:437:1: ruleEndNode : ( ( rule__EndNode__Group__0 ) ) ;
    public final void ruleEndNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:441:2: ( ( ( rule__EndNode__Group__0 ) ) )
            // InternalIfictiondsl.g:442:2: ( ( rule__EndNode__Group__0 ) )
            {
            // InternalIfictiondsl.g:442:2: ( ( rule__EndNode__Group__0 ) )
            // InternalIfictiondsl.g:443:3: ( rule__EndNode__Group__0 )
            {
             before(grammarAccess.getEndNodeAccess().getGroup()); 
            // InternalIfictiondsl.g:444:3: ( rule__EndNode__Group__0 )
            // InternalIfictiondsl.g:444:4: rule__EndNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EndNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEndNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEndNode"


    // $ANTLR start "rule__Node__Alternatives"
    // InternalIfictiondsl.g:452:1: rule__Node__Alternatives : ( ( ruleStartNode ) | ( ruleChoiceNode ) | ( ruleDialogueNode ) | ( ruleSystemStateChangeNode ) | ( ruleEndNode ) );
    public final void rule__Node__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:456:1: ( ( ruleStartNode ) | ( ruleChoiceNode ) | ( ruleDialogueNode ) | ( ruleSystemStateChangeNode ) | ( ruleEndNode ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt1=1;
                }
                break;
            case 20:
                {
                alt1=2;
                }
                break;
            case 35:
                {
                alt1=3;
                }
                break;
            case 40:
                {
                alt1=4;
                }
                break;
            case 41:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalIfictiondsl.g:457:2: ( ruleStartNode )
                    {
                    // InternalIfictiondsl.g:457:2: ( ruleStartNode )
                    // InternalIfictiondsl.g:458:3: ruleStartNode
                    {
                     before(grammarAccess.getNodeAccess().getStartNodeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleStartNode();

                    state._fsp--;

                     after(grammarAccess.getNodeAccess().getStartNodeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIfictiondsl.g:463:2: ( ruleChoiceNode )
                    {
                    // InternalIfictiondsl.g:463:2: ( ruleChoiceNode )
                    // InternalIfictiondsl.g:464:3: ruleChoiceNode
                    {
                     before(grammarAccess.getNodeAccess().getChoiceNodeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleChoiceNode();

                    state._fsp--;

                     after(grammarAccess.getNodeAccess().getChoiceNodeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIfictiondsl.g:469:2: ( ruleDialogueNode )
                    {
                    // InternalIfictiondsl.g:469:2: ( ruleDialogueNode )
                    // InternalIfictiondsl.g:470:3: ruleDialogueNode
                    {
                     before(grammarAccess.getNodeAccess().getDialogueNodeParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleDialogueNode();

                    state._fsp--;

                     after(grammarAccess.getNodeAccess().getDialogueNodeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalIfictiondsl.g:475:2: ( ruleSystemStateChangeNode )
                    {
                    // InternalIfictiondsl.g:475:2: ( ruleSystemStateChangeNode )
                    // InternalIfictiondsl.g:476:3: ruleSystemStateChangeNode
                    {
                     before(grammarAccess.getNodeAccess().getSystemStateChangeNodeParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleSystemStateChangeNode();

                    state._fsp--;

                     after(grammarAccess.getNodeAccess().getSystemStateChangeNodeParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalIfictiondsl.g:481:2: ( ruleEndNode )
                    {
                    // InternalIfictiondsl.g:481:2: ( ruleEndNode )
                    // InternalIfictiondsl.g:482:3: ruleEndNode
                    {
                     before(grammarAccess.getNodeAccess().getEndNodeParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleEndNode();

                    state._fsp--;

                     after(grammarAccess.getNodeAccess().getEndNodeParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Alternatives"


    // $ANTLR start "rule__Primary__Alternatives"
    // InternalIfictiondsl.g:491:1: rule__Primary__Alternatives : ( ( ( rule__Primary__Group_0__0 ) ) | ( ruleComparison ) );
    public final void rule__Primary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:495:1: ( ( ( rule__Primary__Group_0__0 ) ) | ( ruleComparison ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==38) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalIfictiondsl.g:496:2: ( ( rule__Primary__Group_0__0 ) )
                    {
                    // InternalIfictiondsl.g:496:2: ( ( rule__Primary__Group_0__0 ) )
                    // InternalIfictiondsl.g:497:3: ( rule__Primary__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getGroup_0()); 
                    // InternalIfictiondsl.g:498:3: ( rule__Primary__Group_0__0 )
                    // InternalIfictiondsl.g:498:4: rule__Primary__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIfictiondsl.g:502:2: ( ruleComparison )
                    {
                    // InternalIfictiondsl.g:502:2: ( ruleComparison )
                    // InternalIfictiondsl.g:503:3: ruleComparison
                    {
                     before(grammarAccess.getPrimaryAccess().getComparisonParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleComparison();

                    state._fsp--;

                     after(grammarAccess.getPrimaryAccess().getComparisonParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Alternatives"


    // $ANTLR start "rule__Operator__Alternatives"
    // InternalIfictiondsl.g:512:1: rule__Operator__Alternatives : ( ( '=' ) | ( '!=' ) | ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:516:1: ( ( '=' ) | ( '!=' ) | ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) )
            int alt3=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            case 14:
                {
                alt3=4;
                }
                break;
            case 15:
                {
                alt3=5;
                }
                break;
            case 16:
                {
                alt3=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalIfictiondsl.g:517:2: ( '=' )
                    {
                    // InternalIfictiondsl.g:517:2: ( '=' )
                    // InternalIfictiondsl.g:518:3: '='
                    {
                     before(grammarAccess.getOperatorAccess().getEqualsSignKeyword_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getEqualsSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIfictiondsl.g:523:2: ( '!=' )
                    {
                    // InternalIfictiondsl.g:523:2: ( '!=' )
                    // InternalIfictiondsl.g:524:3: '!='
                    {
                     before(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIfictiondsl.g:529:2: ( '>' )
                    {
                    // InternalIfictiondsl.g:529:2: ( '>' )
                    // InternalIfictiondsl.g:530:3: '>'
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalIfictiondsl.g:535:2: ( '<' )
                    {
                    // InternalIfictiondsl.g:535:2: ( '<' )
                    // InternalIfictiondsl.g:536:3: '<'
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignKeyword_3()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalIfictiondsl.g:541:2: ( '>=' )
                    {
                    // InternalIfictiondsl.g:541:2: ( '>=' )
                    // InternalIfictiondsl.g:542:3: '>='
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_4()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalIfictiondsl.g:547:2: ( '<=' )
                    {
                    // InternalIfictiondsl.g:547:2: ( '<=' )
                    // InternalIfictiondsl.g:548:3: '<='
                    {
                     before(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_5()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Alternatives"


    // $ANTLR start "rule__StateUpdate__OperatorAlternatives_1_0"
    // InternalIfictiondsl.g:557:1: rule__StateUpdate__OperatorAlternatives_1_0 : ( ( '+=' ) | ( '-=' ) | ( '=' ) );
    public final void rule__StateUpdate__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:561:1: ( ( '+=' ) | ( '-=' ) | ( '=' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt4=1;
                }
                break;
            case 18:
                {
                alt4=2;
                }
                break;
            case 11:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalIfictiondsl.g:562:2: ( '+=' )
                    {
                    // InternalIfictiondsl.g:562:2: ( '+=' )
                    // InternalIfictiondsl.g:563:3: '+='
                    {
                     before(grammarAccess.getStateUpdateAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getStateUpdateAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIfictiondsl.g:568:2: ( '-=' )
                    {
                    // InternalIfictiondsl.g:568:2: ( '-=' )
                    // InternalIfictiondsl.g:569:3: '-='
                    {
                     before(grammarAccess.getStateUpdateAccess().getOperatorHyphenMinusEqualsSignKeyword_1_0_1()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getStateUpdateAccess().getOperatorHyphenMinusEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIfictiondsl.g:574:2: ( '=' )
                    {
                    // InternalIfictiondsl.g:574:2: ( '=' )
                    // InternalIfictiondsl.g:575:3: '='
                    {
                     before(grammarAccess.getStateUpdateAccess().getOperatorEqualsSignKeyword_1_0_2()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getStateUpdateAccess().getOperatorEqualsSignKeyword_1_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateUpdate__OperatorAlternatives_1_0"


    // $ANTLR start "rule__Story__Group__0"
    // InternalIfictiondsl.g:584:1: rule__Story__Group__0 : rule__Story__Group__0__Impl rule__Story__Group__1 ;
    public final void rule__Story__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:588:1: ( rule__Story__Group__0__Impl rule__Story__Group__1 )
            // InternalIfictiondsl.g:589:2: rule__Story__Group__0__Impl rule__Story__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Story__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Story__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__0"


    // $ANTLR start "rule__Story__Group__0__Impl"
    // InternalIfictiondsl.g:596:1: rule__Story__Group__0__Impl : ( 'Story' ) ;
    public final void rule__Story__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:600:1: ( ( 'Story' ) )
            // InternalIfictiondsl.g:601:1: ( 'Story' )
            {
            // InternalIfictiondsl.g:601:1: ( 'Story' )
            // InternalIfictiondsl.g:602:2: 'Story'
            {
             before(grammarAccess.getStoryAccess().getStoryKeyword_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getStoryAccess().getStoryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__0__Impl"


    // $ANTLR start "rule__Story__Group__1"
    // InternalIfictiondsl.g:611:1: rule__Story__Group__1 : rule__Story__Group__1__Impl rule__Story__Group__2 ;
    public final void rule__Story__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:615:1: ( rule__Story__Group__1__Impl rule__Story__Group__2 )
            // InternalIfictiondsl.g:616:2: rule__Story__Group__1__Impl rule__Story__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Story__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Story__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__1"


    // $ANTLR start "rule__Story__Group__1__Impl"
    // InternalIfictiondsl.g:623:1: rule__Story__Group__1__Impl : ( ( rule__Story__NameAssignment_1 ) ) ;
    public final void rule__Story__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:627:1: ( ( ( rule__Story__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:628:1: ( ( rule__Story__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:628:1: ( ( rule__Story__NameAssignment_1 ) )
            // InternalIfictiondsl.g:629:2: ( rule__Story__NameAssignment_1 )
            {
             before(grammarAccess.getStoryAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:630:2: ( rule__Story__NameAssignment_1 )
            // InternalIfictiondsl.g:630:3: rule__Story__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Story__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStoryAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__1__Impl"


    // $ANTLR start "rule__Story__Group__2"
    // InternalIfictiondsl.g:638:1: rule__Story__Group__2 : rule__Story__Group__2__Impl ;
    public final void rule__Story__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:642:1: ( rule__Story__Group__2__Impl )
            // InternalIfictiondsl.g:643:2: rule__Story__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Story__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__2"


    // $ANTLR start "rule__Story__Group__2__Impl"
    // InternalIfictiondsl.g:649:1: rule__Story__Group__2__Impl : ( ( rule__Story__NodesAssignment_2 )* ) ;
    public final void rule__Story__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:653:1: ( ( ( rule__Story__NodesAssignment_2 )* ) )
            // InternalIfictiondsl.g:654:1: ( ( rule__Story__NodesAssignment_2 )* )
            {
            // InternalIfictiondsl.g:654:1: ( ( rule__Story__NodesAssignment_2 )* )
            // InternalIfictiondsl.g:655:2: ( rule__Story__NodesAssignment_2 )*
            {
             before(grammarAccess.getStoryAccess().getNodesAssignment_2()); 
            // InternalIfictiondsl.g:656:2: ( rule__Story__NodesAssignment_2 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==20||(LA5_0>=34 && LA5_0<=35)||(LA5_0>=40 && LA5_0<=41)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalIfictiondsl.g:656:3: rule__Story__NodesAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Story__NodesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getStoryAccess().getNodesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__2__Impl"


    // $ANTLR start "rule__ChoiceNode__Group__0"
    // InternalIfictiondsl.g:665:1: rule__ChoiceNode__Group__0 : rule__ChoiceNode__Group__0__Impl rule__ChoiceNode__Group__1 ;
    public final void rule__ChoiceNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:669:1: ( rule__ChoiceNode__Group__0__Impl rule__ChoiceNode__Group__1 )
            // InternalIfictiondsl.g:670:2: rule__ChoiceNode__Group__0__Impl rule__ChoiceNode__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ChoiceNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__0"


    // $ANTLR start "rule__ChoiceNode__Group__0__Impl"
    // InternalIfictiondsl.g:677:1: rule__ChoiceNode__Group__0__Impl : ( 'ChoiceNode' ) ;
    public final void rule__ChoiceNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:681:1: ( ( 'ChoiceNode' ) )
            // InternalIfictiondsl.g:682:1: ( 'ChoiceNode' )
            {
            // InternalIfictiondsl.g:682:1: ( 'ChoiceNode' )
            // InternalIfictiondsl.g:683:2: 'ChoiceNode'
            {
             before(grammarAccess.getChoiceNodeAccess().getChoiceNodeKeyword_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getChoiceNodeAccess().getChoiceNodeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__0__Impl"


    // $ANTLR start "rule__ChoiceNode__Group__1"
    // InternalIfictiondsl.g:692:1: rule__ChoiceNode__Group__1 : rule__ChoiceNode__Group__1__Impl rule__ChoiceNode__Group__2 ;
    public final void rule__ChoiceNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:696:1: ( rule__ChoiceNode__Group__1__Impl rule__ChoiceNode__Group__2 )
            // InternalIfictiondsl.g:697:2: rule__ChoiceNode__Group__1__Impl rule__ChoiceNode__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__ChoiceNode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__1"


    // $ANTLR start "rule__ChoiceNode__Group__1__Impl"
    // InternalIfictiondsl.g:704:1: rule__ChoiceNode__Group__1__Impl : ( ( rule__ChoiceNode__NameAssignment_1 ) ) ;
    public final void rule__ChoiceNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:708:1: ( ( ( rule__ChoiceNode__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:709:1: ( ( rule__ChoiceNode__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:709:1: ( ( rule__ChoiceNode__NameAssignment_1 ) )
            // InternalIfictiondsl.g:710:2: ( rule__ChoiceNode__NameAssignment_1 )
            {
             before(grammarAccess.getChoiceNodeAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:711:2: ( rule__ChoiceNode__NameAssignment_1 )
            // InternalIfictiondsl.g:711:3: rule__ChoiceNode__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceNode__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getChoiceNodeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__1__Impl"


    // $ANTLR start "rule__ChoiceNode__Group__2"
    // InternalIfictiondsl.g:719:1: rule__ChoiceNode__Group__2 : rule__ChoiceNode__Group__2__Impl rule__ChoiceNode__Group__3 ;
    public final void rule__ChoiceNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:723:1: ( rule__ChoiceNode__Group__2__Impl rule__ChoiceNode__Group__3 )
            // InternalIfictiondsl.g:724:2: rule__ChoiceNode__Group__2__Impl rule__ChoiceNode__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__ChoiceNode__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__2"


    // $ANTLR start "rule__ChoiceNode__Group__2__Impl"
    // InternalIfictiondsl.g:731:1: rule__ChoiceNode__Group__2__Impl : ( '{' ) ;
    public final void rule__ChoiceNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:735:1: ( ( '{' ) )
            // InternalIfictiondsl.g:736:1: ( '{' )
            {
            // InternalIfictiondsl.g:736:1: ( '{' )
            // InternalIfictiondsl.g:737:2: '{'
            {
             before(grammarAccess.getChoiceNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getChoiceNodeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__2__Impl"


    // $ANTLR start "rule__ChoiceNode__Group__3"
    // InternalIfictiondsl.g:746:1: rule__ChoiceNode__Group__3 : rule__ChoiceNode__Group__3__Impl rule__ChoiceNode__Group__4 ;
    public final void rule__ChoiceNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:750:1: ( rule__ChoiceNode__Group__3__Impl rule__ChoiceNode__Group__4 )
            // InternalIfictiondsl.g:751:2: rule__ChoiceNode__Group__3__Impl rule__ChoiceNode__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__ChoiceNode__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__3"


    // $ANTLR start "rule__ChoiceNode__Group__3__Impl"
    // InternalIfictiondsl.g:758:1: rule__ChoiceNode__Group__3__Impl : ( 'choices' ) ;
    public final void rule__ChoiceNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:762:1: ( ( 'choices' ) )
            // InternalIfictiondsl.g:763:1: ( 'choices' )
            {
            // InternalIfictiondsl.g:763:1: ( 'choices' )
            // InternalIfictiondsl.g:764:2: 'choices'
            {
             before(grammarAccess.getChoiceNodeAccess().getChoicesKeyword_3()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getChoiceNodeAccess().getChoicesKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__3__Impl"


    // $ANTLR start "rule__ChoiceNode__Group__4"
    // InternalIfictiondsl.g:773:1: rule__ChoiceNode__Group__4 : rule__ChoiceNode__Group__4__Impl rule__ChoiceNode__Group__5 ;
    public final void rule__ChoiceNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:777:1: ( rule__ChoiceNode__Group__4__Impl rule__ChoiceNode__Group__5 )
            // InternalIfictiondsl.g:778:2: rule__ChoiceNode__Group__4__Impl rule__ChoiceNode__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__ChoiceNode__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__4"


    // $ANTLR start "rule__ChoiceNode__Group__4__Impl"
    // InternalIfictiondsl.g:785:1: rule__ChoiceNode__Group__4__Impl : ( ':' ) ;
    public final void rule__ChoiceNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:789:1: ( ( ':' ) )
            // InternalIfictiondsl.g:790:1: ( ':' )
            {
            // InternalIfictiondsl.g:790:1: ( ':' )
            // InternalIfictiondsl.g:791:2: ':'
            {
             before(grammarAccess.getChoiceNodeAccess().getColonKeyword_4()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getChoiceNodeAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__4__Impl"


    // $ANTLR start "rule__ChoiceNode__Group__5"
    // InternalIfictiondsl.g:800:1: rule__ChoiceNode__Group__5 : rule__ChoiceNode__Group__5__Impl rule__ChoiceNode__Group__6 ;
    public final void rule__ChoiceNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:804:1: ( rule__ChoiceNode__Group__5__Impl rule__ChoiceNode__Group__6 )
            // InternalIfictiondsl.g:805:2: rule__ChoiceNode__Group__5__Impl rule__ChoiceNode__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__ChoiceNode__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__5"


    // $ANTLR start "rule__ChoiceNode__Group__5__Impl"
    // InternalIfictiondsl.g:812:1: rule__ChoiceNode__Group__5__Impl : ( '[' ) ;
    public final void rule__ChoiceNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:816:1: ( ( '[' ) )
            // InternalIfictiondsl.g:817:1: ( '[' )
            {
            // InternalIfictiondsl.g:817:1: ( '[' )
            // InternalIfictiondsl.g:818:2: '['
            {
             before(grammarAccess.getChoiceNodeAccess().getLeftSquareBracketKeyword_5()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getChoiceNodeAccess().getLeftSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__5__Impl"


    // $ANTLR start "rule__ChoiceNode__Group__6"
    // InternalIfictiondsl.g:827:1: rule__ChoiceNode__Group__6 : rule__ChoiceNode__Group__6__Impl rule__ChoiceNode__Group__7 ;
    public final void rule__ChoiceNode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:831:1: ( rule__ChoiceNode__Group__6__Impl rule__ChoiceNode__Group__7 )
            // InternalIfictiondsl.g:832:2: rule__ChoiceNode__Group__6__Impl rule__ChoiceNode__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__ChoiceNode__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__6"


    // $ANTLR start "rule__ChoiceNode__Group__6__Impl"
    // InternalIfictiondsl.g:839:1: rule__ChoiceNode__Group__6__Impl : ( ( rule__ChoiceNode__Group_6__0 )? ) ;
    public final void rule__ChoiceNode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:843:1: ( ( ( rule__ChoiceNode__Group_6__0 )? ) )
            // InternalIfictiondsl.g:844:1: ( ( rule__ChoiceNode__Group_6__0 )? )
            {
            // InternalIfictiondsl.g:844:1: ( ( rule__ChoiceNode__Group_6__0 )? )
            // InternalIfictiondsl.g:845:2: ( rule__ChoiceNode__Group_6__0 )?
            {
             before(grammarAccess.getChoiceNodeAccess().getGroup_6()); 
            // InternalIfictiondsl.g:846:2: ( rule__ChoiceNode__Group_6__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==28) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalIfictiondsl.g:846:3: rule__ChoiceNode__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ChoiceNode__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChoiceNodeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__6__Impl"


    // $ANTLR start "rule__ChoiceNode__Group__7"
    // InternalIfictiondsl.g:854:1: rule__ChoiceNode__Group__7 : rule__ChoiceNode__Group__7__Impl rule__ChoiceNode__Group__8 ;
    public final void rule__ChoiceNode__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:858:1: ( rule__ChoiceNode__Group__7__Impl rule__ChoiceNode__Group__8 )
            // InternalIfictiondsl.g:859:2: rule__ChoiceNode__Group__7__Impl rule__ChoiceNode__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__ChoiceNode__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__7"


    // $ANTLR start "rule__ChoiceNode__Group__7__Impl"
    // InternalIfictiondsl.g:866:1: rule__ChoiceNode__Group__7__Impl : ( ']' ) ;
    public final void rule__ChoiceNode__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:870:1: ( ( ']' ) )
            // InternalIfictiondsl.g:871:1: ( ']' )
            {
            // InternalIfictiondsl.g:871:1: ( ']' )
            // InternalIfictiondsl.g:872:2: ']'
            {
             before(grammarAccess.getChoiceNodeAccess().getRightSquareBracketKeyword_7()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getChoiceNodeAccess().getRightSquareBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__7__Impl"


    // $ANTLR start "rule__ChoiceNode__Group__8"
    // InternalIfictiondsl.g:881:1: rule__ChoiceNode__Group__8 : rule__ChoiceNode__Group__8__Impl ;
    public final void rule__ChoiceNode__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:885:1: ( rule__ChoiceNode__Group__8__Impl )
            // InternalIfictiondsl.g:886:2: rule__ChoiceNode__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__8"


    // $ANTLR start "rule__ChoiceNode__Group__8__Impl"
    // InternalIfictiondsl.g:892:1: rule__ChoiceNode__Group__8__Impl : ( '}' ) ;
    public final void rule__ChoiceNode__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:896:1: ( ( '}' ) )
            // InternalIfictiondsl.g:897:1: ( '}' )
            {
            // InternalIfictiondsl.g:897:1: ( '}' )
            // InternalIfictiondsl.g:898:2: '}'
            {
             before(grammarAccess.getChoiceNodeAccess().getRightCurlyBracketKeyword_8()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getChoiceNodeAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group__8__Impl"


    // $ANTLR start "rule__ChoiceNode__Group_6__0"
    // InternalIfictiondsl.g:908:1: rule__ChoiceNode__Group_6__0 : rule__ChoiceNode__Group_6__0__Impl rule__ChoiceNode__Group_6__1 ;
    public final void rule__ChoiceNode__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:912:1: ( rule__ChoiceNode__Group_6__0__Impl rule__ChoiceNode__Group_6__1 )
            // InternalIfictiondsl.g:913:2: rule__ChoiceNode__Group_6__0__Impl rule__ChoiceNode__Group_6__1
            {
            pushFollow(FOLLOW_12);
            rule__ChoiceNode__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group_6__0"


    // $ANTLR start "rule__ChoiceNode__Group_6__0__Impl"
    // InternalIfictiondsl.g:920:1: rule__ChoiceNode__Group_6__0__Impl : ( ( rule__ChoiceNode__OptionsAssignment_6_0 ) ) ;
    public final void rule__ChoiceNode__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:924:1: ( ( ( rule__ChoiceNode__OptionsAssignment_6_0 ) ) )
            // InternalIfictiondsl.g:925:1: ( ( rule__ChoiceNode__OptionsAssignment_6_0 ) )
            {
            // InternalIfictiondsl.g:925:1: ( ( rule__ChoiceNode__OptionsAssignment_6_0 ) )
            // InternalIfictiondsl.g:926:2: ( rule__ChoiceNode__OptionsAssignment_6_0 )
            {
             before(grammarAccess.getChoiceNodeAccess().getOptionsAssignment_6_0()); 
            // InternalIfictiondsl.g:927:2: ( rule__ChoiceNode__OptionsAssignment_6_0 )
            // InternalIfictiondsl.g:927:3: rule__ChoiceNode__OptionsAssignment_6_0
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceNode__OptionsAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getChoiceNodeAccess().getOptionsAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group_6__0__Impl"


    // $ANTLR start "rule__ChoiceNode__Group_6__1"
    // InternalIfictiondsl.g:935:1: rule__ChoiceNode__Group_6__1 : rule__ChoiceNode__Group_6__1__Impl ;
    public final void rule__ChoiceNode__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:939:1: ( rule__ChoiceNode__Group_6__1__Impl )
            // InternalIfictiondsl.g:940:2: rule__ChoiceNode__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group_6__1"


    // $ANTLR start "rule__ChoiceNode__Group_6__1__Impl"
    // InternalIfictiondsl.g:946:1: rule__ChoiceNode__Group_6__1__Impl : ( ( rule__ChoiceNode__Group_6_1__0 )* ) ;
    public final void rule__ChoiceNode__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:950:1: ( ( ( rule__ChoiceNode__Group_6_1__0 )* ) )
            // InternalIfictiondsl.g:951:1: ( ( rule__ChoiceNode__Group_6_1__0 )* )
            {
            // InternalIfictiondsl.g:951:1: ( ( rule__ChoiceNode__Group_6_1__0 )* )
            // InternalIfictiondsl.g:952:2: ( rule__ChoiceNode__Group_6_1__0 )*
            {
             before(grammarAccess.getChoiceNodeAccess().getGroup_6_1()); 
            // InternalIfictiondsl.g:953:2: ( rule__ChoiceNode__Group_6_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalIfictiondsl.g:953:3: rule__ChoiceNode__Group_6_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__ChoiceNode__Group_6_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getChoiceNodeAccess().getGroup_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group_6__1__Impl"


    // $ANTLR start "rule__ChoiceNode__Group_6_1__0"
    // InternalIfictiondsl.g:962:1: rule__ChoiceNode__Group_6_1__0 : rule__ChoiceNode__Group_6_1__0__Impl rule__ChoiceNode__Group_6_1__1 ;
    public final void rule__ChoiceNode__Group_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:966:1: ( rule__ChoiceNode__Group_6_1__0__Impl rule__ChoiceNode__Group_6_1__1 )
            // InternalIfictiondsl.g:967:2: rule__ChoiceNode__Group_6_1__0__Impl rule__ChoiceNode__Group_6_1__1
            {
            pushFollow(FOLLOW_14);
            rule__ChoiceNode__Group_6_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group_6_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group_6_1__0"


    // $ANTLR start "rule__ChoiceNode__Group_6_1__0__Impl"
    // InternalIfictiondsl.g:974:1: rule__ChoiceNode__Group_6_1__0__Impl : ( ',' ) ;
    public final void rule__ChoiceNode__Group_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:978:1: ( ( ',' ) )
            // InternalIfictiondsl.g:979:1: ( ',' )
            {
            // InternalIfictiondsl.g:979:1: ( ',' )
            // InternalIfictiondsl.g:980:2: ','
            {
             before(grammarAccess.getChoiceNodeAccess().getCommaKeyword_6_1_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getChoiceNodeAccess().getCommaKeyword_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group_6_1__0__Impl"


    // $ANTLR start "rule__ChoiceNode__Group_6_1__1"
    // InternalIfictiondsl.g:989:1: rule__ChoiceNode__Group_6_1__1 : rule__ChoiceNode__Group_6_1__1__Impl ;
    public final void rule__ChoiceNode__Group_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:993:1: ( rule__ChoiceNode__Group_6_1__1__Impl )
            // InternalIfictiondsl.g:994:2: rule__ChoiceNode__Group_6_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceNode__Group_6_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group_6_1__1"


    // $ANTLR start "rule__ChoiceNode__Group_6_1__1__Impl"
    // InternalIfictiondsl.g:1000:1: rule__ChoiceNode__Group_6_1__1__Impl : ( ( rule__ChoiceNode__OptionsAssignment_6_1_1 ) ) ;
    public final void rule__ChoiceNode__Group_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1004:1: ( ( ( rule__ChoiceNode__OptionsAssignment_6_1_1 ) ) )
            // InternalIfictiondsl.g:1005:1: ( ( rule__ChoiceNode__OptionsAssignment_6_1_1 ) )
            {
            // InternalIfictiondsl.g:1005:1: ( ( rule__ChoiceNode__OptionsAssignment_6_1_1 ) )
            // InternalIfictiondsl.g:1006:2: ( rule__ChoiceNode__OptionsAssignment_6_1_1 )
            {
             before(grammarAccess.getChoiceNodeAccess().getOptionsAssignment_6_1_1()); 
            // InternalIfictiondsl.g:1007:2: ( rule__ChoiceNode__OptionsAssignment_6_1_1 )
            // InternalIfictiondsl.g:1007:3: rule__ChoiceNode__OptionsAssignment_6_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceNode__OptionsAssignment_6_1_1();

            state._fsp--;


            }

             after(grammarAccess.getChoiceNodeAccess().getOptionsAssignment_6_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__Group_6_1__1__Impl"


    // $ANTLR start "rule__ChoiceOption__Group__0"
    // InternalIfictiondsl.g:1016:1: rule__ChoiceOption__Group__0 : rule__ChoiceOption__Group__0__Impl rule__ChoiceOption__Group__1 ;
    public final void rule__ChoiceOption__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1020:1: ( rule__ChoiceOption__Group__0__Impl rule__ChoiceOption__Group__1 )
            // InternalIfictiondsl.g:1021:2: rule__ChoiceOption__Group__0__Impl rule__ChoiceOption__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__ChoiceOption__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__0"


    // $ANTLR start "rule__ChoiceOption__Group__0__Impl"
    // InternalIfictiondsl.g:1028:1: rule__ChoiceOption__Group__0__Impl : ( 'ChoiceOption' ) ;
    public final void rule__ChoiceOption__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1032:1: ( ( 'ChoiceOption' ) )
            // InternalIfictiondsl.g:1033:1: ( 'ChoiceOption' )
            {
            // InternalIfictiondsl.g:1033:1: ( 'ChoiceOption' )
            // InternalIfictiondsl.g:1034:2: 'ChoiceOption'
            {
             before(grammarAccess.getChoiceOptionAccess().getChoiceOptionKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getChoiceOptionAccess().getChoiceOptionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__0__Impl"


    // $ANTLR start "rule__ChoiceOption__Group__1"
    // InternalIfictiondsl.g:1043:1: rule__ChoiceOption__Group__1 : rule__ChoiceOption__Group__1__Impl rule__ChoiceOption__Group__2 ;
    public final void rule__ChoiceOption__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1047:1: ( rule__ChoiceOption__Group__1__Impl rule__ChoiceOption__Group__2 )
            // InternalIfictiondsl.g:1048:2: rule__ChoiceOption__Group__1__Impl rule__ChoiceOption__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__ChoiceOption__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__1"


    // $ANTLR start "rule__ChoiceOption__Group__1__Impl"
    // InternalIfictiondsl.g:1055:1: rule__ChoiceOption__Group__1__Impl : ( '{' ) ;
    public final void rule__ChoiceOption__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1059:1: ( ( '{' ) )
            // InternalIfictiondsl.g:1060:1: ( '{' )
            {
            // InternalIfictiondsl.g:1060:1: ( '{' )
            // InternalIfictiondsl.g:1061:2: '{'
            {
             before(grammarAccess.getChoiceOptionAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getChoiceOptionAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__1__Impl"


    // $ANTLR start "rule__ChoiceOption__Group__2"
    // InternalIfictiondsl.g:1070:1: rule__ChoiceOption__Group__2 : rule__ChoiceOption__Group__2__Impl rule__ChoiceOption__Group__3 ;
    public final void rule__ChoiceOption__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1074:1: ( rule__ChoiceOption__Group__2__Impl rule__ChoiceOption__Group__3 )
            // InternalIfictiondsl.g:1075:2: rule__ChoiceOption__Group__2__Impl rule__ChoiceOption__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__ChoiceOption__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__2"


    // $ANTLR start "rule__ChoiceOption__Group__2__Impl"
    // InternalIfictiondsl.g:1082:1: rule__ChoiceOption__Group__2__Impl : ( 'displayText' ) ;
    public final void rule__ChoiceOption__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1086:1: ( ( 'displayText' ) )
            // InternalIfictiondsl.g:1087:1: ( 'displayText' )
            {
            // InternalIfictiondsl.g:1087:1: ( 'displayText' )
            // InternalIfictiondsl.g:1088:2: 'displayText'
            {
             before(grammarAccess.getChoiceOptionAccess().getDisplayTextKeyword_2()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getChoiceOptionAccess().getDisplayTextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__2__Impl"


    // $ANTLR start "rule__ChoiceOption__Group__3"
    // InternalIfictiondsl.g:1097:1: rule__ChoiceOption__Group__3 : rule__ChoiceOption__Group__3__Impl rule__ChoiceOption__Group__4 ;
    public final void rule__ChoiceOption__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1101:1: ( rule__ChoiceOption__Group__3__Impl rule__ChoiceOption__Group__4 )
            // InternalIfictiondsl.g:1102:2: rule__ChoiceOption__Group__3__Impl rule__ChoiceOption__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__ChoiceOption__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__3"


    // $ANTLR start "rule__ChoiceOption__Group__3__Impl"
    // InternalIfictiondsl.g:1109:1: rule__ChoiceOption__Group__3__Impl : ( ':' ) ;
    public final void rule__ChoiceOption__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1113:1: ( ( ':' ) )
            // InternalIfictiondsl.g:1114:1: ( ':' )
            {
            // InternalIfictiondsl.g:1114:1: ( ':' )
            // InternalIfictiondsl.g:1115:2: ':'
            {
             before(grammarAccess.getChoiceOptionAccess().getColonKeyword_3()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getChoiceOptionAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__3__Impl"


    // $ANTLR start "rule__ChoiceOption__Group__4"
    // InternalIfictiondsl.g:1124:1: rule__ChoiceOption__Group__4 : rule__ChoiceOption__Group__4__Impl rule__ChoiceOption__Group__5 ;
    public final void rule__ChoiceOption__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1128:1: ( rule__ChoiceOption__Group__4__Impl rule__ChoiceOption__Group__5 )
            // InternalIfictiondsl.g:1129:2: rule__ChoiceOption__Group__4__Impl rule__ChoiceOption__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__ChoiceOption__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__4"


    // $ANTLR start "rule__ChoiceOption__Group__4__Impl"
    // InternalIfictiondsl.g:1136:1: rule__ChoiceOption__Group__4__Impl : ( ( rule__ChoiceOption__TextAssignment_4 ) ) ;
    public final void rule__ChoiceOption__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1140:1: ( ( ( rule__ChoiceOption__TextAssignment_4 ) ) )
            // InternalIfictiondsl.g:1141:1: ( ( rule__ChoiceOption__TextAssignment_4 ) )
            {
            // InternalIfictiondsl.g:1141:1: ( ( rule__ChoiceOption__TextAssignment_4 ) )
            // InternalIfictiondsl.g:1142:2: ( rule__ChoiceOption__TextAssignment_4 )
            {
             before(grammarAccess.getChoiceOptionAccess().getTextAssignment_4()); 
            // InternalIfictiondsl.g:1143:2: ( rule__ChoiceOption__TextAssignment_4 )
            // InternalIfictiondsl.g:1143:3: rule__ChoiceOption__TextAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceOption__TextAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getChoiceOptionAccess().getTextAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__4__Impl"


    // $ANTLR start "rule__ChoiceOption__Group__5"
    // InternalIfictiondsl.g:1151:1: rule__ChoiceOption__Group__5 : rule__ChoiceOption__Group__5__Impl rule__ChoiceOption__Group__6 ;
    public final void rule__ChoiceOption__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1155:1: ( rule__ChoiceOption__Group__5__Impl rule__ChoiceOption__Group__6 )
            // InternalIfictiondsl.g:1156:2: rule__ChoiceOption__Group__5__Impl rule__ChoiceOption__Group__6
            {
            pushFollow(FOLLOW_17);
            rule__ChoiceOption__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__5"


    // $ANTLR start "rule__ChoiceOption__Group__5__Impl"
    // InternalIfictiondsl.g:1163:1: rule__ChoiceOption__Group__5__Impl : ( ',' ) ;
    public final void rule__ChoiceOption__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1167:1: ( ( ',' ) )
            // InternalIfictiondsl.g:1168:1: ( ',' )
            {
            // InternalIfictiondsl.g:1168:1: ( ',' )
            // InternalIfictiondsl.g:1169:2: ','
            {
             before(grammarAccess.getChoiceOptionAccess().getCommaKeyword_5()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getChoiceOptionAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__5__Impl"


    // $ANTLR start "rule__ChoiceOption__Group__6"
    // InternalIfictiondsl.g:1178:1: rule__ChoiceOption__Group__6 : rule__ChoiceOption__Group__6__Impl rule__ChoiceOption__Group__7 ;
    public final void rule__ChoiceOption__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1182:1: ( rule__ChoiceOption__Group__6__Impl rule__ChoiceOption__Group__7 )
            // InternalIfictiondsl.g:1183:2: rule__ChoiceOption__Group__6__Impl rule__ChoiceOption__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__ChoiceOption__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__6"


    // $ANTLR start "rule__ChoiceOption__Group__6__Impl"
    // InternalIfictiondsl.g:1190:1: rule__ChoiceOption__Group__6__Impl : ( ( rule__ChoiceOption__Group_6__0 ) ) ;
    public final void rule__ChoiceOption__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1194:1: ( ( ( rule__ChoiceOption__Group_6__0 ) ) )
            // InternalIfictiondsl.g:1195:1: ( ( rule__ChoiceOption__Group_6__0 ) )
            {
            // InternalIfictiondsl.g:1195:1: ( ( rule__ChoiceOption__Group_6__0 ) )
            // InternalIfictiondsl.g:1196:2: ( rule__ChoiceOption__Group_6__0 )
            {
             before(grammarAccess.getChoiceOptionAccess().getGroup_6()); 
            // InternalIfictiondsl.g:1197:2: ( rule__ChoiceOption__Group_6__0 )
            // InternalIfictiondsl.g:1197:3: rule__ChoiceOption__Group_6__0
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group_6__0();

            state._fsp--;


            }

             after(grammarAccess.getChoiceOptionAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__6__Impl"


    // $ANTLR start "rule__ChoiceOption__Group__7"
    // InternalIfictiondsl.g:1205:1: rule__ChoiceOption__Group__7 : rule__ChoiceOption__Group__7__Impl ;
    public final void rule__ChoiceOption__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1209:1: ( rule__ChoiceOption__Group__7__Impl )
            // InternalIfictiondsl.g:1210:2: rule__ChoiceOption__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__7"


    // $ANTLR start "rule__ChoiceOption__Group__7__Impl"
    // InternalIfictiondsl.g:1216:1: rule__ChoiceOption__Group__7__Impl : ( '}' ) ;
    public final void rule__ChoiceOption__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1220:1: ( ( '}' ) )
            // InternalIfictiondsl.g:1221:1: ( '}' )
            {
            // InternalIfictiondsl.g:1221:1: ( '}' )
            // InternalIfictiondsl.g:1222:2: '}'
            {
             before(grammarAccess.getChoiceOptionAccess().getRightCurlyBracketKeyword_7()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getChoiceOptionAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group__7__Impl"


    // $ANTLR start "rule__ChoiceOption__Group_6__0"
    // InternalIfictiondsl.g:1232:1: rule__ChoiceOption__Group_6__0 : rule__ChoiceOption__Group_6__0__Impl rule__ChoiceOption__Group_6__1 ;
    public final void rule__ChoiceOption__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1236:1: ( rule__ChoiceOption__Group_6__0__Impl rule__ChoiceOption__Group_6__1 )
            // InternalIfictiondsl.g:1237:2: rule__ChoiceOption__Group_6__0__Impl rule__ChoiceOption__Group_6__1
            {
            pushFollow(FOLLOW_12);
            rule__ChoiceOption__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group_6__0"


    // $ANTLR start "rule__ChoiceOption__Group_6__0__Impl"
    // InternalIfictiondsl.g:1244:1: rule__ChoiceOption__Group_6__0__Impl : ( ( rule__ChoiceOption__TransitionsAssignment_6_0 ) ) ;
    public final void rule__ChoiceOption__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1248:1: ( ( ( rule__ChoiceOption__TransitionsAssignment_6_0 ) ) )
            // InternalIfictiondsl.g:1249:1: ( ( rule__ChoiceOption__TransitionsAssignment_6_0 ) )
            {
            // InternalIfictiondsl.g:1249:1: ( ( rule__ChoiceOption__TransitionsAssignment_6_0 ) )
            // InternalIfictiondsl.g:1250:2: ( rule__ChoiceOption__TransitionsAssignment_6_0 )
            {
             before(grammarAccess.getChoiceOptionAccess().getTransitionsAssignment_6_0()); 
            // InternalIfictiondsl.g:1251:2: ( rule__ChoiceOption__TransitionsAssignment_6_0 )
            // InternalIfictiondsl.g:1251:3: rule__ChoiceOption__TransitionsAssignment_6_0
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceOption__TransitionsAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getChoiceOptionAccess().getTransitionsAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group_6__0__Impl"


    // $ANTLR start "rule__ChoiceOption__Group_6__1"
    // InternalIfictiondsl.g:1259:1: rule__ChoiceOption__Group_6__1 : rule__ChoiceOption__Group_6__1__Impl ;
    public final void rule__ChoiceOption__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1263:1: ( rule__ChoiceOption__Group_6__1__Impl )
            // InternalIfictiondsl.g:1264:2: rule__ChoiceOption__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group_6__1"


    // $ANTLR start "rule__ChoiceOption__Group_6__1__Impl"
    // InternalIfictiondsl.g:1270:1: rule__ChoiceOption__Group_6__1__Impl : ( ( rule__ChoiceOption__Group_6_1__0 )* ) ;
    public final void rule__ChoiceOption__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1274:1: ( ( ( rule__ChoiceOption__Group_6_1__0 )* ) )
            // InternalIfictiondsl.g:1275:1: ( ( rule__ChoiceOption__Group_6_1__0 )* )
            {
            // InternalIfictiondsl.g:1275:1: ( ( rule__ChoiceOption__Group_6_1__0 )* )
            // InternalIfictiondsl.g:1276:2: ( rule__ChoiceOption__Group_6_1__0 )*
            {
             before(grammarAccess.getChoiceOptionAccess().getGroup_6_1()); 
            // InternalIfictiondsl.g:1277:2: ( rule__ChoiceOption__Group_6_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==27) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalIfictiondsl.g:1277:3: rule__ChoiceOption__Group_6_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__ChoiceOption__Group_6_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getChoiceOptionAccess().getGroup_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group_6__1__Impl"


    // $ANTLR start "rule__ChoiceOption__Group_6_1__0"
    // InternalIfictiondsl.g:1286:1: rule__ChoiceOption__Group_6_1__0 : rule__ChoiceOption__Group_6_1__0__Impl rule__ChoiceOption__Group_6_1__1 ;
    public final void rule__ChoiceOption__Group_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1290:1: ( rule__ChoiceOption__Group_6_1__0__Impl rule__ChoiceOption__Group_6_1__1 )
            // InternalIfictiondsl.g:1291:2: rule__ChoiceOption__Group_6_1__0__Impl rule__ChoiceOption__Group_6_1__1
            {
            pushFollow(FOLLOW_17);
            rule__ChoiceOption__Group_6_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group_6_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group_6_1__0"


    // $ANTLR start "rule__ChoiceOption__Group_6_1__0__Impl"
    // InternalIfictiondsl.g:1298:1: rule__ChoiceOption__Group_6_1__0__Impl : ( ',' ) ;
    public final void rule__ChoiceOption__Group_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1302:1: ( ( ',' ) )
            // InternalIfictiondsl.g:1303:1: ( ',' )
            {
            // InternalIfictiondsl.g:1303:1: ( ',' )
            // InternalIfictiondsl.g:1304:2: ','
            {
             before(grammarAccess.getChoiceOptionAccess().getCommaKeyword_6_1_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getChoiceOptionAccess().getCommaKeyword_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group_6_1__0__Impl"


    // $ANTLR start "rule__ChoiceOption__Group_6_1__1"
    // InternalIfictiondsl.g:1313:1: rule__ChoiceOption__Group_6_1__1 : rule__ChoiceOption__Group_6_1__1__Impl ;
    public final void rule__ChoiceOption__Group_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1317:1: ( rule__ChoiceOption__Group_6_1__1__Impl )
            // InternalIfictiondsl.g:1318:2: rule__ChoiceOption__Group_6_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceOption__Group_6_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group_6_1__1"


    // $ANTLR start "rule__ChoiceOption__Group_6_1__1__Impl"
    // InternalIfictiondsl.g:1324:1: rule__ChoiceOption__Group_6_1__1__Impl : ( ( rule__ChoiceOption__TransitionsAssignment_6_1_1 ) ) ;
    public final void rule__ChoiceOption__Group_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1328:1: ( ( ( rule__ChoiceOption__TransitionsAssignment_6_1_1 ) ) )
            // InternalIfictiondsl.g:1329:1: ( ( rule__ChoiceOption__TransitionsAssignment_6_1_1 ) )
            {
            // InternalIfictiondsl.g:1329:1: ( ( rule__ChoiceOption__TransitionsAssignment_6_1_1 ) )
            // InternalIfictiondsl.g:1330:2: ( rule__ChoiceOption__TransitionsAssignment_6_1_1 )
            {
             before(grammarAccess.getChoiceOptionAccess().getTransitionsAssignment_6_1_1()); 
            // InternalIfictiondsl.g:1331:2: ( rule__ChoiceOption__TransitionsAssignment_6_1_1 )
            // InternalIfictiondsl.g:1331:3: rule__ChoiceOption__TransitionsAssignment_6_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ChoiceOption__TransitionsAssignment_6_1_1();

            state._fsp--;


            }

             after(grammarAccess.getChoiceOptionAccess().getTransitionsAssignment_6_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__Group_6_1__1__Impl"


    // $ANTLR start "rule__Transition__Group__0"
    // InternalIfictiondsl.g:1340:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1344:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalIfictiondsl.g:1345:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Transition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0"


    // $ANTLR start "rule__Transition__Group__0__Impl"
    // InternalIfictiondsl.g:1352:1: rule__Transition__Group__0__Impl : ( '->' ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1356:1: ( ( '->' ) )
            // InternalIfictiondsl.g:1357:1: ( '->' )
            {
            // InternalIfictiondsl.g:1357:1: ( '->' )
            // InternalIfictiondsl.g:1358:2: '->'
            {
             before(grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0__Impl"


    // $ANTLR start "rule__Transition__Group__1"
    // InternalIfictiondsl.g:1367:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1371:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalIfictiondsl.g:1372:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Transition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1"


    // $ANTLR start "rule__Transition__Group__1__Impl"
    // InternalIfictiondsl.g:1379:1: rule__Transition__Group__1__Impl : ( ( rule__Transition__DestinationAssignment_1 ) ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1383:1: ( ( ( rule__Transition__DestinationAssignment_1 ) ) )
            // InternalIfictiondsl.g:1384:1: ( ( rule__Transition__DestinationAssignment_1 ) )
            {
            // InternalIfictiondsl.g:1384:1: ( ( rule__Transition__DestinationAssignment_1 ) )
            // InternalIfictiondsl.g:1385:2: ( rule__Transition__DestinationAssignment_1 )
            {
             before(grammarAccess.getTransitionAccess().getDestinationAssignment_1()); 
            // InternalIfictiondsl.g:1386:2: ( rule__Transition__DestinationAssignment_1 )
            // InternalIfictiondsl.g:1386:3: rule__Transition__DestinationAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Transition__DestinationAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getDestinationAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1__Impl"


    // $ANTLR start "rule__Transition__Group__2"
    // InternalIfictiondsl.g:1394:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl rule__Transition__Group__3 ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1398:1: ( rule__Transition__Group__2__Impl rule__Transition__Group__3 )
            // InternalIfictiondsl.g:1399:2: rule__Transition__Group__2__Impl rule__Transition__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Transition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2"


    // $ANTLR start "rule__Transition__Group__2__Impl"
    // InternalIfictiondsl.g:1406:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__Group_2__0 )? ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1410:1: ( ( ( rule__Transition__Group_2__0 )? ) )
            // InternalIfictiondsl.g:1411:1: ( ( rule__Transition__Group_2__0 )? )
            {
            // InternalIfictiondsl.g:1411:1: ( ( rule__Transition__Group_2__0 )? )
            // InternalIfictiondsl.g:1412:2: ( rule__Transition__Group_2__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_2()); 
            // InternalIfictiondsl.g:1413:2: ( rule__Transition__Group_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==31) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==32) ) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // InternalIfictiondsl.g:1413:3: rule__Transition__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transition__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2__Impl"


    // $ANTLR start "rule__Transition__Group__3"
    // InternalIfictiondsl.g:1421:1: rule__Transition__Group__3 : rule__Transition__Group__3__Impl ;
    public final void rule__Transition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1425:1: ( rule__Transition__Group__3__Impl )
            // InternalIfictiondsl.g:1426:2: rule__Transition__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__3"


    // $ANTLR start "rule__Transition__Group__3__Impl"
    // InternalIfictiondsl.g:1432:1: rule__Transition__Group__3__Impl : ( ( rule__Transition__Group_3__0 )? ) ;
    public final void rule__Transition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1436:1: ( ( ( rule__Transition__Group_3__0 )? ) )
            // InternalIfictiondsl.g:1437:1: ( ( rule__Transition__Group_3__0 )? )
            {
            // InternalIfictiondsl.g:1437:1: ( ( rule__Transition__Group_3__0 )? )
            // InternalIfictiondsl.g:1438:2: ( rule__Transition__Group_3__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_3()); 
            // InternalIfictiondsl.g:1439:2: ( rule__Transition__Group_3__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==31) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalIfictiondsl.g:1439:3: rule__Transition__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transition__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__3__Impl"


    // $ANTLR start "rule__Transition__Group_2__0"
    // InternalIfictiondsl.g:1448:1: rule__Transition__Group_2__0 : rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 ;
    public final void rule__Transition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1452:1: ( rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 )
            // InternalIfictiondsl.g:1453:2: rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1
            {
            pushFollow(FOLLOW_19);
            rule__Transition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__0"


    // $ANTLR start "rule__Transition__Group_2__0__Impl"
    // InternalIfictiondsl.g:1460:1: rule__Transition__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Transition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1464:1: ( ( 'with' ) )
            // InternalIfictiondsl.g:1465:1: ( 'with' )
            {
            // InternalIfictiondsl.g:1465:1: ( 'with' )
            // InternalIfictiondsl.g:1466:2: 'with'
            {
             before(grammarAccess.getTransitionAccess().getWithKeyword_2_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getWithKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__0__Impl"


    // $ANTLR start "rule__Transition__Group_2__1"
    // InternalIfictiondsl.g:1475:1: rule__Transition__Group_2__1 : rule__Transition__Group_2__1__Impl rule__Transition__Group_2__2 ;
    public final void rule__Transition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1479:1: ( rule__Transition__Group_2__1__Impl rule__Transition__Group_2__2 )
            // InternalIfictiondsl.g:1480:2: rule__Transition__Group_2__1__Impl rule__Transition__Group_2__2
            {
            pushFollow(FOLLOW_20);
            rule__Transition__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__1"


    // $ANTLR start "rule__Transition__Group_2__1__Impl"
    // InternalIfictiondsl.g:1487:1: rule__Transition__Group_2__1__Impl : ( 'priority' ) ;
    public final void rule__Transition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1491:1: ( ( 'priority' ) )
            // InternalIfictiondsl.g:1492:1: ( 'priority' )
            {
            // InternalIfictiondsl.g:1492:1: ( 'priority' )
            // InternalIfictiondsl.g:1493:2: 'priority'
            {
             before(grammarAccess.getTransitionAccess().getPriorityKeyword_2_1()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getPriorityKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__1__Impl"


    // $ANTLR start "rule__Transition__Group_2__2"
    // InternalIfictiondsl.g:1502:1: rule__Transition__Group_2__2 : rule__Transition__Group_2__2__Impl ;
    public final void rule__Transition__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1506:1: ( rule__Transition__Group_2__2__Impl )
            // InternalIfictiondsl.g:1507:2: rule__Transition__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__2"


    // $ANTLR start "rule__Transition__Group_2__2__Impl"
    // InternalIfictiondsl.g:1513:1: rule__Transition__Group_2__2__Impl : ( ( rule__Transition__PriorityAssignment_2_2 ) ) ;
    public final void rule__Transition__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1517:1: ( ( ( rule__Transition__PriorityAssignment_2_2 ) ) )
            // InternalIfictiondsl.g:1518:1: ( ( rule__Transition__PriorityAssignment_2_2 ) )
            {
            // InternalIfictiondsl.g:1518:1: ( ( rule__Transition__PriorityAssignment_2_2 ) )
            // InternalIfictiondsl.g:1519:2: ( rule__Transition__PriorityAssignment_2_2 )
            {
             before(grammarAccess.getTransitionAccess().getPriorityAssignment_2_2()); 
            // InternalIfictiondsl.g:1520:2: ( rule__Transition__PriorityAssignment_2_2 )
            // InternalIfictiondsl.g:1520:3: rule__Transition__PriorityAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Transition__PriorityAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getPriorityAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__2__Impl"


    // $ANTLR start "rule__Transition__Group_3__0"
    // InternalIfictiondsl.g:1529:1: rule__Transition__Group_3__0 : rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1 ;
    public final void rule__Transition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1533:1: ( rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1 )
            // InternalIfictiondsl.g:1534:2: rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1
            {
            pushFollow(FOLLOW_21);
            rule__Transition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__0"


    // $ANTLR start "rule__Transition__Group_3__0__Impl"
    // InternalIfictiondsl.g:1541:1: rule__Transition__Group_3__0__Impl : ( 'with' ) ;
    public final void rule__Transition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1545:1: ( ( 'with' ) )
            // InternalIfictiondsl.g:1546:1: ( 'with' )
            {
            // InternalIfictiondsl.g:1546:1: ( 'with' )
            // InternalIfictiondsl.g:1547:2: 'with'
            {
             before(grammarAccess.getTransitionAccess().getWithKeyword_3_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getWithKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__0__Impl"


    // $ANTLR start "rule__Transition__Group_3__1"
    // InternalIfictiondsl.g:1556:1: rule__Transition__Group_3__1 : rule__Transition__Group_3__1__Impl rule__Transition__Group_3__2 ;
    public final void rule__Transition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1560:1: ( rule__Transition__Group_3__1__Impl rule__Transition__Group_3__2 )
            // InternalIfictiondsl.g:1561:2: rule__Transition__Group_3__1__Impl rule__Transition__Group_3__2
            {
            pushFollow(FOLLOW_8);
            rule__Transition__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__1"


    // $ANTLR start "rule__Transition__Group_3__1__Impl"
    // InternalIfictiondsl.g:1568:1: rule__Transition__Group_3__1__Impl : ( 'condition' ) ;
    public final void rule__Transition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1572:1: ( ( 'condition' ) )
            // InternalIfictiondsl.g:1573:1: ( 'condition' )
            {
            // InternalIfictiondsl.g:1573:1: ( 'condition' )
            // InternalIfictiondsl.g:1574:2: 'condition'
            {
             before(grammarAccess.getTransitionAccess().getConditionKeyword_3_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getConditionKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__1__Impl"


    // $ANTLR start "rule__Transition__Group_3__2"
    // InternalIfictiondsl.g:1583:1: rule__Transition__Group_3__2 : rule__Transition__Group_3__2__Impl rule__Transition__Group_3__3 ;
    public final void rule__Transition__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1587:1: ( rule__Transition__Group_3__2__Impl rule__Transition__Group_3__3 )
            // InternalIfictiondsl.g:1588:2: rule__Transition__Group_3__2__Impl rule__Transition__Group_3__3
            {
            pushFollow(FOLLOW_22);
            rule__Transition__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__2"


    // $ANTLR start "rule__Transition__Group_3__2__Impl"
    // InternalIfictiondsl.g:1595:1: rule__Transition__Group_3__2__Impl : ( ':' ) ;
    public final void rule__Transition__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1599:1: ( ( ':' ) )
            // InternalIfictiondsl.g:1600:1: ( ':' )
            {
            // InternalIfictiondsl.g:1600:1: ( ':' )
            // InternalIfictiondsl.g:1601:2: ':'
            {
             before(grammarAccess.getTransitionAccess().getColonKeyword_3_2()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getColonKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__2__Impl"


    // $ANTLR start "rule__Transition__Group_3__3"
    // InternalIfictiondsl.g:1610:1: rule__Transition__Group_3__3 : rule__Transition__Group_3__3__Impl ;
    public final void rule__Transition__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1614:1: ( rule__Transition__Group_3__3__Impl )
            // InternalIfictiondsl.g:1615:2: rule__Transition__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__3"


    // $ANTLR start "rule__Transition__Group_3__3__Impl"
    // InternalIfictiondsl.g:1621:1: rule__Transition__Group_3__3__Impl : ( ( rule__Transition__ConditionAssignment_3_3 ) ) ;
    public final void rule__Transition__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1625:1: ( ( ( rule__Transition__ConditionAssignment_3_3 ) ) )
            // InternalIfictiondsl.g:1626:1: ( ( rule__Transition__ConditionAssignment_3_3 ) )
            {
            // InternalIfictiondsl.g:1626:1: ( ( rule__Transition__ConditionAssignment_3_3 ) )
            // InternalIfictiondsl.g:1627:2: ( rule__Transition__ConditionAssignment_3_3 )
            {
             before(grammarAccess.getTransitionAccess().getConditionAssignment_3_3()); 
            // InternalIfictiondsl.g:1628:2: ( rule__Transition__ConditionAssignment_3_3 )
            // InternalIfictiondsl.g:1628:3: rule__Transition__ConditionAssignment_3_3
            {
            pushFollow(FOLLOW_2);
            rule__Transition__ConditionAssignment_3_3();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getConditionAssignment_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__3__Impl"


    // $ANTLR start "rule__StartNode__Group__0"
    // InternalIfictiondsl.g:1637:1: rule__StartNode__Group__0 : rule__StartNode__Group__0__Impl rule__StartNode__Group__1 ;
    public final void rule__StartNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1641:1: ( rule__StartNode__Group__0__Impl rule__StartNode__Group__1 )
            // InternalIfictiondsl.g:1642:2: rule__StartNode__Group__0__Impl rule__StartNode__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__StartNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__0"


    // $ANTLR start "rule__StartNode__Group__0__Impl"
    // InternalIfictiondsl.g:1649:1: rule__StartNode__Group__0__Impl : ( 'StartNode' ) ;
    public final void rule__StartNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1653:1: ( ( 'StartNode' ) )
            // InternalIfictiondsl.g:1654:1: ( 'StartNode' )
            {
            // InternalIfictiondsl.g:1654:1: ( 'StartNode' )
            // InternalIfictiondsl.g:1655:2: 'StartNode'
            {
             before(grammarAccess.getStartNodeAccess().getStartNodeKeyword_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getStartNodeAccess().getStartNodeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__0__Impl"


    // $ANTLR start "rule__StartNode__Group__1"
    // InternalIfictiondsl.g:1664:1: rule__StartNode__Group__1 : rule__StartNode__Group__1__Impl rule__StartNode__Group__2 ;
    public final void rule__StartNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1668:1: ( rule__StartNode__Group__1__Impl rule__StartNode__Group__2 )
            // InternalIfictiondsl.g:1669:2: rule__StartNode__Group__1__Impl rule__StartNode__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__StartNode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartNode__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__1"


    // $ANTLR start "rule__StartNode__Group__1__Impl"
    // InternalIfictiondsl.g:1676:1: rule__StartNode__Group__1__Impl : ( ( rule__StartNode__NameAssignment_1 ) ) ;
    public final void rule__StartNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1680:1: ( ( ( rule__StartNode__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:1681:1: ( ( rule__StartNode__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:1681:1: ( ( rule__StartNode__NameAssignment_1 ) )
            // InternalIfictiondsl.g:1682:2: ( rule__StartNode__NameAssignment_1 )
            {
             before(grammarAccess.getStartNodeAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:1683:2: ( rule__StartNode__NameAssignment_1 )
            // InternalIfictiondsl.g:1683:3: rule__StartNode__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__StartNode__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStartNodeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__1__Impl"


    // $ANTLR start "rule__StartNode__Group__2"
    // InternalIfictiondsl.g:1691:1: rule__StartNode__Group__2 : rule__StartNode__Group__2__Impl rule__StartNode__Group__3 ;
    public final void rule__StartNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1695:1: ( rule__StartNode__Group__2__Impl rule__StartNode__Group__3 )
            // InternalIfictiondsl.g:1696:2: rule__StartNode__Group__2__Impl rule__StartNode__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__StartNode__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartNode__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__2"


    // $ANTLR start "rule__StartNode__Group__2__Impl"
    // InternalIfictiondsl.g:1703:1: rule__StartNode__Group__2__Impl : ( '{' ) ;
    public final void rule__StartNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1707:1: ( ( '{' ) )
            // InternalIfictiondsl.g:1708:1: ( '{' )
            {
            // InternalIfictiondsl.g:1708:1: ( '{' )
            // InternalIfictiondsl.g:1709:2: '{'
            {
             before(grammarAccess.getStartNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getStartNodeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__2__Impl"


    // $ANTLR start "rule__StartNode__Group__3"
    // InternalIfictiondsl.g:1718:1: rule__StartNode__Group__3 : rule__StartNode__Group__3__Impl rule__StartNode__Group__4 ;
    public final void rule__StartNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1722:1: ( rule__StartNode__Group__3__Impl rule__StartNode__Group__4 )
            // InternalIfictiondsl.g:1723:2: rule__StartNode__Group__3__Impl rule__StartNode__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__StartNode__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartNode__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__3"


    // $ANTLR start "rule__StartNode__Group__3__Impl"
    // InternalIfictiondsl.g:1730:1: rule__StartNode__Group__3__Impl : ( 'displayText' ) ;
    public final void rule__StartNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1734:1: ( ( 'displayText' ) )
            // InternalIfictiondsl.g:1735:1: ( 'displayText' )
            {
            // InternalIfictiondsl.g:1735:1: ( 'displayText' )
            // InternalIfictiondsl.g:1736:2: 'displayText'
            {
             before(grammarAccess.getStartNodeAccess().getDisplayTextKeyword_3()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getStartNodeAccess().getDisplayTextKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__3__Impl"


    // $ANTLR start "rule__StartNode__Group__4"
    // InternalIfictiondsl.g:1745:1: rule__StartNode__Group__4 : rule__StartNode__Group__4__Impl rule__StartNode__Group__5 ;
    public final void rule__StartNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1749:1: ( rule__StartNode__Group__4__Impl rule__StartNode__Group__5 )
            // InternalIfictiondsl.g:1750:2: rule__StartNode__Group__4__Impl rule__StartNode__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__StartNode__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartNode__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__4"


    // $ANTLR start "rule__StartNode__Group__4__Impl"
    // InternalIfictiondsl.g:1757:1: rule__StartNode__Group__4__Impl : ( ':' ) ;
    public final void rule__StartNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1761:1: ( ( ':' ) )
            // InternalIfictiondsl.g:1762:1: ( ':' )
            {
            // InternalIfictiondsl.g:1762:1: ( ':' )
            // InternalIfictiondsl.g:1763:2: ':'
            {
             before(grammarAccess.getStartNodeAccess().getColonKeyword_4()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getStartNodeAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__4__Impl"


    // $ANTLR start "rule__StartNode__Group__5"
    // InternalIfictiondsl.g:1772:1: rule__StartNode__Group__5 : rule__StartNode__Group__5__Impl rule__StartNode__Group__6 ;
    public final void rule__StartNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1776:1: ( rule__StartNode__Group__5__Impl rule__StartNode__Group__6 )
            // InternalIfictiondsl.g:1777:2: rule__StartNode__Group__5__Impl rule__StartNode__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__StartNode__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartNode__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__5"


    // $ANTLR start "rule__StartNode__Group__5__Impl"
    // InternalIfictiondsl.g:1784:1: rule__StartNode__Group__5__Impl : ( ( rule__StartNode__TextAssignment_5 ) ) ;
    public final void rule__StartNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1788:1: ( ( ( rule__StartNode__TextAssignment_5 ) ) )
            // InternalIfictiondsl.g:1789:1: ( ( rule__StartNode__TextAssignment_5 ) )
            {
            // InternalIfictiondsl.g:1789:1: ( ( rule__StartNode__TextAssignment_5 ) )
            // InternalIfictiondsl.g:1790:2: ( rule__StartNode__TextAssignment_5 )
            {
             before(grammarAccess.getStartNodeAccess().getTextAssignment_5()); 
            // InternalIfictiondsl.g:1791:2: ( rule__StartNode__TextAssignment_5 )
            // InternalIfictiondsl.g:1791:3: rule__StartNode__TextAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__StartNode__TextAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getStartNodeAccess().getTextAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__5__Impl"


    // $ANTLR start "rule__StartNode__Group__6"
    // InternalIfictiondsl.g:1799:1: rule__StartNode__Group__6 : rule__StartNode__Group__6__Impl rule__StartNode__Group__7 ;
    public final void rule__StartNode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1803:1: ( rule__StartNode__Group__6__Impl rule__StartNode__Group__7 )
            // InternalIfictiondsl.g:1804:2: rule__StartNode__Group__6__Impl rule__StartNode__Group__7
            {
            pushFollow(FOLLOW_17);
            rule__StartNode__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartNode__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__6"


    // $ANTLR start "rule__StartNode__Group__6__Impl"
    // InternalIfictiondsl.g:1811:1: rule__StartNode__Group__6__Impl : ( ',' ) ;
    public final void rule__StartNode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1815:1: ( ( ',' ) )
            // InternalIfictiondsl.g:1816:1: ( ',' )
            {
            // InternalIfictiondsl.g:1816:1: ( ',' )
            // InternalIfictiondsl.g:1817:2: ','
            {
             before(grammarAccess.getStartNodeAccess().getCommaKeyword_6()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getStartNodeAccess().getCommaKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__6__Impl"


    // $ANTLR start "rule__StartNode__Group__7"
    // InternalIfictiondsl.g:1826:1: rule__StartNode__Group__7 : rule__StartNode__Group__7__Impl rule__StartNode__Group__8 ;
    public final void rule__StartNode__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1830:1: ( rule__StartNode__Group__7__Impl rule__StartNode__Group__8 )
            // InternalIfictiondsl.g:1831:2: rule__StartNode__Group__7__Impl rule__StartNode__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__StartNode__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StartNode__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__7"


    // $ANTLR start "rule__StartNode__Group__7__Impl"
    // InternalIfictiondsl.g:1838:1: rule__StartNode__Group__7__Impl : ( ( rule__StartNode__TransitionAssignment_7 ) ) ;
    public final void rule__StartNode__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1842:1: ( ( ( rule__StartNode__TransitionAssignment_7 ) ) )
            // InternalIfictiondsl.g:1843:1: ( ( rule__StartNode__TransitionAssignment_7 ) )
            {
            // InternalIfictiondsl.g:1843:1: ( ( rule__StartNode__TransitionAssignment_7 ) )
            // InternalIfictiondsl.g:1844:2: ( rule__StartNode__TransitionAssignment_7 )
            {
             before(grammarAccess.getStartNodeAccess().getTransitionAssignment_7()); 
            // InternalIfictiondsl.g:1845:2: ( rule__StartNode__TransitionAssignment_7 )
            // InternalIfictiondsl.g:1845:3: rule__StartNode__TransitionAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__StartNode__TransitionAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getStartNodeAccess().getTransitionAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__7__Impl"


    // $ANTLR start "rule__StartNode__Group__8"
    // InternalIfictiondsl.g:1853:1: rule__StartNode__Group__8 : rule__StartNode__Group__8__Impl ;
    public final void rule__StartNode__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1857:1: ( rule__StartNode__Group__8__Impl )
            // InternalIfictiondsl.g:1858:2: rule__StartNode__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StartNode__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__8"


    // $ANTLR start "rule__StartNode__Group__8__Impl"
    // InternalIfictiondsl.g:1864:1: rule__StartNode__Group__8__Impl : ( '}' ) ;
    public final void rule__StartNode__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1868:1: ( ( '}' ) )
            // InternalIfictiondsl.g:1869:1: ( '}' )
            {
            // InternalIfictiondsl.g:1869:1: ( '}' )
            // InternalIfictiondsl.g:1870:2: '}'
            {
             before(grammarAccess.getStartNodeAccess().getRightCurlyBracketKeyword_8()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getStartNodeAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__Group__8__Impl"


    // $ANTLR start "rule__DialogueNode__Group__0"
    // InternalIfictiondsl.g:1880:1: rule__DialogueNode__Group__0 : rule__DialogueNode__Group__0__Impl rule__DialogueNode__Group__1 ;
    public final void rule__DialogueNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1884:1: ( rule__DialogueNode__Group__0__Impl rule__DialogueNode__Group__1 )
            // InternalIfictiondsl.g:1885:2: rule__DialogueNode__Group__0__Impl rule__DialogueNode__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__DialogueNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DialogueNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__0"


    // $ANTLR start "rule__DialogueNode__Group__0__Impl"
    // InternalIfictiondsl.g:1892:1: rule__DialogueNode__Group__0__Impl : ( 'DialogueNode' ) ;
    public final void rule__DialogueNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1896:1: ( ( 'DialogueNode' ) )
            // InternalIfictiondsl.g:1897:1: ( 'DialogueNode' )
            {
            // InternalIfictiondsl.g:1897:1: ( 'DialogueNode' )
            // InternalIfictiondsl.g:1898:2: 'DialogueNode'
            {
             before(grammarAccess.getDialogueNodeAccess().getDialogueNodeKeyword_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getDialogueNodeAccess().getDialogueNodeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__0__Impl"


    // $ANTLR start "rule__DialogueNode__Group__1"
    // InternalIfictiondsl.g:1907:1: rule__DialogueNode__Group__1 : rule__DialogueNode__Group__1__Impl rule__DialogueNode__Group__2 ;
    public final void rule__DialogueNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1911:1: ( rule__DialogueNode__Group__1__Impl rule__DialogueNode__Group__2 )
            // InternalIfictiondsl.g:1912:2: rule__DialogueNode__Group__1__Impl rule__DialogueNode__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__DialogueNode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DialogueNode__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__1"


    // $ANTLR start "rule__DialogueNode__Group__1__Impl"
    // InternalIfictiondsl.g:1919:1: rule__DialogueNode__Group__1__Impl : ( ( rule__DialogueNode__NameAssignment_1 ) ) ;
    public final void rule__DialogueNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1923:1: ( ( ( rule__DialogueNode__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:1924:1: ( ( rule__DialogueNode__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:1924:1: ( ( rule__DialogueNode__NameAssignment_1 ) )
            // InternalIfictiondsl.g:1925:2: ( rule__DialogueNode__NameAssignment_1 )
            {
             before(grammarAccess.getDialogueNodeAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:1926:2: ( rule__DialogueNode__NameAssignment_1 )
            // InternalIfictiondsl.g:1926:3: rule__DialogueNode__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DialogueNode__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDialogueNodeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__1__Impl"


    // $ANTLR start "rule__DialogueNode__Group__2"
    // InternalIfictiondsl.g:1934:1: rule__DialogueNode__Group__2 : rule__DialogueNode__Group__2__Impl rule__DialogueNode__Group__3 ;
    public final void rule__DialogueNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1938:1: ( rule__DialogueNode__Group__2__Impl rule__DialogueNode__Group__3 )
            // InternalIfictiondsl.g:1939:2: rule__DialogueNode__Group__2__Impl rule__DialogueNode__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__DialogueNode__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DialogueNode__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__2"


    // $ANTLR start "rule__DialogueNode__Group__2__Impl"
    // InternalIfictiondsl.g:1946:1: rule__DialogueNode__Group__2__Impl : ( '{' ) ;
    public final void rule__DialogueNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1950:1: ( ( '{' ) )
            // InternalIfictiondsl.g:1951:1: ( '{' )
            {
            // InternalIfictiondsl.g:1951:1: ( '{' )
            // InternalIfictiondsl.g:1952:2: '{'
            {
             before(grammarAccess.getDialogueNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getDialogueNodeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__2__Impl"


    // $ANTLR start "rule__DialogueNode__Group__3"
    // InternalIfictiondsl.g:1961:1: rule__DialogueNode__Group__3 : rule__DialogueNode__Group__3__Impl rule__DialogueNode__Group__4 ;
    public final void rule__DialogueNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1965:1: ( rule__DialogueNode__Group__3__Impl rule__DialogueNode__Group__4 )
            // InternalIfictiondsl.g:1966:2: rule__DialogueNode__Group__3__Impl rule__DialogueNode__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__DialogueNode__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DialogueNode__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__3"


    // $ANTLR start "rule__DialogueNode__Group__3__Impl"
    // InternalIfictiondsl.g:1973:1: rule__DialogueNode__Group__3__Impl : ( 'displayText' ) ;
    public final void rule__DialogueNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1977:1: ( ( 'displayText' ) )
            // InternalIfictiondsl.g:1978:1: ( 'displayText' )
            {
            // InternalIfictiondsl.g:1978:1: ( 'displayText' )
            // InternalIfictiondsl.g:1979:2: 'displayText'
            {
             before(grammarAccess.getDialogueNodeAccess().getDisplayTextKeyword_3()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getDialogueNodeAccess().getDisplayTextKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__3__Impl"


    // $ANTLR start "rule__DialogueNode__Group__4"
    // InternalIfictiondsl.g:1988:1: rule__DialogueNode__Group__4 : rule__DialogueNode__Group__4__Impl rule__DialogueNode__Group__5 ;
    public final void rule__DialogueNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1992:1: ( rule__DialogueNode__Group__4__Impl rule__DialogueNode__Group__5 )
            // InternalIfictiondsl.g:1993:2: rule__DialogueNode__Group__4__Impl rule__DialogueNode__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__DialogueNode__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DialogueNode__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__4"


    // $ANTLR start "rule__DialogueNode__Group__4__Impl"
    // InternalIfictiondsl.g:2000:1: rule__DialogueNode__Group__4__Impl : ( ':' ) ;
    public final void rule__DialogueNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2004:1: ( ( ':' ) )
            // InternalIfictiondsl.g:2005:1: ( ':' )
            {
            // InternalIfictiondsl.g:2005:1: ( ':' )
            // InternalIfictiondsl.g:2006:2: ':'
            {
             before(grammarAccess.getDialogueNodeAccess().getColonKeyword_4()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getDialogueNodeAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__4__Impl"


    // $ANTLR start "rule__DialogueNode__Group__5"
    // InternalIfictiondsl.g:2015:1: rule__DialogueNode__Group__5 : rule__DialogueNode__Group__5__Impl rule__DialogueNode__Group__6 ;
    public final void rule__DialogueNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2019:1: ( rule__DialogueNode__Group__5__Impl rule__DialogueNode__Group__6 )
            // InternalIfictiondsl.g:2020:2: rule__DialogueNode__Group__5__Impl rule__DialogueNode__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__DialogueNode__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DialogueNode__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__5"


    // $ANTLR start "rule__DialogueNode__Group__5__Impl"
    // InternalIfictiondsl.g:2027:1: rule__DialogueNode__Group__5__Impl : ( ( rule__DialogueNode__TextAssignment_5 ) ) ;
    public final void rule__DialogueNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2031:1: ( ( ( rule__DialogueNode__TextAssignment_5 ) ) )
            // InternalIfictiondsl.g:2032:1: ( ( rule__DialogueNode__TextAssignment_5 ) )
            {
            // InternalIfictiondsl.g:2032:1: ( ( rule__DialogueNode__TextAssignment_5 ) )
            // InternalIfictiondsl.g:2033:2: ( rule__DialogueNode__TextAssignment_5 )
            {
             before(grammarAccess.getDialogueNodeAccess().getTextAssignment_5()); 
            // InternalIfictiondsl.g:2034:2: ( rule__DialogueNode__TextAssignment_5 )
            // InternalIfictiondsl.g:2034:3: rule__DialogueNode__TextAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__DialogueNode__TextAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getDialogueNodeAccess().getTextAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__5__Impl"


    // $ANTLR start "rule__DialogueNode__Group__6"
    // InternalIfictiondsl.g:2042:1: rule__DialogueNode__Group__6 : rule__DialogueNode__Group__6__Impl rule__DialogueNode__Group__7 ;
    public final void rule__DialogueNode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2046:1: ( rule__DialogueNode__Group__6__Impl rule__DialogueNode__Group__7 )
            // InternalIfictiondsl.g:2047:2: rule__DialogueNode__Group__6__Impl rule__DialogueNode__Group__7
            {
            pushFollow(FOLLOW_17);
            rule__DialogueNode__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DialogueNode__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__6"


    // $ANTLR start "rule__DialogueNode__Group__6__Impl"
    // InternalIfictiondsl.g:2054:1: rule__DialogueNode__Group__6__Impl : ( ',' ) ;
    public final void rule__DialogueNode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2058:1: ( ( ',' ) )
            // InternalIfictiondsl.g:2059:1: ( ',' )
            {
            // InternalIfictiondsl.g:2059:1: ( ',' )
            // InternalIfictiondsl.g:2060:2: ','
            {
             before(grammarAccess.getDialogueNodeAccess().getCommaKeyword_6()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getDialogueNodeAccess().getCommaKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__6__Impl"


    // $ANTLR start "rule__DialogueNode__Group__7"
    // InternalIfictiondsl.g:2069:1: rule__DialogueNode__Group__7 : rule__DialogueNode__Group__7__Impl rule__DialogueNode__Group__8 ;
    public final void rule__DialogueNode__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2073:1: ( rule__DialogueNode__Group__7__Impl rule__DialogueNode__Group__8 )
            // InternalIfictiondsl.g:2074:2: rule__DialogueNode__Group__7__Impl rule__DialogueNode__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__DialogueNode__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DialogueNode__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__7"


    // $ANTLR start "rule__DialogueNode__Group__7__Impl"
    // InternalIfictiondsl.g:2081:1: rule__DialogueNode__Group__7__Impl : ( ( rule__DialogueNode__TransitionAssignment_7 ) ) ;
    public final void rule__DialogueNode__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2085:1: ( ( ( rule__DialogueNode__TransitionAssignment_7 ) ) )
            // InternalIfictiondsl.g:2086:1: ( ( rule__DialogueNode__TransitionAssignment_7 ) )
            {
            // InternalIfictiondsl.g:2086:1: ( ( rule__DialogueNode__TransitionAssignment_7 ) )
            // InternalIfictiondsl.g:2087:2: ( rule__DialogueNode__TransitionAssignment_7 )
            {
             before(grammarAccess.getDialogueNodeAccess().getTransitionAssignment_7()); 
            // InternalIfictiondsl.g:2088:2: ( rule__DialogueNode__TransitionAssignment_7 )
            // InternalIfictiondsl.g:2088:3: rule__DialogueNode__TransitionAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__DialogueNode__TransitionAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getDialogueNodeAccess().getTransitionAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__7__Impl"


    // $ANTLR start "rule__DialogueNode__Group__8"
    // InternalIfictiondsl.g:2096:1: rule__DialogueNode__Group__8 : rule__DialogueNode__Group__8__Impl ;
    public final void rule__DialogueNode__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2100:1: ( rule__DialogueNode__Group__8__Impl )
            // InternalIfictiondsl.g:2101:2: rule__DialogueNode__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DialogueNode__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__8"


    // $ANTLR start "rule__DialogueNode__Group__8__Impl"
    // InternalIfictiondsl.g:2107:1: rule__DialogueNode__Group__8__Impl : ( '}' ) ;
    public final void rule__DialogueNode__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2111:1: ( ( '}' ) )
            // InternalIfictiondsl.g:2112:1: ( '}' )
            {
            // InternalIfictiondsl.g:2112:1: ( '}' )
            // InternalIfictiondsl.g:2113:2: '}'
            {
             before(grammarAccess.getDialogueNodeAccess().getRightCurlyBracketKeyword_8()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getDialogueNodeAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__Group__8__Impl"


    // $ANTLR start "rule__OrCondition__Group__0"
    // InternalIfictiondsl.g:2123:1: rule__OrCondition__Group__0 : rule__OrCondition__Group__0__Impl rule__OrCondition__Group__1 ;
    public final void rule__OrCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2127:1: ( rule__OrCondition__Group__0__Impl rule__OrCondition__Group__1 )
            // InternalIfictiondsl.g:2128:2: rule__OrCondition__Group__0__Impl rule__OrCondition__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__OrCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrCondition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__Group__0"


    // $ANTLR start "rule__OrCondition__Group__0__Impl"
    // InternalIfictiondsl.g:2135:1: rule__OrCondition__Group__0__Impl : ( ruleAndCondition ) ;
    public final void rule__OrCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2139:1: ( ( ruleAndCondition ) )
            // InternalIfictiondsl.g:2140:1: ( ruleAndCondition )
            {
            // InternalIfictiondsl.g:2140:1: ( ruleAndCondition )
            // InternalIfictiondsl.g:2141:2: ruleAndCondition
            {
             before(grammarAccess.getOrConditionAccess().getAndConditionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAndCondition();

            state._fsp--;

             after(grammarAccess.getOrConditionAccess().getAndConditionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__Group__0__Impl"


    // $ANTLR start "rule__OrCondition__Group__1"
    // InternalIfictiondsl.g:2150:1: rule__OrCondition__Group__1 : rule__OrCondition__Group__1__Impl ;
    public final void rule__OrCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2154:1: ( rule__OrCondition__Group__1__Impl )
            // InternalIfictiondsl.g:2155:2: rule__OrCondition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrCondition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__Group__1"


    // $ANTLR start "rule__OrCondition__Group__1__Impl"
    // InternalIfictiondsl.g:2161:1: rule__OrCondition__Group__1__Impl : ( ( rule__OrCondition__Group_1__0 )* ) ;
    public final void rule__OrCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2165:1: ( ( ( rule__OrCondition__Group_1__0 )* ) )
            // InternalIfictiondsl.g:2166:1: ( ( rule__OrCondition__Group_1__0 )* )
            {
            // InternalIfictiondsl.g:2166:1: ( ( rule__OrCondition__Group_1__0 )* )
            // InternalIfictiondsl.g:2167:2: ( rule__OrCondition__Group_1__0 )*
            {
             before(grammarAccess.getOrConditionAccess().getGroup_1()); 
            // InternalIfictiondsl.g:2168:2: ( rule__OrCondition__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==36) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalIfictiondsl.g:2168:3: rule__OrCondition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__OrCondition__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getOrConditionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__Group__1__Impl"


    // $ANTLR start "rule__OrCondition__Group_1__0"
    // InternalIfictiondsl.g:2177:1: rule__OrCondition__Group_1__0 : rule__OrCondition__Group_1__0__Impl rule__OrCondition__Group_1__1 ;
    public final void rule__OrCondition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2181:1: ( rule__OrCondition__Group_1__0__Impl rule__OrCondition__Group_1__1 )
            // InternalIfictiondsl.g:2182:2: rule__OrCondition__Group_1__0__Impl rule__OrCondition__Group_1__1
            {
            pushFollow(FOLLOW_23);
            rule__OrCondition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrCondition__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__Group_1__0"


    // $ANTLR start "rule__OrCondition__Group_1__0__Impl"
    // InternalIfictiondsl.g:2189:1: rule__OrCondition__Group_1__0__Impl : ( () ) ;
    public final void rule__OrCondition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2193:1: ( ( () ) )
            // InternalIfictiondsl.g:2194:1: ( () )
            {
            // InternalIfictiondsl.g:2194:1: ( () )
            // InternalIfictiondsl.g:2195:2: ()
            {
             before(grammarAccess.getOrConditionAccess().getOrLeftAction_1_0()); 
            // InternalIfictiondsl.g:2196:2: ()
            // InternalIfictiondsl.g:2196:3: 
            {
            }

             after(grammarAccess.getOrConditionAccess().getOrLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__Group_1__0__Impl"


    // $ANTLR start "rule__OrCondition__Group_1__1"
    // InternalIfictiondsl.g:2204:1: rule__OrCondition__Group_1__1 : rule__OrCondition__Group_1__1__Impl rule__OrCondition__Group_1__2 ;
    public final void rule__OrCondition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2208:1: ( rule__OrCondition__Group_1__1__Impl rule__OrCondition__Group_1__2 )
            // InternalIfictiondsl.g:2209:2: rule__OrCondition__Group_1__1__Impl rule__OrCondition__Group_1__2
            {
            pushFollow(FOLLOW_22);
            rule__OrCondition__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrCondition__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__Group_1__1"


    // $ANTLR start "rule__OrCondition__Group_1__1__Impl"
    // InternalIfictiondsl.g:2216:1: rule__OrCondition__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__OrCondition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2220:1: ( ( 'or' ) )
            // InternalIfictiondsl.g:2221:1: ( 'or' )
            {
            // InternalIfictiondsl.g:2221:1: ( 'or' )
            // InternalIfictiondsl.g:2222:2: 'or'
            {
             before(grammarAccess.getOrConditionAccess().getOrKeyword_1_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getOrConditionAccess().getOrKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__Group_1__1__Impl"


    // $ANTLR start "rule__OrCondition__Group_1__2"
    // InternalIfictiondsl.g:2231:1: rule__OrCondition__Group_1__2 : rule__OrCondition__Group_1__2__Impl ;
    public final void rule__OrCondition__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2235:1: ( rule__OrCondition__Group_1__2__Impl )
            // InternalIfictiondsl.g:2236:2: rule__OrCondition__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrCondition__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__Group_1__2"


    // $ANTLR start "rule__OrCondition__Group_1__2__Impl"
    // InternalIfictiondsl.g:2242:1: rule__OrCondition__Group_1__2__Impl : ( ( rule__OrCondition__RightAssignment_1_2 ) ) ;
    public final void rule__OrCondition__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2246:1: ( ( ( rule__OrCondition__RightAssignment_1_2 ) ) )
            // InternalIfictiondsl.g:2247:1: ( ( rule__OrCondition__RightAssignment_1_2 ) )
            {
            // InternalIfictiondsl.g:2247:1: ( ( rule__OrCondition__RightAssignment_1_2 ) )
            // InternalIfictiondsl.g:2248:2: ( rule__OrCondition__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrConditionAccess().getRightAssignment_1_2()); 
            // InternalIfictiondsl.g:2249:2: ( rule__OrCondition__RightAssignment_1_2 )
            // InternalIfictiondsl.g:2249:3: rule__OrCondition__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__OrCondition__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrConditionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__Group_1__2__Impl"


    // $ANTLR start "rule__AndCondition__Group__0"
    // InternalIfictiondsl.g:2258:1: rule__AndCondition__Group__0 : rule__AndCondition__Group__0__Impl rule__AndCondition__Group__1 ;
    public final void rule__AndCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2262:1: ( rule__AndCondition__Group__0__Impl rule__AndCondition__Group__1 )
            // InternalIfictiondsl.g:2263:2: rule__AndCondition__Group__0__Impl rule__AndCondition__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__AndCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndCondition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__Group__0"


    // $ANTLR start "rule__AndCondition__Group__0__Impl"
    // InternalIfictiondsl.g:2270:1: rule__AndCondition__Group__0__Impl : ( rulePrimary ) ;
    public final void rule__AndCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2274:1: ( ( rulePrimary ) )
            // InternalIfictiondsl.g:2275:1: ( rulePrimary )
            {
            // InternalIfictiondsl.g:2275:1: ( rulePrimary )
            // InternalIfictiondsl.g:2276:2: rulePrimary
            {
             before(grammarAccess.getAndConditionAccess().getPrimaryParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getAndConditionAccess().getPrimaryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__Group__0__Impl"


    // $ANTLR start "rule__AndCondition__Group__1"
    // InternalIfictiondsl.g:2285:1: rule__AndCondition__Group__1 : rule__AndCondition__Group__1__Impl ;
    public final void rule__AndCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2289:1: ( rule__AndCondition__Group__1__Impl )
            // InternalIfictiondsl.g:2290:2: rule__AndCondition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndCondition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__Group__1"


    // $ANTLR start "rule__AndCondition__Group__1__Impl"
    // InternalIfictiondsl.g:2296:1: rule__AndCondition__Group__1__Impl : ( ( rule__AndCondition__Group_1__0 )* ) ;
    public final void rule__AndCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2300:1: ( ( ( rule__AndCondition__Group_1__0 )* ) )
            // InternalIfictiondsl.g:2301:1: ( ( rule__AndCondition__Group_1__0 )* )
            {
            // InternalIfictiondsl.g:2301:1: ( ( rule__AndCondition__Group_1__0 )* )
            // InternalIfictiondsl.g:2302:2: ( rule__AndCondition__Group_1__0 )*
            {
             before(grammarAccess.getAndConditionAccess().getGroup_1()); 
            // InternalIfictiondsl.g:2303:2: ( rule__AndCondition__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==37) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalIfictiondsl.g:2303:3: rule__AndCondition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__AndCondition__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getAndConditionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__Group__1__Impl"


    // $ANTLR start "rule__AndCondition__Group_1__0"
    // InternalIfictiondsl.g:2312:1: rule__AndCondition__Group_1__0 : rule__AndCondition__Group_1__0__Impl rule__AndCondition__Group_1__1 ;
    public final void rule__AndCondition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2316:1: ( rule__AndCondition__Group_1__0__Impl rule__AndCondition__Group_1__1 )
            // InternalIfictiondsl.g:2317:2: rule__AndCondition__Group_1__0__Impl rule__AndCondition__Group_1__1
            {
            pushFollow(FOLLOW_25);
            rule__AndCondition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndCondition__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__Group_1__0"


    // $ANTLR start "rule__AndCondition__Group_1__0__Impl"
    // InternalIfictiondsl.g:2324:1: rule__AndCondition__Group_1__0__Impl : ( () ) ;
    public final void rule__AndCondition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2328:1: ( ( () ) )
            // InternalIfictiondsl.g:2329:1: ( () )
            {
            // InternalIfictiondsl.g:2329:1: ( () )
            // InternalIfictiondsl.g:2330:2: ()
            {
             before(grammarAccess.getAndConditionAccess().getAndLeftAction_1_0()); 
            // InternalIfictiondsl.g:2331:2: ()
            // InternalIfictiondsl.g:2331:3: 
            {
            }

             after(grammarAccess.getAndConditionAccess().getAndLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__Group_1__0__Impl"


    // $ANTLR start "rule__AndCondition__Group_1__1"
    // InternalIfictiondsl.g:2339:1: rule__AndCondition__Group_1__1 : rule__AndCondition__Group_1__1__Impl rule__AndCondition__Group_1__2 ;
    public final void rule__AndCondition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2343:1: ( rule__AndCondition__Group_1__1__Impl rule__AndCondition__Group_1__2 )
            // InternalIfictiondsl.g:2344:2: rule__AndCondition__Group_1__1__Impl rule__AndCondition__Group_1__2
            {
            pushFollow(FOLLOW_22);
            rule__AndCondition__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndCondition__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__Group_1__1"


    // $ANTLR start "rule__AndCondition__Group_1__1__Impl"
    // InternalIfictiondsl.g:2351:1: rule__AndCondition__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__AndCondition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2355:1: ( ( 'and' ) )
            // InternalIfictiondsl.g:2356:1: ( 'and' )
            {
            // InternalIfictiondsl.g:2356:1: ( 'and' )
            // InternalIfictiondsl.g:2357:2: 'and'
            {
             before(grammarAccess.getAndConditionAccess().getAndKeyword_1_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getAndConditionAccess().getAndKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__Group_1__1__Impl"


    // $ANTLR start "rule__AndCondition__Group_1__2"
    // InternalIfictiondsl.g:2366:1: rule__AndCondition__Group_1__2 : rule__AndCondition__Group_1__2__Impl ;
    public final void rule__AndCondition__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2370:1: ( rule__AndCondition__Group_1__2__Impl )
            // InternalIfictiondsl.g:2371:2: rule__AndCondition__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndCondition__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__Group_1__2"


    // $ANTLR start "rule__AndCondition__Group_1__2__Impl"
    // InternalIfictiondsl.g:2377:1: rule__AndCondition__Group_1__2__Impl : ( ( rule__AndCondition__RightAssignment_1_2 ) ) ;
    public final void rule__AndCondition__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2381:1: ( ( ( rule__AndCondition__RightAssignment_1_2 ) ) )
            // InternalIfictiondsl.g:2382:1: ( ( rule__AndCondition__RightAssignment_1_2 ) )
            {
            // InternalIfictiondsl.g:2382:1: ( ( rule__AndCondition__RightAssignment_1_2 ) )
            // InternalIfictiondsl.g:2383:2: ( rule__AndCondition__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndConditionAccess().getRightAssignment_1_2()); 
            // InternalIfictiondsl.g:2384:2: ( rule__AndCondition__RightAssignment_1_2 )
            // InternalIfictiondsl.g:2384:3: rule__AndCondition__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__AndCondition__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndConditionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__Group_1__2__Impl"


    // $ANTLR start "rule__Primary__Group_0__0"
    // InternalIfictiondsl.g:2393:1: rule__Primary__Group_0__0 : rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1 ;
    public final void rule__Primary__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2397:1: ( rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1 )
            // InternalIfictiondsl.g:2398:2: rule__Primary__Group_0__0__Impl rule__Primary__Group_0__1
            {
            pushFollow(FOLLOW_22);
            rule__Primary__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__0"


    // $ANTLR start "rule__Primary__Group_0__0__Impl"
    // InternalIfictiondsl.g:2405:1: rule__Primary__Group_0__0__Impl : ( '(' ) ;
    public final void rule__Primary__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2409:1: ( ( '(' ) )
            // InternalIfictiondsl.g:2410:1: ( '(' )
            {
            // InternalIfictiondsl.g:2410:1: ( '(' )
            // InternalIfictiondsl.g:2411:2: '('
            {
             before(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__0__Impl"


    // $ANTLR start "rule__Primary__Group_0__1"
    // InternalIfictiondsl.g:2420:1: rule__Primary__Group_0__1 : rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2 ;
    public final void rule__Primary__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2424:1: ( rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2 )
            // InternalIfictiondsl.g:2425:2: rule__Primary__Group_0__1__Impl rule__Primary__Group_0__2
            {
            pushFollow(FOLLOW_27);
            rule__Primary__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__1"


    // $ANTLR start "rule__Primary__Group_0__1__Impl"
    // InternalIfictiondsl.g:2432:1: rule__Primary__Group_0__1__Impl : ( ruleCondition ) ;
    public final void rule__Primary__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2436:1: ( ( ruleCondition ) )
            // InternalIfictiondsl.g:2437:1: ( ruleCondition )
            {
            // InternalIfictiondsl.g:2437:1: ( ruleCondition )
            // InternalIfictiondsl.g:2438:2: ruleCondition
            {
             before(grammarAccess.getPrimaryAccess().getConditionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getConditionParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__1__Impl"


    // $ANTLR start "rule__Primary__Group_0__2"
    // InternalIfictiondsl.g:2447:1: rule__Primary__Group_0__2 : rule__Primary__Group_0__2__Impl ;
    public final void rule__Primary__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2451:1: ( rule__Primary__Group_0__2__Impl )
            // InternalIfictiondsl.g:2452:2: rule__Primary__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__2"


    // $ANTLR start "rule__Primary__Group_0__2__Impl"
    // InternalIfictiondsl.g:2458:1: rule__Primary__Group_0__2__Impl : ( ')' ) ;
    public final void rule__Primary__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2462:1: ( ( ')' ) )
            // InternalIfictiondsl.g:2463:1: ( ')' )
            {
            // InternalIfictiondsl.g:2463:1: ( ')' )
            // InternalIfictiondsl.g:2464:2: ')'
            {
             before(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_0__2__Impl"


    // $ANTLR start "rule__Comparison__Group__0"
    // InternalIfictiondsl.g:2474:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2478:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // InternalIfictiondsl.g:2479:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__Comparison__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Comparison__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0"


    // $ANTLR start "rule__Comparison__Group__0__Impl"
    // InternalIfictiondsl.g:2486:1: rule__Comparison__Group__0__Impl : ( ( rule__Comparison__VariableAssignment_0 ) ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2490:1: ( ( ( rule__Comparison__VariableAssignment_0 ) ) )
            // InternalIfictiondsl.g:2491:1: ( ( rule__Comparison__VariableAssignment_0 ) )
            {
            // InternalIfictiondsl.g:2491:1: ( ( rule__Comparison__VariableAssignment_0 ) )
            // InternalIfictiondsl.g:2492:2: ( rule__Comparison__VariableAssignment_0 )
            {
             before(grammarAccess.getComparisonAccess().getVariableAssignment_0()); 
            // InternalIfictiondsl.g:2493:2: ( rule__Comparison__VariableAssignment_0 )
            // InternalIfictiondsl.g:2493:3: rule__Comparison__VariableAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__VariableAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getVariableAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0__Impl"


    // $ANTLR start "rule__Comparison__Group__1"
    // InternalIfictiondsl.g:2501:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl rule__Comparison__Group__2 ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2505:1: ( rule__Comparison__Group__1__Impl rule__Comparison__Group__2 )
            // InternalIfictiondsl.g:2506:2: rule__Comparison__Group__1__Impl rule__Comparison__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__Comparison__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Comparison__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1"


    // $ANTLR start "rule__Comparison__Group__1__Impl"
    // InternalIfictiondsl.g:2513:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__OperatorAssignment_1 ) ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2517:1: ( ( ( rule__Comparison__OperatorAssignment_1 ) ) )
            // InternalIfictiondsl.g:2518:1: ( ( rule__Comparison__OperatorAssignment_1 ) )
            {
            // InternalIfictiondsl.g:2518:1: ( ( rule__Comparison__OperatorAssignment_1 ) )
            // InternalIfictiondsl.g:2519:2: ( rule__Comparison__OperatorAssignment_1 )
            {
             before(grammarAccess.getComparisonAccess().getOperatorAssignment_1()); 
            // InternalIfictiondsl.g:2520:2: ( rule__Comparison__OperatorAssignment_1 )
            // InternalIfictiondsl.g:2520:3: rule__Comparison__OperatorAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__OperatorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getOperatorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1__Impl"


    // $ANTLR start "rule__Comparison__Group__2"
    // InternalIfictiondsl.g:2528:1: rule__Comparison__Group__2 : rule__Comparison__Group__2__Impl ;
    public final void rule__Comparison__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2532:1: ( rule__Comparison__Group__2__Impl )
            // InternalIfictiondsl.g:2533:2: rule__Comparison__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__2"


    // $ANTLR start "rule__Comparison__Group__2__Impl"
    // InternalIfictiondsl.g:2539:1: rule__Comparison__Group__2__Impl : ( ( rule__Comparison__ValueAssignment_2 ) ) ;
    public final void rule__Comparison__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2543:1: ( ( ( rule__Comparison__ValueAssignment_2 ) ) )
            // InternalIfictiondsl.g:2544:1: ( ( rule__Comparison__ValueAssignment_2 ) )
            {
            // InternalIfictiondsl.g:2544:1: ( ( rule__Comparison__ValueAssignment_2 ) )
            // InternalIfictiondsl.g:2545:2: ( rule__Comparison__ValueAssignment_2 )
            {
             before(grammarAccess.getComparisonAccess().getValueAssignment_2()); 
            // InternalIfictiondsl.g:2546:2: ( rule__Comparison__ValueAssignment_2 )
            // InternalIfictiondsl.g:2546:3: rule__Comparison__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__2__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__0"
    // InternalIfictiondsl.g:2555:1: rule__SystemStateChangeNode__Group__0 : rule__SystemStateChangeNode__Group__0__Impl rule__SystemStateChangeNode__Group__1 ;
    public final void rule__SystemStateChangeNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2559:1: ( rule__SystemStateChangeNode__Group__0__Impl rule__SystemStateChangeNode__Group__1 )
            // InternalIfictiondsl.g:2560:2: rule__SystemStateChangeNode__Group__0__Impl rule__SystemStateChangeNode__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__SystemStateChangeNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__0"


    // $ANTLR start "rule__SystemStateChangeNode__Group__0__Impl"
    // InternalIfictiondsl.g:2567:1: rule__SystemStateChangeNode__Group__0__Impl : ( 'SystemStateChangeNode' ) ;
    public final void rule__SystemStateChangeNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2571:1: ( ( 'SystemStateChangeNode' ) )
            // InternalIfictiondsl.g:2572:1: ( 'SystemStateChangeNode' )
            {
            // InternalIfictiondsl.g:2572:1: ( 'SystemStateChangeNode' )
            // InternalIfictiondsl.g:2573:2: 'SystemStateChangeNode'
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getSystemStateChangeNodeKeyword_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getSystemStateChangeNodeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__0__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__1"
    // InternalIfictiondsl.g:2582:1: rule__SystemStateChangeNode__Group__1 : rule__SystemStateChangeNode__Group__1__Impl rule__SystemStateChangeNode__Group__2 ;
    public final void rule__SystemStateChangeNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2586:1: ( rule__SystemStateChangeNode__Group__1__Impl rule__SystemStateChangeNode__Group__2 )
            // InternalIfictiondsl.g:2587:2: rule__SystemStateChangeNode__Group__1__Impl rule__SystemStateChangeNode__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__SystemStateChangeNode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__1"


    // $ANTLR start "rule__SystemStateChangeNode__Group__1__Impl"
    // InternalIfictiondsl.g:2594:1: rule__SystemStateChangeNode__Group__1__Impl : ( ( rule__SystemStateChangeNode__NameAssignment_1 ) ) ;
    public final void rule__SystemStateChangeNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2598:1: ( ( ( rule__SystemStateChangeNode__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:2599:1: ( ( rule__SystemStateChangeNode__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:2599:1: ( ( rule__SystemStateChangeNode__NameAssignment_1 ) )
            // InternalIfictiondsl.g:2600:2: ( rule__SystemStateChangeNode__NameAssignment_1 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:2601:2: ( rule__SystemStateChangeNode__NameAssignment_1 )
            // InternalIfictiondsl.g:2601:3: rule__SystemStateChangeNode__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__1__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__2"
    // InternalIfictiondsl.g:2609:1: rule__SystemStateChangeNode__Group__2 : rule__SystemStateChangeNode__Group__2__Impl rule__SystemStateChangeNode__Group__3 ;
    public final void rule__SystemStateChangeNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2613:1: ( rule__SystemStateChangeNode__Group__2__Impl rule__SystemStateChangeNode__Group__3 )
            // InternalIfictiondsl.g:2614:2: rule__SystemStateChangeNode__Group__2__Impl rule__SystemStateChangeNode__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__SystemStateChangeNode__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__2"


    // $ANTLR start "rule__SystemStateChangeNode__Group__2__Impl"
    // InternalIfictiondsl.g:2621:1: rule__SystemStateChangeNode__Group__2__Impl : ( '{' ) ;
    public final void rule__SystemStateChangeNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2625:1: ( ( '{' ) )
            // InternalIfictiondsl.g:2626:1: ( '{' )
            {
            // InternalIfictiondsl.g:2626:1: ( '{' )
            // InternalIfictiondsl.g:2627:2: '{'
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__2__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__3"
    // InternalIfictiondsl.g:2636:1: rule__SystemStateChangeNode__Group__3 : rule__SystemStateChangeNode__Group__3__Impl rule__SystemStateChangeNode__Group__4 ;
    public final void rule__SystemStateChangeNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2640:1: ( rule__SystemStateChangeNode__Group__3__Impl rule__SystemStateChangeNode__Group__4 )
            // InternalIfictiondsl.g:2641:2: rule__SystemStateChangeNode__Group__3__Impl rule__SystemStateChangeNode__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__SystemStateChangeNode__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__3"


    // $ANTLR start "rule__SystemStateChangeNode__Group__3__Impl"
    // InternalIfictiondsl.g:2648:1: rule__SystemStateChangeNode__Group__3__Impl : ( 'displayText' ) ;
    public final void rule__SystemStateChangeNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2652:1: ( ( 'displayText' ) )
            // InternalIfictiondsl.g:2653:1: ( 'displayText' )
            {
            // InternalIfictiondsl.g:2653:1: ( 'displayText' )
            // InternalIfictiondsl.g:2654:2: 'displayText'
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getDisplayTextKeyword_3()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getDisplayTextKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__3__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__4"
    // InternalIfictiondsl.g:2663:1: rule__SystemStateChangeNode__Group__4 : rule__SystemStateChangeNode__Group__4__Impl rule__SystemStateChangeNode__Group__5 ;
    public final void rule__SystemStateChangeNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2667:1: ( rule__SystemStateChangeNode__Group__4__Impl rule__SystemStateChangeNode__Group__5 )
            // InternalIfictiondsl.g:2668:2: rule__SystemStateChangeNode__Group__4__Impl rule__SystemStateChangeNode__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__SystemStateChangeNode__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__4"


    // $ANTLR start "rule__SystemStateChangeNode__Group__4__Impl"
    // InternalIfictiondsl.g:2675:1: rule__SystemStateChangeNode__Group__4__Impl : ( ':' ) ;
    public final void rule__SystemStateChangeNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2679:1: ( ( ':' ) )
            // InternalIfictiondsl.g:2680:1: ( ':' )
            {
            // InternalIfictiondsl.g:2680:1: ( ':' )
            // InternalIfictiondsl.g:2681:2: ':'
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getColonKeyword_4()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__4__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__5"
    // InternalIfictiondsl.g:2690:1: rule__SystemStateChangeNode__Group__5 : rule__SystemStateChangeNode__Group__5__Impl rule__SystemStateChangeNode__Group__6 ;
    public final void rule__SystemStateChangeNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2694:1: ( rule__SystemStateChangeNode__Group__5__Impl rule__SystemStateChangeNode__Group__6 )
            // InternalIfictiondsl.g:2695:2: rule__SystemStateChangeNode__Group__5__Impl rule__SystemStateChangeNode__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__SystemStateChangeNode__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__5"


    // $ANTLR start "rule__SystemStateChangeNode__Group__5__Impl"
    // InternalIfictiondsl.g:2702:1: rule__SystemStateChangeNode__Group__5__Impl : ( ( rule__SystemStateChangeNode__TextAssignment_5 ) ) ;
    public final void rule__SystemStateChangeNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2706:1: ( ( ( rule__SystemStateChangeNode__TextAssignment_5 ) ) )
            // InternalIfictiondsl.g:2707:1: ( ( rule__SystemStateChangeNode__TextAssignment_5 ) )
            {
            // InternalIfictiondsl.g:2707:1: ( ( rule__SystemStateChangeNode__TextAssignment_5 ) )
            // InternalIfictiondsl.g:2708:2: ( rule__SystemStateChangeNode__TextAssignment_5 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getTextAssignment_5()); 
            // InternalIfictiondsl.g:2709:2: ( rule__SystemStateChangeNode__TextAssignment_5 )
            // InternalIfictiondsl.g:2709:3: rule__SystemStateChangeNode__TextAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__TextAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getTextAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__5__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__6"
    // InternalIfictiondsl.g:2717:1: rule__SystemStateChangeNode__Group__6 : rule__SystemStateChangeNode__Group__6__Impl rule__SystemStateChangeNode__Group__7 ;
    public final void rule__SystemStateChangeNode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2721:1: ( rule__SystemStateChangeNode__Group__6__Impl rule__SystemStateChangeNode__Group__7 )
            // InternalIfictiondsl.g:2722:2: rule__SystemStateChangeNode__Group__6__Impl rule__SystemStateChangeNode__Group__7
            {
            pushFollow(FOLLOW_16);
            rule__SystemStateChangeNode__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__6"


    // $ANTLR start "rule__SystemStateChangeNode__Group__6__Impl"
    // InternalIfictiondsl.g:2729:1: rule__SystemStateChangeNode__Group__6__Impl : ( ',' ) ;
    public final void rule__SystemStateChangeNode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2733:1: ( ( ',' ) )
            // InternalIfictiondsl.g:2734:1: ( ',' )
            {
            // InternalIfictiondsl.g:2734:1: ( ',' )
            // InternalIfictiondsl.g:2735:2: ','
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getCommaKeyword_6()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getCommaKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__6__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__7"
    // InternalIfictiondsl.g:2744:1: rule__SystemStateChangeNode__Group__7 : rule__SystemStateChangeNode__Group__7__Impl rule__SystemStateChangeNode__Group__8 ;
    public final void rule__SystemStateChangeNode__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2748:1: ( rule__SystemStateChangeNode__Group__7__Impl rule__SystemStateChangeNode__Group__8 )
            // InternalIfictiondsl.g:2749:2: rule__SystemStateChangeNode__Group__7__Impl rule__SystemStateChangeNode__Group__8
            {
            pushFollow(FOLLOW_29);
            rule__SystemStateChangeNode__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__7"


    // $ANTLR start "rule__SystemStateChangeNode__Group__7__Impl"
    // InternalIfictiondsl.g:2756:1: rule__SystemStateChangeNode__Group__7__Impl : ( ( rule__SystemStateChangeNode__StateUpdatesAssignment_7 ) ) ;
    public final void rule__SystemStateChangeNode__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2760:1: ( ( ( rule__SystemStateChangeNode__StateUpdatesAssignment_7 ) ) )
            // InternalIfictiondsl.g:2761:1: ( ( rule__SystemStateChangeNode__StateUpdatesAssignment_7 ) )
            {
            // InternalIfictiondsl.g:2761:1: ( ( rule__SystemStateChangeNode__StateUpdatesAssignment_7 ) )
            // InternalIfictiondsl.g:2762:2: ( rule__SystemStateChangeNode__StateUpdatesAssignment_7 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getStateUpdatesAssignment_7()); 
            // InternalIfictiondsl.g:2763:2: ( rule__SystemStateChangeNode__StateUpdatesAssignment_7 )
            // InternalIfictiondsl.g:2763:3: rule__SystemStateChangeNode__StateUpdatesAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__StateUpdatesAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getStateUpdatesAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__7__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__8"
    // InternalIfictiondsl.g:2771:1: rule__SystemStateChangeNode__Group__8 : rule__SystemStateChangeNode__Group__8__Impl rule__SystemStateChangeNode__Group__9 ;
    public final void rule__SystemStateChangeNode__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2775:1: ( rule__SystemStateChangeNode__Group__8__Impl rule__SystemStateChangeNode__Group__9 )
            // InternalIfictiondsl.g:2776:2: rule__SystemStateChangeNode__Group__8__Impl rule__SystemStateChangeNode__Group__9
            {
            pushFollow(FOLLOW_29);
            rule__SystemStateChangeNode__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__8"


    // $ANTLR start "rule__SystemStateChangeNode__Group__8__Impl"
    // InternalIfictiondsl.g:2783:1: rule__SystemStateChangeNode__Group__8__Impl : ( ( rule__SystemStateChangeNode__Group_8__0 )* ) ;
    public final void rule__SystemStateChangeNode__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2787:1: ( ( ( rule__SystemStateChangeNode__Group_8__0 )* ) )
            // InternalIfictiondsl.g:2788:1: ( ( rule__SystemStateChangeNode__Group_8__0 )* )
            {
            // InternalIfictiondsl.g:2788:1: ( ( rule__SystemStateChangeNode__Group_8__0 )* )
            // InternalIfictiondsl.g:2789:2: ( rule__SystemStateChangeNode__Group_8__0 )*
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getGroup_8()); 
            // InternalIfictiondsl.g:2790:2: ( rule__SystemStateChangeNode__Group_8__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==27) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalIfictiondsl.g:2790:3: rule__SystemStateChangeNode__Group_8__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__SystemStateChangeNode__Group_8__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getSystemStateChangeNodeAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__8__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__9"
    // InternalIfictiondsl.g:2798:1: rule__SystemStateChangeNode__Group__9 : rule__SystemStateChangeNode__Group__9__Impl rule__SystemStateChangeNode__Group__10 ;
    public final void rule__SystemStateChangeNode__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2802:1: ( rule__SystemStateChangeNode__Group__9__Impl rule__SystemStateChangeNode__Group__10 )
            // InternalIfictiondsl.g:2803:2: rule__SystemStateChangeNode__Group__9__Impl rule__SystemStateChangeNode__Group__10
            {
            pushFollow(FOLLOW_11);
            rule__SystemStateChangeNode__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__9"


    // $ANTLR start "rule__SystemStateChangeNode__Group__9__Impl"
    // InternalIfictiondsl.g:2810:1: rule__SystemStateChangeNode__Group__9__Impl : ( ( rule__SystemStateChangeNode__TransitionAssignment_9 ) ) ;
    public final void rule__SystemStateChangeNode__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2814:1: ( ( ( rule__SystemStateChangeNode__TransitionAssignment_9 ) ) )
            // InternalIfictiondsl.g:2815:1: ( ( rule__SystemStateChangeNode__TransitionAssignment_9 ) )
            {
            // InternalIfictiondsl.g:2815:1: ( ( rule__SystemStateChangeNode__TransitionAssignment_9 ) )
            // InternalIfictiondsl.g:2816:2: ( rule__SystemStateChangeNode__TransitionAssignment_9 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getTransitionAssignment_9()); 
            // InternalIfictiondsl.g:2817:2: ( rule__SystemStateChangeNode__TransitionAssignment_9 )
            // InternalIfictiondsl.g:2817:3: rule__SystemStateChangeNode__TransitionAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__TransitionAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getTransitionAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__9__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__10"
    // InternalIfictiondsl.g:2825:1: rule__SystemStateChangeNode__Group__10 : rule__SystemStateChangeNode__Group__10__Impl ;
    public final void rule__SystemStateChangeNode__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2829:1: ( rule__SystemStateChangeNode__Group__10__Impl )
            // InternalIfictiondsl.g:2830:2: rule__SystemStateChangeNode__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__10"


    // $ANTLR start "rule__SystemStateChangeNode__Group__10__Impl"
    // InternalIfictiondsl.g:2836:1: rule__SystemStateChangeNode__Group__10__Impl : ( '}' ) ;
    public final void rule__SystemStateChangeNode__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2840:1: ( ( '}' ) )
            // InternalIfictiondsl.g:2841:1: ( '}' )
            {
            // InternalIfictiondsl.g:2841:1: ( '}' )
            // InternalIfictiondsl.g:2842:2: '}'
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getRightCurlyBracketKeyword_10()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group__10__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group_8__0"
    // InternalIfictiondsl.g:2852:1: rule__SystemStateChangeNode__Group_8__0 : rule__SystemStateChangeNode__Group_8__0__Impl rule__SystemStateChangeNode__Group_8__1 ;
    public final void rule__SystemStateChangeNode__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2856:1: ( rule__SystemStateChangeNode__Group_8__0__Impl rule__SystemStateChangeNode__Group_8__1 )
            // InternalIfictiondsl.g:2857:2: rule__SystemStateChangeNode__Group_8__0__Impl rule__SystemStateChangeNode__Group_8__1
            {
            pushFollow(FOLLOW_16);
            rule__SystemStateChangeNode__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group_8__0"


    // $ANTLR start "rule__SystemStateChangeNode__Group_8__0__Impl"
    // InternalIfictiondsl.g:2864:1: rule__SystemStateChangeNode__Group_8__0__Impl : ( ',' ) ;
    public final void rule__SystemStateChangeNode__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2868:1: ( ( ',' ) )
            // InternalIfictiondsl.g:2869:1: ( ',' )
            {
            // InternalIfictiondsl.g:2869:1: ( ',' )
            // InternalIfictiondsl.g:2870:2: ','
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getCommaKeyword_8_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getCommaKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group_8__0__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group_8__1"
    // InternalIfictiondsl.g:2879:1: rule__SystemStateChangeNode__Group_8__1 : rule__SystemStateChangeNode__Group_8__1__Impl ;
    public final void rule__SystemStateChangeNode__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2883:1: ( rule__SystemStateChangeNode__Group_8__1__Impl )
            // InternalIfictiondsl.g:2884:2: rule__SystemStateChangeNode__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group_8__1"


    // $ANTLR start "rule__SystemStateChangeNode__Group_8__1__Impl"
    // InternalIfictiondsl.g:2890:1: rule__SystemStateChangeNode__Group_8__1__Impl : ( ( rule__SystemStateChangeNode__StateUpdatesAssignment_8_1 ) ) ;
    public final void rule__SystemStateChangeNode__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2894:1: ( ( ( rule__SystemStateChangeNode__StateUpdatesAssignment_8_1 ) ) )
            // InternalIfictiondsl.g:2895:1: ( ( rule__SystemStateChangeNode__StateUpdatesAssignment_8_1 ) )
            {
            // InternalIfictiondsl.g:2895:1: ( ( rule__SystemStateChangeNode__StateUpdatesAssignment_8_1 ) )
            // InternalIfictiondsl.g:2896:2: ( rule__SystemStateChangeNode__StateUpdatesAssignment_8_1 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getStateUpdatesAssignment_8_1()); 
            // InternalIfictiondsl.g:2897:2: ( rule__SystemStateChangeNode__StateUpdatesAssignment_8_1 )
            // InternalIfictiondsl.g:2897:3: rule__SystemStateChangeNode__StateUpdatesAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__StateUpdatesAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getStateUpdatesAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__Group_8__1__Impl"


    // $ANTLR start "rule__StateUpdate__Group__0"
    // InternalIfictiondsl.g:2906:1: rule__StateUpdate__Group__0 : rule__StateUpdate__Group__0__Impl rule__StateUpdate__Group__1 ;
    public final void rule__StateUpdate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2910:1: ( rule__StateUpdate__Group__0__Impl rule__StateUpdate__Group__1 )
            // InternalIfictiondsl.g:2911:2: rule__StateUpdate__Group__0__Impl rule__StateUpdate__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__StateUpdate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StateUpdate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateUpdate__Group__0"


    // $ANTLR start "rule__StateUpdate__Group__0__Impl"
    // InternalIfictiondsl.g:2918:1: rule__StateUpdate__Group__0__Impl : ( ( rule__StateUpdate__VariableAssignment_0 ) ) ;
    public final void rule__StateUpdate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2922:1: ( ( ( rule__StateUpdate__VariableAssignment_0 ) ) )
            // InternalIfictiondsl.g:2923:1: ( ( rule__StateUpdate__VariableAssignment_0 ) )
            {
            // InternalIfictiondsl.g:2923:1: ( ( rule__StateUpdate__VariableAssignment_0 ) )
            // InternalIfictiondsl.g:2924:2: ( rule__StateUpdate__VariableAssignment_0 )
            {
             before(grammarAccess.getStateUpdateAccess().getVariableAssignment_0()); 
            // InternalIfictiondsl.g:2925:2: ( rule__StateUpdate__VariableAssignment_0 )
            // InternalIfictiondsl.g:2925:3: rule__StateUpdate__VariableAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__StateUpdate__VariableAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getStateUpdateAccess().getVariableAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateUpdate__Group__0__Impl"


    // $ANTLR start "rule__StateUpdate__Group__1"
    // InternalIfictiondsl.g:2933:1: rule__StateUpdate__Group__1 : rule__StateUpdate__Group__1__Impl rule__StateUpdate__Group__2 ;
    public final void rule__StateUpdate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2937:1: ( rule__StateUpdate__Group__1__Impl rule__StateUpdate__Group__2 )
            // InternalIfictiondsl.g:2938:2: rule__StateUpdate__Group__1__Impl rule__StateUpdate__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__StateUpdate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StateUpdate__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateUpdate__Group__1"


    // $ANTLR start "rule__StateUpdate__Group__1__Impl"
    // InternalIfictiondsl.g:2945:1: rule__StateUpdate__Group__1__Impl : ( ( rule__StateUpdate__OperatorAssignment_1 ) ) ;
    public final void rule__StateUpdate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2949:1: ( ( ( rule__StateUpdate__OperatorAssignment_1 ) ) )
            // InternalIfictiondsl.g:2950:1: ( ( rule__StateUpdate__OperatorAssignment_1 ) )
            {
            // InternalIfictiondsl.g:2950:1: ( ( rule__StateUpdate__OperatorAssignment_1 ) )
            // InternalIfictiondsl.g:2951:2: ( rule__StateUpdate__OperatorAssignment_1 )
            {
             before(grammarAccess.getStateUpdateAccess().getOperatorAssignment_1()); 
            // InternalIfictiondsl.g:2952:2: ( rule__StateUpdate__OperatorAssignment_1 )
            // InternalIfictiondsl.g:2952:3: rule__StateUpdate__OperatorAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__StateUpdate__OperatorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStateUpdateAccess().getOperatorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateUpdate__Group__1__Impl"


    // $ANTLR start "rule__StateUpdate__Group__2"
    // InternalIfictiondsl.g:2960:1: rule__StateUpdate__Group__2 : rule__StateUpdate__Group__2__Impl ;
    public final void rule__StateUpdate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2964:1: ( rule__StateUpdate__Group__2__Impl )
            // InternalIfictiondsl.g:2965:2: rule__StateUpdate__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StateUpdate__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateUpdate__Group__2"


    // $ANTLR start "rule__StateUpdate__Group__2__Impl"
    // InternalIfictiondsl.g:2971:1: rule__StateUpdate__Group__2__Impl : ( ( rule__StateUpdate__ValueAssignment_2 ) ) ;
    public final void rule__StateUpdate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2975:1: ( ( ( rule__StateUpdate__ValueAssignment_2 ) ) )
            // InternalIfictiondsl.g:2976:1: ( ( rule__StateUpdate__ValueAssignment_2 ) )
            {
            // InternalIfictiondsl.g:2976:1: ( ( rule__StateUpdate__ValueAssignment_2 ) )
            // InternalIfictiondsl.g:2977:2: ( rule__StateUpdate__ValueAssignment_2 )
            {
             before(grammarAccess.getStateUpdateAccess().getValueAssignment_2()); 
            // InternalIfictiondsl.g:2978:2: ( rule__StateUpdate__ValueAssignment_2 )
            // InternalIfictiondsl.g:2978:3: rule__StateUpdate__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__StateUpdate__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStateUpdateAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateUpdate__Group__2__Impl"


    // $ANTLR start "rule__EndNode__Group__0"
    // InternalIfictiondsl.g:2987:1: rule__EndNode__Group__0 : rule__EndNode__Group__0__Impl rule__EndNode__Group__1 ;
    public final void rule__EndNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2991:1: ( rule__EndNode__Group__0__Impl rule__EndNode__Group__1 )
            // InternalIfictiondsl.g:2992:2: rule__EndNode__Group__0__Impl rule__EndNode__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__EndNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EndNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__0"


    // $ANTLR start "rule__EndNode__Group__0__Impl"
    // InternalIfictiondsl.g:2999:1: rule__EndNode__Group__0__Impl : ( 'EndNode' ) ;
    public final void rule__EndNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3003:1: ( ( 'EndNode' ) )
            // InternalIfictiondsl.g:3004:1: ( 'EndNode' )
            {
            // InternalIfictiondsl.g:3004:1: ( 'EndNode' )
            // InternalIfictiondsl.g:3005:2: 'EndNode'
            {
             before(grammarAccess.getEndNodeAccess().getEndNodeKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getEndNodeAccess().getEndNodeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__0__Impl"


    // $ANTLR start "rule__EndNode__Group__1"
    // InternalIfictiondsl.g:3014:1: rule__EndNode__Group__1 : rule__EndNode__Group__1__Impl rule__EndNode__Group__2 ;
    public final void rule__EndNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3018:1: ( rule__EndNode__Group__1__Impl rule__EndNode__Group__2 )
            // InternalIfictiondsl.g:3019:2: rule__EndNode__Group__1__Impl rule__EndNode__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__EndNode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EndNode__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__1"


    // $ANTLR start "rule__EndNode__Group__1__Impl"
    // InternalIfictiondsl.g:3026:1: rule__EndNode__Group__1__Impl : ( ( rule__EndNode__NameAssignment_1 ) ) ;
    public final void rule__EndNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3030:1: ( ( ( rule__EndNode__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:3031:1: ( ( rule__EndNode__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:3031:1: ( ( rule__EndNode__NameAssignment_1 ) )
            // InternalIfictiondsl.g:3032:2: ( rule__EndNode__NameAssignment_1 )
            {
             before(grammarAccess.getEndNodeAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:3033:2: ( rule__EndNode__NameAssignment_1 )
            // InternalIfictiondsl.g:3033:3: rule__EndNode__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EndNode__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEndNodeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__1__Impl"


    // $ANTLR start "rule__EndNode__Group__2"
    // InternalIfictiondsl.g:3041:1: rule__EndNode__Group__2 : rule__EndNode__Group__2__Impl rule__EndNode__Group__3 ;
    public final void rule__EndNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3045:1: ( rule__EndNode__Group__2__Impl rule__EndNode__Group__3 )
            // InternalIfictiondsl.g:3046:2: rule__EndNode__Group__2__Impl rule__EndNode__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__EndNode__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EndNode__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__2"


    // $ANTLR start "rule__EndNode__Group__2__Impl"
    // InternalIfictiondsl.g:3053:1: rule__EndNode__Group__2__Impl : ( '{' ) ;
    public final void rule__EndNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3057:1: ( ( '{' ) )
            // InternalIfictiondsl.g:3058:1: ( '{' )
            {
            // InternalIfictiondsl.g:3058:1: ( '{' )
            // InternalIfictiondsl.g:3059:2: '{'
            {
             before(grammarAccess.getEndNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getEndNodeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__2__Impl"


    // $ANTLR start "rule__EndNode__Group__3"
    // InternalIfictiondsl.g:3068:1: rule__EndNode__Group__3 : rule__EndNode__Group__3__Impl rule__EndNode__Group__4 ;
    public final void rule__EndNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3072:1: ( rule__EndNode__Group__3__Impl rule__EndNode__Group__4 )
            // InternalIfictiondsl.g:3073:2: rule__EndNode__Group__3__Impl rule__EndNode__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__EndNode__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EndNode__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__3"


    // $ANTLR start "rule__EndNode__Group__3__Impl"
    // InternalIfictiondsl.g:3080:1: rule__EndNode__Group__3__Impl : ( 'displayText' ) ;
    public final void rule__EndNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3084:1: ( ( 'displayText' ) )
            // InternalIfictiondsl.g:3085:1: ( 'displayText' )
            {
            // InternalIfictiondsl.g:3085:1: ( 'displayText' )
            // InternalIfictiondsl.g:3086:2: 'displayText'
            {
             before(grammarAccess.getEndNodeAccess().getDisplayTextKeyword_3()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getEndNodeAccess().getDisplayTextKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__3__Impl"


    // $ANTLR start "rule__EndNode__Group__4"
    // InternalIfictiondsl.g:3095:1: rule__EndNode__Group__4 : rule__EndNode__Group__4__Impl rule__EndNode__Group__5 ;
    public final void rule__EndNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3099:1: ( rule__EndNode__Group__4__Impl rule__EndNode__Group__5 )
            // InternalIfictiondsl.g:3100:2: rule__EndNode__Group__4__Impl rule__EndNode__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__EndNode__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EndNode__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__4"


    // $ANTLR start "rule__EndNode__Group__4__Impl"
    // InternalIfictiondsl.g:3107:1: rule__EndNode__Group__4__Impl : ( ':' ) ;
    public final void rule__EndNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3111:1: ( ( ':' ) )
            // InternalIfictiondsl.g:3112:1: ( ':' )
            {
            // InternalIfictiondsl.g:3112:1: ( ':' )
            // InternalIfictiondsl.g:3113:2: ':'
            {
             before(grammarAccess.getEndNodeAccess().getColonKeyword_4()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getEndNodeAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__4__Impl"


    // $ANTLR start "rule__EndNode__Group__5"
    // InternalIfictiondsl.g:3122:1: rule__EndNode__Group__5 : rule__EndNode__Group__5__Impl rule__EndNode__Group__6 ;
    public final void rule__EndNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3126:1: ( rule__EndNode__Group__5__Impl rule__EndNode__Group__6 )
            // InternalIfictiondsl.g:3127:2: rule__EndNode__Group__5__Impl rule__EndNode__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__EndNode__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EndNode__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__5"


    // $ANTLR start "rule__EndNode__Group__5__Impl"
    // InternalIfictiondsl.g:3134:1: rule__EndNode__Group__5__Impl : ( ( rule__EndNode__TextAssignment_5 ) ) ;
    public final void rule__EndNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3138:1: ( ( ( rule__EndNode__TextAssignment_5 ) ) )
            // InternalIfictiondsl.g:3139:1: ( ( rule__EndNode__TextAssignment_5 ) )
            {
            // InternalIfictiondsl.g:3139:1: ( ( rule__EndNode__TextAssignment_5 ) )
            // InternalIfictiondsl.g:3140:2: ( rule__EndNode__TextAssignment_5 )
            {
             before(grammarAccess.getEndNodeAccess().getTextAssignment_5()); 
            // InternalIfictiondsl.g:3141:2: ( rule__EndNode__TextAssignment_5 )
            // InternalIfictiondsl.g:3141:3: rule__EndNode__TextAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__EndNode__TextAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEndNodeAccess().getTextAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__5__Impl"


    // $ANTLR start "rule__EndNode__Group__6"
    // InternalIfictiondsl.g:3149:1: rule__EndNode__Group__6 : rule__EndNode__Group__6__Impl ;
    public final void rule__EndNode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3153:1: ( rule__EndNode__Group__6__Impl )
            // InternalIfictiondsl.g:3154:2: rule__EndNode__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EndNode__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__6"


    // $ANTLR start "rule__EndNode__Group__6__Impl"
    // InternalIfictiondsl.g:3160:1: rule__EndNode__Group__6__Impl : ( '}' ) ;
    public final void rule__EndNode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3164:1: ( ( '}' ) )
            // InternalIfictiondsl.g:3165:1: ( '}' )
            {
            // InternalIfictiondsl.g:3165:1: ( '}' )
            // InternalIfictiondsl.g:3166:2: '}'
            {
             before(grammarAccess.getEndNodeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getEndNodeAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__Group__6__Impl"


    // $ANTLR start "rule__Story__NameAssignment_1"
    // InternalIfictiondsl.g:3176:1: rule__Story__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Story__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3180:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:3181:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:3181:2: ( RULE_ID )
            // InternalIfictiondsl.g:3182:3: RULE_ID
            {
             before(grammarAccess.getStoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getStoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__NameAssignment_1"


    // $ANTLR start "rule__Story__NodesAssignment_2"
    // InternalIfictiondsl.g:3191:1: rule__Story__NodesAssignment_2 : ( ruleNode ) ;
    public final void rule__Story__NodesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3195:1: ( ( ruleNode ) )
            // InternalIfictiondsl.g:3196:2: ( ruleNode )
            {
            // InternalIfictiondsl.g:3196:2: ( ruleNode )
            // InternalIfictiondsl.g:3197:3: ruleNode
            {
             before(grammarAccess.getStoryAccess().getNodesNodeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getStoryAccess().getNodesNodeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__NodesAssignment_2"


    // $ANTLR start "rule__ChoiceNode__NameAssignment_1"
    // InternalIfictiondsl.g:3206:1: rule__ChoiceNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ChoiceNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3210:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:3211:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:3211:2: ( RULE_ID )
            // InternalIfictiondsl.g:3212:3: RULE_ID
            {
             before(grammarAccess.getChoiceNodeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getChoiceNodeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__NameAssignment_1"


    // $ANTLR start "rule__ChoiceNode__OptionsAssignment_6_0"
    // InternalIfictiondsl.g:3221:1: rule__ChoiceNode__OptionsAssignment_6_0 : ( ruleChoiceOption ) ;
    public final void rule__ChoiceNode__OptionsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3225:1: ( ( ruleChoiceOption ) )
            // InternalIfictiondsl.g:3226:2: ( ruleChoiceOption )
            {
            // InternalIfictiondsl.g:3226:2: ( ruleChoiceOption )
            // InternalIfictiondsl.g:3227:3: ruleChoiceOption
            {
             before(grammarAccess.getChoiceNodeAccess().getOptionsChoiceOptionParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_2);
            ruleChoiceOption();

            state._fsp--;

             after(grammarAccess.getChoiceNodeAccess().getOptionsChoiceOptionParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__OptionsAssignment_6_0"


    // $ANTLR start "rule__ChoiceNode__OptionsAssignment_6_1_1"
    // InternalIfictiondsl.g:3236:1: rule__ChoiceNode__OptionsAssignment_6_1_1 : ( ruleChoiceOption ) ;
    public final void rule__ChoiceNode__OptionsAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3240:1: ( ( ruleChoiceOption ) )
            // InternalIfictiondsl.g:3241:2: ( ruleChoiceOption )
            {
            // InternalIfictiondsl.g:3241:2: ( ruleChoiceOption )
            // InternalIfictiondsl.g:3242:3: ruleChoiceOption
            {
             before(grammarAccess.getChoiceNodeAccess().getOptionsChoiceOptionParserRuleCall_6_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleChoiceOption();

            state._fsp--;

             after(grammarAccess.getChoiceNodeAccess().getOptionsChoiceOptionParserRuleCall_6_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceNode__OptionsAssignment_6_1_1"


    // $ANTLR start "rule__ChoiceOption__TextAssignment_4"
    // InternalIfictiondsl.g:3251:1: rule__ChoiceOption__TextAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ChoiceOption__TextAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3255:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:3256:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:3256:2: ( RULE_STRING )
            // InternalIfictiondsl.g:3257:3: RULE_STRING
            {
             before(grammarAccess.getChoiceOptionAccess().getTextSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getChoiceOptionAccess().getTextSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__TextAssignment_4"


    // $ANTLR start "rule__ChoiceOption__TransitionsAssignment_6_0"
    // InternalIfictiondsl.g:3266:1: rule__ChoiceOption__TransitionsAssignment_6_0 : ( ruleTransition ) ;
    public final void rule__ChoiceOption__TransitionsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3270:1: ( ( ruleTransition ) )
            // InternalIfictiondsl.g:3271:2: ( ruleTransition )
            {
            // InternalIfictiondsl.g:3271:2: ( ruleTransition )
            // InternalIfictiondsl.g:3272:3: ruleTransition
            {
             before(grammarAccess.getChoiceOptionAccess().getTransitionsTransitionParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getChoiceOptionAccess().getTransitionsTransitionParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__TransitionsAssignment_6_0"


    // $ANTLR start "rule__ChoiceOption__TransitionsAssignment_6_1_1"
    // InternalIfictiondsl.g:3281:1: rule__ChoiceOption__TransitionsAssignment_6_1_1 : ( ruleTransition ) ;
    public final void rule__ChoiceOption__TransitionsAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3285:1: ( ( ruleTransition ) )
            // InternalIfictiondsl.g:3286:2: ( ruleTransition )
            {
            // InternalIfictiondsl.g:3286:2: ( ruleTransition )
            // InternalIfictiondsl.g:3287:3: ruleTransition
            {
             before(grammarAccess.getChoiceOptionAccess().getTransitionsTransitionParserRuleCall_6_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getChoiceOptionAccess().getTransitionsTransitionParserRuleCall_6_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChoiceOption__TransitionsAssignment_6_1_1"


    // $ANTLR start "rule__Transition__DestinationAssignment_1"
    // InternalIfictiondsl.g:3296:1: rule__Transition__DestinationAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__DestinationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3300:1: ( ( ( RULE_ID ) ) )
            // InternalIfictiondsl.g:3301:2: ( ( RULE_ID ) )
            {
            // InternalIfictiondsl.g:3301:2: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:3302:3: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getDestinationNodeCrossReference_1_0()); 
            // InternalIfictiondsl.g:3303:3: ( RULE_ID )
            // InternalIfictiondsl.g:3304:4: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getDestinationNodeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getDestinationNodeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getDestinationNodeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__DestinationAssignment_1"


    // $ANTLR start "rule__Transition__PriorityAssignment_2_2"
    // InternalIfictiondsl.g:3315:1: rule__Transition__PriorityAssignment_2_2 : ( RULE_INT ) ;
    public final void rule__Transition__PriorityAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3319:1: ( ( RULE_INT ) )
            // InternalIfictiondsl.g:3320:2: ( RULE_INT )
            {
            // InternalIfictiondsl.g:3320:2: ( RULE_INT )
            // InternalIfictiondsl.g:3321:3: RULE_INT
            {
             before(grammarAccess.getTransitionAccess().getPriorityINTTerminalRuleCall_2_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getPriorityINTTerminalRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__PriorityAssignment_2_2"


    // $ANTLR start "rule__Transition__ConditionAssignment_3_3"
    // InternalIfictiondsl.g:3330:1: rule__Transition__ConditionAssignment_3_3 : ( ruleCondition ) ;
    public final void rule__Transition__ConditionAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3334:1: ( ( ruleCondition ) )
            // InternalIfictiondsl.g:3335:2: ( ruleCondition )
            {
            // InternalIfictiondsl.g:3335:2: ( ruleCondition )
            // InternalIfictiondsl.g:3336:3: ruleCondition
            {
             before(grammarAccess.getTransitionAccess().getConditionConditionParserRuleCall_3_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getConditionConditionParserRuleCall_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__ConditionAssignment_3_3"


    // $ANTLR start "rule__StartNode__NameAssignment_1"
    // InternalIfictiondsl.g:3345:1: rule__StartNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__StartNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3349:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:3350:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:3350:2: ( RULE_ID )
            // InternalIfictiondsl.g:3351:3: RULE_ID
            {
             before(grammarAccess.getStartNodeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getStartNodeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__NameAssignment_1"


    // $ANTLR start "rule__StartNode__TextAssignment_5"
    // InternalIfictiondsl.g:3360:1: rule__StartNode__TextAssignment_5 : ( RULE_STRING ) ;
    public final void rule__StartNode__TextAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3364:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:3365:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:3365:2: ( RULE_STRING )
            // InternalIfictiondsl.g:3366:3: RULE_STRING
            {
             before(grammarAccess.getStartNodeAccess().getTextSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getStartNodeAccess().getTextSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__TextAssignment_5"


    // $ANTLR start "rule__StartNode__TransitionAssignment_7"
    // InternalIfictiondsl.g:3375:1: rule__StartNode__TransitionAssignment_7 : ( ruleTransition ) ;
    public final void rule__StartNode__TransitionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3379:1: ( ( ruleTransition ) )
            // InternalIfictiondsl.g:3380:2: ( ruleTransition )
            {
            // InternalIfictiondsl.g:3380:2: ( ruleTransition )
            // InternalIfictiondsl.g:3381:3: ruleTransition
            {
             before(grammarAccess.getStartNodeAccess().getTransitionTransitionParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getStartNodeAccess().getTransitionTransitionParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StartNode__TransitionAssignment_7"


    // $ANTLR start "rule__DialogueNode__NameAssignment_1"
    // InternalIfictiondsl.g:3390:1: rule__DialogueNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DialogueNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3394:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:3395:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:3395:2: ( RULE_ID )
            // InternalIfictiondsl.g:3396:3: RULE_ID
            {
             before(grammarAccess.getDialogueNodeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDialogueNodeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__NameAssignment_1"


    // $ANTLR start "rule__DialogueNode__TextAssignment_5"
    // InternalIfictiondsl.g:3405:1: rule__DialogueNode__TextAssignment_5 : ( RULE_STRING ) ;
    public final void rule__DialogueNode__TextAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3409:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:3410:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:3410:2: ( RULE_STRING )
            // InternalIfictiondsl.g:3411:3: RULE_STRING
            {
             before(grammarAccess.getDialogueNodeAccess().getTextSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDialogueNodeAccess().getTextSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__TextAssignment_5"


    // $ANTLR start "rule__DialogueNode__TransitionAssignment_7"
    // InternalIfictiondsl.g:3420:1: rule__DialogueNode__TransitionAssignment_7 : ( ruleTransition ) ;
    public final void rule__DialogueNode__TransitionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3424:1: ( ( ruleTransition ) )
            // InternalIfictiondsl.g:3425:2: ( ruleTransition )
            {
            // InternalIfictiondsl.g:3425:2: ( ruleTransition )
            // InternalIfictiondsl.g:3426:3: ruleTransition
            {
             before(grammarAccess.getDialogueNodeAccess().getTransitionTransitionParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getDialogueNodeAccess().getTransitionTransitionParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DialogueNode__TransitionAssignment_7"


    // $ANTLR start "rule__OrCondition__RightAssignment_1_2"
    // InternalIfictiondsl.g:3435:1: rule__OrCondition__RightAssignment_1_2 : ( ruleAndCondition ) ;
    public final void rule__OrCondition__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3439:1: ( ( ruleAndCondition ) )
            // InternalIfictiondsl.g:3440:2: ( ruleAndCondition )
            {
            // InternalIfictiondsl.g:3440:2: ( ruleAndCondition )
            // InternalIfictiondsl.g:3441:3: ruleAndCondition
            {
             before(grammarAccess.getOrConditionAccess().getRightAndConditionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAndCondition();

            state._fsp--;

             after(grammarAccess.getOrConditionAccess().getRightAndConditionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrCondition__RightAssignment_1_2"


    // $ANTLR start "rule__AndCondition__RightAssignment_1_2"
    // InternalIfictiondsl.g:3450:1: rule__AndCondition__RightAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__AndCondition__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3454:1: ( ( rulePrimary ) )
            // InternalIfictiondsl.g:3455:2: ( rulePrimary )
            {
            // InternalIfictiondsl.g:3455:2: ( rulePrimary )
            // InternalIfictiondsl.g:3456:3: rulePrimary
            {
             before(grammarAccess.getAndConditionAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getAndConditionAccess().getRightPrimaryParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndCondition__RightAssignment_1_2"


    // $ANTLR start "rule__Comparison__VariableAssignment_0"
    // InternalIfictiondsl.g:3465:1: rule__Comparison__VariableAssignment_0 : ( RULE_ID ) ;
    public final void rule__Comparison__VariableAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3469:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:3470:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:3470:2: ( RULE_ID )
            // InternalIfictiondsl.g:3471:3: RULE_ID
            {
             before(grammarAccess.getComparisonAccess().getVariableIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getComparisonAccess().getVariableIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__VariableAssignment_0"


    // $ANTLR start "rule__Comparison__OperatorAssignment_1"
    // InternalIfictiondsl.g:3480:1: rule__Comparison__OperatorAssignment_1 : ( ruleOperator ) ;
    public final void rule__Comparison__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3484:1: ( ( ruleOperator ) )
            // InternalIfictiondsl.g:3485:2: ( ruleOperator )
            {
            // InternalIfictiondsl.g:3485:2: ( ruleOperator )
            // InternalIfictiondsl.g:3486:3: ruleOperator
            {
             before(grammarAccess.getComparisonAccess().getOperatorOperatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getComparisonAccess().getOperatorOperatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__OperatorAssignment_1"


    // $ANTLR start "rule__Comparison__ValueAssignment_2"
    // InternalIfictiondsl.g:3495:1: rule__Comparison__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__Comparison__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3499:1: ( ( RULE_INT ) )
            // InternalIfictiondsl.g:3500:2: ( RULE_INT )
            {
            // InternalIfictiondsl.g:3500:2: ( RULE_INT )
            // InternalIfictiondsl.g:3501:3: RULE_INT
            {
             before(grammarAccess.getComparisonAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getComparisonAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__ValueAssignment_2"


    // $ANTLR start "rule__SystemStateChangeNode__NameAssignment_1"
    // InternalIfictiondsl.g:3510:1: rule__SystemStateChangeNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SystemStateChangeNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3514:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:3515:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:3515:2: ( RULE_ID )
            // InternalIfictiondsl.g:3516:3: RULE_ID
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__NameAssignment_1"


    // $ANTLR start "rule__SystemStateChangeNode__TextAssignment_5"
    // InternalIfictiondsl.g:3525:1: rule__SystemStateChangeNode__TextAssignment_5 : ( RULE_STRING ) ;
    public final void rule__SystemStateChangeNode__TextAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3529:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:3530:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:3530:2: ( RULE_STRING )
            // InternalIfictiondsl.g:3531:3: RULE_STRING
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getTextSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getTextSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__TextAssignment_5"


    // $ANTLR start "rule__SystemStateChangeNode__StateUpdatesAssignment_7"
    // InternalIfictiondsl.g:3540:1: rule__SystemStateChangeNode__StateUpdatesAssignment_7 : ( ruleStateUpdate ) ;
    public final void rule__SystemStateChangeNode__StateUpdatesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3544:1: ( ( ruleStateUpdate ) )
            // InternalIfictiondsl.g:3545:2: ( ruleStateUpdate )
            {
            // InternalIfictiondsl.g:3545:2: ( ruleStateUpdate )
            // InternalIfictiondsl.g:3546:3: ruleStateUpdate
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getStateUpdatesStateUpdateParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleStateUpdate();

            state._fsp--;

             after(grammarAccess.getSystemStateChangeNodeAccess().getStateUpdatesStateUpdateParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__StateUpdatesAssignment_7"


    // $ANTLR start "rule__SystemStateChangeNode__StateUpdatesAssignment_8_1"
    // InternalIfictiondsl.g:3555:1: rule__SystemStateChangeNode__StateUpdatesAssignment_8_1 : ( ruleStateUpdate ) ;
    public final void rule__SystemStateChangeNode__StateUpdatesAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3559:1: ( ( ruleStateUpdate ) )
            // InternalIfictiondsl.g:3560:2: ( ruleStateUpdate )
            {
            // InternalIfictiondsl.g:3560:2: ( ruleStateUpdate )
            // InternalIfictiondsl.g:3561:3: ruleStateUpdate
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getStateUpdatesStateUpdateParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStateUpdate();

            state._fsp--;

             after(grammarAccess.getSystemStateChangeNodeAccess().getStateUpdatesStateUpdateParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__StateUpdatesAssignment_8_1"


    // $ANTLR start "rule__SystemStateChangeNode__TransitionAssignment_9"
    // InternalIfictiondsl.g:3570:1: rule__SystemStateChangeNode__TransitionAssignment_9 : ( ruleTransition ) ;
    public final void rule__SystemStateChangeNode__TransitionAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3574:1: ( ( ruleTransition ) )
            // InternalIfictiondsl.g:3575:2: ( ruleTransition )
            {
            // InternalIfictiondsl.g:3575:2: ( ruleTransition )
            // InternalIfictiondsl.g:3576:3: ruleTransition
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getTransitionTransitionParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getSystemStateChangeNodeAccess().getTransitionTransitionParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SystemStateChangeNode__TransitionAssignment_9"


    // $ANTLR start "rule__StateUpdate__VariableAssignment_0"
    // InternalIfictiondsl.g:3585:1: rule__StateUpdate__VariableAssignment_0 : ( RULE_STRING ) ;
    public final void rule__StateUpdate__VariableAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3589:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:3590:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:3590:2: ( RULE_STRING )
            // InternalIfictiondsl.g:3591:3: RULE_STRING
            {
             before(grammarAccess.getStateUpdateAccess().getVariableSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getStateUpdateAccess().getVariableSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateUpdate__VariableAssignment_0"


    // $ANTLR start "rule__StateUpdate__OperatorAssignment_1"
    // InternalIfictiondsl.g:3600:1: rule__StateUpdate__OperatorAssignment_1 : ( ( rule__StateUpdate__OperatorAlternatives_1_0 ) ) ;
    public final void rule__StateUpdate__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3604:1: ( ( ( rule__StateUpdate__OperatorAlternatives_1_0 ) ) )
            // InternalIfictiondsl.g:3605:2: ( ( rule__StateUpdate__OperatorAlternatives_1_0 ) )
            {
            // InternalIfictiondsl.g:3605:2: ( ( rule__StateUpdate__OperatorAlternatives_1_0 ) )
            // InternalIfictiondsl.g:3606:3: ( rule__StateUpdate__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getStateUpdateAccess().getOperatorAlternatives_1_0()); 
            // InternalIfictiondsl.g:3607:3: ( rule__StateUpdate__OperatorAlternatives_1_0 )
            // InternalIfictiondsl.g:3607:4: rule__StateUpdate__OperatorAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__StateUpdate__OperatorAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getStateUpdateAccess().getOperatorAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateUpdate__OperatorAssignment_1"


    // $ANTLR start "rule__StateUpdate__ValueAssignment_2"
    // InternalIfictiondsl.g:3615:1: rule__StateUpdate__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__StateUpdate__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3619:1: ( ( RULE_INT ) )
            // InternalIfictiondsl.g:3620:2: ( RULE_INT )
            {
            // InternalIfictiondsl.g:3620:2: ( RULE_INT )
            // InternalIfictiondsl.g:3621:3: RULE_INT
            {
             before(grammarAccess.getStateUpdateAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getStateUpdateAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StateUpdate__ValueAssignment_2"


    // $ANTLR start "rule__EndNode__NameAssignment_1"
    // InternalIfictiondsl.g:3630:1: rule__EndNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EndNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3634:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:3635:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:3635:2: ( RULE_ID )
            // InternalIfictiondsl.g:3636:3: RULE_ID
            {
             before(grammarAccess.getEndNodeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEndNodeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__NameAssignment_1"


    // $ANTLR start "rule__EndNode__TextAssignment_5"
    // InternalIfictiondsl.g:3645:1: rule__EndNode__TextAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EndNode__TextAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:3649:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:3650:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:3650:2: ( RULE_STRING )
            // InternalIfictiondsl.g:3651:3: RULE_STRING
            {
             before(grammarAccess.getEndNodeAccess().getTextSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getEndNodeAccess().getTextSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndNode__TextAssignment_5"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000030C00100000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000030C00100002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000060800L});

}