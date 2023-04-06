package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ProblemSpecification'", "'{'", "'WorldModel'", "':'", "'TasksModel'", "'RobotsModel'", "'Mission'", "'}'", "'robots'", "'needed'", "'at'", "'location'", "'with'", "'criticality'", "'('", "'description'", "')'", "'subtasks'", "'['", "','", "']'", "'ordered'", "'consecutive'", "'x'", "'y'", "'to'", "'distance'", "'initial'", "'has'", "'velocity'", "'can'", "'do'", "'-'", "'time required'", "'success'", "'probability'", "'atomic'", "'task'", "'compound'", "'but'", "'as'", "'specified'", "'all'", "'work'", "'between'", "'all robots work in '", "'greater than'", "'lower than'", "'geq'", "'leq'", "'robot'", "'work between'", "'work in '", "'qeg'", "'all robot deployed'", "'time available:'", "'system: get '", "'number of allocations'", "'system: evochecker population'", "'system: evochecker evaluations'", "'.'", "'E'", "'e'", "'true'", "'false'"
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
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
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
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
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
    // InternalMyDsl.g:64:1: entryRuleProblemSpecification returns [EObject current=null] : iv_ruleProblemSpecification= ruleProblemSpecification EOF ;
    public final EObject entryRuleProblemSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProblemSpecification = null;


        try {
            // InternalMyDsl.g:64:61: (iv_ruleProblemSpecification= ruleProblemSpecification EOF )
            // InternalMyDsl.g:65:2: iv_ruleProblemSpecification= ruleProblemSpecification EOF
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
    // InternalMyDsl.g:71:1: ruleProblemSpecification returns [EObject current=null] : ( () otherlv_1= 'ProblemSpecification' otherlv_2= '{' otherlv_3= 'WorldModel' otherlv_4= ':' ( (lv_worldModel_5_0= ruleWorldModel ) ) ( (lv_worldModel_6_0= ruleWorldModel ) )* otherlv_7= 'TasksModel' otherlv_8= ':' ( (lv_tasksModel_9_0= ruleTasksModel ) ) ( (lv_tasksModel_10_0= ruleTasksModel ) )* otherlv_11= 'RobotsModel' otherlv_12= ':' ( (lv_robotsModel_13_0= ruleRobotsModel ) ) otherlv_14= 'Mission' otherlv_15= ':' ( (lv_mission_16_0= ruleMission ) ) ( (lv_mission_17_0= ruleMission ) )* ( ( (lv_qos_18_0= ruleQoS ) ) ( (lv_qos_19_0= ruleQoS ) )* )? otherlv_20= '}' ) ;
    public final EObject ruleProblemSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_20=null;
        EObject lv_worldModel_5_0 = null;

        EObject lv_worldModel_6_0 = null;

        EObject lv_tasksModel_9_0 = null;

        EObject lv_tasksModel_10_0 = null;

        EObject lv_robotsModel_13_0 = null;

        EObject lv_mission_16_0 = null;

        EObject lv_mission_17_0 = null;

        EObject lv_qos_18_0 = null;

        EObject lv_qos_19_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:77:2: ( ( () otherlv_1= 'ProblemSpecification' otherlv_2= '{' otherlv_3= 'WorldModel' otherlv_4= ':' ( (lv_worldModel_5_0= ruleWorldModel ) ) ( (lv_worldModel_6_0= ruleWorldModel ) )* otherlv_7= 'TasksModel' otherlv_8= ':' ( (lv_tasksModel_9_0= ruleTasksModel ) ) ( (lv_tasksModel_10_0= ruleTasksModel ) )* otherlv_11= 'RobotsModel' otherlv_12= ':' ( (lv_robotsModel_13_0= ruleRobotsModel ) ) otherlv_14= 'Mission' otherlv_15= ':' ( (lv_mission_16_0= ruleMission ) ) ( (lv_mission_17_0= ruleMission ) )* ( ( (lv_qos_18_0= ruleQoS ) ) ( (lv_qos_19_0= ruleQoS ) )* )? otherlv_20= '}' ) )
            // InternalMyDsl.g:78:2: ( () otherlv_1= 'ProblemSpecification' otherlv_2= '{' otherlv_3= 'WorldModel' otherlv_4= ':' ( (lv_worldModel_5_0= ruleWorldModel ) ) ( (lv_worldModel_6_0= ruleWorldModel ) )* otherlv_7= 'TasksModel' otherlv_8= ':' ( (lv_tasksModel_9_0= ruleTasksModel ) ) ( (lv_tasksModel_10_0= ruleTasksModel ) )* otherlv_11= 'RobotsModel' otherlv_12= ':' ( (lv_robotsModel_13_0= ruleRobotsModel ) ) otherlv_14= 'Mission' otherlv_15= ':' ( (lv_mission_16_0= ruleMission ) ) ( (lv_mission_17_0= ruleMission ) )* ( ( (lv_qos_18_0= ruleQoS ) ) ( (lv_qos_19_0= ruleQoS ) )* )? otherlv_20= '}' )
            {
            // InternalMyDsl.g:78:2: ( () otherlv_1= 'ProblemSpecification' otherlv_2= '{' otherlv_3= 'WorldModel' otherlv_4= ':' ( (lv_worldModel_5_0= ruleWorldModel ) ) ( (lv_worldModel_6_0= ruleWorldModel ) )* otherlv_7= 'TasksModel' otherlv_8= ':' ( (lv_tasksModel_9_0= ruleTasksModel ) ) ( (lv_tasksModel_10_0= ruleTasksModel ) )* otherlv_11= 'RobotsModel' otherlv_12= ':' ( (lv_robotsModel_13_0= ruleRobotsModel ) ) otherlv_14= 'Mission' otherlv_15= ':' ( (lv_mission_16_0= ruleMission ) ) ( (lv_mission_17_0= ruleMission ) )* ( ( (lv_qos_18_0= ruleQoS ) ) ( (lv_qos_19_0= ruleQoS ) )* )? otherlv_20= '}' )
            // InternalMyDsl.g:79:3: () otherlv_1= 'ProblemSpecification' otherlv_2= '{' otherlv_3= 'WorldModel' otherlv_4= ':' ( (lv_worldModel_5_0= ruleWorldModel ) ) ( (lv_worldModel_6_0= ruleWorldModel ) )* otherlv_7= 'TasksModel' otherlv_8= ':' ( (lv_tasksModel_9_0= ruleTasksModel ) ) ( (lv_tasksModel_10_0= ruleTasksModel ) )* otherlv_11= 'RobotsModel' otherlv_12= ':' ( (lv_robotsModel_13_0= ruleRobotsModel ) ) otherlv_14= 'Mission' otherlv_15= ':' ( (lv_mission_16_0= ruleMission ) ) ( (lv_mission_17_0= ruleMission ) )* ( ( (lv_qos_18_0= ruleQoS ) ) ( (lv_qos_19_0= ruleQoS ) )* )? otherlv_20= '}'
            {
            // InternalMyDsl.g:79:3: ()
            // InternalMyDsl.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProblemSpecificationAccess().getProblemSpecificationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getProblemSpecificationAccess().getProblemSpecificationKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getProblemSpecificationAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getProblemSpecificationAccess().getWorldModelKeyword_3());
            		
            otherlv_4=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getProblemSpecificationAccess().getColonKeyword_4());
            		
            // InternalMyDsl.g:102:3: ( (lv_worldModel_5_0= ruleWorldModel ) )
            // InternalMyDsl.g:103:4: (lv_worldModel_5_0= ruleWorldModel )
            {
            // InternalMyDsl.g:103:4: (lv_worldModel_5_0= ruleWorldModel )
            // InternalMyDsl.g:104:5: lv_worldModel_5_0= ruleWorldModel
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

            // InternalMyDsl.g:121:3: ( (lv_worldModel_6_0= ruleWorldModel ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyDsl.g:122:4: (lv_worldModel_6_0= ruleWorldModel )
            	    {
            	    // InternalMyDsl.g:122:4: (lv_worldModel_6_0= ruleWorldModel )
            	    // InternalMyDsl.g:123:5: lv_worldModel_6_0= ruleWorldModel
            	    {

            	    					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getWorldModelWorldModelParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_worldModel_6_0=ruleWorldModel();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"worldModel",
            	    						lv_worldModel_6_0,
            	    						"org.xtext.example.mydsl.MyDsl.WorldModel");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_7=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_7, grammarAccess.getProblemSpecificationAccess().getTasksModelKeyword_7());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_8, grammarAccess.getProblemSpecificationAccess().getColonKeyword_8());
            		
            // InternalMyDsl.g:148:3: ( (lv_tasksModel_9_0= ruleTasksModel ) )
            // InternalMyDsl.g:149:4: (lv_tasksModel_9_0= ruleTasksModel )
            {
            // InternalMyDsl.g:149:4: (lv_tasksModel_9_0= ruleTasksModel )
            // InternalMyDsl.g:150:5: lv_tasksModel_9_0= ruleTasksModel
            {

            					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getTasksModelTasksModelParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_8);
            lv_tasksModel_9_0=ruleTasksModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            					}
            					add(
            						current,
            						"tasksModel",
            						lv_tasksModel_9_0,
            						"org.xtext.example.mydsl.MyDsl.TasksModel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:167:3: ( (lv_tasksModel_10_0= ruleTasksModel ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMyDsl.g:168:4: (lv_tasksModel_10_0= ruleTasksModel )
            	    {
            	    // InternalMyDsl.g:168:4: (lv_tasksModel_10_0= ruleTasksModel )
            	    // InternalMyDsl.g:169:5: lv_tasksModel_10_0= ruleTasksModel
            	    {

            	    					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getTasksModelTasksModelParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_8);
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
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_11=(Token)match(input,16,FOLLOW_5); 

            			newLeafNode(otherlv_11, grammarAccess.getProblemSpecificationAccess().getRobotsModelKeyword_11());
            		
            otherlv_12=(Token)match(input,14,FOLLOW_9); 

            			newLeafNode(otherlv_12, grammarAccess.getProblemSpecificationAccess().getColonKeyword_12());
            		
            // InternalMyDsl.g:194:3: ( (lv_robotsModel_13_0= ruleRobotsModel ) )
            // InternalMyDsl.g:195:4: (lv_robotsModel_13_0= ruleRobotsModel )
            {
            // InternalMyDsl.g:195:4: (lv_robotsModel_13_0= ruleRobotsModel )
            // InternalMyDsl.g:196:5: lv_robotsModel_13_0= ruleRobotsModel
            {

            					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getRobotsModelRobotsModelParserRuleCall_13_0());
            				
            pushFollow(FOLLOW_10);
            lv_robotsModel_13_0=ruleRobotsModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            					}
            					set(
            						current,
            						"robotsModel",
            						lv_robotsModel_13_0,
            						"org.xtext.example.mydsl.MyDsl.RobotsModel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,17,FOLLOW_5); 

            			newLeafNode(otherlv_14, grammarAccess.getProblemSpecificationAccess().getMissionKeyword_14());
            		
            otherlv_15=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_15, grammarAccess.getProblemSpecificationAccess().getColonKeyword_15());
            		
            // InternalMyDsl.g:221:3: ( (lv_mission_16_0= ruleMission ) )
            // InternalMyDsl.g:222:4: (lv_mission_16_0= ruleMission )
            {
            // InternalMyDsl.g:222:4: (lv_mission_16_0= ruleMission )
            // InternalMyDsl.g:223:5: lv_mission_16_0= ruleMission
            {

            					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getMissionMissionParserRuleCall_16_0());
            				
            pushFollow(FOLLOW_11);
            lv_mission_16_0=ruleMission();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            					}
            					add(
            						current,
            						"mission",
            						lv_mission_16_0,
            						"org.xtext.example.mydsl.MyDsl.Mission");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:240:3: ( (lv_mission_17_0= ruleMission ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMyDsl.g:241:4: (lv_mission_17_0= ruleMission )
            	    {
            	    // InternalMyDsl.g:241:4: (lv_mission_17_0= ruleMission )
            	    // InternalMyDsl.g:242:5: lv_mission_17_0= ruleMission
            	    {

            	    					newCompositeNode(grammarAccess.getProblemSpecificationAccess().getMissionMissionParserRuleCall_17_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_mission_17_0=ruleMission();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"mission",
            	    						lv_mission_17_0,
            	    						"org.xtext.example.mydsl.MyDsl.Mission");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalMyDsl.g:259:3: ( ( (lv_qos_18_0= ruleQoS ) ) ( (lv_qos_19_0= ruleQoS ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==53||LA5_0==56||LA5_0==61||(LA5_0>=65 && LA5_0<=67)||(LA5_0>=69 && LA5_0<=70)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMyDsl.g:260:4: ( (lv_qos_18_0= ruleQoS ) ) ( (lv_qos_19_0= ruleQoS ) )*
                    {
                    // InternalMyDsl.g:260:4: ( (lv_qos_18_0= ruleQoS ) )
                    // InternalMyDsl.g:261:5: (lv_qos_18_0= ruleQoS )
                    {
                    // InternalMyDsl.g:261:5: (lv_qos_18_0= ruleQoS )
                    // InternalMyDsl.g:262:6: lv_qos_18_0= ruleQoS
                    {

                    						newCompositeNode(grammarAccess.getProblemSpecificationAccess().getQosQoSParserRuleCall_18_0_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_qos_18_0=ruleQoS();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
                    						}
                    						add(
                    							current,
                    							"qos",
                    							lv_qos_18_0,
                    							"org.xtext.example.mydsl.MyDsl.QoS");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:279:4: ( (lv_qos_19_0= ruleQoS ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==53||LA4_0==56||LA4_0==61||(LA4_0>=65 && LA4_0<=67)||(LA4_0>=69 && LA4_0<=70)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalMyDsl.g:280:5: (lv_qos_19_0= ruleQoS )
                    	    {
                    	    // InternalMyDsl.g:280:5: (lv_qos_19_0= ruleQoS )
                    	    // InternalMyDsl.g:281:6: lv_qos_19_0= ruleQoS
                    	    {

                    	    						newCompositeNode(grammarAccess.getProblemSpecificationAccess().getQosQoSParserRuleCall_18_1_0());
                    	    					
                    	    pushFollow(FOLLOW_12);
                    	    lv_qos_19_0=ruleQoS();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getProblemSpecificationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"qos",
                    	    							lv_qos_19_0,
                    	    							"org.xtext.example.mydsl.MyDsl.QoS");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_20=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_20, grammarAccess.getProblemSpecificationAccess().getRightCurlyBracketKeyword_19());
            		

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


    // $ANTLR start "entryRuleTasksModel"
    // InternalMyDsl.g:307:1: entryRuleTasksModel returns [EObject current=null] : iv_ruleTasksModel= ruleTasksModel EOF ;
    public final EObject entryRuleTasksModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTasksModel = null;


        try {
            // InternalMyDsl.g:307:51: (iv_ruleTasksModel= ruleTasksModel EOF )
            // InternalMyDsl.g:308:2: iv_ruleTasksModel= ruleTasksModel EOF
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
    // InternalMyDsl.g:314:1: ruleTasksModel returns [EObject current=null] : (this_AtomicTask_0= ruleAtomicTask | this_CompoundTask_1= ruleCompoundTask ) ;
    public final EObject ruleTasksModel() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicTask_0 = null;

        EObject this_CompoundTask_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:320:2: ( (this_AtomicTask_0= ruleAtomicTask | this_CompoundTask_1= ruleCompoundTask ) )
            // InternalMyDsl.g:321:2: (this_AtomicTask_0= ruleAtomicTask | this_CompoundTask_1= ruleCompoundTask )
            {
            // InternalMyDsl.g:321:2: (this_AtomicTask_0= ruleAtomicTask | this_CompoundTask_1= ruleCompoundTask )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==14) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==28) ) {
                        alt6=2;
                    }
                    else if ( (LA6_3==RULE_INT||LA6_3==43) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA6_0==RULE_ID) ) {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==14) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==28) ) {
                        alt6=2;
                    }
                    else if ( (LA6_3==RULE_INT||LA6_3==43) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:322:3: this_AtomicTask_0= ruleAtomicTask
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
                    // InternalMyDsl.g:331:3: this_CompoundTask_1= ruleCompoundTask
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
    // InternalMyDsl.g:343:1: entryRuleAtomicTask returns [EObject current=null] : iv_ruleAtomicTask= ruleAtomicTask EOF ;
    public final EObject entryRuleAtomicTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicTask = null;


        try {
            // InternalMyDsl.g:343:51: (iv_ruleAtomicTask= ruleAtomicTask EOF )
            // InternalMyDsl.g:344:2: iv_ruleAtomicTask= ruleAtomicTask EOF
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
    // InternalMyDsl.g:350:1: ruleAtomicTask returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_robots_3_0= ruleEInt ) ) otherlv_4= 'robots' otherlv_5= 'needed' (otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) ) )? (otherlv_9= 'with' otherlv_10= 'criticality' otherlv_11= ':' ( (lv_criticality_12_0= ruleEBoolean ) ) )? (otherlv_13= '(' otherlv_14= 'description' otherlv_15= ':' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )? ) ;
    public final EObject ruleAtomicTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_robots_3_0 = null;

        AntlrDatatypeRuleToken lv_criticality_12_0 = null;

        AntlrDatatypeRuleToken lv_description_16_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:356:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_robots_3_0= ruleEInt ) ) otherlv_4= 'robots' otherlv_5= 'needed' (otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) ) )? (otherlv_9= 'with' otherlv_10= 'criticality' otherlv_11= ':' ( (lv_criticality_12_0= ruleEBoolean ) ) )? (otherlv_13= '(' otherlv_14= 'description' otherlv_15= ':' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )? ) )
            // InternalMyDsl.g:357:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_robots_3_0= ruleEInt ) ) otherlv_4= 'robots' otherlv_5= 'needed' (otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) ) )? (otherlv_9= 'with' otherlv_10= 'criticality' otherlv_11= ':' ( (lv_criticality_12_0= ruleEBoolean ) ) )? (otherlv_13= '(' otherlv_14= 'description' otherlv_15= ':' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )? )
            {
            // InternalMyDsl.g:357:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_robots_3_0= ruleEInt ) ) otherlv_4= 'robots' otherlv_5= 'needed' (otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) ) )? (otherlv_9= 'with' otherlv_10= 'criticality' otherlv_11= ':' ( (lv_criticality_12_0= ruleEBoolean ) ) )? (otherlv_13= '(' otherlv_14= 'description' otherlv_15= ':' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )? )
            // InternalMyDsl.g:358:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_robots_3_0= ruleEInt ) ) otherlv_4= 'robots' otherlv_5= 'needed' (otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) ) )? (otherlv_9= 'with' otherlv_10= 'criticality' otherlv_11= ':' ( (lv_criticality_12_0= ruleEBoolean ) ) )? (otherlv_13= '(' otherlv_14= 'description' otherlv_15= ':' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )?
            {
            // InternalMyDsl.g:358:3: ()
            // InternalMyDsl.g:359:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAtomicTaskAccess().getAtomicTaskAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:365:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:366:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:366:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:367:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAtomicTaskAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAtomicTaskRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getAtomicTaskAccess().getColonKeyword_2());
            		
            // InternalMyDsl.g:388:3: ( (lv_robots_3_0= ruleEInt ) )
            // InternalMyDsl.g:389:4: (lv_robots_3_0= ruleEInt )
            {
            // InternalMyDsl.g:389:4: (lv_robots_3_0= ruleEInt )
            // InternalMyDsl.g:390:5: lv_robots_3_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getAtomicTaskAccess().getRobotsEIntParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_9);
            lv_robots_3_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAtomicTaskRule());
            					}
            					set(
            						current,
            						"robots",
            						lv_robots_3_0,
            						"org.xtext.example.mydsl.MyDsl.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getAtomicTaskAccess().getRobotsKeyword_4());
            		
            otherlv_5=(Token)match(input,20,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getAtomicTaskAccess().getNeededKeyword_5());
            		
            // InternalMyDsl.g:415:3: (otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMyDsl.g:416:4: otherlv_6= 'at' otherlv_7= 'location' ( ( ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_16); 

                    				newLeafNode(otherlv_6, grammarAccess.getAtomicTaskAccess().getAtKeyword_6_0());
                    			
                    otherlv_7=(Token)match(input,22,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getAtomicTaskAccess().getLocationKeyword_6_1());
                    			
                    // InternalMyDsl.g:424:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:425:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:425:5: ( ruleEString )
                    // InternalMyDsl.g:426:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicTaskRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAtomicTaskAccess().getLocLocationCrossReference_6_2_0());
                    					
                    pushFollow(FOLLOW_17);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:441:3: (otherlv_9= 'with' otherlv_10= 'criticality' otherlv_11= ':' ( (lv_criticality_12_0= ruleEBoolean ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:442:4: otherlv_9= 'with' otherlv_10= 'criticality' otherlv_11= ':' ( (lv_criticality_12_0= ruleEBoolean ) )
                    {
                    otherlv_9=(Token)match(input,23,FOLLOW_18); 

                    				newLeafNode(otherlv_9, grammarAccess.getAtomicTaskAccess().getWithKeyword_7_0());
                    			
                    otherlv_10=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_10, grammarAccess.getAtomicTaskAccess().getCriticalityKeyword_7_1());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_19); 

                    				newLeafNode(otherlv_11, grammarAccess.getAtomicTaskAccess().getColonKeyword_7_2());
                    			
                    // InternalMyDsl.g:454:4: ( (lv_criticality_12_0= ruleEBoolean ) )
                    // InternalMyDsl.g:455:5: (lv_criticality_12_0= ruleEBoolean )
                    {
                    // InternalMyDsl.g:455:5: (lv_criticality_12_0= ruleEBoolean )
                    // InternalMyDsl.g:456:6: lv_criticality_12_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getAtomicTaskAccess().getCriticalityEBooleanParserRuleCall_7_3_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_criticality_12_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicTaskRule());
                    						}
                    						set(
                    							current,
                    							"criticality",
                    							lv_criticality_12_0,
                    							"org.xtext.example.mydsl.MyDsl.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:474:3: (otherlv_13= '(' otherlv_14= 'description' otherlv_15= ':' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMyDsl.g:475:4: otherlv_13= '(' otherlv_14= 'description' otherlv_15= ':' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')'
                    {
                    otherlv_13=(Token)match(input,25,FOLLOW_21); 

                    				newLeafNode(otherlv_13, grammarAccess.getAtomicTaskAccess().getLeftParenthesisKeyword_8_0());
                    			
                    otherlv_14=(Token)match(input,26,FOLLOW_5); 

                    				newLeafNode(otherlv_14, grammarAccess.getAtomicTaskAccess().getDescriptionKeyword_8_1());
                    			
                    otherlv_15=(Token)match(input,14,FOLLOW_6); 

                    				newLeafNode(otherlv_15, grammarAccess.getAtomicTaskAccess().getColonKeyword_8_2());
                    			
                    // InternalMyDsl.g:487:4: ( (lv_description_16_0= ruleEString ) )
                    // InternalMyDsl.g:488:5: (lv_description_16_0= ruleEString )
                    {
                    // InternalMyDsl.g:488:5: (lv_description_16_0= ruleEString )
                    // InternalMyDsl.g:489:6: lv_description_16_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getAtomicTaskAccess().getDescriptionEStringParserRuleCall_8_3_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_description_16_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicTaskRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_16_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getAtomicTaskAccess().getRightParenthesisKeyword_8_4());
                    			

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
    // $ANTLR end "ruleAtomicTask"


    // $ANTLR start "entryRuleCompoundTask"
    // InternalMyDsl.g:515:1: entryRuleCompoundTask returns [EObject current=null] : iv_ruleCompoundTask= ruleCompoundTask EOF ;
    public final EObject entryRuleCompoundTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundTask = null;


        try {
            // InternalMyDsl.g:515:53: (iv_ruleCompoundTask= ruleCompoundTask EOF )
            // InternalMyDsl.g:516:2: iv_ruleCompoundTask= ruleCompoundTask EOF
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
    // InternalMyDsl.g:522:1: ruleCompoundTask returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'subtasks' otherlv_4= '[' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ']' (otherlv_9= 'at' ( ( ruleEString ) ) )? (otherlv_11= 'with' otherlv_12= 'criticality' otherlv_13= ':' ( (lv_criticality_14_0= ruleEBoolean ) ) )? (otherlv_15= 'ordered' otherlv_16= ':' ( (lv_ordered_17_0= ruleEBoolean ) ) )? (otherlv_18= 'consecutive' otherlv_19= ':' ( (lv_consecutive_20_0= ruleEBoolean ) ) )? (otherlv_21= '(' otherlv_22= 'description' otherlv_23= ':' ( (lv_description_24_0= ruleEString ) ) otherlv_25= ')' )? ) ;
    public final EObject ruleCompoundTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_criticality_14_0 = null;

        AntlrDatatypeRuleToken lv_ordered_17_0 = null;

        AntlrDatatypeRuleToken lv_consecutive_20_0 = null;

        AntlrDatatypeRuleToken lv_description_24_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:528:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'subtasks' otherlv_4= '[' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ']' (otherlv_9= 'at' ( ( ruleEString ) ) )? (otherlv_11= 'with' otherlv_12= 'criticality' otherlv_13= ':' ( (lv_criticality_14_0= ruleEBoolean ) ) )? (otherlv_15= 'ordered' otherlv_16= ':' ( (lv_ordered_17_0= ruleEBoolean ) ) )? (otherlv_18= 'consecutive' otherlv_19= ':' ( (lv_consecutive_20_0= ruleEBoolean ) ) )? (otherlv_21= '(' otherlv_22= 'description' otherlv_23= ':' ( (lv_description_24_0= ruleEString ) ) otherlv_25= ')' )? ) )
            // InternalMyDsl.g:529:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'subtasks' otherlv_4= '[' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ']' (otherlv_9= 'at' ( ( ruleEString ) ) )? (otherlv_11= 'with' otherlv_12= 'criticality' otherlv_13= ':' ( (lv_criticality_14_0= ruleEBoolean ) ) )? (otherlv_15= 'ordered' otherlv_16= ':' ( (lv_ordered_17_0= ruleEBoolean ) ) )? (otherlv_18= 'consecutive' otherlv_19= ':' ( (lv_consecutive_20_0= ruleEBoolean ) ) )? (otherlv_21= '(' otherlv_22= 'description' otherlv_23= ':' ( (lv_description_24_0= ruleEString ) ) otherlv_25= ')' )? )
            {
            // InternalMyDsl.g:529:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'subtasks' otherlv_4= '[' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ']' (otherlv_9= 'at' ( ( ruleEString ) ) )? (otherlv_11= 'with' otherlv_12= 'criticality' otherlv_13= ':' ( (lv_criticality_14_0= ruleEBoolean ) ) )? (otherlv_15= 'ordered' otherlv_16= ':' ( (lv_ordered_17_0= ruleEBoolean ) ) )? (otherlv_18= 'consecutive' otherlv_19= ':' ( (lv_consecutive_20_0= ruleEBoolean ) ) )? (otherlv_21= '(' otherlv_22= 'description' otherlv_23= ':' ( (lv_description_24_0= ruleEString ) ) otherlv_25= ')' )? )
            // InternalMyDsl.g:530:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'subtasks' otherlv_4= '[' ( ( ruleEString ) ) (otherlv_6= ',' ( ( ruleEString ) ) )* otherlv_8= ']' (otherlv_9= 'at' ( ( ruleEString ) ) )? (otherlv_11= 'with' otherlv_12= 'criticality' otherlv_13= ':' ( (lv_criticality_14_0= ruleEBoolean ) ) )? (otherlv_15= 'ordered' otherlv_16= ':' ( (lv_ordered_17_0= ruleEBoolean ) ) )? (otherlv_18= 'consecutive' otherlv_19= ':' ( (lv_consecutive_20_0= ruleEBoolean ) ) )? (otherlv_21= '(' otherlv_22= 'description' otherlv_23= ':' ( (lv_description_24_0= ruleEString ) ) otherlv_25= ')' )?
            {
            // InternalMyDsl.g:530:3: ()
            // InternalMyDsl.g:531:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompoundTaskAccess().getCompoundTaskAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:537:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:538:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:538:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:539:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCompoundTaskAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompoundTaskRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getCompoundTaskAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,28,FOLLOW_24); 

            			newLeafNode(otherlv_3, grammarAccess.getCompoundTaskAccess().getSubtasksKeyword_3());
            		
            otherlv_4=(Token)match(input,29,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getCompoundTaskAccess().getLeftSquareBracketKeyword_4());
            		
            // InternalMyDsl.g:568:3: ( ( ruleEString ) )
            // InternalMyDsl.g:569:4: ( ruleEString )
            {
            // InternalMyDsl.g:569:4: ( ruleEString )
            // InternalMyDsl.g:570:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompoundTaskRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelCrossReference_5_0());
            				
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:584:3: (otherlv_6= ',' ( ( ruleEString ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==30) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMyDsl.g:585:4: otherlv_6= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_6=(Token)match(input,30,FOLLOW_6); 

            	    				newLeafNode(otherlv_6, grammarAccess.getCompoundTaskAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMyDsl.g:589:4: ( ( ruleEString ) )
            	    // InternalMyDsl.g:590:5: ( ruleEString )
            	    {
            	    // InternalMyDsl.g:590:5: ( ruleEString )
            	    // InternalMyDsl.g:591:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getCompoundTaskRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelCrossReference_6_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_8=(Token)match(input,31,FOLLOW_26); 

            			newLeafNode(otherlv_8, grammarAccess.getCompoundTaskAccess().getRightSquareBracketKeyword_7());
            		
            // InternalMyDsl.g:610:3: (otherlv_9= 'at' ( ( ruleEString ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyDsl.g:611:4: otherlv_9= 'at' ( ( ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,21,FOLLOW_6); 

                    				newLeafNode(otherlv_9, grammarAccess.getCompoundTaskAccess().getAtKeyword_8_0());
                    			
                    // InternalMyDsl.g:615:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:616:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:616:5: ( ruleEString )
                    // InternalMyDsl.g:617:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCompoundTaskRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCompoundTaskAccess().getLocationLocationCrossReference_8_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:632:3: (otherlv_11= 'with' otherlv_12= 'criticality' otherlv_13= ':' ( (lv_criticality_14_0= ruleEBoolean ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMyDsl.g:633:4: otherlv_11= 'with' otherlv_12= 'criticality' otherlv_13= ':' ( (lv_criticality_14_0= ruleEBoolean ) )
                    {
                    otherlv_11=(Token)match(input,23,FOLLOW_18); 

                    				newLeafNode(otherlv_11, grammarAccess.getCompoundTaskAccess().getWithKeyword_9_0());
                    			
                    otherlv_12=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_12, grammarAccess.getCompoundTaskAccess().getCriticalityKeyword_9_1());
                    			
                    otherlv_13=(Token)match(input,14,FOLLOW_19); 

                    				newLeafNode(otherlv_13, grammarAccess.getCompoundTaskAccess().getColonKeyword_9_2());
                    			
                    // InternalMyDsl.g:645:4: ( (lv_criticality_14_0= ruleEBoolean ) )
                    // InternalMyDsl.g:646:5: (lv_criticality_14_0= ruleEBoolean )
                    {
                    // InternalMyDsl.g:646:5: (lv_criticality_14_0= ruleEBoolean )
                    // InternalMyDsl.g:647:6: lv_criticality_14_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getCompoundTaskAccess().getCriticalityEBooleanParserRuleCall_9_3_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_criticality_14_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompoundTaskRule());
                    						}
                    						set(
                    							current,
                    							"criticality",
                    							lv_criticality_14_0,
                    							"org.xtext.example.mydsl.MyDsl.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:665:3: (otherlv_15= 'ordered' otherlv_16= ':' ( (lv_ordered_17_0= ruleEBoolean ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyDsl.g:666:4: otherlv_15= 'ordered' otherlv_16= ':' ( (lv_ordered_17_0= ruleEBoolean ) )
                    {
                    otherlv_15=(Token)match(input,32,FOLLOW_5); 

                    				newLeafNode(otherlv_15, grammarAccess.getCompoundTaskAccess().getOrderedKeyword_10_0());
                    			
                    otherlv_16=(Token)match(input,14,FOLLOW_19); 

                    				newLeafNode(otherlv_16, grammarAccess.getCompoundTaskAccess().getColonKeyword_10_1());
                    			
                    // InternalMyDsl.g:674:4: ( (lv_ordered_17_0= ruleEBoolean ) )
                    // InternalMyDsl.g:675:5: (lv_ordered_17_0= ruleEBoolean )
                    {
                    // InternalMyDsl.g:675:5: (lv_ordered_17_0= ruleEBoolean )
                    // InternalMyDsl.g:676:6: lv_ordered_17_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getCompoundTaskAccess().getOrderedEBooleanParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_29);
                    lv_ordered_17_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompoundTaskRule());
                    						}
                    						set(
                    							current,
                    							"ordered",
                    							lv_ordered_17_0,
                    							"org.xtext.example.mydsl.MyDsl.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:694:3: (otherlv_18= 'consecutive' otherlv_19= ':' ( (lv_consecutive_20_0= ruleEBoolean ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==33) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMyDsl.g:695:4: otherlv_18= 'consecutive' otherlv_19= ':' ( (lv_consecutive_20_0= ruleEBoolean ) )
                    {
                    otherlv_18=(Token)match(input,33,FOLLOW_5); 

                    				newLeafNode(otherlv_18, grammarAccess.getCompoundTaskAccess().getConsecutiveKeyword_11_0());
                    			
                    otherlv_19=(Token)match(input,14,FOLLOW_19); 

                    				newLeafNode(otherlv_19, grammarAccess.getCompoundTaskAccess().getColonKeyword_11_1());
                    			
                    // InternalMyDsl.g:703:4: ( (lv_consecutive_20_0= ruleEBoolean ) )
                    // InternalMyDsl.g:704:5: (lv_consecutive_20_0= ruleEBoolean )
                    {
                    // InternalMyDsl.g:704:5: (lv_consecutive_20_0= ruleEBoolean )
                    // InternalMyDsl.g:705:6: lv_consecutive_20_0= ruleEBoolean
                    {

                    						newCompositeNode(grammarAccess.getCompoundTaskAccess().getConsecutiveEBooleanParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_consecutive_20_0=ruleEBoolean();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompoundTaskRule());
                    						}
                    						set(
                    							current,
                    							"consecutive",
                    							lv_consecutive_20_0,
                    							"org.xtext.example.mydsl.MyDsl.EBoolean");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:723:3: (otherlv_21= '(' otherlv_22= 'description' otherlv_23= ':' ( (lv_description_24_0= ruleEString ) ) otherlv_25= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDsl.g:724:4: otherlv_21= '(' otherlv_22= 'description' otherlv_23= ':' ( (lv_description_24_0= ruleEString ) ) otherlv_25= ')'
                    {
                    otherlv_21=(Token)match(input,25,FOLLOW_21); 

                    				newLeafNode(otherlv_21, grammarAccess.getCompoundTaskAccess().getLeftParenthesisKeyword_12_0());
                    			
                    otherlv_22=(Token)match(input,26,FOLLOW_5); 

                    				newLeafNode(otherlv_22, grammarAccess.getCompoundTaskAccess().getDescriptionKeyword_12_1());
                    			
                    otherlv_23=(Token)match(input,14,FOLLOW_6); 

                    				newLeafNode(otherlv_23, grammarAccess.getCompoundTaskAccess().getColonKeyword_12_2());
                    			
                    // InternalMyDsl.g:736:4: ( (lv_description_24_0= ruleEString ) )
                    // InternalMyDsl.g:737:5: (lv_description_24_0= ruleEString )
                    {
                    // InternalMyDsl.g:737:5: (lv_description_24_0= ruleEString )
                    // InternalMyDsl.g:738:6: lv_description_24_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompoundTaskAccess().getDescriptionEStringParserRuleCall_12_3_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_description_24_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompoundTaskRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_24_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_25=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_25, grammarAccess.getCompoundTaskAccess().getRightParenthesisKeyword_12_4());
                    			

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


    // $ANTLR start "entryRuleWorldModel"
    // InternalMyDsl.g:764:1: entryRuleWorldModel returns [EObject current=null] : iv_ruleWorldModel= ruleWorldModel EOF ;
    public final EObject entryRuleWorldModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorldModel = null;


        try {
            // InternalMyDsl.g:764:51: (iv_ruleWorldModel= ruleWorldModel EOF )
            // InternalMyDsl.g:765:2: iv_ruleWorldModel= ruleWorldModel EOF
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
    // InternalMyDsl.g:771:1: ruleWorldModel returns [EObject current=null] : (this_Location_0= ruleLocation | this_Paths_1= rulePaths ) ;
    public final EObject ruleWorldModel() throws RecognitionException {
        EObject current = null;

        EObject this_Location_0 = null;

        EObject this_Paths_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:777:2: ( (this_Location_0= ruleLocation | this_Paths_1= rulePaths ) )
            // InternalMyDsl.g:778:2: (this_Location_0= ruleLocation | this_Paths_1= rulePaths )
            {
            // InternalMyDsl.g:778:2: (this_Location_0= ruleLocation | this_Paths_1= rulePaths )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==36) ) {
                    alt16=2;
                }
                else if ( (LA16_1==14) ) {
                    alt16=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA16_0==RULE_ID) ) {
                int LA16_2 = input.LA(2);

                if ( (LA16_2==14) ) {
                    alt16=1;
                }
                else if ( (LA16_2==36) ) {
                    alt16=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalMyDsl.g:779:3: this_Location_0= ruleLocation
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
                    // InternalMyDsl.g:788:3: this_Paths_1= rulePaths
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
    // InternalMyDsl.g:800:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // InternalMyDsl.g:800:49: (iv_ruleLocation= ruleLocation EOF )
            // InternalMyDsl.g:801:2: iv_ruleLocation= ruleLocation EOF
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
    // InternalMyDsl.g:807:1: ruleLocation returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= '(' otherlv_4= 'x' ( (lv_x_5_0= ruleEDouble ) ) otherlv_6= 'y' ( (lv_y_7_0= ruleEDouble ) ) (otherlv_8= 'description' ( (lv_description_9_0= ruleEString ) ) )? otherlv_10= ')' ) ;
    public final EObject ruleLocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_x_5_0 = null;

        AntlrDatatypeRuleToken lv_y_7_0 = null;

        AntlrDatatypeRuleToken lv_description_9_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:813:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= '(' otherlv_4= 'x' ( (lv_x_5_0= ruleEDouble ) ) otherlv_6= 'y' ( (lv_y_7_0= ruleEDouble ) ) (otherlv_8= 'description' ( (lv_description_9_0= ruleEString ) ) )? otherlv_10= ')' ) )
            // InternalMyDsl.g:814:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= '(' otherlv_4= 'x' ( (lv_x_5_0= ruleEDouble ) ) otherlv_6= 'y' ( (lv_y_7_0= ruleEDouble ) ) (otherlv_8= 'description' ( (lv_description_9_0= ruleEString ) ) )? otherlv_10= ')' )
            {
            // InternalMyDsl.g:814:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= '(' otherlv_4= 'x' ( (lv_x_5_0= ruleEDouble ) ) otherlv_6= 'y' ( (lv_y_7_0= ruleEDouble ) ) (otherlv_8= 'description' ( (lv_description_9_0= ruleEString ) ) )? otherlv_10= ')' )
            // InternalMyDsl.g:815:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= '(' otherlv_4= 'x' ( (lv_x_5_0= ruleEDouble ) ) otherlv_6= 'y' ( (lv_y_7_0= ruleEDouble ) ) (otherlv_8= 'description' ( (lv_description_9_0= ruleEString ) ) )? otherlv_10= ')'
            {
            // InternalMyDsl.g:815:3: ()
            // InternalMyDsl.g:816:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLocationAccess().getLocationAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:822:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:823:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:823:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:824:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLocationAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getLocationAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,25,FOLLOW_31); 

            			newLeafNode(otherlv_3, grammarAccess.getLocationAccess().getLeftParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,34,FOLLOW_32); 

            			newLeafNode(otherlv_4, grammarAccess.getLocationAccess().getXKeyword_4());
            		
            // InternalMyDsl.g:853:3: ( (lv_x_5_0= ruleEDouble ) )
            // InternalMyDsl.g:854:4: (lv_x_5_0= ruleEDouble )
            {
            // InternalMyDsl.g:854:4: (lv_x_5_0= ruleEDouble )
            // InternalMyDsl.g:855:5: lv_x_5_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getLocationAccess().getXEDoubleParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_33);
            lv_x_5_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationRule());
            					}
            					set(
            						current,
            						"x",
            						lv_x_5_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,35,FOLLOW_32); 

            			newLeafNode(otherlv_6, grammarAccess.getLocationAccess().getYKeyword_6());
            		
            // InternalMyDsl.g:876:3: ( (lv_y_7_0= ruleEDouble ) )
            // InternalMyDsl.g:877:4: (lv_y_7_0= ruleEDouble )
            {
            // InternalMyDsl.g:877:4: (lv_y_7_0= ruleEDouble )
            // InternalMyDsl.g:878:5: lv_y_7_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getLocationAccess().getYEDoubleParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_34);
            lv_y_7_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationRule());
            					}
            					set(
            						current,
            						"y",
            						lv_y_7_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:895:3: (otherlv_8= 'description' ( (lv_description_9_0= ruleEString ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:896:4: otherlv_8= 'description' ( (lv_description_9_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_6); 

                    				newLeafNode(otherlv_8, grammarAccess.getLocationAccess().getDescriptionKeyword_8_0());
                    			
                    // InternalMyDsl.g:900:4: ( (lv_description_9_0= ruleEString ) )
                    // InternalMyDsl.g:901:5: (lv_description_9_0= ruleEString )
                    {
                    // InternalMyDsl.g:901:5: (lv_description_9_0= ruleEString )
                    // InternalMyDsl.g:902:6: lv_description_9_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getLocationAccess().getDescriptionEStringParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_22);
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

            otherlv_10=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getLocationAccess().getRightParenthesisKeyword_9());
            		

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
    // InternalMyDsl.g:928:1: entryRulePaths returns [EObject current=null] : iv_rulePaths= rulePaths EOF ;
    public final EObject entryRulePaths() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePaths = null;


        try {
            // InternalMyDsl.g:928:46: (iv_rulePaths= rulePaths EOF )
            // InternalMyDsl.g:929:2: iv_rulePaths= rulePaths EOF
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
    // InternalMyDsl.g:935:1: rulePaths returns [EObject current=null] : ( () ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= ',' otherlv_5= 'distance' ( (lv_distance_6_0= ruleEDouble ) ) ) ;
    public final EObject rulePaths() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_distance_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:941:2: ( ( () ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= ',' otherlv_5= 'distance' ( (lv_distance_6_0= ruleEDouble ) ) ) )
            // InternalMyDsl.g:942:2: ( () ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= ',' otherlv_5= 'distance' ( (lv_distance_6_0= ruleEDouble ) ) )
            {
            // InternalMyDsl.g:942:2: ( () ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= ',' otherlv_5= 'distance' ( (lv_distance_6_0= ruleEDouble ) ) )
            // InternalMyDsl.g:943:3: () ( ( ruleEString ) ) otherlv_2= 'to' ( ( ruleEString ) ) otherlv_4= ',' otherlv_5= 'distance' ( (lv_distance_6_0= ruleEDouble ) )
            {
            // InternalMyDsl.g:943:3: ()
            // InternalMyDsl.g:944:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPathsAccess().getPathsAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:950:3: ( ( ruleEString ) )
            // InternalMyDsl.g:951:4: ( ruleEString )
            {
            // InternalMyDsl.g:951:4: ( ruleEString )
            // InternalMyDsl.g:952:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPathsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPathsAccess().getLoc1LocationCrossReference_1_0());
            				
            pushFollow(FOLLOW_35);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,36,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getPathsAccess().getToKeyword_2());
            		
            // InternalMyDsl.g:970:3: ( ( ruleEString ) )
            // InternalMyDsl.g:971:4: ( ruleEString )
            {
            // InternalMyDsl.g:971:4: ( ruleEString )
            // InternalMyDsl.g:972:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPathsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPathsAccess().getLoc2LocationCrossReference_3_0());
            				
            pushFollow(FOLLOW_36);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_37); 

            			newLeafNode(otherlv_4, grammarAccess.getPathsAccess().getCommaKeyword_4());
            		
            otherlv_5=(Token)match(input,37,FOLLOW_32); 

            			newLeafNode(otherlv_5, grammarAccess.getPathsAccess().getDistanceKeyword_5());
            		
            // InternalMyDsl.g:994:3: ( (lv_distance_6_0= ruleEDouble ) )
            // InternalMyDsl.g:995:4: (lv_distance_6_0= ruleEDouble )
            {
            // InternalMyDsl.g:995:4: (lv_distance_6_0= ruleEDouble )
            // InternalMyDsl.g:996:5: lv_distance_6_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getPathsAccess().getDistanceEDoubleParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_distance_6_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathsRule());
            					}
            					set(
            						current,
            						"distance",
            						lv_distance_6_0,
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


    // $ANTLR start "entryRuleRobotsModel"
    // InternalMyDsl.g:1017:1: entryRuleRobotsModel returns [EObject current=null] : iv_ruleRobotsModel= ruleRobotsModel EOF ;
    public final EObject entryRuleRobotsModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRobotsModel = null;


        try {
            // InternalMyDsl.g:1017:52: (iv_ruleRobotsModel= ruleRobotsModel EOF )
            // InternalMyDsl.g:1018:2: iv_ruleRobotsModel= ruleRobotsModel EOF
            {
             newCompositeNode(grammarAccess.getRobotsModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRobotsModel=ruleRobotsModel();

            state._fsp--;

             current =iv_ruleRobotsModel; 
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
    // $ANTLR end "entryRuleRobotsModel"


    // $ANTLR start "ruleRobotsModel"
    // InternalMyDsl.g:1024:1: ruleRobotsModel returns [EObject current=null] : (otherlv_0= 'robots' otherlv_1= ':' ( (lv_robots_2_0= ruleRobot ) ) ( (lv_robots_3_0= ruleRobot ) )* ) ;
    public final EObject ruleRobotsModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_robots_2_0 = null;

        EObject lv_robots_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1030:2: ( (otherlv_0= 'robots' otherlv_1= ':' ( (lv_robots_2_0= ruleRobot ) ) ( (lv_robots_3_0= ruleRobot ) )* ) )
            // InternalMyDsl.g:1031:2: (otherlv_0= 'robots' otherlv_1= ':' ( (lv_robots_2_0= ruleRobot ) ) ( (lv_robots_3_0= ruleRobot ) )* )
            {
            // InternalMyDsl.g:1031:2: (otherlv_0= 'robots' otherlv_1= ':' ( (lv_robots_2_0= ruleRobot ) ) ( (lv_robots_3_0= ruleRobot ) )* )
            // InternalMyDsl.g:1032:3: otherlv_0= 'robots' otherlv_1= ':' ( (lv_robots_2_0= ruleRobot ) ) ( (lv_robots_3_0= ruleRobot ) )*
            {
            otherlv_0=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getRobotsModelAccess().getRobotsKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getRobotsModelAccess().getColonKeyword_1());
            		
            // InternalMyDsl.g:1040:3: ( (lv_robots_2_0= ruleRobot ) )
            // InternalMyDsl.g:1041:4: (lv_robots_2_0= ruleRobot )
            {
            // InternalMyDsl.g:1041:4: (lv_robots_2_0= ruleRobot )
            // InternalMyDsl.g:1042:5: lv_robots_2_0= ruleRobot
            {

            					newCompositeNode(grammarAccess.getRobotsModelAccess().getRobotsRobotParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_38);
            lv_robots_2_0=ruleRobot();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobotsModelRule());
            					}
            					add(
            						current,
            						"robots",
            						lv_robots_2_0,
            						"org.xtext.example.mydsl.MyDsl.Robot");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1059:3: ( (lv_robots_3_0= ruleRobot ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_ID)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMyDsl.g:1060:4: (lv_robots_3_0= ruleRobot )
            	    {
            	    // InternalMyDsl.g:1060:4: (lv_robots_3_0= ruleRobot )
            	    // InternalMyDsl.g:1061:5: lv_robots_3_0= ruleRobot
            	    {

            	    					newCompositeNode(grammarAccess.getRobotsModelAccess().getRobotsRobotParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_38);
            	    lv_robots_3_0=ruleRobot();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRobotsModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"robots",
            	    						lv_robots_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Robot");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // $ANTLR end "ruleRobotsModel"


    // $ANTLR start "entryRuleRobot"
    // InternalMyDsl.g:1082:1: entryRuleRobot returns [EObject current=null] : iv_ruleRobot= ruleRobot EOF ;
    public final EObject entryRuleRobot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRobot = null;


        try {
            // InternalMyDsl.g:1082:46: (iv_ruleRobot= ruleRobot EOF )
            // InternalMyDsl.g:1083:2: iv_ruleRobot= ruleRobot EOF
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
    // InternalMyDsl.g:1089:1: ruleRobot returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'at' otherlv_4= 'initial' otherlv_5= 'location' ( ( ruleEString ) ) otherlv_7= 'has' otherlv_8= 'velocity' ( (lv_velocity_9_0= ruleEDouble ) ) otherlv_10= 'can' otherlv_11= 'do' otherlv_12= '(' ( (lv_robots2tasksPerformance_13_0= ruleRobots2tasksPerformance ) ) (otherlv_14= ',' ( (lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance ) ) )* otherlv_16= ')' ) ;
    public final EObject ruleRobot() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_velocity_9_0 = null;

        EObject lv_robots2tasksPerformance_13_0 = null;

        EObject lv_robots2tasksPerformance_15_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1095:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'at' otherlv_4= 'initial' otherlv_5= 'location' ( ( ruleEString ) ) otherlv_7= 'has' otherlv_8= 'velocity' ( (lv_velocity_9_0= ruleEDouble ) ) otherlv_10= 'can' otherlv_11= 'do' otherlv_12= '(' ( (lv_robots2tasksPerformance_13_0= ruleRobots2tasksPerformance ) ) (otherlv_14= ',' ( (lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance ) ) )* otherlv_16= ')' ) )
            // InternalMyDsl.g:1096:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'at' otherlv_4= 'initial' otherlv_5= 'location' ( ( ruleEString ) ) otherlv_7= 'has' otherlv_8= 'velocity' ( (lv_velocity_9_0= ruleEDouble ) ) otherlv_10= 'can' otherlv_11= 'do' otherlv_12= '(' ( (lv_robots2tasksPerformance_13_0= ruleRobots2tasksPerformance ) ) (otherlv_14= ',' ( (lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance ) ) )* otherlv_16= ')' )
            {
            // InternalMyDsl.g:1096:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'at' otherlv_4= 'initial' otherlv_5= 'location' ( ( ruleEString ) ) otherlv_7= 'has' otherlv_8= 'velocity' ( (lv_velocity_9_0= ruleEDouble ) ) otherlv_10= 'can' otherlv_11= 'do' otherlv_12= '(' ( (lv_robots2tasksPerformance_13_0= ruleRobots2tasksPerformance ) ) (otherlv_14= ',' ( (lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance ) ) )* otherlv_16= ')' )
            // InternalMyDsl.g:1097:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'at' otherlv_4= 'initial' otherlv_5= 'location' ( ( ruleEString ) ) otherlv_7= 'has' otherlv_8= 'velocity' ( (lv_velocity_9_0= ruleEDouble ) ) otherlv_10= 'can' otherlv_11= 'do' otherlv_12= '(' ( (lv_robots2tasksPerformance_13_0= ruleRobots2tasksPerformance ) ) (otherlv_14= ',' ( (lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance ) ) )* otherlv_16= ')'
            {
            // InternalMyDsl.g:1097:3: ()
            // InternalMyDsl.g:1098:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRobotAccess().getRobotAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1104:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1105:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1105:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1106:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRobotAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobotRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getRobotAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,21,FOLLOW_40); 

            			newLeafNode(otherlv_3, grammarAccess.getRobotAccess().getAtKeyword_3());
            		
            otherlv_4=(Token)match(input,38,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getRobotAccess().getInitialKeyword_4());
            		
            otherlv_5=(Token)match(input,22,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getRobotAccess().getLocationKeyword_5());
            		
            // InternalMyDsl.g:1139:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1140:4: ( ruleEString )
            {
            // InternalMyDsl.g:1140:4: ( ruleEString )
            // InternalMyDsl.g:1141:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRobotRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRobotAccess().getInitLocLocationCrossReference_6_0());
            				
            pushFollow(FOLLOW_41);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,39,FOLLOW_42); 

            			newLeafNode(otherlv_7, grammarAccess.getRobotAccess().getHasKeyword_7());
            		
            otherlv_8=(Token)match(input,40,FOLLOW_32); 

            			newLeafNode(otherlv_8, grammarAccess.getRobotAccess().getVelocityKeyword_8());
            		
            // InternalMyDsl.g:1163:3: ( (lv_velocity_9_0= ruleEDouble ) )
            // InternalMyDsl.g:1164:4: (lv_velocity_9_0= ruleEDouble )
            {
            // InternalMyDsl.g:1164:4: (lv_velocity_9_0= ruleEDouble )
            // InternalMyDsl.g:1165:5: lv_velocity_9_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getRobotAccess().getVelocityEDoubleParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_43);
            lv_velocity_9_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobotRule());
            					}
            					set(
            						current,
            						"velocity",
            						lv_velocity_9_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,41,FOLLOW_44); 

            			newLeafNode(otherlv_10, grammarAccess.getRobotAccess().getCanKeyword_10());
            		
            otherlv_11=(Token)match(input,42,FOLLOW_30); 

            			newLeafNode(otherlv_11, grammarAccess.getRobotAccess().getDoKeyword_11());
            		
            otherlv_12=(Token)match(input,25,FOLLOW_6); 

            			newLeafNode(otherlv_12, grammarAccess.getRobotAccess().getLeftParenthesisKeyword_12());
            		
            // InternalMyDsl.g:1194:3: ( (lv_robots2tasksPerformance_13_0= ruleRobots2tasksPerformance ) )
            // InternalMyDsl.g:1195:4: (lv_robots2tasksPerformance_13_0= ruleRobots2tasksPerformance )
            {
            // InternalMyDsl.g:1195:4: (lv_robots2tasksPerformance_13_0= ruleRobots2tasksPerformance )
            // InternalMyDsl.g:1196:5: lv_robots2tasksPerformance_13_0= ruleRobots2tasksPerformance
            {

            					newCompositeNode(grammarAccess.getRobotAccess().getRobots2tasksPerformanceRobots2tasksPerformanceParserRuleCall_13_0());
            				
            pushFollow(FOLLOW_45);
            lv_robots2tasksPerformance_13_0=ruleRobots2tasksPerformance();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobotRule());
            					}
            					add(
            						current,
            						"robots2tasksPerformance",
            						lv_robots2tasksPerformance_13_0,
            						"org.xtext.example.mydsl.MyDsl.Robots2tasksPerformance");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1213:3: (otherlv_14= ',' ( (lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==30) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalMyDsl.g:1214:4: otherlv_14= ',' ( (lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance ) )
            	    {
            	    otherlv_14=(Token)match(input,30,FOLLOW_6); 

            	    				newLeafNode(otherlv_14, grammarAccess.getRobotAccess().getCommaKeyword_14_0());
            	    			
            	    // InternalMyDsl.g:1218:4: ( (lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance ) )
            	    // InternalMyDsl.g:1219:5: (lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance )
            	    {
            	    // InternalMyDsl.g:1219:5: (lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance )
            	    // InternalMyDsl.g:1220:6: lv_robots2tasksPerformance_15_0= ruleRobots2tasksPerformance
            	    {

            	    						newCompositeNode(grammarAccess.getRobotAccess().getRobots2tasksPerformanceRobots2tasksPerformanceParserRuleCall_14_1_0());
            	    					
            	    pushFollow(FOLLOW_45);
            	    lv_robots2tasksPerformance_15_0=ruleRobots2tasksPerformance();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRobotRule());
            	    						}
            	    						add(
            	    							current,
            	    							"robots2tasksPerformance",
            	    							lv_robots2tasksPerformance_15_0,
            	    							"org.xtext.example.mydsl.MyDsl.Robots2tasksPerformance");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_16=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getRobotAccess().getRightParenthesisKeyword_15());
            		

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


    // $ANTLR start "entryRuleRobots2tasksPerformance"
    // InternalMyDsl.g:1246:1: entryRuleRobots2tasksPerformance returns [EObject current=null] : iv_ruleRobots2tasksPerformance= ruleRobots2tasksPerformance EOF ;
    public final EObject entryRuleRobots2tasksPerformance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRobots2tasksPerformance = null;


        try {
            // InternalMyDsl.g:1246:64: (iv_ruleRobots2tasksPerformance= ruleRobots2tasksPerformance EOF )
            // InternalMyDsl.g:1247:2: iv_ruleRobots2tasksPerformance= ruleRobots2tasksPerformance EOF
            {
             newCompositeNode(grammarAccess.getRobots2tasksPerformanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRobots2tasksPerformance=ruleRobots2tasksPerformance();

            state._fsp--;

             current =iv_ruleRobots2tasksPerformance; 
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
    // $ANTLR end "entryRuleRobots2tasksPerformance"


    // $ANTLR start "ruleRobots2tasksPerformance"
    // InternalMyDsl.g:1253:1: ruleRobots2tasksPerformance returns [EObject current=null] : ( () ( ( ruleEString ) ) otherlv_2= '-' otherlv_3= 'time required' otherlv_4= ':' ( (lv_time_5_0= ruleEDouble ) ) otherlv_6= ',' otherlv_7= 'success' otherlv_8= 'probability' otherlv_9= ':' ( (lv_prob_10_0= ruleEDouble ) ) ) ;
    public final EObject ruleRobots2tasksPerformance() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_time_5_0 = null;

        AntlrDatatypeRuleToken lv_prob_10_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1259:2: ( ( () ( ( ruleEString ) ) otherlv_2= '-' otherlv_3= 'time required' otherlv_4= ':' ( (lv_time_5_0= ruleEDouble ) ) otherlv_6= ',' otherlv_7= 'success' otherlv_8= 'probability' otherlv_9= ':' ( (lv_prob_10_0= ruleEDouble ) ) ) )
            // InternalMyDsl.g:1260:2: ( () ( ( ruleEString ) ) otherlv_2= '-' otherlv_3= 'time required' otherlv_4= ':' ( (lv_time_5_0= ruleEDouble ) ) otherlv_6= ',' otherlv_7= 'success' otherlv_8= 'probability' otherlv_9= ':' ( (lv_prob_10_0= ruleEDouble ) ) )
            {
            // InternalMyDsl.g:1260:2: ( () ( ( ruleEString ) ) otherlv_2= '-' otherlv_3= 'time required' otherlv_4= ':' ( (lv_time_5_0= ruleEDouble ) ) otherlv_6= ',' otherlv_7= 'success' otherlv_8= 'probability' otherlv_9= ':' ( (lv_prob_10_0= ruleEDouble ) ) )
            // InternalMyDsl.g:1261:3: () ( ( ruleEString ) ) otherlv_2= '-' otherlv_3= 'time required' otherlv_4= ':' ( (lv_time_5_0= ruleEDouble ) ) otherlv_6= ',' otherlv_7= 'success' otherlv_8= 'probability' otherlv_9= ':' ( (lv_prob_10_0= ruleEDouble ) )
            {
            // InternalMyDsl.g:1261:3: ()
            // InternalMyDsl.g:1262:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRobots2tasksPerformanceAccess().getRobots2tasksPerformanceAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1268:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1269:4: ( ruleEString )
            {
            // InternalMyDsl.g:1269:4: ( ruleEString )
            // InternalMyDsl.g:1270:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRobots2tasksPerformanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRobots2tasksPerformanceAccess().getAtAtomicTaskCrossReference_1_0());
            				
            pushFollow(FOLLOW_46);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_47); 

            			newLeafNode(otherlv_2, grammarAccess.getRobots2tasksPerformanceAccess().getHyphenMinusKeyword_2());
            		
            otherlv_3=(Token)match(input,44,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getRobots2tasksPerformanceAccess().getTimeRequiredKeyword_3());
            		
            otherlv_4=(Token)match(input,14,FOLLOW_32); 

            			newLeafNode(otherlv_4, grammarAccess.getRobots2tasksPerformanceAccess().getColonKeyword_4());
            		
            // InternalMyDsl.g:1296:3: ( (lv_time_5_0= ruleEDouble ) )
            // InternalMyDsl.g:1297:4: (lv_time_5_0= ruleEDouble )
            {
            // InternalMyDsl.g:1297:4: (lv_time_5_0= ruleEDouble )
            // InternalMyDsl.g:1298:5: lv_time_5_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getRobots2tasksPerformanceAccess().getTimeEDoubleParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_36);
            lv_time_5_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobots2tasksPerformanceRule());
            					}
            					set(
            						current,
            						"time",
            						lv_time_5_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,30,FOLLOW_48); 

            			newLeafNode(otherlv_6, grammarAccess.getRobots2tasksPerformanceAccess().getCommaKeyword_6());
            		
            otherlv_7=(Token)match(input,45,FOLLOW_49); 

            			newLeafNode(otherlv_7, grammarAccess.getRobots2tasksPerformanceAccess().getSuccessKeyword_7());
            		
            otherlv_8=(Token)match(input,46,FOLLOW_5); 

            			newLeafNode(otherlv_8, grammarAccess.getRobots2tasksPerformanceAccess().getProbabilityKeyword_8());
            		
            otherlv_9=(Token)match(input,14,FOLLOW_32); 

            			newLeafNode(otherlv_9, grammarAccess.getRobots2tasksPerformanceAccess().getColonKeyword_9());
            		
            // InternalMyDsl.g:1331:3: ( (lv_prob_10_0= ruleEDouble ) )
            // InternalMyDsl.g:1332:4: (lv_prob_10_0= ruleEDouble )
            {
            // InternalMyDsl.g:1332:4: (lv_prob_10_0= ruleEDouble )
            // InternalMyDsl.g:1333:5: lv_prob_10_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getRobots2tasksPerformanceAccess().getProbEDoubleParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_2);
            lv_prob_10_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobots2tasksPerformanceRule());
            					}
            					set(
            						current,
            						"prob",
            						lv_prob_10_0,
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
    // $ANTLR end "ruleRobots2tasksPerformance"


    // $ANTLR start "entryRuleMission"
    // InternalMyDsl.g:1354:1: entryRuleMission returns [EObject current=null] : iv_ruleMission= ruleMission EOF ;
    public final EObject entryRuleMission() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMission = null;


        try {
            // InternalMyDsl.g:1354:48: (iv_ruleMission= ruleMission EOF )
            // InternalMyDsl.g:1355:2: iv_ruleMission= ruleMission EOF
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
    // InternalMyDsl.g:1361:1: ruleMission returns [EObject current=null] : (this_AtomicTaskNoLoc_0= ruleAtomicTaskNoLoc | this_AtomicTaskLoc_1= ruleAtomicTaskLoc | this_CompTaskNoLoc_2= ruleCompTaskNoLoc | this_CompTaskOneLoc_3= ruleCompTaskOneLoc | this_CompTaskListLoc_4= ruleCompTaskListLoc | this_CompTaskAtBut_5= ruleCompTaskAtBut | this_CompTaskStatedBut_6= ruleCompTaskStatedBut ) ;
    public final EObject ruleMission() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicTaskNoLoc_0 = null;

        EObject this_AtomicTaskLoc_1 = null;

        EObject this_CompTaskNoLoc_2 = null;

        EObject this_CompTaskOneLoc_3 = null;

        EObject this_CompTaskListLoc_4 = null;

        EObject this_CompTaskAtBut_5 = null;

        EObject this_CompTaskStatedBut_6 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1367:2: ( (this_AtomicTaskNoLoc_0= ruleAtomicTaskNoLoc | this_AtomicTaskLoc_1= ruleAtomicTaskLoc | this_CompTaskNoLoc_2= ruleCompTaskNoLoc | this_CompTaskOneLoc_3= ruleCompTaskOneLoc | this_CompTaskListLoc_4= ruleCompTaskListLoc | this_CompTaskAtBut_5= ruleCompTaskAtBut | this_CompTaskStatedBut_6= ruleCompTaskStatedBut ) )
            // InternalMyDsl.g:1368:2: (this_AtomicTaskNoLoc_0= ruleAtomicTaskNoLoc | this_AtomicTaskLoc_1= ruleAtomicTaskLoc | this_CompTaskNoLoc_2= ruleCompTaskNoLoc | this_CompTaskOneLoc_3= ruleCompTaskOneLoc | this_CompTaskListLoc_4= ruleCompTaskListLoc | this_CompTaskAtBut_5= ruleCompTaskAtBut | this_CompTaskStatedBut_6= ruleCompTaskStatedBut )
            {
            // InternalMyDsl.g:1368:2: (this_AtomicTaskNoLoc_0= ruleAtomicTaskNoLoc | this_AtomicTaskLoc_1= ruleAtomicTaskLoc | this_CompTaskNoLoc_2= ruleCompTaskNoLoc | this_CompTaskOneLoc_3= ruleCompTaskOneLoc | this_CompTaskListLoc_4= ruleCompTaskListLoc | this_CompTaskAtBut_5= ruleCompTaskAtBut | this_CompTaskStatedBut_6= ruleCompTaskStatedBut )
            int alt20=7;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalMyDsl.g:1369:3: this_AtomicTaskNoLoc_0= ruleAtomicTaskNoLoc
                    {

                    			newCompositeNode(grammarAccess.getMissionAccess().getAtomicTaskNoLocParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AtomicTaskNoLoc_0=ruleAtomicTaskNoLoc();

                    state._fsp--;


                    			current = this_AtomicTaskNoLoc_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1378:3: this_AtomicTaskLoc_1= ruleAtomicTaskLoc
                    {

                    			newCompositeNode(grammarAccess.getMissionAccess().getAtomicTaskLocParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AtomicTaskLoc_1=ruleAtomicTaskLoc();

                    state._fsp--;


                    			current = this_AtomicTaskLoc_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1387:3: this_CompTaskNoLoc_2= ruleCompTaskNoLoc
                    {

                    			newCompositeNode(grammarAccess.getMissionAccess().getCompTaskNoLocParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_CompTaskNoLoc_2=ruleCompTaskNoLoc();

                    state._fsp--;


                    			current = this_CompTaskNoLoc_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1396:3: this_CompTaskOneLoc_3= ruleCompTaskOneLoc
                    {

                    			newCompositeNode(grammarAccess.getMissionAccess().getCompTaskOneLocParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_CompTaskOneLoc_3=ruleCompTaskOneLoc();

                    state._fsp--;


                    			current = this_CompTaskOneLoc_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:1405:3: this_CompTaskListLoc_4= ruleCompTaskListLoc
                    {

                    			newCompositeNode(grammarAccess.getMissionAccess().getCompTaskListLocParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_CompTaskListLoc_4=ruleCompTaskListLoc();

                    state._fsp--;


                    			current = this_CompTaskListLoc_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:1414:3: this_CompTaskAtBut_5= ruleCompTaskAtBut
                    {

                    			newCompositeNode(grammarAccess.getMissionAccess().getCompTaskAtButParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_CompTaskAtBut_5=ruleCompTaskAtBut();

                    state._fsp--;


                    			current = this_CompTaskAtBut_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:1423:3: this_CompTaskStatedBut_6= ruleCompTaskStatedBut
                    {

                    			newCompositeNode(grammarAccess.getMissionAccess().getCompTaskStatedButParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_CompTaskStatedBut_6=ruleCompTaskStatedBut();

                    state._fsp--;


                    			current = this_CompTaskStatedBut_6;
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
    // $ANTLR end "ruleMission"


    // $ANTLR start "entryRuleAtomicTaskNoLoc"
    // InternalMyDsl.g:1435:1: entryRuleAtomicTaskNoLoc returns [EObject current=null] : iv_ruleAtomicTaskNoLoc= ruleAtomicTaskNoLoc EOF ;
    public final EObject entryRuleAtomicTaskNoLoc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicTaskNoLoc = null;


        try {
            // InternalMyDsl.g:1435:56: (iv_ruleAtomicTaskNoLoc= ruleAtomicTaskNoLoc EOF )
            // InternalMyDsl.g:1436:2: iv_ruleAtomicTaskNoLoc= ruleAtomicTaskNoLoc EOF
            {
             newCompositeNode(grammarAccess.getAtomicTaskNoLocRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtomicTaskNoLoc=ruleAtomicTaskNoLoc();

            state._fsp--;

             current =iv_ruleAtomicTaskNoLoc; 
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
    // $ANTLR end "entryRuleAtomicTaskNoLoc"


    // $ANTLR start "ruleAtomicTaskNoLoc"
    // InternalMyDsl.g:1442:1: ruleAtomicTaskNoLoc returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( ( ruleEString ) ) (otherlv_4= '(' ( (lv_description_5_0= ruleEString ) ) otherlv_6= ')' )? ) ;
    public final EObject ruleAtomicTaskNoLoc() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1448:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( ( ruleEString ) ) (otherlv_4= '(' ( (lv_description_5_0= ruleEString ) ) otherlv_6= ')' )? ) )
            // InternalMyDsl.g:1449:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( ( ruleEString ) ) (otherlv_4= '(' ( (lv_description_5_0= ruleEString ) ) otherlv_6= ')' )? )
            {
            // InternalMyDsl.g:1449:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( ( ruleEString ) ) (otherlv_4= '(' ( (lv_description_5_0= ruleEString ) ) otherlv_6= ')' )? )
            // InternalMyDsl.g:1450:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( ( ruleEString ) ) (otherlv_4= '(' ( (lv_description_5_0= ruleEString ) ) otherlv_6= ')' )?
            {
            // InternalMyDsl.g:1450:3: ()
            // InternalMyDsl.g:1451:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAtomicTaskNoLocAccess().getAtomicTaskNoLocAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1457:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1458:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1458:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1459:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAtomicTaskNoLocAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAtomicTaskNoLocRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getAtomicTaskNoLocAccess().getColonKeyword_2());
            		
            // InternalMyDsl.g:1480:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1481:4: ( ruleEString )
            {
            // InternalMyDsl.g:1481:4: ( ruleEString )
            // InternalMyDsl.g:1482:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAtomicTaskNoLocRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAtomicTaskNoLocAccess().getAtAtomicTaskCrossReference_3_0());
            				
            pushFollow(FOLLOW_20);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1496:3: (otherlv_4= '(' ( (lv_description_5_0= ruleEString ) ) otherlv_6= ')' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==25) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:1497:4: otherlv_4= '(' ( (lv_description_5_0= ruleEString ) ) otherlv_6= ')'
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getAtomicTaskNoLocAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalMyDsl.g:1501:4: ( (lv_description_5_0= ruleEString ) )
                    // InternalMyDsl.g:1502:5: (lv_description_5_0= ruleEString )
                    {
                    // InternalMyDsl.g:1502:5: (lv_description_5_0= ruleEString )
                    // InternalMyDsl.g:1503:6: lv_description_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getAtomicTaskNoLocAccess().getDescriptionEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_description_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicTaskNoLocRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_5_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getAtomicTaskNoLocAccess().getRightParenthesisKeyword_4_2());
                    			

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
    // $ANTLR end "ruleAtomicTaskNoLoc"


    // $ANTLR start "entryRuleAtomicTaskLoc"
    // InternalMyDsl.g:1529:1: entryRuleAtomicTaskLoc returns [EObject current=null] : iv_ruleAtomicTaskLoc= ruleAtomicTaskLoc EOF ;
    public final EObject entryRuleAtomicTaskLoc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicTaskLoc = null;


        try {
            // InternalMyDsl.g:1529:54: (iv_ruleAtomicTaskLoc= ruleAtomicTaskLoc EOF )
            // InternalMyDsl.g:1530:2: iv_ruleAtomicTaskLoc= ruleAtomicTaskLoc EOF
            {
             newCompositeNode(grammarAccess.getAtomicTaskLocRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtomicTaskLoc=ruleAtomicTaskLoc();

            state._fsp--;

             current =iv_ruleAtomicTaskLoc; 
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
    // $ANTLR end "entryRuleAtomicTaskLoc"


    // $ANTLR start "ruleAtomicTaskLoc"
    // InternalMyDsl.g:1536:1: ruleAtomicTaskLoc returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) (otherlv_8= '(' ( (lv_description_9_0= ruleEString ) ) otherlv_10= ')' )? ) ;
    public final EObject ruleAtomicTaskLoc() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_9_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1542:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) (otherlv_8= '(' ( (lv_description_9_0= ruleEString ) ) otherlv_10= ')' )? ) )
            // InternalMyDsl.g:1543:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) (otherlv_8= '(' ( (lv_description_9_0= ruleEString ) ) otherlv_10= ')' )? )
            {
            // InternalMyDsl.g:1543:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) (otherlv_8= '(' ( (lv_description_9_0= ruleEString ) ) otherlv_10= ')' )? )
            // InternalMyDsl.g:1544:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'atomic' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) (otherlv_8= '(' ( (lv_description_9_0= ruleEString ) ) otherlv_10= ')' )?
            {
            // InternalMyDsl.g:1544:3: ()
            // InternalMyDsl.g:1545:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAtomicTaskLocAccess().getAtomicTaskLocAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1551:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1552:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1552:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1553:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAtomicTaskLocAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAtomicTaskLocRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getAtomicTaskLocAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,47,FOLLOW_51); 

            			newLeafNode(otherlv_3, grammarAccess.getAtomicTaskLocAccess().getAtomicKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getAtomicTaskLocAccess().getTaskKeyword_4());
            		
            // InternalMyDsl.g:1582:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1583:4: ( ruleEString )
            {
            // InternalMyDsl.g:1583:4: ( ruleEString )
            // InternalMyDsl.g:1584:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAtomicTaskLocRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAtomicTaskLocAccess().getAtAtomicTaskCrossReference_5_0());
            				
            pushFollow(FOLLOW_39);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getAtomicTaskLocAccess().getAtKeyword_6());
            		
            // InternalMyDsl.g:1602:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1603:4: ( ruleEString )
            {
            // InternalMyDsl.g:1603:4: ( ruleEString )
            // InternalMyDsl.g:1604:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAtomicTaskLocRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAtomicTaskLocAccess().getLocLocationCrossReference_7_0());
            				
            pushFollow(FOLLOW_20);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1618:3: (otherlv_8= '(' ( (lv_description_9_0= ruleEString ) ) otherlv_10= ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==25) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMyDsl.g:1619:4: otherlv_8= '(' ( (lv_description_9_0= ruleEString ) ) otherlv_10= ')'
                    {
                    otherlv_8=(Token)match(input,25,FOLLOW_6); 

                    				newLeafNode(otherlv_8, grammarAccess.getAtomicTaskLocAccess().getLeftParenthesisKeyword_8_0());
                    			
                    // InternalMyDsl.g:1623:4: ( (lv_description_9_0= ruleEString ) )
                    // InternalMyDsl.g:1624:5: (lv_description_9_0= ruleEString )
                    {
                    // InternalMyDsl.g:1624:5: (lv_description_9_0= ruleEString )
                    // InternalMyDsl.g:1625:6: lv_description_9_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getAtomicTaskLocAccess().getDescriptionEStringParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_description_9_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicTaskLocRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_9_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getAtomicTaskLocAccess().getRightParenthesisKeyword_8_2());
                    			

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
    // $ANTLR end "ruleAtomicTaskLoc"


    // $ANTLR start "entryRuleCompTaskNoLoc"
    // InternalMyDsl.g:1651:1: entryRuleCompTaskNoLoc returns [EObject current=null] : iv_ruleCompTaskNoLoc= ruleCompTaskNoLoc EOF ;
    public final EObject entryRuleCompTaskNoLoc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompTaskNoLoc = null;


        try {
            // InternalMyDsl.g:1651:54: (iv_ruleCompTaskNoLoc= ruleCompTaskNoLoc EOF )
            // InternalMyDsl.g:1652:2: iv_ruleCompTaskNoLoc= ruleCompTaskNoLoc EOF
            {
             newCompositeNode(grammarAccess.getCompTaskNoLocRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompTaskNoLoc=ruleCompTaskNoLoc();

            state._fsp--;

             current =iv_ruleCompTaskNoLoc; 
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
    // $ANTLR end "entryRuleCompTaskNoLoc"


    // $ANTLR start "ruleCompTaskNoLoc"
    // InternalMyDsl.g:1658:1: ruleCompTaskNoLoc returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) (otherlv_6= '-' otherlv_7= 'criticality' ( (lv_criticality_8_0= ruleEString ) ) )? (otherlv_9= '(' ( (lv_description_10_0= ruleEString ) ) otherlv_11= ')' )? ) ;
    public final EObject ruleCompTaskNoLoc() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_criticality_8_0 = null;

        AntlrDatatypeRuleToken lv_description_10_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1664:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) (otherlv_6= '-' otherlv_7= 'criticality' ( (lv_criticality_8_0= ruleEString ) ) )? (otherlv_9= '(' ( (lv_description_10_0= ruleEString ) ) otherlv_11= ')' )? ) )
            // InternalMyDsl.g:1665:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) (otherlv_6= '-' otherlv_7= 'criticality' ( (lv_criticality_8_0= ruleEString ) ) )? (otherlv_9= '(' ( (lv_description_10_0= ruleEString ) ) otherlv_11= ')' )? )
            {
            // InternalMyDsl.g:1665:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) (otherlv_6= '-' otherlv_7= 'criticality' ( (lv_criticality_8_0= ruleEString ) ) )? (otherlv_9= '(' ( (lv_description_10_0= ruleEString ) ) otherlv_11= ')' )? )
            // InternalMyDsl.g:1666:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) (otherlv_6= '-' otherlv_7= 'criticality' ( (lv_criticality_8_0= ruleEString ) ) )? (otherlv_9= '(' ( (lv_description_10_0= ruleEString ) ) otherlv_11= ')' )?
            {
            // InternalMyDsl.g:1666:3: ()
            // InternalMyDsl.g:1667:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompTaskNoLocAccess().getCompTaskNoLocAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1673:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1674:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1674:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1675:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCompTaskNoLocAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompTaskNoLocRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getCompTaskNoLocAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,49,FOLLOW_51); 

            			newLeafNode(otherlv_3, grammarAccess.getCompTaskNoLocAccess().getCompoundKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getCompTaskNoLocAccess().getTaskKeyword_4());
            		
            // InternalMyDsl.g:1704:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1705:4: ( ruleEString )
            {
            // InternalMyDsl.g:1705:4: ( ruleEString )
            // InternalMyDsl.g:1706:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompTaskNoLocRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCompTaskNoLocAccess().getCtCompoundTaskCrossReference_5_0());
            				
            pushFollow(FOLLOW_53);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1720:3: (otherlv_6= '-' otherlv_7= 'criticality' ( (lv_criticality_8_0= ruleEString ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==43) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:1721:4: otherlv_6= '-' otherlv_7= 'criticality' ( (lv_criticality_8_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,43,FOLLOW_18); 

                    				newLeafNode(otherlv_6, grammarAccess.getCompTaskNoLocAccess().getHyphenMinusKeyword_6_0());
                    			
                    otherlv_7=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getCompTaskNoLocAccess().getCriticalityKeyword_6_1());
                    			
                    // InternalMyDsl.g:1729:4: ( (lv_criticality_8_0= ruleEString ) )
                    // InternalMyDsl.g:1730:5: (lv_criticality_8_0= ruleEString )
                    {
                    // InternalMyDsl.g:1730:5: (lv_criticality_8_0= ruleEString )
                    // InternalMyDsl.g:1731:6: lv_criticality_8_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompTaskNoLocAccess().getCriticalityEStringParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_criticality_8_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompTaskNoLocRule());
                    						}
                    						set(
                    							current,
                    							"criticality",
                    							lv_criticality_8_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1749:3: (otherlv_9= '(' ( (lv_description_10_0= ruleEString ) ) otherlv_11= ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==25) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMyDsl.g:1750:4: otherlv_9= '(' ( (lv_description_10_0= ruleEString ) ) otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,25,FOLLOW_6); 

                    				newLeafNode(otherlv_9, grammarAccess.getCompTaskNoLocAccess().getLeftParenthesisKeyword_7_0());
                    			
                    // InternalMyDsl.g:1754:4: ( (lv_description_10_0= ruleEString ) )
                    // InternalMyDsl.g:1755:5: (lv_description_10_0= ruleEString )
                    {
                    // InternalMyDsl.g:1755:5: (lv_description_10_0= ruleEString )
                    // InternalMyDsl.g:1756:6: lv_description_10_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompTaskNoLocAccess().getDescriptionEStringParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_description_10_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompTaskNoLocRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_10_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getCompTaskNoLocAccess().getRightParenthesisKeyword_7_2());
                    			

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
    // $ANTLR end "ruleCompTaskNoLoc"


    // $ANTLR start "entryRuleCompTaskOneLoc"
    // InternalMyDsl.g:1782:1: entryRuleCompTaskOneLoc returns [EObject current=null] : iv_ruleCompTaskOneLoc= ruleCompTaskOneLoc EOF ;
    public final EObject entryRuleCompTaskOneLoc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompTaskOneLoc = null;


        try {
            // InternalMyDsl.g:1782:55: (iv_ruleCompTaskOneLoc= ruleCompTaskOneLoc EOF )
            // InternalMyDsl.g:1783:2: iv_ruleCompTaskOneLoc= ruleCompTaskOneLoc EOF
            {
             newCompositeNode(grammarAccess.getCompTaskOneLocRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompTaskOneLoc=ruleCompTaskOneLoc();

            state._fsp--;

             current =iv_ruleCompTaskOneLoc; 
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
    // $ANTLR end "entryRuleCompTaskOneLoc"


    // $ANTLR start "ruleCompTaskOneLoc"
    // InternalMyDsl.g:1789:1: ruleCompTaskOneLoc returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) (otherlv_8= '-' otherlv_9= 'criticality' ( (lv_criticality_10_0= ruleEString ) ) )? (otherlv_11= '(' ( (lv_description_12_0= ruleEString ) ) otherlv_13= ')' )? ) ;
    public final EObject ruleCompTaskOneLoc() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_criticality_10_0 = null;

        AntlrDatatypeRuleToken lv_description_12_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1795:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) (otherlv_8= '-' otherlv_9= 'criticality' ( (lv_criticality_10_0= ruleEString ) ) )? (otherlv_11= '(' ( (lv_description_12_0= ruleEString ) ) otherlv_13= ')' )? ) )
            // InternalMyDsl.g:1796:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) (otherlv_8= '-' otherlv_9= 'criticality' ( (lv_criticality_10_0= ruleEString ) ) )? (otherlv_11= '(' ( (lv_description_12_0= ruleEString ) ) otherlv_13= ')' )? )
            {
            // InternalMyDsl.g:1796:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) (otherlv_8= '-' otherlv_9= 'criticality' ( (lv_criticality_10_0= ruleEString ) ) )? (otherlv_11= '(' ( (lv_description_12_0= ruleEString ) ) otherlv_13= ')' )? )
            // InternalMyDsl.g:1797:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) (otherlv_8= '-' otherlv_9= 'criticality' ( (lv_criticality_10_0= ruleEString ) ) )? (otherlv_11= '(' ( (lv_description_12_0= ruleEString ) ) otherlv_13= ')' )?
            {
            // InternalMyDsl.g:1797:3: ()
            // InternalMyDsl.g:1798:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompTaskOneLocAccess().getCompTaskOneLocAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1804:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1805:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1805:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1806:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCompTaskOneLocAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompTaskOneLocRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getCompTaskOneLocAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,49,FOLLOW_51); 

            			newLeafNode(otherlv_3, grammarAccess.getCompTaskOneLocAccess().getCompoundKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getCompTaskOneLocAccess().getTaskKeyword_4());
            		
            // InternalMyDsl.g:1835:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1836:4: ( ruleEString )
            {
            // InternalMyDsl.g:1836:4: ( ruleEString )
            // InternalMyDsl.g:1837:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompTaskOneLocRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCompTaskOneLocAccess().getCtCompoundTaskCrossReference_5_0());
            				
            pushFollow(FOLLOW_39);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getCompTaskOneLocAccess().getAtKeyword_6());
            		
            // InternalMyDsl.g:1855:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1856:4: ( ruleEString )
            {
            // InternalMyDsl.g:1856:4: ( ruleEString )
            // InternalMyDsl.g:1857:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompTaskOneLocRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCompTaskOneLocAccess().getLocLocationCrossReference_7_0());
            				
            pushFollow(FOLLOW_53);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1871:3: (otherlv_8= '-' otherlv_9= 'criticality' ( (lv_criticality_10_0= ruleEString ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==43) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMyDsl.g:1872:4: otherlv_8= '-' otherlv_9= 'criticality' ( (lv_criticality_10_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,43,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getCompTaskOneLocAccess().getHyphenMinusKeyword_8_0());
                    			
                    otherlv_9=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_9, grammarAccess.getCompTaskOneLocAccess().getCriticalityKeyword_8_1());
                    			
                    // InternalMyDsl.g:1880:4: ( (lv_criticality_10_0= ruleEString ) )
                    // InternalMyDsl.g:1881:5: (lv_criticality_10_0= ruleEString )
                    {
                    // InternalMyDsl.g:1881:5: (lv_criticality_10_0= ruleEString )
                    // InternalMyDsl.g:1882:6: lv_criticality_10_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompTaskOneLocAccess().getCriticalityEStringParserRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_criticality_10_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompTaskOneLocRule());
                    						}
                    						set(
                    							current,
                    							"criticality",
                    							lv_criticality_10_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1900:3: (otherlv_11= '(' ( (lv_description_12_0= ruleEString ) ) otherlv_13= ')' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==25) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMyDsl.g:1901:4: otherlv_11= '(' ( (lv_description_12_0= ruleEString ) ) otherlv_13= ')'
                    {
                    otherlv_11=(Token)match(input,25,FOLLOW_6); 

                    				newLeafNode(otherlv_11, grammarAccess.getCompTaskOneLocAccess().getLeftParenthesisKeyword_9_0());
                    			
                    // InternalMyDsl.g:1905:4: ( (lv_description_12_0= ruleEString ) )
                    // InternalMyDsl.g:1906:5: (lv_description_12_0= ruleEString )
                    {
                    // InternalMyDsl.g:1906:5: (lv_description_12_0= ruleEString )
                    // InternalMyDsl.g:1907:6: lv_description_12_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompTaskOneLocAccess().getDescriptionEStringParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_description_12_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompTaskOneLocRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_12_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getCompTaskOneLocAccess().getRightParenthesisKeyword_9_2());
                    			

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
    // $ANTLR end "ruleCompTaskOneLoc"


    // $ANTLR start "entryRuleCompTaskListLoc"
    // InternalMyDsl.g:1933:1: entryRuleCompTaskListLoc returns [EObject current=null] : iv_ruleCompTaskListLoc= ruleCompTaskListLoc EOF ;
    public final EObject entryRuleCompTaskListLoc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompTaskListLoc = null;


        try {
            // InternalMyDsl.g:1933:56: (iv_ruleCompTaskListLoc= ruleCompTaskListLoc EOF )
            // InternalMyDsl.g:1934:2: iv_ruleCompTaskListLoc= ruleCompTaskListLoc EOF
            {
             newCompositeNode(grammarAccess.getCompTaskListLocRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompTaskListLoc=ruleCompTaskListLoc();

            state._fsp--;

             current =iv_ruleCompTaskListLoc; 
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
    // $ANTLR end "entryRuleCompTaskListLoc"


    // $ANTLR start "ruleCompTaskListLoc"
    // InternalMyDsl.g:1940:1: ruleCompTaskListLoc returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' otherlv_7= '[' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ']' (otherlv_12= '-' otherlv_13= 'criticality' ( (lv_criticality_14_0= ruleEString ) ) )? (otherlv_15= '(' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )? ) ;
    public final EObject ruleCompTaskListLoc() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_criticality_14_0 = null;

        AntlrDatatypeRuleToken lv_description_16_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1946:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' otherlv_7= '[' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ']' (otherlv_12= '-' otherlv_13= 'criticality' ( (lv_criticality_14_0= ruleEString ) ) )? (otherlv_15= '(' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )? ) )
            // InternalMyDsl.g:1947:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' otherlv_7= '[' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ']' (otherlv_12= '-' otherlv_13= 'criticality' ( (lv_criticality_14_0= ruleEString ) ) )? (otherlv_15= '(' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )? )
            {
            // InternalMyDsl.g:1947:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' otherlv_7= '[' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ']' (otherlv_12= '-' otherlv_13= 'criticality' ( (lv_criticality_14_0= ruleEString ) ) )? (otherlv_15= '(' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )? )
            // InternalMyDsl.g:1948:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' otherlv_7= '[' ( ( ruleEString ) ) (otherlv_9= ',' ( ( ruleEString ) ) )* otherlv_11= ']' (otherlv_12= '-' otherlv_13= 'criticality' ( (lv_criticality_14_0= ruleEString ) ) )? (otherlv_15= '(' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )?
            {
            // InternalMyDsl.g:1948:3: ()
            // InternalMyDsl.g:1949:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompTaskListLocAccess().getCompTaskListLocAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1955:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1956:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1956:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1957:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCompTaskListLocAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompTaskListLocRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getCompTaskListLocAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,49,FOLLOW_51); 

            			newLeafNode(otherlv_3, grammarAccess.getCompTaskListLocAccess().getCompoundKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getCompTaskListLocAccess().getTaskKeyword_4());
            		
            // InternalMyDsl.g:1986:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1987:4: ( ruleEString )
            {
            // InternalMyDsl.g:1987:4: ( ruleEString )
            // InternalMyDsl.g:1988:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompTaskListLocRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCompTaskListLocAccess().getCtCompoundTaskCrossReference_5_0());
            				
            pushFollow(FOLLOW_39);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_24); 

            			newLeafNode(otherlv_6, grammarAccess.getCompTaskListLocAccess().getAtKeyword_6());
            		
            otherlv_7=(Token)match(input,29,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getCompTaskListLocAccess().getLeftSquareBracketKeyword_7());
            		
            // InternalMyDsl.g:2010:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2011:4: ( ruleEString )
            {
            // InternalMyDsl.g:2011:4: ( ruleEString )
            // InternalMyDsl.g:2012:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompTaskListLocRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCompTaskListLocAccess().getLocationListLocationCrossReference_8_0());
            				
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:2026:3: (otherlv_9= ',' ( ( ruleEString ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==30) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalMyDsl.g:2027:4: otherlv_9= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_9=(Token)match(input,30,FOLLOW_6); 

            	    				newLeafNode(otherlv_9, grammarAccess.getCompTaskListLocAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalMyDsl.g:2031:4: ( ( ruleEString ) )
            	    // InternalMyDsl.g:2032:5: ( ruleEString )
            	    {
            	    // InternalMyDsl.g:2032:5: ( ruleEString )
            	    // InternalMyDsl.g:2033:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getCompTaskListLocRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getCompTaskListLocAccess().getLocationListLocationCrossReference_9_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_11=(Token)match(input,31,FOLLOW_53); 

            			newLeafNode(otherlv_11, grammarAccess.getCompTaskListLocAccess().getRightSquareBracketKeyword_10());
            		
            // InternalMyDsl.g:2052:3: (otherlv_12= '-' otherlv_13= 'criticality' ( (lv_criticality_14_0= ruleEString ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==43) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMyDsl.g:2053:4: otherlv_12= '-' otherlv_13= 'criticality' ( (lv_criticality_14_0= ruleEString ) )
                    {
                    otherlv_12=(Token)match(input,43,FOLLOW_18); 

                    				newLeafNode(otherlv_12, grammarAccess.getCompTaskListLocAccess().getHyphenMinusKeyword_11_0());
                    			
                    otherlv_13=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_13, grammarAccess.getCompTaskListLocAccess().getCriticalityKeyword_11_1());
                    			
                    // InternalMyDsl.g:2061:4: ( (lv_criticality_14_0= ruleEString ) )
                    // InternalMyDsl.g:2062:5: (lv_criticality_14_0= ruleEString )
                    {
                    // InternalMyDsl.g:2062:5: (lv_criticality_14_0= ruleEString )
                    // InternalMyDsl.g:2063:6: lv_criticality_14_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompTaskListLocAccess().getCriticalityEStringParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_criticality_14_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompTaskListLocRule());
                    						}
                    						set(
                    							current,
                    							"criticality",
                    							lv_criticality_14_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:2081:3: (otherlv_15= '(' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==25) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMyDsl.g:2082:4: otherlv_15= '(' ( (lv_description_16_0= ruleEString ) ) otherlv_17= ')'
                    {
                    otherlv_15=(Token)match(input,25,FOLLOW_6); 

                    				newLeafNode(otherlv_15, grammarAccess.getCompTaskListLocAccess().getLeftParenthesisKeyword_12_0());
                    			
                    // InternalMyDsl.g:2086:4: ( (lv_description_16_0= ruleEString ) )
                    // InternalMyDsl.g:2087:5: (lv_description_16_0= ruleEString )
                    {
                    // InternalMyDsl.g:2087:5: (lv_description_16_0= ruleEString )
                    // InternalMyDsl.g:2088:6: lv_description_16_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompTaskListLocAccess().getDescriptionEStringParserRuleCall_12_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_description_16_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompTaskListLocRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_16_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getCompTaskListLocAccess().getRightParenthesisKeyword_12_2());
                    			

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
    // $ANTLR end "ruleCompTaskListLoc"


    // $ANTLR start "entryRuleCompTaskAtBut"
    // InternalMyDsl.g:2114:1: entryRuleCompTaskAtBut returns [EObject current=null] : iv_ruleCompTaskAtBut= ruleCompTaskAtBut EOF ;
    public final EObject entryRuleCompTaskAtBut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompTaskAtBut = null;


        try {
            // InternalMyDsl.g:2114:54: (iv_ruleCompTaskAtBut= ruleCompTaskAtBut EOF )
            // InternalMyDsl.g:2115:2: iv_ruleCompTaskAtBut= ruleCompTaskAtBut EOF
            {
             newCompositeNode(grammarAccess.getCompTaskAtButRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompTaskAtBut=ruleCompTaskAtBut();

            state._fsp--;

             current =iv_ruleCompTaskAtBut; 
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
    // $ANTLR end "entryRuleCompTaskAtBut"


    // $ANTLR start "ruleCompTaskAtBut"
    // InternalMyDsl.g:2121:1: ruleCompTaskAtBut returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) otherlv_8= 'but' otherlv_9= '[' ( (lv_locationList_10_0= ruleLocationOrSpace ) ) (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )* otherlv_13= ']' (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )? (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )? ) ;
    public final EObject ruleCompTaskAtBut() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_locationList_10_0 = null;

        EObject lv_locationList_12_0 = null;

        AntlrDatatypeRuleToken lv_criticality_16_0 = null;

        AntlrDatatypeRuleToken lv_description_18_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2127:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) otherlv_8= 'but' otherlv_9= '[' ( (lv_locationList_10_0= ruleLocationOrSpace ) ) (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )* otherlv_13= ']' (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )? (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )? ) )
            // InternalMyDsl.g:2128:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) otherlv_8= 'but' otherlv_9= '[' ( (lv_locationList_10_0= ruleLocationOrSpace ) ) (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )* otherlv_13= ']' (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )? (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )? )
            {
            // InternalMyDsl.g:2128:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) otherlv_8= 'but' otherlv_9= '[' ( (lv_locationList_10_0= ruleLocationOrSpace ) ) (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )* otherlv_13= ']' (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )? (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )? )
            // InternalMyDsl.g:2129:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'at' ( ( ruleEString ) ) otherlv_8= 'but' otherlv_9= '[' ( (lv_locationList_10_0= ruleLocationOrSpace ) ) (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )* otherlv_13= ']' (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )? (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )?
            {
            // InternalMyDsl.g:2129:3: ()
            // InternalMyDsl.g:2130:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompTaskAtButAccess().getCompTaskAtButAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:2136:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2137:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2137:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2138:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCompTaskAtButAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompTaskAtButRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getCompTaskAtButAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,49,FOLLOW_51); 

            			newLeafNode(otherlv_3, grammarAccess.getCompTaskAtButAccess().getCompoundKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getCompTaskAtButAccess().getTaskKeyword_4());
            		
            // InternalMyDsl.g:2167:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2168:4: ( ruleEString )
            {
            // InternalMyDsl.g:2168:4: ( ruleEString )
            // InternalMyDsl.g:2169:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompTaskAtButRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCompTaskAtButAccess().getCtCompoundTaskCrossReference_5_0());
            				
            pushFollow(FOLLOW_39);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getCompTaskAtButAccess().getAtKeyword_6());
            		
            // InternalMyDsl.g:2187:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2188:4: ( ruleEString )
            {
            // InternalMyDsl.g:2188:4: ( ruleEString )
            // InternalMyDsl.g:2189:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompTaskAtButRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCompTaskAtButAccess().getLocLocationCrossReference_7_0());
            				
            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,50,FOLLOW_24); 

            			newLeafNode(otherlv_8, grammarAccess.getCompTaskAtButAccess().getButKeyword_8());
            		
            otherlv_9=(Token)match(input,29,FOLLOW_55); 

            			newLeafNode(otherlv_9, grammarAccess.getCompTaskAtButAccess().getLeftSquareBracketKeyword_9());
            		
            // InternalMyDsl.g:2211:3: ( (lv_locationList_10_0= ruleLocationOrSpace ) )
            // InternalMyDsl.g:2212:4: (lv_locationList_10_0= ruleLocationOrSpace )
            {
            // InternalMyDsl.g:2212:4: (lv_locationList_10_0= ruleLocationOrSpace )
            // InternalMyDsl.g:2213:5: lv_locationList_10_0= ruleLocationOrSpace
            {

            					newCompositeNode(grammarAccess.getCompTaskAtButAccess().getLocationListLocationOrSpaceParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_25);
            lv_locationList_10_0=ruleLocationOrSpace();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompTaskAtButRule());
            					}
            					add(
            						current,
            						"locationList",
            						lv_locationList_10_0,
            						"org.xtext.example.mydsl.MyDsl.LocationOrSpace");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:2230:3: (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==30) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalMyDsl.g:2231:4: otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) )
            	    {
            	    otherlv_11=(Token)match(input,30,FOLLOW_55); 

            	    				newLeafNode(otherlv_11, grammarAccess.getCompTaskAtButAccess().getCommaKeyword_11_0());
            	    			
            	    // InternalMyDsl.g:2235:4: ( (lv_locationList_12_0= ruleLocationOrSpace ) )
            	    // InternalMyDsl.g:2236:5: (lv_locationList_12_0= ruleLocationOrSpace )
            	    {
            	    // InternalMyDsl.g:2236:5: (lv_locationList_12_0= ruleLocationOrSpace )
            	    // InternalMyDsl.g:2237:6: lv_locationList_12_0= ruleLocationOrSpace
            	    {

            	    						newCompositeNode(grammarAccess.getCompTaskAtButAccess().getLocationListLocationOrSpaceParserRuleCall_11_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    lv_locationList_12_0=ruleLocationOrSpace();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCompTaskAtButRule());
            	    						}
            	    						add(
            	    							current,
            	    							"locationList",
            	    							lv_locationList_12_0,
            	    							"org.xtext.example.mydsl.MyDsl.LocationOrSpace");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_13=(Token)match(input,31,FOLLOW_53); 

            			newLeafNode(otherlv_13, grammarAccess.getCompTaskAtButAccess().getRightSquareBracketKeyword_12());
            		
            // InternalMyDsl.g:2259:3: (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==43) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMyDsl.g:2260:4: otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) )
                    {
                    otherlv_14=(Token)match(input,43,FOLLOW_18); 

                    				newLeafNode(otherlv_14, grammarAccess.getCompTaskAtButAccess().getHyphenMinusKeyword_13_0());
                    			
                    otherlv_15=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_15, grammarAccess.getCompTaskAtButAccess().getCriticalityKeyword_13_1());
                    			
                    // InternalMyDsl.g:2268:4: ( (lv_criticality_16_0= ruleEString ) )
                    // InternalMyDsl.g:2269:5: (lv_criticality_16_0= ruleEString )
                    {
                    // InternalMyDsl.g:2269:5: (lv_criticality_16_0= ruleEString )
                    // InternalMyDsl.g:2270:6: lv_criticality_16_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompTaskAtButAccess().getCriticalityEStringParserRuleCall_13_2_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_criticality_16_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompTaskAtButRule());
                    						}
                    						set(
                    							current,
                    							"criticality",
                    							lv_criticality_16_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:2288:3: (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:2289:4: otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')'
                    {
                    otherlv_17=(Token)match(input,25,FOLLOW_6); 

                    				newLeafNode(otherlv_17, grammarAccess.getCompTaskAtButAccess().getLeftParenthesisKeyword_14_0());
                    			
                    // InternalMyDsl.g:2293:4: ( (lv_description_18_0= ruleEString ) )
                    // InternalMyDsl.g:2294:5: (lv_description_18_0= ruleEString )
                    {
                    // InternalMyDsl.g:2294:5: (lv_description_18_0= ruleEString )
                    // InternalMyDsl.g:2295:6: lv_description_18_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompTaskAtButAccess().getDescriptionEStringParserRuleCall_14_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_description_18_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompTaskAtButRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_18_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_19=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getCompTaskAtButAccess().getRightParenthesisKeyword_14_2());
                    			

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
    // $ANTLR end "ruleCompTaskAtBut"


    // $ANTLR start "entryRuleCompTaskStatedBut"
    // InternalMyDsl.g:2321:1: entryRuleCompTaskStatedBut returns [EObject current=null] : iv_ruleCompTaskStatedBut= ruleCompTaskStatedBut EOF ;
    public final EObject entryRuleCompTaskStatedBut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompTaskStatedBut = null;


        try {
            // InternalMyDsl.g:2321:58: (iv_ruleCompTaskStatedBut= ruleCompTaskStatedBut EOF )
            // InternalMyDsl.g:2322:2: iv_ruleCompTaskStatedBut= ruleCompTaskStatedBut EOF
            {
             newCompositeNode(grammarAccess.getCompTaskStatedButRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompTaskStatedBut=ruleCompTaskStatedBut();

            state._fsp--;

             current =iv_ruleCompTaskStatedBut; 
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
    // $ANTLR end "entryRuleCompTaskStatedBut"


    // $ANTLR start "ruleCompTaskStatedBut"
    // InternalMyDsl.g:2328:1: ruleCompTaskStatedBut returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'as' otherlv_7= 'specified' otherlv_8= 'but' otherlv_9= '[' ( (lv_locationList_10_0= ruleLocationOrSpace ) ) (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )* otherlv_13= ']' (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )? (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )? ) ;
    public final EObject ruleCompTaskStatedBut() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_locationList_10_0 = null;

        EObject lv_locationList_12_0 = null;

        AntlrDatatypeRuleToken lv_criticality_16_0 = null;

        AntlrDatatypeRuleToken lv_description_18_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2334:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'as' otherlv_7= 'specified' otherlv_8= 'but' otherlv_9= '[' ( (lv_locationList_10_0= ruleLocationOrSpace ) ) (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )* otherlv_13= ']' (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )? (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )? ) )
            // InternalMyDsl.g:2335:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'as' otherlv_7= 'specified' otherlv_8= 'but' otherlv_9= '[' ( (lv_locationList_10_0= ruleLocationOrSpace ) ) (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )* otherlv_13= ']' (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )? (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )? )
            {
            // InternalMyDsl.g:2335:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'as' otherlv_7= 'specified' otherlv_8= 'but' otherlv_9= '[' ( (lv_locationList_10_0= ruleLocationOrSpace ) ) (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )* otherlv_13= ']' (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )? (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )? )
            // InternalMyDsl.g:2336:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'compound' otherlv_4= 'task' ( ( ruleEString ) ) otherlv_6= 'as' otherlv_7= 'specified' otherlv_8= 'but' otherlv_9= '[' ( (lv_locationList_10_0= ruleLocationOrSpace ) ) (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )* otherlv_13= ']' (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )? (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )?
            {
            // InternalMyDsl.g:2336:3: ()
            // InternalMyDsl.g:2337:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompTaskStatedButAccess().getCompTaskStatedButAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:2343:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2344:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2344:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2345:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCompTaskStatedButAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompTaskStatedButRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getCompTaskStatedButAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,49,FOLLOW_51); 

            			newLeafNode(otherlv_3, grammarAccess.getCompTaskStatedButAccess().getCompoundKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getCompTaskStatedButAccess().getTaskKeyword_4());
            		
            // InternalMyDsl.g:2374:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2375:4: ( ruleEString )
            {
            // InternalMyDsl.g:2375:4: ( ruleEString )
            // InternalMyDsl.g:2376:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompTaskStatedButRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCompTaskStatedButAccess().getCtCompoundTaskCrossReference_5_0());
            				
            pushFollow(FOLLOW_56);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,51,FOLLOW_57); 

            			newLeafNode(otherlv_6, grammarAccess.getCompTaskStatedButAccess().getAsKeyword_6());
            		
            otherlv_7=(Token)match(input,52,FOLLOW_54); 

            			newLeafNode(otherlv_7, grammarAccess.getCompTaskStatedButAccess().getSpecifiedKeyword_7());
            		
            otherlv_8=(Token)match(input,50,FOLLOW_24); 

            			newLeafNode(otherlv_8, grammarAccess.getCompTaskStatedButAccess().getButKeyword_8());
            		
            otherlv_9=(Token)match(input,29,FOLLOW_55); 

            			newLeafNode(otherlv_9, grammarAccess.getCompTaskStatedButAccess().getLeftSquareBracketKeyword_9());
            		
            // InternalMyDsl.g:2406:3: ( (lv_locationList_10_0= ruleLocationOrSpace ) )
            // InternalMyDsl.g:2407:4: (lv_locationList_10_0= ruleLocationOrSpace )
            {
            // InternalMyDsl.g:2407:4: (lv_locationList_10_0= ruleLocationOrSpace )
            // InternalMyDsl.g:2408:5: lv_locationList_10_0= ruleLocationOrSpace
            {

            					newCompositeNode(grammarAccess.getCompTaskStatedButAccess().getLocationListLocationOrSpaceParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_25);
            lv_locationList_10_0=ruleLocationOrSpace();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompTaskStatedButRule());
            					}
            					add(
            						current,
            						"locationList",
            						lv_locationList_10_0,
            						"org.xtext.example.mydsl.MyDsl.LocationOrSpace");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:2425:3: (otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==30) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalMyDsl.g:2426:4: otherlv_11= ',' ( (lv_locationList_12_0= ruleLocationOrSpace ) )
            	    {
            	    otherlv_11=(Token)match(input,30,FOLLOW_55); 

            	    				newLeafNode(otherlv_11, grammarAccess.getCompTaskStatedButAccess().getCommaKeyword_11_0());
            	    			
            	    // InternalMyDsl.g:2430:4: ( (lv_locationList_12_0= ruleLocationOrSpace ) )
            	    // InternalMyDsl.g:2431:5: (lv_locationList_12_0= ruleLocationOrSpace )
            	    {
            	    // InternalMyDsl.g:2431:5: (lv_locationList_12_0= ruleLocationOrSpace )
            	    // InternalMyDsl.g:2432:6: lv_locationList_12_0= ruleLocationOrSpace
            	    {

            	    						newCompositeNode(grammarAccess.getCompTaskStatedButAccess().getLocationListLocationOrSpaceParserRuleCall_11_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    lv_locationList_12_0=ruleLocationOrSpace();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCompTaskStatedButRule());
            	    						}
            	    						add(
            	    							current,
            	    							"locationList",
            	    							lv_locationList_12_0,
            	    							"org.xtext.example.mydsl.MyDsl.LocationOrSpace");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            otherlv_13=(Token)match(input,31,FOLLOW_53); 

            			newLeafNode(otherlv_13, grammarAccess.getCompTaskStatedButAccess().getRightSquareBracketKeyword_12());
            		
            // InternalMyDsl.g:2454:3: (otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==43) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMyDsl.g:2455:4: otherlv_14= '-' otherlv_15= 'criticality' ( (lv_criticality_16_0= ruleEString ) )
                    {
                    otherlv_14=(Token)match(input,43,FOLLOW_18); 

                    				newLeafNode(otherlv_14, grammarAccess.getCompTaskStatedButAccess().getHyphenMinusKeyword_13_0());
                    			
                    otherlv_15=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_15, grammarAccess.getCompTaskStatedButAccess().getCriticalityKeyword_13_1());
                    			
                    // InternalMyDsl.g:2463:4: ( (lv_criticality_16_0= ruleEString ) )
                    // InternalMyDsl.g:2464:5: (lv_criticality_16_0= ruleEString )
                    {
                    // InternalMyDsl.g:2464:5: (lv_criticality_16_0= ruleEString )
                    // InternalMyDsl.g:2465:6: lv_criticality_16_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompTaskStatedButAccess().getCriticalityEStringParserRuleCall_13_2_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_criticality_16_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompTaskStatedButRule());
                    						}
                    						set(
                    							current,
                    							"criticality",
                    							lv_criticality_16_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:2483:3: (otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==25) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMyDsl.g:2484:4: otherlv_17= '(' ( (lv_description_18_0= ruleEString ) ) otherlv_19= ')'
                    {
                    otherlv_17=(Token)match(input,25,FOLLOW_6); 

                    				newLeafNode(otherlv_17, grammarAccess.getCompTaskStatedButAccess().getLeftParenthesisKeyword_14_0());
                    			
                    // InternalMyDsl.g:2488:4: ( (lv_description_18_0= ruleEString ) )
                    // InternalMyDsl.g:2489:5: (lv_description_18_0= ruleEString )
                    {
                    // InternalMyDsl.g:2489:5: (lv_description_18_0= ruleEString )
                    // InternalMyDsl.g:2490:6: lv_description_18_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCompTaskStatedButAccess().getDescriptionEStringParserRuleCall_14_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_description_18_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCompTaskStatedButRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_18_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_19=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_19, grammarAccess.getCompTaskStatedButAccess().getRightParenthesisKeyword_14_2());
                    			

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
    // $ANTLR end "ruleCompTaskStatedBut"


    // $ANTLR start "entryRuleQoS"
    // InternalMyDsl.g:2516:1: entryRuleQoS returns [EObject current=null] : iv_ruleQoS= ruleQoS EOF ;
    public final EObject entryRuleQoS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQoS = null;


        try {
            // InternalMyDsl.g:2516:44: (iv_ruleQoS= ruleQoS EOF )
            // InternalMyDsl.g:2517:2: iv_ruleQoS= ruleQoS EOF
            {
             newCompositeNode(grammarAccess.getQoSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQoS=ruleQoS();

            state._fsp--;

             current =iv_ruleQoS; 
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
    // $ANTLR end "entryRuleQoS"


    // $ANTLR start "ruleQoS"
    // InternalMyDsl.g:2523:1: ruleQoS returns [EObject current=null] : (this_AllRobotsXX_0= ruleAllRobotsXX | this_AllRobotsX_1= ruleAllRobotsX | this_RobotsXX_2= ruleRobotsXX | this_RobotsX_3= ruleRobotsX | this_AllRobotsDeploy_4= ruleAllRobotsDeploy | this_NumAllocations_5= ruleNumAllocations | this_NumPopulation_6= ruleNumPopulation | this_NumEvaluations_7= ruleNumEvaluations | this_TimeAvailable_8= ruleTimeAvailable ) ;
    public final EObject ruleQoS() throws RecognitionException {
        EObject current = null;

        EObject this_AllRobotsXX_0 = null;

        EObject this_AllRobotsX_1 = null;

        EObject this_RobotsXX_2 = null;

        EObject this_RobotsX_3 = null;

        EObject this_AllRobotsDeploy_4 = null;

        EObject this_NumAllocations_5 = null;

        EObject this_NumPopulation_6 = null;

        EObject this_NumEvaluations_7 = null;

        EObject this_TimeAvailable_8 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2529:2: ( (this_AllRobotsXX_0= ruleAllRobotsXX | this_AllRobotsX_1= ruleAllRobotsX | this_RobotsXX_2= ruleRobotsXX | this_RobotsX_3= ruleRobotsX | this_AllRobotsDeploy_4= ruleAllRobotsDeploy | this_NumAllocations_5= ruleNumAllocations | this_NumPopulation_6= ruleNumPopulation | this_NumEvaluations_7= ruleNumEvaluations | this_TimeAvailable_8= ruleTimeAvailable ) )
            // InternalMyDsl.g:2530:2: (this_AllRobotsXX_0= ruleAllRobotsXX | this_AllRobotsX_1= ruleAllRobotsX | this_RobotsXX_2= ruleRobotsXX | this_RobotsX_3= ruleRobotsX | this_AllRobotsDeploy_4= ruleAllRobotsDeploy | this_NumAllocations_5= ruleNumAllocations | this_NumPopulation_6= ruleNumPopulation | this_NumEvaluations_7= ruleNumEvaluations | this_TimeAvailable_8= ruleTimeAvailable )
            {
            // InternalMyDsl.g:2530:2: (this_AllRobotsXX_0= ruleAllRobotsXX | this_AllRobotsX_1= ruleAllRobotsX | this_RobotsXX_2= ruleRobotsXX | this_RobotsX_3= ruleRobotsX | this_AllRobotsDeploy_4= ruleAllRobotsDeploy | this_NumAllocations_5= ruleNumAllocations | this_NumPopulation_6= ruleNumPopulation | this_NumEvaluations_7= ruleNumEvaluations | this_TimeAvailable_8= ruleTimeAvailable )
            int alt36=9;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // InternalMyDsl.g:2531:3: this_AllRobotsXX_0= ruleAllRobotsXX
                    {

                    			newCompositeNode(grammarAccess.getQoSAccess().getAllRobotsXXParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AllRobotsXX_0=ruleAllRobotsXX();

                    state._fsp--;


                    			current = this_AllRobotsXX_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2540:3: this_AllRobotsX_1= ruleAllRobotsX
                    {

                    			newCompositeNode(grammarAccess.getQoSAccess().getAllRobotsXParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AllRobotsX_1=ruleAllRobotsX();

                    state._fsp--;


                    			current = this_AllRobotsX_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2549:3: this_RobotsXX_2= ruleRobotsXX
                    {

                    			newCompositeNode(grammarAccess.getQoSAccess().getRobotsXXParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_RobotsXX_2=ruleRobotsXX();

                    state._fsp--;


                    			current = this_RobotsXX_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2558:3: this_RobotsX_3= ruleRobotsX
                    {

                    			newCompositeNode(grammarAccess.getQoSAccess().getRobotsXParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_RobotsX_3=ruleRobotsX();

                    state._fsp--;


                    			current = this_RobotsX_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2567:3: this_AllRobotsDeploy_4= ruleAllRobotsDeploy
                    {

                    			newCompositeNode(grammarAccess.getQoSAccess().getAllRobotsDeployParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_AllRobotsDeploy_4=ruleAllRobotsDeploy();

                    state._fsp--;


                    			current = this_AllRobotsDeploy_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:2576:3: this_NumAllocations_5= ruleNumAllocations
                    {

                    			newCompositeNode(grammarAccess.getQoSAccess().getNumAllocationsParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumAllocations_5=ruleNumAllocations();

                    state._fsp--;


                    			current = this_NumAllocations_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:2585:3: this_NumPopulation_6= ruleNumPopulation
                    {

                    			newCompositeNode(grammarAccess.getQoSAccess().getNumPopulationParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumPopulation_6=ruleNumPopulation();

                    state._fsp--;


                    			current = this_NumPopulation_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:2594:3: this_NumEvaluations_7= ruleNumEvaluations
                    {

                    			newCompositeNode(grammarAccess.getQoSAccess().getNumEvaluationsParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumEvaluations_7=ruleNumEvaluations();

                    state._fsp--;


                    			current = this_NumEvaluations_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:2603:3: this_TimeAvailable_8= ruleTimeAvailable
                    {

                    			newCompositeNode(grammarAccess.getQoSAccess().getTimeAvailableParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeAvailable_8=ruleTimeAvailable();

                    state._fsp--;


                    			current = this_TimeAvailable_8;
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
    // $ANTLR end "ruleQoS"


    // $ANTLR start "entryRuleAllRobotsXX"
    // InternalMyDsl.g:2615:1: entryRuleAllRobotsXX returns [EObject current=null] : iv_ruleAllRobotsXX= ruleAllRobotsXX EOF ;
    public final EObject entryRuleAllRobotsXX() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAllRobotsXX = null;


        try {
            // InternalMyDsl.g:2615:52: (iv_ruleAllRobotsXX= ruleAllRobotsXX EOF )
            // InternalMyDsl.g:2616:2: iv_ruleAllRobotsXX= ruleAllRobotsXX EOF
            {
             newCompositeNode(grammarAccess.getAllRobotsXXRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAllRobotsXX=ruleAllRobotsXX();

            state._fsp--;

             current =iv_ruleAllRobotsXX; 
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
    // $ANTLR end "entryRuleAllRobotsXX"


    // $ANTLR start "ruleAllRobotsXX"
    // InternalMyDsl.g:2622:1: ruleAllRobotsXX returns [EObject current=null] : ( () otherlv_1= 'all' otherlv_2= 'robots' otherlv_3= 'work' otherlv_4= 'between' ( ( (lv_coordinate_5_1= 'x' | lv_coordinate_5_2= 'y' ) ) ) otherlv_6= '[' ( (lv_xy1_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_xy2_9_0= ruleEDouble ) ) otherlv_10= ']' ) ;
    public final EObject ruleAllRobotsXX() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_coordinate_5_1=null;
        Token lv_coordinate_5_2=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_xy1_7_0 = null;

        AntlrDatatypeRuleToken lv_xy2_9_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2628:2: ( ( () otherlv_1= 'all' otherlv_2= 'robots' otherlv_3= 'work' otherlv_4= 'between' ( ( (lv_coordinate_5_1= 'x' | lv_coordinate_5_2= 'y' ) ) ) otherlv_6= '[' ( (lv_xy1_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_xy2_9_0= ruleEDouble ) ) otherlv_10= ']' ) )
            // InternalMyDsl.g:2629:2: ( () otherlv_1= 'all' otherlv_2= 'robots' otherlv_3= 'work' otherlv_4= 'between' ( ( (lv_coordinate_5_1= 'x' | lv_coordinate_5_2= 'y' ) ) ) otherlv_6= '[' ( (lv_xy1_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_xy2_9_0= ruleEDouble ) ) otherlv_10= ']' )
            {
            // InternalMyDsl.g:2629:2: ( () otherlv_1= 'all' otherlv_2= 'robots' otherlv_3= 'work' otherlv_4= 'between' ( ( (lv_coordinate_5_1= 'x' | lv_coordinate_5_2= 'y' ) ) ) otherlv_6= '[' ( (lv_xy1_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_xy2_9_0= ruleEDouble ) ) otherlv_10= ']' )
            // InternalMyDsl.g:2630:3: () otherlv_1= 'all' otherlv_2= 'robots' otherlv_3= 'work' otherlv_4= 'between' ( ( (lv_coordinate_5_1= 'x' | lv_coordinate_5_2= 'y' ) ) ) otherlv_6= '[' ( (lv_xy1_7_0= ruleEDouble ) ) otherlv_8= ',' ( (lv_xy2_9_0= ruleEDouble ) ) otherlv_10= ']'
            {
            // InternalMyDsl.g:2630:3: ()
            // InternalMyDsl.g:2631:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAllRobotsXXAccess().getAllRobotsXXAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,53,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getAllRobotsXXAccess().getAllKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_58); 

            			newLeafNode(otherlv_2, grammarAccess.getAllRobotsXXAccess().getRobotsKeyword_2());
            		
            otherlv_3=(Token)match(input,54,FOLLOW_59); 

            			newLeafNode(otherlv_3, grammarAccess.getAllRobotsXXAccess().getWorkKeyword_3());
            		
            otherlv_4=(Token)match(input,55,FOLLOW_60); 

            			newLeafNode(otherlv_4, grammarAccess.getAllRobotsXXAccess().getBetweenKeyword_4());
            		
            // InternalMyDsl.g:2653:3: ( ( (lv_coordinate_5_1= 'x' | lv_coordinate_5_2= 'y' ) ) )
            // InternalMyDsl.g:2654:4: ( (lv_coordinate_5_1= 'x' | lv_coordinate_5_2= 'y' ) )
            {
            // InternalMyDsl.g:2654:4: ( (lv_coordinate_5_1= 'x' | lv_coordinate_5_2= 'y' ) )
            // InternalMyDsl.g:2655:5: (lv_coordinate_5_1= 'x' | lv_coordinate_5_2= 'y' )
            {
            // InternalMyDsl.g:2655:5: (lv_coordinate_5_1= 'x' | lv_coordinate_5_2= 'y' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==34) ) {
                alt37=1;
            }
            else if ( (LA37_0==35) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalMyDsl.g:2656:6: lv_coordinate_5_1= 'x'
                    {
                    lv_coordinate_5_1=(Token)match(input,34,FOLLOW_24); 

                    						newLeafNode(lv_coordinate_5_1, grammarAccess.getAllRobotsXXAccess().getCoordinateXKeyword_5_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAllRobotsXXRule());
                    						}
                    						setWithLastConsumed(current, "coordinate", lv_coordinate_5_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2667:6: lv_coordinate_5_2= 'y'
                    {
                    lv_coordinate_5_2=(Token)match(input,35,FOLLOW_24); 

                    						newLeafNode(lv_coordinate_5_2, grammarAccess.getAllRobotsXXAccess().getCoordinateYKeyword_5_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAllRobotsXXRule());
                    						}
                    						setWithLastConsumed(current, "coordinate", lv_coordinate_5_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_6=(Token)match(input,29,FOLLOW_32); 

            			newLeafNode(otherlv_6, grammarAccess.getAllRobotsXXAccess().getLeftSquareBracketKeyword_6());
            		
            // InternalMyDsl.g:2684:3: ( (lv_xy1_7_0= ruleEDouble ) )
            // InternalMyDsl.g:2685:4: (lv_xy1_7_0= ruleEDouble )
            {
            // InternalMyDsl.g:2685:4: (lv_xy1_7_0= ruleEDouble )
            // InternalMyDsl.g:2686:5: lv_xy1_7_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getAllRobotsXXAccess().getXy1EDoubleParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_36);
            lv_xy1_7_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAllRobotsXXRule());
            					}
            					set(
            						current,
            						"xy1",
            						lv_xy1_7_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,30,FOLLOW_32); 

            			newLeafNode(otherlv_8, grammarAccess.getAllRobotsXXAccess().getCommaKeyword_8());
            		
            // InternalMyDsl.g:2707:3: ( (lv_xy2_9_0= ruleEDouble ) )
            // InternalMyDsl.g:2708:4: (lv_xy2_9_0= ruleEDouble )
            {
            // InternalMyDsl.g:2708:4: (lv_xy2_9_0= ruleEDouble )
            // InternalMyDsl.g:2709:5: lv_xy2_9_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getAllRobotsXXAccess().getXy2EDoubleParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_61);
            lv_xy2_9_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAllRobotsXXRule());
            					}
            					set(
            						current,
            						"xy2",
            						lv_xy2_9_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,31,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getAllRobotsXXAccess().getRightSquareBracketKeyword_10());
            		

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
    // $ANTLR end "ruleAllRobotsXX"


    // $ANTLR start "entryRuleAllRobotsX"
    // InternalMyDsl.g:2734:1: entryRuleAllRobotsX returns [EObject current=null] : iv_ruleAllRobotsX= ruleAllRobotsX EOF ;
    public final EObject entryRuleAllRobotsX() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAllRobotsX = null;


        try {
            // InternalMyDsl.g:2734:51: (iv_ruleAllRobotsX= ruleAllRobotsX EOF )
            // InternalMyDsl.g:2735:2: iv_ruleAllRobotsX= ruleAllRobotsX EOF
            {
             newCompositeNode(grammarAccess.getAllRobotsXRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAllRobotsX=ruleAllRobotsX();

            state._fsp--;

             current =iv_ruleAllRobotsX; 
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
    // $ANTLR end "entryRuleAllRobotsX"


    // $ANTLR start "ruleAllRobotsX"
    // InternalMyDsl.g:2741:1: ruleAllRobotsX returns [EObject current=null] : ( () otherlv_1= 'all robots work in ' ( ( (lv_coordinate_2_1= 'x' | lv_coordinate_2_2= 'y' ) ) ) ( ( (lv_type_3_1= 'greater than' | lv_type_3_2= 'lower than' | lv_type_3_3= 'geq' | lv_type_3_4= 'leq' ) ) ) ( (lv_xy_4_0= ruleEDouble ) ) ) ;
    public final EObject ruleAllRobotsX() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_coordinate_2_1=null;
        Token lv_coordinate_2_2=null;
        Token lv_type_3_1=null;
        Token lv_type_3_2=null;
        Token lv_type_3_3=null;
        Token lv_type_3_4=null;
        AntlrDatatypeRuleToken lv_xy_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2747:2: ( ( () otherlv_1= 'all robots work in ' ( ( (lv_coordinate_2_1= 'x' | lv_coordinate_2_2= 'y' ) ) ) ( ( (lv_type_3_1= 'greater than' | lv_type_3_2= 'lower than' | lv_type_3_3= 'geq' | lv_type_3_4= 'leq' ) ) ) ( (lv_xy_4_0= ruleEDouble ) ) ) )
            // InternalMyDsl.g:2748:2: ( () otherlv_1= 'all robots work in ' ( ( (lv_coordinate_2_1= 'x' | lv_coordinate_2_2= 'y' ) ) ) ( ( (lv_type_3_1= 'greater than' | lv_type_3_2= 'lower than' | lv_type_3_3= 'geq' | lv_type_3_4= 'leq' ) ) ) ( (lv_xy_4_0= ruleEDouble ) ) )
            {
            // InternalMyDsl.g:2748:2: ( () otherlv_1= 'all robots work in ' ( ( (lv_coordinate_2_1= 'x' | lv_coordinate_2_2= 'y' ) ) ) ( ( (lv_type_3_1= 'greater than' | lv_type_3_2= 'lower than' | lv_type_3_3= 'geq' | lv_type_3_4= 'leq' ) ) ) ( (lv_xy_4_0= ruleEDouble ) ) )
            // InternalMyDsl.g:2749:3: () otherlv_1= 'all robots work in ' ( ( (lv_coordinate_2_1= 'x' | lv_coordinate_2_2= 'y' ) ) ) ( ( (lv_type_3_1= 'greater than' | lv_type_3_2= 'lower than' | lv_type_3_3= 'geq' | lv_type_3_4= 'leq' ) ) ) ( (lv_xy_4_0= ruleEDouble ) )
            {
            // InternalMyDsl.g:2749:3: ()
            // InternalMyDsl.g:2750:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAllRobotsXAccess().getAllRobotsXAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,56,FOLLOW_60); 

            			newLeafNode(otherlv_1, grammarAccess.getAllRobotsXAccess().getAllRobotsWorkInKeyword_1());
            		
            // InternalMyDsl.g:2760:3: ( ( (lv_coordinate_2_1= 'x' | lv_coordinate_2_2= 'y' ) ) )
            // InternalMyDsl.g:2761:4: ( (lv_coordinate_2_1= 'x' | lv_coordinate_2_2= 'y' ) )
            {
            // InternalMyDsl.g:2761:4: ( (lv_coordinate_2_1= 'x' | lv_coordinate_2_2= 'y' ) )
            // InternalMyDsl.g:2762:5: (lv_coordinate_2_1= 'x' | lv_coordinate_2_2= 'y' )
            {
            // InternalMyDsl.g:2762:5: (lv_coordinate_2_1= 'x' | lv_coordinate_2_2= 'y' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==34) ) {
                alt38=1;
            }
            else if ( (LA38_0==35) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalMyDsl.g:2763:6: lv_coordinate_2_1= 'x'
                    {
                    lv_coordinate_2_1=(Token)match(input,34,FOLLOW_62); 

                    						newLeafNode(lv_coordinate_2_1, grammarAccess.getAllRobotsXAccess().getCoordinateXKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAllRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "coordinate", lv_coordinate_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2774:6: lv_coordinate_2_2= 'y'
                    {
                    lv_coordinate_2_2=(Token)match(input,35,FOLLOW_62); 

                    						newLeafNode(lv_coordinate_2_2, grammarAccess.getAllRobotsXAccess().getCoordinateYKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAllRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "coordinate", lv_coordinate_2_2, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalMyDsl.g:2787:3: ( ( (lv_type_3_1= 'greater than' | lv_type_3_2= 'lower than' | lv_type_3_3= 'geq' | lv_type_3_4= 'leq' ) ) )
            // InternalMyDsl.g:2788:4: ( (lv_type_3_1= 'greater than' | lv_type_3_2= 'lower than' | lv_type_3_3= 'geq' | lv_type_3_4= 'leq' ) )
            {
            // InternalMyDsl.g:2788:4: ( (lv_type_3_1= 'greater than' | lv_type_3_2= 'lower than' | lv_type_3_3= 'geq' | lv_type_3_4= 'leq' ) )
            // InternalMyDsl.g:2789:5: (lv_type_3_1= 'greater than' | lv_type_3_2= 'lower than' | lv_type_3_3= 'geq' | lv_type_3_4= 'leq' )
            {
            // InternalMyDsl.g:2789:5: (lv_type_3_1= 'greater than' | lv_type_3_2= 'lower than' | lv_type_3_3= 'geq' | lv_type_3_4= 'leq' )
            int alt39=4;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt39=1;
                }
                break;
            case 58:
                {
                alt39=2;
                }
                break;
            case 59:
                {
                alt39=3;
                }
                break;
            case 60:
                {
                alt39=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalMyDsl.g:2790:6: lv_type_3_1= 'greater than'
                    {
                    lv_type_3_1=(Token)match(input,57,FOLLOW_32); 

                    						newLeafNode(lv_type_3_1, grammarAccess.getAllRobotsXAccess().getTypeGreaterThanKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAllRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_3_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2801:6: lv_type_3_2= 'lower than'
                    {
                    lv_type_3_2=(Token)match(input,58,FOLLOW_32); 

                    						newLeafNode(lv_type_3_2, grammarAccess.getAllRobotsXAccess().getTypeLowerThanKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAllRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_3_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2812:6: lv_type_3_3= 'geq'
                    {
                    lv_type_3_3=(Token)match(input,59,FOLLOW_32); 

                    						newLeafNode(lv_type_3_3, grammarAccess.getAllRobotsXAccess().getTypeGeqKeyword_3_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAllRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_3_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2823:6: lv_type_3_4= 'leq'
                    {
                    lv_type_3_4=(Token)match(input,60,FOLLOW_32); 

                    						newLeafNode(lv_type_3_4, grammarAccess.getAllRobotsXAccess().getTypeLeqKeyword_3_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAllRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_3_4, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalMyDsl.g:2836:3: ( (lv_xy_4_0= ruleEDouble ) )
            // InternalMyDsl.g:2837:4: (lv_xy_4_0= ruleEDouble )
            {
            // InternalMyDsl.g:2837:4: (lv_xy_4_0= ruleEDouble )
            // InternalMyDsl.g:2838:5: lv_xy_4_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getAllRobotsXAccess().getXyEDoubleParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_xy_4_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAllRobotsXRule());
            					}
            					set(
            						current,
            						"xy",
            						lv_xy_4_0,
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
    // $ANTLR end "ruleAllRobotsX"


    // $ANTLR start "entryRuleRobotsXX"
    // InternalMyDsl.g:2859:1: entryRuleRobotsXX returns [EObject current=null] : iv_ruleRobotsXX= ruleRobotsXX EOF ;
    public final EObject entryRuleRobotsXX() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRobotsXX = null;


        try {
            // InternalMyDsl.g:2859:49: (iv_ruleRobotsXX= ruleRobotsXX EOF )
            // InternalMyDsl.g:2860:2: iv_ruleRobotsXX= ruleRobotsXX EOF
            {
             newCompositeNode(grammarAccess.getRobotsXXRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRobotsXX=ruleRobotsXX();

            state._fsp--;

             current =iv_ruleRobotsXX; 
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
    // $ANTLR end "entryRuleRobotsXX"


    // $ANTLR start "ruleRobotsXX"
    // InternalMyDsl.g:2866:1: ruleRobotsXX returns [EObject current=null] : ( () otherlv_1= 'robot' ( ( ruleEString ) ) otherlv_3= 'work between' ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) ) otherlv_5= '[' ( (lv_xy1_6_0= ruleEDouble ) ) otherlv_7= ',' ( (lv_xy2_8_0= ruleEDouble ) ) otherlv_9= ']' ) ;
    public final EObject ruleRobotsXX() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_coordinate_4_1=null;
        Token lv_coordinate_4_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_xy1_6_0 = null;

        AntlrDatatypeRuleToken lv_xy2_8_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2872:2: ( ( () otherlv_1= 'robot' ( ( ruleEString ) ) otherlv_3= 'work between' ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) ) otherlv_5= '[' ( (lv_xy1_6_0= ruleEDouble ) ) otherlv_7= ',' ( (lv_xy2_8_0= ruleEDouble ) ) otherlv_9= ']' ) )
            // InternalMyDsl.g:2873:2: ( () otherlv_1= 'robot' ( ( ruleEString ) ) otherlv_3= 'work between' ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) ) otherlv_5= '[' ( (lv_xy1_6_0= ruleEDouble ) ) otherlv_7= ',' ( (lv_xy2_8_0= ruleEDouble ) ) otherlv_9= ']' )
            {
            // InternalMyDsl.g:2873:2: ( () otherlv_1= 'robot' ( ( ruleEString ) ) otherlv_3= 'work between' ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) ) otherlv_5= '[' ( (lv_xy1_6_0= ruleEDouble ) ) otherlv_7= ',' ( (lv_xy2_8_0= ruleEDouble ) ) otherlv_9= ']' )
            // InternalMyDsl.g:2874:3: () otherlv_1= 'robot' ( ( ruleEString ) ) otherlv_3= 'work between' ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) ) otherlv_5= '[' ( (lv_xy1_6_0= ruleEDouble ) ) otherlv_7= ',' ( (lv_xy2_8_0= ruleEDouble ) ) otherlv_9= ']'
            {
            // InternalMyDsl.g:2874:3: ()
            // InternalMyDsl.g:2875:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRobotsXXAccess().getRobotsXXAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,61,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getRobotsXXAccess().getRobotKeyword_1());
            		
            // InternalMyDsl.g:2885:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2886:4: ( ruleEString )
            {
            // InternalMyDsl.g:2886:4: ( ruleEString )
            // InternalMyDsl.g:2887:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRobotsXXRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRobotsXXAccess().getRobotRobotCrossReference_2_0());
            				
            pushFollow(FOLLOW_63);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,62,FOLLOW_60); 

            			newLeafNode(otherlv_3, grammarAccess.getRobotsXXAccess().getWorkBetweenKeyword_3());
            		
            // InternalMyDsl.g:2905:3: ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) )
            // InternalMyDsl.g:2906:4: ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) )
            {
            // InternalMyDsl.g:2906:4: ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) )
            // InternalMyDsl.g:2907:5: (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' )
            {
            // InternalMyDsl.g:2907:5: (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==34) ) {
                alt40=1;
            }
            else if ( (LA40_0==35) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalMyDsl.g:2908:6: lv_coordinate_4_1= 'x'
                    {
                    lv_coordinate_4_1=(Token)match(input,34,FOLLOW_24); 

                    						newLeafNode(lv_coordinate_4_1, grammarAccess.getRobotsXXAccess().getCoordinateXKeyword_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRobotsXXRule());
                    						}
                    						setWithLastConsumed(current, "coordinate", lv_coordinate_4_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2919:6: lv_coordinate_4_2= 'y'
                    {
                    lv_coordinate_4_2=(Token)match(input,35,FOLLOW_24); 

                    						newLeafNode(lv_coordinate_4_2, grammarAccess.getRobotsXXAccess().getCoordinateYKeyword_4_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRobotsXXRule());
                    						}
                    						setWithLastConsumed(current, "coordinate", lv_coordinate_4_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_5=(Token)match(input,29,FOLLOW_32); 

            			newLeafNode(otherlv_5, grammarAccess.getRobotsXXAccess().getLeftSquareBracketKeyword_5());
            		
            // InternalMyDsl.g:2936:3: ( (lv_xy1_6_0= ruleEDouble ) )
            // InternalMyDsl.g:2937:4: (lv_xy1_6_0= ruleEDouble )
            {
            // InternalMyDsl.g:2937:4: (lv_xy1_6_0= ruleEDouble )
            // InternalMyDsl.g:2938:5: lv_xy1_6_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getRobotsXXAccess().getXy1EDoubleParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_36);
            lv_xy1_6_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobotsXXRule());
            					}
            					set(
            						current,
            						"xy1",
            						lv_xy1_6_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,30,FOLLOW_32); 

            			newLeafNode(otherlv_7, grammarAccess.getRobotsXXAccess().getCommaKeyword_7());
            		
            // InternalMyDsl.g:2959:3: ( (lv_xy2_8_0= ruleEDouble ) )
            // InternalMyDsl.g:2960:4: (lv_xy2_8_0= ruleEDouble )
            {
            // InternalMyDsl.g:2960:4: (lv_xy2_8_0= ruleEDouble )
            // InternalMyDsl.g:2961:5: lv_xy2_8_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getRobotsXXAccess().getXy2EDoubleParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_61);
            lv_xy2_8_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobotsXXRule());
            					}
            					set(
            						current,
            						"xy2",
            						lv_xy2_8_0,
            						"org.xtext.example.mydsl.MyDsl.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,31,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getRobotsXXAccess().getRightSquareBracketKeyword_9());
            		

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
    // $ANTLR end "ruleRobotsXX"


    // $ANTLR start "entryRuleRobotsX"
    // InternalMyDsl.g:2986:1: entryRuleRobotsX returns [EObject current=null] : iv_ruleRobotsX= ruleRobotsX EOF ;
    public final EObject entryRuleRobotsX() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRobotsX = null;


        try {
            // InternalMyDsl.g:2986:48: (iv_ruleRobotsX= ruleRobotsX EOF )
            // InternalMyDsl.g:2987:2: iv_ruleRobotsX= ruleRobotsX EOF
            {
             newCompositeNode(grammarAccess.getRobotsXRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRobotsX=ruleRobotsX();

            state._fsp--;

             current =iv_ruleRobotsX; 
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
    // $ANTLR end "entryRuleRobotsX"


    // $ANTLR start "ruleRobotsX"
    // InternalMyDsl.g:2993:1: ruleRobotsX returns [EObject current=null] : ( () otherlv_1= 'robot' ( ( ruleEString ) ) otherlv_3= 'work in ' ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) ) ( ( (lv_type_5_1= 'greater than' | lv_type_5_2= 'lower than' | lv_type_5_3= 'qeg' | lv_type_5_4= 'leq' ) ) ) ( (lv_xy_6_0= ruleEDouble ) ) ) ;
    public final EObject ruleRobotsX() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_coordinate_4_1=null;
        Token lv_coordinate_4_2=null;
        Token lv_type_5_1=null;
        Token lv_type_5_2=null;
        Token lv_type_5_3=null;
        Token lv_type_5_4=null;
        AntlrDatatypeRuleToken lv_xy_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2999:2: ( ( () otherlv_1= 'robot' ( ( ruleEString ) ) otherlv_3= 'work in ' ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) ) ( ( (lv_type_5_1= 'greater than' | lv_type_5_2= 'lower than' | lv_type_5_3= 'qeg' | lv_type_5_4= 'leq' ) ) ) ( (lv_xy_6_0= ruleEDouble ) ) ) )
            // InternalMyDsl.g:3000:2: ( () otherlv_1= 'robot' ( ( ruleEString ) ) otherlv_3= 'work in ' ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) ) ( ( (lv_type_5_1= 'greater than' | lv_type_5_2= 'lower than' | lv_type_5_3= 'qeg' | lv_type_5_4= 'leq' ) ) ) ( (lv_xy_6_0= ruleEDouble ) ) )
            {
            // InternalMyDsl.g:3000:2: ( () otherlv_1= 'robot' ( ( ruleEString ) ) otherlv_3= 'work in ' ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) ) ( ( (lv_type_5_1= 'greater than' | lv_type_5_2= 'lower than' | lv_type_5_3= 'qeg' | lv_type_5_4= 'leq' ) ) ) ( (lv_xy_6_0= ruleEDouble ) ) )
            // InternalMyDsl.g:3001:3: () otherlv_1= 'robot' ( ( ruleEString ) ) otherlv_3= 'work in ' ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) ) ( ( (lv_type_5_1= 'greater than' | lv_type_5_2= 'lower than' | lv_type_5_3= 'qeg' | lv_type_5_4= 'leq' ) ) ) ( (lv_xy_6_0= ruleEDouble ) )
            {
            // InternalMyDsl.g:3001:3: ()
            // InternalMyDsl.g:3002:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRobotsXAccess().getRobotsXAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,61,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getRobotsXAccess().getRobotKeyword_1());
            		
            // InternalMyDsl.g:3012:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3013:4: ( ruleEString )
            {
            // InternalMyDsl.g:3013:4: ( ruleEString )
            // InternalMyDsl.g:3014:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRobotsXRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRobotsXAccess().getRobotRobotCrossReference_2_0());
            				
            pushFollow(FOLLOW_64);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,63,FOLLOW_60); 

            			newLeafNode(otherlv_3, grammarAccess.getRobotsXAccess().getWorkInKeyword_3());
            		
            // InternalMyDsl.g:3032:3: ( ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) ) )
            // InternalMyDsl.g:3033:4: ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) )
            {
            // InternalMyDsl.g:3033:4: ( (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' ) )
            // InternalMyDsl.g:3034:5: (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' )
            {
            // InternalMyDsl.g:3034:5: (lv_coordinate_4_1= 'x' | lv_coordinate_4_2= 'y' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==34) ) {
                alt41=1;
            }
            else if ( (LA41_0==35) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalMyDsl.g:3035:6: lv_coordinate_4_1= 'x'
                    {
                    lv_coordinate_4_1=(Token)match(input,34,FOLLOW_65); 

                    						newLeafNode(lv_coordinate_4_1, grammarAccess.getRobotsXAccess().getCoordinateXKeyword_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "coordinate", lv_coordinate_4_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3046:6: lv_coordinate_4_2= 'y'
                    {
                    lv_coordinate_4_2=(Token)match(input,35,FOLLOW_65); 

                    						newLeafNode(lv_coordinate_4_2, grammarAccess.getRobotsXAccess().getCoordinateYKeyword_4_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "coordinate", lv_coordinate_4_2, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalMyDsl.g:3059:3: ( ( (lv_type_5_1= 'greater than' | lv_type_5_2= 'lower than' | lv_type_5_3= 'qeg' | lv_type_5_4= 'leq' ) ) )
            // InternalMyDsl.g:3060:4: ( (lv_type_5_1= 'greater than' | lv_type_5_2= 'lower than' | lv_type_5_3= 'qeg' | lv_type_5_4= 'leq' ) )
            {
            // InternalMyDsl.g:3060:4: ( (lv_type_5_1= 'greater than' | lv_type_5_2= 'lower than' | lv_type_5_3= 'qeg' | lv_type_5_4= 'leq' ) )
            // InternalMyDsl.g:3061:5: (lv_type_5_1= 'greater than' | lv_type_5_2= 'lower than' | lv_type_5_3= 'qeg' | lv_type_5_4= 'leq' )
            {
            // InternalMyDsl.g:3061:5: (lv_type_5_1= 'greater than' | lv_type_5_2= 'lower than' | lv_type_5_3= 'qeg' | lv_type_5_4= 'leq' )
            int alt42=4;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt42=1;
                }
                break;
            case 58:
                {
                alt42=2;
                }
                break;
            case 64:
                {
                alt42=3;
                }
                break;
            case 60:
                {
                alt42=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalMyDsl.g:3062:6: lv_type_5_1= 'greater than'
                    {
                    lv_type_5_1=(Token)match(input,57,FOLLOW_32); 

                    						newLeafNode(lv_type_5_1, grammarAccess.getRobotsXAccess().getTypeGreaterThanKeyword_5_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_5_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3073:6: lv_type_5_2= 'lower than'
                    {
                    lv_type_5_2=(Token)match(input,58,FOLLOW_32); 

                    						newLeafNode(lv_type_5_2, grammarAccess.getRobotsXAccess().getTypeLowerThanKeyword_5_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_5_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3084:6: lv_type_5_3= 'qeg'
                    {
                    lv_type_5_3=(Token)match(input,64,FOLLOW_32); 

                    						newLeafNode(lv_type_5_3, grammarAccess.getRobotsXAccess().getTypeQegKeyword_5_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_5_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3095:6: lv_type_5_4= 'leq'
                    {
                    lv_type_5_4=(Token)match(input,60,FOLLOW_32); 

                    						newLeafNode(lv_type_5_4, grammarAccess.getRobotsXAccess().getTypeLeqKeyword_5_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRobotsXRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_5_4, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalMyDsl.g:3108:3: ( (lv_xy_6_0= ruleEDouble ) )
            // InternalMyDsl.g:3109:4: (lv_xy_6_0= ruleEDouble )
            {
            // InternalMyDsl.g:3109:4: (lv_xy_6_0= ruleEDouble )
            // InternalMyDsl.g:3110:5: lv_xy_6_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getRobotsXAccess().getXyEDoubleParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_xy_6_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRobotsXRule());
            					}
            					set(
            						current,
            						"xy",
            						lv_xy_6_0,
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
    // $ANTLR end "ruleRobotsX"


    // $ANTLR start "entryRuleAllRobotsDeploy"
    // InternalMyDsl.g:3131:1: entryRuleAllRobotsDeploy returns [EObject current=null] : iv_ruleAllRobotsDeploy= ruleAllRobotsDeploy EOF ;
    public final EObject entryRuleAllRobotsDeploy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAllRobotsDeploy = null;


        try {
            // InternalMyDsl.g:3131:56: (iv_ruleAllRobotsDeploy= ruleAllRobotsDeploy EOF )
            // InternalMyDsl.g:3132:2: iv_ruleAllRobotsDeploy= ruleAllRobotsDeploy EOF
            {
             newCompositeNode(grammarAccess.getAllRobotsDeployRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAllRobotsDeploy=ruleAllRobotsDeploy();

            state._fsp--;

             current =iv_ruleAllRobotsDeploy; 
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
    // $ANTLR end "entryRuleAllRobotsDeploy"


    // $ANTLR start "ruleAllRobotsDeploy"
    // InternalMyDsl.g:3138:1: ruleAllRobotsDeploy returns [EObject current=null] : ( () otherlv_1= 'all robot deployed' ) ;
    public final EObject ruleAllRobotsDeploy() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3144:2: ( ( () otherlv_1= 'all robot deployed' ) )
            // InternalMyDsl.g:3145:2: ( () otherlv_1= 'all robot deployed' )
            {
            // InternalMyDsl.g:3145:2: ( () otherlv_1= 'all robot deployed' )
            // InternalMyDsl.g:3146:3: () otherlv_1= 'all robot deployed'
            {
            // InternalMyDsl.g:3146:3: ()
            // InternalMyDsl.g:3147:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAllRobotsDeployAccess().getAllRobotsDeployAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,65,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getAllRobotsDeployAccess().getAllRobotDeployedKeyword_1());
            		

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
    // $ANTLR end "ruleAllRobotsDeploy"


    // $ANTLR start "entryRuleTimeAvailable"
    // InternalMyDsl.g:3161:1: entryRuleTimeAvailable returns [EObject current=null] : iv_ruleTimeAvailable= ruleTimeAvailable EOF ;
    public final EObject entryRuleTimeAvailable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeAvailable = null;


        try {
            // InternalMyDsl.g:3161:54: (iv_ruleTimeAvailable= ruleTimeAvailable EOF )
            // InternalMyDsl.g:3162:2: iv_ruleTimeAvailable= ruleTimeAvailable EOF
            {
             newCompositeNode(grammarAccess.getTimeAvailableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeAvailable=ruleTimeAvailable();

            state._fsp--;

             current =iv_ruleTimeAvailable; 
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
    // $ANTLR end "entryRuleTimeAvailable"


    // $ANTLR start "ruleTimeAvailable"
    // InternalMyDsl.g:3168:1: ruleTimeAvailable returns [EObject current=null] : ( () otherlv_1= 'time available:' ( (lv_number_2_0= ruleEInt ) ) ) ;
    public final EObject ruleTimeAvailable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_number_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3174:2: ( ( () otherlv_1= 'time available:' ( (lv_number_2_0= ruleEInt ) ) ) )
            // InternalMyDsl.g:3175:2: ( () otherlv_1= 'time available:' ( (lv_number_2_0= ruleEInt ) ) )
            {
            // InternalMyDsl.g:3175:2: ( () otherlv_1= 'time available:' ( (lv_number_2_0= ruleEInt ) ) )
            // InternalMyDsl.g:3176:3: () otherlv_1= 'time available:' ( (lv_number_2_0= ruleEInt ) )
            {
            // InternalMyDsl.g:3176:3: ()
            // InternalMyDsl.g:3177:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeAvailableAccess().getTimeAvailableAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,66,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeAvailableAccess().getTimeAvailableKeyword_1());
            		
            // InternalMyDsl.g:3187:3: ( (lv_number_2_0= ruleEInt ) )
            // InternalMyDsl.g:3188:4: (lv_number_2_0= ruleEInt )
            {
            // InternalMyDsl.g:3188:4: (lv_number_2_0= ruleEInt )
            // InternalMyDsl.g:3189:5: lv_number_2_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getTimeAvailableAccess().getNumberEIntParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_number_2_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeAvailableRule());
            					}
            					set(
            						current,
            						"number",
            						lv_number_2_0,
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
    // $ANTLR end "ruleTimeAvailable"


    // $ANTLR start "entryRuleNumAllocations"
    // InternalMyDsl.g:3210:1: entryRuleNumAllocations returns [EObject current=null] : iv_ruleNumAllocations= ruleNumAllocations EOF ;
    public final EObject entryRuleNumAllocations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAllocations = null;


        try {
            // InternalMyDsl.g:3210:55: (iv_ruleNumAllocations= ruleNumAllocations EOF )
            // InternalMyDsl.g:3211:2: iv_ruleNumAllocations= ruleNumAllocations EOF
            {
             newCompositeNode(grammarAccess.getNumAllocationsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumAllocations=ruleNumAllocations();

            state._fsp--;

             current =iv_ruleNumAllocations; 
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
    // $ANTLR end "entryRuleNumAllocations"


    // $ANTLR start "ruleNumAllocations"
    // InternalMyDsl.g:3217:1: ruleNumAllocations returns [EObject current=null] : ( () otherlv_1= 'system: get ' ( (lv_number_2_0= ruleEInt ) ) otherlv_3= 'number of allocations' ) ;
    public final EObject ruleNumAllocations() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_number_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3223:2: ( ( () otherlv_1= 'system: get ' ( (lv_number_2_0= ruleEInt ) ) otherlv_3= 'number of allocations' ) )
            // InternalMyDsl.g:3224:2: ( () otherlv_1= 'system: get ' ( (lv_number_2_0= ruleEInt ) ) otherlv_3= 'number of allocations' )
            {
            // InternalMyDsl.g:3224:2: ( () otherlv_1= 'system: get ' ( (lv_number_2_0= ruleEInt ) ) otherlv_3= 'number of allocations' )
            // InternalMyDsl.g:3225:3: () otherlv_1= 'system: get ' ( (lv_number_2_0= ruleEInt ) ) otherlv_3= 'number of allocations'
            {
            // InternalMyDsl.g:3225:3: ()
            // InternalMyDsl.g:3226:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumAllocationsAccess().getNumAllocationsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,67,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getNumAllocationsAccess().getSystemGetKeyword_1());
            		
            // InternalMyDsl.g:3236:3: ( (lv_number_2_0= ruleEInt ) )
            // InternalMyDsl.g:3237:4: (lv_number_2_0= ruleEInt )
            {
            // InternalMyDsl.g:3237:4: (lv_number_2_0= ruleEInt )
            // InternalMyDsl.g:3238:5: lv_number_2_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getNumAllocationsAccess().getNumberEIntParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_66);
            lv_number_2_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumAllocationsRule());
            					}
            					set(
            						current,
            						"number",
            						lv_number_2_0,
            						"org.xtext.example.mydsl.MyDsl.EInt");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,68,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getNumAllocationsAccess().getNumberOfAllocationsKeyword_3());
            		

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
    // $ANTLR end "ruleNumAllocations"


    // $ANTLR start "entryRuleNumPopulation"
    // InternalMyDsl.g:3263:1: entryRuleNumPopulation returns [EObject current=null] : iv_ruleNumPopulation= ruleNumPopulation EOF ;
    public final EObject entryRuleNumPopulation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumPopulation = null;


        try {
            // InternalMyDsl.g:3263:54: (iv_ruleNumPopulation= ruleNumPopulation EOF )
            // InternalMyDsl.g:3264:2: iv_ruleNumPopulation= ruleNumPopulation EOF
            {
             newCompositeNode(grammarAccess.getNumPopulationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumPopulation=ruleNumPopulation();

            state._fsp--;

             current =iv_ruleNumPopulation; 
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
    // $ANTLR end "entryRuleNumPopulation"


    // $ANTLR start "ruleNumPopulation"
    // InternalMyDsl.g:3270:1: ruleNumPopulation returns [EObject current=null] : ( () otherlv_1= 'system: evochecker population' ( (lv_number_2_0= ruleEInt ) ) ) ;
    public final EObject ruleNumPopulation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_number_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3276:2: ( ( () otherlv_1= 'system: evochecker population' ( (lv_number_2_0= ruleEInt ) ) ) )
            // InternalMyDsl.g:3277:2: ( () otherlv_1= 'system: evochecker population' ( (lv_number_2_0= ruleEInt ) ) )
            {
            // InternalMyDsl.g:3277:2: ( () otherlv_1= 'system: evochecker population' ( (lv_number_2_0= ruleEInt ) ) )
            // InternalMyDsl.g:3278:3: () otherlv_1= 'system: evochecker population' ( (lv_number_2_0= ruleEInt ) )
            {
            // InternalMyDsl.g:3278:3: ()
            // InternalMyDsl.g:3279:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumPopulationAccess().getNumPopulationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,69,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getNumPopulationAccess().getSystemEvocheckerPopulationKeyword_1());
            		
            // InternalMyDsl.g:3289:3: ( (lv_number_2_0= ruleEInt ) )
            // InternalMyDsl.g:3290:4: (lv_number_2_0= ruleEInt )
            {
            // InternalMyDsl.g:3290:4: (lv_number_2_0= ruleEInt )
            // InternalMyDsl.g:3291:5: lv_number_2_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getNumPopulationAccess().getNumberEIntParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_number_2_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumPopulationRule());
            					}
            					set(
            						current,
            						"number",
            						lv_number_2_0,
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
    // $ANTLR end "ruleNumPopulation"


    // $ANTLR start "entryRuleNumEvaluations"
    // InternalMyDsl.g:3312:1: entryRuleNumEvaluations returns [EObject current=null] : iv_ruleNumEvaluations= ruleNumEvaluations EOF ;
    public final EObject entryRuleNumEvaluations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumEvaluations = null;


        try {
            // InternalMyDsl.g:3312:55: (iv_ruleNumEvaluations= ruleNumEvaluations EOF )
            // InternalMyDsl.g:3313:2: iv_ruleNumEvaluations= ruleNumEvaluations EOF
            {
             newCompositeNode(grammarAccess.getNumEvaluationsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumEvaluations=ruleNumEvaluations();

            state._fsp--;

             current =iv_ruleNumEvaluations; 
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
    // $ANTLR end "entryRuleNumEvaluations"


    // $ANTLR start "ruleNumEvaluations"
    // InternalMyDsl.g:3319:1: ruleNumEvaluations returns [EObject current=null] : ( () otherlv_1= 'system: evochecker evaluations' ( (lv_number_2_0= ruleEInt ) ) ) ;
    public final EObject ruleNumEvaluations() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_number_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3325:2: ( ( () otherlv_1= 'system: evochecker evaluations' ( (lv_number_2_0= ruleEInt ) ) ) )
            // InternalMyDsl.g:3326:2: ( () otherlv_1= 'system: evochecker evaluations' ( (lv_number_2_0= ruleEInt ) ) )
            {
            // InternalMyDsl.g:3326:2: ( () otherlv_1= 'system: evochecker evaluations' ( (lv_number_2_0= ruleEInt ) ) )
            // InternalMyDsl.g:3327:3: () otherlv_1= 'system: evochecker evaluations' ( (lv_number_2_0= ruleEInt ) )
            {
            // InternalMyDsl.g:3327:3: ()
            // InternalMyDsl.g:3328:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumEvaluationsAccess().getNumEvaluationsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,70,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getNumEvaluationsAccess().getSystemEvocheckerEvaluationsKeyword_1());
            		
            // InternalMyDsl.g:3338:3: ( (lv_number_2_0= ruleEInt ) )
            // InternalMyDsl.g:3339:4: (lv_number_2_0= ruleEInt )
            {
            // InternalMyDsl.g:3339:4: (lv_number_2_0= ruleEInt )
            // InternalMyDsl.g:3340:5: lv_number_2_0= ruleEInt
            {

            					newCompositeNode(grammarAccess.getNumEvaluationsAccess().getNumberEIntParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_number_2_0=ruleEInt();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumEvaluationsRule());
            					}
            					set(
            						current,
            						"number",
            						lv_number_2_0,
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
    // $ANTLR end "ruleNumEvaluations"


    // $ANTLR start "entryRuleLocationOrSpace"
    // InternalMyDsl.g:3361:1: entryRuleLocationOrSpace returns [EObject current=null] : iv_ruleLocationOrSpace= ruleLocationOrSpace EOF ;
    public final EObject entryRuleLocationOrSpace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocationOrSpace = null;


        try {
            // InternalMyDsl.g:3361:56: (iv_ruleLocationOrSpace= ruleLocationOrSpace EOF )
            // InternalMyDsl.g:3362:2: iv_ruleLocationOrSpace= ruleLocationOrSpace EOF
            {
             newCompositeNode(grammarAccess.getLocationOrSpaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocationOrSpace=ruleLocationOrSpace();

            state._fsp--;

             current =iv_ruleLocationOrSpace; 
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
    // $ANTLR end "entryRuleLocationOrSpace"


    // $ANTLR start "ruleLocationOrSpace"
    // InternalMyDsl.g:3368:1: ruleLocationOrSpace returns [EObject current=null] : ( ( (lv_space_0_0= '-' ) ) | ( ( ruleEString ) ) ) ;
    public final EObject ruleLocationOrSpace() throws RecognitionException {
        EObject current = null;

        Token lv_space_0_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3374:2: ( ( ( (lv_space_0_0= '-' ) ) | ( ( ruleEString ) ) ) )
            // InternalMyDsl.g:3375:2: ( ( (lv_space_0_0= '-' ) ) | ( ( ruleEString ) ) )
            {
            // InternalMyDsl.g:3375:2: ( ( (lv_space_0_0= '-' ) ) | ( ( ruleEString ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==43) ) {
                alt43=1;
            }
            else if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_ID)) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalMyDsl.g:3376:3: ( (lv_space_0_0= '-' ) )
                    {
                    // InternalMyDsl.g:3376:3: ( (lv_space_0_0= '-' ) )
                    // InternalMyDsl.g:3377:4: (lv_space_0_0= '-' )
                    {
                    // InternalMyDsl.g:3377:4: (lv_space_0_0= '-' )
                    // InternalMyDsl.g:3378:5: lv_space_0_0= '-'
                    {
                    lv_space_0_0=(Token)match(input,43,FOLLOW_2); 

                    					newLeafNode(lv_space_0_0, grammarAccess.getLocationOrSpaceAccess().getSpaceHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getLocationOrSpaceRule());
                    					}
                    					setWithLastConsumed(current, "space", lv_space_0_0, "-");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3391:3: ( ( ruleEString ) )
                    {
                    // InternalMyDsl.g:3391:3: ( ( ruleEString ) )
                    // InternalMyDsl.g:3392:4: ( ruleEString )
                    {
                    // InternalMyDsl.g:3392:4: ( ruleEString )
                    // InternalMyDsl.g:3393:5: ruleEString
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getLocationOrSpaceRule());
                    					}
                    				

                    					newCompositeNode(grammarAccess.getLocationOrSpaceAccess().getLocLocationCrossReference_1_0());
                    				
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
    // $ANTLR end "ruleLocationOrSpace"


    // $ANTLR start "entryRuleEString"
    // InternalMyDsl.g:3411:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMyDsl.g:3411:47: (iv_ruleEString= ruleEString EOF )
            // InternalMyDsl.g:3412:2: iv_ruleEString= ruleEString EOF
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
    // InternalMyDsl.g:3418:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3424:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMyDsl.g:3425:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMyDsl.g:3425:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_STRING) ) {
                alt44=1;
            }
            else if ( (LA44_0==RULE_ID) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalMyDsl.g:3426:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3434:3: this_ID_1= RULE_ID
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
    // InternalMyDsl.g:3445:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalMyDsl.g:3445:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalMyDsl.g:3446:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalMyDsl.g:3452:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3458:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalMyDsl.g:3459:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalMyDsl.g:3459:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalMyDsl.g:3460:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalMyDsl.g:3460:3: (kw= '-' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==43) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalMyDsl.g:3461:4: kw= '-'
                    {
                    kw=(Token)match(input,43,FOLLOW_67); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:3467:3: (this_INT_1= RULE_INT )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_INT) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalMyDsl.g:3468:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_68); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,71,FOLLOW_69); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_70); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
            		
            // InternalMyDsl.g:3488:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=72 && LA49_0<=73)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalMyDsl.g:3489:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalMyDsl.g:3489:4: (kw= 'E' | kw= 'e' )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==72) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==73) ) {
                        alt47=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalMyDsl.g:3490:5: kw= 'E'
                            {
                            kw=(Token)match(input,72,FOLLOW_13); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalMyDsl.g:3496:5: kw= 'e'
                            {
                            kw=(Token)match(input,73,FOLLOW_13); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalMyDsl.g:3502:4: (kw= '-' )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==43) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // InternalMyDsl.g:3503:5: kw= '-'
                            {
                            kw=(Token)match(input,43,FOLLOW_69); 

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


    // $ANTLR start "entryRuleEInt"
    // InternalMyDsl.g:3521:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalMyDsl.g:3521:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalMyDsl.g:3522:2: iv_ruleEInt= ruleEInt EOF
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
    // InternalMyDsl.g:3528:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3534:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalMyDsl.g:3535:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalMyDsl.g:3535:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalMyDsl.g:3536:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalMyDsl.g:3536:3: (kw= '-' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==43) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalMyDsl.g:3537:4: kw= '-'
                    {
                    kw=(Token)match(input,43,FOLLOW_69); 

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


    // $ANTLR start "entryRuleEBoolean"
    // InternalMyDsl.g:3554:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalMyDsl.g:3554:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalMyDsl.g:3555:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
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
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalMyDsl.g:3561:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3567:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalMyDsl.g:3568:2: (kw= 'true' | kw= 'false' )
            {
            // InternalMyDsl.g:3568:2: (kw= 'true' | kw= 'false' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==74) ) {
                alt51=1;
            }
            else if ( (LA51_0==75) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalMyDsl.g:3569:3: kw= 'true'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3575:3: kw= 'false'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1());
                    		

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
    // $ANTLR end "ruleEBoolean"

    // Delegated rules


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\10\uffff\2\12\3\uffff\2\21\3\uffff";
    static final String dfa_3s = "\1\4\2\16\1\4\1\60\2\uffff\3\4\1\uffff\1\4\1\uffff\2\4\3\uffff";
    static final String dfa_4s = "\1\5\2\16\1\61\1\60\2\uffff\1\5\2\106\1\uffff\1\35\1\uffff\2\106\3\uffff";
    static final String dfa_5s = "\5\uffff\1\1\1\2\3\uffff\1\3\1\uffff\1\7\2\uffff\1\5\1\6\1\4";
    static final String dfa_6s = "\22\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\2",
            "\1\3",
            "\1\3",
            "\2\5\51\uffff\1\6\1\uffff\1\4",
            "\1\7",
            "",
            "",
            "\1\10\1\11",
            "\2\12\14\uffff\1\12\2\uffff\1\13\3\uffff\1\12\21\uffff\1\12\7\uffff\1\14\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\3\uffff\3\12\1\uffff\2\12",
            "\2\12\14\uffff\1\12\2\uffff\1\13\3\uffff\1\12\21\uffff\1\12\7\uffff\1\14\1\uffff\1\12\2\uffff\1\12\4\uffff\1\12\3\uffff\3\12\1\uffff\2\12",
            "",
            "\1\15\1\16\27\uffff\1\17",
            "",
            "\2\21\14\uffff\1\21\6\uffff\1\21\21\uffff\1\21\6\uffff\1\20\2\uffff\1\21\2\uffff\1\21\4\uffff\1\21\3\uffff\3\21\1\uffff\2\21",
            "\2\21\14\uffff\1\21\6\uffff\1\21\21\uffff\1\21\6\uffff\1\20\2\uffff\1\21\2\uffff\1\21\4\uffff\1\21\3\uffff\3\21\1\uffff\2\21",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1368:2: (this_AtomicTaskNoLoc_0= ruleAtomicTaskNoLoc | this_AtomicTaskLoc_1= ruleAtomicTaskLoc | this_CompTaskNoLoc_2= ruleCompTaskNoLoc | this_CompTaskOneLoc_3= ruleCompTaskOneLoc | this_CompTaskListLoc_4= ruleCompTaskListLoc | this_CompTaskAtBut_5= ruleCompTaskAtBut | this_CompTaskStatedBut_6= ruleCompTaskStatedBut )";
        }
    }
    static final String dfa_8s = "\15\uffff";
    static final String dfa_9s = "\1\65\2\uffff\1\4\5\uffff\2\76\2\uffff";
    static final String dfa_10s = "\1\106\2\uffff\1\5\5\uffff\2\77\2\uffff";
    static final String dfa_11s = "\1\uffff\1\1\1\2\1\uffff\1\5\1\6\1\7\1\10\1\11\2\uffff\1\4\1\3";
    static final String dfa_12s = "\15\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\2\uffff\1\2\4\uffff\1\3\3\uffff\1\4\1\10\1\5\1\uffff\1\6\1\7",
            "",
            "",
            "\1\11\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\14\1\13",
            "\1\14\1\13",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2530:2: (this_AllRobotsXX_0= ruleAllRobotsXX | this_AllRobotsX_1= ruleAllRobotsX | this_RobotsXX_2= ruleRobotsXX | this_RobotsX_3= ruleRobotsX | this_AllRobotsDeploy_4= ruleAllRobotsDeploy | this_NumAllocations_5= ruleNumAllocations | this_NumPopulation_6= ruleNumPopulation | this_NumEvaluations_7= ruleNumEvaluations | this_TimeAvailable_8= ruleTimeAvailable )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x2120000000040030L,0x000000000000006EL});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x2120000000040000L,0x000000000000006EL});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000080000000040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002A00002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000302A00002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000302800002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000302000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000202000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000080000000040L,0x0000000000000080L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000080002000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000080000000030L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x1E00000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x1600000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000080L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});

}