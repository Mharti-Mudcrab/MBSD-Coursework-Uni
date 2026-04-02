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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'!='", "'>'", "'<'", "'+='", "'-='", "'Story'", "'ChoiceNode'", "'{'", "'choices'", "':'", "'['", "']'", "'}'", "','", "'ChoiceOption'", "'displayText'", "'->'", "'with'", "'priority'", "'condition'", "'StartNode'", "'DialogueNode'", "'SystemStateChangeNode'", "'EndNode'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
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
    // InternalIfictiondsl.g:237:1: ruleCondition : ( ( rule__Condition__Group__0 ) ) ;
    public final void ruleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:241:2: ( ( ( rule__Condition__Group__0 ) ) )
            // InternalIfictiondsl.g:242:2: ( ( rule__Condition__Group__0 ) )
            {
            // InternalIfictiondsl.g:242:2: ( ( rule__Condition__Group__0 ) )
            // InternalIfictiondsl.g:243:3: ( rule__Condition__Group__0 )
            {
             before(grammarAccess.getConditionAccess().getGroup()); 
            // InternalIfictiondsl.g:244:3: ( rule__Condition__Group__0 )
            // InternalIfictiondsl.g:244:4: rule__Condition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getGroup()); 

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


    // $ANTLR start "entryRuleSystemStateChangeNode"
    // InternalIfictiondsl.g:253:1: entryRuleSystemStateChangeNode : ruleSystemStateChangeNode EOF ;
    public final void entryRuleSystemStateChangeNode() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:254:1: ( ruleSystemStateChangeNode EOF )
            // InternalIfictiondsl.g:255:1: ruleSystemStateChangeNode EOF
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
    // InternalIfictiondsl.g:262:1: ruleSystemStateChangeNode : ( ( rule__SystemStateChangeNode__Group__0 ) ) ;
    public final void ruleSystemStateChangeNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:266:2: ( ( ( rule__SystemStateChangeNode__Group__0 ) ) )
            // InternalIfictiondsl.g:267:2: ( ( rule__SystemStateChangeNode__Group__0 ) )
            {
            // InternalIfictiondsl.g:267:2: ( ( rule__SystemStateChangeNode__Group__0 ) )
            // InternalIfictiondsl.g:268:3: ( rule__SystemStateChangeNode__Group__0 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getGroup()); 
            // InternalIfictiondsl.g:269:3: ( rule__SystemStateChangeNode__Group__0 )
            // InternalIfictiondsl.g:269:4: rule__SystemStateChangeNode__Group__0
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


    // $ANTLR start "entryRuleEndNode"
    // InternalIfictiondsl.g:278:1: entryRuleEndNode : ruleEndNode EOF ;
    public final void entryRuleEndNode() throws RecognitionException {
        try {
            // InternalIfictiondsl.g:279:1: ( ruleEndNode EOF )
            // InternalIfictiondsl.g:280:1: ruleEndNode EOF
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
    // InternalIfictiondsl.g:287:1: ruleEndNode : ( ( rule__EndNode__Group__0 ) ) ;
    public final void ruleEndNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:291:2: ( ( ( rule__EndNode__Group__0 ) ) )
            // InternalIfictiondsl.g:292:2: ( ( rule__EndNode__Group__0 ) )
            {
            // InternalIfictiondsl.g:292:2: ( ( rule__EndNode__Group__0 ) )
            // InternalIfictiondsl.g:293:3: ( rule__EndNode__Group__0 )
            {
             before(grammarAccess.getEndNodeAccess().getGroup()); 
            // InternalIfictiondsl.g:294:3: ( rule__EndNode__Group__0 )
            // InternalIfictiondsl.g:294:4: rule__EndNode__Group__0
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
    // InternalIfictiondsl.g:302:1: rule__Node__Alternatives : ( ( ruleStartNode ) | ( ruleChoiceNode ) | ( ruleDialogueNode ) | ( ruleSystemStateChangeNode ) | ( ruleEndNode ) );
    public final void rule__Node__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:306:1: ( ( ruleStartNode ) | ( ruleChoiceNode ) | ( ruleDialogueNode ) | ( ruleSystemStateChangeNode ) | ( ruleEndNode ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt1=1;
                }
                break;
            case 18:
                {
                alt1=2;
                }
                break;
            case 33:
                {
                alt1=3;
                }
                break;
            case 34:
                {
                alt1=4;
                }
                break;
            case 35:
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
                    // InternalIfictiondsl.g:307:2: ( ruleStartNode )
                    {
                    // InternalIfictiondsl.g:307:2: ( ruleStartNode )
                    // InternalIfictiondsl.g:308:3: ruleStartNode
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
                    // InternalIfictiondsl.g:313:2: ( ruleChoiceNode )
                    {
                    // InternalIfictiondsl.g:313:2: ( ruleChoiceNode )
                    // InternalIfictiondsl.g:314:3: ruleChoiceNode
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
                    // InternalIfictiondsl.g:319:2: ( ruleDialogueNode )
                    {
                    // InternalIfictiondsl.g:319:2: ( ruleDialogueNode )
                    // InternalIfictiondsl.g:320:3: ruleDialogueNode
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
                    // InternalIfictiondsl.g:325:2: ( ruleSystemStateChangeNode )
                    {
                    // InternalIfictiondsl.g:325:2: ( ruleSystemStateChangeNode )
                    // InternalIfictiondsl.g:326:3: ruleSystemStateChangeNode
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
                    // InternalIfictiondsl.g:331:2: ( ruleEndNode )
                    {
                    // InternalIfictiondsl.g:331:2: ( ruleEndNode )
                    // InternalIfictiondsl.g:332:3: ruleEndNode
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


    // $ANTLR start "rule__Condition__OperatorAlternatives_1_0"
    // InternalIfictiondsl.g:341:1: rule__Condition__OperatorAlternatives_1_0 : ( ( '=' ) | ( '!=' ) | ( '>' ) | ( '<' ) );
    public final void rule__Condition__OperatorAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:345:1: ( ( '=' ) | ( '!=' ) | ( '>' ) | ( '<' ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalIfictiondsl.g:346:2: ( '=' )
                    {
                    // InternalIfictiondsl.g:346:2: ( '=' )
                    // InternalIfictiondsl.g:347:3: '='
                    {
                     before(grammarAccess.getConditionAccess().getOperatorEqualsSignKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getConditionAccess().getOperatorEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIfictiondsl.g:352:2: ( '!=' )
                    {
                    // InternalIfictiondsl.g:352:2: ( '!=' )
                    // InternalIfictiondsl.g:353:3: '!='
                    {
                     before(grammarAccess.getConditionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getConditionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIfictiondsl.g:358:2: ( '>' )
                    {
                    // InternalIfictiondsl.g:358:2: ( '>' )
                    // InternalIfictiondsl.g:359:3: '>'
                    {
                     before(grammarAccess.getConditionAccess().getOperatorGreaterThanSignKeyword_1_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getConditionAccess().getOperatorGreaterThanSignKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalIfictiondsl.g:364:2: ( '<' )
                    {
                    // InternalIfictiondsl.g:364:2: ( '<' )
                    // InternalIfictiondsl.g:365:3: '<'
                    {
                     before(grammarAccess.getConditionAccess().getOperatorLessThanSignKeyword_1_0_3()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getConditionAccess().getOperatorLessThanSignKeyword_1_0_3()); 

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
    // $ANTLR end "rule__Condition__OperatorAlternatives_1_0"


    // $ANTLR start "rule__SystemStateChangeNode__OperatorAlternatives_8_0"
    // InternalIfictiondsl.g:374:1: rule__SystemStateChangeNode__OperatorAlternatives_8_0 : ( ( '+=' ) | ( '-=' ) | ( '=' ) );
    public final void rule__SystemStateChangeNode__OperatorAlternatives_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:378:1: ( ( '+=' ) | ( '-=' ) | ( '=' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt3=1;
                }
                break;
            case 16:
                {
                alt3=2;
                }
                break;
            case 11:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalIfictiondsl.g:379:2: ( '+=' )
                    {
                    // InternalIfictiondsl.g:379:2: ( '+=' )
                    // InternalIfictiondsl.g:380:3: '+='
                    {
                     before(grammarAccess.getSystemStateChangeNodeAccess().getOperatorPlusSignEqualsSignKeyword_8_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getSystemStateChangeNodeAccess().getOperatorPlusSignEqualsSignKeyword_8_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIfictiondsl.g:385:2: ( '-=' )
                    {
                    // InternalIfictiondsl.g:385:2: ( '-=' )
                    // InternalIfictiondsl.g:386:3: '-='
                    {
                     before(grammarAccess.getSystemStateChangeNodeAccess().getOperatorHyphenMinusEqualsSignKeyword_8_0_1()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getSystemStateChangeNodeAccess().getOperatorHyphenMinusEqualsSignKeyword_8_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIfictiondsl.g:391:2: ( '=' )
                    {
                    // InternalIfictiondsl.g:391:2: ( '=' )
                    // InternalIfictiondsl.g:392:3: '='
                    {
                     before(grammarAccess.getSystemStateChangeNodeAccess().getOperatorEqualsSignKeyword_8_0_2()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getSystemStateChangeNodeAccess().getOperatorEqualsSignKeyword_8_0_2()); 

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
    // $ANTLR end "rule__SystemStateChangeNode__OperatorAlternatives_8_0"


    // $ANTLR start "rule__Story__Group__0"
    // InternalIfictiondsl.g:401:1: rule__Story__Group__0 : rule__Story__Group__0__Impl rule__Story__Group__1 ;
    public final void rule__Story__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:405:1: ( rule__Story__Group__0__Impl rule__Story__Group__1 )
            // InternalIfictiondsl.g:406:2: rule__Story__Group__0__Impl rule__Story__Group__1
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
    // InternalIfictiondsl.g:413:1: rule__Story__Group__0__Impl : ( 'Story' ) ;
    public final void rule__Story__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:417:1: ( ( 'Story' ) )
            // InternalIfictiondsl.g:418:1: ( 'Story' )
            {
            // InternalIfictiondsl.g:418:1: ( 'Story' )
            // InternalIfictiondsl.g:419:2: 'Story'
            {
             before(grammarAccess.getStoryAccess().getStoryKeyword_0()); 
            match(input,17,FOLLOW_2); 
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
    // InternalIfictiondsl.g:428:1: rule__Story__Group__1 : rule__Story__Group__1__Impl rule__Story__Group__2 ;
    public final void rule__Story__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:432:1: ( rule__Story__Group__1__Impl rule__Story__Group__2 )
            // InternalIfictiondsl.g:433:2: rule__Story__Group__1__Impl rule__Story__Group__2
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
    // InternalIfictiondsl.g:440:1: rule__Story__Group__1__Impl : ( ( rule__Story__NameAssignment_1 ) ) ;
    public final void rule__Story__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:444:1: ( ( ( rule__Story__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:445:1: ( ( rule__Story__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:445:1: ( ( rule__Story__NameAssignment_1 ) )
            // InternalIfictiondsl.g:446:2: ( rule__Story__NameAssignment_1 )
            {
             before(grammarAccess.getStoryAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:447:2: ( rule__Story__NameAssignment_1 )
            // InternalIfictiondsl.g:447:3: rule__Story__NameAssignment_1
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
    // InternalIfictiondsl.g:455:1: rule__Story__Group__2 : rule__Story__Group__2__Impl ;
    public final void rule__Story__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:459:1: ( rule__Story__Group__2__Impl )
            // InternalIfictiondsl.g:460:2: rule__Story__Group__2__Impl
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
    // InternalIfictiondsl.g:466:1: rule__Story__Group__2__Impl : ( ( rule__Story__NodesAssignment_2 )* ) ;
    public final void rule__Story__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:470:1: ( ( ( rule__Story__NodesAssignment_2 )* ) )
            // InternalIfictiondsl.g:471:1: ( ( rule__Story__NodesAssignment_2 )* )
            {
            // InternalIfictiondsl.g:471:1: ( ( rule__Story__NodesAssignment_2 )* )
            // InternalIfictiondsl.g:472:2: ( rule__Story__NodesAssignment_2 )*
            {
             before(grammarAccess.getStoryAccess().getNodesAssignment_2()); 
            // InternalIfictiondsl.g:473:2: ( rule__Story__NodesAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18||(LA4_0>=32 && LA4_0<=35)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalIfictiondsl.g:473:3: rule__Story__NodesAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Story__NodesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // InternalIfictiondsl.g:482:1: rule__ChoiceNode__Group__0 : rule__ChoiceNode__Group__0__Impl rule__ChoiceNode__Group__1 ;
    public final void rule__ChoiceNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:486:1: ( rule__ChoiceNode__Group__0__Impl rule__ChoiceNode__Group__1 )
            // InternalIfictiondsl.g:487:2: rule__ChoiceNode__Group__0__Impl rule__ChoiceNode__Group__1
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
    // InternalIfictiondsl.g:494:1: rule__ChoiceNode__Group__0__Impl : ( 'ChoiceNode' ) ;
    public final void rule__ChoiceNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:498:1: ( ( 'ChoiceNode' ) )
            // InternalIfictiondsl.g:499:1: ( 'ChoiceNode' )
            {
            // InternalIfictiondsl.g:499:1: ( 'ChoiceNode' )
            // InternalIfictiondsl.g:500:2: 'ChoiceNode'
            {
             before(grammarAccess.getChoiceNodeAccess().getChoiceNodeKeyword_0()); 
            match(input,18,FOLLOW_2); 
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
    // InternalIfictiondsl.g:509:1: rule__ChoiceNode__Group__1 : rule__ChoiceNode__Group__1__Impl rule__ChoiceNode__Group__2 ;
    public final void rule__ChoiceNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:513:1: ( rule__ChoiceNode__Group__1__Impl rule__ChoiceNode__Group__2 )
            // InternalIfictiondsl.g:514:2: rule__ChoiceNode__Group__1__Impl rule__ChoiceNode__Group__2
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
    // InternalIfictiondsl.g:521:1: rule__ChoiceNode__Group__1__Impl : ( ( rule__ChoiceNode__NameAssignment_1 ) ) ;
    public final void rule__ChoiceNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:525:1: ( ( ( rule__ChoiceNode__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:526:1: ( ( rule__ChoiceNode__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:526:1: ( ( rule__ChoiceNode__NameAssignment_1 ) )
            // InternalIfictiondsl.g:527:2: ( rule__ChoiceNode__NameAssignment_1 )
            {
             before(grammarAccess.getChoiceNodeAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:528:2: ( rule__ChoiceNode__NameAssignment_1 )
            // InternalIfictiondsl.g:528:3: rule__ChoiceNode__NameAssignment_1
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
    // InternalIfictiondsl.g:536:1: rule__ChoiceNode__Group__2 : rule__ChoiceNode__Group__2__Impl rule__ChoiceNode__Group__3 ;
    public final void rule__ChoiceNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:540:1: ( rule__ChoiceNode__Group__2__Impl rule__ChoiceNode__Group__3 )
            // InternalIfictiondsl.g:541:2: rule__ChoiceNode__Group__2__Impl rule__ChoiceNode__Group__3
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
    // InternalIfictiondsl.g:548:1: rule__ChoiceNode__Group__2__Impl : ( '{' ) ;
    public final void rule__ChoiceNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:552:1: ( ( '{' ) )
            // InternalIfictiondsl.g:553:1: ( '{' )
            {
            // InternalIfictiondsl.g:553:1: ( '{' )
            // InternalIfictiondsl.g:554:2: '{'
            {
             before(grammarAccess.getChoiceNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_2); 
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
    // InternalIfictiondsl.g:563:1: rule__ChoiceNode__Group__3 : rule__ChoiceNode__Group__3__Impl rule__ChoiceNode__Group__4 ;
    public final void rule__ChoiceNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:567:1: ( rule__ChoiceNode__Group__3__Impl rule__ChoiceNode__Group__4 )
            // InternalIfictiondsl.g:568:2: rule__ChoiceNode__Group__3__Impl rule__ChoiceNode__Group__4
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
    // InternalIfictiondsl.g:575:1: rule__ChoiceNode__Group__3__Impl : ( 'choices' ) ;
    public final void rule__ChoiceNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:579:1: ( ( 'choices' ) )
            // InternalIfictiondsl.g:580:1: ( 'choices' )
            {
            // InternalIfictiondsl.g:580:1: ( 'choices' )
            // InternalIfictiondsl.g:581:2: 'choices'
            {
             before(grammarAccess.getChoiceNodeAccess().getChoicesKeyword_3()); 
            match(input,20,FOLLOW_2); 
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
    // InternalIfictiondsl.g:590:1: rule__ChoiceNode__Group__4 : rule__ChoiceNode__Group__4__Impl rule__ChoiceNode__Group__5 ;
    public final void rule__ChoiceNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:594:1: ( rule__ChoiceNode__Group__4__Impl rule__ChoiceNode__Group__5 )
            // InternalIfictiondsl.g:595:2: rule__ChoiceNode__Group__4__Impl rule__ChoiceNode__Group__5
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
    // InternalIfictiondsl.g:602:1: rule__ChoiceNode__Group__4__Impl : ( ':' ) ;
    public final void rule__ChoiceNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:606:1: ( ( ':' ) )
            // InternalIfictiondsl.g:607:1: ( ':' )
            {
            // InternalIfictiondsl.g:607:1: ( ':' )
            // InternalIfictiondsl.g:608:2: ':'
            {
             before(grammarAccess.getChoiceNodeAccess().getColonKeyword_4()); 
            match(input,21,FOLLOW_2); 
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
    // InternalIfictiondsl.g:617:1: rule__ChoiceNode__Group__5 : rule__ChoiceNode__Group__5__Impl rule__ChoiceNode__Group__6 ;
    public final void rule__ChoiceNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:621:1: ( rule__ChoiceNode__Group__5__Impl rule__ChoiceNode__Group__6 )
            // InternalIfictiondsl.g:622:2: rule__ChoiceNode__Group__5__Impl rule__ChoiceNode__Group__6
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
    // InternalIfictiondsl.g:629:1: rule__ChoiceNode__Group__5__Impl : ( '[' ) ;
    public final void rule__ChoiceNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:633:1: ( ( '[' ) )
            // InternalIfictiondsl.g:634:1: ( '[' )
            {
            // InternalIfictiondsl.g:634:1: ( '[' )
            // InternalIfictiondsl.g:635:2: '['
            {
             before(grammarAccess.getChoiceNodeAccess().getLeftSquareBracketKeyword_5()); 
            match(input,22,FOLLOW_2); 
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
    // InternalIfictiondsl.g:644:1: rule__ChoiceNode__Group__6 : rule__ChoiceNode__Group__6__Impl rule__ChoiceNode__Group__7 ;
    public final void rule__ChoiceNode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:648:1: ( rule__ChoiceNode__Group__6__Impl rule__ChoiceNode__Group__7 )
            // InternalIfictiondsl.g:649:2: rule__ChoiceNode__Group__6__Impl rule__ChoiceNode__Group__7
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
    // InternalIfictiondsl.g:656:1: rule__ChoiceNode__Group__6__Impl : ( ( rule__ChoiceNode__Group_6__0 )? ) ;
    public final void rule__ChoiceNode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:660:1: ( ( ( rule__ChoiceNode__Group_6__0 )? ) )
            // InternalIfictiondsl.g:661:1: ( ( rule__ChoiceNode__Group_6__0 )? )
            {
            // InternalIfictiondsl.g:661:1: ( ( rule__ChoiceNode__Group_6__0 )? )
            // InternalIfictiondsl.g:662:2: ( rule__ChoiceNode__Group_6__0 )?
            {
             before(grammarAccess.getChoiceNodeAccess().getGroup_6()); 
            // InternalIfictiondsl.g:663:2: ( rule__ChoiceNode__Group_6__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==26) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalIfictiondsl.g:663:3: rule__ChoiceNode__Group_6__0
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
    // InternalIfictiondsl.g:671:1: rule__ChoiceNode__Group__7 : rule__ChoiceNode__Group__7__Impl rule__ChoiceNode__Group__8 ;
    public final void rule__ChoiceNode__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:675:1: ( rule__ChoiceNode__Group__7__Impl rule__ChoiceNode__Group__8 )
            // InternalIfictiondsl.g:676:2: rule__ChoiceNode__Group__7__Impl rule__ChoiceNode__Group__8
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
    // InternalIfictiondsl.g:683:1: rule__ChoiceNode__Group__7__Impl : ( ']' ) ;
    public final void rule__ChoiceNode__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:687:1: ( ( ']' ) )
            // InternalIfictiondsl.g:688:1: ( ']' )
            {
            // InternalIfictiondsl.g:688:1: ( ']' )
            // InternalIfictiondsl.g:689:2: ']'
            {
             before(grammarAccess.getChoiceNodeAccess().getRightSquareBracketKeyword_7()); 
            match(input,23,FOLLOW_2); 
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
    // InternalIfictiondsl.g:698:1: rule__ChoiceNode__Group__8 : rule__ChoiceNode__Group__8__Impl ;
    public final void rule__ChoiceNode__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:702:1: ( rule__ChoiceNode__Group__8__Impl )
            // InternalIfictiondsl.g:703:2: rule__ChoiceNode__Group__8__Impl
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
    // InternalIfictiondsl.g:709:1: rule__ChoiceNode__Group__8__Impl : ( '}' ) ;
    public final void rule__ChoiceNode__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:713:1: ( ( '}' ) )
            // InternalIfictiondsl.g:714:1: ( '}' )
            {
            // InternalIfictiondsl.g:714:1: ( '}' )
            // InternalIfictiondsl.g:715:2: '}'
            {
             before(grammarAccess.getChoiceNodeAccess().getRightCurlyBracketKeyword_8()); 
            match(input,24,FOLLOW_2); 
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
    // InternalIfictiondsl.g:725:1: rule__ChoiceNode__Group_6__0 : rule__ChoiceNode__Group_6__0__Impl rule__ChoiceNode__Group_6__1 ;
    public final void rule__ChoiceNode__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:729:1: ( rule__ChoiceNode__Group_6__0__Impl rule__ChoiceNode__Group_6__1 )
            // InternalIfictiondsl.g:730:2: rule__ChoiceNode__Group_6__0__Impl rule__ChoiceNode__Group_6__1
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
    // InternalIfictiondsl.g:737:1: rule__ChoiceNode__Group_6__0__Impl : ( ( rule__ChoiceNode__OptionsAssignment_6_0 ) ) ;
    public final void rule__ChoiceNode__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:741:1: ( ( ( rule__ChoiceNode__OptionsAssignment_6_0 ) ) )
            // InternalIfictiondsl.g:742:1: ( ( rule__ChoiceNode__OptionsAssignment_6_0 ) )
            {
            // InternalIfictiondsl.g:742:1: ( ( rule__ChoiceNode__OptionsAssignment_6_0 ) )
            // InternalIfictiondsl.g:743:2: ( rule__ChoiceNode__OptionsAssignment_6_0 )
            {
             before(grammarAccess.getChoiceNodeAccess().getOptionsAssignment_6_0()); 
            // InternalIfictiondsl.g:744:2: ( rule__ChoiceNode__OptionsAssignment_6_0 )
            // InternalIfictiondsl.g:744:3: rule__ChoiceNode__OptionsAssignment_6_0
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
    // InternalIfictiondsl.g:752:1: rule__ChoiceNode__Group_6__1 : rule__ChoiceNode__Group_6__1__Impl ;
    public final void rule__ChoiceNode__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:756:1: ( rule__ChoiceNode__Group_6__1__Impl )
            // InternalIfictiondsl.g:757:2: rule__ChoiceNode__Group_6__1__Impl
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
    // InternalIfictiondsl.g:763:1: rule__ChoiceNode__Group_6__1__Impl : ( ( rule__ChoiceNode__Group_6_1__0 )* ) ;
    public final void rule__ChoiceNode__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:767:1: ( ( ( rule__ChoiceNode__Group_6_1__0 )* ) )
            // InternalIfictiondsl.g:768:1: ( ( rule__ChoiceNode__Group_6_1__0 )* )
            {
            // InternalIfictiondsl.g:768:1: ( ( rule__ChoiceNode__Group_6_1__0 )* )
            // InternalIfictiondsl.g:769:2: ( rule__ChoiceNode__Group_6_1__0 )*
            {
             before(grammarAccess.getChoiceNodeAccess().getGroup_6_1()); 
            // InternalIfictiondsl.g:770:2: ( rule__ChoiceNode__Group_6_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalIfictiondsl.g:770:3: rule__ChoiceNode__Group_6_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__ChoiceNode__Group_6_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // InternalIfictiondsl.g:779:1: rule__ChoiceNode__Group_6_1__0 : rule__ChoiceNode__Group_6_1__0__Impl rule__ChoiceNode__Group_6_1__1 ;
    public final void rule__ChoiceNode__Group_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:783:1: ( rule__ChoiceNode__Group_6_1__0__Impl rule__ChoiceNode__Group_6_1__1 )
            // InternalIfictiondsl.g:784:2: rule__ChoiceNode__Group_6_1__0__Impl rule__ChoiceNode__Group_6_1__1
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
    // InternalIfictiondsl.g:791:1: rule__ChoiceNode__Group_6_1__0__Impl : ( ',' ) ;
    public final void rule__ChoiceNode__Group_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:795:1: ( ( ',' ) )
            // InternalIfictiondsl.g:796:1: ( ',' )
            {
            // InternalIfictiondsl.g:796:1: ( ',' )
            // InternalIfictiondsl.g:797:2: ','
            {
             before(grammarAccess.getChoiceNodeAccess().getCommaKeyword_6_1_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalIfictiondsl.g:806:1: rule__ChoiceNode__Group_6_1__1 : rule__ChoiceNode__Group_6_1__1__Impl ;
    public final void rule__ChoiceNode__Group_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:810:1: ( rule__ChoiceNode__Group_6_1__1__Impl )
            // InternalIfictiondsl.g:811:2: rule__ChoiceNode__Group_6_1__1__Impl
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
    // InternalIfictiondsl.g:817:1: rule__ChoiceNode__Group_6_1__1__Impl : ( ( rule__ChoiceNode__OptionsAssignment_6_1_1 ) ) ;
    public final void rule__ChoiceNode__Group_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:821:1: ( ( ( rule__ChoiceNode__OptionsAssignment_6_1_1 ) ) )
            // InternalIfictiondsl.g:822:1: ( ( rule__ChoiceNode__OptionsAssignment_6_1_1 ) )
            {
            // InternalIfictiondsl.g:822:1: ( ( rule__ChoiceNode__OptionsAssignment_6_1_1 ) )
            // InternalIfictiondsl.g:823:2: ( rule__ChoiceNode__OptionsAssignment_6_1_1 )
            {
             before(grammarAccess.getChoiceNodeAccess().getOptionsAssignment_6_1_1()); 
            // InternalIfictiondsl.g:824:2: ( rule__ChoiceNode__OptionsAssignment_6_1_1 )
            // InternalIfictiondsl.g:824:3: rule__ChoiceNode__OptionsAssignment_6_1_1
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
    // InternalIfictiondsl.g:833:1: rule__ChoiceOption__Group__0 : rule__ChoiceOption__Group__0__Impl rule__ChoiceOption__Group__1 ;
    public final void rule__ChoiceOption__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:837:1: ( rule__ChoiceOption__Group__0__Impl rule__ChoiceOption__Group__1 )
            // InternalIfictiondsl.g:838:2: rule__ChoiceOption__Group__0__Impl rule__ChoiceOption__Group__1
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
    // InternalIfictiondsl.g:845:1: rule__ChoiceOption__Group__0__Impl : ( 'ChoiceOption' ) ;
    public final void rule__ChoiceOption__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:849:1: ( ( 'ChoiceOption' ) )
            // InternalIfictiondsl.g:850:1: ( 'ChoiceOption' )
            {
            // InternalIfictiondsl.g:850:1: ( 'ChoiceOption' )
            // InternalIfictiondsl.g:851:2: 'ChoiceOption'
            {
             before(grammarAccess.getChoiceOptionAccess().getChoiceOptionKeyword_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalIfictiondsl.g:860:1: rule__ChoiceOption__Group__1 : rule__ChoiceOption__Group__1__Impl rule__ChoiceOption__Group__2 ;
    public final void rule__ChoiceOption__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:864:1: ( rule__ChoiceOption__Group__1__Impl rule__ChoiceOption__Group__2 )
            // InternalIfictiondsl.g:865:2: rule__ChoiceOption__Group__1__Impl rule__ChoiceOption__Group__2
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
    // InternalIfictiondsl.g:872:1: rule__ChoiceOption__Group__1__Impl : ( '{' ) ;
    public final void rule__ChoiceOption__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:876:1: ( ( '{' ) )
            // InternalIfictiondsl.g:877:1: ( '{' )
            {
            // InternalIfictiondsl.g:877:1: ( '{' )
            // InternalIfictiondsl.g:878:2: '{'
            {
             before(grammarAccess.getChoiceOptionAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,19,FOLLOW_2); 
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
    // InternalIfictiondsl.g:887:1: rule__ChoiceOption__Group__2 : rule__ChoiceOption__Group__2__Impl rule__ChoiceOption__Group__3 ;
    public final void rule__ChoiceOption__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:891:1: ( rule__ChoiceOption__Group__2__Impl rule__ChoiceOption__Group__3 )
            // InternalIfictiondsl.g:892:2: rule__ChoiceOption__Group__2__Impl rule__ChoiceOption__Group__3
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
    // InternalIfictiondsl.g:899:1: rule__ChoiceOption__Group__2__Impl : ( 'displayText' ) ;
    public final void rule__ChoiceOption__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:903:1: ( ( 'displayText' ) )
            // InternalIfictiondsl.g:904:1: ( 'displayText' )
            {
            // InternalIfictiondsl.g:904:1: ( 'displayText' )
            // InternalIfictiondsl.g:905:2: 'displayText'
            {
             before(grammarAccess.getChoiceOptionAccess().getDisplayTextKeyword_2()); 
            match(input,27,FOLLOW_2); 
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
    // InternalIfictiondsl.g:914:1: rule__ChoiceOption__Group__3 : rule__ChoiceOption__Group__3__Impl rule__ChoiceOption__Group__4 ;
    public final void rule__ChoiceOption__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:918:1: ( rule__ChoiceOption__Group__3__Impl rule__ChoiceOption__Group__4 )
            // InternalIfictiondsl.g:919:2: rule__ChoiceOption__Group__3__Impl rule__ChoiceOption__Group__4
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
    // InternalIfictiondsl.g:926:1: rule__ChoiceOption__Group__3__Impl : ( ':' ) ;
    public final void rule__ChoiceOption__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:930:1: ( ( ':' ) )
            // InternalIfictiondsl.g:931:1: ( ':' )
            {
            // InternalIfictiondsl.g:931:1: ( ':' )
            // InternalIfictiondsl.g:932:2: ':'
            {
             before(grammarAccess.getChoiceOptionAccess().getColonKeyword_3()); 
            match(input,21,FOLLOW_2); 
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
    // InternalIfictiondsl.g:941:1: rule__ChoiceOption__Group__4 : rule__ChoiceOption__Group__4__Impl rule__ChoiceOption__Group__5 ;
    public final void rule__ChoiceOption__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:945:1: ( rule__ChoiceOption__Group__4__Impl rule__ChoiceOption__Group__5 )
            // InternalIfictiondsl.g:946:2: rule__ChoiceOption__Group__4__Impl rule__ChoiceOption__Group__5
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
    // InternalIfictiondsl.g:953:1: rule__ChoiceOption__Group__4__Impl : ( ( rule__ChoiceOption__TextAssignment_4 ) ) ;
    public final void rule__ChoiceOption__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:957:1: ( ( ( rule__ChoiceOption__TextAssignment_4 ) ) )
            // InternalIfictiondsl.g:958:1: ( ( rule__ChoiceOption__TextAssignment_4 ) )
            {
            // InternalIfictiondsl.g:958:1: ( ( rule__ChoiceOption__TextAssignment_4 ) )
            // InternalIfictiondsl.g:959:2: ( rule__ChoiceOption__TextAssignment_4 )
            {
             before(grammarAccess.getChoiceOptionAccess().getTextAssignment_4()); 
            // InternalIfictiondsl.g:960:2: ( rule__ChoiceOption__TextAssignment_4 )
            // InternalIfictiondsl.g:960:3: rule__ChoiceOption__TextAssignment_4
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
    // InternalIfictiondsl.g:968:1: rule__ChoiceOption__Group__5 : rule__ChoiceOption__Group__5__Impl rule__ChoiceOption__Group__6 ;
    public final void rule__ChoiceOption__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:972:1: ( rule__ChoiceOption__Group__5__Impl rule__ChoiceOption__Group__6 )
            // InternalIfictiondsl.g:973:2: rule__ChoiceOption__Group__5__Impl rule__ChoiceOption__Group__6
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
    // InternalIfictiondsl.g:980:1: rule__ChoiceOption__Group__5__Impl : ( ',' ) ;
    public final void rule__ChoiceOption__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:984:1: ( ( ',' ) )
            // InternalIfictiondsl.g:985:1: ( ',' )
            {
            // InternalIfictiondsl.g:985:1: ( ',' )
            // InternalIfictiondsl.g:986:2: ','
            {
             before(grammarAccess.getChoiceOptionAccess().getCommaKeyword_5()); 
            match(input,25,FOLLOW_2); 
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
    // InternalIfictiondsl.g:995:1: rule__ChoiceOption__Group__6 : rule__ChoiceOption__Group__6__Impl rule__ChoiceOption__Group__7 ;
    public final void rule__ChoiceOption__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:999:1: ( rule__ChoiceOption__Group__6__Impl rule__ChoiceOption__Group__7 )
            // InternalIfictiondsl.g:1000:2: rule__ChoiceOption__Group__6__Impl rule__ChoiceOption__Group__7
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
    // InternalIfictiondsl.g:1007:1: rule__ChoiceOption__Group__6__Impl : ( ( rule__ChoiceOption__Group_6__0 ) ) ;
    public final void rule__ChoiceOption__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1011:1: ( ( ( rule__ChoiceOption__Group_6__0 ) ) )
            // InternalIfictiondsl.g:1012:1: ( ( rule__ChoiceOption__Group_6__0 ) )
            {
            // InternalIfictiondsl.g:1012:1: ( ( rule__ChoiceOption__Group_6__0 ) )
            // InternalIfictiondsl.g:1013:2: ( rule__ChoiceOption__Group_6__0 )
            {
             before(grammarAccess.getChoiceOptionAccess().getGroup_6()); 
            // InternalIfictiondsl.g:1014:2: ( rule__ChoiceOption__Group_6__0 )
            // InternalIfictiondsl.g:1014:3: rule__ChoiceOption__Group_6__0
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
    // InternalIfictiondsl.g:1022:1: rule__ChoiceOption__Group__7 : rule__ChoiceOption__Group__7__Impl ;
    public final void rule__ChoiceOption__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1026:1: ( rule__ChoiceOption__Group__7__Impl )
            // InternalIfictiondsl.g:1027:2: rule__ChoiceOption__Group__7__Impl
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
    // InternalIfictiondsl.g:1033:1: rule__ChoiceOption__Group__7__Impl : ( '}' ) ;
    public final void rule__ChoiceOption__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1037:1: ( ( '}' ) )
            // InternalIfictiondsl.g:1038:1: ( '}' )
            {
            // InternalIfictiondsl.g:1038:1: ( '}' )
            // InternalIfictiondsl.g:1039:2: '}'
            {
             before(grammarAccess.getChoiceOptionAccess().getRightCurlyBracketKeyword_7()); 
            match(input,24,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1049:1: rule__ChoiceOption__Group_6__0 : rule__ChoiceOption__Group_6__0__Impl rule__ChoiceOption__Group_6__1 ;
    public final void rule__ChoiceOption__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1053:1: ( rule__ChoiceOption__Group_6__0__Impl rule__ChoiceOption__Group_6__1 )
            // InternalIfictiondsl.g:1054:2: rule__ChoiceOption__Group_6__0__Impl rule__ChoiceOption__Group_6__1
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
    // InternalIfictiondsl.g:1061:1: rule__ChoiceOption__Group_6__0__Impl : ( ( rule__ChoiceOption__TransitionsAssignment_6_0 ) ) ;
    public final void rule__ChoiceOption__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1065:1: ( ( ( rule__ChoiceOption__TransitionsAssignment_6_0 ) ) )
            // InternalIfictiondsl.g:1066:1: ( ( rule__ChoiceOption__TransitionsAssignment_6_0 ) )
            {
            // InternalIfictiondsl.g:1066:1: ( ( rule__ChoiceOption__TransitionsAssignment_6_0 ) )
            // InternalIfictiondsl.g:1067:2: ( rule__ChoiceOption__TransitionsAssignment_6_0 )
            {
             before(grammarAccess.getChoiceOptionAccess().getTransitionsAssignment_6_0()); 
            // InternalIfictiondsl.g:1068:2: ( rule__ChoiceOption__TransitionsAssignment_6_0 )
            // InternalIfictiondsl.g:1068:3: rule__ChoiceOption__TransitionsAssignment_6_0
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
    // InternalIfictiondsl.g:1076:1: rule__ChoiceOption__Group_6__1 : rule__ChoiceOption__Group_6__1__Impl ;
    public final void rule__ChoiceOption__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1080:1: ( rule__ChoiceOption__Group_6__1__Impl )
            // InternalIfictiondsl.g:1081:2: rule__ChoiceOption__Group_6__1__Impl
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
    // InternalIfictiondsl.g:1087:1: rule__ChoiceOption__Group_6__1__Impl : ( ( rule__ChoiceOption__Group_6_1__0 )* ) ;
    public final void rule__ChoiceOption__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1091:1: ( ( ( rule__ChoiceOption__Group_6_1__0 )* ) )
            // InternalIfictiondsl.g:1092:1: ( ( rule__ChoiceOption__Group_6_1__0 )* )
            {
            // InternalIfictiondsl.g:1092:1: ( ( rule__ChoiceOption__Group_6_1__0 )* )
            // InternalIfictiondsl.g:1093:2: ( rule__ChoiceOption__Group_6_1__0 )*
            {
             before(grammarAccess.getChoiceOptionAccess().getGroup_6_1()); 
            // InternalIfictiondsl.g:1094:2: ( rule__ChoiceOption__Group_6_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalIfictiondsl.g:1094:3: rule__ChoiceOption__Group_6_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__ChoiceOption__Group_6_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // InternalIfictiondsl.g:1103:1: rule__ChoiceOption__Group_6_1__0 : rule__ChoiceOption__Group_6_1__0__Impl rule__ChoiceOption__Group_6_1__1 ;
    public final void rule__ChoiceOption__Group_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1107:1: ( rule__ChoiceOption__Group_6_1__0__Impl rule__ChoiceOption__Group_6_1__1 )
            // InternalIfictiondsl.g:1108:2: rule__ChoiceOption__Group_6_1__0__Impl rule__ChoiceOption__Group_6_1__1
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
    // InternalIfictiondsl.g:1115:1: rule__ChoiceOption__Group_6_1__0__Impl : ( ',' ) ;
    public final void rule__ChoiceOption__Group_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1119:1: ( ( ',' ) )
            // InternalIfictiondsl.g:1120:1: ( ',' )
            {
            // InternalIfictiondsl.g:1120:1: ( ',' )
            // InternalIfictiondsl.g:1121:2: ','
            {
             before(grammarAccess.getChoiceOptionAccess().getCommaKeyword_6_1_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1130:1: rule__ChoiceOption__Group_6_1__1 : rule__ChoiceOption__Group_6_1__1__Impl ;
    public final void rule__ChoiceOption__Group_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1134:1: ( rule__ChoiceOption__Group_6_1__1__Impl )
            // InternalIfictiondsl.g:1135:2: rule__ChoiceOption__Group_6_1__1__Impl
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
    // InternalIfictiondsl.g:1141:1: rule__ChoiceOption__Group_6_1__1__Impl : ( ( rule__ChoiceOption__TransitionsAssignment_6_1_1 ) ) ;
    public final void rule__ChoiceOption__Group_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1145:1: ( ( ( rule__ChoiceOption__TransitionsAssignment_6_1_1 ) ) )
            // InternalIfictiondsl.g:1146:1: ( ( rule__ChoiceOption__TransitionsAssignment_6_1_1 ) )
            {
            // InternalIfictiondsl.g:1146:1: ( ( rule__ChoiceOption__TransitionsAssignment_6_1_1 ) )
            // InternalIfictiondsl.g:1147:2: ( rule__ChoiceOption__TransitionsAssignment_6_1_1 )
            {
             before(grammarAccess.getChoiceOptionAccess().getTransitionsAssignment_6_1_1()); 
            // InternalIfictiondsl.g:1148:2: ( rule__ChoiceOption__TransitionsAssignment_6_1_1 )
            // InternalIfictiondsl.g:1148:3: rule__ChoiceOption__TransitionsAssignment_6_1_1
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
    // InternalIfictiondsl.g:1157:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1161:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalIfictiondsl.g:1162:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
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
    // InternalIfictiondsl.g:1169:1: rule__Transition__Group__0__Impl : ( '->' ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1173:1: ( ( '->' ) )
            // InternalIfictiondsl.g:1174:1: ( '->' )
            {
            // InternalIfictiondsl.g:1174:1: ( '->' )
            // InternalIfictiondsl.g:1175:2: '->'
            {
             before(grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1184:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1188:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalIfictiondsl.g:1189:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
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
    // InternalIfictiondsl.g:1196:1: rule__Transition__Group__1__Impl : ( ( rule__Transition__DestinationAssignment_1 ) ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1200:1: ( ( ( rule__Transition__DestinationAssignment_1 ) ) )
            // InternalIfictiondsl.g:1201:1: ( ( rule__Transition__DestinationAssignment_1 ) )
            {
            // InternalIfictiondsl.g:1201:1: ( ( rule__Transition__DestinationAssignment_1 ) )
            // InternalIfictiondsl.g:1202:2: ( rule__Transition__DestinationAssignment_1 )
            {
             before(grammarAccess.getTransitionAccess().getDestinationAssignment_1()); 
            // InternalIfictiondsl.g:1203:2: ( rule__Transition__DestinationAssignment_1 )
            // InternalIfictiondsl.g:1203:3: rule__Transition__DestinationAssignment_1
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
    // InternalIfictiondsl.g:1211:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl rule__Transition__Group__3 ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1215:1: ( rule__Transition__Group__2__Impl rule__Transition__Group__3 )
            // InternalIfictiondsl.g:1216:2: rule__Transition__Group__2__Impl rule__Transition__Group__3
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
    // InternalIfictiondsl.g:1223:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__Group_2__0 )? ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1227:1: ( ( ( rule__Transition__Group_2__0 )? ) )
            // InternalIfictiondsl.g:1228:1: ( ( rule__Transition__Group_2__0 )? )
            {
            // InternalIfictiondsl.g:1228:1: ( ( rule__Transition__Group_2__0 )? )
            // InternalIfictiondsl.g:1229:2: ( rule__Transition__Group_2__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_2()); 
            // InternalIfictiondsl.g:1230:2: ( rule__Transition__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==30) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // InternalIfictiondsl.g:1230:3: rule__Transition__Group_2__0
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
    // InternalIfictiondsl.g:1238:1: rule__Transition__Group__3 : rule__Transition__Group__3__Impl ;
    public final void rule__Transition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1242:1: ( rule__Transition__Group__3__Impl )
            // InternalIfictiondsl.g:1243:2: rule__Transition__Group__3__Impl
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
    // InternalIfictiondsl.g:1249:1: rule__Transition__Group__3__Impl : ( ( rule__Transition__Group_3__0 )? ) ;
    public final void rule__Transition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1253:1: ( ( ( rule__Transition__Group_3__0 )? ) )
            // InternalIfictiondsl.g:1254:1: ( ( rule__Transition__Group_3__0 )? )
            {
            // InternalIfictiondsl.g:1254:1: ( ( rule__Transition__Group_3__0 )? )
            // InternalIfictiondsl.g:1255:2: ( rule__Transition__Group_3__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_3()); 
            // InternalIfictiondsl.g:1256:2: ( rule__Transition__Group_3__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==29) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalIfictiondsl.g:1256:3: rule__Transition__Group_3__0
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
    // InternalIfictiondsl.g:1265:1: rule__Transition__Group_2__0 : rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 ;
    public final void rule__Transition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1269:1: ( rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 )
            // InternalIfictiondsl.g:1270:2: rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1
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
    // InternalIfictiondsl.g:1277:1: rule__Transition__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Transition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1281:1: ( ( 'with' ) )
            // InternalIfictiondsl.g:1282:1: ( 'with' )
            {
            // InternalIfictiondsl.g:1282:1: ( 'with' )
            // InternalIfictiondsl.g:1283:2: 'with'
            {
             before(grammarAccess.getTransitionAccess().getWithKeyword_2_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1292:1: rule__Transition__Group_2__1 : rule__Transition__Group_2__1__Impl rule__Transition__Group_2__2 ;
    public final void rule__Transition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1296:1: ( rule__Transition__Group_2__1__Impl rule__Transition__Group_2__2 )
            // InternalIfictiondsl.g:1297:2: rule__Transition__Group_2__1__Impl rule__Transition__Group_2__2
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
    // InternalIfictiondsl.g:1304:1: rule__Transition__Group_2__1__Impl : ( 'priority' ) ;
    public final void rule__Transition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1308:1: ( ( 'priority' ) )
            // InternalIfictiondsl.g:1309:1: ( 'priority' )
            {
            // InternalIfictiondsl.g:1309:1: ( 'priority' )
            // InternalIfictiondsl.g:1310:2: 'priority'
            {
             before(grammarAccess.getTransitionAccess().getPriorityKeyword_2_1()); 
            match(input,30,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1319:1: rule__Transition__Group_2__2 : rule__Transition__Group_2__2__Impl ;
    public final void rule__Transition__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1323:1: ( rule__Transition__Group_2__2__Impl )
            // InternalIfictiondsl.g:1324:2: rule__Transition__Group_2__2__Impl
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
    // InternalIfictiondsl.g:1330:1: rule__Transition__Group_2__2__Impl : ( ( rule__Transition__PriorityAssignment_2_2 ) ) ;
    public final void rule__Transition__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1334:1: ( ( ( rule__Transition__PriorityAssignment_2_2 ) ) )
            // InternalIfictiondsl.g:1335:1: ( ( rule__Transition__PriorityAssignment_2_2 ) )
            {
            // InternalIfictiondsl.g:1335:1: ( ( rule__Transition__PriorityAssignment_2_2 ) )
            // InternalIfictiondsl.g:1336:2: ( rule__Transition__PriorityAssignment_2_2 )
            {
             before(grammarAccess.getTransitionAccess().getPriorityAssignment_2_2()); 
            // InternalIfictiondsl.g:1337:2: ( rule__Transition__PriorityAssignment_2_2 )
            // InternalIfictiondsl.g:1337:3: rule__Transition__PriorityAssignment_2_2
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
    // InternalIfictiondsl.g:1346:1: rule__Transition__Group_3__0 : rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1 ;
    public final void rule__Transition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1350:1: ( rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1 )
            // InternalIfictiondsl.g:1351:2: rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1
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
    // InternalIfictiondsl.g:1358:1: rule__Transition__Group_3__0__Impl : ( 'with' ) ;
    public final void rule__Transition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1362:1: ( ( 'with' ) )
            // InternalIfictiondsl.g:1363:1: ( 'with' )
            {
            // InternalIfictiondsl.g:1363:1: ( 'with' )
            // InternalIfictiondsl.g:1364:2: 'with'
            {
             before(grammarAccess.getTransitionAccess().getWithKeyword_3_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1373:1: rule__Transition__Group_3__1 : rule__Transition__Group_3__1__Impl rule__Transition__Group_3__2 ;
    public final void rule__Transition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1377:1: ( rule__Transition__Group_3__1__Impl rule__Transition__Group_3__2 )
            // InternalIfictiondsl.g:1378:2: rule__Transition__Group_3__1__Impl rule__Transition__Group_3__2
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
    // InternalIfictiondsl.g:1385:1: rule__Transition__Group_3__1__Impl : ( 'condition' ) ;
    public final void rule__Transition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1389:1: ( ( 'condition' ) )
            // InternalIfictiondsl.g:1390:1: ( 'condition' )
            {
            // InternalIfictiondsl.g:1390:1: ( 'condition' )
            // InternalIfictiondsl.g:1391:2: 'condition'
            {
             before(grammarAccess.getTransitionAccess().getConditionKeyword_3_1()); 
            match(input,31,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1400:1: rule__Transition__Group_3__2 : rule__Transition__Group_3__2__Impl rule__Transition__Group_3__3 ;
    public final void rule__Transition__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1404:1: ( rule__Transition__Group_3__2__Impl rule__Transition__Group_3__3 )
            // InternalIfictiondsl.g:1405:2: rule__Transition__Group_3__2__Impl rule__Transition__Group_3__3
            {
            pushFollow(FOLLOW_3);
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
    // InternalIfictiondsl.g:1412:1: rule__Transition__Group_3__2__Impl : ( ':' ) ;
    public final void rule__Transition__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1416:1: ( ( ':' ) )
            // InternalIfictiondsl.g:1417:1: ( ':' )
            {
            // InternalIfictiondsl.g:1417:1: ( ':' )
            // InternalIfictiondsl.g:1418:2: ':'
            {
             before(grammarAccess.getTransitionAccess().getColonKeyword_3_2()); 
            match(input,21,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1427:1: rule__Transition__Group_3__3 : rule__Transition__Group_3__3__Impl ;
    public final void rule__Transition__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1431:1: ( rule__Transition__Group_3__3__Impl )
            // InternalIfictiondsl.g:1432:2: rule__Transition__Group_3__3__Impl
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
    // InternalIfictiondsl.g:1438:1: rule__Transition__Group_3__3__Impl : ( ( rule__Transition__ConditionAssignment_3_3 ) ) ;
    public final void rule__Transition__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1442:1: ( ( ( rule__Transition__ConditionAssignment_3_3 ) ) )
            // InternalIfictiondsl.g:1443:1: ( ( rule__Transition__ConditionAssignment_3_3 ) )
            {
            // InternalIfictiondsl.g:1443:1: ( ( rule__Transition__ConditionAssignment_3_3 ) )
            // InternalIfictiondsl.g:1444:2: ( rule__Transition__ConditionAssignment_3_3 )
            {
             before(grammarAccess.getTransitionAccess().getConditionAssignment_3_3()); 
            // InternalIfictiondsl.g:1445:2: ( rule__Transition__ConditionAssignment_3_3 )
            // InternalIfictiondsl.g:1445:3: rule__Transition__ConditionAssignment_3_3
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
    // InternalIfictiondsl.g:1454:1: rule__StartNode__Group__0 : rule__StartNode__Group__0__Impl rule__StartNode__Group__1 ;
    public final void rule__StartNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1458:1: ( rule__StartNode__Group__0__Impl rule__StartNode__Group__1 )
            // InternalIfictiondsl.g:1459:2: rule__StartNode__Group__0__Impl rule__StartNode__Group__1
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
    // InternalIfictiondsl.g:1466:1: rule__StartNode__Group__0__Impl : ( 'StartNode' ) ;
    public final void rule__StartNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1470:1: ( ( 'StartNode' ) )
            // InternalIfictiondsl.g:1471:1: ( 'StartNode' )
            {
            // InternalIfictiondsl.g:1471:1: ( 'StartNode' )
            // InternalIfictiondsl.g:1472:2: 'StartNode'
            {
             before(grammarAccess.getStartNodeAccess().getStartNodeKeyword_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1481:1: rule__StartNode__Group__1 : rule__StartNode__Group__1__Impl rule__StartNode__Group__2 ;
    public final void rule__StartNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1485:1: ( rule__StartNode__Group__1__Impl rule__StartNode__Group__2 )
            // InternalIfictiondsl.g:1486:2: rule__StartNode__Group__1__Impl rule__StartNode__Group__2
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
    // InternalIfictiondsl.g:1493:1: rule__StartNode__Group__1__Impl : ( ( rule__StartNode__NameAssignment_1 ) ) ;
    public final void rule__StartNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1497:1: ( ( ( rule__StartNode__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:1498:1: ( ( rule__StartNode__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:1498:1: ( ( rule__StartNode__NameAssignment_1 ) )
            // InternalIfictiondsl.g:1499:2: ( rule__StartNode__NameAssignment_1 )
            {
             before(grammarAccess.getStartNodeAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:1500:2: ( rule__StartNode__NameAssignment_1 )
            // InternalIfictiondsl.g:1500:3: rule__StartNode__NameAssignment_1
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
    // InternalIfictiondsl.g:1508:1: rule__StartNode__Group__2 : rule__StartNode__Group__2__Impl rule__StartNode__Group__3 ;
    public final void rule__StartNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1512:1: ( rule__StartNode__Group__2__Impl rule__StartNode__Group__3 )
            // InternalIfictiondsl.g:1513:2: rule__StartNode__Group__2__Impl rule__StartNode__Group__3
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
    // InternalIfictiondsl.g:1520:1: rule__StartNode__Group__2__Impl : ( '{' ) ;
    public final void rule__StartNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1524:1: ( ( '{' ) )
            // InternalIfictiondsl.g:1525:1: ( '{' )
            {
            // InternalIfictiondsl.g:1525:1: ( '{' )
            // InternalIfictiondsl.g:1526:2: '{'
            {
             before(grammarAccess.getStartNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1535:1: rule__StartNode__Group__3 : rule__StartNode__Group__3__Impl rule__StartNode__Group__4 ;
    public final void rule__StartNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1539:1: ( rule__StartNode__Group__3__Impl rule__StartNode__Group__4 )
            // InternalIfictiondsl.g:1540:2: rule__StartNode__Group__3__Impl rule__StartNode__Group__4
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
    // InternalIfictiondsl.g:1547:1: rule__StartNode__Group__3__Impl : ( 'displayText' ) ;
    public final void rule__StartNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1551:1: ( ( 'displayText' ) )
            // InternalIfictiondsl.g:1552:1: ( 'displayText' )
            {
            // InternalIfictiondsl.g:1552:1: ( 'displayText' )
            // InternalIfictiondsl.g:1553:2: 'displayText'
            {
             before(grammarAccess.getStartNodeAccess().getDisplayTextKeyword_3()); 
            match(input,27,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1562:1: rule__StartNode__Group__4 : rule__StartNode__Group__4__Impl rule__StartNode__Group__5 ;
    public final void rule__StartNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1566:1: ( rule__StartNode__Group__4__Impl rule__StartNode__Group__5 )
            // InternalIfictiondsl.g:1567:2: rule__StartNode__Group__4__Impl rule__StartNode__Group__5
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
    // InternalIfictiondsl.g:1574:1: rule__StartNode__Group__4__Impl : ( ':' ) ;
    public final void rule__StartNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1578:1: ( ( ':' ) )
            // InternalIfictiondsl.g:1579:1: ( ':' )
            {
            // InternalIfictiondsl.g:1579:1: ( ':' )
            // InternalIfictiondsl.g:1580:2: ':'
            {
             before(grammarAccess.getStartNodeAccess().getColonKeyword_4()); 
            match(input,21,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1589:1: rule__StartNode__Group__5 : rule__StartNode__Group__5__Impl rule__StartNode__Group__6 ;
    public final void rule__StartNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1593:1: ( rule__StartNode__Group__5__Impl rule__StartNode__Group__6 )
            // InternalIfictiondsl.g:1594:2: rule__StartNode__Group__5__Impl rule__StartNode__Group__6
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
    // InternalIfictiondsl.g:1601:1: rule__StartNode__Group__5__Impl : ( ( rule__StartNode__TextAssignment_5 ) ) ;
    public final void rule__StartNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1605:1: ( ( ( rule__StartNode__TextAssignment_5 ) ) )
            // InternalIfictiondsl.g:1606:1: ( ( rule__StartNode__TextAssignment_5 ) )
            {
            // InternalIfictiondsl.g:1606:1: ( ( rule__StartNode__TextAssignment_5 ) )
            // InternalIfictiondsl.g:1607:2: ( rule__StartNode__TextAssignment_5 )
            {
             before(grammarAccess.getStartNodeAccess().getTextAssignment_5()); 
            // InternalIfictiondsl.g:1608:2: ( rule__StartNode__TextAssignment_5 )
            // InternalIfictiondsl.g:1608:3: rule__StartNode__TextAssignment_5
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
    // InternalIfictiondsl.g:1616:1: rule__StartNode__Group__6 : rule__StartNode__Group__6__Impl rule__StartNode__Group__7 ;
    public final void rule__StartNode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1620:1: ( rule__StartNode__Group__6__Impl rule__StartNode__Group__7 )
            // InternalIfictiondsl.g:1621:2: rule__StartNode__Group__6__Impl rule__StartNode__Group__7
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
    // InternalIfictiondsl.g:1628:1: rule__StartNode__Group__6__Impl : ( ',' ) ;
    public final void rule__StartNode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1632:1: ( ( ',' ) )
            // InternalIfictiondsl.g:1633:1: ( ',' )
            {
            // InternalIfictiondsl.g:1633:1: ( ',' )
            // InternalIfictiondsl.g:1634:2: ','
            {
             before(grammarAccess.getStartNodeAccess().getCommaKeyword_6()); 
            match(input,25,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1643:1: rule__StartNode__Group__7 : rule__StartNode__Group__7__Impl rule__StartNode__Group__8 ;
    public final void rule__StartNode__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1647:1: ( rule__StartNode__Group__7__Impl rule__StartNode__Group__8 )
            // InternalIfictiondsl.g:1648:2: rule__StartNode__Group__7__Impl rule__StartNode__Group__8
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
    // InternalIfictiondsl.g:1655:1: rule__StartNode__Group__7__Impl : ( ( rule__StartNode__TransitionAssignment_7 ) ) ;
    public final void rule__StartNode__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1659:1: ( ( ( rule__StartNode__TransitionAssignment_7 ) ) )
            // InternalIfictiondsl.g:1660:1: ( ( rule__StartNode__TransitionAssignment_7 ) )
            {
            // InternalIfictiondsl.g:1660:1: ( ( rule__StartNode__TransitionAssignment_7 ) )
            // InternalIfictiondsl.g:1661:2: ( rule__StartNode__TransitionAssignment_7 )
            {
             before(grammarAccess.getStartNodeAccess().getTransitionAssignment_7()); 
            // InternalIfictiondsl.g:1662:2: ( rule__StartNode__TransitionAssignment_7 )
            // InternalIfictiondsl.g:1662:3: rule__StartNode__TransitionAssignment_7
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
    // InternalIfictiondsl.g:1670:1: rule__StartNode__Group__8 : rule__StartNode__Group__8__Impl ;
    public final void rule__StartNode__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1674:1: ( rule__StartNode__Group__8__Impl )
            // InternalIfictiondsl.g:1675:2: rule__StartNode__Group__8__Impl
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
    // InternalIfictiondsl.g:1681:1: rule__StartNode__Group__8__Impl : ( '}' ) ;
    public final void rule__StartNode__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1685:1: ( ( '}' ) )
            // InternalIfictiondsl.g:1686:1: ( '}' )
            {
            // InternalIfictiondsl.g:1686:1: ( '}' )
            // InternalIfictiondsl.g:1687:2: '}'
            {
             before(grammarAccess.getStartNodeAccess().getRightCurlyBracketKeyword_8()); 
            match(input,24,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1697:1: rule__DialogueNode__Group__0 : rule__DialogueNode__Group__0__Impl rule__DialogueNode__Group__1 ;
    public final void rule__DialogueNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1701:1: ( rule__DialogueNode__Group__0__Impl rule__DialogueNode__Group__1 )
            // InternalIfictiondsl.g:1702:2: rule__DialogueNode__Group__0__Impl rule__DialogueNode__Group__1
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
    // InternalIfictiondsl.g:1709:1: rule__DialogueNode__Group__0__Impl : ( 'DialogueNode' ) ;
    public final void rule__DialogueNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1713:1: ( ( 'DialogueNode' ) )
            // InternalIfictiondsl.g:1714:1: ( 'DialogueNode' )
            {
            // InternalIfictiondsl.g:1714:1: ( 'DialogueNode' )
            // InternalIfictiondsl.g:1715:2: 'DialogueNode'
            {
             before(grammarAccess.getDialogueNodeAccess().getDialogueNodeKeyword_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1724:1: rule__DialogueNode__Group__1 : rule__DialogueNode__Group__1__Impl rule__DialogueNode__Group__2 ;
    public final void rule__DialogueNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1728:1: ( rule__DialogueNode__Group__1__Impl rule__DialogueNode__Group__2 )
            // InternalIfictiondsl.g:1729:2: rule__DialogueNode__Group__1__Impl rule__DialogueNode__Group__2
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
    // InternalIfictiondsl.g:1736:1: rule__DialogueNode__Group__1__Impl : ( ( rule__DialogueNode__NameAssignment_1 ) ) ;
    public final void rule__DialogueNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1740:1: ( ( ( rule__DialogueNode__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:1741:1: ( ( rule__DialogueNode__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:1741:1: ( ( rule__DialogueNode__NameAssignment_1 ) )
            // InternalIfictiondsl.g:1742:2: ( rule__DialogueNode__NameAssignment_1 )
            {
             before(grammarAccess.getDialogueNodeAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:1743:2: ( rule__DialogueNode__NameAssignment_1 )
            // InternalIfictiondsl.g:1743:3: rule__DialogueNode__NameAssignment_1
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
    // InternalIfictiondsl.g:1751:1: rule__DialogueNode__Group__2 : rule__DialogueNode__Group__2__Impl rule__DialogueNode__Group__3 ;
    public final void rule__DialogueNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1755:1: ( rule__DialogueNode__Group__2__Impl rule__DialogueNode__Group__3 )
            // InternalIfictiondsl.g:1756:2: rule__DialogueNode__Group__2__Impl rule__DialogueNode__Group__3
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
    // InternalIfictiondsl.g:1763:1: rule__DialogueNode__Group__2__Impl : ( '{' ) ;
    public final void rule__DialogueNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1767:1: ( ( '{' ) )
            // InternalIfictiondsl.g:1768:1: ( '{' )
            {
            // InternalIfictiondsl.g:1768:1: ( '{' )
            // InternalIfictiondsl.g:1769:2: '{'
            {
             before(grammarAccess.getDialogueNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1778:1: rule__DialogueNode__Group__3 : rule__DialogueNode__Group__3__Impl rule__DialogueNode__Group__4 ;
    public final void rule__DialogueNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1782:1: ( rule__DialogueNode__Group__3__Impl rule__DialogueNode__Group__4 )
            // InternalIfictiondsl.g:1783:2: rule__DialogueNode__Group__3__Impl rule__DialogueNode__Group__4
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
    // InternalIfictiondsl.g:1790:1: rule__DialogueNode__Group__3__Impl : ( 'displayText' ) ;
    public final void rule__DialogueNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1794:1: ( ( 'displayText' ) )
            // InternalIfictiondsl.g:1795:1: ( 'displayText' )
            {
            // InternalIfictiondsl.g:1795:1: ( 'displayText' )
            // InternalIfictiondsl.g:1796:2: 'displayText'
            {
             before(grammarAccess.getDialogueNodeAccess().getDisplayTextKeyword_3()); 
            match(input,27,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1805:1: rule__DialogueNode__Group__4 : rule__DialogueNode__Group__4__Impl rule__DialogueNode__Group__5 ;
    public final void rule__DialogueNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1809:1: ( rule__DialogueNode__Group__4__Impl rule__DialogueNode__Group__5 )
            // InternalIfictiondsl.g:1810:2: rule__DialogueNode__Group__4__Impl rule__DialogueNode__Group__5
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
    // InternalIfictiondsl.g:1817:1: rule__DialogueNode__Group__4__Impl : ( ':' ) ;
    public final void rule__DialogueNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1821:1: ( ( ':' ) )
            // InternalIfictiondsl.g:1822:1: ( ':' )
            {
            // InternalIfictiondsl.g:1822:1: ( ':' )
            // InternalIfictiondsl.g:1823:2: ':'
            {
             before(grammarAccess.getDialogueNodeAccess().getColonKeyword_4()); 
            match(input,21,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1832:1: rule__DialogueNode__Group__5 : rule__DialogueNode__Group__5__Impl rule__DialogueNode__Group__6 ;
    public final void rule__DialogueNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1836:1: ( rule__DialogueNode__Group__5__Impl rule__DialogueNode__Group__6 )
            // InternalIfictiondsl.g:1837:2: rule__DialogueNode__Group__5__Impl rule__DialogueNode__Group__6
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
    // InternalIfictiondsl.g:1844:1: rule__DialogueNode__Group__5__Impl : ( ( rule__DialogueNode__TextAssignment_5 ) ) ;
    public final void rule__DialogueNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1848:1: ( ( ( rule__DialogueNode__TextAssignment_5 ) ) )
            // InternalIfictiondsl.g:1849:1: ( ( rule__DialogueNode__TextAssignment_5 ) )
            {
            // InternalIfictiondsl.g:1849:1: ( ( rule__DialogueNode__TextAssignment_5 ) )
            // InternalIfictiondsl.g:1850:2: ( rule__DialogueNode__TextAssignment_5 )
            {
             before(grammarAccess.getDialogueNodeAccess().getTextAssignment_5()); 
            // InternalIfictiondsl.g:1851:2: ( rule__DialogueNode__TextAssignment_5 )
            // InternalIfictiondsl.g:1851:3: rule__DialogueNode__TextAssignment_5
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
    // InternalIfictiondsl.g:1859:1: rule__DialogueNode__Group__6 : rule__DialogueNode__Group__6__Impl rule__DialogueNode__Group__7 ;
    public final void rule__DialogueNode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1863:1: ( rule__DialogueNode__Group__6__Impl rule__DialogueNode__Group__7 )
            // InternalIfictiondsl.g:1864:2: rule__DialogueNode__Group__6__Impl rule__DialogueNode__Group__7
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
    // InternalIfictiondsl.g:1871:1: rule__DialogueNode__Group__6__Impl : ( ',' ) ;
    public final void rule__DialogueNode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1875:1: ( ( ',' ) )
            // InternalIfictiondsl.g:1876:1: ( ',' )
            {
            // InternalIfictiondsl.g:1876:1: ( ',' )
            // InternalIfictiondsl.g:1877:2: ','
            {
             before(grammarAccess.getDialogueNodeAccess().getCommaKeyword_6()); 
            match(input,25,FOLLOW_2); 
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
    // InternalIfictiondsl.g:1886:1: rule__DialogueNode__Group__7 : rule__DialogueNode__Group__7__Impl rule__DialogueNode__Group__8 ;
    public final void rule__DialogueNode__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1890:1: ( rule__DialogueNode__Group__7__Impl rule__DialogueNode__Group__8 )
            // InternalIfictiondsl.g:1891:2: rule__DialogueNode__Group__7__Impl rule__DialogueNode__Group__8
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
    // InternalIfictiondsl.g:1898:1: rule__DialogueNode__Group__7__Impl : ( ( rule__DialogueNode__TransitionAssignment_7 ) ) ;
    public final void rule__DialogueNode__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1902:1: ( ( ( rule__DialogueNode__TransitionAssignment_7 ) ) )
            // InternalIfictiondsl.g:1903:1: ( ( rule__DialogueNode__TransitionAssignment_7 ) )
            {
            // InternalIfictiondsl.g:1903:1: ( ( rule__DialogueNode__TransitionAssignment_7 ) )
            // InternalIfictiondsl.g:1904:2: ( rule__DialogueNode__TransitionAssignment_7 )
            {
             before(grammarAccess.getDialogueNodeAccess().getTransitionAssignment_7()); 
            // InternalIfictiondsl.g:1905:2: ( rule__DialogueNode__TransitionAssignment_7 )
            // InternalIfictiondsl.g:1905:3: rule__DialogueNode__TransitionAssignment_7
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
    // InternalIfictiondsl.g:1913:1: rule__DialogueNode__Group__8 : rule__DialogueNode__Group__8__Impl ;
    public final void rule__DialogueNode__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1917:1: ( rule__DialogueNode__Group__8__Impl )
            // InternalIfictiondsl.g:1918:2: rule__DialogueNode__Group__8__Impl
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
    // InternalIfictiondsl.g:1924:1: rule__DialogueNode__Group__8__Impl : ( '}' ) ;
    public final void rule__DialogueNode__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1928:1: ( ( '}' ) )
            // InternalIfictiondsl.g:1929:1: ( '}' )
            {
            // InternalIfictiondsl.g:1929:1: ( '}' )
            // InternalIfictiondsl.g:1930:2: '}'
            {
             before(grammarAccess.getDialogueNodeAccess().getRightCurlyBracketKeyword_8()); 
            match(input,24,FOLLOW_2); 
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


    // $ANTLR start "rule__Condition__Group__0"
    // InternalIfictiondsl.g:1940:1: rule__Condition__Group__0 : rule__Condition__Group__0__Impl rule__Condition__Group__1 ;
    public final void rule__Condition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1944:1: ( rule__Condition__Group__0__Impl rule__Condition__Group__1 )
            // InternalIfictiondsl.g:1945:2: rule__Condition__Group__0__Impl rule__Condition__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__Condition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__1();

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
    // $ANTLR end "rule__Condition__Group__0"


    // $ANTLR start "rule__Condition__Group__0__Impl"
    // InternalIfictiondsl.g:1952:1: rule__Condition__Group__0__Impl : ( ( rule__Condition__VariableAssignment_0 ) ) ;
    public final void rule__Condition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1956:1: ( ( ( rule__Condition__VariableAssignment_0 ) ) )
            // InternalIfictiondsl.g:1957:1: ( ( rule__Condition__VariableAssignment_0 ) )
            {
            // InternalIfictiondsl.g:1957:1: ( ( rule__Condition__VariableAssignment_0 ) )
            // InternalIfictiondsl.g:1958:2: ( rule__Condition__VariableAssignment_0 )
            {
             before(grammarAccess.getConditionAccess().getVariableAssignment_0()); 
            // InternalIfictiondsl.g:1959:2: ( rule__Condition__VariableAssignment_0 )
            // InternalIfictiondsl.g:1959:3: rule__Condition__VariableAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Condition__VariableAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getVariableAssignment_0()); 

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
    // $ANTLR end "rule__Condition__Group__0__Impl"


    // $ANTLR start "rule__Condition__Group__1"
    // InternalIfictiondsl.g:1967:1: rule__Condition__Group__1 : rule__Condition__Group__1__Impl rule__Condition__Group__2 ;
    public final void rule__Condition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1971:1: ( rule__Condition__Group__1__Impl rule__Condition__Group__2 )
            // InternalIfictiondsl.g:1972:2: rule__Condition__Group__1__Impl rule__Condition__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__Condition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__2();

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
    // $ANTLR end "rule__Condition__Group__1"


    // $ANTLR start "rule__Condition__Group__1__Impl"
    // InternalIfictiondsl.g:1979:1: rule__Condition__Group__1__Impl : ( ( rule__Condition__OperatorAssignment_1 ) ) ;
    public final void rule__Condition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1983:1: ( ( ( rule__Condition__OperatorAssignment_1 ) ) )
            // InternalIfictiondsl.g:1984:1: ( ( rule__Condition__OperatorAssignment_1 ) )
            {
            // InternalIfictiondsl.g:1984:1: ( ( rule__Condition__OperatorAssignment_1 ) )
            // InternalIfictiondsl.g:1985:2: ( rule__Condition__OperatorAssignment_1 )
            {
             before(grammarAccess.getConditionAccess().getOperatorAssignment_1()); 
            // InternalIfictiondsl.g:1986:2: ( rule__Condition__OperatorAssignment_1 )
            // InternalIfictiondsl.g:1986:3: rule__Condition__OperatorAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Condition__OperatorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getOperatorAssignment_1()); 

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
    // $ANTLR end "rule__Condition__Group__1__Impl"


    // $ANTLR start "rule__Condition__Group__2"
    // InternalIfictiondsl.g:1994:1: rule__Condition__Group__2 : rule__Condition__Group__2__Impl ;
    public final void rule__Condition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:1998:1: ( rule__Condition__Group__2__Impl )
            // InternalIfictiondsl.g:1999:2: rule__Condition__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__2__Impl();

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
    // $ANTLR end "rule__Condition__Group__2"


    // $ANTLR start "rule__Condition__Group__2__Impl"
    // InternalIfictiondsl.g:2005:1: rule__Condition__Group__2__Impl : ( ( rule__Condition__ValueAssignment_2 ) ) ;
    public final void rule__Condition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2009:1: ( ( ( rule__Condition__ValueAssignment_2 ) ) )
            // InternalIfictiondsl.g:2010:1: ( ( rule__Condition__ValueAssignment_2 ) )
            {
            // InternalIfictiondsl.g:2010:1: ( ( rule__Condition__ValueAssignment_2 ) )
            // InternalIfictiondsl.g:2011:2: ( rule__Condition__ValueAssignment_2 )
            {
             before(grammarAccess.getConditionAccess().getValueAssignment_2()); 
            // InternalIfictiondsl.g:2012:2: ( rule__Condition__ValueAssignment_2 )
            // InternalIfictiondsl.g:2012:3: rule__Condition__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Condition__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getValueAssignment_2()); 

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
    // $ANTLR end "rule__Condition__Group__2__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__0"
    // InternalIfictiondsl.g:2021:1: rule__SystemStateChangeNode__Group__0 : rule__SystemStateChangeNode__Group__0__Impl rule__SystemStateChangeNode__Group__1 ;
    public final void rule__SystemStateChangeNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2025:1: ( rule__SystemStateChangeNode__Group__0__Impl rule__SystemStateChangeNode__Group__1 )
            // InternalIfictiondsl.g:2026:2: rule__SystemStateChangeNode__Group__0__Impl rule__SystemStateChangeNode__Group__1
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
    // InternalIfictiondsl.g:2033:1: rule__SystemStateChangeNode__Group__0__Impl : ( 'SystemStateChangeNode' ) ;
    public final void rule__SystemStateChangeNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2037:1: ( ( 'SystemStateChangeNode' ) )
            // InternalIfictiondsl.g:2038:1: ( 'SystemStateChangeNode' )
            {
            // InternalIfictiondsl.g:2038:1: ( 'SystemStateChangeNode' )
            // InternalIfictiondsl.g:2039:2: 'SystemStateChangeNode'
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getSystemStateChangeNodeKeyword_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalIfictiondsl.g:2048:1: rule__SystemStateChangeNode__Group__1 : rule__SystemStateChangeNode__Group__1__Impl rule__SystemStateChangeNode__Group__2 ;
    public final void rule__SystemStateChangeNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2052:1: ( rule__SystemStateChangeNode__Group__1__Impl rule__SystemStateChangeNode__Group__2 )
            // InternalIfictiondsl.g:2053:2: rule__SystemStateChangeNode__Group__1__Impl rule__SystemStateChangeNode__Group__2
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
    // InternalIfictiondsl.g:2060:1: rule__SystemStateChangeNode__Group__1__Impl : ( ( rule__SystemStateChangeNode__NameAssignment_1 ) ) ;
    public final void rule__SystemStateChangeNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2064:1: ( ( ( rule__SystemStateChangeNode__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:2065:1: ( ( rule__SystemStateChangeNode__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:2065:1: ( ( rule__SystemStateChangeNode__NameAssignment_1 ) )
            // InternalIfictiondsl.g:2066:2: ( rule__SystemStateChangeNode__NameAssignment_1 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:2067:2: ( rule__SystemStateChangeNode__NameAssignment_1 )
            // InternalIfictiondsl.g:2067:3: rule__SystemStateChangeNode__NameAssignment_1
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
    // InternalIfictiondsl.g:2075:1: rule__SystemStateChangeNode__Group__2 : rule__SystemStateChangeNode__Group__2__Impl rule__SystemStateChangeNode__Group__3 ;
    public final void rule__SystemStateChangeNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2079:1: ( rule__SystemStateChangeNode__Group__2__Impl rule__SystemStateChangeNode__Group__3 )
            // InternalIfictiondsl.g:2080:2: rule__SystemStateChangeNode__Group__2__Impl rule__SystemStateChangeNode__Group__3
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
    // InternalIfictiondsl.g:2087:1: rule__SystemStateChangeNode__Group__2__Impl : ( '{' ) ;
    public final void rule__SystemStateChangeNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2091:1: ( ( '{' ) )
            // InternalIfictiondsl.g:2092:1: ( '{' )
            {
            // InternalIfictiondsl.g:2092:1: ( '{' )
            // InternalIfictiondsl.g:2093:2: '{'
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_2); 
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
    // InternalIfictiondsl.g:2102:1: rule__SystemStateChangeNode__Group__3 : rule__SystemStateChangeNode__Group__3__Impl rule__SystemStateChangeNode__Group__4 ;
    public final void rule__SystemStateChangeNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2106:1: ( rule__SystemStateChangeNode__Group__3__Impl rule__SystemStateChangeNode__Group__4 )
            // InternalIfictiondsl.g:2107:2: rule__SystemStateChangeNode__Group__3__Impl rule__SystemStateChangeNode__Group__4
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
    // InternalIfictiondsl.g:2114:1: rule__SystemStateChangeNode__Group__3__Impl : ( 'displayText' ) ;
    public final void rule__SystemStateChangeNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2118:1: ( ( 'displayText' ) )
            // InternalIfictiondsl.g:2119:1: ( 'displayText' )
            {
            // InternalIfictiondsl.g:2119:1: ( 'displayText' )
            // InternalIfictiondsl.g:2120:2: 'displayText'
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getDisplayTextKeyword_3()); 
            match(input,27,FOLLOW_2); 
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
    // InternalIfictiondsl.g:2129:1: rule__SystemStateChangeNode__Group__4 : rule__SystemStateChangeNode__Group__4__Impl rule__SystemStateChangeNode__Group__5 ;
    public final void rule__SystemStateChangeNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2133:1: ( rule__SystemStateChangeNode__Group__4__Impl rule__SystemStateChangeNode__Group__5 )
            // InternalIfictiondsl.g:2134:2: rule__SystemStateChangeNode__Group__4__Impl rule__SystemStateChangeNode__Group__5
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
    // InternalIfictiondsl.g:2141:1: rule__SystemStateChangeNode__Group__4__Impl : ( ':' ) ;
    public final void rule__SystemStateChangeNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2145:1: ( ( ':' ) )
            // InternalIfictiondsl.g:2146:1: ( ':' )
            {
            // InternalIfictiondsl.g:2146:1: ( ':' )
            // InternalIfictiondsl.g:2147:2: ':'
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getColonKeyword_4()); 
            match(input,21,FOLLOW_2); 
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
    // InternalIfictiondsl.g:2156:1: rule__SystemStateChangeNode__Group__5 : rule__SystemStateChangeNode__Group__5__Impl rule__SystemStateChangeNode__Group__6 ;
    public final void rule__SystemStateChangeNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2160:1: ( rule__SystemStateChangeNode__Group__5__Impl rule__SystemStateChangeNode__Group__6 )
            // InternalIfictiondsl.g:2161:2: rule__SystemStateChangeNode__Group__5__Impl rule__SystemStateChangeNode__Group__6
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
    // InternalIfictiondsl.g:2168:1: rule__SystemStateChangeNode__Group__5__Impl : ( ( rule__SystemStateChangeNode__TextAssignment_5 ) ) ;
    public final void rule__SystemStateChangeNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2172:1: ( ( ( rule__SystemStateChangeNode__TextAssignment_5 ) ) )
            // InternalIfictiondsl.g:2173:1: ( ( rule__SystemStateChangeNode__TextAssignment_5 ) )
            {
            // InternalIfictiondsl.g:2173:1: ( ( rule__SystemStateChangeNode__TextAssignment_5 ) )
            // InternalIfictiondsl.g:2174:2: ( rule__SystemStateChangeNode__TextAssignment_5 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getTextAssignment_5()); 
            // InternalIfictiondsl.g:2175:2: ( rule__SystemStateChangeNode__TextAssignment_5 )
            // InternalIfictiondsl.g:2175:3: rule__SystemStateChangeNode__TextAssignment_5
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
    // InternalIfictiondsl.g:2183:1: rule__SystemStateChangeNode__Group__6 : rule__SystemStateChangeNode__Group__6__Impl rule__SystemStateChangeNode__Group__7 ;
    public final void rule__SystemStateChangeNode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2187:1: ( rule__SystemStateChangeNode__Group__6__Impl rule__SystemStateChangeNode__Group__7 )
            // InternalIfictiondsl.g:2188:2: rule__SystemStateChangeNode__Group__6__Impl rule__SystemStateChangeNode__Group__7
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
    // InternalIfictiondsl.g:2195:1: rule__SystemStateChangeNode__Group__6__Impl : ( ',' ) ;
    public final void rule__SystemStateChangeNode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2199:1: ( ( ',' ) )
            // InternalIfictiondsl.g:2200:1: ( ',' )
            {
            // InternalIfictiondsl.g:2200:1: ( ',' )
            // InternalIfictiondsl.g:2201:2: ','
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getCommaKeyword_6()); 
            match(input,25,FOLLOW_2); 
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
    // InternalIfictiondsl.g:2210:1: rule__SystemStateChangeNode__Group__7 : rule__SystemStateChangeNode__Group__7__Impl rule__SystemStateChangeNode__Group__8 ;
    public final void rule__SystemStateChangeNode__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2214:1: ( rule__SystemStateChangeNode__Group__7__Impl rule__SystemStateChangeNode__Group__8 )
            // InternalIfictiondsl.g:2215:2: rule__SystemStateChangeNode__Group__7__Impl rule__SystemStateChangeNode__Group__8
            {
            pushFollow(FOLLOW_23);
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
    // InternalIfictiondsl.g:2222:1: rule__SystemStateChangeNode__Group__7__Impl : ( ( rule__SystemStateChangeNode__VariableAssignment_7 ) ) ;
    public final void rule__SystemStateChangeNode__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2226:1: ( ( ( rule__SystemStateChangeNode__VariableAssignment_7 ) ) )
            // InternalIfictiondsl.g:2227:1: ( ( rule__SystemStateChangeNode__VariableAssignment_7 ) )
            {
            // InternalIfictiondsl.g:2227:1: ( ( rule__SystemStateChangeNode__VariableAssignment_7 ) )
            // InternalIfictiondsl.g:2228:2: ( rule__SystemStateChangeNode__VariableAssignment_7 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getVariableAssignment_7()); 
            // InternalIfictiondsl.g:2229:2: ( rule__SystemStateChangeNode__VariableAssignment_7 )
            // InternalIfictiondsl.g:2229:3: rule__SystemStateChangeNode__VariableAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__VariableAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getVariableAssignment_7()); 

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
    // InternalIfictiondsl.g:2237:1: rule__SystemStateChangeNode__Group__8 : rule__SystemStateChangeNode__Group__8__Impl rule__SystemStateChangeNode__Group__9 ;
    public final void rule__SystemStateChangeNode__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2241:1: ( rule__SystemStateChangeNode__Group__8__Impl rule__SystemStateChangeNode__Group__9 )
            // InternalIfictiondsl.g:2242:2: rule__SystemStateChangeNode__Group__8__Impl rule__SystemStateChangeNode__Group__9
            {
            pushFollow(FOLLOW_20);
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
    // InternalIfictiondsl.g:2249:1: rule__SystemStateChangeNode__Group__8__Impl : ( ( rule__SystemStateChangeNode__OperatorAssignment_8 ) ) ;
    public final void rule__SystemStateChangeNode__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2253:1: ( ( ( rule__SystemStateChangeNode__OperatorAssignment_8 ) ) )
            // InternalIfictiondsl.g:2254:1: ( ( rule__SystemStateChangeNode__OperatorAssignment_8 ) )
            {
            // InternalIfictiondsl.g:2254:1: ( ( rule__SystemStateChangeNode__OperatorAssignment_8 ) )
            // InternalIfictiondsl.g:2255:2: ( rule__SystemStateChangeNode__OperatorAssignment_8 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getOperatorAssignment_8()); 
            // InternalIfictiondsl.g:2256:2: ( rule__SystemStateChangeNode__OperatorAssignment_8 )
            // InternalIfictiondsl.g:2256:3: rule__SystemStateChangeNode__OperatorAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__OperatorAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getOperatorAssignment_8()); 

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
    // InternalIfictiondsl.g:2264:1: rule__SystemStateChangeNode__Group__9 : rule__SystemStateChangeNode__Group__9__Impl rule__SystemStateChangeNode__Group__10 ;
    public final void rule__SystemStateChangeNode__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2268:1: ( rule__SystemStateChangeNode__Group__9__Impl rule__SystemStateChangeNode__Group__10 )
            // InternalIfictiondsl.g:2269:2: rule__SystemStateChangeNode__Group__9__Impl rule__SystemStateChangeNode__Group__10
            {
            pushFollow(FOLLOW_12);
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
    // InternalIfictiondsl.g:2276:1: rule__SystemStateChangeNode__Group__9__Impl : ( ( rule__SystemStateChangeNode__ValueAssignment_9 ) ) ;
    public final void rule__SystemStateChangeNode__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2280:1: ( ( ( rule__SystemStateChangeNode__ValueAssignment_9 ) ) )
            // InternalIfictiondsl.g:2281:1: ( ( rule__SystemStateChangeNode__ValueAssignment_9 ) )
            {
            // InternalIfictiondsl.g:2281:1: ( ( rule__SystemStateChangeNode__ValueAssignment_9 ) )
            // InternalIfictiondsl.g:2282:2: ( rule__SystemStateChangeNode__ValueAssignment_9 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getValueAssignment_9()); 
            // InternalIfictiondsl.g:2283:2: ( rule__SystemStateChangeNode__ValueAssignment_9 )
            // InternalIfictiondsl.g:2283:3: rule__SystemStateChangeNode__ValueAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__ValueAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getValueAssignment_9()); 

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
    // InternalIfictiondsl.g:2291:1: rule__SystemStateChangeNode__Group__10 : rule__SystemStateChangeNode__Group__10__Impl rule__SystemStateChangeNode__Group__11 ;
    public final void rule__SystemStateChangeNode__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2295:1: ( rule__SystemStateChangeNode__Group__10__Impl rule__SystemStateChangeNode__Group__11 )
            // InternalIfictiondsl.g:2296:2: rule__SystemStateChangeNode__Group__10__Impl rule__SystemStateChangeNode__Group__11
            {
            pushFollow(FOLLOW_17);
            rule__SystemStateChangeNode__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__11();

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
    // InternalIfictiondsl.g:2303:1: rule__SystemStateChangeNode__Group__10__Impl : ( ',' ) ;
    public final void rule__SystemStateChangeNode__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2307:1: ( ( ',' ) )
            // InternalIfictiondsl.g:2308:1: ( ',' )
            {
            // InternalIfictiondsl.g:2308:1: ( ',' )
            // InternalIfictiondsl.g:2309:2: ','
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getCommaKeyword_10()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getCommaKeyword_10()); 

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


    // $ANTLR start "rule__SystemStateChangeNode__Group__11"
    // InternalIfictiondsl.g:2318:1: rule__SystemStateChangeNode__Group__11 : rule__SystemStateChangeNode__Group__11__Impl rule__SystemStateChangeNode__Group__12 ;
    public final void rule__SystemStateChangeNode__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2322:1: ( rule__SystemStateChangeNode__Group__11__Impl rule__SystemStateChangeNode__Group__12 )
            // InternalIfictiondsl.g:2323:2: rule__SystemStateChangeNode__Group__11__Impl rule__SystemStateChangeNode__Group__12
            {
            pushFollow(FOLLOW_11);
            rule__SystemStateChangeNode__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__12();

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
    // $ANTLR end "rule__SystemStateChangeNode__Group__11"


    // $ANTLR start "rule__SystemStateChangeNode__Group__11__Impl"
    // InternalIfictiondsl.g:2330:1: rule__SystemStateChangeNode__Group__11__Impl : ( ( rule__SystemStateChangeNode__TransitionAssignment_11 ) ) ;
    public final void rule__SystemStateChangeNode__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2334:1: ( ( ( rule__SystemStateChangeNode__TransitionAssignment_11 ) ) )
            // InternalIfictiondsl.g:2335:1: ( ( rule__SystemStateChangeNode__TransitionAssignment_11 ) )
            {
            // InternalIfictiondsl.g:2335:1: ( ( rule__SystemStateChangeNode__TransitionAssignment_11 ) )
            // InternalIfictiondsl.g:2336:2: ( rule__SystemStateChangeNode__TransitionAssignment_11 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getTransitionAssignment_11()); 
            // InternalIfictiondsl.g:2337:2: ( rule__SystemStateChangeNode__TransitionAssignment_11 )
            // InternalIfictiondsl.g:2337:3: rule__SystemStateChangeNode__TransitionAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__TransitionAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getTransitionAssignment_11()); 

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
    // $ANTLR end "rule__SystemStateChangeNode__Group__11__Impl"


    // $ANTLR start "rule__SystemStateChangeNode__Group__12"
    // InternalIfictiondsl.g:2345:1: rule__SystemStateChangeNode__Group__12 : rule__SystemStateChangeNode__Group__12__Impl ;
    public final void rule__SystemStateChangeNode__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2349:1: ( rule__SystemStateChangeNode__Group__12__Impl )
            // InternalIfictiondsl.g:2350:2: rule__SystemStateChangeNode__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__Group__12__Impl();

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
    // $ANTLR end "rule__SystemStateChangeNode__Group__12"


    // $ANTLR start "rule__SystemStateChangeNode__Group__12__Impl"
    // InternalIfictiondsl.g:2356:1: rule__SystemStateChangeNode__Group__12__Impl : ( '}' ) ;
    public final void rule__SystemStateChangeNode__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2360:1: ( ( '}' ) )
            // InternalIfictiondsl.g:2361:1: ( '}' )
            {
            // InternalIfictiondsl.g:2361:1: ( '}' )
            // InternalIfictiondsl.g:2362:2: '}'
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getRightCurlyBracketKeyword_12()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getRightCurlyBracketKeyword_12()); 

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
    // $ANTLR end "rule__SystemStateChangeNode__Group__12__Impl"


    // $ANTLR start "rule__EndNode__Group__0"
    // InternalIfictiondsl.g:2372:1: rule__EndNode__Group__0 : rule__EndNode__Group__0__Impl rule__EndNode__Group__1 ;
    public final void rule__EndNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2376:1: ( rule__EndNode__Group__0__Impl rule__EndNode__Group__1 )
            // InternalIfictiondsl.g:2377:2: rule__EndNode__Group__0__Impl rule__EndNode__Group__1
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
    // InternalIfictiondsl.g:2384:1: rule__EndNode__Group__0__Impl : ( 'EndNode' ) ;
    public final void rule__EndNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2388:1: ( ( 'EndNode' ) )
            // InternalIfictiondsl.g:2389:1: ( 'EndNode' )
            {
            // InternalIfictiondsl.g:2389:1: ( 'EndNode' )
            // InternalIfictiondsl.g:2390:2: 'EndNode'
            {
             before(grammarAccess.getEndNodeAccess().getEndNodeKeyword_0()); 
            match(input,35,FOLLOW_2); 
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
    // InternalIfictiondsl.g:2399:1: rule__EndNode__Group__1 : rule__EndNode__Group__1__Impl rule__EndNode__Group__2 ;
    public final void rule__EndNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2403:1: ( rule__EndNode__Group__1__Impl rule__EndNode__Group__2 )
            // InternalIfictiondsl.g:2404:2: rule__EndNode__Group__1__Impl rule__EndNode__Group__2
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
    // InternalIfictiondsl.g:2411:1: rule__EndNode__Group__1__Impl : ( ( rule__EndNode__NameAssignment_1 ) ) ;
    public final void rule__EndNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2415:1: ( ( ( rule__EndNode__NameAssignment_1 ) ) )
            // InternalIfictiondsl.g:2416:1: ( ( rule__EndNode__NameAssignment_1 ) )
            {
            // InternalIfictiondsl.g:2416:1: ( ( rule__EndNode__NameAssignment_1 ) )
            // InternalIfictiondsl.g:2417:2: ( rule__EndNode__NameAssignment_1 )
            {
             before(grammarAccess.getEndNodeAccess().getNameAssignment_1()); 
            // InternalIfictiondsl.g:2418:2: ( rule__EndNode__NameAssignment_1 )
            // InternalIfictiondsl.g:2418:3: rule__EndNode__NameAssignment_1
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
    // InternalIfictiondsl.g:2426:1: rule__EndNode__Group__2 : rule__EndNode__Group__2__Impl rule__EndNode__Group__3 ;
    public final void rule__EndNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2430:1: ( rule__EndNode__Group__2__Impl rule__EndNode__Group__3 )
            // InternalIfictiondsl.g:2431:2: rule__EndNode__Group__2__Impl rule__EndNode__Group__3
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
    // InternalIfictiondsl.g:2438:1: rule__EndNode__Group__2__Impl : ( '{' ) ;
    public final void rule__EndNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2442:1: ( ( '{' ) )
            // InternalIfictiondsl.g:2443:1: ( '{' )
            {
            // InternalIfictiondsl.g:2443:1: ( '{' )
            // InternalIfictiondsl.g:2444:2: '{'
            {
             before(grammarAccess.getEndNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,19,FOLLOW_2); 
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
    // InternalIfictiondsl.g:2453:1: rule__EndNode__Group__3 : rule__EndNode__Group__3__Impl rule__EndNode__Group__4 ;
    public final void rule__EndNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2457:1: ( rule__EndNode__Group__3__Impl rule__EndNode__Group__4 )
            // InternalIfictiondsl.g:2458:2: rule__EndNode__Group__3__Impl rule__EndNode__Group__4
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
    // InternalIfictiondsl.g:2465:1: rule__EndNode__Group__3__Impl : ( 'displayText' ) ;
    public final void rule__EndNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2469:1: ( ( 'displayText' ) )
            // InternalIfictiondsl.g:2470:1: ( 'displayText' )
            {
            // InternalIfictiondsl.g:2470:1: ( 'displayText' )
            // InternalIfictiondsl.g:2471:2: 'displayText'
            {
             before(grammarAccess.getEndNodeAccess().getDisplayTextKeyword_3()); 
            match(input,27,FOLLOW_2); 
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
    // InternalIfictiondsl.g:2480:1: rule__EndNode__Group__4 : rule__EndNode__Group__4__Impl rule__EndNode__Group__5 ;
    public final void rule__EndNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2484:1: ( rule__EndNode__Group__4__Impl rule__EndNode__Group__5 )
            // InternalIfictiondsl.g:2485:2: rule__EndNode__Group__4__Impl rule__EndNode__Group__5
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
    // InternalIfictiondsl.g:2492:1: rule__EndNode__Group__4__Impl : ( ':' ) ;
    public final void rule__EndNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2496:1: ( ( ':' ) )
            // InternalIfictiondsl.g:2497:1: ( ':' )
            {
            // InternalIfictiondsl.g:2497:1: ( ':' )
            // InternalIfictiondsl.g:2498:2: ':'
            {
             before(grammarAccess.getEndNodeAccess().getColonKeyword_4()); 
            match(input,21,FOLLOW_2); 
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
    // InternalIfictiondsl.g:2507:1: rule__EndNode__Group__5 : rule__EndNode__Group__5__Impl rule__EndNode__Group__6 ;
    public final void rule__EndNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2511:1: ( rule__EndNode__Group__5__Impl rule__EndNode__Group__6 )
            // InternalIfictiondsl.g:2512:2: rule__EndNode__Group__5__Impl rule__EndNode__Group__6
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
    // InternalIfictiondsl.g:2519:1: rule__EndNode__Group__5__Impl : ( ( rule__EndNode__TextAssignment_5 ) ) ;
    public final void rule__EndNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2523:1: ( ( ( rule__EndNode__TextAssignment_5 ) ) )
            // InternalIfictiondsl.g:2524:1: ( ( rule__EndNode__TextAssignment_5 ) )
            {
            // InternalIfictiondsl.g:2524:1: ( ( rule__EndNode__TextAssignment_5 ) )
            // InternalIfictiondsl.g:2525:2: ( rule__EndNode__TextAssignment_5 )
            {
             before(grammarAccess.getEndNodeAccess().getTextAssignment_5()); 
            // InternalIfictiondsl.g:2526:2: ( rule__EndNode__TextAssignment_5 )
            // InternalIfictiondsl.g:2526:3: rule__EndNode__TextAssignment_5
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
    // InternalIfictiondsl.g:2534:1: rule__EndNode__Group__6 : rule__EndNode__Group__6__Impl ;
    public final void rule__EndNode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2538:1: ( rule__EndNode__Group__6__Impl )
            // InternalIfictiondsl.g:2539:2: rule__EndNode__Group__6__Impl
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
    // InternalIfictiondsl.g:2545:1: rule__EndNode__Group__6__Impl : ( '}' ) ;
    public final void rule__EndNode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2549:1: ( ( '}' ) )
            // InternalIfictiondsl.g:2550:1: ( '}' )
            {
            // InternalIfictiondsl.g:2550:1: ( '}' )
            // InternalIfictiondsl.g:2551:2: '}'
            {
             before(grammarAccess.getEndNodeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,24,FOLLOW_2); 
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
    // InternalIfictiondsl.g:2561:1: rule__Story__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Story__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2565:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:2566:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:2566:2: ( RULE_ID )
            // InternalIfictiondsl.g:2567:3: RULE_ID
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
    // InternalIfictiondsl.g:2576:1: rule__Story__NodesAssignment_2 : ( ruleNode ) ;
    public final void rule__Story__NodesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2580:1: ( ( ruleNode ) )
            // InternalIfictiondsl.g:2581:2: ( ruleNode )
            {
            // InternalIfictiondsl.g:2581:2: ( ruleNode )
            // InternalIfictiondsl.g:2582:3: ruleNode
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
    // InternalIfictiondsl.g:2591:1: rule__ChoiceNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ChoiceNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2595:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:2596:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:2596:2: ( RULE_ID )
            // InternalIfictiondsl.g:2597:3: RULE_ID
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
    // InternalIfictiondsl.g:2606:1: rule__ChoiceNode__OptionsAssignment_6_0 : ( ruleChoiceOption ) ;
    public final void rule__ChoiceNode__OptionsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2610:1: ( ( ruleChoiceOption ) )
            // InternalIfictiondsl.g:2611:2: ( ruleChoiceOption )
            {
            // InternalIfictiondsl.g:2611:2: ( ruleChoiceOption )
            // InternalIfictiondsl.g:2612:3: ruleChoiceOption
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
    // InternalIfictiondsl.g:2621:1: rule__ChoiceNode__OptionsAssignment_6_1_1 : ( ruleChoiceOption ) ;
    public final void rule__ChoiceNode__OptionsAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2625:1: ( ( ruleChoiceOption ) )
            // InternalIfictiondsl.g:2626:2: ( ruleChoiceOption )
            {
            // InternalIfictiondsl.g:2626:2: ( ruleChoiceOption )
            // InternalIfictiondsl.g:2627:3: ruleChoiceOption
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
    // InternalIfictiondsl.g:2636:1: rule__ChoiceOption__TextAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ChoiceOption__TextAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2640:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:2641:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:2641:2: ( RULE_STRING )
            // InternalIfictiondsl.g:2642:3: RULE_STRING
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
    // InternalIfictiondsl.g:2651:1: rule__ChoiceOption__TransitionsAssignment_6_0 : ( ruleTransition ) ;
    public final void rule__ChoiceOption__TransitionsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2655:1: ( ( ruleTransition ) )
            // InternalIfictiondsl.g:2656:2: ( ruleTransition )
            {
            // InternalIfictiondsl.g:2656:2: ( ruleTransition )
            // InternalIfictiondsl.g:2657:3: ruleTransition
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
    // InternalIfictiondsl.g:2666:1: rule__ChoiceOption__TransitionsAssignment_6_1_1 : ( ruleTransition ) ;
    public final void rule__ChoiceOption__TransitionsAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2670:1: ( ( ruleTransition ) )
            // InternalIfictiondsl.g:2671:2: ( ruleTransition )
            {
            // InternalIfictiondsl.g:2671:2: ( ruleTransition )
            // InternalIfictiondsl.g:2672:3: ruleTransition
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
    // InternalIfictiondsl.g:2681:1: rule__Transition__DestinationAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__DestinationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2685:1: ( ( ( RULE_ID ) ) )
            // InternalIfictiondsl.g:2686:2: ( ( RULE_ID ) )
            {
            // InternalIfictiondsl.g:2686:2: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:2687:3: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getDestinationNodeCrossReference_1_0()); 
            // InternalIfictiondsl.g:2688:3: ( RULE_ID )
            // InternalIfictiondsl.g:2689:4: RULE_ID
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
    // InternalIfictiondsl.g:2700:1: rule__Transition__PriorityAssignment_2_2 : ( RULE_INT ) ;
    public final void rule__Transition__PriorityAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2704:1: ( ( RULE_INT ) )
            // InternalIfictiondsl.g:2705:2: ( RULE_INT )
            {
            // InternalIfictiondsl.g:2705:2: ( RULE_INT )
            // InternalIfictiondsl.g:2706:3: RULE_INT
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
    // InternalIfictiondsl.g:2715:1: rule__Transition__ConditionAssignment_3_3 : ( ruleCondition ) ;
    public final void rule__Transition__ConditionAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2719:1: ( ( ruleCondition ) )
            // InternalIfictiondsl.g:2720:2: ( ruleCondition )
            {
            // InternalIfictiondsl.g:2720:2: ( ruleCondition )
            // InternalIfictiondsl.g:2721:3: ruleCondition
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
    // InternalIfictiondsl.g:2730:1: rule__StartNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__StartNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2734:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:2735:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:2735:2: ( RULE_ID )
            // InternalIfictiondsl.g:2736:3: RULE_ID
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
    // InternalIfictiondsl.g:2745:1: rule__StartNode__TextAssignment_5 : ( RULE_STRING ) ;
    public final void rule__StartNode__TextAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2749:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:2750:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:2750:2: ( RULE_STRING )
            // InternalIfictiondsl.g:2751:3: RULE_STRING
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
    // InternalIfictiondsl.g:2760:1: rule__StartNode__TransitionAssignment_7 : ( ruleTransition ) ;
    public final void rule__StartNode__TransitionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2764:1: ( ( ruleTransition ) )
            // InternalIfictiondsl.g:2765:2: ( ruleTransition )
            {
            // InternalIfictiondsl.g:2765:2: ( ruleTransition )
            // InternalIfictiondsl.g:2766:3: ruleTransition
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
    // InternalIfictiondsl.g:2775:1: rule__DialogueNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DialogueNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2779:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:2780:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:2780:2: ( RULE_ID )
            // InternalIfictiondsl.g:2781:3: RULE_ID
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
    // InternalIfictiondsl.g:2790:1: rule__DialogueNode__TextAssignment_5 : ( RULE_STRING ) ;
    public final void rule__DialogueNode__TextAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2794:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:2795:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:2795:2: ( RULE_STRING )
            // InternalIfictiondsl.g:2796:3: RULE_STRING
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
    // InternalIfictiondsl.g:2805:1: rule__DialogueNode__TransitionAssignment_7 : ( ruleTransition ) ;
    public final void rule__DialogueNode__TransitionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2809:1: ( ( ruleTransition ) )
            // InternalIfictiondsl.g:2810:2: ( ruleTransition )
            {
            // InternalIfictiondsl.g:2810:2: ( ruleTransition )
            // InternalIfictiondsl.g:2811:3: ruleTransition
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


    // $ANTLR start "rule__Condition__VariableAssignment_0"
    // InternalIfictiondsl.g:2820:1: rule__Condition__VariableAssignment_0 : ( RULE_ID ) ;
    public final void rule__Condition__VariableAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2824:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:2825:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:2825:2: ( RULE_ID )
            // InternalIfictiondsl.g:2826:3: RULE_ID
            {
             before(grammarAccess.getConditionAccess().getVariableIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getVariableIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__Condition__VariableAssignment_0"


    // $ANTLR start "rule__Condition__OperatorAssignment_1"
    // InternalIfictiondsl.g:2835:1: rule__Condition__OperatorAssignment_1 : ( ( rule__Condition__OperatorAlternatives_1_0 ) ) ;
    public final void rule__Condition__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2839:1: ( ( ( rule__Condition__OperatorAlternatives_1_0 ) ) )
            // InternalIfictiondsl.g:2840:2: ( ( rule__Condition__OperatorAlternatives_1_0 ) )
            {
            // InternalIfictiondsl.g:2840:2: ( ( rule__Condition__OperatorAlternatives_1_0 ) )
            // InternalIfictiondsl.g:2841:3: ( rule__Condition__OperatorAlternatives_1_0 )
            {
             before(grammarAccess.getConditionAccess().getOperatorAlternatives_1_0()); 
            // InternalIfictiondsl.g:2842:3: ( rule__Condition__OperatorAlternatives_1_0 )
            // InternalIfictiondsl.g:2842:4: rule__Condition__OperatorAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Condition__OperatorAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getOperatorAlternatives_1_0()); 

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
    // $ANTLR end "rule__Condition__OperatorAssignment_1"


    // $ANTLR start "rule__Condition__ValueAssignment_2"
    // InternalIfictiondsl.g:2850:1: rule__Condition__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__Condition__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2854:1: ( ( RULE_INT ) )
            // InternalIfictiondsl.g:2855:2: ( RULE_INT )
            {
            // InternalIfictiondsl.g:2855:2: ( RULE_INT )
            // InternalIfictiondsl.g:2856:3: RULE_INT
            {
             before(grammarAccess.getConditionAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getValueINTTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Condition__ValueAssignment_2"


    // $ANTLR start "rule__SystemStateChangeNode__NameAssignment_1"
    // InternalIfictiondsl.g:2865:1: rule__SystemStateChangeNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SystemStateChangeNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2869:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:2870:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:2870:2: ( RULE_ID )
            // InternalIfictiondsl.g:2871:3: RULE_ID
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
    // InternalIfictiondsl.g:2880:1: rule__SystemStateChangeNode__TextAssignment_5 : ( RULE_STRING ) ;
    public final void rule__SystemStateChangeNode__TextAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2884:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:2885:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:2885:2: ( RULE_STRING )
            // InternalIfictiondsl.g:2886:3: RULE_STRING
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


    // $ANTLR start "rule__SystemStateChangeNode__VariableAssignment_7"
    // InternalIfictiondsl.g:2895:1: rule__SystemStateChangeNode__VariableAssignment_7 : ( RULE_STRING ) ;
    public final void rule__SystemStateChangeNode__VariableAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2899:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:2900:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:2900:2: ( RULE_STRING )
            // InternalIfictiondsl.g:2901:3: RULE_STRING
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getVariableSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getVariableSTRINGTerminalRuleCall_7_0()); 

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
    // $ANTLR end "rule__SystemStateChangeNode__VariableAssignment_7"


    // $ANTLR start "rule__SystemStateChangeNode__OperatorAssignment_8"
    // InternalIfictiondsl.g:2910:1: rule__SystemStateChangeNode__OperatorAssignment_8 : ( ( rule__SystemStateChangeNode__OperatorAlternatives_8_0 ) ) ;
    public final void rule__SystemStateChangeNode__OperatorAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2914:1: ( ( ( rule__SystemStateChangeNode__OperatorAlternatives_8_0 ) ) )
            // InternalIfictiondsl.g:2915:2: ( ( rule__SystemStateChangeNode__OperatorAlternatives_8_0 ) )
            {
            // InternalIfictiondsl.g:2915:2: ( ( rule__SystemStateChangeNode__OperatorAlternatives_8_0 ) )
            // InternalIfictiondsl.g:2916:3: ( rule__SystemStateChangeNode__OperatorAlternatives_8_0 )
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getOperatorAlternatives_8_0()); 
            // InternalIfictiondsl.g:2917:3: ( rule__SystemStateChangeNode__OperatorAlternatives_8_0 )
            // InternalIfictiondsl.g:2917:4: rule__SystemStateChangeNode__OperatorAlternatives_8_0
            {
            pushFollow(FOLLOW_2);
            rule__SystemStateChangeNode__OperatorAlternatives_8_0();

            state._fsp--;


            }

             after(grammarAccess.getSystemStateChangeNodeAccess().getOperatorAlternatives_8_0()); 

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
    // $ANTLR end "rule__SystemStateChangeNode__OperatorAssignment_8"


    // $ANTLR start "rule__SystemStateChangeNode__ValueAssignment_9"
    // InternalIfictiondsl.g:2925:1: rule__SystemStateChangeNode__ValueAssignment_9 : ( RULE_INT ) ;
    public final void rule__SystemStateChangeNode__ValueAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2929:1: ( ( RULE_INT ) )
            // InternalIfictiondsl.g:2930:2: ( RULE_INT )
            {
            // InternalIfictiondsl.g:2930:2: ( RULE_INT )
            // InternalIfictiondsl.g:2931:3: RULE_INT
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getValueINTTerminalRuleCall_9_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getSystemStateChangeNodeAccess().getValueINTTerminalRuleCall_9_0()); 

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
    // $ANTLR end "rule__SystemStateChangeNode__ValueAssignment_9"


    // $ANTLR start "rule__SystemStateChangeNode__TransitionAssignment_11"
    // InternalIfictiondsl.g:2940:1: rule__SystemStateChangeNode__TransitionAssignment_11 : ( ruleTransition ) ;
    public final void rule__SystemStateChangeNode__TransitionAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2944:1: ( ( ruleTransition ) )
            // InternalIfictiondsl.g:2945:2: ( ruleTransition )
            {
            // InternalIfictiondsl.g:2945:2: ( ruleTransition )
            // InternalIfictiondsl.g:2946:3: ruleTransition
            {
             before(grammarAccess.getSystemStateChangeNodeAccess().getTransitionTransitionParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getSystemStateChangeNodeAccess().getTransitionTransitionParserRuleCall_11_0()); 

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
    // $ANTLR end "rule__SystemStateChangeNode__TransitionAssignment_11"


    // $ANTLR start "rule__EndNode__NameAssignment_1"
    // InternalIfictiondsl.g:2955:1: rule__EndNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EndNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2959:1: ( ( RULE_ID ) )
            // InternalIfictiondsl.g:2960:2: ( RULE_ID )
            {
            // InternalIfictiondsl.g:2960:2: ( RULE_ID )
            // InternalIfictiondsl.g:2961:3: RULE_ID
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
    // InternalIfictiondsl.g:2970:1: rule__EndNode__TextAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EndNode__TextAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIfictiondsl.g:2974:1: ( ( RULE_STRING ) )
            // InternalIfictiondsl.g:2975:2: ( RULE_STRING )
            {
            // InternalIfictiondsl.g:2975:2: ( RULE_STRING )
            // InternalIfictiondsl.g:2976:3: RULE_STRING
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
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000F00040000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000F00040002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000018800L});

}