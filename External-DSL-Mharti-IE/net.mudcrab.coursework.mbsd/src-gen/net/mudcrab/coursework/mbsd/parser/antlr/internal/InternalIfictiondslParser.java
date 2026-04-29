package net.mudcrab.coursework.mbsd.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import net.mudcrab.coursework.mbsd.services.IfictiondslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIfictiondslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Story'", "'ChoiceNode'", "'{'", "'choices'", "':'", "'['", "','", "']'", "'}'", "'ChoiceOption'", "'displayText'", "'->'", "'with'", "'priority'", "'condition'", "'StartNode'", "'DialogueNode'", "'or'", "'and'", "'('", "')'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'SystemStateChangeNode'", "'+='", "'-='", "'='", "'EndNode'"
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
    public static final int T__42=42;
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

        public InternalIfictiondslParser(TokenStream input, IfictiondslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Story";
       	}

       	@Override
       	protected IfictiondslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleStory"
    // InternalIfictiondsl.g:64:1: entryRuleStory returns [EObject current=null] : iv_ruleStory= ruleStory EOF ;
    public final EObject entryRuleStory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStory = null;


        try {
            // InternalIfictiondsl.g:64:46: (iv_ruleStory= ruleStory EOF )
            // InternalIfictiondsl.g:65:2: iv_ruleStory= ruleStory EOF
            {
             newCompositeNode(grammarAccess.getStoryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStory=ruleStory();

            state._fsp--;

             current =iv_ruleStory; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStory"


    // $ANTLR start "ruleStory"
    // InternalIfictiondsl.g:71:1: ruleStory returns [EObject current=null] : (otherlv_0= 'Story' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nodes_2_0= ruleNode ) )* ) ;
    public final EObject ruleStory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_nodes_2_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:77:2: ( (otherlv_0= 'Story' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nodes_2_0= ruleNode ) )* ) )
            // InternalIfictiondsl.g:78:2: (otherlv_0= 'Story' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nodes_2_0= ruleNode ) )* )
            {
            // InternalIfictiondsl.g:78:2: (otherlv_0= 'Story' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nodes_2_0= ruleNode ) )* )
            // InternalIfictiondsl.g:79:3: otherlv_0= 'Story' ( (lv_name_1_0= RULE_ID ) ) ( (lv_nodes_2_0= ruleNode ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStoryAccess().getStoryKeyword_0());
            		
            // InternalIfictiondsl.g:83:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalIfictiondsl.g:84:4: (lv_name_1_0= RULE_ID )
            {
            // InternalIfictiondsl.g:84:4: (lv_name_1_0= RULE_ID )
            // InternalIfictiondsl.g:85:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStoryAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStoryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalIfictiondsl.g:101:3: ( (lv_nodes_2_0= ruleNode ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||(LA1_0>=26 && LA1_0<=27)||LA1_0==38||LA1_0==42) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIfictiondsl.g:102:4: (lv_nodes_2_0= ruleNode )
            	    {
            	    // InternalIfictiondsl.g:102:4: (lv_nodes_2_0= ruleNode )
            	    // InternalIfictiondsl.g:103:5: lv_nodes_2_0= ruleNode
            	    {

            	    					newCompositeNode(grammarAccess.getStoryAccess().getNodesNodeParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_nodes_2_0=ruleNode();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStoryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"nodes",
            	    						lv_nodes_2_0,
            	    						"net.mudcrab.coursework.mbsd.Ifictiondsl.Node");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStory"


    // $ANTLR start "entryRuleNode"
    // InternalIfictiondsl.g:124:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalIfictiondsl.g:124:45: (iv_ruleNode= ruleNode EOF )
            // InternalIfictiondsl.g:125:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalIfictiondsl.g:131:1: ruleNode returns [EObject current=null] : (this_StartNode_0= ruleStartNode | this_ChoiceNode_1= ruleChoiceNode | this_DialogueNode_2= ruleDialogueNode | this_SystemStateChangeNode_3= ruleSystemStateChangeNode | this_EndNode_4= ruleEndNode ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        EObject this_StartNode_0 = null;

        EObject this_ChoiceNode_1 = null;

        EObject this_DialogueNode_2 = null;

        EObject this_SystemStateChangeNode_3 = null;

        EObject this_EndNode_4 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:137:2: ( (this_StartNode_0= ruleStartNode | this_ChoiceNode_1= ruleChoiceNode | this_DialogueNode_2= ruleDialogueNode | this_SystemStateChangeNode_3= ruleSystemStateChangeNode | this_EndNode_4= ruleEndNode ) )
            // InternalIfictiondsl.g:138:2: (this_StartNode_0= ruleStartNode | this_ChoiceNode_1= ruleChoiceNode | this_DialogueNode_2= ruleDialogueNode | this_SystemStateChangeNode_3= ruleSystemStateChangeNode | this_EndNode_4= ruleEndNode )
            {
            // InternalIfictiondsl.g:138:2: (this_StartNode_0= ruleStartNode | this_ChoiceNode_1= ruleChoiceNode | this_DialogueNode_2= ruleDialogueNode | this_SystemStateChangeNode_3= ruleSystemStateChangeNode | this_EndNode_4= ruleEndNode )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 27:
                {
                alt2=3;
                }
                break;
            case 38:
                {
                alt2=4;
                }
                break;
            case 42:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalIfictiondsl.g:139:3: this_StartNode_0= ruleStartNode
                    {

                    			newCompositeNode(grammarAccess.getNodeAccess().getStartNodeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StartNode_0=ruleStartNode();

                    state._fsp--;


                    			current = this_StartNode_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalIfictiondsl.g:148:3: this_ChoiceNode_1= ruleChoiceNode
                    {

                    			newCompositeNode(grammarAccess.getNodeAccess().getChoiceNodeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ChoiceNode_1=ruleChoiceNode();

                    state._fsp--;


                    			current = this_ChoiceNode_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalIfictiondsl.g:157:3: this_DialogueNode_2= ruleDialogueNode
                    {

                    			newCompositeNode(grammarAccess.getNodeAccess().getDialogueNodeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DialogueNode_2=ruleDialogueNode();

                    state._fsp--;


                    			current = this_DialogueNode_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalIfictiondsl.g:166:3: this_SystemStateChangeNode_3= ruleSystemStateChangeNode
                    {

                    			newCompositeNode(grammarAccess.getNodeAccess().getSystemStateChangeNodeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_SystemStateChangeNode_3=ruleSystemStateChangeNode();

                    state._fsp--;


                    			current = this_SystemStateChangeNode_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalIfictiondsl.g:175:3: this_EndNode_4= ruleEndNode
                    {

                    			newCompositeNode(grammarAccess.getNodeAccess().getEndNodeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_EndNode_4=ruleEndNode();

                    state._fsp--;


                    			current = this_EndNode_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleChoiceNode"
    // InternalIfictiondsl.g:187:1: entryRuleChoiceNode returns [EObject current=null] : iv_ruleChoiceNode= ruleChoiceNode EOF ;
    public final EObject entryRuleChoiceNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoiceNode = null;


        try {
            // InternalIfictiondsl.g:187:51: (iv_ruleChoiceNode= ruleChoiceNode EOF )
            // InternalIfictiondsl.g:188:2: iv_ruleChoiceNode= ruleChoiceNode EOF
            {
             newCompositeNode(grammarAccess.getChoiceNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChoiceNode=ruleChoiceNode();

            state._fsp--;

             current =iv_ruleChoiceNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChoiceNode"


    // $ANTLR start "ruleChoiceNode"
    // InternalIfictiondsl.g:194:1: ruleChoiceNode returns [EObject current=null] : (otherlv_0= 'ChoiceNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'choices' otherlv_4= ':' otherlv_5= '[' ( ( (lv_options_6_0= ruleChoiceOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleChoiceOption ) ) )* )? otherlv_9= ']' otherlv_10= '}' ) ;
    public final EObject ruleChoiceNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_options_6_0 = null;

        EObject lv_options_8_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:200:2: ( (otherlv_0= 'ChoiceNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'choices' otherlv_4= ':' otherlv_5= '[' ( ( (lv_options_6_0= ruleChoiceOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleChoiceOption ) ) )* )? otherlv_9= ']' otherlv_10= '}' ) )
            // InternalIfictiondsl.g:201:2: (otherlv_0= 'ChoiceNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'choices' otherlv_4= ':' otherlv_5= '[' ( ( (lv_options_6_0= ruleChoiceOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleChoiceOption ) ) )* )? otherlv_9= ']' otherlv_10= '}' )
            {
            // InternalIfictiondsl.g:201:2: (otherlv_0= 'ChoiceNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'choices' otherlv_4= ':' otherlv_5= '[' ( ( (lv_options_6_0= ruleChoiceOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleChoiceOption ) ) )* )? otherlv_9= ']' otherlv_10= '}' )
            // InternalIfictiondsl.g:202:3: otherlv_0= 'ChoiceNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'choices' otherlv_4= ':' otherlv_5= '[' ( ( (lv_options_6_0= ruleChoiceOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleChoiceOption ) ) )* )? otherlv_9= ']' otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getChoiceNodeAccess().getChoiceNodeKeyword_0());
            		
            // InternalIfictiondsl.g:206:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalIfictiondsl.g:207:4: (lv_name_1_0= RULE_ID )
            {
            // InternalIfictiondsl.g:207:4: (lv_name_1_0= RULE_ID )
            // InternalIfictiondsl.g:208:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getChoiceNodeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChoiceNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getChoiceNodeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getChoiceNodeAccess().getChoicesKeyword_3());
            		
            otherlv_4=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getChoiceNodeAccess().getColonKeyword_4());
            		
            otherlv_5=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getChoiceNodeAccess().getLeftSquareBracketKeyword_5());
            		
            // InternalIfictiondsl.g:240:3: ( ( (lv_options_6_0= ruleChoiceOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleChoiceOption ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalIfictiondsl.g:241:4: ( (lv_options_6_0= ruleChoiceOption ) ) (otherlv_7= ',' ( (lv_options_8_0= ruleChoiceOption ) ) )*
                    {
                    // InternalIfictiondsl.g:241:4: ( (lv_options_6_0= ruleChoiceOption ) )
                    // InternalIfictiondsl.g:242:5: (lv_options_6_0= ruleChoiceOption )
                    {
                    // InternalIfictiondsl.g:242:5: (lv_options_6_0= ruleChoiceOption )
                    // InternalIfictiondsl.g:243:6: lv_options_6_0= ruleChoiceOption
                    {

                    						newCompositeNode(grammarAccess.getChoiceNodeAccess().getOptionsChoiceOptionParserRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_options_6_0=ruleChoiceOption();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getChoiceNodeRule());
                    						}
                    						add(
                    							current,
                    							"options",
                    							lv_options_6_0,
                    							"net.mudcrab.coursework.mbsd.Ifictiondsl.ChoiceOption");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalIfictiondsl.g:260:4: (otherlv_7= ',' ( (lv_options_8_0= ruleChoiceOption ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalIfictiondsl.g:261:5: otherlv_7= ',' ( (lv_options_8_0= ruleChoiceOption ) )
                    	    {
                    	    otherlv_7=(Token)match(input,17,FOLLOW_11); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getChoiceNodeAccess().getCommaKeyword_6_1_0());
                    	    				
                    	    // InternalIfictiondsl.g:265:5: ( (lv_options_8_0= ruleChoiceOption ) )
                    	    // InternalIfictiondsl.g:266:6: (lv_options_8_0= ruleChoiceOption )
                    	    {
                    	    // InternalIfictiondsl.g:266:6: (lv_options_8_0= ruleChoiceOption )
                    	    // InternalIfictiondsl.g:267:7: lv_options_8_0= ruleChoiceOption
                    	    {

                    	    							newCompositeNode(grammarAccess.getChoiceNodeAccess().getOptionsChoiceOptionParserRuleCall_6_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_options_8_0=ruleChoiceOption();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getChoiceNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"options",
                    	    								lv_options_8_0,
                    	    								"net.mudcrab.coursework.mbsd.Ifictiondsl.ChoiceOption");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_9, grammarAccess.getChoiceNodeAccess().getRightSquareBracketKeyword_7());
            		
            otherlv_10=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getChoiceNodeAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChoiceNode"


    // $ANTLR start "entryRuleChoiceOption"
    // InternalIfictiondsl.g:298:1: entryRuleChoiceOption returns [EObject current=null] : iv_ruleChoiceOption= ruleChoiceOption EOF ;
    public final EObject entryRuleChoiceOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoiceOption = null;


        try {
            // InternalIfictiondsl.g:298:53: (iv_ruleChoiceOption= ruleChoiceOption EOF )
            // InternalIfictiondsl.g:299:2: iv_ruleChoiceOption= ruleChoiceOption EOF
            {
             newCompositeNode(grammarAccess.getChoiceOptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChoiceOption=ruleChoiceOption();

            state._fsp--;

             current =iv_ruleChoiceOption; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChoiceOption"


    // $ANTLR start "ruleChoiceOption"
    // InternalIfictiondsl.g:305:1: ruleChoiceOption returns [EObject current=null] : (otherlv_0= 'ChoiceOption' otherlv_1= '{' otherlv_2= 'displayText' otherlv_3= ':' ( (lv_text_4_0= RULE_STRING ) ) otherlv_5= ',' ( ( (lv_transitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_transitions_8_0= ruleTransition ) ) )* ) otherlv_9= '}' ) ;
    public final EObject ruleChoiceOption() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_text_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_transitions_6_0 = null;

        EObject lv_transitions_8_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:311:2: ( (otherlv_0= 'ChoiceOption' otherlv_1= '{' otherlv_2= 'displayText' otherlv_3= ':' ( (lv_text_4_0= RULE_STRING ) ) otherlv_5= ',' ( ( (lv_transitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_transitions_8_0= ruleTransition ) ) )* ) otherlv_9= '}' ) )
            // InternalIfictiondsl.g:312:2: (otherlv_0= 'ChoiceOption' otherlv_1= '{' otherlv_2= 'displayText' otherlv_3= ':' ( (lv_text_4_0= RULE_STRING ) ) otherlv_5= ',' ( ( (lv_transitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_transitions_8_0= ruleTransition ) ) )* ) otherlv_9= '}' )
            {
            // InternalIfictiondsl.g:312:2: (otherlv_0= 'ChoiceOption' otherlv_1= '{' otherlv_2= 'displayText' otherlv_3= ':' ( (lv_text_4_0= RULE_STRING ) ) otherlv_5= ',' ( ( (lv_transitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_transitions_8_0= ruleTransition ) ) )* ) otherlv_9= '}' )
            // InternalIfictiondsl.g:313:3: otherlv_0= 'ChoiceOption' otherlv_1= '{' otherlv_2= 'displayText' otherlv_3= ':' ( (lv_text_4_0= RULE_STRING ) ) otherlv_5= ',' ( ( (lv_transitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_transitions_8_0= ruleTransition ) ) )* ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getChoiceOptionAccess().getChoiceOptionKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getChoiceOptionAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getChoiceOptionAccess().getDisplayTextKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getChoiceOptionAccess().getColonKeyword_3());
            		
            // InternalIfictiondsl.g:329:3: ( (lv_text_4_0= RULE_STRING ) )
            // InternalIfictiondsl.g:330:4: (lv_text_4_0= RULE_STRING )
            {
            // InternalIfictiondsl.g:330:4: (lv_text_4_0= RULE_STRING )
            // InternalIfictiondsl.g:331:5: lv_text_4_0= RULE_STRING
            {
            lv_text_4_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

            					newLeafNode(lv_text_4_0, grammarAccess.getChoiceOptionAccess().getTextSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChoiceOptionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"text",
            						lv_text_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_16); 

            			newLeafNode(otherlv_5, grammarAccess.getChoiceOptionAccess().getCommaKeyword_5());
            		
            // InternalIfictiondsl.g:351:3: ( ( (lv_transitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_transitions_8_0= ruleTransition ) ) )* )
            // InternalIfictiondsl.g:352:4: ( (lv_transitions_6_0= ruleTransition ) ) (otherlv_7= ',' ( (lv_transitions_8_0= ruleTransition ) ) )*
            {
            // InternalIfictiondsl.g:352:4: ( (lv_transitions_6_0= ruleTransition ) )
            // InternalIfictiondsl.g:353:5: (lv_transitions_6_0= ruleTransition )
            {
            // InternalIfictiondsl.g:353:5: (lv_transitions_6_0= ruleTransition )
            // InternalIfictiondsl.g:354:6: lv_transitions_6_0= ruleTransition
            {

            						newCompositeNode(grammarAccess.getChoiceOptionAccess().getTransitionsTransitionParserRuleCall_6_0_0());
            					
            pushFollow(FOLLOW_17);
            lv_transitions_6_0=ruleTransition();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getChoiceOptionRule());
            						}
            						add(
            							current,
            							"transitions",
            							lv_transitions_6_0,
            							"net.mudcrab.coursework.mbsd.Ifictiondsl.Transition");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalIfictiondsl.g:371:4: (otherlv_7= ',' ( (lv_transitions_8_0= ruleTransition ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalIfictiondsl.g:372:5: otherlv_7= ',' ( (lv_transitions_8_0= ruleTransition ) )
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_16); 

            	    					newLeafNode(otherlv_7, grammarAccess.getChoiceOptionAccess().getCommaKeyword_6_1_0());
            	    				
            	    // InternalIfictiondsl.g:376:5: ( (lv_transitions_8_0= ruleTransition ) )
            	    // InternalIfictiondsl.g:377:6: (lv_transitions_8_0= ruleTransition )
            	    {
            	    // InternalIfictiondsl.g:377:6: (lv_transitions_8_0= ruleTransition )
            	    // InternalIfictiondsl.g:378:7: lv_transitions_8_0= ruleTransition
            	    {

            	    							newCompositeNode(grammarAccess.getChoiceOptionAccess().getTransitionsTransitionParserRuleCall_6_1_1_0());
            	    						
            	    pushFollow(FOLLOW_17);
            	    lv_transitions_8_0=ruleTransition();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getChoiceOptionRule());
            	    							}
            	    							add(
            	    								current,
            	    								"transitions",
            	    								lv_transitions_8_0,
            	    								"net.mudcrab.coursework.mbsd.Ifictiondsl.Transition");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            otherlv_9=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getChoiceOptionAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChoiceOption"


    // $ANTLR start "entryRuleTransition"
    // InternalIfictiondsl.g:405:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalIfictiondsl.g:405:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalIfictiondsl.g:406:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalIfictiondsl.g:412:1: ruleTransition returns [EObject current=null] : (otherlv_0= '->' ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'with' otherlv_3= 'priority' ( (lv_priority_4_0= RULE_INT ) ) )? (otherlv_5= 'with' otherlv_6= 'condition' otherlv_7= ':' ( (lv_condition_8_0= ruleCondition ) ) )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_priority_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_condition_8_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:418:2: ( (otherlv_0= '->' ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'with' otherlv_3= 'priority' ( (lv_priority_4_0= RULE_INT ) ) )? (otherlv_5= 'with' otherlv_6= 'condition' otherlv_7= ':' ( (lv_condition_8_0= ruleCondition ) ) )? ) )
            // InternalIfictiondsl.g:419:2: (otherlv_0= '->' ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'with' otherlv_3= 'priority' ( (lv_priority_4_0= RULE_INT ) ) )? (otherlv_5= 'with' otherlv_6= 'condition' otherlv_7= ':' ( (lv_condition_8_0= ruleCondition ) ) )? )
            {
            // InternalIfictiondsl.g:419:2: (otherlv_0= '->' ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'with' otherlv_3= 'priority' ( (lv_priority_4_0= RULE_INT ) ) )? (otherlv_5= 'with' otherlv_6= 'condition' otherlv_7= ':' ( (lv_condition_8_0= ruleCondition ) ) )? )
            // InternalIfictiondsl.g:420:3: otherlv_0= '->' ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'with' otherlv_3= 'priority' ( (lv_priority_4_0= RULE_INT ) ) )? (otherlv_5= 'with' otherlv_6= 'condition' otherlv_7= ':' ( (lv_condition_8_0= ruleCondition ) ) )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getHyphenMinusGreaterThanSignKeyword_0());
            		
            // InternalIfictiondsl.g:424:3: ( (otherlv_1= RULE_ID ) )
            // InternalIfictiondsl.g:425:4: (otherlv_1= RULE_ID )
            {
            // InternalIfictiondsl.g:425:4: (otherlv_1= RULE_ID )
            // InternalIfictiondsl.g:426:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getDestinationNodeCrossReference_1_0());
            				

            }


            }

            // InternalIfictiondsl.g:437:3: (otherlv_2= 'with' otherlv_3= 'priority' ( (lv_priority_4_0= RULE_INT ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==24) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // InternalIfictiondsl.g:438:4: otherlv_2= 'with' otherlv_3= 'priority' ( (lv_priority_4_0= RULE_INT ) )
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getWithKeyword_2_0());
                    			
                    otherlv_3=(Token)match(input,24,FOLLOW_20); 

                    				newLeafNode(otherlv_3, grammarAccess.getTransitionAccess().getPriorityKeyword_2_1());
                    			
                    // InternalIfictiondsl.g:446:4: ( (lv_priority_4_0= RULE_INT ) )
                    // InternalIfictiondsl.g:447:5: (lv_priority_4_0= RULE_INT )
                    {
                    // InternalIfictiondsl.g:447:5: (lv_priority_4_0= RULE_INT )
                    // InternalIfictiondsl.g:448:6: lv_priority_4_0= RULE_INT
                    {
                    lv_priority_4_0=(Token)match(input,RULE_INT,FOLLOW_18); 

                    						newLeafNode(lv_priority_4_0, grammarAccess.getTransitionAccess().getPriorityINTTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTransitionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"priority",
                    							lv_priority_4_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalIfictiondsl.g:465:3: (otherlv_5= 'with' otherlv_6= 'condition' otherlv_7= ':' ( (lv_condition_8_0= ruleCondition ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==23) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalIfictiondsl.g:466:4: otherlv_5= 'with' otherlv_6= 'condition' otherlv_7= ':' ( (lv_condition_8_0= ruleCondition ) )
                    {
                    otherlv_5=(Token)match(input,23,FOLLOW_21); 

                    				newLeafNode(otherlv_5, grammarAccess.getTransitionAccess().getWithKeyword_3_0());
                    			
                    otherlv_6=(Token)match(input,25,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getTransitionAccess().getConditionKeyword_3_1());
                    			
                    otherlv_7=(Token)match(input,15,FOLLOW_22); 

                    				newLeafNode(otherlv_7, grammarAccess.getTransitionAccess().getColonKeyword_3_2());
                    			
                    // InternalIfictiondsl.g:478:4: ( (lv_condition_8_0= ruleCondition ) )
                    // InternalIfictiondsl.g:479:5: (lv_condition_8_0= ruleCondition )
                    {
                    // InternalIfictiondsl.g:479:5: (lv_condition_8_0= ruleCondition )
                    // InternalIfictiondsl.g:480:6: lv_condition_8_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getTransitionAccess().getConditionConditionParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_condition_8_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_8_0,
                    							"net.mudcrab.coursework.mbsd.Ifictiondsl.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleStartNode"
    // InternalIfictiondsl.g:502:1: entryRuleStartNode returns [EObject current=null] : iv_ruleStartNode= ruleStartNode EOF ;
    public final EObject entryRuleStartNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartNode = null;


        try {
            // InternalIfictiondsl.g:502:50: (iv_ruleStartNode= ruleStartNode EOF )
            // InternalIfictiondsl.g:503:2: iv_ruleStartNode= ruleStartNode EOF
            {
             newCompositeNode(grammarAccess.getStartNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStartNode=ruleStartNode();

            state._fsp--;

             current =iv_ruleStartNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartNode"


    // $ANTLR start "ruleStartNode"
    // InternalIfictiondsl.g:509:1: ruleStartNode returns [EObject current=null] : (otherlv_0= 'StartNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_transition_7_0= ruleTransition ) ) otherlv_8= '}' ) ;
    public final EObject ruleStartNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_text_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_transition_7_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:515:2: ( (otherlv_0= 'StartNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_transition_7_0= ruleTransition ) ) otherlv_8= '}' ) )
            // InternalIfictiondsl.g:516:2: (otherlv_0= 'StartNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_transition_7_0= ruleTransition ) ) otherlv_8= '}' )
            {
            // InternalIfictiondsl.g:516:2: (otherlv_0= 'StartNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_transition_7_0= ruleTransition ) ) otherlv_8= '}' )
            // InternalIfictiondsl.g:517:3: otherlv_0= 'StartNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_transition_7_0= ruleTransition ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStartNodeAccess().getStartNodeKeyword_0());
            		
            // InternalIfictiondsl.g:521:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalIfictiondsl.g:522:4: (lv_name_1_0= RULE_ID )
            {
            // InternalIfictiondsl.g:522:4: (lv_name_1_0= RULE_ID )
            // InternalIfictiondsl.g:523:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStartNodeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStartNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getStartNodeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getStartNodeAccess().getDisplayTextKeyword_3());
            		
            otherlv_4=(Token)match(input,15,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getStartNodeAccess().getColonKeyword_4());
            		
            // InternalIfictiondsl.g:551:3: ( (lv_text_5_0= RULE_STRING ) )
            // InternalIfictiondsl.g:552:4: (lv_text_5_0= RULE_STRING )
            {
            // InternalIfictiondsl.g:552:4: (lv_text_5_0= RULE_STRING )
            // InternalIfictiondsl.g:553:5: lv_text_5_0= RULE_STRING
            {
            lv_text_5_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

            					newLeafNode(lv_text_5_0, grammarAccess.getStartNodeAccess().getTextSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStartNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"text",
            						lv_text_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_16); 

            			newLeafNode(otherlv_6, grammarAccess.getStartNodeAccess().getCommaKeyword_6());
            		
            // InternalIfictiondsl.g:573:3: ( (lv_transition_7_0= ruleTransition ) )
            // InternalIfictiondsl.g:574:4: (lv_transition_7_0= ruleTransition )
            {
            // InternalIfictiondsl.g:574:4: (lv_transition_7_0= ruleTransition )
            // InternalIfictiondsl.g:575:5: lv_transition_7_0= ruleTransition
            {

            					newCompositeNode(grammarAccess.getStartNodeAccess().getTransitionTransitionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_12);
            lv_transition_7_0=ruleTransition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStartNodeRule());
            					}
            					set(
            						current,
            						"transition",
            						lv_transition_7_0,
            						"net.mudcrab.coursework.mbsd.Ifictiondsl.Transition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getStartNodeAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartNode"


    // $ANTLR start "entryRuleDialogueNode"
    // InternalIfictiondsl.g:600:1: entryRuleDialogueNode returns [EObject current=null] : iv_ruleDialogueNode= ruleDialogueNode EOF ;
    public final EObject entryRuleDialogueNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDialogueNode = null;


        try {
            // InternalIfictiondsl.g:600:53: (iv_ruleDialogueNode= ruleDialogueNode EOF )
            // InternalIfictiondsl.g:601:2: iv_ruleDialogueNode= ruleDialogueNode EOF
            {
             newCompositeNode(grammarAccess.getDialogueNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDialogueNode=ruleDialogueNode();

            state._fsp--;

             current =iv_ruleDialogueNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDialogueNode"


    // $ANTLR start "ruleDialogueNode"
    // InternalIfictiondsl.g:607:1: ruleDialogueNode returns [EObject current=null] : (otherlv_0= 'DialogueNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_transition_7_0= ruleTransition ) ) otherlv_8= '}' ) ;
    public final EObject ruleDialogueNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_text_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_transition_7_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:613:2: ( (otherlv_0= 'DialogueNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_transition_7_0= ruleTransition ) ) otherlv_8= '}' ) )
            // InternalIfictiondsl.g:614:2: (otherlv_0= 'DialogueNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_transition_7_0= ruleTransition ) ) otherlv_8= '}' )
            {
            // InternalIfictiondsl.g:614:2: (otherlv_0= 'DialogueNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_transition_7_0= ruleTransition ) ) otherlv_8= '}' )
            // InternalIfictiondsl.g:615:3: otherlv_0= 'DialogueNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_transition_7_0= ruleTransition ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDialogueNodeAccess().getDialogueNodeKeyword_0());
            		
            // InternalIfictiondsl.g:619:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalIfictiondsl.g:620:4: (lv_name_1_0= RULE_ID )
            {
            // InternalIfictiondsl.g:620:4: (lv_name_1_0= RULE_ID )
            // InternalIfictiondsl.g:621:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDialogueNodeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDialogueNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getDialogueNodeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getDialogueNodeAccess().getDisplayTextKeyword_3());
            		
            otherlv_4=(Token)match(input,15,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getDialogueNodeAccess().getColonKeyword_4());
            		
            // InternalIfictiondsl.g:649:3: ( (lv_text_5_0= RULE_STRING ) )
            // InternalIfictiondsl.g:650:4: (lv_text_5_0= RULE_STRING )
            {
            // InternalIfictiondsl.g:650:4: (lv_text_5_0= RULE_STRING )
            // InternalIfictiondsl.g:651:5: lv_text_5_0= RULE_STRING
            {
            lv_text_5_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

            					newLeafNode(lv_text_5_0, grammarAccess.getDialogueNodeAccess().getTextSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDialogueNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"text",
            						lv_text_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_16); 

            			newLeafNode(otherlv_6, grammarAccess.getDialogueNodeAccess().getCommaKeyword_6());
            		
            // InternalIfictiondsl.g:671:3: ( (lv_transition_7_0= ruleTransition ) )
            // InternalIfictiondsl.g:672:4: (lv_transition_7_0= ruleTransition )
            {
            // InternalIfictiondsl.g:672:4: (lv_transition_7_0= ruleTransition )
            // InternalIfictiondsl.g:673:5: lv_transition_7_0= ruleTransition
            {

            					newCompositeNode(grammarAccess.getDialogueNodeAccess().getTransitionTransitionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_12);
            lv_transition_7_0=ruleTransition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDialogueNodeRule());
            					}
            					set(
            						current,
            						"transition",
            						lv_transition_7_0,
            						"net.mudcrab.coursework.mbsd.Ifictiondsl.Transition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getDialogueNodeAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDialogueNode"


    // $ANTLR start "entryRuleCondition"
    // InternalIfictiondsl.g:698:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalIfictiondsl.g:698:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalIfictiondsl.g:699:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalIfictiondsl.g:705:1: ruleCondition returns [EObject current=null] : this_OrCondition_0= ruleOrCondition ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        EObject this_OrCondition_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:711:2: (this_OrCondition_0= ruleOrCondition )
            // InternalIfictiondsl.g:712:2: this_OrCondition_0= ruleOrCondition
            {

            		newCompositeNode(grammarAccess.getConditionAccess().getOrConditionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_OrCondition_0=ruleOrCondition();

            state._fsp--;


            		current = this_OrCondition_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleOrCondition"
    // InternalIfictiondsl.g:723:1: entryRuleOrCondition returns [EObject current=null] : iv_ruleOrCondition= ruleOrCondition EOF ;
    public final EObject entryRuleOrCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrCondition = null;


        try {
            // InternalIfictiondsl.g:723:52: (iv_ruleOrCondition= ruleOrCondition EOF )
            // InternalIfictiondsl.g:724:2: iv_ruleOrCondition= ruleOrCondition EOF
            {
             newCompositeNode(grammarAccess.getOrConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrCondition=ruleOrCondition();

            state._fsp--;

             current =iv_ruleOrCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrCondition"


    // $ANTLR start "ruleOrCondition"
    // InternalIfictiondsl.g:730:1: ruleOrCondition returns [EObject current=null] : (this_AndCondition_0= ruleAndCondition ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )* ) ;
    public final EObject ruleOrCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndCondition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:736:2: ( (this_AndCondition_0= ruleAndCondition ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )* ) )
            // InternalIfictiondsl.g:737:2: (this_AndCondition_0= ruleAndCondition ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )* )
            {
            // InternalIfictiondsl.g:737:2: (this_AndCondition_0= ruleAndCondition ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )* )
            // InternalIfictiondsl.g:738:3: this_AndCondition_0= ruleAndCondition ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrConditionAccess().getAndConditionParserRuleCall_0());
            		
            pushFollow(FOLLOW_23);
            this_AndCondition_0=ruleAndCondition();

            state._fsp--;


            			current = this_AndCondition_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalIfictiondsl.g:746:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==28) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalIfictiondsl.g:747:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) )
            	    {
            	    // InternalIfictiondsl.g:747:4: ()
            	    // InternalIfictiondsl.g:748:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrConditionAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,28,FOLLOW_22); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrConditionAccess().getOrKeyword_1_1());
            	    			
            	    // InternalIfictiondsl.g:758:4: ( (lv_right_3_0= ruleAndCondition ) )
            	    // InternalIfictiondsl.g:759:5: (lv_right_3_0= ruleAndCondition )
            	    {
            	    // InternalIfictiondsl.g:759:5: (lv_right_3_0= ruleAndCondition )
            	    // InternalIfictiondsl.g:760:6: lv_right_3_0= ruleAndCondition
            	    {

            	    						newCompositeNode(grammarAccess.getOrConditionAccess().getRightAndConditionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_right_3_0=ruleAndCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrConditionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"net.mudcrab.coursework.mbsd.Ifictiondsl.AndCondition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrCondition"


    // $ANTLR start "entryRuleAndCondition"
    // InternalIfictiondsl.g:782:1: entryRuleAndCondition returns [EObject current=null] : iv_ruleAndCondition= ruleAndCondition EOF ;
    public final EObject entryRuleAndCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndCondition = null;


        try {
            // InternalIfictiondsl.g:782:53: (iv_ruleAndCondition= ruleAndCondition EOF )
            // InternalIfictiondsl.g:783:2: iv_ruleAndCondition= ruleAndCondition EOF
            {
             newCompositeNode(grammarAccess.getAndConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndCondition=ruleAndCondition();

            state._fsp--;

             current =iv_ruleAndCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndCondition"


    // $ANTLR start "ruleAndCondition"
    // InternalIfictiondsl.g:789:1: ruleAndCondition returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleAndCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:795:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalIfictiondsl.g:796:2: (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalIfictiondsl.g:796:2: (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalIfictiondsl.g:797:3: this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndConditionAccess().getPrimaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_24);
            this_Primary_0=rulePrimary();

            state._fsp--;


            			current = this_Primary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalIfictiondsl.g:805:3: ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==29) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalIfictiondsl.g:806:4: () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalIfictiondsl.g:806:4: ()
            	    // InternalIfictiondsl.g:807:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndConditionAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,29,FOLLOW_22); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndConditionAccess().getAndKeyword_1_1());
            	    			
            	    // InternalIfictiondsl.g:817:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalIfictiondsl.g:818:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalIfictiondsl.g:818:5: (lv_right_3_0= rulePrimary )
            	    // InternalIfictiondsl.g:819:6: lv_right_3_0= rulePrimary
            	    {

            	    						newCompositeNode(grammarAccess.getAndConditionAccess().getRightPrimaryParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndConditionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"net.mudcrab.coursework.mbsd.Ifictiondsl.Primary");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndCondition"


    // $ANTLR start "entryRulePrimary"
    // InternalIfictiondsl.g:841:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalIfictiondsl.g:841:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalIfictiondsl.g:842:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalIfictiondsl.g:848:1: rulePrimary returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleCondition ) ) otherlv_3= ')' ) | this_Comparison_4= ruleComparison ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_inner_2_0 = null;

        EObject this_Comparison_4 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:854:2: ( ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleCondition ) ) otherlv_3= ')' ) | this_Comparison_4= ruleComparison ) )
            // InternalIfictiondsl.g:855:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleCondition ) ) otherlv_3= ')' ) | this_Comparison_4= ruleComparison )
            {
            // InternalIfictiondsl.g:855:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleCondition ) ) otherlv_3= ')' ) | this_Comparison_4= ruleComparison )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==30) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalIfictiondsl.g:856:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleCondition ) ) otherlv_3= ')' )
                    {
                    // InternalIfictiondsl.g:856:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleCondition ) ) otherlv_3= ')' )
                    // InternalIfictiondsl.g:857:4: () otherlv_1= '(' ( (lv_inner_2_0= ruleCondition ) ) otherlv_3= ')'
                    {
                    // InternalIfictiondsl.g:857:4: ()
                    // InternalIfictiondsl.g:858:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryAccess().getParenthesesAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,30,FOLLOW_22); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalIfictiondsl.g:868:4: ( (lv_inner_2_0= ruleCondition ) )
                    // InternalIfictiondsl.g:869:5: (lv_inner_2_0= ruleCondition )
                    {
                    // InternalIfictiondsl.g:869:5: (lv_inner_2_0= ruleCondition )
                    // InternalIfictiondsl.g:870:6: lv_inner_2_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getPrimaryAccess().getInnerConditionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_inner_2_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryRule());
                    						}
                    						set(
                    							current,
                    							"inner",
                    							lv_inner_2_0,
                    							"net.mudcrab.coursework.mbsd.Ifictiondsl.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,31,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalIfictiondsl.g:893:3: this_Comparison_4= ruleComparison
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getComparisonParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Comparison_4=ruleComparison();

                    state._fsp--;


                    			current = this_Comparison_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleComparison"
    // InternalIfictiondsl.g:905:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalIfictiondsl.g:905:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalIfictiondsl.g:906:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalIfictiondsl.g:912:1: ruleComparison returns [EObject current=null] : ( ( (lv_variable_0_0= RULE_ID ) ) ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_INT ) ) ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;
        Token lv_value_2_0=null;
        AntlrDatatypeRuleToken lv_operator_1_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:918:2: ( ( ( (lv_variable_0_0= RULE_ID ) ) ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_INT ) ) ) )
            // InternalIfictiondsl.g:919:2: ( ( (lv_variable_0_0= RULE_ID ) ) ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_INT ) ) )
            {
            // InternalIfictiondsl.g:919:2: ( ( (lv_variable_0_0= RULE_ID ) ) ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_INT ) ) )
            // InternalIfictiondsl.g:920:3: ( (lv_variable_0_0= RULE_ID ) ) ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_INT ) )
            {
            // InternalIfictiondsl.g:920:3: ( (lv_variable_0_0= RULE_ID ) )
            // InternalIfictiondsl.g:921:4: (lv_variable_0_0= RULE_ID )
            {
            // InternalIfictiondsl.g:921:4: (lv_variable_0_0= RULE_ID )
            // InternalIfictiondsl.g:922:5: lv_variable_0_0= RULE_ID
            {
            lv_variable_0_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(lv_variable_0_0, grammarAccess.getComparisonAccess().getVariableIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComparisonRule());
            					}
            					setWithLastConsumed(
            						current,
            						"variable",
            						lv_variable_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalIfictiondsl.g:938:3: ( (lv_operator_1_0= ruleOperator ) )
            // InternalIfictiondsl.g:939:4: (lv_operator_1_0= ruleOperator )
            {
            // InternalIfictiondsl.g:939:4: (lv_operator_1_0= ruleOperator )
            // InternalIfictiondsl.g:940:5: lv_operator_1_0= ruleOperator
            {

            					newCompositeNode(grammarAccess.getComparisonAccess().getOperatorOperatorParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_20);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"net.mudcrab.coursework.mbsd.Ifictiondsl.Operator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalIfictiondsl.g:957:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalIfictiondsl.g:958:4: (lv_value_2_0= RULE_INT )
            {
            // InternalIfictiondsl.g:958:4: (lv_value_2_0= RULE_INT )
            // InternalIfictiondsl.g:959:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getComparisonAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComparisonRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleOperator"
    // InternalIfictiondsl.g:979:1: entryRuleOperator returns [String current=null] : iv_ruleOperator= ruleOperator EOF ;
    public final String entryRuleOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOperator = null;


        try {
            // InternalIfictiondsl.g:979:48: (iv_ruleOperator= ruleOperator EOF )
            // InternalIfictiondsl.g:980:2: iv_ruleOperator= ruleOperator EOF
            {
             newCompositeNode(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperator=ruleOperator();

            state._fsp--;

             current =iv_ruleOperator.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalIfictiondsl.g:986:1: ruleOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIfictiondsl.g:992:2: ( (kw= '==' | kw= '!=' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // InternalIfictiondsl.g:993:2: (kw= '==' | kw= '!=' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // InternalIfictiondsl.g:993:2: (kw= '==' | kw= '!=' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt11=6;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt11=1;
                }
                break;
            case 33:
                {
                alt11=2;
                }
                break;
            case 34:
                {
                alt11=3;
                }
                break;
            case 35:
                {
                alt11=4;
                }
                break;
            case 36:
                {
                alt11=5;
                }
                break;
            case 37:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalIfictiondsl.g:994:3: kw= '=='
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getEqualsSignEqualsSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalIfictiondsl.g:1000:3: kw= '!='
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getExclamationMarkEqualsSignKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalIfictiondsl.g:1006:3: kw= '>'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getGreaterThanSignKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalIfictiondsl.g:1012:3: kw= '<'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalIfictiondsl.g:1018:3: kw= '>='
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getGreaterThanSignEqualsSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalIfictiondsl.g:1024:3: kw= '<='
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatorAccess().getLessThanSignEqualsSignKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleSystemStateChangeNode"
    // InternalIfictiondsl.g:1033:1: entryRuleSystemStateChangeNode returns [EObject current=null] : iv_ruleSystemStateChangeNode= ruleSystemStateChangeNode EOF ;
    public final EObject entryRuleSystemStateChangeNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemStateChangeNode = null;


        try {
            // InternalIfictiondsl.g:1033:62: (iv_ruleSystemStateChangeNode= ruleSystemStateChangeNode EOF )
            // InternalIfictiondsl.g:1034:2: iv_ruleSystemStateChangeNode= ruleSystemStateChangeNode EOF
            {
             newCompositeNode(grammarAccess.getSystemStateChangeNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSystemStateChangeNode=ruleSystemStateChangeNode();

            state._fsp--;

             current =iv_ruleSystemStateChangeNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystemStateChangeNode"


    // $ANTLR start "ruleSystemStateChangeNode"
    // InternalIfictiondsl.g:1040:1: ruleSystemStateChangeNode returns [EObject current=null] : (otherlv_0= 'SystemStateChangeNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_stateUpdates_7_0= ruleStateUpdate ) ) (otherlv_8= ',' ( (lv_stateUpdates_9_0= ruleStateUpdate ) ) )* otherlv_10= ',' ( (lv_transition_11_0= ruleTransition ) ) otherlv_12= '}' ) ;
    public final EObject ruleSystemStateChangeNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_text_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_stateUpdates_7_0 = null;

        EObject lv_stateUpdates_9_0 = null;

        EObject lv_transition_11_0 = null;



        	enterRule();

        try {
            // InternalIfictiondsl.g:1046:2: ( (otherlv_0= 'SystemStateChangeNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_stateUpdates_7_0= ruleStateUpdate ) ) (otherlv_8= ',' ( (lv_stateUpdates_9_0= ruleStateUpdate ) ) )* otherlv_10= ',' ( (lv_transition_11_0= ruleTransition ) ) otherlv_12= '}' ) )
            // InternalIfictiondsl.g:1047:2: (otherlv_0= 'SystemStateChangeNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_stateUpdates_7_0= ruleStateUpdate ) ) (otherlv_8= ',' ( (lv_stateUpdates_9_0= ruleStateUpdate ) ) )* otherlv_10= ',' ( (lv_transition_11_0= ruleTransition ) ) otherlv_12= '}' )
            {
            // InternalIfictiondsl.g:1047:2: (otherlv_0= 'SystemStateChangeNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_stateUpdates_7_0= ruleStateUpdate ) ) (otherlv_8= ',' ( (lv_stateUpdates_9_0= ruleStateUpdate ) ) )* otherlv_10= ',' ( (lv_transition_11_0= ruleTransition ) ) otherlv_12= '}' )
            // InternalIfictiondsl.g:1048:3: otherlv_0= 'SystemStateChangeNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= ',' ( (lv_stateUpdates_7_0= ruleStateUpdate ) ) (otherlv_8= ',' ( (lv_stateUpdates_9_0= ruleStateUpdate ) ) )* otherlv_10= ',' ( (lv_transition_11_0= ruleTransition ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSystemStateChangeNodeAccess().getSystemStateChangeNodeKeyword_0());
            		
            // InternalIfictiondsl.g:1052:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalIfictiondsl.g:1053:4: (lv_name_1_0= RULE_ID )
            {
            // InternalIfictiondsl.g:1053:4: (lv_name_1_0= RULE_ID )
            // InternalIfictiondsl.g:1054:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSystemStateChangeNodeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSystemStateChangeNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getSystemStateChangeNodeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getSystemStateChangeNodeAccess().getDisplayTextKeyword_3());
            		
            otherlv_4=(Token)match(input,15,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getSystemStateChangeNodeAccess().getColonKeyword_4());
            		
            // InternalIfictiondsl.g:1082:3: ( (lv_text_5_0= RULE_STRING ) )
            // InternalIfictiondsl.g:1083:4: (lv_text_5_0= RULE_STRING )
            {
            // InternalIfictiondsl.g:1083:4: (lv_text_5_0= RULE_STRING )
            // InternalIfictiondsl.g:1084:5: lv_text_5_0= RULE_STRING
            {
            lv_text_5_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

            					newLeafNode(lv_text_5_0, grammarAccess.getSystemStateChangeNodeAccess().getTextSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSystemStateChangeNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"text",
            						lv_text_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getSystemStateChangeNodeAccess().getCommaKeyword_6());
            		
            // InternalIfictiondsl.g:1104:3: ( (lv_stateUpdates_7_0= ruleStateUpdate ) )
            // InternalIfictiondsl.g:1105:4: (lv_stateUpdates_7_0= ruleStateUpdate )
            {
            // InternalIfictiondsl.g:1105:4: (lv_stateUpdates_7_0= ruleStateUpdate )
            // InternalIfictiondsl.g:1106:5: lv_stateUpdates_7_0= ruleStateUpdate
            {

            					newCompositeNode(grammarAccess.getSystemStateChangeNodeAccess().getStateUpdatesStateUpdateParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_15);
            lv_stateUpdates_7_0=ruleStateUpdate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSystemStateChangeNodeRule());
            					}
            					add(
            						current,
            						"stateUpdates",
            						lv_stateUpdates_7_0,
            						"net.mudcrab.coursework.mbsd.Ifictiondsl.StateUpdate");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalIfictiondsl.g:1123:3: (otherlv_8= ',' ( (lv_stateUpdates_9_0= ruleStateUpdate ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==17) ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==RULE_ID) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // InternalIfictiondsl.g:1124:4: otherlv_8= ',' ( (lv_stateUpdates_9_0= ruleStateUpdate ) )
            	    {
            	    otherlv_8=(Token)match(input,17,FOLLOW_3); 

            	    				newLeafNode(otherlv_8, grammarAccess.getSystemStateChangeNodeAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalIfictiondsl.g:1128:4: ( (lv_stateUpdates_9_0= ruleStateUpdate ) )
            	    // InternalIfictiondsl.g:1129:5: (lv_stateUpdates_9_0= ruleStateUpdate )
            	    {
            	    // InternalIfictiondsl.g:1129:5: (lv_stateUpdates_9_0= ruleStateUpdate )
            	    // InternalIfictiondsl.g:1130:6: lv_stateUpdates_9_0= ruleStateUpdate
            	    {

            	    						newCompositeNode(grammarAccess.getSystemStateChangeNodeAccess().getStateUpdatesStateUpdateParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_stateUpdates_9_0=ruleStateUpdate();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSystemStateChangeNodeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"stateUpdates",
            	    							lv_stateUpdates_9_0,
            	    							"net.mudcrab.coursework.mbsd.Ifictiondsl.StateUpdate");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_10=(Token)match(input,17,FOLLOW_16); 

            			newLeafNode(otherlv_10, grammarAccess.getSystemStateChangeNodeAccess().getCommaKeyword_9());
            		
            // InternalIfictiondsl.g:1152:3: ( (lv_transition_11_0= ruleTransition ) )
            // InternalIfictiondsl.g:1153:4: (lv_transition_11_0= ruleTransition )
            {
            // InternalIfictiondsl.g:1153:4: (lv_transition_11_0= ruleTransition )
            // InternalIfictiondsl.g:1154:5: lv_transition_11_0= ruleTransition
            {

            					newCompositeNode(grammarAccess.getSystemStateChangeNodeAccess().getTransitionTransitionParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_12);
            lv_transition_11_0=ruleTransition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSystemStateChangeNodeRule());
            					}
            					set(
            						current,
            						"transition",
            						lv_transition_11_0,
            						"net.mudcrab.coursework.mbsd.Ifictiondsl.Transition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getSystemStateChangeNodeAccess().getRightCurlyBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystemStateChangeNode"


    // $ANTLR start "entryRuleStateUpdate"
    // InternalIfictiondsl.g:1179:1: entryRuleStateUpdate returns [EObject current=null] : iv_ruleStateUpdate= ruleStateUpdate EOF ;
    public final EObject entryRuleStateUpdate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateUpdate = null;


        try {
            // InternalIfictiondsl.g:1179:52: (iv_ruleStateUpdate= ruleStateUpdate EOF )
            // InternalIfictiondsl.g:1180:2: iv_ruleStateUpdate= ruleStateUpdate EOF
            {
             newCompositeNode(grammarAccess.getStateUpdateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateUpdate=ruleStateUpdate();

            state._fsp--;

             current =iv_ruleStateUpdate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateUpdate"


    // $ANTLR start "ruleStateUpdate"
    // InternalIfictiondsl.g:1186:1: ruleStateUpdate returns [EObject current=null] : ( ( (lv_variable_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '-=' | lv_operator_1_3= '=' ) ) ) ( (lv_value_2_0= RULE_INT ) ) ) ;
    public final EObject ruleStateUpdate() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;
        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalIfictiondsl.g:1192:2: ( ( ( (lv_variable_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '-=' | lv_operator_1_3= '=' ) ) ) ( (lv_value_2_0= RULE_INT ) ) ) )
            // InternalIfictiondsl.g:1193:2: ( ( (lv_variable_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '-=' | lv_operator_1_3= '=' ) ) ) ( (lv_value_2_0= RULE_INT ) ) )
            {
            // InternalIfictiondsl.g:1193:2: ( ( (lv_variable_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '-=' | lv_operator_1_3= '=' ) ) ) ( (lv_value_2_0= RULE_INT ) ) )
            // InternalIfictiondsl.g:1194:3: ( (lv_variable_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '-=' | lv_operator_1_3= '=' ) ) ) ( (lv_value_2_0= RULE_INT ) )
            {
            // InternalIfictiondsl.g:1194:3: ( (lv_variable_0_0= RULE_ID ) )
            // InternalIfictiondsl.g:1195:4: (lv_variable_0_0= RULE_ID )
            {
            // InternalIfictiondsl.g:1195:4: (lv_variable_0_0= RULE_ID )
            // InternalIfictiondsl.g:1196:5: lv_variable_0_0= RULE_ID
            {
            lv_variable_0_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_variable_0_0, grammarAccess.getStateUpdateAccess().getVariableIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateUpdateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"variable",
            						lv_variable_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalIfictiondsl.g:1212:3: ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '-=' | lv_operator_1_3= '=' ) ) )
            // InternalIfictiondsl.g:1213:4: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '-=' | lv_operator_1_3= '=' ) )
            {
            // InternalIfictiondsl.g:1213:4: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '-=' | lv_operator_1_3= '=' ) )
            // InternalIfictiondsl.g:1214:5: (lv_operator_1_1= '+=' | lv_operator_1_2= '-=' | lv_operator_1_3= '=' )
            {
            // InternalIfictiondsl.g:1214:5: (lv_operator_1_1= '+=' | lv_operator_1_2= '-=' | lv_operator_1_3= '=' )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt13=1;
                }
                break;
            case 40:
                {
                alt13=2;
                }
                break;
            case 41:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalIfictiondsl.g:1215:6: lv_operator_1_1= '+='
                    {
                    lv_operator_1_1=(Token)match(input,39,FOLLOW_20); 

                    						newLeafNode(lv_operator_1_1, grammarAccess.getStateUpdateAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateUpdateRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalIfictiondsl.g:1226:6: lv_operator_1_2= '-='
                    {
                    lv_operator_1_2=(Token)match(input,40,FOLLOW_20); 

                    						newLeafNode(lv_operator_1_2, grammarAccess.getStateUpdateAccess().getOperatorHyphenMinusEqualsSignKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateUpdateRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalIfictiondsl.g:1237:6: lv_operator_1_3= '='
                    {
                    lv_operator_1_3=(Token)match(input,41,FOLLOW_20); 

                    						newLeafNode(lv_operator_1_3, grammarAccess.getStateUpdateAccess().getOperatorEqualsSignKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStateUpdateRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_1_3, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalIfictiondsl.g:1250:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalIfictiondsl.g:1251:4: (lv_value_2_0= RULE_INT )
            {
            // InternalIfictiondsl.g:1251:4: (lv_value_2_0= RULE_INT )
            // InternalIfictiondsl.g:1252:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getStateUpdateAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateUpdateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateUpdate"


    // $ANTLR start "entryRuleEndNode"
    // InternalIfictiondsl.g:1272:1: entryRuleEndNode returns [EObject current=null] : iv_ruleEndNode= ruleEndNode EOF ;
    public final EObject entryRuleEndNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndNode = null;


        try {
            // InternalIfictiondsl.g:1272:48: (iv_ruleEndNode= ruleEndNode EOF )
            // InternalIfictiondsl.g:1273:2: iv_ruleEndNode= ruleEndNode EOF
            {
             newCompositeNode(grammarAccess.getEndNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndNode=ruleEndNode();

            state._fsp--;

             current =iv_ruleEndNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndNode"


    // $ANTLR start "ruleEndNode"
    // InternalIfictiondsl.g:1279:1: ruleEndNode returns [EObject current=null] : (otherlv_0= 'EndNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
    public final EObject ruleEndNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_text_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalIfictiondsl.g:1285:2: ( (otherlv_0= 'EndNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // InternalIfictiondsl.g:1286:2: (otherlv_0= 'EndNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // InternalIfictiondsl.g:1286:2: (otherlv_0= 'EndNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // InternalIfictiondsl.g:1287:3: otherlv_0= 'EndNode' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'displayText' otherlv_4= ':' ( (lv_text_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEndNodeAccess().getEndNodeKeyword_0());
            		
            // InternalIfictiondsl.g:1291:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalIfictiondsl.g:1292:4: (lv_name_1_0= RULE_ID )
            {
            // InternalIfictiondsl.g:1292:4: (lv_name_1_0= RULE_ID )
            // InternalIfictiondsl.g:1293:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEndNodeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEndNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getEndNodeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getEndNodeAccess().getDisplayTextKeyword_3());
            		
            otherlv_4=(Token)match(input,15,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getEndNodeAccess().getColonKeyword_4());
            		
            // InternalIfictiondsl.g:1321:3: ( (lv_text_5_0= RULE_STRING ) )
            // InternalIfictiondsl.g:1322:4: (lv_text_5_0= RULE_STRING )
            {
            // InternalIfictiondsl.g:1322:4: (lv_text_5_0= RULE_STRING )
            // InternalIfictiondsl.g:1323:5: lv_text_5_0= RULE_STRING
            {
            lv_text_5_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_text_5_0, grammarAccess.getEndNodeAccess().getTextSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEndNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"text",
            						lv_text_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getEndNodeAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndNode"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000004400C001002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000003F00000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000038000000000L});

}