package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ProblemSpecification'", "'{'", "'WorldModel'", "':'", "'TasksModel'", "','", "'RobotsModel'", "'Mission'", "'}'", "'('", "'x'", "'y'", "'describes'", "')'", "'distance'", "'to'", "'is'", "'robots'", "'robot'", "'needed'", "'at'", "'location'", "'subtasks'", "'['", "']'", "'constraint:'", "'ordered'", "'consecutive'", "'initial'", "'position'", "'has'", "'velocity'", "'with'", "'capabilities'", "'-required'", "'time:'", "'success'", "'rate:'", "'%'", "'objectives:'", "'constraints:'", "'parameters:'", "'numAllocation:'", "'population:'", "'evaluation:'", "'atomic'", "'task'", "'compound'", "'rate'", "'of'", "'greater'", "'than'", "'all'", "'work'", "'in'", "'mission'", "'time'", "'allocate'", "'tasks'", "'closest'", "'limit'", "'max'", "'number'", "'per'", "'-'", "'.'", "'E'", "'e'", "'minimiseIdle'", "'minimiseTravel'", "'maximiseSuccess'", "'lower'", "'end'", "'start'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ProblemSpecification";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProblemSpecification"
    // InternalMyDsl.g:65:1: entryRuleProblemSpecification returns [EObject current=null] : iv_ruleProblemSpecification= ruleProblemSpecification EOF ;
    public final EObject entryRuleProblemSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProblemSpecification = null;


        try {
            // InternalMyDsl.g:65:61: (iv_ruleProblemSpecification= ruleProblemSpecification EOF )
            // InternalMyDsl.g:66:2: iv_ruleProblemSpecification= ruleProblemSpecification EOF
            {
             newCompositeNode(grammarAccess.getProblemSpecificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProblemSpecification=ruleProblemSpecification();

            state._fsp--;

             current =iv_ruleProblemSpecification; 
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
    // $ANTLR end "entryRuleProblemSpecification"


    // $ANTLR start "ruleProblemSpecification"
    // InternalMyDsl.g:72:1: ruleProblemSpecification returns [EObject current=null] : (otherlv_0= 'ProblemSpecification' otherlv_1= '{' otherlv_2= 'WorldModel' otherlv_3= ':' ( (lv_worldModel_4_0= ruleWorldModel ) ) ( (lv_worldModel_5_0= ruleWorldModel ) )* otherlv_6= 'TasksModel' otherlv_7= ':' ( (lv_tasksModel_8_0= ruleTasksModel ) ) (otherlv_9= ',' ( (lv_tasksModel_10_0= ruleTasksModel ) ) )* otherlv_11= 'RobotsModel' otherlv_12= ':' ( (lv_robotsModel_13_0= ruleRobot ) ) (otherlv_14= ',' ( (lv_robotsModel_15_0= ruleRobot ) ) )* otherlv_16= 'Mission' otherlv_17= ':' ( (lv_mission_18_0= ruleMission ) ) (otherlv_19= ',' ( (lv_mission_20_0= ruleMission ) ) )* otherlv_21= '}' ) ;
    public final EObject ruleProblemSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject lv_worldModel_4_0 = null;

        EObject lv_worldModel_5_0 = null;

        EObject lv_tasksModel_8_0 = null;

        EObject lv_tasksModel_10_0 = null;

        EObject lv_robotsModel_13_0 = null;

        EObject lv_robotsModel_15_0 = null;

        EObject lv_mission_18_0 = null;

        EObject lv_mission_20_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:78:2: ( (otherlv_0= 'ProblemSpecification' otherlv_1= '{' otherlv_2= 'WorldModel' otherlv_3= ':' ( (lv_worldModel_4_0= ruleWorldModel ) ) ( (lv_worldModel_5_0= ruleWorldModel ) )* otherlv_6= 'TasksModel' otherlv_7= ':' ( (lv_tasksModel_8_0= ruleTasksModel ) ) (otherlv_9= ',' ( (lv_tasksModel_10_0= ruleTasksModel ) ) )* otherlv_11= 'RobotsModel' otherlv_12= ':' ( (lv_robotsModel_13_0= ruleRobot ) ) (otherlv_14= ',' ( (lv_robotsModel_15_0= ruleRobot ) ) )* otherlv_16= 'Mission' otherlv_17= ':' ( (lv_mission_18_0= ruleMission ) ) (otherlv_19= ',' ( (lv_mission_20_0= ruleMission ) ) )* otherlv_21= '}' ) )
            // InternalMyDsl.g:79:2: (otherlv_0= 'ProblemSpecification' otherlv_1= '{' otherlv_2= 'WorldModel' otherlv_3= ':' ( (lv_worldModel_4_0= ruleWorldModel ) ) ( (lv_worldModel_5_0= ruleWorldModel ) )* otherlv_6= 'TasksModel' otherlv_7= ':' ( (lv_tasksModel_8_0= ruleTasksModel ) ) (otherlv_9= ',' ( (lv_tasksModel_10_0= ruleTasksModel ) ) )* otherlv_11= 'RobotsModel' otherlv_12= ':' ( (lv_robotsModel_13_0= ruleRobot ) ) (otherlv_14= ',' ( (lv_robotsModel_15_0= ruleRobot ) ) )* otherlv_16= 'Mission' otherlv_17= ':' ( (lv_mission_18_0= ruleMission ) ) (otherlv_19= ',' ( (lv_mission_20_0= ruleMission ) ) )* otherlv_21= '}' )
            {
            // InternalMyDsl.g:79:2: (otherlv_0= 'ProblemSpecification' otherlv_1= '{' otherlv_2= 'WorldModel' otherlv_3= ':' ( (lv_worldModel_4_0= ruleWorldModel ) ) ( (lv_worldModel_5_0= ruleWorldModel ) )* otherlv_6= 'TasksModel' otherlv_7= ':' ( (lv_tasksModel_8_0= ruleTasksModel ) ) (otherlv_9= ',' ( (lv_tasksModel_10_0= ruleTasksModel ) ) )* otherlv_11= 'RobotsModel' otherlv_12= ':' ( (lv_robotsModel_13_0= ruleRobot ) ) (otherlv_14= ',' ( (lv_robotsModel_15_0= ruleRobot ) ) )* otherlv_16= 'Mission' otherlv_17= ':' ( (lv_mission_18_0= ruleMission ) ) (otherlv_19= ',' ( (lv_mission_20_0= ruleMission ) ) )* otherlv_21= '}' )
            // InternalMyDsl.g:80:3: otherlv_0= 'ProblemSpecification' otherlv_1= '{' otherlv_2= 'WorldModel' otherlv_3= ':' ( (lv_worldModel_4_0= ruleWorldModel ) ) ( (lv_worldModel_5_0= ruleWorldModel ) )* otherlv_6= 'TasksModel' otherlv_7= ':' ( (lv_tasksModel_8_0= ruleTasksModel ) ) (otherlv_9= ',' ( (lv_tasksModel_10_0= ruleTasksModel ) ) )* otherlv_11= 'RobotsModel' otherlv_12= ':' ( (lv_robotsModel_13_0= ruleRobot ) ) (otherlv_14= ',' ( (lv_robotsModel_15_0= ruleRobot ) ) )* otherlv_16= 'Mission' otherlv_17= ':' ( (lv_mission_18_0= ruleMission ) ) (otherlv_19= ',' ( (lv_mission_20_0= ruleMission ) ) )* otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getProblemSpecificationAccess().getProblemSpecificationKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getProblemSpecificationAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getProblemSpecificationAccess().getWorldModelKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getProblemSpecificationAccess().getColonKeyword_3());
            		
            // InternalMyDsl.g:96:3: ( (lv_worldModel_4_0= ruleWorldModel ) )
            // InternalMyDsl.g:97:4: (lv_worldModel_4_0= ruleWorldModel )
            {
            // InternalMyDsl.g:97:4: (lv_worldModel_4_0= ruleWorldModel )
            // InternalMyDsl.g:98:5: lv_worldModel_4_0= ruleWorldModel
            {

            					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getWorldModelWorldModelParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_worldModel_4_0=ruleWorldModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            					}
            					add(
            						current,
            						"worldModel",
            						lv_worldModel_4_0,
            						"org.xtext.example.mydsl.MyDsl.WorldModel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:115:3: ( (lv_worldModel_5_0= ruleWorldModel ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==25) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyDsl.g:116:4: (lv_worldModel_5_0= ruleWorldModel )
            	    {
            	    // InternalMyDsl.g:116:4: (lv_worldModel_5_0= ruleWorldModel )
            	    // InternalMyDsl.g:117:5: lv_worldModel_5_0= ruleWorldModel
            	    {

            	    					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getWorldModelWorldModelParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_worldModel_5_0=ruleWorldModel();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"worldModel",
            	    						lv_worldModel_5_0,
            	    						"org.xtext.example.mydsl.MyDsl.WorldModel");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_6, grammarAccess.getProblemSpecificationAccess().getTasksModelKeyword_6());
            		
            otherlv_7=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_7, grammarAccess.getProblemSpecificationAccess().getColonKeyword_7());
            		
            // InternalMyDsl.g:142:3: ( (lv_tasksModel_8_0= ruleTasksModel ) )
            // InternalMyDsl.g:143:4: (lv_tasksModel_8_0= ruleTasksModel )
            {
            // InternalMyDsl.g:143:4: (lv_tasksModel_8_0= ruleTasksModel )
            // InternalMyDsl.g:144:5: lv_tasksModel_8_0= ruleTasksModel
            {

            					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getTasksModelTasksModelParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_9);
            lv_tasksModel_8_0=ruleTasksModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            					}
            					add(
            						current,
            						"tasksModel",
            						lv_tasksModel_8_0,
            						"org.xtext.example.mydsl.MyDsl.TasksModel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:161:3: (otherlv_9= ',' ( (lv_tasksModel_10_0= ruleTasksModel ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMyDsl.g:162:4: otherlv_9= ',' ( (lv_tasksModel_10_0= ruleTasksModel ) )
            	    {
            	    otherlv_9=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_9, grammarAccess.getProblemSpecificationAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalMyDsl.g:166:4: ( (lv_tasksModel_10_0= ruleTasksModel ) )
            	    // InternalMyDsl.g:167:5: (lv_tasksModel_10_0= ruleTasksModel )
            	    {
            	    // InternalMyDsl.g:167:5: (lv_tasksModel_10_0= ruleTasksModel )
            	    // InternalMyDsl.g:168:6: lv_tasksModel_10_0= ruleTasksModel
            	    {

            	    						newCompositeNode(grammarAccess.getProblemSpecificationAccess().getTasksModelTasksModelParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_tasksModel_10_0=ruleTasksModel();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"tasksModel",
            	    							lv_tasksModel_10_0,
            	    							"org.xtext.example.mydsl.MyDsl.TasksModel");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_11=(Token)match(input,17,FOLLOW_5); 

            			newLeafNode(otherlv_11, grammarAccess.getProblemSpecificationAccess().getRobotsModelKeyword_10());
            		
            otherlv_12=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_12, grammarAccess.getProblemSpecificationAccess().getColonKeyword_11());
            		
            // InternalMyDsl.g:194:3: ( (lv_robotsModel_13_0= ruleRobot ) )
            // InternalMyDsl.g:195:4: (lv_robotsModel_13_0= ruleRobot )
            {
            // InternalMyDsl.g:195:4: (lv_robotsModel_13_0= ruleRobot )
            // InternalMyDsl.g:196:5: lv_robotsModel_13_0= ruleRobot
            {

            					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getRobotsModelRobotParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_10);
            lv_robotsModel_13_0=ruleRobot();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            					}
            					add(
            						current,
            						"robotsModel",
            						lv_robotsModel_13_0,
            						"org.xtext.example.mydsl.MyDsl.Robot");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:213:3: (otherlv_14= ',' ( (lv_robotsModel_15_0= ruleRobot ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMyDsl.g:214:4: otherlv_14= ',' ( (lv_robotsModel_15_0= ruleRobot ) )
            	    {
            	    otherlv_14=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_14, grammarAccess.getProblemSpecificationAccess().getCommaKeyword_13_0());
            	    			
            	    // InternalMyDsl.g:218:4: ( (lv_robotsModel_15_0= ruleRobot ) )
            	    // InternalMyDsl.g:219:5: (lv_robotsModel_15_0= ruleRobot )
            	    {
            	    // InternalMyDsl.g:219:5: (lv_robotsModel_15_0= ruleRobot )
            	    // InternalMyDsl.g:220:6: lv_robotsModel_15_0= ruleRobot
            	    {

            	    						newCompositeNode(grammarAccess.getProblemSpecificationAccess().getRobotsModelRobotParserRuleCall_13_1_0());
            	    					
            	    pushFollow(FOLLOW_10);
            	    lv_robotsModel_15_0=ruleRobot();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"robotsModel",
            	    							lv_robotsModel_15_0,
            	    							"org.xtext.example.mydsl.MyDsl.Robot");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_16=(Token)match(input,18,FOLLOW_5); 

            			newLeafNode(otherlv_16, grammarAccess.getProblemSpecificationAccess().getMissionKeyword_14());
            		
            otherlv_17=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_17, grammarAccess.getProblemSpecificationAccess().getColonKeyword_15());
            		
            // InternalMyDsl.g:246:3: ( (lv_mission_18_0= ruleMission ) )
            // InternalMyDsl.g:247:4: (lv_mission_18_0= ruleMission )
            {
            // InternalMyDsl.g:247:4: (lv_mission_18_0= ruleMission )
            // InternalMyDsl.g:248:5: lv_mission_18_0= ruleMission
            {

            					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getMissionMissionParserRuleCall_16_0());
            				
            pushFollow(FOLLOW_11);
            lv_mission_18_0=ruleMission();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            					}
            					add(
            						current,
            						"mission",
            						lv_mission_18_0,
            						"org.xtext.example.mydsl.MyDsl.Mission");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:265:3: (otherlv_19= ',' ( (lv_mission_20_0= ruleMission ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMyDsl.g:266:4: otherlv_19= ',' ( (lv_mission_20_0= ruleMission ) )
            	    {
            	    otherlv_19=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_19, grammarAccess.getProblemSpecificationAccess().getCommaKeyword_17_0());
            	    			
            	    // InternalMyDsl.g:270:4: ( (lv_mission_20_0= ruleMission ) )
            	    // InternalMyDsl.g:271:5: (lv_mission_20_0= ruleMission )
            	    {
            	    // InternalMyDsl.g:271:5: (lv_mission_20_0= ruleMission )
            	    // InternalMyDsl.g:272:6: lv_mission_20_0= ruleMission
            	    {

            	    						newCompositeNode(grammarAccess.getProblemSpecificationAccess().getMissionMissionParserRuleCall_17_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_mission_20_0=ruleMission();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"mission",
            	    							lv_mission_20_0,
            	    							"org.xtext.example.mydsl.MyDsl.Mission");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_21=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_21, grammarAccess.getProblemSpecificationAccess().getRightCurlyBracketKeyword_18());
            		

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
    // $ANTLR end "ruleProblemSpecification"


    // $ANTLR start "entryRuleWorldModel"
    // InternalMyDsl.g:298:1: entryRuleWorldModel returns [EObject current=null] : iv_ruleWorldModel= ruleWorldModel EOF ;
    public final EObject entryRuleWorldModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorldModel = null;


        try {
            // InternalMyDsl.g:298:51: (iv_ruleWorldModel= ruleWorldModel EOF )
            // InternalMyDsl.g:299:2: iv_ruleWorldModel= ruleWorldModel EOF
            {
             newCompositeNode(grammarAccess.getWorldModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorldModel=ruleWorldModel();

            state._fsp--;

             current =iv_ruleWorldModel; 
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
    // $ANTLR end "entryRuleWorldModel"


    // $ANTLR start "ruleWorldModel"
    // InternalMyDsl.g:305:1: ruleWorldModel returns [EObject current=null] : (this_Location_0= ruleLocation | this_Paths_1= rulePaths ) ;
    public final EObject ruleWorldModel() throws RecognitionException {
        EObject current = null;

        EObject this_Location_0 = null;

        EObject this_Paths_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:311:2: ( (this_Location_0= ruleLocation | this_Paths_1= rulePaths ) )
            // InternalMyDsl.g:312:2: (this_Location_0= ruleLocation | this_Paths_1= rulePaths )
            {
            // InternalMyDsl.g:312:2: (this_Location_0= ruleLocation | this_Paths_1= rulePaths )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_ID)) ) {
                alt5=1;
            }
            else if ( (LA5_0==25) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalMyDsl.g:313:3: this_Location_0= ruleLocation
                    {

                    			newCompositeNode(grammarAccess.getWorldModelAccess().getLocationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Location_0=ruleLocation();

                    state._fsp--;


                    			current = this_Location_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:322:3: this_Paths_1= rulePaths
                    {

                    			newCompositeNode(grammarAccess.getWorldModelAccess().getPathsParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Paths_1=rulePaths();

                    state._fsp--;


                    			current = this_Paths_1;
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
    // $ANTLR end "ruleWorldModel"


    // $ANTLR start "entryRuleLocation"
    // InternalMyDsl.g:334:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // InternalMyDsl.g:334:49: (iv_ruleLocation= ruleLocation EOF )
            // InternalMyDsl.g:335:2: iv_ruleLocation= ruleLocation EOF
            {
             newCompositeNode(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocation=ruleLocation();

            state._fsp--;

             current =iv_ruleLocation; 
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
    // $ANTLR end "entryRuleLocation"


    // $ANTLR start "ruleLocation"
    // InternalMyDsl.g:341:1: ruleLocation returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= '(' otherlv_3= 'x' ( (lv_x_4_0= ruleEDouble ) ) otherlv_5= 'y' ( (lv_y_6_0= ruleEDouble ) ) (otherlv_7= ',' otherlv_8= 'describes' ( (lv_description_9_0= ruleEString ) ) )? otherlv_10= ')' ) ;
    public final EObject ruleLocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_x_4_0 = null;

        AntlrDatatypeRuleToken lv_y_6_0 = null;

        AntlrDatatypeRuleToken lv_description_9_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:347:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= '(' otherlv_3= 'x' ( (lv_x_4_0= ruleEDouble ) ) otherlv_5= 'y' ( (lv_y_6_0= ruleEDouble ) ) (otherlv_7= ',' otherlv_8= 'describes' ( (lv_description_9_0= ruleEString ) ) )? otherlv_10= ')' ) )
            // InternalMyDsl.g:348:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= '(' otherlv_3= 'x' ( (lv_x_4_0= ruleEDouble ) ) otherlv_5= 'y' ( (lv_y_6_0= ruleEDouble ) ) (otherlv_7= ',' otherlv_8= 'describes' ( (lv_description_9_0= ruleEString ) ) )? otherlv_10= ')' )
            {
            // InternalMyDsl.g:348:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= '(' otherlv_3= 'x' ( (lv_x_4_0= ruleEDouble ) ) otherlv_5= 'y' ( (lv_y_6_0= ruleEDouble ) ) (otherlv_7= ',' otherlv_8= 'describes' ( (lv_description_9_0= ruleEString ) ) )? otherlv_10= ')' )
            // InternalMyDsl.g:349:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= '(' otherlv_3= 'x' ( (lv_x_4_0= ruleEDouble ) ) otherlv_5= 'y' ( (lv_y_6_0= ruleEDouble ) ) (otherlv_7= ',' otherlv_8= 'describes' ( (lv_description_9_0= ruleEString ) ) )? otherlv_10= ')'
            {
            // InternalMyDsl.g:349:3: ( (lv_name_0_0= ruleEString ) )
            // InternalMyDsl.g:350:4: (lv_name_0_0= ruleEString )
            {
            // InternalMyDsl.g:350:4: (lv_name_0_0= ruleEString )
            // InternalMyDsl.g:351:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLocationAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getLocationAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getLocationAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,21,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getLocationAccess().getXKeyword_3());
            		
            // InternalMyDsl.g:380:3: ( (lv_x_4_0= ruleEDouble ) )
            // InternalMyDsl.g:381:4: (lv_x_4_0= ruleEDouble )
            {
            // InternalMyDsl.g:381:4: (lv_x_4_0= ruleEDouble )
            // InternalMyDsl.g:382:5: lv_x_4_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getLocationAccess().getXEDoubleParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_15);
            lv_x_4_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationRule());
            					}
            					set(
            						current,
            						"x",
            						lv_x_4_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,22,FOLLOW_14); 

            			newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getYKeyword_5());
            		
            // InternalMyDsl.g:403:3: ( (lv_y_6_0= ruleEDouble ) )
            // InternalMyDsl.g:404:4: (lv_y_6_0= ruleEDouble )
            {
            // InternalMyDsl.g:404:4: (lv_y_6_0= ruleEDouble )
            // InternalMyDsl.g:405:5: lv_y_6_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getLocationAccess().getYEDoubleParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_16);
            lv_y_6_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationRule());
            					}
            					set(
            						current,
            						"y",
            						lv_y_6_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:422:3: (otherlv_7= ',' otherlv_8= 'describes' ( (lv_description_9_0= ruleEString ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:423:4: otherlv_7= ',' otherlv_8= 'describes' ( (lv_description_9_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_17); 

                    				newLeafNode(otherlv_7, grammarAccess.getLocationAccess().getCommaKeyword_7_0());
                    			
                    otherlv_8=(Token)match(input,23,FOLLOW_8); 

                    				newLeafNode(otherlv_8, grammarAccess.getLocationAccess().getDescribesKeyword_7_1());
                    			
                    // InternalMyDsl.g:431:4: ( (lv_description_9_0= ruleEString ) )
                    // InternalMyDsl.g:432:5: (lv_description_9_0= ruleEString )
                    {
                    // InternalMyDsl.g:432:5: (lv_description_9_0= ruleEString )
                    // InternalMyDsl.g:433:6: lv_description_9_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getLocationAccess().getDescriptionEStringParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_description_9_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLocationRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_9_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getLocationAccess().getRightParenthesisKeyword_8());
            		

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
    // $ANTLR end "ruleLocation"


    // $ANTLR start "entryRulePaths"
    // InternalMyDsl.g:459:1: entryRulePaths returns [EObject current=null] : iv_rulePaths= rulePaths EOF ;
    public final EObject entryRulePaths() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePaths = null;


        try {
            // InternalMyDsl.g:459:46: (iv_rulePaths= rulePaths EOF )
            // InternalMyDsl.g:460:2: iv_rulePaths= rulePaths EOF
            {
             newCompositeNode(grammarAccess.getPathsRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePaths=rulePaths();

            state._fsp--;

             current =iv_rulePaths; 
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
    // $ANTLR end "entryRulePaths"


    // $ANTLR start "rulePaths"
    // InternalMyDsl.g:466:1: rulePaths returns [EObject current=null] : (otherlv_0= 'distance' ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= 'is' ( (lv_distance_5_0= ruleEDouble ) ) ) ;
    public final EObject rulePaths() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_distance_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:472:2: ( (otherlv_0= 'distance' ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= 'is' ( (lv_distance_5_0= ruleEDouble ) ) ) )
            // InternalMyDsl.g:473:2: (otherlv_0= 'distance' ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= 'is' ( (lv_distance_5_0= ruleEDouble ) ) )
            {
            // InternalMyDsl.g:473:2: (otherlv_0= 'distance' ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= 'is' ( (lv_distance_5_0= ruleEDouble ) ) )
            // InternalMyDsl.g:474:3: otherlv_0= 'distance' ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= 'is' ( (lv_distance_5_0= ruleEDouble ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getPathsAccess().getDistanceKeyword_0());
            		
            // InternalMyDsl.g:478:3: ( ( ruleEString ) )
            // InternalMyDsl.g:479:4: ( ruleEString )
            {
            // InternalMyDsl.g:479:4: ( ruleEString )
            // InternalMyDsl.g:480:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPathsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPathsAccess().getLoc1LocationCrossReference_1_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getPathsAccess().getToKeyword_2());
            		
            // InternalMyDsl.g:498:3: ( ( ruleEString ) )
            // InternalMyDsl.g:499:4: ( ruleEString )
            {
            // InternalMyDsl.g:499:4: ( ruleEString )
            // InternalMyDsl.g:500:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPathsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPathsAccess().getLoc2LocationCrossReference_3_0());
            				
            pushFollow(FOLLOW_20);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,27,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getPathsAccess().getIsKeyword_4());
            		
            // InternalMyDsl.g:518:3: ( (lv_distance_5_0= ruleEDouble ) )
            // InternalMyDsl.g:519:4: (lv_distance_5_0= ruleEDouble )
            {
            // InternalMyDsl.g:519:4: (lv_distance_5_0= ruleEDouble )
            // InternalMyDsl.g:520:5: lv_distance_5_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getPathsAccess().getDistanceEDoubleParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_distance_5_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathsRule());
            					}
            					set(
            						current,
            						"distance",
            						lv_distance_5_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "rulePaths"


    // $ANTLR start "entryRuleTasksModel"
    // InternalMyDsl.g:541:1: entryRuleTasksModel returns [EObject current=null] : iv_ruleTasksModel= ruleTasksModel EOF ;
    public final EObject entryRuleTasksModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTasksModel = null;


        try {
            // InternalMyDsl.g:541:51: (iv_ruleTasksModel= ruleTasksModel EOF )
            // InternalMyDsl.g:542:2: iv_ruleTasksModel= ruleTasksModel EOF
            {
             newCompositeNode(grammarAccess.getTasksModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTasksModel=ruleTasksModel();

            state._fsp--;

             current =iv_ruleTasksModel; 
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
    // $ANTLR end "entryRuleTasksModel"


    // $ANTLR start "ruleTasksModel"
    // InternalMyDsl.g:548:1: ruleTasksModel returns [EObject current=null] : (this_AtomicTask_0= ruleAtomicTask | this_CompoundTask_1= ruleCompoundTask ) ;
    public final EObject ruleTasksModel() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicTask_0 = null;

        EObject this_CompoundTask_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:554:2: ( (this_AtomicTask_0= ruleAtomicTask | this_CompoundTask_1= ruleCompoundTask ) )
            // InternalMyDsl.g:555:2: (this_AtomicTask_0= ruleAtomicTask | this_CompoundTask_1= ruleCompoundTask )
            {
            // InternalMyDsl.g:555:2: (this_AtomicTask_0= ruleAtomicTask | this_CompoundTask_1= ruleCompoundTask )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==14) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==33) ) {
                        alt7=2;
                    }
                    else if ( (LA7_3==RULE_INT||LA7_3==75) ) {
                        alt7=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA7_0==RULE_ID) ) {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==14) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==33) ) {
                        alt7=2;
                    }
                    else if ( (LA7_3==RULE_INT||LA7_3==75) ) {
                        alt7=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalMyDsl.g:556:3: this_AtomicTask_0= ruleAtomicTask
                    {

                    			newCompositeNode(grammarAccess.getTasksModelAccess().getAtomicTaskParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AtomicTask_0=ruleAtomicTask();

                    state._fsp--;


                    			current = this_AtomicTask_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:565:3: this_CompoundTask_1= ruleCompoundTask
                    {

                    			newCompositeNode(grammarAccess.getTasksModelAccess().getCompoundTaskParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CompoundTask_1=ruleCompoundTask();

                    state._fsp--;


                    			current = this_CompoundTask_1;
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
    // $ANTLR end "ruleTasksModel"


    // $ANTLR start "entryRuleAtomicTask"
    // InternalMyDsl.g:577:1: entryRuleAtomicTask returns [EObject current=null] : iv_ruleAtomicTask= ruleAtomicTask EOF ;
    public final EObject entryRuleAtomicTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicTask = null;


        try {
            // InternalMyDsl.g:577:51: (iv_ruleAtomicTask= ruleAtomicTask EOF )
            // InternalMyDsl.g:578:2: iv_ruleAtomicTask= ruleAtomicTask EOF
            {
             newCompositeNode(grammarAccess.getAtomicTaskRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtomicTask=ruleAtomicTask();

            state._fsp--;

             current =iv_ruleAtomicTask; 
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
    // $ANTLR end "entryRuleAtomicTask"


    // $ANTLR start "ruleAtomicTask"
    // InternalMyDsl.g:584:1: ruleAtomicTask returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_robots_2_0= ruleEInt ) ) (otherlv_3= 'robots' | otherlv_4= 'robot' ) otherlv_5= 'needed' otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) ) ) ;
    public final EObject ruleAtomicTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_robots_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:590:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_robots_2_0= ruleEInt ) ) (otherlv_3= 'robots' | otherlv_4= 'robot' ) otherlv_5= 'needed' otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) ) ) )
            // InternalMyDsl.g:591:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_robots_2_0= ruleEInt ) ) (otherlv_3= 'robots' | otherlv_4= 'robot' ) otherlv_5= 'needed' otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) ) )
            {
            // InternalMyDsl.g:591:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_robots_2_0= ruleEInt ) ) (otherlv_3= 'robots' | otherlv_4= 'robot' ) otherlv_5= 'needed' otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) ) )
            // InternalMyDsl.g:592:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_robots_2_0= ruleEInt ) ) (otherlv_3= 'robots' | otherlv_4= 'robot' ) otherlv_5= 'needed' otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) )
            {
            // InternalMyDsl.g:592:3: ( (lv_name_0_0= ruleEString ) )
            // InternalMyDsl.g:593:4: (lv_name_0_0= ruleEString )
            {
            // InternalMyDsl.g:593:4: (lv_name_0_0= ruleEString )
            // InternalMyDsl.g:594:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAtomicTaskAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAtomicTaskRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getAtomicTaskAccess().getColonKeyword_1());
            		
            // InternalMyDsl.g:615:3: ( (lv_robots_2_0= ruleEInt ) )
            // InternalMyDsl.g:616:4: (lv_robots_2_0= ruleEInt )
            {
            // InternalMyDsl.g:616:4: (lv_robots_2_0= ruleEInt )
            // InternalMyDsl.g:617:5: lv_robots_2_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getAtomicTaskAccess().getRobotsEIntParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_22);
            lv_robots_2_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAtomicTaskRule());
            					}
            					set(
            						current,
            						"robots",
            						lv_robots_2_0,
            						"org.xtext.example.mydsl.MyDsl.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:634:3: (otherlv_3= 'robots' | otherlv_4= 'robot' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==28) ) {
                alt8=1;
            }
            else if ( (LA8_0==29) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:635:4: otherlv_3= 'robots'
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_23); 

                    				newLeafNode(otherlv_3, grammarAccess.getAtomicTaskAccess().getRobotsKeyword_3_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:640:4: otherlv_4= 'robot'
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_23); 

                    				newLeafNode(otherlv_4, grammarAccess.getAtomicTaskAccess().getRobotKeyword_3_1());
                    			

                    }
                    break;

            }

            otherlv_5=(Token)match(input,30,FOLLOW_24); 

            			newLeafNode(otherlv_5, grammarAccess.getAtomicTaskAccess().getNeededKeyword_4());
            		
            otherlv_6=(Token)match(input,31,FOLLOW_25); 

            			newLeafNode(otherlv_6, grammarAccess.getAtomicTaskAccess().getAtKeyword_5());
            		
            otherlv_7=(Token)match(input,32,FOLLOW_8); 

            			newLeafNode(otherlv_7, grammarAccess.getAtomicTaskAccess().getLocationKeyword_6());
            		
            // InternalMyDsl.g:657:3: ( ( ruleEString ) )
            // InternalMyDsl.g:658:4: ( ruleEString )
            {
            // InternalMyDsl.g:658:4: ( ruleEString )
            // InternalMyDsl.g:659:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAtomicTaskRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAtomicTaskAccess().getLocLocationCrossReference_7_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleAtomicTask"


    // $ANTLR start "entryRuleCompoundTask"
    // InternalMyDsl.g:677:1: entryRuleCompoundTask returns [EObject current=null] : iv_ruleCompoundTask= ruleCompoundTask EOF ;
    public final EObject entryRuleCompoundTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundTask = null;


        try {
            // InternalMyDsl.g:677:53: (iv_ruleCompoundTask= ruleCompoundTask EOF )
            // InternalMyDsl.g:678:2: iv_ruleCompoundTask= ruleCompoundTask EOF
            {
             newCompositeNode(grammarAccess.getCompoundTaskRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompoundTask=ruleCompoundTask();

            state._fsp--;

             current =iv_ruleCompoundTask; 
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
    // $ANTLR end "entryRuleCompoundTask"


    // $ANTLR start "ruleCompoundTask"
    // InternalMyDsl.g:684:1: ruleCompoundTask returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'subtasks' otherlv_3= '[' ( ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* )? otherlv_7= ']' ( (otherlv_8= 'constraint:' ( (lv_ordered_9_0= 'ordered' ) ) ) | (otherlv_10= 'constraint:' ( (lv_consecutive_11_0= 'consecutive' ) ) ) )? ) ;
    public final EObject ruleCompoundTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_ordered_9_0=null;
        Token otherlv_10=null;
        Token lv_consecutive_11_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:690:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'subtasks' otherlv_3= '[' ( ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* )? otherlv_7= ']' ( (otherlv_8= 'constraint:' ( (lv_ordered_9_0= 'ordered' ) ) ) | (otherlv_10= 'constraint:' ( (lv_consecutive_11_0= 'consecutive' ) ) ) )? ) )
            // InternalMyDsl.g:691:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'subtasks' otherlv_3= '[' ( ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* )? otherlv_7= ']' ( (otherlv_8= 'constraint:' ( (lv_ordered_9_0= 'ordered' ) ) ) | (otherlv_10= 'constraint:' ( (lv_consecutive_11_0= 'consecutive' ) ) ) )? )
            {
            // InternalMyDsl.g:691:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'subtasks' otherlv_3= '[' ( ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* )? otherlv_7= ']' ( (otherlv_8= 'constraint:' ( (lv_ordered_9_0= 'ordered' ) ) ) | (otherlv_10= 'constraint:' ( (lv_consecutive_11_0= 'consecutive' ) ) ) )? )
            // InternalMyDsl.g:692:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'subtasks' otherlv_3= '[' ( ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* )? otherlv_7= ']' ( (otherlv_8= 'constraint:' ( (lv_ordered_9_0= 'ordered' ) ) ) | (otherlv_10= 'constraint:' ( (lv_consecutive_11_0= 'consecutive' ) ) ) )?
            {
            // InternalMyDsl.g:692:3: ( (lv_name_0_0= ruleEString ) )
            // InternalMyDsl.g:693:4: (lv_name_0_0= ruleEString )
            {
            // InternalMyDsl.g:693:4: (lv_name_0_0= ruleEString )
            // InternalMyDsl.g:694:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCompoundTaskAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompoundTaskRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getCompoundTaskAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,33,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getCompoundTaskAccess().getSubtasksKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getCompoundTaskAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalMyDsl.g:723:3: ( ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_ID)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMyDsl.g:724:4: ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )*
                    {
                    // InternalMyDsl.g:724:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:725:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:725:5: ( ruleEString )
                    // InternalMyDsl.g:726:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCompoundTaskRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelCrossReference_4_0_0());
                    					
                    pushFollow(FOLLOW_29);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:740:4: (otherlv_5= ',' ( ( ruleEString ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==16) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalMyDsl.g:741:5: otherlv_5= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_5=(Token)match(input,16,FOLLOW_8); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getCompoundTaskAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalMyDsl.g:745:5: ( ( ruleEString ) )
                    	    // InternalMyDsl.g:746:6: ( ruleEString )
                    	    {
                    	    // InternalMyDsl.g:746:6: ( ruleEString )
                    	    // InternalMyDsl.g:747:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getCompoundTaskRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelCrossReference_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_29);
                    	    ruleEString();

                    	    state._fsp--;


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
                    break;

            }

            otherlv_7=(Token)match(input,35,FOLLOW_30); 

            			newLeafNode(otherlv_7, grammarAccess.getCompoundTaskAccess().getRightSquareBracketKeyword_5());
            		
            // InternalMyDsl.g:767:3: ( (otherlv_8= 'constraint:' ( (lv_ordered_9_0= 'ordered' ) ) ) | (otherlv_10= 'constraint:' ( (lv_consecutive_11_0= 'consecutive' ) ) ) )?
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==36) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==38) ) {
                    alt11=2;
                }
                else if ( (LA11_1==37) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // InternalMyDsl.g:768:4: (otherlv_8= 'constraint:' ( (lv_ordered_9_0= 'ordered' ) ) )
                    {
                    // InternalMyDsl.g:768:4: (otherlv_8= 'constraint:' ( (lv_ordered_9_0= 'ordered' ) ) )
                    // InternalMyDsl.g:769:5: otherlv_8= 'constraint:' ( (lv_ordered_9_0= 'ordered' ) )
                    {
                    otherlv_8=(Token)match(input,36,FOLLOW_31); 

                    					newLeafNode(otherlv_8, grammarAccess.getCompoundTaskAccess().getConstraintKeyword_6_0_0());
                    				
                    // InternalMyDsl.g:773:5: ( (lv_ordered_9_0= 'ordered' ) )
                    // InternalMyDsl.g:774:6: (lv_ordered_9_0= 'ordered' )
                    {
                    // InternalMyDsl.g:774:6: (lv_ordered_9_0= 'ordered' )
                    // InternalMyDsl.g:775:7: lv_ordered_9_0= 'ordered'
                    {
                    lv_ordered_9_0=(Token)match(input,37,FOLLOW_2); 

                    							newLeafNode(lv_ordered_9_0, grammarAccess.getCompoundTaskAccess().getOrderedOrderedKeyword_6_0_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getCompoundTaskRule());
                    							}
                    							setWithLastConsumed(current, "ordered", lv_ordered_9_0 != null, "ordered");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:789:4: (otherlv_10= 'constraint:' ( (lv_consecutive_11_0= 'consecutive' ) ) )
                    {
                    // InternalMyDsl.g:789:4: (otherlv_10= 'constraint:' ( (lv_consecutive_11_0= 'consecutive' ) ) )
                    // InternalMyDsl.g:790:5: otherlv_10= 'constraint:' ( (lv_consecutive_11_0= 'consecutive' ) )
                    {
                    otherlv_10=(Token)match(input,36,FOLLOW_32); 

                    					newLeafNode(otherlv_10, grammarAccess.getCompoundTaskAccess().getConstraintKeyword_6_1_0());
                    				
                    // InternalMyDsl.g:794:5: ( (lv_consecutive_11_0= 'consecutive' ) )
                    // InternalMyDsl.g:795:6: (lv_consecutive_11_0= 'consecutive' )
                    {
                    // InternalMyDsl.g:795:6: (lv_consecutive_11_0= 'consecutive' )
                    // InternalMyDsl.g:796:7: lv_consecutive_11_0= 'consecutive'
                    {
                    lv_consecutive_11_0=(Token)match(input,38,FOLLOW_2); 

                    							newLeafNode(lv_consecutive_11_0, grammarAccess.getCompoundTaskAccess().getConsecutiveConsecutiveKeyword_6_1_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getCompoundTaskRule());
                    							}
                    							setWithLastConsumed(current, "consecutive", lv_consecutive_11_0 != null, "consecutive");
                    						

                    }


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
    // $ANTLR end "ruleCompoundTask"


    // $ANTLR start "entryRuleRobot"
    // InternalMyDsl.g:814:1: entryRuleRobot returns [EObject current=null] : iv_ruleRobot= ruleRobot EOF ;
    public final EObject entryRuleRobot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRobot = null;


        try {
            // InternalMyDsl.g:814:46: (iv_ruleRobot= ruleRobot EOF )
            // InternalMyDsl.g:815:2: iv_ruleRobot= ruleRobot EOF
            {
             newCompositeNode(grammarAccess.getRobotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRobot=ruleRobot();

            state._fsp--;

             current =iv_ruleRobot; 
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
    // $ANTLR end "entryRuleRobot"


    // $ANTLR start "ruleRobot"
    // InternalMyDsl.g:821:1: ruleRobot returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'at' otherlv_3= 'initial' otherlv_4= 'position' ( ( ruleEString ) ) otherlv_6= 'has' otherlv_7= 'velocity' ( (lv_velocity_8_0= ruleEDouble ) ) otherlv_9= 'with' otherlv_10= 'capabilities' otherlv_11= '(' ( (lv_capabilities_12_0= ruleCapability ) ) (otherlv_13= ',' ( (lv_capabilities_14_0= ruleCapability ) ) )* otherlv_15= ')' ) ;
    public final EObject ruleRobot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_velocity_8_0 = null;

        EObject lv_capabilities_12_0 = null;

        EObject lv_capabilities_14_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:827:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'at' otherlv_3= 'initial' otherlv_4= 'position' ( ( ruleEString ) ) otherlv_6= 'has' otherlv_7= 'velocity' ( (lv_velocity_8_0= ruleEDouble ) ) otherlv_9= 'with' otherlv_10= 'capabilities' otherlv_11= '(' ( (lv_capabilities_12_0= ruleCapability ) ) (otherlv_13= ',' ( (lv_capabilities_14_0= ruleCapability ) ) )* otherlv_15= ')' ) )
            // InternalMyDsl.g:828:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'at' otherlv_3= 'initial' otherlv_4= 'position' ( ( ruleEString ) ) otherlv_6= 'has' otherlv_7= 'velocity' ( (lv_velocity_8_0= ruleEDouble ) ) otherlv_9= 'with' otherlv_10= 'capabilities' otherlv_11= '(' ( (lv_capabilities_12_0= ruleCapability ) ) (otherlv_13= ',' ( (lv_capabilities_14_0= ruleCapability ) ) )* otherlv_15= ')' )
            {
            // InternalMyDsl.g:828:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'at' otherlv_3= 'initial' otherlv_4= 'position' ( ( ruleEString ) ) otherlv_6= 'has' otherlv_7= 'velocity' ( (lv_velocity_8_0= ruleEDouble ) ) otherlv_9= 'with' otherlv_10= 'capabilities' otherlv_11= '(' ( (lv_capabilities_12_0= ruleCapability ) ) (otherlv_13= ',' ( (lv_capabilities_14_0= ruleCapability ) ) )* otherlv_15= ')' )
            // InternalMyDsl.g:829:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'at' otherlv_3= 'initial' otherlv_4= 'position' ( ( ruleEString ) ) otherlv_6= 'has' otherlv_7= 'velocity' ( (lv_velocity_8_0= ruleEDouble ) ) otherlv_9= 'with' otherlv_10= 'capabilities' otherlv_11= '(' ( (lv_capabilities_12_0= ruleCapability ) ) (otherlv_13= ',' ( (lv_capabilities_14_0= ruleCapability ) ) )* otherlv_15= ')'
            {
            // InternalMyDsl.g:829:3: ( (lv_name_0_0= ruleEString ) )
            // InternalMyDsl.g:830:4: (lv_name_0_0= ruleEString )
            {
            // InternalMyDsl.g:830:4: (lv_name_0_0= ruleEString )
            // InternalMyDsl.g:831:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRobotAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobotRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_24); 

            			newLeafNode(otherlv_1, grammarAccess.getRobotAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,31,FOLLOW_33); 

            			newLeafNode(otherlv_2, grammarAccess.getRobotAccess().getAtKeyword_2());
            		
            otherlv_3=(Token)match(input,39,FOLLOW_34); 

            			newLeafNode(otherlv_3, grammarAccess.getRobotAccess().getInitialKeyword_3());
            		
            otherlv_4=(Token)match(input,40,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getRobotAccess().getPositionKeyword_4());
            		
            // InternalMyDsl.g:864:3: ( ( ruleEString ) )
            // InternalMyDsl.g:865:4: ( ruleEString )
            {
            // InternalMyDsl.g:865:4: ( ruleEString )
            // InternalMyDsl.g:866:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRobotRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRobotAccess().getInitLocLocationCrossReference_5_0());
            				
            pushFollow(FOLLOW_35);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,41,FOLLOW_36); 

            			newLeafNode(otherlv_6, grammarAccess.getRobotAccess().getHasKeyword_6());
            		
            otherlv_7=(Token)match(input,42,FOLLOW_14); 

            			newLeafNode(otherlv_7, grammarAccess.getRobotAccess().getVelocityKeyword_7());
            		
            // InternalMyDsl.g:888:3: ( (lv_velocity_8_0= ruleEDouble ) )
            // InternalMyDsl.g:889:4: (lv_velocity_8_0= ruleEDouble )
            {
            // InternalMyDsl.g:889:4: (lv_velocity_8_0= ruleEDouble )
            // InternalMyDsl.g:890:5: lv_velocity_8_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getRobotAccess().getVelocityEDoubleParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_37);
            lv_velocity_8_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobotRule());
            					}
            					set(
            						current,
            						"velocity",
            						lv_velocity_8_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,43,FOLLOW_38); 

            			newLeafNode(otherlv_9, grammarAccess.getRobotAccess().getWithKeyword_9());
            		
            otherlv_10=(Token)match(input,44,FOLLOW_12); 

            			newLeafNode(otherlv_10, grammarAccess.getRobotAccess().getCapabilitiesKeyword_10());
            		
            otherlv_11=(Token)match(input,20,FOLLOW_8); 

            			newLeafNode(otherlv_11, grammarAccess.getRobotAccess().getLeftParenthesisKeyword_11());
            		
            // InternalMyDsl.g:919:3: ( (lv_capabilities_12_0= ruleCapability ) )
            // InternalMyDsl.g:920:4: (lv_capabilities_12_0= ruleCapability )
            {
            // InternalMyDsl.g:920:4: (lv_capabilities_12_0= ruleCapability )
            // InternalMyDsl.g:921:5: lv_capabilities_12_0= ruleCapability
            {

            					newCompositeNode(grammarAccess.getRobotAccess().getCapabilitiesCapabilityParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_16);
            lv_capabilities_12_0=ruleCapability();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobotRule());
            					}
            					add(
            						current,
            						"capabilities",
            						lv_capabilities_12_0,
            						"org.xtext.example.mydsl.MyDsl.Capability");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:938:3: (otherlv_13= ',' ( (lv_capabilities_14_0= ruleCapability ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==16) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMyDsl.g:939:4: otherlv_13= ',' ( (lv_capabilities_14_0= ruleCapability ) )
            	    {
            	    otherlv_13=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_13, grammarAccess.getRobotAccess().getCommaKeyword_13_0());
            	    			
            	    // InternalMyDsl.g:943:4: ( (lv_capabilities_14_0= ruleCapability ) )
            	    // InternalMyDsl.g:944:5: (lv_capabilities_14_0= ruleCapability )
            	    {
            	    // InternalMyDsl.g:944:5: (lv_capabilities_14_0= ruleCapability )
            	    // InternalMyDsl.g:945:6: lv_capabilities_14_0= ruleCapability
            	    {

            	    						newCompositeNode(grammarAccess.getRobotAccess().getCapabilitiesCapabilityParserRuleCall_13_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_capabilities_14_0=ruleCapability();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRobotRule());
            	    						}
            	    						add(
            	    							current,
            	    							"capabilities",
            	    							lv_capabilities_14_0,
            	    							"org.xtext.example.mydsl.MyDsl.Capability");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_15=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getRobotAccess().getRightParenthesisKeyword_14());
            		

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
    // $ANTLR end "ruleRobot"


    // $ANTLR start "entryRuleCapability"
    // InternalMyDsl.g:971:1: entryRuleCapability returns [EObject current=null] : iv_ruleCapability= ruleCapability EOF ;
    public final EObject entryRuleCapability() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapability = null;


        try {
            // InternalMyDsl.g:971:51: (iv_ruleCapability= ruleCapability EOF )
            // InternalMyDsl.g:972:2: iv_ruleCapability= ruleCapability EOF
            {
             newCompositeNode(grammarAccess.getCapabilityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCapability=ruleCapability();

            state._fsp--;

             current =iv_ruleCapability; 
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
    // $ANTLR end "entryRuleCapability"


    // $ANTLR start "ruleCapability"
    // InternalMyDsl.g:978:1: ruleCapability returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= '-required' otherlv_2= 'time:' ( (lv_time_3_0= ruleEDouble ) ) otherlv_4= ',' otherlv_5= 'success' otherlv_6= 'rate:' ( (lv_success_7_0= ruleEDouble ) ) otherlv_8= '%' ) ;
    public final EObject ruleCapability() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_time_3_0 = null;

        AntlrDatatypeRuleToken lv_success_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:984:2: ( ( ( ( ruleEString ) ) otherlv_1= '-required' otherlv_2= 'time:' ( (lv_time_3_0= ruleEDouble ) ) otherlv_4= ',' otherlv_5= 'success' otherlv_6= 'rate:' ( (lv_success_7_0= ruleEDouble ) ) otherlv_8= '%' ) )
            // InternalMyDsl.g:985:2: ( ( ( ruleEString ) ) otherlv_1= '-required' otherlv_2= 'time:' ( (lv_time_3_0= ruleEDouble ) ) otherlv_4= ',' otherlv_5= 'success' otherlv_6= 'rate:' ( (lv_success_7_0= ruleEDouble ) ) otherlv_8= '%' )
            {
            // InternalMyDsl.g:985:2: ( ( ( ruleEString ) ) otherlv_1= '-required' otherlv_2= 'time:' ( (lv_time_3_0= ruleEDouble ) ) otherlv_4= ',' otherlv_5= 'success' otherlv_6= 'rate:' ( (lv_success_7_0= ruleEDouble ) ) otherlv_8= '%' )
            // InternalMyDsl.g:986:3: ( ( ruleEString ) ) otherlv_1= '-required' otherlv_2= 'time:' ( (lv_time_3_0= ruleEDouble ) ) otherlv_4= ',' otherlv_5= 'success' otherlv_6= 'rate:' ( (lv_success_7_0= ruleEDouble ) ) otherlv_8= '%'
            {
            // InternalMyDsl.g:986:3: ( ( ruleEString ) )
            // InternalMyDsl.g:987:4: ( ruleEString )
            {
            // InternalMyDsl.g:987:4: ( ruleEString )
            // InternalMyDsl.g:988:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCapabilityRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCapabilityAccess().getAtAtomicTaskCrossReference_0_0());
            				
            pushFollow(FOLLOW_39);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,45,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getCapabilityAccess().getRequiredKeyword_1());
            		
            otherlv_2=(Token)match(input,46,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getCapabilityAccess().getTimeKeyword_2());
            		
            // InternalMyDsl.g:1010:3: ( (lv_time_3_0= ruleEDouble ) )
            // InternalMyDsl.g:1011:4: (lv_time_3_0= ruleEDouble )
            {
            // InternalMyDsl.g:1011:4: (lv_time_3_0= ruleEDouble )
            // InternalMyDsl.g:1012:5: lv_time_3_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getCapabilityAccess().getTimeEDoubleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_41);
            lv_time_3_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCapabilityRule());
            					}
            					set(
            						current,
            						"time",
            						lv_time_3_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_42); 

            			newLeafNode(otherlv_4, grammarAccess.getCapabilityAccess().getCommaKeyword_4());
            		
            otherlv_5=(Token)match(input,47,FOLLOW_43); 

            			newLeafNode(otherlv_5, grammarAccess.getCapabilityAccess().getSuccessKeyword_5());
            		
            otherlv_6=(Token)match(input,48,FOLLOW_14); 

            			newLeafNode(otherlv_6, grammarAccess.getCapabilityAccess().getRateKeyword_6());
            		
            // InternalMyDsl.g:1041:3: ( (lv_success_7_0= ruleEDouble ) )
            // InternalMyDsl.g:1042:4: (lv_success_7_0= ruleEDouble )
            {
            // InternalMyDsl.g:1042:4: (lv_success_7_0= ruleEDouble )
            // InternalMyDsl.g:1043:5: lv_success_7_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getCapabilityAccess().getSuccessEDoubleParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_44);
            lv_success_7_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCapabilityRule());
            					}
            					set(
            						current,
            						"success",
            						lv_success_7_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,49,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getCapabilityAccess().getPercentSignKeyword_8());
            		

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
    // $ANTLR end "ruleCapability"


    // $ANTLR start "entryRuleMission"
    // InternalMyDsl.g:1068:1: entryRuleMission returns [EObject current=null] : iv_ruleMission= ruleMission EOF ;
    public final EObject entryRuleMission() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMission = null;


        try {
            // InternalMyDsl.g:1068:48: (iv_ruleMission= ruleMission EOF )
            // InternalMyDsl.g:1069:2: iv_ruleMission= ruleMission EOF
            {
             newCompositeNode(grammarAccess.getMissionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMission=ruleMission();

            state._fsp--;

             current =iv_ruleMission; 
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
    // $ANTLR end "entryRuleMission"


    // $ANTLR start "ruleMission"
    // InternalMyDsl.g:1075:1: ruleMission returns [EObject current=null] : ( ( (lv_missionTask_0_0= ruleMissionTask ) ) (otherlv_1= ',' ( (lv_missionTask_2_0= ruleMissionTask ) ) )* otherlv_3= 'objectives:' ( (lv_obj_4_0= ruleObjective ) ) (otherlv_5= ',' ( (lv_obj_6_0= ruleObjective ) ) )* (otherlv_7= 'constraints:' ( (lv_constraints_8_0= ruleConstraints ) ) (otherlv_9= ',' ( (lv_constraints_10_0= ruleConstraints ) ) )* )? (otherlv_11= 'parameters:' (otherlv_12= 'time:' ( (lv_time_13_0= ruleEInt ) ) )? (otherlv_14= 'numAllocation:' ( (lv_numAlloc_15_0= ruleEInt ) ) )? (otherlv_16= 'population:' ( (lv_population_17_0= ruleEInt ) ) )? (otherlv_18= 'evaluation:' ( (lv_evaluations_19_0= ruleEInt ) ) )? )? ) ;
    public final EObject ruleMission() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_missionTask_0_0 = null;

        EObject lv_missionTask_2_0 = null;

        Enumerator lv_obj_4_0 = null;

        Enumerator lv_obj_6_0 = null;

        EObject lv_constraints_8_0 = null;

        EObject lv_constraints_10_0 = null;

        AntlrDatatypeRuleToken lv_time_13_0 = null;

        AntlrDatatypeRuleToken lv_numAlloc_15_0 = null;

        AntlrDatatypeRuleToken lv_population_17_0 = null;

        AntlrDatatypeRuleToken lv_evaluations_19_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1081:2: ( ( ( (lv_missionTask_0_0= ruleMissionTask ) ) (otherlv_1= ',' ( (lv_missionTask_2_0= ruleMissionTask ) ) )* otherlv_3= 'objectives:' ( (lv_obj_4_0= ruleObjective ) ) (otherlv_5= ',' ( (lv_obj_6_0= ruleObjective ) ) )* (otherlv_7= 'constraints:' ( (lv_constraints_8_0= ruleConstraints ) ) (otherlv_9= ',' ( (lv_constraints_10_0= ruleConstraints ) ) )* )? (otherlv_11= 'parameters:' (otherlv_12= 'time:' ( (lv_time_13_0= ruleEInt ) ) )? (otherlv_14= 'numAllocation:' ( (lv_numAlloc_15_0= ruleEInt ) ) )? (otherlv_16= 'population:' ( (lv_population_17_0= ruleEInt ) ) )? (otherlv_18= 'evaluation:' ( (lv_evaluations_19_0= ruleEInt ) ) )? )? ) )
            // InternalMyDsl.g:1082:2: ( ( (lv_missionTask_0_0= ruleMissionTask ) ) (otherlv_1= ',' ( (lv_missionTask_2_0= ruleMissionTask ) ) )* otherlv_3= 'objectives:' ( (lv_obj_4_0= ruleObjective ) ) (otherlv_5= ',' ( (lv_obj_6_0= ruleObjective ) ) )* (otherlv_7= 'constraints:' ( (lv_constraints_8_0= ruleConstraints ) ) (otherlv_9= ',' ( (lv_constraints_10_0= ruleConstraints ) ) )* )? (otherlv_11= 'parameters:' (otherlv_12= 'time:' ( (lv_time_13_0= ruleEInt ) ) )? (otherlv_14= 'numAllocation:' ( (lv_numAlloc_15_0= ruleEInt ) ) )? (otherlv_16= 'population:' ( (lv_population_17_0= ruleEInt ) ) )? (otherlv_18= 'evaluation:' ( (lv_evaluations_19_0= ruleEInt ) ) )? )? )
            {
            // InternalMyDsl.g:1082:2: ( ( (lv_missionTask_0_0= ruleMissionTask ) ) (otherlv_1= ',' ( (lv_missionTask_2_0= ruleMissionTask ) ) )* otherlv_3= 'objectives:' ( (lv_obj_4_0= ruleObjective ) ) (otherlv_5= ',' ( (lv_obj_6_0= ruleObjective ) ) )* (otherlv_7= 'constraints:' ( (lv_constraints_8_0= ruleConstraints ) ) (otherlv_9= ',' ( (lv_constraints_10_0= ruleConstraints ) ) )* )? (otherlv_11= 'parameters:' (otherlv_12= 'time:' ( (lv_time_13_0= ruleEInt ) ) )? (otherlv_14= 'numAllocation:' ( (lv_numAlloc_15_0= ruleEInt ) ) )? (otherlv_16= 'population:' ( (lv_population_17_0= ruleEInt ) ) )? (otherlv_18= 'evaluation:' ( (lv_evaluations_19_0= ruleEInt ) ) )? )? )
            // InternalMyDsl.g:1083:3: ( (lv_missionTask_0_0= ruleMissionTask ) ) (otherlv_1= ',' ( (lv_missionTask_2_0= ruleMissionTask ) ) )* otherlv_3= 'objectives:' ( (lv_obj_4_0= ruleObjective ) ) (otherlv_5= ',' ( (lv_obj_6_0= ruleObjective ) ) )* (otherlv_7= 'constraints:' ( (lv_constraints_8_0= ruleConstraints ) ) (otherlv_9= ',' ( (lv_constraints_10_0= ruleConstraints ) ) )* )? (otherlv_11= 'parameters:' (otherlv_12= 'time:' ( (lv_time_13_0= ruleEInt ) ) )? (otherlv_14= 'numAllocation:' ( (lv_numAlloc_15_0= ruleEInt ) ) )? (otherlv_16= 'population:' ( (lv_population_17_0= ruleEInt ) ) )? (otherlv_18= 'evaluation:' ( (lv_evaluations_19_0= ruleEInt ) ) )? )?
            {
            // InternalMyDsl.g:1083:3: ( (lv_missionTask_0_0= ruleMissionTask ) )
            // InternalMyDsl.g:1084:4: (lv_missionTask_0_0= ruleMissionTask )
            {
            // InternalMyDsl.g:1084:4: (lv_missionTask_0_0= ruleMissionTask )
            // InternalMyDsl.g:1085:5: lv_missionTask_0_0= ruleMissionTask
            {

            					newCompositeNode(grammarAccess.getMissionAccess().getMissionTaskMissionTaskParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_45);
            lv_missionTask_0_0=ruleMissionTask();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMissionRule());
            					}
            					add(
            						current,
            						"missionTask",
            						lv_missionTask_0_0,
            						"org.xtext.example.mydsl.MyDsl.MissionTask");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1102:3: (otherlv_1= ',' ( (lv_missionTask_2_0= ruleMissionTask ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==16) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMyDsl.g:1103:4: otherlv_1= ',' ( (lv_missionTask_2_0= ruleMissionTask ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getMissionAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMyDsl.g:1107:4: ( (lv_missionTask_2_0= ruleMissionTask ) )
            	    // InternalMyDsl.g:1108:5: (lv_missionTask_2_0= ruleMissionTask )
            	    {
            	    // InternalMyDsl.g:1108:5: (lv_missionTask_2_0= ruleMissionTask )
            	    // InternalMyDsl.g:1109:6: lv_missionTask_2_0= ruleMissionTask
            	    {

            	    						newCompositeNode(grammarAccess.getMissionAccess().getMissionTaskMissionTaskParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_45);
            	    lv_missionTask_2_0=ruleMissionTask();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMissionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"missionTask",
            	    							lv_missionTask_2_0,
            	    							"org.xtext.example.mydsl.MyDsl.MissionTask");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_3=(Token)match(input,50,FOLLOW_46); 

            			newLeafNode(otherlv_3, grammarAccess.getMissionAccess().getObjectivesKeyword_2());
            		
            // InternalMyDsl.g:1131:3: ( (lv_obj_4_0= ruleObjective ) )
            // InternalMyDsl.g:1132:4: (lv_obj_4_0= ruleObjective )
            {
            // InternalMyDsl.g:1132:4: (lv_obj_4_0= ruleObjective )
            // InternalMyDsl.g:1133:5: lv_obj_4_0= ruleObjective
            {

            					newCompositeNode(grammarAccess.getMissionAccess().getObjObjectiveEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_47);
            lv_obj_4_0=ruleObjective();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMissionRule());
            					}
            					add(
            						current,
            						"obj",
            						lv_obj_4_0,
            						"org.xtext.example.mydsl.MyDsl.Objective");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1150:3: (otherlv_5= ',' ( (lv_obj_6_0= ruleObjective ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==16) ) {
                    int LA14_2 = input.LA(2);

                    if ( ((LA14_2>=79 && LA14_2<=81)) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // InternalMyDsl.g:1151:4: otherlv_5= ',' ( (lv_obj_6_0= ruleObjective ) )
            	    {
            	    otherlv_5=(Token)match(input,16,FOLLOW_46); 

            	    				newLeafNode(otherlv_5, grammarAccess.getMissionAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalMyDsl.g:1155:4: ( (lv_obj_6_0= ruleObjective ) )
            	    // InternalMyDsl.g:1156:5: (lv_obj_6_0= ruleObjective )
            	    {
            	    // InternalMyDsl.g:1156:5: (lv_obj_6_0= ruleObjective )
            	    // InternalMyDsl.g:1157:6: lv_obj_6_0= ruleObjective
            	    {

            	    						newCompositeNode(grammarAccess.getMissionAccess().getObjObjectiveEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_47);
            	    lv_obj_6_0=ruleObjective();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMissionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"obj",
            	    							lv_obj_6_0,
            	    							"org.xtext.example.mydsl.MyDsl.Objective");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // InternalMyDsl.g:1175:3: (otherlv_7= 'constraints:' ( (lv_constraints_8_0= ruleConstraints ) ) (otherlv_9= ',' ( (lv_constraints_10_0= ruleConstraints ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==51) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMyDsl.g:1176:4: otherlv_7= 'constraints:' ( (lv_constraints_8_0= ruleConstraints ) ) (otherlv_9= ',' ( (lv_constraints_10_0= ruleConstraints ) ) )*
                    {
                    otherlv_7=(Token)match(input,51,FOLLOW_48); 

                    				newLeafNode(otherlv_7, grammarAccess.getMissionAccess().getConstraintsKeyword_5_0());
                    			
                    // InternalMyDsl.g:1180:4: ( (lv_constraints_8_0= ruleConstraints ) )
                    // InternalMyDsl.g:1181:5: (lv_constraints_8_0= ruleConstraints )
                    {
                    // InternalMyDsl.g:1181:5: (lv_constraints_8_0= ruleConstraints )
                    // InternalMyDsl.g:1182:6: lv_constraints_8_0= ruleConstraints
                    {

                    						newCompositeNode(grammarAccess.getMissionAccess().getConstraintsConstraintsParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_49);
                    lv_constraints_8_0=ruleConstraints();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMissionRule());
                    						}
                    						add(
                    							current,
                    							"constraints",
                    							lv_constraints_8_0,
                    							"org.xtext.example.mydsl.MyDsl.Constraints");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:1199:4: (otherlv_9= ',' ( (lv_constraints_10_0= ruleConstraints ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==16) ) {
                            int LA15_2 = input.LA(2);

                            if ( (LA15_2==EOF||LA15_2==16||LA15_2==19||LA15_2==29||LA15_2==52||LA15_2==56||(LA15_2>=58 && LA15_2<=59)||LA15_2==63||LA15_2==66||LA15_2==68||LA15_2==71) ) {
                                alt15=1;
                            }


                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalMyDsl.g:1200:5: otherlv_9= ',' ( (lv_constraints_10_0= ruleConstraints ) )
                    	    {
                    	    otherlv_9=(Token)match(input,16,FOLLOW_48); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getMissionAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalMyDsl.g:1204:5: ( (lv_constraints_10_0= ruleConstraints ) )
                    	    // InternalMyDsl.g:1205:6: (lv_constraints_10_0= ruleConstraints )
                    	    {
                    	    // InternalMyDsl.g:1205:6: (lv_constraints_10_0= ruleConstraints )
                    	    // InternalMyDsl.g:1206:7: lv_constraints_10_0= ruleConstraints
                    	    {

                    	    							newCompositeNode(grammarAccess.getMissionAccess().getConstraintsConstraintsParserRuleCall_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_49);
                    	    lv_constraints_10_0=ruleConstraints();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMissionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"constraints",
                    	    								lv_constraints_10_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Constraints");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMyDsl.g:1225:3: (otherlv_11= 'parameters:' (otherlv_12= 'time:' ( (lv_time_13_0= ruleEInt ) ) )? (otherlv_14= 'numAllocation:' ( (lv_numAlloc_15_0= ruleEInt ) ) )? (otherlv_16= 'population:' ( (lv_population_17_0= ruleEInt ) ) )? (otherlv_18= 'evaluation:' ( (lv_evaluations_19_0= ruleEInt ) ) )? )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==52) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:1226:4: otherlv_11= 'parameters:' (otherlv_12= 'time:' ( (lv_time_13_0= ruleEInt ) ) )? (otherlv_14= 'numAllocation:' ( (lv_numAlloc_15_0= ruleEInt ) ) )? (otherlv_16= 'population:' ( (lv_population_17_0= ruleEInt ) ) )? (otherlv_18= 'evaluation:' ( (lv_evaluations_19_0= ruleEInt ) ) )?
                    {
                    otherlv_11=(Token)match(input,52,FOLLOW_50); 

                    				newLeafNode(otherlv_11, grammarAccess.getMissionAccess().getParametersKeyword_6_0());
                    			
                    // InternalMyDsl.g:1230:4: (otherlv_12= 'time:' ( (lv_time_13_0= ruleEInt ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==46) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalMyDsl.g:1231:5: otherlv_12= 'time:' ( (lv_time_13_0= ruleEInt ) )
                            {
                            otherlv_12=(Token)match(input,46,FOLLOW_21); 

                            					newLeafNode(otherlv_12, grammarAccess.getMissionAccess().getTimeKeyword_6_1_0());
                            				
                            // InternalMyDsl.g:1235:5: ( (lv_time_13_0= ruleEInt ) )
                            // InternalMyDsl.g:1236:6: (lv_time_13_0= ruleEInt )
                            {
                            // InternalMyDsl.g:1236:6: (lv_time_13_0= ruleEInt )
                            // InternalMyDsl.g:1237:7: lv_time_13_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getMissionAccess().getTimeEIntParserRuleCall_6_1_1_0());
                            						
                            pushFollow(FOLLOW_51);
                            lv_time_13_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getMissionRule());
                            							}
                            							set(
                            								current,
                            								"time",
                            								lv_time_13_0,
                            								"org.xtext.example.mydsl.MyDsl.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalMyDsl.g:1255:4: (otherlv_14= 'numAllocation:' ( (lv_numAlloc_15_0= ruleEInt ) ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==53) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalMyDsl.g:1256:5: otherlv_14= 'numAllocation:' ( (lv_numAlloc_15_0= ruleEInt ) )
                            {
                            otherlv_14=(Token)match(input,53,FOLLOW_21); 

                            					newLeafNode(otherlv_14, grammarAccess.getMissionAccess().getNumAllocationKeyword_6_2_0());
                            				
                            // InternalMyDsl.g:1260:5: ( (lv_numAlloc_15_0= ruleEInt ) )
                            // InternalMyDsl.g:1261:6: (lv_numAlloc_15_0= ruleEInt )
                            {
                            // InternalMyDsl.g:1261:6: (lv_numAlloc_15_0= ruleEInt )
                            // InternalMyDsl.g:1262:7: lv_numAlloc_15_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getMissionAccess().getNumAllocEIntParserRuleCall_6_2_1_0());
                            						
                            pushFollow(FOLLOW_52);
                            lv_numAlloc_15_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getMissionRule());
                            							}
                            							set(
                            								current,
                            								"numAlloc",
                            								lv_numAlloc_15_0,
                            								"org.xtext.example.mydsl.MyDsl.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalMyDsl.g:1280:4: (otherlv_16= 'population:' ( (lv_population_17_0= ruleEInt ) ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==54) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalMyDsl.g:1281:5: otherlv_16= 'population:' ( (lv_population_17_0= ruleEInt ) )
                            {
                            otherlv_16=(Token)match(input,54,FOLLOW_21); 

                            					newLeafNode(otherlv_16, grammarAccess.getMissionAccess().getPopulationKeyword_6_3_0());
                            				
                            // InternalMyDsl.g:1285:5: ( (lv_population_17_0= ruleEInt ) )
                            // InternalMyDsl.g:1286:6: (lv_population_17_0= ruleEInt )
                            {
                            // InternalMyDsl.g:1286:6: (lv_population_17_0= ruleEInt )
                            // InternalMyDsl.g:1287:7: lv_population_17_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getMissionAccess().getPopulationEIntParserRuleCall_6_3_1_0());
                            						
                            pushFollow(FOLLOW_53);
                            lv_population_17_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getMissionRule());
                            							}
                            							set(
                            								current,
                            								"population",
                            								lv_population_17_0,
                            								"org.xtext.example.mydsl.MyDsl.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalMyDsl.g:1305:4: (otherlv_18= 'evaluation:' ( (lv_evaluations_19_0= ruleEInt ) ) )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==55) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalMyDsl.g:1306:5: otherlv_18= 'evaluation:' ( (lv_evaluations_19_0= ruleEInt ) )
                            {
                            otherlv_18=(Token)match(input,55,FOLLOW_21); 

                            					newLeafNode(otherlv_18, grammarAccess.getMissionAccess().getEvaluationKeyword_6_4_0());
                            				
                            // InternalMyDsl.g:1310:5: ( (lv_evaluations_19_0= ruleEInt ) )
                            // InternalMyDsl.g:1311:6: (lv_evaluations_19_0= ruleEInt )
                            {
                            // InternalMyDsl.g:1311:6: (lv_evaluations_19_0= ruleEInt )
                            // InternalMyDsl.g:1312:7: lv_evaluations_19_0= ruleEInt
                            {

                            							newCompositeNode(grammarAccess.getMissionAccess().getEvaluationsEIntParserRuleCall_6_4_1_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_evaluations_19_0=ruleEInt();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getMissionRule());
                            							}
                            							set(
                            								current,
                            								"evaluations",
                            								lv_evaluations_19_0,
                            								"org.xtext.example.mydsl.MyDsl.EInt");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleMission"


    // $ANTLR start "entryRuleMissionTask"
    // InternalMyDsl.g:1335:1: entryRuleMissionTask returns [EObject current=null] : iv_ruleMissionTask= ruleMissionTask EOF ;
    public final EObject entryRuleMissionTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMissionTask = null;


        try {
            // InternalMyDsl.g:1335:52: (iv_ruleMissionTask= ruleMissionTask EOF )
            // InternalMyDsl.g:1336:2: iv_ruleMissionTask= ruleMissionTask EOF
            {
             newCompositeNode(grammarAccess.getMissionTaskRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMissionTask=ruleMissionTask();

            state._fsp--;

             current =iv_ruleMissionTask; 
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
    // $ANTLR end "entryRuleMissionTask"


    // $ANTLR start "ruleMissionTask"
    // InternalMyDsl.g:1342:1: ruleMissionTask returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'compound' otherlv_7= 'task' ( ( ruleEString ) ) ) ) (otherlv_9= 'at' otherlv_10= 'location' ( ( ruleEString ) ) )? ) ;
    public final EObject ruleMissionTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1348:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'compound' otherlv_7= 'task' ( ( ruleEString ) ) ) ) (otherlv_9= 'at' otherlv_10= 'location' ( ( ruleEString ) ) )? ) )
            // InternalMyDsl.g:1349:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'compound' otherlv_7= 'task' ( ( ruleEString ) ) ) ) (otherlv_9= 'at' otherlv_10= 'location' ( ( ruleEString ) ) )? )
            {
            // InternalMyDsl.g:1349:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'compound' otherlv_7= 'task' ( ( ruleEString ) ) ) ) (otherlv_9= 'at' otherlv_10= 'location' ( ( ruleEString ) ) )? )
            // InternalMyDsl.g:1350:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'compound' otherlv_7= 'task' ( ( ruleEString ) ) ) ) (otherlv_9= 'at' otherlv_10= 'location' ( ( ruleEString ) ) )?
            {
            // InternalMyDsl.g:1350:3: ()
            // InternalMyDsl.g:1351:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMissionTaskAccess().getMissionTaskAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1357:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1358:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1358:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1359:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getMissionTaskAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMissionTaskRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_54); 

            			newLeafNode(otherlv_2, grammarAccess.getMissionTaskAccess().getColonKeyword_2());
            		
            // InternalMyDsl.g:1380:3: ( (otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'compound' otherlv_7= 'task' ( ( ruleEString ) ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==56) ) {
                alt22=1;
            }
            else if ( (LA22_0==58) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalMyDsl.g:1381:4: (otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:1381:4: (otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:1382:5: otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,56,FOLLOW_55); 

                    					newLeafNode(otherlv_3, grammarAccess.getMissionTaskAccess().getAtomicKeyword_3_0_0());
                    				
                    otherlv_4=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_4, grammarAccess.getMissionTaskAccess().getTaskKeyword_3_0_1());
                    				
                    // InternalMyDsl.g:1390:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:1391:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:1391:6: ( ruleEString )
                    // InternalMyDsl.g:1392:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getMissionTaskRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getMissionTaskAccess().getAtAtomicTaskCrossReference_3_0_2_0());
                    						
                    pushFollow(FOLLOW_56);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1408:4: (otherlv_6= 'compound' otherlv_7= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:1408:4: (otherlv_6= 'compound' otherlv_7= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:1409:5: otherlv_6= 'compound' otherlv_7= 'task' ( ( ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,58,FOLLOW_55); 

                    					newLeafNode(otherlv_6, grammarAccess.getMissionTaskAccess().getCompoundKeyword_3_1_0());
                    				
                    otherlv_7=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_7, grammarAccess.getMissionTaskAccess().getTaskKeyword_3_1_1());
                    				
                    // InternalMyDsl.g:1417:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:1418:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:1418:6: ( ruleEString )
                    // InternalMyDsl.g:1419:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getMissionTaskRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getMissionTaskAccess().getCtCompoundTaskCrossReference_3_1_2_0());
                    						
                    pushFollow(FOLLOW_56);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1435:3: (otherlv_9= 'at' otherlv_10= 'location' ( ( ruleEString ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:1436:4: otherlv_9= 'at' otherlv_10= 'location' ( ( ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,31,FOLLOW_25); 

                    				newLeafNode(otherlv_9, grammarAccess.getMissionTaskAccess().getAtKeyword_4_0());
                    			
                    otherlv_10=(Token)match(input,32,FOLLOW_8); 

                    				newLeafNode(otherlv_10, grammarAccess.getMissionTaskAccess().getLocationKeyword_4_1());
                    			
                    // InternalMyDsl.g:1444:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1445:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1445:5: ( ruleEString )
                    // InternalMyDsl.g:1446:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMissionTaskRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getMissionTaskAccess().getLocLocationCrossReference_4_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleEString();

                    state._fsp--;


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
    // $ANTLR end "ruleMissionTask"


    // $ANTLR start "entryRuleConstraints"
    // InternalMyDsl.g:1465:1: entryRuleConstraints returns [EObject current=null] : iv_ruleConstraints= ruleConstraints EOF ;
    public final EObject entryRuleConstraints() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraints = null;


        try {
            // InternalMyDsl.g:1465:52: (iv_ruleConstraints= ruleConstraints EOF )
            // InternalMyDsl.g:1466:2: iv_ruleConstraints= ruleConstraints EOF
            {
             newCompositeNode(grammarAccess.getConstraintsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraints=ruleConstraints();

            state._fsp--;

             current =iv_ruleConstraints; 
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
    // $ANTLR end "entryRuleConstraints"


    // $ANTLR start "ruleConstraints"
    // InternalMyDsl.g:1472:1: ruleConstraints returns [EObject current=null] : (this_RateSucc_0= ruleRateSucc | this_SpaceXYRobot_1= ruleSpaceXYRobot | this_TaskTime_2= ruleTaskTime | this_AllocateT_3= ruleAllocateT | this_Closest_4= ruleClosest | this_MaxTasks_5= ruleMaxTasks ) ;
    public final EObject ruleConstraints() throws RecognitionException {
        EObject current = null;

        EObject this_RateSucc_0 = null;

        EObject this_SpaceXYRobot_1 = null;

        EObject this_TaskTime_2 = null;

        EObject this_AllocateT_3 = null;

        EObject this_Closest_4 = null;

        EObject this_MaxTasks_5 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1478:2: ( (this_RateSucc_0= ruleRateSucc | this_SpaceXYRobot_1= ruleSpaceXYRobot | this_TaskTime_2= ruleTaskTime | this_AllocateT_3= ruleAllocateT | this_Closest_4= ruleClosest | this_MaxTasks_5= ruleMaxTasks ) )
            // InternalMyDsl.g:1479:2: (this_RateSucc_0= ruleRateSucc | this_SpaceXYRobot_1= ruleSpaceXYRobot | this_TaskTime_2= ruleTaskTime | this_AllocateT_3= ruleAllocateT | this_Closest_4= ruleClosest | this_MaxTasks_5= ruleMaxTasks )
            {
            // InternalMyDsl.g:1479:2: (this_RateSucc_0= ruleRateSucc | this_SpaceXYRobot_1= ruleSpaceXYRobot | this_TaskTime_2= ruleTaskTime | this_AllocateT_3= ruleAllocateT | this_Closest_4= ruleClosest | this_MaxTasks_5= ruleMaxTasks )
            int alt24=6;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalMyDsl.g:1480:3: this_RateSucc_0= ruleRateSucc
                    {

                    			newCompositeNode(grammarAccess.getConstraintsAccess().getRateSuccParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RateSucc_0=ruleRateSucc();

                    state._fsp--;


                    			current = this_RateSucc_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1489:3: this_SpaceXYRobot_1= ruleSpaceXYRobot
                    {

                    			newCompositeNode(grammarAccess.getConstraintsAccess().getSpaceXYRobotParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpaceXYRobot_1=ruleSpaceXYRobot();

                    state._fsp--;


                    			current = this_SpaceXYRobot_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1498:3: this_TaskTime_2= ruleTaskTime
                    {

                    			newCompositeNode(grammarAccess.getConstraintsAccess().getTaskTimeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_TaskTime_2=ruleTaskTime();

                    state._fsp--;


                    			current = this_TaskTime_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1507:3: this_AllocateT_3= ruleAllocateT
                    {

                    			newCompositeNode(grammarAccess.getConstraintsAccess().getAllocateTParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AllocateT_3=ruleAllocateT();

                    state._fsp--;


                    			current = this_AllocateT_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:1516:3: this_Closest_4= ruleClosest
                    {

                    			newCompositeNode(grammarAccess.getConstraintsAccess().getClosestParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Closest_4=ruleClosest();

                    state._fsp--;


                    			current = this_Closest_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:1525:3: this_MaxTasks_5= ruleMaxTasks
                    {

                    			newCompositeNode(grammarAccess.getConstraintsAccess().getMaxTasksParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_MaxTasks_5=ruleMaxTasks();

                    state._fsp--;


                    			current = this_MaxTasks_5;
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
    // $ANTLR end "ruleConstraints"


    // $ANTLR start "entryRuleRateSucc"
    // InternalMyDsl.g:1537:1: entryRuleRateSucc returns [EObject current=null] : iv_ruleRateSucc= ruleRateSucc EOF ;
    public final EObject entryRuleRateSucc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRateSucc = null;


        try {
            // InternalMyDsl.g:1537:49: (iv_ruleRateSucc= ruleRateSucc EOF )
            // InternalMyDsl.g:1538:2: iv_ruleRateSucc= ruleRateSucc EOF
            {
             newCompositeNode(grammarAccess.getRateSuccRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRateSucc=ruleRateSucc();

            state._fsp--;

             current =iv_ruleRateSucc; 
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
    // $ANTLR end "entryRuleRateSucc"


    // $ANTLR start "ruleRateSucc"
    // InternalMyDsl.g:1544:1: ruleRateSucc returns [EObject current=null] : ( () (otherlv_1= 'rate' otherlv_2= 'of' otherlv_3= 'success' otherlv_4= 'greater' otherlv_5= 'than' ( (lv_rateSucc_6_0= ruleEDouble ) ) )? ) ;
    public final EObject ruleRateSucc() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_rateSucc_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1550:2: ( ( () (otherlv_1= 'rate' otherlv_2= 'of' otherlv_3= 'success' otherlv_4= 'greater' otherlv_5= 'than' ( (lv_rateSucc_6_0= ruleEDouble ) ) )? ) )
            // InternalMyDsl.g:1551:2: ( () (otherlv_1= 'rate' otherlv_2= 'of' otherlv_3= 'success' otherlv_4= 'greater' otherlv_5= 'than' ( (lv_rateSucc_6_0= ruleEDouble ) ) )? )
            {
            // InternalMyDsl.g:1551:2: ( () (otherlv_1= 'rate' otherlv_2= 'of' otherlv_3= 'success' otherlv_4= 'greater' otherlv_5= 'than' ( (lv_rateSucc_6_0= ruleEDouble ) ) )? )
            // InternalMyDsl.g:1552:3: () (otherlv_1= 'rate' otherlv_2= 'of' otherlv_3= 'success' otherlv_4= 'greater' otherlv_5= 'than' ( (lv_rateSucc_6_0= ruleEDouble ) ) )?
            {
            // InternalMyDsl.g:1552:3: ()
            // InternalMyDsl.g:1553:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRateSuccAccess().getRateSuccAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1559:3: (otherlv_1= 'rate' otherlv_2= 'of' otherlv_3= 'success' otherlv_4= 'greater' otherlv_5= 'than' ( (lv_rateSucc_6_0= ruleEDouble ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==59) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMyDsl.g:1560:4: otherlv_1= 'rate' otherlv_2= 'of' otherlv_3= 'success' otherlv_4= 'greater' otherlv_5= 'than' ( (lv_rateSucc_6_0= ruleEDouble ) )
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_57); 

                    				newLeafNode(otherlv_1, grammarAccess.getRateSuccAccess().getRateKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,60,FOLLOW_42); 

                    				newLeafNode(otherlv_2, grammarAccess.getRateSuccAccess().getOfKeyword_1_1());
                    			
                    otherlv_3=(Token)match(input,47,FOLLOW_58); 

                    				newLeafNode(otherlv_3, grammarAccess.getRateSuccAccess().getSuccessKeyword_1_2());
                    			
                    otherlv_4=(Token)match(input,61,FOLLOW_59); 

                    				newLeafNode(otherlv_4, grammarAccess.getRateSuccAccess().getGreaterKeyword_1_3());
                    			
                    otherlv_5=(Token)match(input,62,FOLLOW_14); 

                    				newLeafNode(otherlv_5, grammarAccess.getRateSuccAccess().getThanKeyword_1_4());
                    			
                    // InternalMyDsl.g:1580:4: ( (lv_rateSucc_6_0= ruleEDouble ) )
                    // InternalMyDsl.g:1581:5: (lv_rateSucc_6_0= ruleEDouble )
                    {
                    // InternalMyDsl.g:1581:5: (lv_rateSucc_6_0= ruleEDouble )
                    // InternalMyDsl.g:1582:6: lv_rateSucc_6_0= ruleEDouble
                    {

                    						newCompositeNode(grammarAccess.getRateSuccAccess().getRateSuccEDoubleParserRuleCall_1_5_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_rateSucc_6_0=ruleEDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRateSuccRule());
                    						}
                    						set(
                    							current,
                    							"rateSucc",
                    							lv_rateSucc_6_0,
                    							"org.xtext.example.mydsl.MyDsl.EDouble");
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
    // $ANTLR end "ruleRateSucc"


    // $ANTLR start "entryRuleSpaceXYRobot"
    // InternalMyDsl.g:1604:1: entryRuleSpaceXYRobot returns [EObject current=null] : iv_ruleSpaceXYRobot= ruleSpaceXYRobot EOF ;
    public final EObject entryRuleSpaceXYRobot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpaceXYRobot = null;


        try {
            // InternalMyDsl.g:1604:53: (iv_ruleSpaceXYRobot= ruleSpaceXYRobot EOF )
            // InternalMyDsl.g:1605:2: iv_ruleSpaceXYRobot= ruleSpaceXYRobot EOF
            {
             newCompositeNode(grammarAccess.getSpaceXYRobotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpaceXYRobot=ruleSpaceXYRobot();

            state._fsp--;

             current =iv_ruleSpaceXYRobot; 
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
    // $ANTLR end "entryRuleSpaceXYRobot"


    // $ANTLR start "ruleSpaceXYRobot"
    // InternalMyDsl.g:1611:1: ruleSpaceXYRobot returns [EObject current=null] : ( ( (otherlv_0= 'robot' ( ( ruleEString ) ) ) | ( ( (lv_allrobots_2_0= 'all' ) ) otherlv_3= 'robots' ) ) otherlv_4= 'work' otherlv_5= 'in' ( (lv_coordinate_6_0= ruleXY ) ) ( (lv_lowerGreater_7_0= ruleLowerGreater ) ) otherlv_8= 'than' ( (lv_val_9_0= ruleEDouble ) ) ) ;
    public final EObject ruleSpaceXYRobot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_allrobots_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Enumerator lv_coordinate_6_0 = null;

        Enumerator lv_lowerGreater_7_0 = null;

        AntlrDatatypeRuleToken lv_val_9_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1617:2: ( ( ( (otherlv_0= 'robot' ( ( ruleEString ) ) ) | ( ( (lv_allrobots_2_0= 'all' ) ) otherlv_3= 'robots' ) ) otherlv_4= 'work' otherlv_5= 'in' ( (lv_coordinate_6_0= ruleXY ) ) ( (lv_lowerGreater_7_0= ruleLowerGreater ) ) otherlv_8= 'than' ( (lv_val_9_0= ruleEDouble ) ) ) )
            // InternalMyDsl.g:1618:2: ( ( (otherlv_0= 'robot' ( ( ruleEString ) ) ) | ( ( (lv_allrobots_2_0= 'all' ) ) otherlv_3= 'robots' ) ) otherlv_4= 'work' otherlv_5= 'in' ( (lv_coordinate_6_0= ruleXY ) ) ( (lv_lowerGreater_7_0= ruleLowerGreater ) ) otherlv_8= 'than' ( (lv_val_9_0= ruleEDouble ) ) )
            {
            // InternalMyDsl.g:1618:2: ( ( (otherlv_0= 'robot' ( ( ruleEString ) ) ) | ( ( (lv_allrobots_2_0= 'all' ) ) otherlv_3= 'robots' ) ) otherlv_4= 'work' otherlv_5= 'in' ( (lv_coordinate_6_0= ruleXY ) ) ( (lv_lowerGreater_7_0= ruleLowerGreater ) ) otherlv_8= 'than' ( (lv_val_9_0= ruleEDouble ) ) )
            // InternalMyDsl.g:1619:3: ( (otherlv_0= 'robot' ( ( ruleEString ) ) ) | ( ( (lv_allrobots_2_0= 'all' ) ) otherlv_3= 'robots' ) ) otherlv_4= 'work' otherlv_5= 'in' ( (lv_coordinate_6_0= ruleXY ) ) ( (lv_lowerGreater_7_0= ruleLowerGreater ) ) otherlv_8= 'than' ( (lv_val_9_0= ruleEDouble ) )
            {
            // InternalMyDsl.g:1619:3: ( (otherlv_0= 'robot' ( ( ruleEString ) ) ) | ( ( (lv_allrobots_2_0= 'all' ) ) otherlv_3= 'robots' ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==29) ) {
                alt26=1;
            }
            else if ( (LA26_0==63) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalMyDsl.g:1620:4: (otherlv_0= 'robot' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:1620:4: (otherlv_0= 'robot' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:1621:5: otherlv_0= 'robot' ( ( ruleEString ) )
                    {
                    otherlv_0=(Token)match(input,29,FOLLOW_8); 

                    					newLeafNode(otherlv_0, grammarAccess.getSpaceXYRobotAccess().getRobotKeyword_0_0_0());
                    				
                    // InternalMyDsl.g:1625:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:1626:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:1626:6: ( ruleEString )
                    // InternalMyDsl.g:1627:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getSpaceXYRobotRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getSpaceXYRobotAccess().getRobotRobotCrossReference_0_0_1_0());
                    						
                    pushFollow(FOLLOW_60);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1643:4: ( ( (lv_allrobots_2_0= 'all' ) ) otherlv_3= 'robots' )
                    {
                    // InternalMyDsl.g:1643:4: ( ( (lv_allrobots_2_0= 'all' ) ) otherlv_3= 'robots' )
                    // InternalMyDsl.g:1644:5: ( (lv_allrobots_2_0= 'all' ) ) otherlv_3= 'robots'
                    {
                    // InternalMyDsl.g:1644:5: ( (lv_allrobots_2_0= 'all' ) )
                    // InternalMyDsl.g:1645:6: (lv_allrobots_2_0= 'all' )
                    {
                    // InternalMyDsl.g:1645:6: (lv_allrobots_2_0= 'all' )
                    // InternalMyDsl.g:1646:7: lv_allrobots_2_0= 'all'
                    {
                    lv_allrobots_2_0=(Token)match(input,63,FOLLOW_61); 

                    							newLeafNode(lv_allrobots_2_0, grammarAccess.getSpaceXYRobotAccess().getAllrobotsAllKeyword_0_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getSpaceXYRobotRule());
                    							}
                    							setWithLastConsumed(current, "allrobots", lv_allrobots_2_0, "all");
                    						

                    }


                    }

                    otherlv_3=(Token)match(input,28,FOLLOW_60); 

                    					newLeafNode(otherlv_3, grammarAccess.getSpaceXYRobotAccess().getRobotsKeyword_0_1_1());
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,64,FOLLOW_62); 

            			newLeafNode(otherlv_4, grammarAccess.getSpaceXYRobotAccess().getWorkKeyword_1());
            		
            otherlv_5=(Token)match(input,65,FOLLOW_63); 

            			newLeafNode(otherlv_5, grammarAccess.getSpaceXYRobotAccess().getInKeyword_2());
            		
            // InternalMyDsl.g:1672:3: ( (lv_coordinate_6_0= ruleXY ) )
            // InternalMyDsl.g:1673:4: (lv_coordinate_6_0= ruleXY )
            {
            // InternalMyDsl.g:1673:4: (lv_coordinate_6_0= ruleXY )
            // InternalMyDsl.g:1674:5: lv_coordinate_6_0= ruleXY
            {

            					newCompositeNode(grammarAccess.getSpaceXYRobotAccess().getCoordinateXYEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_64);
            lv_coordinate_6_0=ruleXY();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpaceXYRobotRule());
            					}
            					set(
            						current,
            						"coordinate",
            						lv_coordinate_6_0,
            						"org.xtext.example.mydsl.MyDsl.XY");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1691:3: ( (lv_lowerGreater_7_0= ruleLowerGreater ) )
            // InternalMyDsl.g:1692:4: (lv_lowerGreater_7_0= ruleLowerGreater )
            {
            // InternalMyDsl.g:1692:4: (lv_lowerGreater_7_0= ruleLowerGreater )
            // InternalMyDsl.g:1693:5: lv_lowerGreater_7_0= ruleLowerGreater
            {

            					newCompositeNode(grammarAccess.getSpaceXYRobotAccess().getLowerGreaterLowerGreaterEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_59);
            lv_lowerGreater_7_0=ruleLowerGreater();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpaceXYRobotRule());
            					}
            					set(
            						current,
            						"lowerGreater",
            						lv_lowerGreater_7_0,
            						"org.xtext.example.mydsl.MyDsl.LowerGreater");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,62,FOLLOW_14); 

            			newLeafNode(otherlv_8, grammarAccess.getSpaceXYRobotAccess().getThanKeyword_5());
            		
            // InternalMyDsl.g:1714:3: ( (lv_val_9_0= ruleEDouble ) )
            // InternalMyDsl.g:1715:4: (lv_val_9_0= ruleEDouble )
            {
            // InternalMyDsl.g:1715:4: (lv_val_9_0= ruleEDouble )
            // InternalMyDsl.g:1716:5: lv_val_9_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getSpaceXYRobotAccess().getValEDoubleParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_val_9_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpaceXYRobotRule());
            					}
            					set(
            						current,
            						"val",
            						lv_val_9_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleSpaceXYRobot"


    // $ANTLR start "entryRuleTaskTime"
    // InternalMyDsl.g:1737:1: entryRuleTaskTime returns [EObject current=null] : iv_ruleTaskTime= ruleTaskTime EOF ;
    public final EObject entryRuleTaskTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTaskTime = null;


        try {
            // InternalMyDsl.g:1737:49: (iv_ruleTaskTime= ruleTaskTime EOF )
            // InternalMyDsl.g:1738:2: iv_ruleTaskTime= ruleTaskTime EOF
            {
             newCompositeNode(grammarAccess.getTaskTimeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTaskTime=ruleTaskTime();

            state._fsp--;

             current =iv_ruleTaskTime; 
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
    // $ANTLR end "entryRuleTaskTime"


    // $ANTLR start "ruleTaskTime"
    // InternalMyDsl.g:1744:1: ruleTaskTime returns [EObject current=null] : ( ( (otherlv_0= 'atomic' otherlv_1= 'task' ( ( ruleEString ) ) ) | (otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'mission' otherlv_7= 'task' ( ( ruleEString ) ) ) ) otherlv_9= 'with' ( (lv_startEnd_10_0= ruleStartEnd ) ) otherlv_11= 'time' ( (lv_time_12_0= ruleEDouble ) ) ) ;
    public final EObject ruleTaskTime() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Enumerator lv_startEnd_10_0 = null;

        AntlrDatatypeRuleToken lv_time_12_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1750:2: ( ( ( (otherlv_0= 'atomic' otherlv_1= 'task' ( ( ruleEString ) ) ) | (otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'mission' otherlv_7= 'task' ( ( ruleEString ) ) ) ) otherlv_9= 'with' ( (lv_startEnd_10_0= ruleStartEnd ) ) otherlv_11= 'time' ( (lv_time_12_0= ruleEDouble ) ) ) )
            // InternalMyDsl.g:1751:2: ( ( (otherlv_0= 'atomic' otherlv_1= 'task' ( ( ruleEString ) ) ) | (otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'mission' otherlv_7= 'task' ( ( ruleEString ) ) ) ) otherlv_9= 'with' ( (lv_startEnd_10_0= ruleStartEnd ) ) otherlv_11= 'time' ( (lv_time_12_0= ruleEDouble ) ) )
            {
            // InternalMyDsl.g:1751:2: ( ( (otherlv_0= 'atomic' otherlv_1= 'task' ( ( ruleEString ) ) ) | (otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'mission' otherlv_7= 'task' ( ( ruleEString ) ) ) ) otherlv_9= 'with' ( (lv_startEnd_10_0= ruleStartEnd ) ) otherlv_11= 'time' ( (lv_time_12_0= ruleEDouble ) ) )
            // InternalMyDsl.g:1752:3: ( (otherlv_0= 'atomic' otherlv_1= 'task' ( ( ruleEString ) ) ) | (otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'mission' otherlv_7= 'task' ( ( ruleEString ) ) ) ) otherlv_9= 'with' ( (lv_startEnd_10_0= ruleStartEnd ) ) otherlv_11= 'time' ( (lv_time_12_0= ruleEDouble ) )
            {
            // InternalMyDsl.g:1752:3: ( (otherlv_0= 'atomic' otherlv_1= 'task' ( ( ruleEString ) ) ) | (otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) ) | (otherlv_6= 'mission' otherlv_7= 'task' ( ( ruleEString ) ) ) )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt27=1;
                }
                break;
            case 58:
                {
                alt27=2;
                }
                break;
            case 66:
                {
                alt27=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalMyDsl.g:1753:4: (otherlv_0= 'atomic' otherlv_1= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:1753:4: (otherlv_0= 'atomic' otherlv_1= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:1754:5: otherlv_0= 'atomic' otherlv_1= 'task' ( ( ruleEString ) )
                    {
                    otherlv_0=(Token)match(input,56,FOLLOW_55); 

                    					newLeafNode(otherlv_0, grammarAccess.getTaskTimeAccess().getAtomicKeyword_0_0_0());
                    				
                    otherlv_1=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_1, grammarAccess.getTaskTimeAccess().getTaskKeyword_0_0_1());
                    				
                    // InternalMyDsl.g:1762:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:1763:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:1763:6: ( ruleEString )
                    // InternalMyDsl.g:1764:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTaskTimeRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getTaskTimeAccess().getAtAtomicTaskCrossReference_0_0_2_0());
                    						
                    pushFollow(FOLLOW_37);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1780:4: (otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:1780:4: (otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:1781:5: otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,58,FOLLOW_55); 

                    					newLeafNode(otherlv_3, grammarAccess.getTaskTimeAccess().getCompoundKeyword_0_1_0());
                    				
                    otherlv_4=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_4, grammarAccess.getTaskTimeAccess().getTaskKeyword_0_1_1());
                    				
                    // InternalMyDsl.g:1789:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:1790:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:1790:6: ( ruleEString )
                    // InternalMyDsl.g:1791:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTaskTimeRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getTaskTimeAccess().getCtCompoundTaskCrossReference_0_1_2_0());
                    						
                    pushFollow(FOLLOW_37);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1807:4: (otherlv_6= 'mission' otherlv_7= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:1807:4: (otherlv_6= 'mission' otherlv_7= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:1808:5: otherlv_6= 'mission' otherlv_7= 'task' ( ( ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,66,FOLLOW_55); 

                    					newLeafNode(otherlv_6, grammarAccess.getTaskTimeAccess().getMissionKeyword_0_2_0());
                    				
                    otherlv_7=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_7, grammarAccess.getTaskTimeAccess().getTaskKeyword_0_2_1());
                    				
                    // InternalMyDsl.g:1816:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:1817:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:1817:6: ( ruleEString )
                    // InternalMyDsl.g:1818:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTaskTimeRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getTaskTimeAccess().getMtMissionTaskCrossReference_0_2_2_0());
                    						
                    pushFollow(FOLLOW_37);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,43,FOLLOW_65); 

            			newLeafNode(otherlv_9, grammarAccess.getTaskTimeAccess().getWithKeyword_1());
            		
            // InternalMyDsl.g:1838:3: ( (lv_startEnd_10_0= ruleStartEnd ) )
            // InternalMyDsl.g:1839:4: (lv_startEnd_10_0= ruleStartEnd )
            {
            // InternalMyDsl.g:1839:4: (lv_startEnd_10_0= ruleStartEnd )
            // InternalMyDsl.g:1840:5: lv_startEnd_10_0= ruleStartEnd
            {

            					newCompositeNode(grammarAccess.getTaskTimeAccess().getStartEndStartEndEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_66);
            lv_startEnd_10_0=ruleStartEnd();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTaskTimeRule());
            					}
            					set(
            						current,
            						"startEnd",
            						lv_startEnd_10_0,
            						"org.xtext.example.mydsl.MyDsl.StartEnd");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,67,FOLLOW_14); 

            			newLeafNode(otherlv_11, grammarAccess.getTaskTimeAccess().getTimeKeyword_3());
            		
            // InternalMyDsl.g:1861:3: ( (lv_time_12_0= ruleEDouble ) )
            // InternalMyDsl.g:1862:4: (lv_time_12_0= ruleEDouble )
            {
            // InternalMyDsl.g:1862:4: (lv_time_12_0= ruleEDouble )
            // InternalMyDsl.g:1863:5: lv_time_12_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getTaskTimeAccess().getTimeEDoubleParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_time_12_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTaskTimeRule());
            					}
            					set(
            						current,
            						"time",
            						lv_time_12_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleTaskTime"


    // $ANTLR start "entryRuleAllocateT"
    // InternalMyDsl.g:1884:1: entryRuleAllocateT returns [EObject current=null] : iv_ruleAllocateT= ruleAllocateT EOF ;
    public final EObject entryRuleAllocateT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAllocateT = null;


        try {
            // InternalMyDsl.g:1884:50: (iv_ruleAllocateT= ruleAllocateT EOF )
            // InternalMyDsl.g:1885:2: iv_ruleAllocateT= ruleAllocateT EOF
            {
             newCompositeNode(grammarAccess.getAllocateTRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAllocateT=ruleAllocateT();

            state._fsp--;

             current =iv_ruleAllocateT; 
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
    // $ANTLR end "entryRuleAllocateT"


    // $ANTLR start "ruleAllocateT"
    // InternalMyDsl.g:1891:1: ruleAllocateT returns [EObject current=null] : (otherlv_0= 'allocate' ( (otherlv_1= 'atomic' otherlv_2= 'task' ( ( ruleEString ) ) ) | (otherlv_4= 'compound' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'mission' otherlv_8= 'task' ( ( ruleEString ) ) ) ) otherlv_10= 'to' otherlv_11= 'robot' ( ( ruleEString ) ) ) ;
    public final EObject ruleAllocateT() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1897:2: ( (otherlv_0= 'allocate' ( (otherlv_1= 'atomic' otherlv_2= 'task' ( ( ruleEString ) ) ) | (otherlv_4= 'compound' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'mission' otherlv_8= 'task' ( ( ruleEString ) ) ) ) otherlv_10= 'to' otherlv_11= 'robot' ( ( ruleEString ) ) ) )
            // InternalMyDsl.g:1898:2: (otherlv_0= 'allocate' ( (otherlv_1= 'atomic' otherlv_2= 'task' ( ( ruleEString ) ) ) | (otherlv_4= 'compound' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'mission' otherlv_8= 'task' ( ( ruleEString ) ) ) ) otherlv_10= 'to' otherlv_11= 'robot' ( ( ruleEString ) ) )
            {
            // InternalMyDsl.g:1898:2: (otherlv_0= 'allocate' ( (otherlv_1= 'atomic' otherlv_2= 'task' ( ( ruleEString ) ) ) | (otherlv_4= 'compound' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'mission' otherlv_8= 'task' ( ( ruleEString ) ) ) ) otherlv_10= 'to' otherlv_11= 'robot' ( ( ruleEString ) ) )
            // InternalMyDsl.g:1899:3: otherlv_0= 'allocate' ( (otherlv_1= 'atomic' otherlv_2= 'task' ( ( ruleEString ) ) ) | (otherlv_4= 'compound' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'mission' otherlv_8= 'task' ( ( ruleEString ) ) ) ) otherlv_10= 'to' otherlv_11= 'robot' ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_67); 

            			newLeafNode(otherlv_0, grammarAccess.getAllocateTAccess().getAllocateKeyword_0());
            		
            // InternalMyDsl.g:1903:3: ( (otherlv_1= 'atomic' otherlv_2= 'task' ( ( ruleEString ) ) ) | (otherlv_4= 'compound' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'mission' otherlv_8= 'task' ( ( ruleEString ) ) ) )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt28=1;
                }
                break;
            case 58:
                {
                alt28=2;
                }
                break;
            case 66:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalMyDsl.g:1904:4: (otherlv_1= 'atomic' otherlv_2= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:1904:4: (otherlv_1= 'atomic' otherlv_2= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:1905:5: otherlv_1= 'atomic' otherlv_2= 'task' ( ( ruleEString ) )
                    {
                    otherlv_1=(Token)match(input,56,FOLLOW_55); 

                    					newLeafNode(otherlv_1, grammarAccess.getAllocateTAccess().getAtomicKeyword_1_0_0());
                    				
                    otherlv_2=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_2, grammarAccess.getAllocateTAccess().getTaskKeyword_1_0_1());
                    				
                    // InternalMyDsl.g:1913:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:1914:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:1914:6: ( ruleEString )
                    // InternalMyDsl.g:1915:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getAllocateTRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getAllocateTAccess().getAtAtomicTaskCrossReference_1_0_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1931:4: (otherlv_4= 'compound' otherlv_5= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:1931:4: (otherlv_4= 'compound' otherlv_5= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:1932:5: otherlv_4= 'compound' otherlv_5= 'task' ( ( ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,58,FOLLOW_55); 

                    					newLeafNode(otherlv_4, grammarAccess.getAllocateTAccess().getCompoundKeyword_1_1_0());
                    				
                    otherlv_5=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_5, grammarAccess.getAllocateTAccess().getTaskKeyword_1_1_1());
                    				
                    // InternalMyDsl.g:1940:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:1941:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:1941:6: ( ruleEString )
                    // InternalMyDsl.g:1942:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getAllocateTRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getAllocateTAccess().getCtCompoundTaskCrossReference_1_1_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1958:4: (otherlv_7= 'mission' otherlv_8= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:1958:4: (otherlv_7= 'mission' otherlv_8= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:1959:5: otherlv_7= 'mission' otherlv_8= 'task' ( ( ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,66,FOLLOW_55); 

                    					newLeafNode(otherlv_7, grammarAccess.getAllocateTAccess().getMissionKeyword_1_2_0());
                    				
                    otherlv_8=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_8, grammarAccess.getAllocateTAccess().getTaskKeyword_1_2_1());
                    				
                    // InternalMyDsl.g:1967:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:1968:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:1968:6: ( ruleEString )
                    // InternalMyDsl.g:1969:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getAllocateTRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getAllocateTAccess().getMtMissionTaskCrossReference_1_2_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,26,FOLLOW_68); 

            			newLeafNode(otherlv_10, grammarAccess.getAllocateTAccess().getToKeyword_2());
            		
            otherlv_11=(Token)match(input,29,FOLLOW_8); 

            			newLeafNode(otherlv_11, grammarAccess.getAllocateTAccess().getRobotKeyword_3());
            		
            // InternalMyDsl.g:1993:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1994:4: ( ruleEString )
            {
            // InternalMyDsl.g:1994:4: ( ruleEString )
            // InternalMyDsl.g:1995:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAllocateTRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAllocateTAccess().getRobotRobotCrossReference_4_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleAllocateT"


    // $ANTLR start "entryRuleClosest"
    // InternalMyDsl.g:2013:1: entryRuleClosest returns [EObject current=null] : iv_ruleClosest= ruleClosest EOF ;
    public final EObject entryRuleClosest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosest = null;


        try {
            // InternalMyDsl.g:2013:48: (iv_ruleClosest= ruleClosest EOF )
            // InternalMyDsl.g:2014:2: iv_ruleClosest= ruleClosest EOF
            {
             newCompositeNode(grammarAccess.getClosestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClosest=ruleClosest();

            state._fsp--;

             current =iv_ruleClosest; 
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
    // $ANTLR end "entryRuleClosest"


    // $ANTLR start "ruleClosest"
    // InternalMyDsl.g:2020:1: ruleClosest returns [EObject current=null] : ( () otherlv_1= 'allocate' ( ( ( (lv_all_2_0= 'all' ) ) otherlv_3= 'tasks' ) | (otherlv_4= 'atomic' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'compound' otherlv_8= 'task' ( ( ruleEString ) ) ) | (otherlv_10= 'mission' otherlv_11= 'task' ( ( ruleEString ) ) ) ) otherlv_13= 'to' otherlv_14= 'closest' otherlv_15= 'robot' ) ;
    public final EObject ruleClosest() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_all_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2026:2: ( ( () otherlv_1= 'allocate' ( ( ( (lv_all_2_0= 'all' ) ) otherlv_3= 'tasks' ) | (otherlv_4= 'atomic' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'compound' otherlv_8= 'task' ( ( ruleEString ) ) ) | (otherlv_10= 'mission' otherlv_11= 'task' ( ( ruleEString ) ) ) ) otherlv_13= 'to' otherlv_14= 'closest' otherlv_15= 'robot' ) )
            // InternalMyDsl.g:2027:2: ( () otherlv_1= 'allocate' ( ( ( (lv_all_2_0= 'all' ) ) otherlv_3= 'tasks' ) | (otherlv_4= 'atomic' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'compound' otherlv_8= 'task' ( ( ruleEString ) ) ) | (otherlv_10= 'mission' otherlv_11= 'task' ( ( ruleEString ) ) ) ) otherlv_13= 'to' otherlv_14= 'closest' otherlv_15= 'robot' )
            {
            // InternalMyDsl.g:2027:2: ( () otherlv_1= 'allocate' ( ( ( (lv_all_2_0= 'all' ) ) otherlv_3= 'tasks' ) | (otherlv_4= 'atomic' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'compound' otherlv_8= 'task' ( ( ruleEString ) ) ) | (otherlv_10= 'mission' otherlv_11= 'task' ( ( ruleEString ) ) ) ) otherlv_13= 'to' otherlv_14= 'closest' otherlv_15= 'robot' )
            // InternalMyDsl.g:2028:3: () otherlv_1= 'allocate' ( ( ( (lv_all_2_0= 'all' ) ) otherlv_3= 'tasks' ) | (otherlv_4= 'atomic' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'compound' otherlv_8= 'task' ( ( ruleEString ) ) ) | (otherlv_10= 'mission' otherlv_11= 'task' ( ( ruleEString ) ) ) ) otherlv_13= 'to' otherlv_14= 'closest' otherlv_15= 'robot'
            {
            // InternalMyDsl.g:2028:3: ()
            // InternalMyDsl.g:2029:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClosestAccess().getClosestAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,68,FOLLOW_69); 

            			newLeafNode(otherlv_1, grammarAccess.getClosestAccess().getAllocateKeyword_1());
            		
            // InternalMyDsl.g:2039:3: ( ( ( (lv_all_2_0= 'all' ) ) otherlv_3= 'tasks' ) | (otherlv_4= 'atomic' otherlv_5= 'task' ( ( ruleEString ) ) ) | (otherlv_7= 'compound' otherlv_8= 'task' ( ( ruleEString ) ) ) | (otherlv_10= 'mission' otherlv_11= 'task' ( ( ruleEString ) ) ) )
            int alt29=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt29=1;
                }
                break;
            case 56:
                {
                alt29=2;
                }
                break;
            case 58:
                {
                alt29=3;
                }
                break;
            case 66:
                {
                alt29=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalMyDsl.g:2040:4: ( ( (lv_all_2_0= 'all' ) ) otherlv_3= 'tasks' )
                    {
                    // InternalMyDsl.g:2040:4: ( ( (lv_all_2_0= 'all' ) ) otherlv_3= 'tasks' )
                    // InternalMyDsl.g:2041:5: ( (lv_all_2_0= 'all' ) ) otherlv_3= 'tasks'
                    {
                    // InternalMyDsl.g:2041:5: ( (lv_all_2_0= 'all' ) )
                    // InternalMyDsl.g:2042:6: (lv_all_2_0= 'all' )
                    {
                    // InternalMyDsl.g:2042:6: (lv_all_2_0= 'all' )
                    // InternalMyDsl.g:2043:7: lv_all_2_0= 'all'
                    {
                    lv_all_2_0=(Token)match(input,63,FOLLOW_70); 

                    							newLeafNode(lv_all_2_0, grammarAccess.getClosestAccess().getAllAllKeyword_2_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getClosestRule());
                    							}
                    							setWithLastConsumed(current, "all", lv_all_2_0, "all");
                    						

                    }


                    }

                    otherlv_3=(Token)match(input,69,FOLLOW_19); 

                    					newLeafNode(otherlv_3, grammarAccess.getClosestAccess().getTasksKeyword_2_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2061:4: (otherlv_4= 'atomic' otherlv_5= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:2061:4: (otherlv_4= 'atomic' otherlv_5= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:2062:5: otherlv_4= 'atomic' otherlv_5= 'task' ( ( ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,56,FOLLOW_55); 

                    					newLeafNode(otherlv_4, grammarAccess.getClosestAccess().getAtomicKeyword_2_1_0());
                    				
                    otherlv_5=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_5, grammarAccess.getClosestAccess().getTaskKeyword_2_1_1());
                    				
                    // InternalMyDsl.g:2070:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:2071:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:2071:6: ( ruleEString )
                    // InternalMyDsl.g:2072:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getClosestRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getClosestAccess().getAtAtomicTaskCrossReference_2_1_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2088:4: (otherlv_7= 'compound' otherlv_8= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:2088:4: (otherlv_7= 'compound' otherlv_8= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:2089:5: otherlv_7= 'compound' otherlv_8= 'task' ( ( ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,58,FOLLOW_55); 

                    					newLeafNode(otherlv_7, grammarAccess.getClosestAccess().getCompoundKeyword_2_2_0());
                    				
                    otherlv_8=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_8, grammarAccess.getClosestAccess().getTaskKeyword_2_2_1());
                    				
                    // InternalMyDsl.g:2097:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:2098:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:2098:6: ( ruleEString )
                    // InternalMyDsl.g:2099:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getClosestRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getClosestAccess().getCtCompoundTaskCrossReference_2_2_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2115:4: (otherlv_10= 'mission' otherlv_11= 'task' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:2115:4: (otherlv_10= 'mission' otherlv_11= 'task' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:2116:5: otherlv_10= 'mission' otherlv_11= 'task' ( ( ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,66,FOLLOW_55); 

                    					newLeafNode(otherlv_10, grammarAccess.getClosestAccess().getMissionKeyword_2_3_0());
                    				
                    otherlv_11=(Token)match(input,57,FOLLOW_8); 

                    					newLeafNode(otherlv_11, grammarAccess.getClosestAccess().getTaskKeyword_2_3_1());
                    				
                    // InternalMyDsl.g:2124:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:2125:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:2125:6: ( ruleEString )
                    // InternalMyDsl.g:2126:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getClosestRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getClosestAccess().getMtMissionTaskCrossReference_2_3_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,26,FOLLOW_71); 

            			newLeafNode(otherlv_13, grammarAccess.getClosestAccess().getToKeyword_3());
            		
            otherlv_14=(Token)match(input,70,FOLLOW_68); 

            			newLeafNode(otherlv_14, grammarAccess.getClosestAccess().getClosestKeyword_4());
            		
            otherlv_15=(Token)match(input,29,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getClosestAccess().getRobotKeyword_5());
            		

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
    // $ANTLR end "ruleClosest"


    // $ANTLR start "entryRuleMaxTasks"
    // InternalMyDsl.g:2158:1: entryRuleMaxTasks returns [EObject current=null] : iv_ruleMaxTasks= ruleMaxTasks EOF ;
    public final EObject entryRuleMaxTasks() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxTasks = null;


        try {
            // InternalMyDsl.g:2158:49: (iv_ruleMaxTasks= ruleMaxTasks EOF )
            // InternalMyDsl.g:2159:2: iv_ruleMaxTasks= ruleMaxTasks EOF
            {
             newCompositeNode(grammarAccess.getMaxTasksRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxTasks=ruleMaxTasks();

            state._fsp--;

             current =iv_ruleMaxTasks; 
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
    // $ANTLR end "entryRuleMaxTasks"


    // $ANTLR start "ruleMaxTasks"
    // InternalMyDsl.g:2165:1: ruleMaxTasks returns [EObject current=null] : (otherlv_0= 'limit' otherlv_1= 'max' otherlv_2= 'number' otherlv_3= 'of' otherlv_4= 'tasks' ( ( ( (lv_all_5_0= 'per' ) ) otherlv_6= 'robot' ) | (otherlv_7= 'in' otherlv_8= 'robot' ( ( ruleEString ) ) ) ) otherlv_10= 'to' ( (lv_num_11_0= ruleEInt ) ) ) ;
    public final EObject ruleMaxTasks() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_all_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_num_11_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2171:2: ( (otherlv_0= 'limit' otherlv_1= 'max' otherlv_2= 'number' otherlv_3= 'of' otherlv_4= 'tasks' ( ( ( (lv_all_5_0= 'per' ) ) otherlv_6= 'robot' ) | (otherlv_7= 'in' otherlv_8= 'robot' ( ( ruleEString ) ) ) ) otherlv_10= 'to' ( (lv_num_11_0= ruleEInt ) ) ) )
            // InternalMyDsl.g:2172:2: (otherlv_0= 'limit' otherlv_1= 'max' otherlv_2= 'number' otherlv_3= 'of' otherlv_4= 'tasks' ( ( ( (lv_all_5_0= 'per' ) ) otherlv_6= 'robot' ) | (otherlv_7= 'in' otherlv_8= 'robot' ( ( ruleEString ) ) ) ) otherlv_10= 'to' ( (lv_num_11_0= ruleEInt ) ) )
            {
            // InternalMyDsl.g:2172:2: (otherlv_0= 'limit' otherlv_1= 'max' otherlv_2= 'number' otherlv_3= 'of' otherlv_4= 'tasks' ( ( ( (lv_all_5_0= 'per' ) ) otherlv_6= 'robot' ) | (otherlv_7= 'in' otherlv_8= 'robot' ( ( ruleEString ) ) ) ) otherlv_10= 'to' ( (lv_num_11_0= ruleEInt ) ) )
            // InternalMyDsl.g:2173:3: otherlv_0= 'limit' otherlv_1= 'max' otherlv_2= 'number' otherlv_3= 'of' otherlv_4= 'tasks' ( ( ( (lv_all_5_0= 'per' ) ) otherlv_6= 'robot' ) | (otherlv_7= 'in' otherlv_8= 'robot' ( ( ruleEString ) ) ) ) otherlv_10= 'to' ( (lv_num_11_0= ruleEInt ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_72); 

            			newLeafNode(otherlv_0, grammarAccess.getMaxTasksAccess().getLimitKeyword_0());
            		
            otherlv_1=(Token)match(input,72,FOLLOW_73); 

            			newLeafNode(otherlv_1, grammarAccess.getMaxTasksAccess().getMaxKeyword_1());
            		
            otherlv_2=(Token)match(input,73,FOLLOW_57); 

            			newLeafNode(otherlv_2, grammarAccess.getMaxTasksAccess().getNumberKeyword_2());
            		
            otherlv_3=(Token)match(input,60,FOLLOW_70); 

            			newLeafNode(otherlv_3, grammarAccess.getMaxTasksAccess().getOfKeyword_3());
            		
            otherlv_4=(Token)match(input,69,FOLLOW_74); 

            			newLeafNode(otherlv_4, grammarAccess.getMaxTasksAccess().getTasksKeyword_4());
            		
            // InternalMyDsl.g:2193:3: ( ( ( (lv_all_5_0= 'per' ) ) otherlv_6= 'robot' ) | (otherlv_7= 'in' otherlv_8= 'robot' ( ( ruleEString ) ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==74) ) {
                alt30=1;
            }
            else if ( (LA30_0==65) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalMyDsl.g:2194:4: ( ( (lv_all_5_0= 'per' ) ) otherlv_6= 'robot' )
                    {
                    // InternalMyDsl.g:2194:4: ( ( (lv_all_5_0= 'per' ) ) otherlv_6= 'robot' )
                    // InternalMyDsl.g:2195:5: ( (lv_all_5_0= 'per' ) ) otherlv_6= 'robot'
                    {
                    // InternalMyDsl.g:2195:5: ( (lv_all_5_0= 'per' ) )
                    // InternalMyDsl.g:2196:6: (lv_all_5_0= 'per' )
                    {
                    // InternalMyDsl.g:2196:6: (lv_all_5_0= 'per' )
                    // InternalMyDsl.g:2197:7: lv_all_5_0= 'per'
                    {
                    lv_all_5_0=(Token)match(input,74,FOLLOW_68); 

                    							newLeafNode(lv_all_5_0, grammarAccess.getMaxTasksAccess().getAllPerKeyword_5_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getMaxTasksRule());
                    							}
                    							setWithLastConsumed(current, "all", lv_all_5_0, "per");
                    						

                    }


                    }

                    otherlv_6=(Token)match(input,29,FOLLOW_19); 

                    					newLeafNode(otherlv_6, grammarAccess.getMaxTasksAccess().getRobotKeyword_5_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2215:4: (otherlv_7= 'in' otherlv_8= 'robot' ( ( ruleEString ) ) )
                    {
                    // InternalMyDsl.g:2215:4: (otherlv_7= 'in' otherlv_8= 'robot' ( ( ruleEString ) ) )
                    // InternalMyDsl.g:2216:5: otherlv_7= 'in' otherlv_8= 'robot' ( ( ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,65,FOLLOW_68); 

                    					newLeafNode(otherlv_7, grammarAccess.getMaxTasksAccess().getInKeyword_5_1_0());
                    				
                    otherlv_8=(Token)match(input,29,FOLLOW_8); 

                    					newLeafNode(otherlv_8, grammarAccess.getMaxTasksAccess().getRobotKeyword_5_1_1());
                    				
                    // InternalMyDsl.g:2224:5: ( ( ruleEString ) )
                    // InternalMyDsl.g:2225:6: ( ruleEString )
                    {
                    // InternalMyDsl.g:2225:6: ( ruleEString )
                    // InternalMyDsl.g:2226:7: ruleEString
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getMaxTasksRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getMaxTasksAccess().getRobotRobotCrossReference_5_1_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    ruleEString();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_10, grammarAccess.getMaxTasksAccess().getToKeyword_6());
            		
            // InternalMyDsl.g:2246:3: ( (lv_num_11_0= ruleEInt ) )
            // InternalMyDsl.g:2247:4: (lv_num_11_0= ruleEInt )
            {
            // InternalMyDsl.g:2247:4: (lv_num_11_0= ruleEInt )
            // InternalMyDsl.g:2248:5: lv_num_11_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getMaxTasksAccess().getNumEIntParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_num_11_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMaxTasksRule());
            					}
            					set(
            						current,
            						"num",
            						lv_num_11_0,
            						"org.xtext.example.mydsl.MyDsl.EInt");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleMaxTasks"


    // $ANTLR start "entryRuleEInt"
    // InternalMyDsl.g:2269:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalMyDsl.g:2269:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalMyDsl.g:2270:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
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
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalMyDsl.g:2276:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2282:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalMyDsl.g:2283:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalMyDsl.g:2283:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalMyDsl.g:2284:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalMyDsl.g:2284:3: (kw= '-' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==75) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMyDsl.g:2285:4: kw= '-'
                    {
                    kw=(Token)match(input,75,FOLLOW_75); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

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
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEString"
    // InternalMyDsl.g:2302:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMyDsl.g:2302:47: (iv_ruleEString= ruleEString EOF )
            // InternalMyDsl.g:2303:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalMyDsl.g:2309:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2315:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMyDsl.g:2316:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMyDsl.g:2316:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_STRING) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ID) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:2317:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2325:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

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
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEDouble"
    // InternalMyDsl.g:2336:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalMyDsl.g:2336:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalMyDsl.g:2337:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
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
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalMyDsl.g:2343:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2349:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalMyDsl.g:2350:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalMyDsl.g:2350:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalMyDsl.g:2351:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalMyDsl.g:2351:3: (kw= '-' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==75) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMyDsl.g:2352:4: kw= '-'
                    {
                    kw=(Token)match(input,75,FOLLOW_76); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:2358:3: (this_INT_1= RULE_INT )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_INT) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMyDsl.g:2359:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_77); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,76,FOLLOW_75); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_78); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
            		
            // InternalMyDsl.g:2379:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=77 && LA37_0<=78)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalMyDsl.g:2380:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalMyDsl.g:2380:4: (kw= 'E' | kw= 'e' )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==77) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==78) ) {
                        alt35=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalMyDsl.g:2381:5: kw= 'E'
                            {
                            kw=(Token)match(input,77,FOLLOW_21); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalMyDsl.g:2387:5: kw= 'e'
                            {
                            kw=(Token)match(input,78,FOLLOW_21); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalMyDsl.g:2393:4: (kw= '-' )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==75) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // InternalMyDsl.g:2394:5: kw= '-'
                            {
                            kw=(Token)match(input,75,FOLLOW_75); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1());
                            				

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_7);
                    			

                    				newLeafNode(this_INT_7, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2());
                    			

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
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "ruleObjective"
    // InternalMyDsl.g:2412:1: ruleObjective returns [Enumerator current=null] : ( (enumLiteral_0= 'minimiseIdle' ) | (enumLiteral_1= 'minimiseTravel' ) | (enumLiteral_2= 'maximiseSuccess' ) ) ;
    public final Enumerator ruleObjective() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2418:2: ( ( (enumLiteral_0= 'minimiseIdle' ) | (enumLiteral_1= 'minimiseTravel' ) | (enumLiteral_2= 'maximiseSuccess' ) ) )
            // InternalMyDsl.g:2419:2: ( (enumLiteral_0= 'minimiseIdle' ) | (enumLiteral_1= 'minimiseTravel' ) | (enumLiteral_2= 'maximiseSuccess' ) )
            {
            // InternalMyDsl.g:2419:2: ( (enumLiteral_0= 'minimiseIdle' ) | (enumLiteral_1= 'minimiseTravel' ) | (enumLiteral_2= 'maximiseSuccess' ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt38=1;
                }
                break;
            case 80:
                {
                alt38=2;
                }
                break;
            case 81:
                {
                alt38=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalMyDsl.g:2420:3: (enumLiteral_0= 'minimiseIdle' )
                    {
                    // InternalMyDsl.g:2420:3: (enumLiteral_0= 'minimiseIdle' )
                    // InternalMyDsl.g:2421:4: enumLiteral_0= 'minimiseIdle'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getObjectiveAccess().getMinIdleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getObjectiveAccess().getMinIdleEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2428:3: (enumLiteral_1= 'minimiseTravel' )
                    {
                    // InternalMyDsl.g:2428:3: (enumLiteral_1= 'minimiseTravel' )
                    // InternalMyDsl.g:2429:4: enumLiteral_1= 'minimiseTravel'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getObjectiveAccess().getMinTravelEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getObjectiveAccess().getMinTravelEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2436:3: (enumLiteral_2= 'maximiseSuccess' )
                    {
                    // InternalMyDsl.g:2436:3: (enumLiteral_2= 'maximiseSuccess' )
                    // InternalMyDsl.g:2437:4: enumLiteral_2= 'maximiseSuccess'
                    {
                    enumLiteral_2=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getObjectiveAccess().getMaxSuccEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getObjectiveAccess().getMaxSuccEnumLiteralDeclaration_2());
                    			

                    }


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
    // $ANTLR end "ruleObjective"


    // $ANTLR start "ruleXY"
    // InternalMyDsl.g:2447:1: ruleXY returns [Enumerator current=null] : ( (enumLiteral_0= 'x' ) | (enumLiteral_1= 'y' ) ) ;
    public final Enumerator ruleXY() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2453:2: ( ( (enumLiteral_0= 'x' ) | (enumLiteral_1= 'y' ) ) )
            // InternalMyDsl.g:2454:2: ( (enumLiteral_0= 'x' ) | (enumLiteral_1= 'y' ) )
            {
            // InternalMyDsl.g:2454:2: ( (enumLiteral_0= 'x' ) | (enumLiteral_1= 'y' ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==21) ) {
                alt39=1;
            }
            else if ( (LA39_0==22) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalMyDsl.g:2455:3: (enumLiteral_0= 'x' )
                    {
                    // InternalMyDsl.g:2455:3: (enumLiteral_0= 'x' )
                    // InternalMyDsl.g:2456:4: enumLiteral_0= 'x'
                    {
                    enumLiteral_0=(Token)match(input,21,FOLLOW_2); 

                    				current = grammarAccess.getXYAccess().getXEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getXYAccess().getXEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2463:3: (enumLiteral_1= 'y' )
                    {
                    // InternalMyDsl.g:2463:3: (enumLiteral_1= 'y' )
                    // InternalMyDsl.g:2464:4: enumLiteral_1= 'y'
                    {
                    enumLiteral_1=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getXYAccess().getYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getXYAccess().getYEnumLiteralDeclaration_1());
                    			

                    }


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
    // $ANTLR end "ruleXY"


    // $ANTLR start "ruleLowerGreater"
    // InternalMyDsl.g:2474:1: ruleLowerGreater returns [Enumerator current=null] : ( (enumLiteral_0= 'lower' ) | (enumLiteral_1= 'greater' ) ) ;
    public final Enumerator ruleLowerGreater() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2480:2: ( ( (enumLiteral_0= 'lower' ) | (enumLiteral_1= 'greater' ) ) )
            // InternalMyDsl.g:2481:2: ( (enumLiteral_0= 'lower' ) | (enumLiteral_1= 'greater' ) )
            {
            // InternalMyDsl.g:2481:2: ( (enumLiteral_0= 'lower' ) | (enumLiteral_1= 'greater' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==82) ) {
                alt40=1;
            }
            else if ( (LA40_0==61) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalMyDsl.g:2482:3: (enumLiteral_0= 'lower' )
                    {
                    // InternalMyDsl.g:2482:3: (enumLiteral_0= 'lower' )
                    // InternalMyDsl.g:2483:4: enumLiteral_0= 'lower'
                    {
                    enumLiteral_0=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getLowerGreaterAccess().getLowerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLowerGreaterAccess().getLowerEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2490:3: (enumLiteral_1= 'greater' )
                    {
                    // InternalMyDsl.g:2490:3: (enumLiteral_1= 'greater' )
                    // InternalMyDsl.g:2491:4: enumLiteral_1= 'greater'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getLowerGreaterAccess().getGreaterEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLowerGreaterAccess().getGreaterEnumLiteralDeclaration_1());
                    			

                    }


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
    // $ANTLR end "ruleLowerGreater"


    // $ANTLR start "ruleStartEnd"
    // InternalMyDsl.g:2501:1: ruleStartEnd returns [Enumerator current=null] : ( (enumLiteral_0= 'end' ) | (enumLiteral_1= 'start' ) ) ;
    public final Enumerator ruleStartEnd() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2507:2: ( ( (enumLiteral_0= 'end' ) | (enumLiteral_1= 'start' ) ) )
            // InternalMyDsl.g:2508:2: ( (enumLiteral_0= 'end' ) | (enumLiteral_1= 'start' ) )
            {
            // InternalMyDsl.g:2508:2: ( (enumLiteral_0= 'end' ) | (enumLiteral_1= 'start' ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==83) ) {
                alt41=1;
            }
            else if ( (LA41_0==84) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalMyDsl.g:2509:3: (enumLiteral_0= 'end' )
                    {
                    // InternalMyDsl.g:2509:3: (enumLiteral_0= 'end' )
                    // InternalMyDsl.g:2510:4: enumLiteral_0= 'end'
                    {
                    enumLiteral_0=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getStartEndAccess().getEndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStartEndAccess().getEndEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2517:3: (enumLiteral_1= 'start' )
                    {
                    // InternalMyDsl.g:2517:3: (enumLiteral_1= 'start' )
                    // InternalMyDsl.g:2518:4: enumLiteral_1= 'start'
                    {
                    enumLiteral_1=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getStartEndAccess().getStartEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStartEndAccess().getStartEnumLiteralDeclaration_1());
                    			

                    }


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
    // $ANTLR end "ruleStartEnd"

    // Delegated rules


    protected DFA24 dfa24 = new DFA24(this);
    static final String dfa_1s = "\25\uffff";
    static final String dfa_2s = "\1\1\24\uffff";
    static final String dfa_3s = "\1\20\3\uffff\1\70\2\uffff\3\71\3\5\6\32\1\35\1\uffff";
    static final String dfa_4s = "\1\107\3\uffff\1\102\2\uffff\3\71\3\6\6\32\1\106\1\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\5\15\uffff\1\4";
    static final String dfa_6s = "\25\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\2\uffff\1\1\11\uffff\1\2\26\uffff\1\1\3\uffff\1\3\1\uffff\1\3\1\1\3\uffff\1\2\2\uffff\1\3\1\uffff\1\4\2\uffff\1\5",
            "",
            "",
            "",
            "\1\7\1\uffff\1\10\4\uffff\1\6\2\uffff\1\11",
            "",
            "",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15\1\16",
            "\1\17\1\20",
            "\1\21\1\22",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\24\50\uffff\1\6",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1479:2: (this_RateSucc_0= ruleRateSucc | this_SpaceXYRobot_1= ruleSpaceXYRobot | this_TaskTime_2= ruleTaskTime | this_AllocateT_3= ruleAllocateT | this_Closest_4= ruleClosest | this_MaxTasks_5= ruleMaxTasks )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000002000060L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000002008060L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L,0x0000000000001800L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000800L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000800000060L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000800010000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0004000000010000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000038000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0018000000010002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x8D00000020000000L,0x0000000000000094L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0010000000010002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x00E0400000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x00E0000000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0500000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x2000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000180000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0500000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x8500000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000402L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000010L,0x0000000000001000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000002L,0x0000000000006000L});

}