package org.xtext.example.mydsl.ide.contentassist.antlr.internal;

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
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'robots'", "'robot'", "'E'", "'e'", "'minimiseIdle'", "'minimiseTravel'", "'maximiseSuccess'", "'x'", "'y'", "'lower'", "'greater'", "'end'", "'start'", "'ProblemSpecification'", "'{'", "'WorldModel'", "':'", "'TasksModel'", "'RobotsModel'", "'Mission'", "'}'", "','", "'('", "')'", "'describes'", "'distance'", "'to'", "'is'", "'needed'", "'at'", "'location'", "'subtasks'", "'['", "']'", "'constraint:'", "'initial'", "'position'", "'has'", "'velocity'", "'with'", "'capabilities'", "'-required'", "'time:'", "'success'", "'rate:'", "'%'", "'objectives:'", "'constraints:'", "'parameters:'", "'numAllocation:'", "'population:'", "'evaluation:'", "'atomic'", "'task'", "'compound'", "'rate'", "'of'", "'than'", "'work'", "'in'", "'time'", "'mission'", "'allocate'", "'closest'", "'tasks'", "'limit'", "'max'", "'number'", "'-'", "'.'", "'ordered'", "'consecutive'", "'all'", "'per'"
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

    	public void setGrammarAccess(MyDslGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleProblemSpecification"
    // InternalMyDsl.g:53:1: entryRuleProblemSpecification : ruleProblemSpecification EOF ;
    public final void entryRuleProblemSpecification() throws RecognitionException {
        try {
            // InternalMyDsl.g:54:1: ( ruleProblemSpecification EOF )
            // InternalMyDsl.g:55:1: ruleProblemSpecification EOF
            {
             before(grammarAccess.getProblemSpecificationRule()); 
            pushFollow(FOLLOW_1);
            ruleProblemSpecification();

            state._fsp--;

             after(grammarAccess.getProblemSpecificationRule()); 
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
    // $ANTLR end "entryRuleProblemSpecification"


    // $ANTLR start "ruleProblemSpecification"
    // InternalMyDsl.g:62:1: ruleProblemSpecification : ( ( rule__ProblemSpecification__Group__0 ) ) ;
    public final void ruleProblemSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:66:2: ( ( ( rule__ProblemSpecification__Group__0 ) ) )
            // InternalMyDsl.g:67:2: ( ( rule__ProblemSpecification__Group__0 ) )
            {
            // InternalMyDsl.g:67:2: ( ( rule__ProblemSpecification__Group__0 ) )
            // InternalMyDsl.g:68:3: ( rule__ProblemSpecification__Group__0 )
            {
             before(grammarAccess.getProblemSpecificationAccess().getGroup()); 
            // InternalMyDsl.g:69:3: ( rule__ProblemSpecification__Group__0 )
            // InternalMyDsl.g:69:4: rule__ProblemSpecification__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProblemSpecificationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProblemSpecification"


    // $ANTLR start "entryRuleWorldModel"
    // InternalMyDsl.g:78:1: entryRuleWorldModel : ruleWorldModel EOF ;
    public final void entryRuleWorldModel() throws RecognitionException {
        try {
            // InternalMyDsl.g:79:1: ( ruleWorldModel EOF )
            // InternalMyDsl.g:80:1: ruleWorldModel EOF
            {
             before(grammarAccess.getWorldModelRule()); 
            pushFollow(FOLLOW_1);
            ruleWorldModel();

            state._fsp--;

             after(grammarAccess.getWorldModelRule()); 
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
    // $ANTLR end "entryRuleWorldModel"


    // $ANTLR start "ruleWorldModel"
    // InternalMyDsl.g:87:1: ruleWorldModel : ( ( rule__WorldModel__Alternatives ) ) ;
    public final void ruleWorldModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:91:2: ( ( ( rule__WorldModel__Alternatives ) ) )
            // InternalMyDsl.g:92:2: ( ( rule__WorldModel__Alternatives ) )
            {
            // InternalMyDsl.g:92:2: ( ( rule__WorldModel__Alternatives ) )
            // InternalMyDsl.g:93:3: ( rule__WorldModel__Alternatives )
            {
             before(grammarAccess.getWorldModelAccess().getAlternatives()); 
            // InternalMyDsl.g:94:3: ( rule__WorldModel__Alternatives )
            // InternalMyDsl.g:94:4: rule__WorldModel__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__WorldModel__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getWorldModelAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorldModel"


    // $ANTLR start "entryRuleLocation"
    // InternalMyDsl.g:103:1: entryRuleLocation : ruleLocation EOF ;
    public final void entryRuleLocation() throws RecognitionException {
        try {
            // InternalMyDsl.g:104:1: ( ruleLocation EOF )
            // InternalMyDsl.g:105:1: ruleLocation EOF
            {
             before(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_1);
            ruleLocation();

            state._fsp--;

             after(grammarAccess.getLocationRule()); 
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
    // $ANTLR end "entryRuleLocation"


    // $ANTLR start "ruleLocation"
    // InternalMyDsl.g:112:1: ruleLocation : ( ( rule__Location__Group__0 ) ) ;
    public final void ruleLocation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:116:2: ( ( ( rule__Location__Group__0 ) ) )
            // InternalMyDsl.g:117:2: ( ( rule__Location__Group__0 ) )
            {
            // InternalMyDsl.g:117:2: ( ( rule__Location__Group__0 ) )
            // InternalMyDsl.g:118:3: ( rule__Location__Group__0 )
            {
             before(grammarAccess.getLocationAccess().getGroup()); 
            // InternalMyDsl.g:119:3: ( rule__Location__Group__0 )
            // InternalMyDsl.g:119:4: rule__Location__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Location__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLocation"


    // $ANTLR start "entryRulePaths"
    // InternalMyDsl.g:128:1: entryRulePaths : rulePaths EOF ;
    public final void entryRulePaths() throws RecognitionException {
        try {
            // InternalMyDsl.g:129:1: ( rulePaths EOF )
            // InternalMyDsl.g:130:1: rulePaths EOF
            {
             before(grammarAccess.getPathsRule()); 
            pushFollow(FOLLOW_1);
            rulePaths();

            state._fsp--;

             after(grammarAccess.getPathsRule()); 
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
    // $ANTLR end "entryRulePaths"


    // $ANTLR start "rulePaths"
    // InternalMyDsl.g:137:1: rulePaths : ( ( rule__Paths__Group__0 ) ) ;
    public final void rulePaths() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:141:2: ( ( ( rule__Paths__Group__0 ) ) )
            // InternalMyDsl.g:142:2: ( ( rule__Paths__Group__0 ) )
            {
            // InternalMyDsl.g:142:2: ( ( rule__Paths__Group__0 ) )
            // InternalMyDsl.g:143:3: ( rule__Paths__Group__0 )
            {
             before(grammarAccess.getPathsAccess().getGroup()); 
            // InternalMyDsl.g:144:3: ( rule__Paths__Group__0 )
            // InternalMyDsl.g:144:4: rule__Paths__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Paths__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPathsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePaths"


    // $ANTLR start "entryRuleTasksModel"
    // InternalMyDsl.g:153:1: entryRuleTasksModel : ruleTasksModel EOF ;
    public final void entryRuleTasksModel() throws RecognitionException {
        try {
            // InternalMyDsl.g:154:1: ( ruleTasksModel EOF )
            // InternalMyDsl.g:155:1: ruleTasksModel EOF
            {
             before(grammarAccess.getTasksModelRule()); 
            pushFollow(FOLLOW_1);
            ruleTasksModel();

            state._fsp--;

             after(grammarAccess.getTasksModelRule()); 
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
    // $ANTLR end "entryRuleTasksModel"


    // $ANTLR start "ruleTasksModel"
    // InternalMyDsl.g:162:1: ruleTasksModel : ( ( rule__TasksModel__Alternatives ) ) ;
    public final void ruleTasksModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:166:2: ( ( ( rule__TasksModel__Alternatives ) ) )
            // InternalMyDsl.g:167:2: ( ( rule__TasksModel__Alternatives ) )
            {
            // InternalMyDsl.g:167:2: ( ( rule__TasksModel__Alternatives ) )
            // InternalMyDsl.g:168:3: ( rule__TasksModel__Alternatives )
            {
             before(grammarAccess.getTasksModelAccess().getAlternatives()); 
            // InternalMyDsl.g:169:3: ( rule__TasksModel__Alternatives )
            // InternalMyDsl.g:169:4: rule__TasksModel__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TasksModel__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTasksModelAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTasksModel"


    // $ANTLR start "entryRuleAtomicTask"
    // InternalMyDsl.g:178:1: entryRuleAtomicTask : ruleAtomicTask EOF ;
    public final void entryRuleAtomicTask() throws RecognitionException {
        try {
            // InternalMyDsl.g:179:1: ( ruleAtomicTask EOF )
            // InternalMyDsl.g:180:1: ruleAtomicTask EOF
            {
             before(grammarAccess.getAtomicTaskRule()); 
            pushFollow(FOLLOW_1);
            ruleAtomicTask();

            state._fsp--;

             after(grammarAccess.getAtomicTaskRule()); 
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
    // $ANTLR end "entryRuleAtomicTask"


    // $ANTLR start "ruleAtomicTask"
    // InternalMyDsl.g:187:1: ruleAtomicTask : ( ( rule__AtomicTask__Group__0 ) ) ;
    public final void ruleAtomicTask() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:191:2: ( ( ( rule__AtomicTask__Group__0 ) ) )
            // InternalMyDsl.g:192:2: ( ( rule__AtomicTask__Group__0 ) )
            {
            // InternalMyDsl.g:192:2: ( ( rule__AtomicTask__Group__0 ) )
            // InternalMyDsl.g:193:3: ( rule__AtomicTask__Group__0 )
            {
             before(grammarAccess.getAtomicTaskAccess().getGroup()); 
            // InternalMyDsl.g:194:3: ( rule__AtomicTask__Group__0 )
            // InternalMyDsl.g:194:4: rule__AtomicTask__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AtomicTask__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAtomicTaskAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtomicTask"


    // $ANTLR start "entryRuleCompoundTask"
    // InternalMyDsl.g:203:1: entryRuleCompoundTask : ruleCompoundTask EOF ;
    public final void entryRuleCompoundTask() throws RecognitionException {
        try {
            // InternalMyDsl.g:204:1: ( ruleCompoundTask EOF )
            // InternalMyDsl.g:205:1: ruleCompoundTask EOF
            {
             before(grammarAccess.getCompoundTaskRule()); 
            pushFollow(FOLLOW_1);
            ruleCompoundTask();

            state._fsp--;

             after(grammarAccess.getCompoundTaskRule()); 
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
    // $ANTLR end "entryRuleCompoundTask"


    // $ANTLR start "ruleCompoundTask"
    // InternalMyDsl.g:212:1: ruleCompoundTask : ( ( rule__CompoundTask__Group__0 ) ) ;
    public final void ruleCompoundTask() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:216:2: ( ( ( rule__CompoundTask__Group__0 ) ) )
            // InternalMyDsl.g:217:2: ( ( rule__CompoundTask__Group__0 ) )
            {
            // InternalMyDsl.g:217:2: ( ( rule__CompoundTask__Group__0 ) )
            // InternalMyDsl.g:218:3: ( rule__CompoundTask__Group__0 )
            {
             before(grammarAccess.getCompoundTaskAccess().getGroup()); 
            // InternalMyDsl.g:219:3: ( rule__CompoundTask__Group__0 )
            // InternalMyDsl.g:219:4: rule__CompoundTask__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCompoundTaskAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCompoundTask"


    // $ANTLR start "entryRuleRobot"
    // InternalMyDsl.g:228:1: entryRuleRobot : ruleRobot EOF ;
    public final void entryRuleRobot() throws RecognitionException {
        try {
            // InternalMyDsl.g:229:1: ( ruleRobot EOF )
            // InternalMyDsl.g:230:1: ruleRobot EOF
            {
             before(grammarAccess.getRobotRule()); 
            pushFollow(FOLLOW_1);
            ruleRobot();

            state._fsp--;

             after(grammarAccess.getRobotRule()); 
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
    // $ANTLR end "entryRuleRobot"


    // $ANTLR start "ruleRobot"
    // InternalMyDsl.g:237:1: ruleRobot : ( ( rule__Robot__Group__0 ) ) ;
    public final void ruleRobot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:241:2: ( ( ( rule__Robot__Group__0 ) ) )
            // InternalMyDsl.g:242:2: ( ( rule__Robot__Group__0 ) )
            {
            // InternalMyDsl.g:242:2: ( ( rule__Robot__Group__0 ) )
            // InternalMyDsl.g:243:3: ( rule__Robot__Group__0 )
            {
             before(grammarAccess.getRobotAccess().getGroup()); 
            // InternalMyDsl.g:244:3: ( rule__Robot__Group__0 )
            // InternalMyDsl.g:244:4: rule__Robot__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Robot__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRobotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRobot"


    // $ANTLR start "entryRuleCapability"
    // InternalMyDsl.g:253:1: entryRuleCapability : ruleCapability EOF ;
    public final void entryRuleCapability() throws RecognitionException {
        try {
            // InternalMyDsl.g:254:1: ( ruleCapability EOF )
            // InternalMyDsl.g:255:1: ruleCapability EOF
            {
             before(grammarAccess.getCapabilityRule()); 
            pushFollow(FOLLOW_1);
            ruleCapability();

            state._fsp--;

             after(grammarAccess.getCapabilityRule()); 
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
    // $ANTLR end "entryRuleCapability"


    // $ANTLR start "ruleCapability"
    // InternalMyDsl.g:262:1: ruleCapability : ( ( rule__Capability__Group__0 ) ) ;
    public final void ruleCapability() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:266:2: ( ( ( rule__Capability__Group__0 ) ) )
            // InternalMyDsl.g:267:2: ( ( rule__Capability__Group__0 ) )
            {
            // InternalMyDsl.g:267:2: ( ( rule__Capability__Group__0 ) )
            // InternalMyDsl.g:268:3: ( rule__Capability__Group__0 )
            {
             before(grammarAccess.getCapabilityAccess().getGroup()); 
            // InternalMyDsl.g:269:3: ( rule__Capability__Group__0 )
            // InternalMyDsl.g:269:4: rule__Capability__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Capability__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCapabilityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCapability"


    // $ANTLR start "entryRuleMission"
    // InternalMyDsl.g:278:1: entryRuleMission : ruleMission EOF ;
    public final void entryRuleMission() throws RecognitionException {
        try {
            // InternalMyDsl.g:279:1: ( ruleMission EOF )
            // InternalMyDsl.g:280:1: ruleMission EOF
            {
             before(grammarAccess.getMissionRule()); 
            pushFollow(FOLLOW_1);
            ruleMission();

            state._fsp--;

             after(grammarAccess.getMissionRule()); 
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
    // $ANTLR end "entryRuleMission"


    // $ANTLR start "ruleMission"
    // InternalMyDsl.g:287:1: ruleMission : ( ( rule__Mission__Group__0 ) ) ;
    public final void ruleMission() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:291:2: ( ( ( rule__Mission__Group__0 ) ) )
            // InternalMyDsl.g:292:2: ( ( rule__Mission__Group__0 ) )
            {
            // InternalMyDsl.g:292:2: ( ( rule__Mission__Group__0 ) )
            // InternalMyDsl.g:293:3: ( rule__Mission__Group__0 )
            {
             before(grammarAccess.getMissionAccess().getGroup()); 
            // InternalMyDsl.g:294:3: ( rule__Mission__Group__0 )
            // InternalMyDsl.g:294:4: rule__Mission__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMission"


    // $ANTLR start "entryRuleMissionTask"
    // InternalMyDsl.g:303:1: entryRuleMissionTask : ruleMissionTask EOF ;
    public final void entryRuleMissionTask() throws RecognitionException {
        try {
            // InternalMyDsl.g:304:1: ( ruleMissionTask EOF )
            // InternalMyDsl.g:305:1: ruleMissionTask EOF
            {
             before(grammarAccess.getMissionTaskRule()); 
            pushFollow(FOLLOW_1);
            ruleMissionTask();

            state._fsp--;

             after(grammarAccess.getMissionTaskRule()); 
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
    // $ANTLR end "entryRuleMissionTask"


    // $ANTLR start "ruleMissionTask"
    // InternalMyDsl.g:312:1: ruleMissionTask : ( ( rule__MissionTask__Group__0 ) ) ;
    public final void ruleMissionTask() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:316:2: ( ( ( rule__MissionTask__Group__0 ) ) )
            // InternalMyDsl.g:317:2: ( ( rule__MissionTask__Group__0 ) )
            {
            // InternalMyDsl.g:317:2: ( ( rule__MissionTask__Group__0 ) )
            // InternalMyDsl.g:318:3: ( rule__MissionTask__Group__0 )
            {
             before(grammarAccess.getMissionTaskAccess().getGroup()); 
            // InternalMyDsl.g:319:3: ( rule__MissionTask__Group__0 )
            // InternalMyDsl.g:319:4: rule__MissionTask__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MissionTask__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMissionTaskAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMissionTask"


    // $ANTLR start "entryRuleConstraints"
    // InternalMyDsl.g:328:1: entryRuleConstraints : ruleConstraints EOF ;
    public final void entryRuleConstraints() throws RecognitionException {
        try {
            // InternalMyDsl.g:329:1: ( ruleConstraints EOF )
            // InternalMyDsl.g:330:1: ruleConstraints EOF
            {
             before(grammarAccess.getConstraintsRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraints();

            state._fsp--;

             after(grammarAccess.getConstraintsRule()); 
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
    // $ANTLR end "entryRuleConstraints"


    // $ANTLR start "ruleConstraints"
    // InternalMyDsl.g:337:1: ruleConstraints : ( ( rule__Constraints__Alternatives ) ) ;
    public final void ruleConstraints() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:341:2: ( ( ( rule__Constraints__Alternatives ) ) )
            // InternalMyDsl.g:342:2: ( ( rule__Constraints__Alternatives ) )
            {
            // InternalMyDsl.g:342:2: ( ( rule__Constraints__Alternatives ) )
            // InternalMyDsl.g:343:3: ( rule__Constraints__Alternatives )
            {
             before(grammarAccess.getConstraintsAccess().getAlternatives()); 
            // InternalMyDsl.g:344:3: ( rule__Constraints__Alternatives )
            // InternalMyDsl.g:344:4: rule__Constraints__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Constraints__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConstraintsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraints"


    // $ANTLR start "entryRuleRateSucc"
    // InternalMyDsl.g:353:1: entryRuleRateSucc : ruleRateSucc EOF ;
    public final void entryRuleRateSucc() throws RecognitionException {
        try {
            // InternalMyDsl.g:354:1: ( ruleRateSucc EOF )
            // InternalMyDsl.g:355:1: ruleRateSucc EOF
            {
             before(grammarAccess.getRateSuccRule()); 
            pushFollow(FOLLOW_1);
            ruleRateSucc();

            state._fsp--;

             after(grammarAccess.getRateSuccRule()); 
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
    // $ANTLR end "entryRuleRateSucc"


    // $ANTLR start "ruleRateSucc"
    // InternalMyDsl.g:362:1: ruleRateSucc : ( ( rule__RateSucc__Group__0 ) ) ;
    public final void ruleRateSucc() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:366:2: ( ( ( rule__RateSucc__Group__0 ) ) )
            // InternalMyDsl.g:367:2: ( ( rule__RateSucc__Group__0 ) )
            {
            // InternalMyDsl.g:367:2: ( ( rule__RateSucc__Group__0 ) )
            // InternalMyDsl.g:368:3: ( rule__RateSucc__Group__0 )
            {
             before(grammarAccess.getRateSuccAccess().getGroup()); 
            // InternalMyDsl.g:369:3: ( rule__RateSucc__Group__0 )
            // InternalMyDsl.g:369:4: rule__RateSucc__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RateSucc__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRateSuccAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRateSucc"


    // $ANTLR start "entryRuleSpaceXYRobot"
    // InternalMyDsl.g:378:1: entryRuleSpaceXYRobot : ruleSpaceXYRobot EOF ;
    public final void entryRuleSpaceXYRobot() throws RecognitionException {
        try {
            // InternalMyDsl.g:379:1: ( ruleSpaceXYRobot EOF )
            // InternalMyDsl.g:380:1: ruleSpaceXYRobot EOF
            {
             before(grammarAccess.getSpaceXYRobotRule()); 
            pushFollow(FOLLOW_1);
            ruleSpaceXYRobot();

            state._fsp--;

             after(grammarAccess.getSpaceXYRobotRule()); 
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
    // $ANTLR end "entryRuleSpaceXYRobot"


    // $ANTLR start "ruleSpaceXYRobot"
    // InternalMyDsl.g:387:1: ruleSpaceXYRobot : ( ( rule__SpaceXYRobot__Group__0 ) ) ;
    public final void ruleSpaceXYRobot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:391:2: ( ( ( rule__SpaceXYRobot__Group__0 ) ) )
            // InternalMyDsl.g:392:2: ( ( rule__SpaceXYRobot__Group__0 ) )
            {
            // InternalMyDsl.g:392:2: ( ( rule__SpaceXYRobot__Group__0 ) )
            // InternalMyDsl.g:393:3: ( rule__SpaceXYRobot__Group__0 )
            {
             before(grammarAccess.getSpaceXYRobotAccess().getGroup()); 
            // InternalMyDsl.g:394:3: ( rule__SpaceXYRobot__Group__0 )
            // InternalMyDsl.g:394:4: rule__SpaceXYRobot__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSpaceXYRobotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSpaceXYRobot"


    // $ANTLR start "entryRuleTaskTime"
    // InternalMyDsl.g:403:1: entryRuleTaskTime : ruleTaskTime EOF ;
    public final void entryRuleTaskTime() throws RecognitionException {
        try {
            // InternalMyDsl.g:404:1: ( ruleTaskTime EOF )
            // InternalMyDsl.g:405:1: ruleTaskTime EOF
            {
             before(grammarAccess.getTaskTimeRule()); 
            pushFollow(FOLLOW_1);
            ruleTaskTime();

            state._fsp--;

             after(grammarAccess.getTaskTimeRule()); 
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
    // $ANTLR end "entryRuleTaskTime"


    // $ANTLR start "ruleTaskTime"
    // InternalMyDsl.g:412:1: ruleTaskTime : ( ( rule__TaskTime__Group__0 ) ) ;
    public final void ruleTaskTime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:416:2: ( ( ( rule__TaskTime__Group__0 ) ) )
            // InternalMyDsl.g:417:2: ( ( rule__TaskTime__Group__0 ) )
            {
            // InternalMyDsl.g:417:2: ( ( rule__TaskTime__Group__0 ) )
            // InternalMyDsl.g:418:3: ( rule__TaskTime__Group__0 )
            {
             before(grammarAccess.getTaskTimeAccess().getGroup()); 
            // InternalMyDsl.g:419:3: ( rule__TaskTime__Group__0 )
            // InternalMyDsl.g:419:4: rule__TaskTime__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTaskTimeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTaskTime"


    // $ANTLR start "entryRuleAllocateT"
    // InternalMyDsl.g:428:1: entryRuleAllocateT : ruleAllocateT EOF ;
    public final void entryRuleAllocateT() throws RecognitionException {
        try {
            // InternalMyDsl.g:429:1: ( ruleAllocateT EOF )
            // InternalMyDsl.g:430:1: ruleAllocateT EOF
            {
             before(grammarAccess.getAllocateTRule()); 
            pushFollow(FOLLOW_1);
            ruleAllocateT();

            state._fsp--;

             after(grammarAccess.getAllocateTRule()); 
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
    // $ANTLR end "entryRuleAllocateT"


    // $ANTLR start "ruleAllocateT"
    // InternalMyDsl.g:437:1: ruleAllocateT : ( ( rule__AllocateT__Group__0 ) ) ;
    public final void ruleAllocateT() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:441:2: ( ( ( rule__AllocateT__Group__0 ) ) )
            // InternalMyDsl.g:442:2: ( ( rule__AllocateT__Group__0 ) )
            {
            // InternalMyDsl.g:442:2: ( ( rule__AllocateT__Group__0 ) )
            // InternalMyDsl.g:443:3: ( rule__AllocateT__Group__0 )
            {
             before(grammarAccess.getAllocateTAccess().getGroup()); 
            // InternalMyDsl.g:444:3: ( rule__AllocateT__Group__0 )
            // InternalMyDsl.g:444:4: rule__AllocateT__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AllocateT__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAllocateTAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAllocateT"


    // $ANTLR start "entryRuleClosest"
    // InternalMyDsl.g:453:1: entryRuleClosest : ruleClosest EOF ;
    public final void entryRuleClosest() throws RecognitionException {
        try {
            // InternalMyDsl.g:454:1: ( ruleClosest EOF )
            // InternalMyDsl.g:455:1: ruleClosest EOF
            {
             before(grammarAccess.getClosestRule()); 
            pushFollow(FOLLOW_1);
            ruleClosest();

            state._fsp--;

             after(grammarAccess.getClosestRule()); 
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
    // $ANTLR end "entryRuleClosest"


    // $ANTLR start "ruleClosest"
    // InternalMyDsl.g:462:1: ruleClosest : ( ( rule__Closest__Group__0 ) ) ;
    public final void ruleClosest() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:466:2: ( ( ( rule__Closest__Group__0 ) ) )
            // InternalMyDsl.g:467:2: ( ( rule__Closest__Group__0 ) )
            {
            // InternalMyDsl.g:467:2: ( ( rule__Closest__Group__0 ) )
            // InternalMyDsl.g:468:3: ( rule__Closest__Group__0 )
            {
             before(grammarAccess.getClosestAccess().getGroup()); 
            // InternalMyDsl.g:469:3: ( rule__Closest__Group__0 )
            // InternalMyDsl.g:469:4: rule__Closest__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Closest__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClosestAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClosest"


    // $ANTLR start "entryRuleMaxTasks"
    // InternalMyDsl.g:478:1: entryRuleMaxTasks : ruleMaxTasks EOF ;
    public final void entryRuleMaxTasks() throws RecognitionException {
        try {
            // InternalMyDsl.g:479:1: ( ruleMaxTasks EOF )
            // InternalMyDsl.g:480:1: ruleMaxTasks EOF
            {
             before(grammarAccess.getMaxTasksRule()); 
            pushFollow(FOLLOW_1);
            ruleMaxTasks();

            state._fsp--;

             after(grammarAccess.getMaxTasksRule()); 
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
    // $ANTLR end "entryRuleMaxTasks"


    // $ANTLR start "ruleMaxTasks"
    // InternalMyDsl.g:487:1: ruleMaxTasks : ( ( rule__MaxTasks__Group__0 ) ) ;
    public final void ruleMaxTasks() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:491:2: ( ( ( rule__MaxTasks__Group__0 ) ) )
            // InternalMyDsl.g:492:2: ( ( rule__MaxTasks__Group__0 ) )
            {
            // InternalMyDsl.g:492:2: ( ( rule__MaxTasks__Group__0 ) )
            // InternalMyDsl.g:493:3: ( rule__MaxTasks__Group__0 )
            {
             before(grammarAccess.getMaxTasksAccess().getGroup()); 
            // InternalMyDsl.g:494:3: ( rule__MaxTasks__Group__0 )
            // InternalMyDsl.g:494:4: rule__MaxTasks__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMaxTasksAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMaxTasks"


    // $ANTLR start "entryRuleEInt"
    // InternalMyDsl.g:503:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalMyDsl.g:504:1: ( ruleEInt EOF )
            // InternalMyDsl.g:505:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
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
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalMyDsl.g:512:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:516:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalMyDsl.g:517:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalMyDsl.g:517:2: ( ( rule__EInt__Group__0 ) )
            // InternalMyDsl.g:518:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalMyDsl.g:519:3: ( rule__EInt__Group__0 )
            // InternalMyDsl.g:519:4: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEString"
    // InternalMyDsl.g:528:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalMyDsl.g:529:1: ( ruleEString EOF )
            // InternalMyDsl.g:530:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalMyDsl.g:537:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:541:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalMyDsl.g:542:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalMyDsl.g:542:2: ( ( rule__EString__Alternatives ) )
            // InternalMyDsl.g:543:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalMyDsl.g:544:3: ( rule__EString__Alternatives )
            // InternalMyDsl.g:544:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEDouble"
    // InternalMyDsl.g:553:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalMyDsl.g:554:1: ( ruleEDouble EOF )
            // InternalMyDsl.g:555:1: ruleEDouble EOF
            {
             before(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getEDoubleRule()); 
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
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalMyDsl.g:562:1: ruleEDouble : ( ( rule__EDouble__Group__0 ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:566:2: ( ( ( rule__EDouble__Group__0 ) ) )
            // InternalMyDsl.g:567:2: ( ( rule__EDouble__Group__0 ) )
            {
            // InternalMyDsl.g:567:2: ( ( rule__EDouble__Group__0 ) )
            // InternalMyDsl.g:568:3: ( rule__EDouble__Group__0 )
            {
             before(grammarAccess.getEDoubleAccess().getGroup()); 
            // InternalMyDsl.g:569:3: ( rule__EDouble__Group__0 )
            // InternalMyDsl.g:569:4: rule__EDouble__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "ruleObjective"
    // InternalMyDsl.g:578:1: ruleObjective : ( ( rule__Objective__Alternatives ) ) ;
    public final void ruleObjective() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:582:1: ( ( ( rule__Objective__Alternatives ) ) )
            // InternalMyDsl.g:583:2: ( ( rule__Objective__Alternatives ) )
            {
            // InternalMyDsl.g:583:2: ( ( rule__Objective__Alternatives ) )
            // InternalMyDsl.g:584:3: ( rule__Objective__Alternatives )
            {
             before(grammarAccess.getObjectiveAccess().getAlternatives()); 
            // InternalMyDsl.g:585:3: ( rule__Objective__Alternatives )
            // InternalMyDsl.g:585:4: rule__Objective__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Objective__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getObjectiveAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjective"


    // $ANTLR start "ruleXY"
    // InternalMyDsl.g:594:1: ruleXY : ( ( rule__XY__Alternatives ) ) ;
    public final void ruleXY() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:598:1: ( ( ( rule__XY__Alternatives ) ) )
            // InternalMyDsl.g:599:2: ( ( rule__XY__Alternatives ) )
            {
            // InternalMyDsl.g:599:2: ( ( rule__XY__Alternatives ) )
            // InternalMyDsl.g:600:3: ( rule__XY__Alternatives )
            {
             before(grammarAccess.getXYAccess().getAlternatives()); 
            // InternalMyDsl.g:601:3: ( rule__XY__Alternatives )
            // InternalMyDsl.g:601:4: rule__XY__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__XY__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getXYAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXY"


    // $ANTLR start "ruleLowerGreater"
    // InternalMyDsl.g:610:1: ruleLowerGreater : ( ( rule__LowerGreater__Alternatives ) ) ;
    public final void ruleLowerGreater() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:614:1: ( ( ( rule__LowerGreater__Alternatives ) ) )
            // InternalMyDsl.g:615:2: ( ( rule__LowerGreater__Alternatives ) )
            {
            // InternalMyDsl.g:615:2: ( ( rule__LowerGreater__Alternatives ) )
            // InternalMyDsl.g:616:3: ( rule__LowerGreater__Alternatives )
            {
             before(grammarAccess.getLowerGreaterAccess().getAlternatives()); 
            // InternalMyDsl.g:617:3: ( rule__LowerGreater__Alternatives )
            // InternalMyDsl.g:617:4: rule__LowerGreater__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LowerGreater__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLowerGreaterAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLowerGreater"


    // $ANTLR start "ruleStartEnd"
    // InternalMyDsl.g:626:1: ruleStartEnd : ( ( rule__StartEnd__Alternatives ) ) ;
    public final void ruleStartEnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:630:1: ( ( ( rule__StartEnd__Alternatives ) ) )
            // InternalMyDsl.g:631:2: ( ( rule__StartEnd__Alternatives ) )
            {
            // InternalMyDsl.g:631:2: ( ( rule__StartEnd__Alternatives ) )
            // InternalMyDsl.g:632:3: ( rule__StartEnd__Alternatives )
            {
             before(grammarAccess.getStartEndAccess().getAlternatives()); 
            // InternalMyDsl.g:633:3: ( rule__StartEnd__Alternatives )
            // InternalMyDsl.g:633:4: rule__StartEnd__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__StartEnd__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStartEndAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStartEnd"


    // $ANTLR start "rule__WorldModel__Alternatives"
    // InternalMyDsl.g:641:1: rule__WorldModel__Alternatives : ( ( ruleLocation ) | ( rulePaths ) );
    public final void rule__WorldModel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:645:1: ( ( ruleLocation ) | ( rulePaths ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                alt1=1;
            }
            else if ( (LA1_0==36) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalMyDsl.g:646:2: ( ruleLocation )
                    {
                    // InternalMyDsl.g:646:2: ( ruleLocation )
                    // InternalMyDsl.g:647:3: ruleLocation
                    {
                     before(grammarAccess.getWorldModelAccess().getLocationParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLocation();

                    state._fsp--;

                     after(grammarAccess.getWorldModelAccess().getLocationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:652:2: ( rulePaths )
                    {
                    // InternalMyDsl.g:652:2: ( rulePaths )
                    // InternalMyDsl.g:653:3: rulePaths
                    {
                     before(grammarAccess.getWorldModelAccess().getPathsParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePaths();

                    state._fsp--;

                     after(grammarAccess.getWorldModelAccess().getPathsParserRuleCall_1()); 

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
    // $ANTLR end "rule__WorldModel__Alternatives"


    // $ANTLR start "rule__TasksModel__Alternatives"
    // InternalMyDsl.g:662:1: rule__TasksModel__Alternatives : ( ( ruleAtomicTask ) | ( ruleCompoundTask ) );
    public final void rule__TasksModel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:666:1: ( ( ruleAtomicTask ) | ( ruleCompoundTask ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==27) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==RULE_INT||LA2_3==79) ) {
                        alt2=1;
                    }
                    else if ( (LA2_3==42) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==RULE_ID) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==27) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==RULE_INT||LA2_3==79) ) {
                        alt2=1;
                    }
                    else if ( (LA2_3==42) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMyDsl.g:667:2: ( ruleAtomicTask )
                    {
                    // InternalMyDsl.g:667:2: ( ruleAtomicTask )
                    // InternalMyDsl.g:668:3: ruleAtomicTask
                    {
                     before(grammarAccess.getTasksModelAccess().getAtomicTaskParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleAtomicTask();

                    state._fsp--;

                     after(grammarAccess.getTasksModelAccess().getAtomicTaskParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:673:2: ( ruleCompoundTask )
                    {
                    // InternalMyDsl.g:673:2: ( ruleCompoundTask )
                    // InternalMyDsl.g:674:3: ruleCompoundTask
                    {
                     before(grammarAccess.getTasksModelAccess().getCompoundTaskParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleCompoundTask();

                    state._fsp--;

                     after(grammarAccess.getTasksModelAccess().getCompoundTaskParserRuleCall_1()); 

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
    // $ANTLR end "rule__TasksModel__Alternatives"


    // $ANTLR start "rule__AtomicTask__Alternatives_3"
    // InternalMyDsl.g:683:1: rule__AtomicTask__Alternatives_3 : ( ( 'robots' ) | ( 'robot' ) );
    public final void rule__AtomicTask__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:687:1: ( ( 'robots' ) | ( 'robot' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMyDsl.g:688:2: ( 'robots' )
                    {
                    // InternalMyDsl.g:688:2: ( 'robots' )
                    // InternalMyDsl.g:689:3: 'robots'
                    {
                     before(grammarAccess.getAtomicTaskAccess().getRobotsKeyword_3_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getAtomicTaskAccess().getRobotsKeyword_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:694:2: ( 'robot' )
                    {
                    // InternalMyDsl.g:694:2: ( 'robot' )
                    // InternalMyDsl.g:695:3: 'robot'
                    {
                     before(grammarAccess.getAtomicTaskAccess().getRobotKeyword_3_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getAtomicTaskAccess().getRobotKeyword_3_1()); 

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
    // $ANTLR end "rule__AtomicTask__Alternatives_3"


    // $ANTLR start "rule__CompoundTask__Alternatives_6"
    // InternalMyDsl.g:704:1: rule__CompoundTask__Alternatives_6 : ( ( ( rule__CompoundTask__Group_6_0__0 ) ) | ( ( rule__CompoundTask__Group_6_1__0 ) ) );
    public final void rule__CompoundTask__Alternatives_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:708:1: ( ( ( rule__CompoundTask__Group_6_0__0 ) ) | ( ( rule__CompoundTask__Group_6_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==45) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==82) ) {
                    alt4=2;
                }
                else if ( (LA4_1==81) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMyDsl.g:709:2: ( ( rule__CompoundTask__Group_6_0__0 ) )
                    {
                    // InternalMyDsl.g:709:2: ( ( rule__CompoundTask__Group_6_0__0 ) )
                    // InternalMyDsl.g:710:3: ( rule__CompoundTask__Group_6_0__0 )
                    {
                     before(grammarAccess.getCompoundTaskAccess().getGroup_6_0()); 
                    // InternalMyDsl.g:711:3: ( rule__CompoundTask__Group_6_0__0 )
                    // InternalMyDsl.g:711:4: rule__CompoundTask__Group_6_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CompoundTask__Group_6_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCompoundTaskAccess().getGroup_6_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:715:2: ( ( rule__CompoundTask__Group_6_1__0 ) )
                    {
                    // InternalMyDsl.g:715:2: ( ( rule__CompoundTask__Group_6_1__0 ) )
                    // InternalMyDsl.g:716:3: ( rule__CompoundTask__Group_6_1__0 )
                    {
                     before(grammarAccess.getCompoundTaskAccess().getGroup_6_1()); 
                    // InternalMyDsl.g:717:3: ( rule__CompoundTask__Group_6_1__0 )
                    // InternalMyDsl.g:717:4: rule__CompoundTask__Group_6_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CompoundTask__Group_6_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCompoundTaskAccess().getGroup_6_1()); 

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
    // $ANTLR end "rule__CompoundTask__Alternatives_6"


    // $ANTLR start "rule__MissionTask__Alternatives_3"
    // InternalMyDsl.g:725:1: rule__MissionTask__Alternatives_3 : ( ( ( rule__MissionTask__Group_3_0__0 ) ) | ( ( rule__MissionTask__Group_3_1__0 ) ) );
    public final void rule__MissionTask__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:729:1: ( ( ( rule__MissionTask__Group_3_0__0 ) ) | ( ( rule__MissionTask__Group_3_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==63) ) {
                alt5=1;
            }
            else if ( (LA5_0==65) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalMyDsl.g:730:2: ( ( rule__MissionTask__Group_3_0__0 ) )
                    {
                    // InternalMyDsl.g:730:2: ( ( rule__MissionTask__Group_3_0__0 ) )
                    // InternalMyDsl.g:731:3: ( rule__MissionTask__Group_3_0__0 )
                    {
                     before(grammarAccess.getMissionTaskAccess().getGroup_3_0()); 
                    // InternalMyDsl.g:732:3: ( rule__MissionTask__Group_3_0__0 )
                    // InternalMyDsl.g:732:4: rule__MissionTask__Group_3_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MissionTask__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMissionTaskAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:736:2: ( ( rule__MissionTask__Group_3_1__0 ) )
                    {
                    // InternalMyDsl.g:736:2: ( ( rule__MissionTask__Group_3_1__0 ) )
                    // InternalMyDsl.g:737:3: ( rule__MissionTask__Group_3_1__0 )
                    {
                     before(grammarAccess.getMissionTaskAccess().getGroup_3_1()); 
                    // InternalMyDsl.g:738:3: ( rule__MissionTask__Group_3_1__0 )
                    // InternalMyDsl.g:738:4: rule__MissionTask__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MissionTask__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMissionTaskAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__MissionTask__Alternatives_3"


    // $ANTLR start "rule__Constraints__Alternatives"
    // InternalMyDsl.g:746:1: rule__Constraints__Alternatives : ( ( ruleRateSucc ) | ( ruleSpaceXYRobot ) | ( ruleTaskTime ) | ( ruleAllocateT ) | ( ruleClosest ) | ( ruleMaxTasks ) );
    public final void rule__Constraints__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:750:1: ( ( ruleRateSucc ) | ( ruleSpaceXYRobot ) | ( ruleTaskTime ) | ( ruleAllocateT ) | ( ruleClosest ) | ( ruleMaxTasks ) )
            int alt6=6;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:751:2: ( ruleRateSucc )
                    {
                    // InternalMyDsl.g:751:2: ( ruleRateSucc )
                    // InternalMyDsl.g:752:3: ruleRateSucc
                    {
                     before(grammarAccess.getConstraintsAccess().getRateSuccParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleRateSucc();

                    state._fsp--;

                     after(grammarAccess.getConstraintsAccess().getRateSuccParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:757:2: ( ruleSpaceXYRobot )
                    {
                    // InternalMyDsl.g:757:2: ( ruleSpaceXYRobot )
                    // InternalMyDsl.g:758:3: ruleSpaceXYRobot
                    {
                     before(grammarAccess.getConstraintsAccess().getSpaceXYRobotParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleSpaceXYRobot();

                    state._fsp--;

                     after(grammarAccess.getConstraintsAccess().getSpaceXYRobotParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:763:2: ( ruleTaskTime )
                    {
                    // InternalMyDsl.g:763:2: ( ruleTaskTime )
                    // InternalMyDsl.g:764:3: ruleTaskTime
                    {
                     before(grammarAccess.getConstraintsAccess().getTaskTimeParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleTaskTime();

                    state._fsp--;

                     after(grammarAccess.getConstraintsAccess().getTaskTimeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:769:2: ( ruleAllocateT )
                    {
                    // InternalMyDsl.g:769:2: ( ruleAllocateT )
                    // InternalMyDsl.g:770:3: ruleAllocateT
                    {
                     before(grammarAccess.getConstraintsAccess().getAllocateTParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleAllocateT();

                    state._fsp--;

                     after(grammarAccess.getConstraintsAccess().getAllocateTParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:775:2: ( ruleClosest )
                    {
                    // InternalMyDsl.g:775:2: ( ruleClosest )
                    // InternalMyDsl.g:776:3: ruleClosest
                    {
                     before(grammarAccess.getConstraintsAccess().getClosestParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleClosest();

                    state._fsp--;

                     after(grammarAccess.getConstraintsAccess().getClosestParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:781:2: ( ruleMaxTasks )
                    {
                    // InternalMyDsl.g:781:2: ( ruleMaxTasks )
                    // InternalMyDsl.g:782:3: ruleMaxTasks
                    {
                     before(grammarAccess.getConstraintsAccess().getMaxTasksParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleMaxTasks();

                    state._fsp--;

                     after(grammarAccess.getConstraintsAccess().getMaxTasksParserRuleCall_5()); 

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
    // $ANTLR end "rule__Constraints__Alternatives"


    // $ANTLR start "rule__SpaceXYRobot__Alternatives_0"
    // InternalMyDsl.g:791:1: rule__SpaceXYRobot__Alternatives_0 : ( ( ( rule__SpaceXYRobot__Group_0_0__0 ) ) | ( ( rule__SpaceXYRobot__Group_0_1__0 ) ) );
    public final void rule__SpaceXYRobot__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:795:1: ( ( ( rule__SpaceXYRobot__Group_0_0__0 ) ) | ( ( rule__SpaceXYRobot__Group_0_1__0 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==12) ) {
                alt7=1;
            }
            else if ( (LA7_0==83) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalMyDsl.g:796:2: ( ( rule__SpaceXYRobot__Group_0_0__0 ) )
                    {
                    // InternalMyDsl.g:796:2: ( ( rule__SpaceXYRobot__Group_0_0__0 ) )
                    // InternalMyDsl.g:797:3: ( rule__SpaceXYRobot__Group_0_0__0 )
                    {
                     before(grammarAccess.getSpaceXYRobotAccess().getGroup_0_0()); 
                    // InternalMyDsl.g:798:3: ( rule__SpaceXYRobot__Group_0_0__0 )
                    // InternalMyDsl.g:798:4: rule__SpaceXYRobot__Group_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SpaceXYRobot__Group_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSpaceXYRobotAccess().getGroup_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:802:2: ( ( rule__SpaceXYRobot__Group_0_1__0 ) )
                    {
                    // InternalMyDsl.g:802:2: ( ( rule__SpaceXYRobot__Group_0_1__0 ) )
                    // InternalMyDsl.g:803:3: ( rule__SpaceXYRobot__Group_0_1__0 )
                    {
                     before(grammarAccess.getSpaceXYRobotAccess().getGroup_0_1()); 
                    // InternalMyDsl.g:804:3: ( rule__SpaceXYRobot__Group_0_1__0 )
                    // InternalMyDsl.g:804:4: rule__SpaceXYRobot__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SpaceXYRobot__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSpaceXYRobotAccess().getGroup_0_1()); 

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
    // $ANTLR end "rule__SpaceXYRobot__Alternatives_0"


    // $ANTLR start "rule__TaskTime__Alternatives_0"
    // InternalMyDsl.g:812:1: rule__TaskTime__Alternatives_0 : ( ( ( rule__TaskTime__Group_0_0__0 ) ) | ( ( rule__TaskTime__Group_0_1__0 ) ) | ( ( rule__TaskTime__Group_0_2__0 ) ) );
    public final void rule__TaskTime__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:816:1: ( ( ( rule__TaskTime__Group_0_0__0 ) ) | ( ( rule__TaskTime__Group_0_1__0 ) ) | ( ( rule__TaskTime__Group_0_2__0 ) ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt8=1;
                }
                break;
            case 65:
                {
                alt8=2;
                }
                break;
            case 72:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:817:2: ( ( rule__TaskTime__Group_0_0__0 ) )
                    {
                    // InternalMyDsl.g:817:2: ( ( rule__TaskTime__Group_0_0__0 ) )
                    // InternalMyDsl.g:818:3: ( rule__TaskTime__Group_0_0__0 )
                    {
                     before(grammarAccess.getTaskTimeAccess().getGroup_0_0()); 
                    // InternalMyDsl.g:819:3: ( rule__TaskTime__Group_0_0__0 )
                    // InternalMyDsl.g:819:4: rule__TaskTime__Group_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TaskTime__Group_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTaskTimeAccess().getGroup_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:823:2: ( ( rule__TaskTime__Group_0_1__0 ) )
                    {
                    // InternalMyDsl.g:823:2: ( ( rule__TaskTime__Group_0_1__0 ) )
                    // InternalMyDsl.g:824:3: ( rule__TaskTime__Group_0_1__0 )
                    {
                     before(grammarAccess.getTaskTimeAccess().getGroup_0_1()); 
                    // InternalMyDsl.g:825:3: ( rule__TaskTime__Group_0_1__0 )
                    // InternalMyDsl.g:825:4: rule__TaskTime__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TaskTime__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTaskTimeAccess().getGroup_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:829:2: ( ( rule__TaskTime__Group_0_2__0 ) )
                    {
                    // InternalMyDsl.g:829:2: ( ( rule__TaskTime__Group_0_2__0 ) )
                    // InternalMyDsl.g:830:3: ( rule__TaskTime__Group_0_2__0 )
                    {
                     before(grammarAccess.getTaskTimeAccess().getGroup_0_2()); 
                    // InternalMyDsl.g:831:3: ( rule__TaskTime__Group_0_2__0 )
                    // InternalMyDsl.g:831:4: rule__TaskTime__Group_0_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TaskTime__Group_0_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTaskTimeAccess().getGroup_0_2()); 

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
    // $ANTLR end "rule__TaskTime__Alternatives_0"


    // $ANTLR start "rule__AllocateT__Alternatives_1"
    // InternalMyDsl.g:839:1: rule__AllocateT__Alternatives_1 : ( ( ( rule__AllocateT__Group_1_0__0 ) ) | ( ( rule__AllocateT__Group_1_1__0 ) ) | ( ( rule__AllocateT__Group_1_2__0 ) ) );
    public final void rule__AllocateT__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:843:1: ( ( ( rule__AllocateT__Group_1_0__0 ) ) | ( ( rule__AllocateT__Group_1_1__0 ) ) | ( ( rule__AllocateT__Group_1_2__0 ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt9=1;
                }
                break;
            case 65:
                {
                alt9=2;
                }
                break;
            case 72:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalMyDsl.g:844:2: ( ( rule__AllocateT__Group_1_0__0 ) )
                    {
                    // InternalMyDsl.g:844:2: ( ( rule__AllocateT__Group_1_0__0 ) )
                    // InternalMyDsl.g:845:3: ( rule__AllocateT__Group_1_0__0 )
                    {
                     before(grammarAccess.getAllocateTAccess().getGroup_1_0()); 
                    // InternalMyDsl.g:846:3: ( rule__AllocateT__Group_1_0__0 )
                    // InternalMyDsl.g:846:4: rule__AllocateT__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AllocateT__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAllocateTAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:850:2: ( ( rule__AllocateT__Group_1_1__0 ) )
                    {
                    // InternalMyDsl.g:850:2: ( ( rule__AllocateT__Group_1_1__0 ) )
                    // InternalMyDsl.g:851:3: ( rule__AllocateT__Group_1_1__0 )
                    {
                     before(grammarAccess.getAllocateTAccess().getGroup_1_1()); 
                    // InternalMyDsl.g:852:3: ( rule__AllocateT__Group_1_1__0 )
                    // InternalMyDsl.g:852:4: rule__AllocateT__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AllocateT__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAllocateTAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:856:2: ( ( rule__AllocateT__Group_1_2__0 ) )
                    {
                    // InternalMyDsl.g:856:2: ( ( rule__AllocateT__Group_1_2__0 ) )
                    // InternalMyDsl.g:857:3: ( rule__AllocateT__Group_1_2__0 )
                    {
                     before(grammarAccess.getAllocateTAccess().getGroup_1_2()); 
                    // InternalMyDsl.g:858:3: ( rule__AllocateT__Group_1_2__0 )
                    // InternalMyDsl.g:858:4: rule__AllocateT__Group_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AllocateT__Group_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAllocateTAccess().getGroup_1_2()); 

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
    // $ANTLR end "rule__AllocateT__Alternatives_1"


    // $ANTLR start "rule__Closest__Alternatives_2"
    // InternalMyDsl.g:866:1: rule__Closest__Alternatives_2 : ( ( ( rule__Closest__Group_2_0__0 ) ) | ( ( rule__Closest__Group_2_1__0 ) ) | ( ( rule__Closest__Group_2_2__0 ) ) | ( ( rule__Closest__Group_2_3__0 ) ) );
    public final void rule__Closest__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:870:1: ( ( ( rule__Closest__Group_2_0__0 ) ) | ( ( rule__Closest__Group_2_1__0 ) ) | ( ( rule__Closest__Group_2_2__0 ) ) | ( ( rule__Closest__Group_2_3__0 ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt10=1;
                }
                break;
            case 63:
                {
                alt10=2;
                }
                break;
            case 65:
                {
                alt10=3;
                }
                break;
            case 72:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalMyDsl.g:871:2: ( ( rule__Closest__Group_2_0__0 ) )
                    {
                    // InternalMyDsl.g:871:2: ( ( rule__Closest__Group_2_0__0 ) )
                    // InternalMyDsl.g:872:3: ( rule__Closest__Group_2_0__0 )
                    {
                     before(grammarAccess.getClosestAccess().getGroup_2_0()); 
                    // InternalMyDsl.g:873:3: ( rule__Closest__Group_2_0__0 )
                    // InternalMyDsl.g:873:4: rule__Closest__Group_2_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Closest__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getClosestAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:877:2: ( ( rule__Closest__Group_2_1__0 ) )
                    {
                    // InternalMyDsl.g:877:2: ( ( rule__Closest__Group_2_1__0 ) )
                    // InternalMyDsl.g:878:3: ( rule__Closest__Group_2_1__0 )
                    {
                     before(grammarAccess.getClosestAccess().getGroup_2_1()); 
                    // InternalMyDsl.g:879:3: ( rule__Closest__Group_2_1__0 )
                    // InternalMyDsl.g:879:4: rule__Closest__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Closest__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getClosestAccess().getGroup_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:883:2: ( ( rule__Closest__Group_2_2__0 ) )
                    {
                    // InternalMyDsl.g:883:2: ( ( rule__Closest__Group_2_2__0 ) )
                    // InternalMyDsl.g:884:3: ( rule__Closest__Group_2_2__0 )
                    {
                     before(grammarAccess.getClosestAccess().getGroup_2_2()); 
                    // InternalMyDsl.g:885:3: ( rule__Closest__Group_2_2__0 )
                    // InternalMyDsl.g:885:4: rule__Closest__Group_2_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Closest__Group_2_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getClosestAccess().getGroup_2_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:889:2: ( ( rule__Closest__Group_2_3__0 ) )
                    {
                    // InternalMyDsl.g:889:2: ( ( rule__Closest__Group_2_3__0 ) )
                    // InternalMyDsl.g:890:3: ( rule__Closest__Group_2_3__0 )
                    {
                     before(grammarAccess.getClosestAccess().getGroup_2_3()); 
                    // InternalMyDsl.g:891:3: ( rule__Closest__Group_2_3__0 )
                    // InternalMyDsl.g:891:4: rule__Closest__Group_2_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Closest__Group_2_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getClosestAccess().getGroup_2_3()); 

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
    // $ANTLR end "rule__Closest__Alternatives_2"


    // $ANTLR start "rule__MaxTasks__Alternatives_5"
    // InternalMyDsl.g:899:1: rule__MaxTasks__Alternatives_5 : ( ( ( rule__MaxTasks__Group_5_0__0 ) ) | ( ( rule__MaxTasks__Group_5_1__0 ) ) );
    public final void rule__MaxTasks__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:903:1: ( ( ( rule__MaxTasks__Group_5_0__0 ) ) | ( ( rule__MaxTasks__Group_5_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==84) ) {
                alt11=1;
            }
            else if ( (LA11_0==70) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyDsl.g:904:2: ( ( rule__MaxTasks__Group_5_0__0 ) )
                    {
                    // InternalMyDsl.g:904:2: ( ( rule__MaxTasks__Group_5_0__0 ) )
                    // InternalMyDsl.g:905:3: ( rule__MaxTasks__Group_5_0__0 )
                    {
                     before(grammarAccess.getMaxTasksAccess().getGroup_5_0()); 
                    // InternalMyDsl.g:906:3: ( rule__MaxTasks__Group_5_0__0 )
                    // InternalMyDsl.g:906:4: rule__MaxTasks__Group_5_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MaxTasks__Group_5_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMaxTasksAccess().getGroup_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:910:2: ( ( rule__MaxTasks__Group_5_1__0 ) )
                    {
                    // InternalMyDsl.g:910:2: ( ( rule__MaxTasks__Group_5_1__0 ) )
                    // InternalMyDsl.g:911:3: ( rule__MaxTasks__Group_5_1__0 )
                    {
                     before(grammarAccess.getMaxTasksAccess().getGroup_5_1()); 
                    // InternalMyDsl.g:912:3: ( rule__MaxTasks__Group_5_1__0 )
                    // InternalMyDsl.g:912:4: rule__MaxTasks__Group_5_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MaxTasks__Group_5_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMaxTasksAccess().getGroup_5_1()); 

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
    // $ANTLR end "rule__MaxTasks__Alternatives_5"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalMyDsl.g:920:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:924:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalMyDsl.g:925:2: ( RULE_STRING )
                    {
                    // InternalMyDsl.g:925:2: ( RULE_STRING )
                    // InternalMyDsl.g:926:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:931:2: ( RULE_ID )
                    {
                    // InternalMyDsl.g:931:2: ( RULE_ID )
                    // InternalMyDsl.g:932:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__EDouble__Alternatives_4_0"
    // InternalMyDsl.g:941:1: rule__EDouble__Alternatives_4_0 : ( ( 'E' ) | ( 'e' ) );
    public final void rule__EDouble__Alternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:945:1: ( ( 'E' ) | ( 'e' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==13) ) {
                alt13=1;
            }
            else if ( (LA13_0==14) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyDsl.g:946:2: ( 'E' )
                    {
                    // InternalMyDsl.g:946:2: ( 'E' )
                    // InternalMyDsl.g:947:3: 'E'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:952:2: ( 'e' )
                    {
                    // InternalMyDsl.g:952:2: ( 'e' )
                    // InternalMyDsl.g:953:3: 'e'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 

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
    // $ANTLR end "rule__EDouble__Alternatives_4_0"


    // $ANTLR start "rule__Objective__Alternatives"
    // InternalMyDsl.g:962:1: rule__Objective__Alternatives : ( ( ( 'minimiseIdle' ) ) | ( ( 'minimiseTravel' ) ) | ( ( 'maximiseSuccess' ) ) );
    public final void rule__Objective__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:966:1: ( ( ( 'minimiseIdle' ) ) | ( ( 'minimiseTravel' ) ) | ( ( 'maximiseSuccess' ) ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt14=1;
                }
                break;
            case 16:
                {
                alt14=2;
                }
                break;
            case 17:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalMyDsl.g:967:2: ( ( 'minimiseIdle' ) )
                    {
                    // InternalMyDsl.g:967:2: ( ( 'minimiseIdle' ) )
                    // InternalMyDsl.g:968:3: ( 'minimiseIdle' )
                    {
                     before(grammarAccess.getObjectiveAccess().getMinIdleEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:969:3: ( 'minimiseIdle' )
                    // InternalMyDsl.g:969:4: 'minimiseIdle'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getObjectiveAccess().getMinIdleEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:973:2: ( ( 'minimiseTravel' ) )
                    {
                    // InternalMyDsl.g:973:2: ( ( 'minimiseTravel' ) )
                    // InternalMyDsl.g:974:3: ( 'minimiseTravel' )
                    {
                     before(grammarAccess.getObjectiveAccess().getMinTravelEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:975:3: ( 'minimiseTravel' )
                    // InternalMyDsl.g:975:4: 'minimiseTravel'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getObjectiveAccess().getMinTravelEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:979:2: ( ( 'maximiseSuccess' ) )
                    {
                    // InternalMyDsl.g:979:2: ( ( 'maximiseSuccess' ) )
                    // InternalMyDsl.g:980:3: ( 'maximiseSuccess' )
                    {
                     before(grammarAccess.getObjectiveAccess().getMaxSuccEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:981:3: ( 'maximiseSuccess' )
                    // InternalMyDsl.g:981:4: 'maximiseSuccess'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getObjectiveAccess().getMaxSuccEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__Objective__Alternatives"


    // $ANTLR start "rule__XY__Alternatives"
    // InternalMyDsl.g:989:1: rule__XY__Alternatives : ( ( ( 'x' ) ) | ( ( 'y' ) ) );
    public final void rule__XY__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:993:1: ( ( ( 'x' ) ) | ( ( 'y' ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            else if ( (LA15_0==19) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDsl.g:994:2: ( ( 'x' ) )
                    {
                    // InternalMyDsl.g:994:2: ( ( 'x' ) )
                    // InternalMyDsl.g:995:3: ( 'x' )
                    {
                     before(grammarAccess.getXYAccess().getXEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:996:3: ( 'x' )
                    // InternalMyDsl.g:996:4: 'x'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getXYAccess().getXEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1000:2: ( ( 'y' ) )
                    {
                    // InternalMyDsl.g:1000:2: ( ( 'y' ) )
                    // InternalMyDsl.g:1001:3: ( 'y' )
                    {
                     before(grammarAccess.getXYAccess().getYEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:1002:3: ( 'y' )
                    // InternalMyDsl.g:1002:4: 'y'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getXYAccess().getYEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__XY__Alternatives"


    // $ANTLR start "rule__LowerGreater__Alternatives"
    // InternalMyDsl.g:1010:1: rule__LowerGreater__Alternatives : ( ( ( 'lower' ) ) | ( ( 'greater' ) ) );
    public final void rule__LowerGreater__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1014:1: ( ( ( 'lower' ) ) | ( ( 'greater' ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            else if ( (LA16_0==21) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalMyDsl.g:1015:2: ( ( 'lower' ) )
                    {
                    // InternalMyDsl.g:1015:2: ( ( 'lower' ) )
                    // InternalMyDsl.g:1016:3: ( 'lower' )
                    {
                     before(grammarAccess.getLowerGreaterAccess().getLowerEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:1017:3: ( 'lower' )
                    // InternalMyDsl.g:1017:4: 'lower'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLowerGreaterAccess().getLowerEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1021:2: ( ( 'greater' ) )
                    {
                    // InternalMyDsl.g:1021:2: ( ( 'greater' ) )
                    // InternalMyDsl.g:1022:3: ( 'greater' )
                    {
                     before(grammarAccess.getLowerGreaterAccess().getGreaterEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:1023:3: ( 'greater' )
                    // InternalMyDsl.g:1023:4: 'greater'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLowerGreaterAccess().getGreaterEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__LowerGreater__Alternatives"


    // $ANTLR start "rule__StartEnd__Alternatives"
    // InternalMyDsl.g:1031:1: rule__StartEnd__Alternatives : ( ( ( 'end' ) ) | ( ( 'start' ) ) );
    public final void rule__StartEnd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1035:1: ( ( ( 'end' ) ) | ( ( 'start' ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            else if ( (LA17_0==23) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:1036:2: ( ( 'end' ) )
                    {
                    // InternalMyDsl.g:1036:2: ( ( 'end' ) )
                    // InternalMyDsl.g:1037:3: ( 'end' )
                    {
                     before(grammarAccess.getStartEndAccess().getEndEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:1038:3: ( 'end' )
                    // InternalMyDsl.g:1038:4: 'end'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getStartEndAccess().getEndEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1042:2: ( ( 'start' ) )
                    {
                    // InternalMyDsl.g:1042:2: ( ( 'start' ) )
                    // InternalMyDsl.g:1043:3: ( 'start' )
                    {
                     before(grammarAccess.getStartEndAccess().getStartEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:1044:3: ( 'start' )
                    // InternalMyDsl.g:1044:4: 'start'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getStartEndAccess().getStartEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__StartEnd__Alternatives"


    // $ANTLR start "rule__ProblemSpecification__Group__0"
    // InternalMyDsl.g:1052:1: rule__ProblemSpecification__Group__0 : rule__ProblemSpecification__Group__0__Impl rule__ProblemSpecification__Group__1 ;
    public final void rule__ProblemSpecification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1056:1: ( rule__ProblemSpecification__Group__0__Impl rule__ProblemSpecification__Group__1 )
            // InternalMyDsl.g:1057:2: rule__ProblemSpecification__Group__0__Impl rule__ProblemSpecification__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ProblemSpecification__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__1();

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
    // $ANTLR end "rule__ProblemSpecification__Group__0"


    // $ANTLR start "rule__ProblemSpecification__Group__0__Impl"
    // InternalMyDsl.g:1064:1: rule__ProblemSpecification__Group__0__Impl : ( 'ProblemSpecification' ) ;
    public final void rule__ProblemSpecification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1068:1: ( ( 'ProblemSpecification' ) )
            // InternalMyDsl.g:1069:1: ( 'ProblemSpecification' )
            {
            // InternalMyDsl.g:1069:1: ( 'ProblemSpecification' )
            // InternalMyDsl.g:1070:2: 'ProblemSpecification'
            {
             before(grammarAccess.getProblemSpecificationAccess().getProblemSpecificationKeyword_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getProblemSpecificationKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__0__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__1"
    // InternalMyDsl.g:1079:1: rule__ProblemSpecification__Group__1 : rule__ProblemSpecification__Group__1__Impl rule__ProblemSpecification__Group__2 ;
    public final void rule__ProblemSpecification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1083:1: ( rule__ProblemSpecification__Group__1__Impl rule__ProblemSpecification__Group__2 )
            // InternalMyDsl.g:1084:2: rule__ProblemSpecification__Group__1__Impl rule__ProblemSpecification__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ProblemSpecification__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__2();

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
    // $ANTLR end "rule__ProblemSpecification__Group__1"


    // $ANTLR start "rule__ProblemSpecification__Group__1__Impl"
    // InternalMyDsl.g:1091:1: rule__ProblemSpecification__Group__1__Impl : ( '{' ) ;
    public final void rule__ProblemSpecification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1095:1: ( ( '{' ) )
            // InternalMyDsl.g:1096:1: ( '{' )
            {
            // InternalMyDsl.g:1096:1: ( '{' )
            // InternalMyDsl.g:1097:2: '{'
            {
             before(grammarAccess.getProblemSpecificationAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__1__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__2"
    // InternalMyDsl.g:1106:1: rule__ProblemSpecification__Group__2 : rule__ProblemSpecification__Group__2__Impl rule__ProblemSpecification__Group__3 ;
    public final void rule__ProblemSpecification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1110:1: ( rule__ProblemSpecification__Group__2__Impl rule__ProblemSpecification__Group__3 )
            // InternalMyDsl.g:1111:2: rule__ProblemSpecification__Group__2__Impl rule__ProblemSpecification__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__ProblemSpecification__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__3();

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
    // $ANTLR end "rule__ProblemSpecification__Group__2"


    // $ANTLR start "rule__ProblemSpecification__Group__2__Impl"
    // InternalMyDsl.g:1118:1: rule__ProblemSpecification__Group__2__Impl : ( 'WorldModel' ) ;
    public final void rule__ProblemSpecification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1122:1: ( ( 'WorldModel' ) )
            // InternalMyDsl.g:1123:1: ( 'WorldModel' )
            {
            // InternalMyDsl.g:1123:1: ( 'WorldModel' )
            // InternalMyDsl.g:1124:2: 'WorldModel'
            {
             before(grammarAccess.getProblemSpecificationAccess().getWorldModelKeyword_2()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getWorldModelKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__2__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__3"
    // InternalMyDsl.g:1133:1: rule__ProblemSpecification__Group__3 : rule__ProblemSpecification__Group__3__Impl rule__ProblemSpecification__Group__4 ;
    public final void rule__ProblemSpecification__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1137:1: ( rule__ProblemSpecification__Group__3__Impl rule__ProblemSpecification__Group__4 )
            // InternalMyDsl.g:1138:2: rule__ProblemSpecification__Group__3__Impl rule__ProblemSpecification__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__ProblemSpecification__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__4();

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
    // $ANTLR end "rule__ProblemSpecification__Group__3"


    // $ANTLR start "rule__ProblemSpecification__Group__3__Impl"
    // InternalMyDsl.g:1145:1: rule__ProblemSpecification__Group__3__Impl : ( ':' ) ;
    public final void rule__ProblemSpecification__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1149:1: ( ( ':' ) )
            // InternalMyDsl.g:1150:1: ( ':' )
            {
            // InternalMyDsl.g:1150:1: ( ':' )
            // InternalMyDsl.g:1151:2: ':'
            {
             before(grammarAccess.getProblemSpecificationAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__3__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__4"
    // InternalMyDsl.g:1160:1: rule__ProblemSpecification__Group__4 : rule__ProblemSpecification__Group__4__Impl rule__ProblemSpecification__Group__5 ;
    public final void rule__ProblemSpecification__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1164:1: ( rule__ProblemSpecification__Group__4__Impl rule__ProblemSpecification__Group__5 )
            // InternalMyDsl.g:1165:2: rule__ProblemSpecification__Group__4__Impl rule__ProblemSpecification__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__ProblemSpecification__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__5();

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
    // $ANTLR end "rule__ProblemSpecification__Group__4"


    // $ANTLR start "rule__ProblemSpecification__Group__4__Impl"
    // InternalMyDsl.g:1172:1: rule__ProblemSpecification__Group__4__Impl : ( ( rule__ProblemSpecification__WorldModelAssignment_4 ) ) ;
    public final void rule__ProblemSpecification__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1176:1: ( ( ( rule__ProblemSpecification__WorldModelAssignment_4 ) ) )
            // InternalMyDsl.g:1177:1: ( ( rule__ProblemSpecification__WorldModelAssignment_4 ) )
            {
            // InternalMyDsl.g:1177:1: ( ( rule__ProblemSpecification__WorldModelAssignment_4 ) )
            // InternalMyDsl.g:1178:2: ( rule__ProblemSpecification__WorldModelAssignment_4 )
            {
             before(grammarAccess.getProblemSpecificationAccess().getWorldModelAssignment_4()); 
            // InternalMyDsl.g:1179:2: ( rule__ProblemSpecification__WorldModelAssignment_4 )
            // InternalMyDsl.g:1179:3: rule__ProblemSpecification__WorldModelAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__WorldModelAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getProblemSpecificationAccess().getWorldModelAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__4__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__5"
    // InternalMyDsl.g:1187:1: rule__ProblemSpecification__Group__5 : rule__ProblemSpecification__Group__5__Impl rule__ProblemSpecification__Group__6 ;
    public final void rule__ProblemSpecification__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1191:1: ( rule__ProblemSpecification__Group__5__Impl rule__ProblemSpecification__Group__6 )
            // InternalMyDsl.g:1192:2: rule__ProblemSpecification__Group__5__Impl rule__ProblemSpecification__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__ProblemSpecification__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__6();

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
    // $ANTLR end "rule__ProblemSpecification__Group__5"


    // $ANTLR start "rule__ProblemSpecification__Group__5__Impl"
    // InternalMyDsl.g:1199:1: rule__ProblemSpecification__Group__5__Impl : ( ( rule__ProblemSpecification__WorldModelAssignment_5 )* ) ;
    public final void rule__ProblemSpecification__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1203:1: ( ( ( rule__ProblemSpecification__WorldModelAssignment_5 )* ) )
            // InternalMyDsl.g:1204:1: ( ( rule__ProblemSpecification__WorldModelAssignment_5 )* )
            {
            // InternalMyDsl.g:1204:1: ( ( rule__ProblemSpecification__WorldModelAssignment_5 )* )
            // InternalMyDsl.g:1205:2: ( rule__ProblemSpecification__WorldModelAssignment_5 )*
            {
             before(grammarAccess.getProblemSpecificationAccess().getWorldModelAssignment_5()); 
            // InternalMyDsl.g:1206:2: ( rule__ProblemSpecification__WorldModelAssignment_5 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_ID)||LA18_0==36) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMyDsl.g:1206:3: rule__ProblemSpecification__WorldModelAssignment_5
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__ProblemSpecification__WorldModelAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getProblemSpecificationAccess().getWorldModelAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__5__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__6"
    // InternalMyDsl.g:1214:1: rule__ProblemSpecification__Group__6 : rule__ProblemSpecification__Group__6__Impl rule__ProblemSpecification__Group__7 ;
    public final void rule__ProblemSpecification__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1218:1: ( rule__ProblemSpecification__Group__6__Impl rule__ProblemSpecification__Group__7 )
            // InternalMyDsl.g:1219:2: rule__ProblemSpecification__Group__6__Impl rule__ProblemSpecification__Group__7
            {
            pushFollow(FOLLOW_5);
            rule__ProblemSpecification__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__7();

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
    // $ANTLR end "rule__ProblemSpecification__Group__6"


    // $ANTLR start "rule__ProblemSpecification__Group__6__Impl"
    // InternalMyDsl.g:1226:1: rule__ProblemSpecification__Group__6__Impl : ( 'TasksModel' ) ;
    public final void rule__ProblemSpecification__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1230:1: ( ( 'TasksModel' ) )
            // InternalMyDsl.g:1231:1: ( 'TasksModel' )
            {
            // InternalMyDsl.g:1231:1: ( 'TasksModel' )
            // InternalMyDsl.g:1232:2: 'TasksModel'
            {
             before(grammarAccess.getProblemSpecificationAccess().getTasksModelKeyword_6()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getTasksModelKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__6__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__7"
    // InternalMyDsl.g:1241:1: rule__ProblemSpecification__Group__7 : rule__ProblemSpecification__Group__7__Impl rule__ProblemSpecification__Group__8 ;
    public final void rule__ProblemSpecification__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1245:1: ( rule__ProblemSpecification__Group__7__Impl rule__ProblemSpecification__Group__8 )
            // InternalMyDsl.g:1246:2: rule__ProblemSpecification__Group__7__Impl rule__ProblemSpecification__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__ProblemSpecification__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__8();

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
    // $ANTLR end "rule__ProblemSpecification__Group__7"


    // $ANTLR start "rule__ProblemSpecification__Group__7__Impl"
    // InternalMyDsl.g:1253:1: rule__ProblemSpecification__Group__7__Impl : ( ':' ) ;
    public final void rule__ProblemSpecification__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1257:1: ( ( ':' ) )
            // InternalMyDsl.g:1258:1: ( ':' )
            {
            // InternalMyDsl.g:1258:1: ( ':' )
            // InternalMyDsl.g:1259:2: ':'
            {
             before(grammarAccess.getProblemSpecificationAccess().getColonKeyword_7()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getColonKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__7__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__8"
    // InternalMyDsl.g:1268:1: rule__ProblemSpecification__Group__8 : rule__ProblemSpecification__Group__8__Impl rule__ProblemSpecification__Group__9 ;
    public final void rule__ProblemSpecification__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1272:1: ( rule__ProblemSpecification__Group__8__Impl rule__ProblemSpecification__Group__9 )
            // InternalMyDsl.g:1273:2: rule__ProblemSpecification__Group__8__Impl rule__ProblemSpecification__Group__9
            {
            pushFollow(FOLLOW_10);
            rule__ProblemSpecification__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__9();

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
    // $ANTLR end "rule__ProblemSpecification__Group__8"


    // $ANTLR start "rule__ProblemSpecification__Group__8__Impl"
    // InternalMyDsl.g:1280:1: rule__ProblemSpecification__Group__8__Impl : ( ( rule__ProblemSpecification__TasksModelAssignment_8 ) ) ;
    public final void rule__ProblemSpecification__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1284:1: ( ( ( rule__ProblemSpecification__TasksModelAssignment_8 ) ) )
            // InternalMyDsl.g:1285:1: ( ( rule__ProblemSpecification__TasksModelAssignment_8 ) )
            {
            // InternalMyDsl.g:1285:1: ( ( rule__ProblemSpecification__TasksModelAssignment_8 ) )
            // InternalMyDsl.g:1286:2: ( rule__ProblemSpecification__TasksModelAssignment_8 )
            {
             before(grammarAccess.getProblemSpecificationAccess().getTasksModelAssignment_8()); 
            // InternalMyDsl.g:1287:2: ( rule__ProblemSpecification__TasksModelAssignment_8 )
            // InternalMyDsl.g:1287:3: rule__ProblemSpecification__TasksModelAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__TasksModelAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getProblemSpecificationAccess().getTasksModelAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__8__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__9"
    // InternalMyDsl.g:1295:1: rule__ProblemSpecification__Group__9 : rule__ProblemSpecification__Group__9__Impl rule__ProblemSpecification__Group__10 ;
    public final void rule__ProblemSpecification__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1299:1: ( rule__ProblemSpecification__Group__9__Impl rule__ProblemSpecification__Group__10 )
            // InternalMyDsl.g:1300:2: rule__ProblemSpecification__Group__9__Impl rule__ProblemSpecification__Group__10
            {
            pushFollow(FOLLOW_10);
            rule__ProblemSpecification__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__10();

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
    // $ANTLR end "rule__ProblemSpecification__Group__9"


    // $ANTLR start "rule__ProblemSpecification__Group__9__Impl"
    // InternalMyDsl.g:1307:1: rule__ProblemSpecification__Group__9__Impl : ( ( rule__ProblemSpecification__Group_9__0 )* ) ;
    public final void rule__ProblemSpecification__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1311:1: ( ( ( rule__ProblemSpecification__Group_9__0 )* ) )
            // InternalMyDsl.g:1312:1: ( ( rule__ProblemSpecification__Group_9__0 )* )
            {
            // InternalMyDsl.g:1312:1: ( ( rule__ProblemSpecification__Group_9__0 )* )
            // InternalMyDsl.g:1313:2: ( rule__ProblemSpecification__Group_9__0 )*
            {
             before(grammarAccess.getProblemSpecificationAccess().getGroup_9()); 
            // InternalMyDsl.g:1314:2: ( rule__ProblemSpecification__Group_9__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==32) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalMyDsl.g:1314:3: rule__ProblemSpecification__Group_9__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ProblemSpecification__Group_9__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getProblemSpecificationAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__9__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__10"
    // InternalMyDsl.g:1322:1: rule__ProblemSpecification__Group__10 : rule__ProblemSpecification__Group__10__Impl rule__ProblemSpecification__Group__11 ;
    public final void rule__ProblemSpecification__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1326:1: ( rule__ProblemSpecification__Group__10__Impl rule__ProblemSpecification__Group__11 )
            // InternalMyDsl.g:1327:2: rule__ProblemSpecification__Group__10__Impl rule__ProblemSpecification__Group__11
            {
            pushFollow(FOLLOW_5);
            rule__ProblemSpecification__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__11();

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
    // $ANTLR end "rule__ProblemSpecification__Group__10"


    // $ANTLR start "rule__ProblemSpecification__Group__10__Impl"
    // InternalMyDsl.g:1334:1: rule__ProblemSpecification__Group__10__Impl : ( 'RobotsModel' ) ;
    public final void rule__ProblemSpecification__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1338:1: ( ( 'RobotsModel' ) )
            // InternalMyDsl.g:1339:1: ( 'RobotsModel' )
            {
            // InternalMyDsl.g:1339:1: ( 'RobotsModel' )
            // InternalMyDsl.g:1340:2: 'RobotsModel'
            {
             before(grammarAccess.getProblemSpecificationAccess().getRobotsModelKeyword_10()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getRobotsModelKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__10__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__11"
    // InternalMyDsl.g:1349:1: rule__ProblemSpecification__Group__11 : rule__ProblemSpecification__Group__11__Impl rule__ProblemSpecification__Group__12 ;
    public final void rule__ProblemSpecification__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1353:1: ( rule__ProblemSpecification__Group__11__Impl rule__ProblemSpecification__Group__12 )
            // InternalMyDsl.g:1354:2: rule__ProblemSpecification__Group__11__Impl rule__ProblemSpecification__Group__12
            {
            pushFollow(FOLLOW_9);
            rule__ProblemSpecification__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__12();

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
    // $ANTLR end "rule__ProblemSpecification__Group__11"


    // $ANTLR start "rule__ProblemSpecification__Group__11__Impl"
    // InternalMyDsl.g:1361:1: rule__ProblemSpecification__Group__11__Impl : ( ':' ) ;
    public final void rule__ProblemSpecification__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1365:1: ( ( ':' ) )
            // InternalMyDsl.g:1366:1: ( ':' )
            {
            // InternalMyDsl.g:1366:1: ( ':' )
            // InternalMyDsl.g:1367:2: ':'
            {
             before(grammarAccess.getProblemSpecificationAccess().getColonKeyword_11()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getColonKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__11__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__12"
    // InternalMyDsl.g:1376:1: rule__ProblemSpecification__Group__12 : rule__ProblemSpecification__Group__12__Impl rule__ProblemSpecification__Group__13 ;
    public final void rule__ProblemSpecification__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1380:1: ( rule__ProblemSpecification__Group__12__Impl rule__ProblemSpecification__Group__13 )
            // InternalMyDsl.g:1381:2: rule__ProblemSpecification__Group__12__Impl rule__ProblemSpecification__Group__13
            {
            pushFollow(FOLLOW_12);
            rule__ProblemSpecification__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__13();

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
    // $ANTLR end "rule__ProblemSpecification__Group__12"


    // $ANTLR start "rule__ProblemSpecification__Group__12__Impl"
    // InternalMyDsl.g:1388:1: rule__ProblemSpecification__Group__12__Impl : ( ( rule__ProblemSpecification__RobotsModelAssignment_12 ) ) ;
    public final void rule__ProblemSpecification__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1392:1: ( ( ( rule__ProblemSpecification__RobotsModelAssignment_12 ) ) )
            // InternalMyDsl.g:1393:1: ( ( rule__ProblemSpecification__RobotsModelAssignment_12 ) )
            {
            // InternalMyDsl.g:1393:1: ( ( rule__ProblemSpecification__RobotsModelAssignment_12 ) )
            // InternalMyDsl.g:1394:2: ( rule__ProblemSpecification__RobotsModelAssignment_12 )
            {
             before(grammarAccess.getProblemSpecificationAccess().getRobotsModelAssignment_12()); 
            // InternalMyDsl.g:1395:2: ( rule__ProblemSpecification__RobotsModelAssignment_12 )
            // InternalMyDsl.g:1395:3: rule__ProblemSpecification__RobotsModelAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__RobotsModelAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getProblemSpecificationAccess().getRobotsModelAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__12__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__13"
    // InternalMyDsl.g:1403:1: rule__ProblemSpecification__Group__13 : rule__ProblemSpecification__Group__13__Impl rule__ProblemSpecification__Group__14 ;
    public final void rule__ProblemSpecification__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1407:1: ( rule__ProblemSpecification__Group__13__Impl rule__ProblemSpecification__Group__14 )
            // InternalMyDsl.g:1408:2: rule__ProblemSpecification__Group__13__Impl rule__ProblemSpecification__Group__14
            {
            pushFollow(FOLLOW_12);
            rule__ProblemSpecification__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__14();

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
    // $ANTLR end "rule__ProblemSpecification__Group__13"


    // $ANTLR start "rule__ProblemSpecification__Group__13__Impl"
    // InternalMyDsl.g:1415:1: rule__ProblemSpecification__Group__13__Impl : ( ( rule__ProblemSpecification__Group_13__0 )* ) ;
    public final void rule__ProblemSpecification__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1419:1: ( ( ( rule__ProblemSpecification__Group_13__0 )* ) )
            // InternalMyDsl.g:1420:1: ( ( rule__ProblemSpecification__Group_13__0 )* )
            {
            // InternalMyDsl.g:1420:1: ( ( rule__ProblemSpecification__Group_13__0 )* )
            // InternalMyDsl.g:1421:2: ( rule__ProblemSpecification__Group_13__0 )*
            {
             before(grammarAccess.getProblemSpecificationAccess().getGroup_13()); 
            // InternalMyDsl.g:1422:2: ( rule__ProblemSpecification__Group_13__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==32) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMyDsl.g:1422:3: rule__ProblemSpecification__Group_13__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ProblemSpecification__Group_13__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getProblemSpecificationAccess().getGroup_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__13__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__14"
    // InternalMyDsl.g:1430:1: rule__ProblemSpecification__Group__14 : rule__ProblemSpecification__Group__14__Impl rule__ProblemSpecification__Group__15 ;
    public final void rule__ProblemSpecification__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1434:1: ( rule__ProblemSpecification__Group__14__Impl rule__ProblemSpecification__Group__15 )
            // InternalMyDsl.g:1435:2: rule__ProblemSpecification__Group__14__Impl rule__ProblemSpecification__Group__15
            {
            pushFollow(FOLLOW_5);
            rule__ProblemSpecification__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__15();

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
    // $ANTLR end "rule__ProblemSpecification__Group__14"


    // $ANTLR start "rule__ProblemSpecification__Group__14__Impl"
    // InternalMyDsl.g:1442:1: rule__ProblemSpecification__Group__14__Impl : ( 'Mission' ) ;
    public final void rule__ProblemSpecification__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1446:1: ( ( 'Mission' ) )
            // InternalMyDsl.g:1447:1: ( 'Mission' )
            {
            // InternalMyDsl.g:1447:1: ( 'Mission' )
            // InternalMyDsl.g:1448:2: 'Mission'
            {
             before(grammarAccess.getProblemSpecificationAccess().getMissionKeyword_14()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getMissionKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__14__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__15"
    // InternalMyDsl.g:1457:1: rule__ProblemSpecification__Group__15 : rule__ProblemSpecification__Group__15__Impl rule__ProblemSpecification__Group__16 ;
    public final void rule__ProblemSpecification__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1461:1: ( rule__ProblemSpecification__Group__15__Impl rule__ProblemSpecification__Group__16 )
            // InternalMyDsl.g:1462:2: rule__ProblemSpecification__Group__15__Impl rule__ProblemSpecification__Group__16
            {
            pushFollow(FOLLOW_9);
            rule__ProblemSpecification__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__16();

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
    // $ANTLR end "rule__ProblemSpecification__Group__15"


    // $ANTLR start "rule__ProblemSpecification__Group__15__Impl"
    // InternalMyDsl.g:1469:1: rule__ProblemSpecification__Group__15__Impl : ( ':' ) ;
    public final void rule__ProblemSpecification__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1473:1: ( ( ':' ) )
            // InternalMyDsl.g:1474:1: ( ':' )
            {
            // InternalMyDsl.g:1474:1: ( ':' )
            // InternalMyDsl.g:1475:2: ':'
            {
             before(grammarAccess.getProblemSpecificationAccess().getColonKeyword_15()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getColonKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__15__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__16"
    // InternalMyDsl.g:1484:1: rule__ProblemSpecification__Group__16 : rule__ProblemSpecification__Group__16__Impl rule__ProblemSpecification__Group__17 ;
    public final void rule__ProblemSpecification__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1488:1: ( rule__ProblemSpecification__Group__16__Impl rule__ProblemSpecification__Group__17 )
            // InternalMyDsl.g:1489:2: rule__ProblemSpecification__Group__16__Impl rule__ProblemSpecification__Group__17
            {
            pushFollow(FOLLOW_13);
            rule__ProblemSpecification__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__17();

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
    // $ANTLR end "rule__ProblemSpecification__Group__16"


    // $ANTLR start "rule__ProblemSpecification__Group__16__Impl"
    // InternalMyDsl.g:1496:1: rule__ProblemSpecification__Group__16__Impl : ( ( rule__ProblemSpecification__MissionAssignment_16 ) ) ;
    public final void rule__ProblemSpecification__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1500:1: ( ( ( rule__ProblemSpecification__MissionAssignment_16 ) ) )
            // InternalMyDsl.g:1501:1: ( ( rule__ProblemSpecification__MissionAssignment_16 ) )
            {
            // InternalMyDsl.g:1501:1: ( ( rule__ProblemSpecification__MissionAssignment_16 ) )
            // InternalMyDsl.g:1502:2: ( rule__ProblemSpecification__MissionAssignment_16 )
            {
             before(grammarAccess.getProblemSpecificationAccess().getMissionAssignment_16()); 
            // InternalMyDsl.g:1503:2: ( rule__ProblemSpecification__MissionAssignment_16 )
            // InternalMyDsl.g:1503:3: rule__ProblemSpecification__MissionAssignment_16
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__MissionAssignment_16();

            state._fsp--;


            }

             after(grammarAccess.getProblemSpecificationAccess().getMissionAssignment_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__16__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__17"
    // InternalMyDsl.g:1511:1: rule__ProblemSpecification__Group__17 : rule__ProblemSpecification__Group__17__Impl rule__ProblemSpecification__Group__18 ;
    public final void rule__ProblemSpecification__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1515:1: ( rule__ProblemSpecification__Group__17__Impl rule__ProblemSpecification__Group__18 )
            // InternalMyDsl.g:1516:2: rule__ProblemSpecification__Group__17__Impl rule__ProblemSpecification__Group__18
            {
            pushFollow(FOLLOW_13);
            rule__ProblemSpecification__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__18();

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
    // $ANTLR end "rule__ProblemSpecification__Group__17"


    // $ANTLR start "rule__ProblemSpecification__Group__17__Impl"
    // InternalMyDsl.g:1523:1: rule__ProblemSpecification__Group__17__Impl : ( ( rule__ProblemSpecification__Group_17__0 )* ) ;
    public final void rule__ProblemSpecification__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1527:1: ( ( ( rule__ProblemSpecification__Group_17__0 )* ) )
            // InternalMyDsl.g:1528:1: ( ( rule__ProblemSpecification__Group_17__0 )* )
            {
            // InternalMyDsl.g:1528:1: ( ( rule__ProblemSpecification__Group_17__0 )* )
            // InternalMyDsl.g:1529:2: ( rule__ProblemSpecification__Group_17__0 )*
            {
             before(grammarAccess.getProblemSpecificationAccess().getGroup_17()); 
            // InternalMyDsl.g:1530:2: ( rule__ProblemSpecification__Group_17__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==32) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMyDsl.g:1530:3: rule__ProblemSpecification__Group_17__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ProblemSpecification__Group_17__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getProblemSpecificationAccess().getGroup_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__17__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group__18"
    // InternalMyDsl.g:1538:1: rule__ProblemSpecification__Group__18 : rule__ProblemSpecification__Group__18__Impl ;
    public final void rule__ProblemSpecification__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1542:1: ( rule__ProblemSpecification__Group__18__Impl )
            // InternalMyDsl.g:1543:2: rule__ProblemSpecification__Group__18__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group__18__Impl();

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
    // $ANTLR end "rule__ProblemSpecification__Group__18"


    // $ANTLR start "rule__ProblemSpecification__Group__18__Impl"
    // InternalMyDsl.g:1549:1: rule__ProblemSpecification__Group__18__Impl : ( '}' ) ;
    public final void rule__ProblemSpecification__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1553:1: ( ( '}' ) )
            // InternalMyDsl.g:1554:1: ( '}' )
            {
            // InternalMyDsl.g:1554:1: ( '}' )
            // InternalMyDsl.g:1555:2: '}'
            {
             before(grammarAccess.getProblemSpecificationAccess().getRightCurlyBracketKeyword_18()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getRightCurlyBracketKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group__18__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group_9__0"
    // InternalMyDsl.g:1565:1: rule__ProblemSpecification__Group_9__0 : rule__ProblemSpecification__Group_9__0__Impl rule__ProblemSpecification__Group_9__1 ;
    public final void rule__ProblemSpecification__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1569:1: ( rule__ProblemSpecification__Group_9__0__Impl rule__ProblemSpecification__Group_9__1 )
            // InternalMyDsl.g:1570:2: rule__ProblemSpecification__Group_9__0__Impl rule__ProblemSpecification__Group_9__1
            {
            pushFollow(FOLLOW_9);
            rule__ProblemSpecification__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group_9__1();

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
    // $ANTLR end "rule__ProblemSpecification__Group_9__0"


    // $ANTLR start "rule__ProblemSpecification__Group_9__0__Impl"
    // InternalMyDsl.g:1577:1: rule__ProblemSpecification__Group_9__0__Impl : ( ',' ) ;
    public final void rule__ProblemSpecification__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1581:1: ( ( ',' ) )
            // InternalMyDsl.g:1582:1: ( ',' )
            {
            // InternalMyDsl.g:1582:1: ( ',' )
            // InternalMyDsl.g:1583:2: ','
            {
             before(grammarAccess.getProblemSpecificationAccess().getCommaKeyword_9_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getCommaKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group_9__0__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group_9__1"
    // InternalMyDsl.g:1592:1: rule__ProblemSpecification__Group_9__1 : rule__ProblemSpecification__Group_9__1__Impl ;
    public final void rule__ProblemSpecification__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1596:1: ( rule__ProblemSpecification__Group_9__1__Impl )
            // InternalMyDsl.g:1597:2: rule__ProblemSpecification__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group_9__1__Impl();

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
    // $ANTLR end "rule__ProblemSpecification__Group_9__1"


    // $ANTLR start "rule__ProblemSpecification__Group_9__1__Impl"
    // InternalMyDsl.g:1603:1: rule__ProblemSpecification__Group_9__1__Impl : ( ( rule__ProblemSpecification__TasksModelAssignment_9_1 ) ) ;
    public final void rule__ProblemSpecification__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1607:1: ( ( ( rule__ProblemSpecification__TasksModelAssignment_9_1 ) ) )
            // InternalMyDsl.g:1608:1: ( ( rule__ProblemSpecification__TasksModelAssignment_9_1 ) )
            {
            // InternalMyDsl.g:1608:1: ( ( rule__ProblemSpecification__TasksModelAssignment_9_1 ) )
            // InternalMyDsl.g:1609:2: ( rule__ProblemSpecification__TasksModelAssignment_9_1 )
            {
             before(grammarAccess.getProblemSpecificationAccess().getTasksModelAssignment_9_1()); 
            // InternalMyDsl.g:1610:2: ( rule__ProblemSpecification__TasksModelAssignment_9_1 )
            // InternalMyDsl.g:1610:3: rule__ProblemSpecification__TasksModelAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__TasksModelAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getProblemSpecificationAccess().getTasksModelAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group_9__1__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group_13__0"
    // InternalMyDsl.g:1619:1: rule__ProblemSpecification__Group_13__0 : rule__ProblemSpecification__Group_13__0__Impl rule__ProblemSpecification__Group_13__1 ;
    public final void rule__ProblemSpecification__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1623:1: ( rule__ProblemSpecification__Group_13__0__Impl rule__ProblemSpecification__Group_13__1 )
            // InternalMyDsl.g:1624:2: rule__ProblemSpecification__Group_13__0__Impl rule__ProblemSpecification__Group_13__1
            {
            pushFollow(FOLLOW_9);
            rule__ProblemSpecification__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group_13__1();

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
    // $ANTLR end "rule__ProblemSpecification__Group_13__0"


    // $ANTLR start "rule__ProblemSpecification__Group_13__0__Impl"
    // InternalMyDsl.g:1631:1: rule__ProblemSpecification__Group_13__0__Impl : ( ',' ) ;
    public final void rule__ProblemSpecification__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1635:1: ( ( ',' ) )
            // InternalMyDsl.g:1636:1: ( ',' )
            {
            // InternalMyDsl.g:1636:1: ( ',' )
            // InternalMyDsl.g:1637:2: ','
            {
             before(grammarAccess.getProblemSpecificationAccess().getCommaKeyword_13_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getCommaKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group_13__0__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group_13__1"
    // InternalMyDsl.g:1646:1: rule__ProblemSpecification__Group_13__1 : rule__ProblemSpecification__Group_13__1__Impl ;
    public final void rule__ProblemSpecification__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1650:1: ( rule__ProblemSpecification__Group_13__1__Impl )
            // InternalMyDsl.g:1651:2: rule__ProblemSpecification__Group_13__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group_13__1__Impl();

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
    // $ANTLR end "rule__ProblemSpecification__Group_13__1"


    // $ANTLR start "rule__ProblemSpecification__Group_13__1__Impl"
    // InternalMyDsl.g:1657:1: rule__ProblemSpecification__Group_13__1__Impl : ( ( rule__ProblemSpecification__RobotsModelAssignment_13_1 ) ) ;
    public final void rule__ProblemSpecification__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1661:1: ( ( ( rule__ProblemSpecification__RobotsModelAssignment_13_1 ) ) )
            // InternalMyDsl.g:1662:1: ( ( rule__ProblemSpecification__RobotsModelAssignment_13_1 ) )
            {
            // InternalMyDsl.g:1662:1: ( ( rule__ProblemSpecification__RobotsModelAssignment_13_1 ) )
            // InternalMyDsl.g:1663:2: ( rule__ProblemSpecification__RobotsModelAssignment_13_1 )
            {
             before(grammarAccess.getProblemSpecificationAccess().getRobotsModelAssignment_13_1()); 
            // InternalMyDsl.g:1664:2: ( rule__ProblemSpecification__RobotsModelAssignment_13_1 )
            // InternalMyDsl.g:1664:3: rule__ProblemSpecification__RobotsModelAssignment_13_1
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__RobotsModelAssignment_13_1();

            state._fsp--;


            }

             after(grammarAccess.getProblemSpecificationAccess().getRobotsModelAssignment_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group_13__1__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group_17__0"
    // InternalMyDsl.g:1673:1: rule__ProblemSpecification__Group_17__0 : rule__ProblemSpecification__Group_17__0__Impl rule__ProblemSpecification__Group_17__1 ;
    public final void rule__ProblemSpecification__Group_17__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1677:1: ( rule__ProblemSpecification__Group_17__0__Impl rule__ProblemSpecification__Group_17__1 )
            // InternalMyDsl.g:1678:2: rule__ProblemSpecification__Group_17__0__Impl rule__ProblemSpecification__Group_17__1
            {
            pushFollow(FOLLOW_9);
            rule__ProblemSpecification__Group_17__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group_17__1();

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
    // $ANTLR end "rule__ProblemSpecification__Group_17__0"


    // $ANTLR start "rule__ProblemSpecification__Group_17__0__Impl"
    // InternalMyDsl.g:1685:1: rule__ProblemSpecification__Group_17__0__Impl : ( ',' ) ;
    public final void rule__ProblemSpecification__Group_17__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1689:1: ( ( ',' ) )
            // InternalMyDsl.g:1690:1: ( ',' )
            {
            // InternalMyDsl.g:1690:1: ( ',' )
            // InternalMyDsl.g:1691:2: ','
            {
             before(grammarAccess.getProblemSpecificationAccess().getCommaKeyword_17_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getProblemSpecificationAccess().getCommaKeyword_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group_17__0__Impl"


    // $ANTLR start "rule__ProblemSpecification__Group_17__1"
    // InternalMyDsl.g:1700:1: rule__ProblemSpecification__Group_17__1 : rule__ProblemSpecification__Group_17__1__Impl ;
    public final void rule__ProblemSpecification__Group_17__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1704:1: ( rule__ProblemSpecification__Group_17__1__Impl )
            // InternalMyDsl.g:1705:2: rule__ProblemSpecification__Group_17__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__Group_17__1__Impl();

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
    // $ANTLR end "rule__ProblemSpecification__Group_17__1"


    // $ANTLR start "rule__ProblemSpecification__Group_17__1__Impl"
    // InternalMyDsl.g:1711:1: rule__ProblemSpecification__Group_17__1__Impl : ( ( rule__ProblemSpecification__MissionAssignment_17_1 ) ) ;
    public final void rule__ProblemSpecification__Group_17__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1715:1: ( ( ( rule__ProblemSpecification__MissionAssignment_17_1 ) ) )
            // InternalMyDsl.g:1716:1: ( ( rule__ProblemSpecification__MissionAssignment_17_1 ) )
            {
            // InternalMyDsl.g:1716:1: ( ( rule__ProblemSpecification__MissionAssignment_17_1 ) )
            // InternalMyDsl.g:1717:2: ( rule__ProblemSpecification__MissionAssignment_17_1 )
            {
             before(grammarAccess.getProblemSpecificationAccess().getMissionAssignment_17_1()); 
            // InternalMyDsl.g:1718:2: ( rule__ProblemSpecification__MissionAssignment_17_1 )
            // InternalMyDsl.g:1718:3: rule__ProblemSpecification__MissionAssignment_17_1
            {
            pushFollow(FOLLOW_2);
            rule__ProblemSpecification__MissionAssignment_17_1();

            state._fsp--;


            }

             after(grammarAccess.getProblemSpecificationAccess().getMissionAssignment_17_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__Group_17__1__Impl"


    // $ANTLR start "rule__Location__Group__0"
    // InternalMyDsl.g:1727:1: rule__Location__Group__0 : rule__Location__Group__0__Impl rule__Location__Group__1 ;
    public final void rule__Location__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1731:1: ( rule__Location__Group__0__Impl rule__Location__Group__1 )
            // InternalMyDsl.g:1732:2: rule__Location__Group__0__Impl rule__Location__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Location__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Location__Group__1();

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
    // $ANTLR end "rule__Location__Group__0"


    // $ANTLR start "rule__Location__Group__0__Impl"
    // InternalMyDsl.g:1739:1: rule__Location__Group__0__Impl : ( ( rule__Location__NameAssignment_0 ) ) ;
    public final void rule__Location__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1743:1: ( ( ( rule__Location__NameAssignment_0 ) ) )
            // InternalMyDsl.g:1744:1: ( ( rule__Location__NameAssignment_0 ) )
            {
            // InternalMyDsl.g:1744:1: ( ( rule__Location__NameAssignment_0 ) )
            // InternalMyDsl.g:1745:2: ( rule__Location__NameAssignment_0 )
            {
             before(grammarAccess.getLocationAccess().getNameAssignment_0()); 
            // InternalMyDsl.g:1746:2: ( rule__Location__NameAssignment_0 )
            // InternalMyDsl.g:1746:3: rule__Location__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Location__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__0__Impl"


    // $ANTLR start "rule__Location__Group__1"
    // InternalMyDsl.g:1754:1: rule__Location__Group__1 : rule__Location__Group__1__Impl rule__Location__Group__2 ;
    public final void rule__Location__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1758:1: ( rule__Location__Group__1__Impl rule__Location__Group__2 )
            // InternalMyDsl.g:1759:2: rule__Location__Group__1__Impl rule__Location__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Location__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Location__Group__2();

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
    // $ANTLR end "rule__Location__Group__1"


    // $ANTLR start "rule__Location__Group__1__Impl"
    // InternalMyDsl.g:1766:1: rule__Location__Group__1__Impl : ( ':' ) ;
    public final void rule__Location__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1770:1: ( ( ':' ) )
            // InternalMyDsl.g:1771:1: ( ':' )
            {
            // InternalMyDsl.g:1771:1: ( ':' )
            // InternalMyDsl.g:1772:2: ':'
            {
             before(grammarAccess.getLocationAccess().getColonKeyword_1()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getLocationAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__1__Impl"


    // $ANTLR start "rule__Location__Group__2"
    // InternalMyDsl.g:1781:1: rule__Location__Group__2 : rule__Location__Group__2__Impl rule__Location__Group__3 ;
    public final void rule__Location__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1785:1: ( rule__Location__Group__2__Impl rule__Location__Group__3 )
            // InternalMyDsl.g:1786:2: rule__Location__Group__2__Impl rule__Location__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__Location__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Location__Group__3();

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
    // $ANTLR end "rule__Location__Group__2"


    // $ANTLR start "rule__Location__Group__2__Impl"
    // InternalMyDsl.g:1793:1: rule__Location__Group__2__Impl : ( '(' ) ;
    public final void rule__Location__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1797:1: ( ( '(' ) )
            // InternalMyDsl.g:1798:1: ( '(' )
            {
            // InternalMyDsl.g:1798:1: ( '(' )
            // InternalMyDsl.g:1799:2: '('
            {
             before(grammarAccess.getLocationAccess().getLeftParenthesisKeyword_2()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getLocationAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__2__Impl"


    // $ANTLR start "rule__Location__Group__3"
    // InternalMyDsl.g:1808:1: rule__Location__Group__3 : rule__Location__Group__3__Impl rule__Location__Group__4 ;
    public final void rule__Location__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1812:1: ( rule__Location__Group__3__Impl rule__Location__Group__4 )
            // InternalMyDsl.g:1813:2: rule__Location__Group__3__Impl rule__Location__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__Location__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Location__Group__4();

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
    // $ANTLR end "rule__Location__Group__3"


    // $ANTLR start "rule__Location__Group__3__Impl"
    // InternalMyDsl.g:1820:1: rule__Location__Group__3__Impl : ( 'x' ) ;
    public final void rule__Location__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1824:1: ( ( 'x' ) )
            // InternalMyDsl.g:1825:1: ( 'x' )
            {
            // InternalMyDsl.g:1825:1: ( 'x' )
            // InternalMyDsl.g:1826:2: 'x'
            {
             before(grammarAccess.getLocationAccess().getXKeyword_3()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getLocationAccess().getXKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__3__Impl"


    // $ANTLR start "rule__Location__Group__4"
    // InternalMyDsl.g:1835:1: rule__Location__Group__4 : rule__Location__Group__4__Impl rule__Location__Group__5 ;
    public final void rule__Location__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1839:1: ( rule__Location__Group__4__Impl rule__Location__Group__5 )
            // InternalMyDsl.g:1840:2: rule__Location__Group__4__Impl rule__Location__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__Location__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Location__Group__5();

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
    // $ANTLR end "rule__Location__Group__4"


    // $ANTLR start "rule__Location__Group__4__Impl"
    // InternalMyDsl.g:1847:1: rule__Location__Group__4__Impl : ( ( rule__Location__XAssignment_4 ) ) ;
    public final void rule__Location__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1851:1: ( ( ( rule__Location__XAssignment_4 ) ) )
            // InternalMyDsl.g:1852:1: ( ( rule__Location__XAssignment_4 ) )
            {
            // InternalMyDsl.g:1852:1: ( ( rule__Location__XAssignment_4 ) )
            // InternalMyDsl.g:1853:2: ( rule__Location__XAssignment_4 )
            {
             before(grammarAccess.getLocationAccess().getXAssignment_4()); 
            // InternalMyDsl.g:1854:2: ( rule__Location__XAssignment_4 )
            // InternalMyDsl.g:1854:3: rule__Location__XAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Location__XAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getXAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__4__Impl"


    // $ANTLR start "rule__Location__Group__5"
    // InternalMyDsl.g:1862:1: rule__Location__Group__5 : rule__Location__Group__5__Impl rule__Location__Group__6 ;
    public final void rule__Location__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1866:1: ( rule__Location__Group__5__Impl rule__Location__Group__6 )
            // InternalMyDsl.g:1867:2: rule__Location__Group__5__Impl rule__Location__Group__6
            {
            pushFollow(FOLLOW_16);
            rule__Location__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Location__Group__6();

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
    // $ANTLR end "rule__Location__Group__5"


    // $ANTLR start "rule__Location__Group__5__Impl"
    // InternalMyDsl.g:1874:1: rule__Location__Group__5__Impl : ( 'y' ) ;
    public final void rule__Location__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1878:1: ( ( 'y' ) )
            // InternalMyDsl.g:1879:1: ( 'y' )
            {
            // InternalMyDsl.g:1879:1: ( 'y' )
            // InternalMyDsl.g:1880:2: 'y'
            {
             before(grammarAccess.getLocationAccess().getYKeyword_5()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getLocationAccess().getYKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__5__Impl"


    // $ANTLR start "rule__Location__Group__6"
    // InternalMyDsl.g:1889:1: rule__Location__Group__6 : rule__Location__Group__6__Impl rule__Location__Group__7 ;
    public final void rule__Location__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1893:1: ( rule__Location__Group__6__Impl rule__Location__Group__7 )
            // InternalMyDsl.g:1894:2: rule__Location__Group__6__Impl rule__Location__Group__7
            {
            pushFollow(FOLLOW_18);
            rule__Location__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Location__Group__7();

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
    // $ANTLR end "rule__Location__Group__6"


    // $ANTLR start "rule__Location__Group__6__Impl"
    // InternalMyDsl.g:1901:1: rule__Location__Group__6__Impl : ( ( rule__Location__YAssignment_6 ) ) ;
    public final void rule__Location__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1905:1: ( ( ( rule__Location__YAssignment_6 ) ) )
            // InternalMyDsl.g:1906:1: ( ( rule__Location__YAssignment_6 ) )
            {
            // InternalMyDsl.g:1906:1: ( ( rule__Location__YAssignment_6 ) )
            // InternalMyDsl.g:1907:2: ( rule__Location__YAssignment_6 )
            {
             before(grammarAccess.getLocationAccess().getYAssignment_6()); 
            // InternalMyDsl.g:1908:2: ( rule__Location__YAssignment_6 )
            // InternalMyDsl.g:1908:3: rule__Location__YAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Location__YAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getYAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__6__Impl"


    // $ANTLR start "rule__Location__Group__7"
    // InternalMyDsl.g:1916:1: rule__Location__Group__7 : rule__Location__Group__7__Impl rule__Location__Group__8 ;
    public final void rule__Location__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1920:1: ( rule__Location__Group__7__Impl rule__Location__Group__8 )
            // InternalMyDsl.g:1921:2: rule__Location__Group__7__Impl rule__Location__Group__8
            {
            pushFollow(FOLLOW_18);
            rule__Location__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Location__Group__8();

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
    // $ANTLR end "rule__Location__Group__7"


    // $ANTLR start "rule__Location__Group__7__Impl"
    // InternalMyDsl.g:1928:1: rule__Location__Group__7__Impl : ( ( rule__Location__Group_7__0 )? ) ;
    public final void rule__Location__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1932:1: ( ( ( rule__Location__Group_7__0 )? ) )
            // InternalMyDsl.g:1933:1: ( ( rule__Location__Group_7__0 )? )
            {
            // InternalMyDsl.g:1933:1: ( ( rule__Location__Group_7__0 )? )
            // InternalMyDsl.g:1934:2: ( rule__Location__Group_7__0 )?
            {
             before(grammarAccess.getLocationAccess().getGroup_7()); 
            // InternalMyDsl.g:1935:2: ( rule__Location__Group_7__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMyDsl.g:1935:3: rule__Location__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Location__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLocationAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__7__Impl"


    // $ANTLR start "rule__Location__Group__8"
    // InternalMyDsl.g:1943:1: rule__Location__Group__8 : rule__Location__Group__8__Impl ;
    public final void rule__Location__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1947:1: ( rule__Location__Group__8__Impl )
            // InternalMyDsl.g:1948:2: rule__Location__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Location__Group__8__Impl();

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
    // $ANTLR end "rule__Location__Group__8"


    // $ANTLR start "rule__Location__Group__8__Impl"
    // InternalMyDsl.g:1954:1: rule__Location__Group__8__Impl : ( ')' ) ;
    public final void rule__Location__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1958:1: ( ( ')' ) )
            // InternalMyDsl.g:1959:1: ( ')' )
            {
            // InternalMyDsl.g:1959:1: ( ')' )
            // InternalMyDsl.g:1960:2: ')'
            {
             before(grammarAccess.getLocationAccess().getRightParenthesisKeyword_8()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getLocationAccess().getRightParenthesisKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group__8__Impl"


    // $ANTLR start "rule__Location__Group_7__0"
    // InternalMyDsl.g:1970:1: rule__Location__Group_7__0 : rule__Location__Group_7__0__Impl rule__Location__Group_7__1 ;
    public final void rule__Location__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1974:1: ( rule__Location__Group_7__0__Impl rule__Location__Group_7__1 )
            // InternalMyDsl.g:1975:2: rule__Location__Group_7__0__Impl rule__Location__Group_7__1
            {
            pushFollow(FOLLOW_19);
            rule__Location__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Location__Group_7__1();

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
    // $ANTLR end "rule__Location__Group_7__0"


    // $ANTLR start "rule__Location__Group_7__0__Impl"
    // InternalMyDsl.g:1982:1: rule__Location__Group_7__0__Impl : ( ',' ) ;
    public final void rule__Location__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1986:1: ( ( ',' ) )
            // InternalMyDsl.g:1987:1: ( ',' )
            {
            // InternalMyDsl.g:1987:1: ( ',' )
            // InternalMyDsl.g:1988:2: ','
            {
             before(grammarAccess.getLocationAccess().getCommaKeyword_7_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getLocationAccess().getCommaKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_7__0__Impl"


    // $ANTLR start "rule__Location__Group_7__1"
    // InternalMyDsl.g:1997:1: rule__Location__Group_7__1 : rule__Location__Group_7__1__Impl rule__Location__Group_7__2 ;
    public final void rule__Location__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2001:1: ( rule__Location__Group_7__1__Impl rule__Location__Group_7__2 )
            // InternalMyDsl.g:2002:2: rule__Location__Group_7__1__Impl rule__Location__Group_7__2
            {
            pushFollow(FOLLOW_9);
            rule__Location__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Location__Group_7__2();

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
    // $ANTLR end "rule__Location__Group_7__1"


    // $ANTLR start "rule__Location__Group_7__1__Impl"
    // InternalMyDsl.g:2009:1: rule__Location__Group_7__1__Impl : ( 'describes' ) ;
    public final void rule__Location__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2013:1: ( ( 'describes' ) )
            // InternalMyDsl.g:2014:1: ( 'describes' )
            {
            // InternalMyDsl.g:2014:1: ( 'describes' )
            // InternalMyDsl.g:2015:2: 'describes'
            {
             before(grammarAccess.getLocationAccess().getDescribesKeyword_7_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLocationAccess().getDescribesKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_7__1__Impl"


    // $ANTLR start "rule__Location__Group_7__2"
    // InternalMyDsl.g:2024:1: rule__Location__Group_7__2 : rule__Location__Group_7__2__Impl ;
    public final void rule__Location__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2028:1: ( rule__Location__Group_7__2__Impl )
            // InternalMyDsl.g:2029:2: rule__Location__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Location__Group_7__2__Impl();

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
    // $ANTLR end "rule__Location__Group_7__2"


    // $ANTLR start "rule__Location__Group_7__2__Impl"
    // InternalMyDsl.g:2035:1: rule__Location__Group_7__2__Impl : ( ( rule__Location__DescriptionAssignment_7_2 ) ) ;
    public final void rule__Location__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2039:1: ( ( ( rule__Location__DescriptionAssignment_7_2 ) ) )
            // InternalMyDsl.g:2040:1: ( ( rule__Location__DescriptionAssignment_7_2 ) )
            {
            // InternalMyDsl.g:2040:1: ( ( rule__Location__DescriptionAssignment_7_2 ) )
            // InternalMyDsl.g:2041:2: ( rule__Location__DescriptionAssignment_7_2 )
            {
             before(grammarAccess.getLocationAccess().getDescriptionAssignment_7_2()); 
            // InternalMyDsl.g:2042:2: ( rule__Location__DescriptionAssignment_7_2 )
            // InternalMyDsl.g:2042:3: rule__Location__DescriptionAssignment_7_2
            {
            pushFollow(FOLLOW_2);
            rule__Location__DescriptionAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getLocationAccess().getDescriptionAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__Group_7__2__Impl"


    // $ANTLR start "rule__Paths__Group__0"
    // InternalMyDsl.g:2051:1: rule__Paths__Group__0 : rule__Paths__Group__0__Impl rule__Paths__Group__1 ;
    public final void rule__Paths__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2055:1: ( rule__Paths__Group__0__Impl rule__Paths__Group__1 )
            // InternalMyDsl.g:2056:2: rule__Paths__Group__0__Impl rule__Paths__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Paths__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Paths__Group__1();

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
    // $ANTLR end "rule__Paths__Group__0"


    // $ANTLR start "rule__Paths__Group__0__Impl"
    // InternalMyDsl.g:2063:1: rule__Paths__Group__0__Impl : ( 'distance' ) ;
    public final void rule__Paths__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2067:1: ( ( 'distance' ) )
            // InternalMyDsl.g:2068:1: ( 'distance' )
            {
            // InternalMyDsl.g:2068:1: ( 'distance' )
            // InternalMyDsl.g:2069:2: 'distance'
            {
             before(grammarAccess.getPathsAccess().getDistanceKeyword_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getPathsAccess().getDistanceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paths__Group__0__Impl"


    // $ANTLR start "rule__Paths__Group__1"
    // InternalMyDsl.g:2078:1: rule__Paths__Group__1 : rule__Paths__Group__1__Impl rule__Paths__Group__2 ;
    public final void rule__Paths__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2082:1: ( rule__Paths__Group__1__Impl rule__Paths__Group__2 )
            // InternalMyDsl.g:2083:2: rule__Paths__Group__1__Impl rule__Paths__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__Paths__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Paths__Group__2();

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
    // $ANTLR end "rule__Paths__Group__1"


    // $ANTLR start "rule__Paths__Group__1__Impl"
    // InternalMyDsl.g:2090:1: rule__Paths__Group__1__Impl : ( ( rule__Paths__Loc1Assignment_1 ) ) ;
    public final void rule__Paths__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2094:1: ( ( ( rule__Paths__Loc1Assignment_1 ) ) )
            // InternalMyDsl.g:2095:1: ( ( rule__Paths__Loc1Assignment_1 ) )
            {
            // InternalMyDsl.g:2095:1: ( ( rule__Paths__Loc1Assignment_1 ) )
            // InternalMyDsl.g:2096:2: ( rule__Paths__Loc1Assignment_1 )
            {
             before(grammarAccess.getPathsAccess().getLoc1Assignment_1()); 
            // InternalMyDsl.g:2097:2: ( rule__Paths__Loc1Assignment_1 )
            // InternalMyDsl.g:2097:3: rule__Paths__Loc1Assignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Paths__Loc1Assignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPathsAccess().getLoc1Assignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paths__Group__1__Impl"


    // $ANTLR start "rule__Paths__Group__2"
    // InternalMyDsl.g:2105:1: rule__Paths__Group__2 : rule__Paths__Group__2__Impl rule__Paths__Group__3 ;
    public final void rule__Paths__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2109:1: ( rule__Paths__Group__2__Impl rule__Paths__Group__3 )
            // InternalMyDsl.g:2110:2: rule__Paths__Group__2__Impl rule__Paths__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__Paths__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Paths__Group__3();

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
    // $ANTLR end "rule__Paths__Group__2"


    // $ANTLR start "rule__Paths__Group__2__Impl"
    // InternalMyDsl.g:2117:1: rule__Paths__Group__2__Impl : ( 'to' ) ;
    public final void rule__Paths__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2121:1: ( ( 'to' ) )
            // InternalMyDsl.g:2122:1: ( 'to' )
            {
            // InternalMyDsl.g:2122:1: ( 'to' )
            // InternalMyDsl.g:2123:2: 'to'
            {
             before(grammarAccess.getPathsAccess().getToKeyword_2()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getPathsAccess().getToKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paths__Group__2__Impl"


    // $ANTLR start "rule__Paths__Group__3"
    // InternalMyDsl.g:2132:1: rule__Paths__Group__3 : rule__Paths__Group__3__Impl rule__Paths__Group__4 ;
    public final void rule__Paths__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2136:1: ( rule__Paths__Group__3__Impl rule__Paths__Group__4 )
            // InternalMyDsl.g:2137:2: rule__Paths__Group__3__Impl rule__Paths__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__Paths__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Paths__Group__4();

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
    // $ANTLR end "rule__Paths__Group__3"


    // $ANTLR start "rule__Paths__Group__3__Impl"
    // InternalMyDsl.g:2144:1: rule__Paths__Group__3__Impl : ( ( rule__Paths__Loc2Assignment_3 ) ) ;
    public final void rule__Paths__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2148:1: ( ( ( rule__Paths__Loc2Assignment_3 ) ) )
            // InternalMyDsl.g:2149:1: ( ( rule__Paths__Loc2Assignment_3 ) )
            {
            // InternalMyDsl.g:2149:1: ( ( rule__Paths__Loc2Assignment_3 ) )
            // InternalMyDsl.g:2150:2: ( rule__Paths__Loc2Assignment_3 )
            {
             before(grammarAccess.getPathsAccess().getLoc2Assignment_3()); 
            // InternalMyDsl.g:2151:2: ( rule__Paths__Loc2Assignment_3 )
            // InternalMyDsl.g:2151:3: rule__Paths__Loc2Assignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Paths__Loc2Assignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPathsAccess().getLoc2Assignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paths__Group__3__Impl"


    // $ANTLR start "rule__Paths__Group__4"
    // InternalMyDsl.g:2159:1: rule__Paths__Group__4 : rule__Paths__Group__4__Impl rule__Paths__Group__5 ;
    public final void rule__Paths__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2163:1: ( rule__Paths__Group__4__Impl rule__Paths__Group__5 )
            // InternalMyDsl.g:2164:2: rule__Paths__Group__4__Impl rule__Paths__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__Paths__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Paths__Group__5();

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
    // $ANTLR end "rule__Paths__Group__4"


    // $ANTLR start "rule__Paths__Group__4__Impl"
    // InternalMyDsl.g:2171:1: rule__Paths__Group__4__Impl : ( 'is' ) ;
    public final void rule__Paths__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2175:1: ( ( 'is' ) )
            // InternalMyDsl.g:2176:1: ( 'is' )
            {
            // InternalMyDsl.g:2176:1: ( 'is' )
            // InternalMyDsl.g:2177:2: 'is'
            {
             before(grammarAccess.getPathsAccess().getIsKeyword_4()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getPathsAccess().getIsKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paths__Group__4__Impl"


    // $ANTLR start "rule__Paths__Group__5"
    // InternalMyDsl.g:2186:1: rule__Paths__Group__5 : rule__Paths__Group__5__Impl ;
    public final void rule__Paths__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2190:1: ( rule__Paths__Group__5__Impl )
            // InternalMyDsl.g:2191:2: rule__Paths__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Paths__Group__5__Impl();

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
    // $ANTLR end "rule__Paths__Group__5"


    // $ANTLR start "rule__Paths__Group__5__Impl"
    // InternalMyDsl.g:2197:1: rule__Paths__Group__5__Impl : ( ( rule__Paths__DistanceAssignment_5 ) ) ;
    public final void rule__Paths__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2201:1: ( ( ( rule__Paths__DistanceAssignment_5 ) ) )
            // InternalMyDsl.g:2202:1: ( ( rule__Paths__DistanceAssignment_5 ) )
            {
            // InternalMyDsl.g:2202:1: ( ( rule__Paths__DistanceAssignment_5 ) )
            // InternalMyDsl.g:2203:2: ( rule__Paths__DistanceAssignment_5 )
            {
             before(grammarAccess.getPathsAccess().getDistanceAssignment_5()); 
            // InternalMyDsl.g:2204:2: ( rule__Paths__DistanceAssignment_5 )
            // InternalMyDsl.g:2204:3: rule__Paths__DistanceAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Paths__DistanceAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getPathsAccess().getDistanceAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paths__Group__5__Impl"


    // $ANTLR start "rule__AtomicTask__Group__0"
    // InternalMyDsl.g:2213:1: rule__AtomicTask__Group__0 : rule__AtomicTask__Group__0__Impl rule__AtomicTask__Group__1 ;
    public final void rule__AtomicTask__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2217:1: ( rule__AtomicTask__Group__0__Impl rule__AtomicTask__Group__1 )
            // InternalMyDsl.g:2218:2: rule__AtomicTask__Group__0__Impl rule__AtomicTask__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__AtomicTask__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AtomicTask__Group__1();

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
    // $ANTLR end "rule__AtomicTask__Group__0"


    // $ANTLR start "rule__AtomicTask__Group__0__Impl"
    // InternalMyDsl.g:2225:1: rule__AtomicTask__Group__0__Impl : ( ( rule__AtomicTask__NameAssignment_0 ) ) ;
    public final void rule__AtomicTask__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2229:1: ( ( ( rule__AtomicTask__NameAssignment_0 ) ) )
            // InternalMyDsl.g:2230:1: ( ( rule__AtomicTask__NameAssignment_0 ) )
            {
            // InternalMyDsl.g:2230:1: ( ( rule__AtomicTask__NameAssignment_0 ) )
            // InternalMyDsl.g:2231:2: ( rule__AtomicTask__NameAssignment_0 )
            {
             before(grammarAccess.getAtomicTaskAccess().getNameAssignment_0()); 
            // InternalMyDsl.g:2232:2: ( rule__AtomicTask__NameAssignment_0 )
            // InternalMyDsl.g:2232:3: rule__AtomicTask__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AtomicTask__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAtomicTaskAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__Group__0__Impl"


    // $ANTLR start "rule__AtomicTask__Group__1"
    // InternalMyDsl.g:2240:1: rule__AtomicTask__Group__1 : rule__AtomicTask__Group__1__Impl rule__AtomicTask__Group__2 ;
    public final void rule__AtomicTask__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2244:1: ( rule__AtomicTask__Group__1__Impl rule__AtomicTask__Group__2 )
            // InternalMyDsl.g:2245:2: rule__AtomicTask__Group__1__Impl rule__AtomicTask__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__AtomicTask__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AtomicTask__Group__2();

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
    // $ANTLR end "rule__AtomicTask__Group__1"


    // $ANTLR start "rule__AtomicTask__Group__1__Impl"
    // InternalMyDsl.g:2252:1: rule__AtomicTask__Group__1__Impl : ( ':' ) ;
    public final void rule__AtomicTask__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2256:1: ( ( ':' ) )
            // InternalMyDsl.g:2257:1: ( ':' )
            {
            // InternalMyDsl.g:2257:1: ( ':' )
            // InternalMyDsl.g:2258:2: ':'
            {
             before(grammarAccess.getAtomicTaskAccess().getColonKeyword_1()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getAtomicTaskAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__Group__1__Impl"


    // $ANTLR start "rule__AtomicTask__Group__2"
    // InternalMyDsl.g:2267:1: rule__AtomicTask__Group__2 : rule__AtomicTask__Group__2__Impl rule__AtomicTask__Group__3 ;
    public final void rule__AtomicTask__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2271:1: ( rule__AtomicTask__Group__2__Impl rule__AtomicTask__Group__3 )
            // InternalMyDsl.g:2272:2: rule__AtomicTask__Group__2__Impl rule__AtomicTask__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__AtomicTask__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AtomicTask__Group__3();

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
    // $ANTLR end "rule__AtomicTask__Group__2"


    // $ANTLR start "rule__AtomicTask__Group__2__Impl"
    // InternalMyDsl.g:2279:1: rule__AtomicTask__Group__2__Impl : ( ( rule__AtomicTask__RobotsAssignment_2 ) ) ;
    public final void rule__AtomicTask__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2283:1: ( ( ( rule__AtomicTask__RobotsAssignment_2 ) ) )
            // InternalMyDsl.g:2284:1: ( ( rule__AtomicTask__RobotsAssignment_2 ) )
            {
            // InternalMyDsl.g:2284:1: ( ( rule__AtomicTask__RobotsAssignment_2 ) )
            // InternalMyDsl.g:2285:2: ( rule__AtomicTask__RobotsAssignment_2 )
            {
             before(grammarAccess.getAtomicTaskAccess().getRobotsAssignment_2()); 
            // InternalMyDsl.g:2286:2: ( rule__AtomicTask__RobotsAssignment_2 )
            // InternalMyDsl.g:2286:3: rule__AtomicTask__RobotsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AtomicTask__RobotsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAtomicTaskAccess().getRobotsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__Group__2__Impl"


    // $ANTLR start "rule__AtomicTask__Group__3"
    // InternalMyDsl.g:2294:1: rule__AtomicTask__Group__3 : rule__AtomicTask__Group__3__Impl rule__AtomicTask__Group__4 ;
    public final void rule__AtomicTask__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2298:1: ( rule__AtomicTask__Group__3__Impl rule__AtomicTask__Group__4 )
            // InternalMyDsl.g:2299:2: rule__AtomicTask__Group__3__Impl rule__AtomicTask__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__AtomicTask__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AtomicTask__Group__4();

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
    // $ANTLR end "rule__AtomicTask__Group__3"


    // $ANTLR start "rule__AtomicTask__Group__3__Impl"
    // InternalMyDsl.g:2306:1: rule__AtomicTask__Group__3__Impl : ( ( rule__AtomicTask__Alternatives_3 ) ) ;
    public final void rule__AtomicTask__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2310:1: ( ( ( rule__AtomicTask__Alternatives_3 ) ) )
            // InternalMyDsl.g:2311:1: ( ( rule__AtomicTask__Alternatives_3 ) )
            {
            // InternalMyDsl.g:2311:1: ( ( rule__AtomicTask__Alternatives_3 ) )
            // InternalMyDsl.g:2312:2: ( rule__AtomicTask__Alternatives_3 )
            {
             before(grammarAccess.getAtomicTaskAccess().getAlternatives_3()); 
            // InternalMyDsl.g:2313:2: ( rule__AtomicTask__Alternatives_3 )
            // InternalMyDsl.g:2313:3: rule__AtomicTask__Alternatives_3
            {
            pushFollow(FOLLOW_2);
            rule__AtomicTask__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getAtomicTaskAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__Group__3__Impl"


    // $ANTLR start "rule__AtomicTask__Group__4"
    // InternalMyDsl.g:2321:1: rule__AtomicTask__Group__4 : rule__AtomicTask__Group__4__Impl rule__AtomicTask__Group__5 ;
    public final void rule__AtomicTask__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2325:1: ( rule__AtomicTask__Group__4__Impl rule__AtomicTask__Group__5 )
            // InternalMyDsl.g:2326:2: rule__AtomicTask__Group__4__Impl rule__AtomicTask__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__AtomicTask__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AtomicTask__Group__5();

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
    // $ANTLR end "rule__AtomicTask__Group__4"


    // $ANTLR start "rule__AtomicTask__Group__4__Impl"
    // InternalMyDsl.g:2333:1: rule__AtomicTask__Group__4__Impl : ( 'needed' ) ;
    public final void rule__AtomicTask__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2337:1: ( ( 'needed' ) )
            // InternalMyDsl.g:2338:1: ( 'needed' )
            {
            // InternalMyDsl.g:2338:1: ( 'needed' )
            // InternalMyDsl.g:2339:2: 'needed'
            {
             before(grammarAccess.getAtomicTaskAccess().getNeededKeyword_4()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getAtomicTaskAccess().getNeededKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__Group__4__Impl"


    // $ANTLR start "rule__AtomicTask__Group__5"
    // InternalMyDsl.g:2348:1: rule__AtomicTask__Group__5 : rule__AtomicTask__Group__5__Impl rule__AtomicTask__Group__6 ;
    public final void rule__AtomicTask__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2352:1: ( rule__AtomicTask__Group__5__Impl rule__AtomicTask__Group__6 )
            // InternalMyDsl.g:2353:2: rule__AtomicTask__Group__5__Impl rule__AtomicTask__Group__6
            {
            pushFollow(FOLLOW_26);
            rule__AtomicTask__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AtomicTask__Group__6();

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
    // $ANTLR end "rule__AtomicTask__Group__5"


    // $ANTLR start "rule__AtomicTask__Group__5__Impl"
    // InternalMyDsl.g:2360:1: rule__AtomicTask__Group__5__Impl : ( 'at' ) ;
    public final void rule__AtomicTask__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2364:1: ( ( 'at' ) )
            // InternalMyDsl.g:2365:1: ( 'at' )
            {
            // InternalMyDsl.g:2365:1: ( 'at' )
            // InternalMyDsl.g:2366:2: 'at'
            {
             before(grammarAccess.getAtomicTaskAccess().getAtKeyword_5()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getAtomicTaskAccess().getAtKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__Group__5__Impl"


    // $ANTLR start "rule__AtomicTask__Group__6"
    // InternalMyDsl.g:2375:1: rule__AtomicTask__Group__6 : rule__AtomicTask__Group__6__Impl rule__AtomicTask__Group__7 ;
    public final void rule__AtomicTask__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2379:1: ( rule__AtomicTask__Group__6__Impl rule__AtomicTask__Group__7 )
            // InternalMyDsl.g:2380:2: rule__AtomicTask__Group__6__Impl rule__AtomicTask__Group__7
            {
            pushFollow(FOLLOW_9);
            rule__AtomicTask__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AtomicTask__Group__7();

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
    // $ANTLR end "rule__AtomicTask__Group__6"


    // $ANTLR start "rule__AtomicTask__Group__6__Impl"
    // InternalMyDsl.g:2387:1: rule__AtomicTask__Group__6__Impl : ( 'location' ) ;
    public final void rule__AtomicTask__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2391:1: ( ( 'location' ) )
            // InternalMyDsl.g:2392:1: ( 'location' )
            {
            // InternalMyDsl.g:2392:1: ( 'location' )
            // InternalMyDsl.g:2393:2: 'location'
            {
             before(grammarAccess.getAtomicTaskAccess().getLocationKeyword_6()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getAtomicTaskAccess().getLocationKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__Group__6__Impl"


    // $ANTLR start "rule__AtomicTask__Group__7"
    // InternalMyDsl.g:2402:1: rule__AtomicTask__Group__7 : rule__AtomicTask__Group__7__Impl ;
    public final void rule__AtomicTask__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2406:1: ( rule__AtomicTask__Group__7__Impl )
            // InternalMyDsl.g:2407:2: rule__AtomicTask__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AtomicTask__Group__7__Impl();

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
    // $ANTLR end "rule__AtomicTask__Group__7"


    // $ANTLR start "rule__AtomicTask__Group__7__Impl"
    // InternalMyDsl.g:2413:1: rule__AtomicTask__Group__7__Impl : ( ( rule__AtomicTask__LocAssignment_7 ) ) ;
    public final void rule__AtomicTask__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2417:1: ( ( ( rule__AtomicTask__LocAssignment_7 ) ) )
            // InternalMyDsl.g:2418:1: ( ( rule__AtomicTask__LocAssignment_7 ) )
            {
            // InternalMyDsl.g:2418:1: ( ( rule__AtomicTask__LocAssignment_7 ) )
            // InternalMyDsl.g:2419:2: ( rule__AtomicTask__LocAssignment_7 )
            {
             before(grammarAccess.getAtomicTaskAccess().getLocAssignment_7()); 
            // InternalMyDsl.g:2420:2: ( rule__AtomicTask__LocAssignment_7 )
            // InternalMyDsl.g:2420:3: rule__AtomicTask__LocAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__AtomicTask__LocAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getAtomicTaskAccess().getLocAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__Group__7__Impl"


    // $ANTLR start "rule__CompoundTask__Group__0"
    // InternalMyDsl.g:2429:1: rule__CompoundTask__Group__0 : rule__CompoundTask__Group__0__Impl rule__CompoundTask__Group__1 ;
    public final void rule__CompoundTask__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2433:1: ( rule__CompoundTask__Group__0__Impl rule__CompoundTask__Group__1 )
            // InternalMyDsl.g:2434:2: rule__CompoundTask__Group__0__Impl rule__CompoundTask__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__CompoundTask__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group__1();

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
    // $ANTLR end "rule__CompoundTask__Group__0"


    // $ANTLR start "rule__CompoundTask__Group__0__Impl"
    // InternalMyDsl.g:2441:1: rule__CompoundTask__Group__0__Impl : ( ( rule__CompoundTask__NameAssignment_0 ) ) ;
    public final void rule__CompoundTask__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2445:1: ( ( ( rule__CompoundTask__NameAssignment_0 ) ) )
            // InternalMyDsl.g:2446:1: ( ( rule__CompoundTask__NameAssignment_0 ) )
            {
            // InternalMyDsl.g:2446:1: ( ( rule__CompoundTask__NameAssignment_0 ) )
            // InternalMyDsl.g:2447:2: ( rule__CompoundTask__NameAssignment_0 )
            {
             before(grammarAccess.getCompoundTaskAccess().getNameAssignment_0()); 
            // InternalMyDsl.g:2448:2: ( rule__CompoundTask__NameAssignment_0 )
            // InternalMyDsl.g:2448:3: rule__CompoundTask__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCompoundTaskAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group__0__Impl"


    // $ANTLR start "rule__CompoundTask__Group__1"
    // InternalMyDsl.g:2456:1: rule__CompoundTask__Group__1 : rule__CompoundTask__Group__1__Impl rule__CompoundTask__Group__2 ;
    public final void rule__CompoundTask__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2460:1: ( rule__CompoundTask__Group__1__Impl rule__CompoundTask__Group__2 )
            // InternalMyDsl.g:2461:2: rule__CompoundTask__Group__1__Impl rule__CompoundTask__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__CompoundTask__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group__2();

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
    // $ANTLR end "rule__CompoundTask__Group__1"


    // $ANTLR start "rule__CompoundTask__Group__1__Impl"
    // InternalMyDsl.g:2468:1: rule__CompoundTask__Group__1__Impl : ( ':' ) ;
    public final void rule__CompoundTask__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2472:1: ( ( ':' ) )
            // InternalMyDsl.g:2473:1: ( ':' )
            {
            // InternalMyDsl.g:2473:1: ( ':' )
            // InternalMyDsl.g:2474:2: ':'
            {
             before(grammarAccess.getCompoundTaskAccess().getColonKeyword_1()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getCompoundTaskAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group__1__Impl"


    // $ANTLR start "rule__CompoundTask__Group__2"
    // InternalMyDsl.g:2483:1: rule__CompoundTask__Group__2 : rule__CompoundTask__Group__2__Impl rule__CompoundTask__Group__3 ;
    public final void rule__CompoundTask__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2487:1: ( rule__CompoundTask__Group__2__Impl rule__CompoundTask__Group__3 )
            // InternalMyDsl.g:2488:2: rule__CompoundTask__Group__2__Impl rule__CompoundTask__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__CompoundTask__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group__3();

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
    // $ANTLR end "rule__CompoundTask__Group__2"


    // $ANTLR start "rule__CompoundTask__Group__2__Impl"
    // InternalMyDsl.g:2495:1: rule__CompoundTask__Group__2__Impl : ( 'subtasks' ) ;
    public final void rule__CompoundTask__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2499:1: ( ( 'subtasks' ) )
            // InternalMyDsl.g:2500:1: ( 'subtasks' )
            {
            // InternalMyDsl.g:2500:1: ( 'subtasks' )
            // InternalMyDsl.g:2501:2: 'subtasks'
            {
             before(grammarAccess.getCompoundTaskAccess().getSubtasksKeyword_2()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getCompoundTaskAccess().getSubtasksKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group__2__Impl"


    // $ANTLR start "rule__CompoundTask__Group__3"
    // InternalMyDsl.g:2510:1: rule__CompoundTask__Group__3 : rule__CompoundTask__Group__3__Impl rule__CompoundTask__Group__4 ;
    public final void rule__CompoundTask__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2514:1: ( rule__CompoundTask__Group__3__Impl rule__CompoundTask__Group__4 )
            // InternalMyDsl.g:2515:2: rule__CompoundTask__Group__3__Impl rule__CompoundTask__Group__4
            {
            pushFollow(FOLLOW_29);
            rule__CompoundTask__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group__4();

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
    // $ANTLR end "rule__CompoundTask__Group__3"


    // $ANTLR start "rule__CompoundTask__Group__3__Impl"
    // InternalMyDsl.g:2522:1: rule__CompoundTask__Group__3__Impl : ( '[' ) ;
    public final void rule__CompoundTask__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2526:1: ( ( '[' ) )
            // InternalMyDsl.g:2527:1: ( '[' )
            {
            // InternalMyDsl.g:2527:1: ( '[' )
            // InternalMyDsl.g:2528:2: '['
            {
             before(grammarAccess.getCompoundTaskAccess().getLeftSquareBracketKeyword_3()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getCompoundTaskAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group__3__Impl"


    // $ANTLR start "rule__CompoundTask__Group__4"
    // InternalMyDsl.g:2537:1: rule__CompoundTask__Group__4 : rule__CompoundTask__Group__4__Impl rule__CompoundTask__Group__5 ;
    public final void rule__CompoundTask__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2541:1: ( rule__CompoundTask__Group__4__Impl rule__CompoundTask__Group__5 )
            // InternalMyDsl.g:2542:2: rule__CompoundTask__Group__4__Impl rule__CompoundTask__Group__5
            {
            pushFollow(FOLLOW_29);
            rule__CompoundTask__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group__5();

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
    // $ANTLR end "rule__CompoundTask__Group__4"


    // $ANTLR start "rule__CompoundTask__Group__4__Impl"
    // InternalMyDsl.g:2549:1: rule__CompoundTask__Group__4__Impl : ( ( rule__CompoundTask__Group_4__0 )? ) ;
    public final void rule__CompoundTask__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2553:1: ( ( ( rule__CompoundTask__Group_4__0 )? ) )
            // InternalMyDsl.g:2554:1: ( ( rule__CompoundTask__Group_4__0 )? )
            {
            // InternalMyDsl.g:2554:1: ( ( rule__CompoundTask__Group_4__0 )? )
            // InternalMyDsl.g:2555:2: ( rule__CompoundTask__Group_4__0 )?
            {
             before(grammarAccess.getCompoundTaskAccess().getGroup_4()); 
            // InternalMyDsl.g:2556:2: ( rule__CompoundTask__Group_4__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_STRING && LA23_0<=RULE_ID)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:2556:3: rule__CompoundTask__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CompoundTask__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCompoundTaskAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group__4__Impl"


    // $ANTLR start "rule__CompoundTask__Group__5"
    // InternalMyDsl.g:2564:1: rule__CompoundTask__Group__5 : rule__CompoundTask__Group__5__Impl rule__CompoundTask__Group__6 ;
    public final void rule__CompoundTask__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2568:1: ( rule__CompoundTask__Group__5__Impl rule__CompoundTask__Group__6 )
            // InternalMyDsl.g:2569:2: rule__CompoundTask__Group__5__Impl rule__CompoundTask__Group__6
            {
            pushFollow(FOLLOW_30);
            rule__CompoundTask__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group__6();

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
    // $ANTLR end "rule__CompoundTask__Group__5"


    // $ANTLR start "rule__CompoundTask__Group__5__Impl"
    // InternalMyDsl.g:2576:1: rule__CompoundTask__Group__5__Impl : ( ']' ) ;
    public final void rule__CompoundTask__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2580:1: ( ( ']' ) )
            // InternalMyDsl.g:2581:1: ( ']' )
            {
            // InternalMyDsl.g:2581:1: ( ']' )
            // InternalMyDsl.g:2582:2: ']'
            {
             before(grammarAccess.getCompoundTaskAccess().getRightSquareBracketKeyword_5()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getCompoundTaskAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group__5__Impl"


    // $ANTLR start "rule__CompoundTask__Group__6"
    // InternalMyDsl.g:2591:1: rule__CompoundTask__Group__6 : rule__CompoundTask__Group__6__Impl ;
    public final void rule__CompoundTask__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2595:1: ( rule__CompoundTask__Group__6__Impl )
            // InternalMyDsl.g:2596:2: rule__CompoundTask__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group__6__Impl();

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
    // $ANTLR end "rule__CompoundTask__Group__6"


    // $ANTLR start "rule__CompoundTask__Group__6__Impl"
    // InternalMyDsl.g:2602:1: rule__CompoundTask__Group__6__Impl : ( ( rule__CompoundTask__Alternatives_6 )? ) ;
    public final void rule__CompoundTask__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2606:1: ( ( ( rule__CompoundTask__Alternatives_6 )? ) )
            // InternalMyDsl.g:2607:1: ( ( rule__CompoundTask__Alternatives_6 )? )
            {
            // InternalMyDsl.g:2607:1: ( ( rule__CompoundTask__Alternatives_6 )? )
            // InternalMyDsl.g:2608:2: ( rule__CompoundTask__Alternatives_6 )?
            {
             before(grammarAccess.getCompoundTaskAccess().getAlternatives_6()); 
            // InternalMyDsl.g:2609:2: ( rule__CompoundTask__Alternatives_6 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==45) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMyDsl.g:2609:3: rule__CompoundTask__Alternatives_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__CompoundTask__Alternatives_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCompoundTaskAccess().getAlternatives_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group__6__Impl"


    // $ANTLR start "rule__CompoundTask__Group_4__0"
    // InternalMyDsl.g:2618:1: rule__CompoundTask__Group_4__0 : rule__CompoundTask__Group_4__0__Impl rule__CompoundTask__Group_4__1 ;
    public final void rule__CompoundTask__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2622:1: ( rule__CompoundTask__Group_4__0__Impl rule__CompoundTask__Group_4__1 )
            // InternalMyDsl.g:2623:2: rule__CompoundTask__Group_4__0__Impl rule__CompoundTask__Group_4__1
            {
            pushFollow(FOLLOW_31);
            rule__CompoundTask__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group_4__1();

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
    // $ANTLR end "rule__CompoundTask__Group_4__0"


    // $ANTLR start "rule__CompoundTask__Group_4__0__Impl"
    // InternalMyDsl.g:2630:1: rule__CompoundTask__Group_4__0__Impl : ( ( rule__CompoundTask__CanDoTaskAssignment_4_0 ) ) ;
    public final void rule__CompoundTask__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2634:1: ( ( ( rule__CompoundTask__CanDoTaskAssignment_4_0 ) ) )
            // InternalMyDsl.g:2635:1: ( ( rule__CompoundTask__CanDoTaskAssignment_4_0 ) )
            {
            // InternalMyDsl.g:2635:1: ( ( rule__CompoundTask__CanDoTaskAssignment_4_0 ) )
            // InternalMyDsl.g:2636:2: ( rule__CompoundTask__CanDoTaskAssignment_4_0 )
            {
             before(grammarAccess.getCompoundTaskAccess().getCanDoTaskAssignment_4_0()); 
            // InternalMyDsl.g:2637:2: ( rule__CompoundTask__CanDoTaskAssignment_4_0 )
            // InternalMyDsl.g:2637:3: rule__CompoundTask__CanDoTaskAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__CanDoTaskAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getCompoundTaskAccess().getCanDoTaskAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group_4__0__Impl"


    // $ANTLR start "rule__CompoundTask__Group_4__1"
    // InternalMyDsl.g:2645:1: rule__CompoundTask__Group_4__1 : rule__CompoundTask__Group_4__1__Impl ;
    public final void rule__CompoundTask__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2649:1: ( rule__CompoundTask__Group_4__1__Impl )
            // InternalMyDsl.g:2650:2: rule__CompoundTask__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group_4__1__Impl();

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
    // $ANTLR end "rule__CompoundTask__Group_4__1"


    // $ANTLR start "rule__CompoundTask__Group_4__1__Impl"
    // InternalMyDsl.g:2656:1: rule__CompoundTask__Group_4__1__Impl : ( ( rule__CompoundTask__Group_4_1__0 )* ) ;
    public final void rule__CompoundTask__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2660:1: ( ( ( rule__CompoundTask__Group_4_1__0 )* ) )
            // InternalMyDsl.g:2661:1: ( ( rule__CompoundTask__Group_4_1__0 )* )
            {
            // InternalMyDsl.g:2661:1: ( ( rule__CompoundTask__Group_4_1__0 )* )
            // InternalMyDsl.g:2662:2: ( rule__CompoundTask__Group_4_1__0 )*
            {
             before(grammarAccess.getCompoundTaskAccess().getGroup_4_1()); 
            // InternalMyDsl.g:2663:2: ( rule__CompoundTask__Group_4_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==32) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalMyDsl.g:2663:3: rule__CompoundTask__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__CompoundTask__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getCompoundTaskAccess().getGroup_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group_4__1__Impl"


    // $ANTLR start "rule__CompoundTask__Group_4_1__0"
    // InternalMyDsl.g:2672:1: rule__CompoundTask__Group_4_1__0 : rule__CompoundTask__Group_4_1__0__Impl rule__CompoundTask__Group_4_1__1 ;
    public final void rule__CompoundTask__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2676:1: ( rule__CompoundTask__Group_4_1__0__Impl rule__CompoundTask__Group_4_1__1 )
            // InternalMyDsl.g:2677:2: rule__CompoundTask__Group_4_1__0__Impl rule__CompoundTask__Group_4_1__1
            {
            pushFollow(FOLLOW_9);
            rule__CompoundTask__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group_4_1__1();

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
    // $ANTLR end "rule__CompoundTask__Group_4_1__0"


    // $ANTLR start "rule__CompoundTask__Group_4_1__0__Impl"
    // InternalMyDsl.g:2684:1: rule__CompoundTask__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__CompoundTask__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2688:1: ( ( ',' ) )
            // InternalMyDsl.g:2689:1: ( ',' )
            {
            // InternalMyDsl.g:2689:1: ( ',' )
            // InternalMyDsl.g:2690:2: ','
            {
             before(grammarAccess.getCompoundTaskAccess().getCommaKeyword_4_1_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getCompoundTaskAccess().getCommaKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group_4_1__0__Impl"


    // $ANTLR start "rule__CompoundTask__Group_4_1__1"
    // InternalMyDsl.g:2699:1: rule__CompoundTask__Group_4_1__1 : rule__CompoundTask__Group_4_1__1__Impl ;
    public final void rule__CompoundTask__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2703:1: ( rule__CompoundTask__Group_4_1__1__Impl )
            // InternalMyDsl.g:2704:2: rule__CompoundTask__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group_4_1__1__Impl();

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
    // $ANTLR end "rule__CompoundTask__Group_4_1__1"


    // $ANTLR start "rule__CompoundTask__Group_4_1__1__Impl"
    // InternalMyDsl.g:2710:1: rule__CompoundTask__Group_4_1__1__Impl : ( ( rule__CompoundTask__CanDoTaskAssignment_4_1_1 ) ) ;
    public final void rule__CompoundTask__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2714:1: ( ( ( rule__CompoundTask__CanDoTaskAssignment_4_1_1 ) ) )
            // InternalMyDsl.g:2715:1: ( ( rule__CompoundTask__CanDoTaskAssignment_4_1_1 ) )
            {
            // InternalMyDsl.g:2715:1: ( ( rule__CompoundTask__CanDoTaskAssignment_4_1_1 ) )
            // InternalMyDsl.g:2716:2: ( rule__CompoundTask__CanDoTaskAssignment_4_1_1 )
            {
             before(grammarAccess.getCompoundTaskAccess().getCanDoTaskAssignment_4_1_1()); 
            // InternalMyDsl.g:2717:2: ( rule__CompoundTask__CanDoTaskAssignment_4_1_1 )
            // InternalMyDsl.g:2717:3: rule__CompoundTask__CanDoTaskAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__CanDoTaskAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getCompoundTaskAccess().getCanDoTaskAssignment_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group_4_1__1__Impl"


    // $ANTLR start "rule__CompoundTask__Group_6_0__0"
    // InternalMyDsl.g:2726:1: rule__CompoundTask__Group_6_0__0 : rule__CompoundTask__Group_6_0__0__Impl rule__CompoundTask__Group_6_0__1 ;
    public final void rule__CompoundTask__Group_6_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2730:1: ( rule__CompoundTask__Group_6_0__0__Impl rule__CompoundTask__Group_6_0__1 )
            // InternalMyDsl.g:2731:2: rule__CompoundTask__Group_6_0__0__Impl rule__CompoundTask__Group_6_0__1
            {
            pushFollow(FOLLOW_32);
            rule__CompoundTask__Group_6_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group_6_0__1();

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
    // $ANTLR end "rule__CompoundTask__Group_6_0__0"


    // $ANTLR start "rule__CompoundTask__Group_6_0__0__Impl"
    // InternalMyDsl.g:2738:1: rule__CompoundTask__Group_6_0__0__Impl : ( 'constraint:' ) ;
    public final void rule__CompoundTask__Group_6_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2742:1: ( ( 'constraint:' ) )
            // InternalMyDsl.g:2743:1: ( 'constraint:' )
            {
            // InternalMyDsl.g:2743:1: ( 'constraint:' )
            // InternalMyDsl.g:2744:2: 'constraint:'
            {
             before(grammarAccess.getCompoundTaskAccess().getConstraintKeyword_6_0_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getCompoundTaskAccess().getConstraintKeyword_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group_6_0__0__Impl"


    // $ANTLR start "rule__CompoundTask__Group_6_0__1"
    // InternalMyDsl.g:2753:1: rule__CompoundTask__Group_6_0__1 : rule__CompoundTask__Group_6_0__1__Impl ;
    public final void rule__CompoundTask__Group_6_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2757:1: ( rule__CompoundTask__Group_6_0__1__Impl )
            // InternalMyDsl.g:2758:2: rule__CompoundTask__Group_6_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group_6_0__1__Impl();

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
    // $ANTLR end "rule__CompoundTask__Group_6_0__1"


    // $ANTLR start "rule__CompoundTask__Group_6_0__1__Impl"
    // InternalMyDsl.g:2764:1: rule__CompoundTask__Group_6_0__1__Impl : ( ( rule__CompoundTask__OrderedAssignment_6_0_1 ) ) ;
    public final void rule__CompoundTask__Group_6_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2768:1: ( ( ( rule__CompoundTask__OrderedAssignment_6_0_1 ) ) )
            // InternalMyDsl.g:2769:1: ( ( rule__CompoundTask__OrderedAssignment_6_0_1 ) )
            {
            // InternalMyDsl.g:2769:1: ( ( rule__CompoundTask__OrderedAssignment_6_0_1 ) )
            // InternalMyDsl.g:2770:2: ( rule__CompoundTask__OrderedAssignment_6_0_1 )
            {
             before(grammarAccess.getCompoundTaskAccess().getOrderedAssignment_6_0_1()); 
            // InternalMyDsl.g:2771:2: ( rule__CompoundTask__OrderedAssignment_6_0_1 )
            // InternalMyDsl.g:2771:3: rule__CompoundTask__OrderedAssignment_6_0_1
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__OrderedAssignment_6_0_1();

            state._fsp--;


            }

             after(grammarAccess.getCompoundTaskAccess().getOrderedAssignment_6_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group_6_0__1__Impl"


    // $ANTLR start "rule__CompoundTask__Group_6_1__0"
    // InternalMyDsl.g:2780:1: rule__CompoundTask__Group_6_1__0 : rule__CompoundTask__Group_6_1__0__Impl rule__CompoundTask__Group_6_1__1 ;
    public final void rule__CompoundTask__Group_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2784:1: ( rule__CompoundTask__Group_6_1__0__Impl rule__CompoundTask__Group_6_1__1 )
            // InternalMyDsl.g:2785:2: rule__CompoundTask__Group_6_1__0__Impl rule__CompoundTask__Group_6_1__1
            {
            pushFollow(FOLLOW_33);
            rule__CompoundTask__Group_6_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group_6_1__1();

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
    // $ANTLR end "rule__CompoundTask__Group_6_1__0"


    // $ANTLR start "rule__CompoundTask__Group_6_1__0__Impl"
    // InternalMyDsl.g:2792:1: rule__CompoundTask__Group_6_1__0__Impl : ( 'constraint:' ) ;
    public final void rule__CompoundTask__Group_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2796:1: ( ( 'constraint:' ) )
            // InternalMyDsl.g:2797:1: ( 'constraint:' )
            {
            // InternalMyDsl.g:2797:1: ( 'constraint:' )
            // InternalMyDsl.g:2798:2: 'constraint:'
            {
             before(grammarAccess.getCompoundTaskAccess().getConstraintKeyword_6_1_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getCompoundTaskAccess().getConstraintKeyword_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group_6_1__0__Impl"


    // $ANTLR start "rule__CompoundTask__Group_6_1__1"
    // InternalMyDsl.g:2807:1: rule__CompoundTask__Group_6_1__1 : rule__CompoundTask__Group_6_1__1__Impl ;
    public final void rule__CompoundTask__Group_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2811:1: ( rule__CompoundTask__Group_6_1__1__Impl )
            // InternalMyDsl.g:2812:2: rule__CompoundTask__Group_6_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__Group_6_1__1__Impl();

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
    // $ANTLR end "rule__CompoundTask__Group_6_1__1"


    // $ANTLR start "rule__CompoundTask__Group_6_1__1__Impl"
    // InternalMyDsl.g:2818:1: rule__CompoundTask__Group_6_1__1__Impl : ( ( rule__CompoundTask__ConsecutiveAssignment_6_1_1 ) ) ;
    public final void rule__CompoundTask__Group_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2822:1: ( ( ( rule__CompoundTask__ConsecutiveAssignment_6_1_1 ) ) )
            // InternalMyDsl.g:2823:1: ( ( rule__CompoundTask__ConsecutiveAssignment_6_1_1 ) )
            {
            // InternalMyDsl.g:2823:1: ( ( rule__CompoundTask__ConsecutiveAssignment_6_1_1 ) )
            // InternalMyDsl.g:2824:2: ( rule__CompoundTask__ConsecutiveAssignment_6_1_1 )
            {
             before(grammarAccess.getCompoundTaskAccess().getConsecutiveAssignment_6_1_1()); 
            // InternalMyDsl.g:2825:2: ( rule__CompoundTask__ConsecutiveAssignment_6_1_1 )
            // InternalMyDsl.g:2825:3: rule__CompoundTask__ConsecutiveAssignment_6_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CompoundTask__ConsecutiveAssignment_6_1_1();

            state._fsp--;


            }

             after(grammarAccess.getCompoundTaskAccess().getConsecutiveAssignment_6_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__Group_6_1__1__Impl"


    // $ANTLR start "rule__Robot__Group__0"
    // InternalMyDsl.g:2834:1: rule__Robot__Group__0 : rule__Robot__Group__0__Impl rule__Robot__Group__1 ;
    public final void rule__Robot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2838:1: ( rule__Robot__Group__0__Impl rule__Robot__Group__1 )
            // InternalMyDsl.g:2839:2: rule__Robot__Group__0__Impl rule__Robot__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Robot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__1();

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
    // $ANTLR end "rule__Robot__Group__0"


    // $ANTLR start "rule__Robot__Group__0__Impl"
    // InternalMyDsl.g:2846:1: rule__Robot__Group__0__Impl : ( ( rule__Robot__NameAssignment_0 ) ) ;
    public final void rule__Robot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2850:1: ( ( ( rule__Robot__NameAssignment_0 ) ) )
            // InternalMyDsl.g:2851:1: ( ( rule__Robot__NameAssignment_0 ) )
            {
            // InternalMyDsl.g:2851:1: ( ( rule__Robot__NameAssignment_0 ) )
            // InternalMyDsl.g:2852:2: ( rule__Robot__NameAssignment_0 )
            {
             before(grammarAccess.getRobotAccess().getNameAssignment_0()); 
            // InternalMyDsl.g:2853:2: ( rule__Robot__NameAssignment_0 )
            // InternalMyDsl.g:2853:3: rule__Robot__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Robot__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRobotAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__0__Impl"


    // $ANTLR start "rule__Robot__Group__1"
    // InternalMyDsl.g:2861:1: rule__Robot__Group__1 : rule__Robot__Group__1__Impl rule__Robot__Group__2 ;
    public final void rule__Robot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2865:1: ( rule__Robot__Group__1__Impl rule__Robot__Group__2 )
            // InternalMyDsl.g:2866:2: rule__Robot__Group__1__Impl rule__Robot__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Robot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__2();

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
    // $ANTLR end "rule__Robot__Group__1"


    // $ANTLR start "rule__Robot__Group__1__Impl"
    // InternalMyDsl.g:2873:1: rule__Robot__Group__1__Impl : ( ':' ) ;
    public final void rule__Robot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2877:1: ( ( ':' ) )
            // InternalMyDsl.g:2878:1: ( ':' )
            {
            // InternalMyDsl.g:2878:1: ( ':' )
            // InternalMyDsl.g:2879:2: ':'
            {
             before(grammarAccess.getRobotAccess().getColonKeyword_1()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__1__Impl"


    // $ANTLR start "rule__Robot__Group__2"
    // InternalMyDsl.g:2888:1: rule__Robot__Group__2 : rule__Robot__Group__2__Impl rule__Robot__Group__3 ;
    public final void rule__Robot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2892:1: ( rule__Robot__Group__2__Impl rule__Robot__Group__3 )
            // InternalMyDsl.g:2893:2: rule__Robot__Group__2__Impl rule__Robot__Group__3
            {
            pushFollow(FOLLOW_34);
            rule__Robot__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__3();

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
    // $ANTLR end "rule__Robot__Group__2"


    // $ANTLR start "rule__Robot__Group__2__Impl"
    // InternalMyDsl.g:2900:1: rule__Robot__Group__2__Impl : ( 'at' ) ;
    public final void rule__Robot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2904:1: ( ( 'at' ) )
            // InternalMyDsl.g:2905:1: ( 'at' )
            {
            // InternalMyDsl.g:2905:1: ( 'at' )
            // InternalMyDsl.g:2906:2: 'at'
            {
             before(grammarAccess.getRobotAccess().getAtKeyword_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getAtKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__2__Impl"


    // $ANTLR start "rule__Robot__Group__3"
    // InternalMyDsl.g:2915:1: rule__Robot__Group__3 : rule__Robot__Group__3__Impl rule__Robot__Group__4 ;
    public final void rule__Robot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2919:1: ( rule__Robot__Group__3__Impl rule__Robot__Group__4 )
            // InternalMyDsl.g:2920:2: rule__Robot__Group__3__Impl rule__Robot__Group__4
            {
            pushFollow(FOLLOW_35);
            rule__Robot__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__4();

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
    // $ANTLR end "rule__Robot__Group__3"


    // $ANTLR start "rule__Robot__Group__3__Impl"
    // InternalMyDsl.g:2927:1: rule__Robot__Group__3__Impl : ( 'initial' ) ;
    public final void rule__Robot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2931:1: ( ( 'initial' ) )
            // InternalMyDsl.g:2932:1: ( 'initial' )
            {
            // InternalMyDsl.g:2932:1: ( 'initial' )
            // InternalMyDsl.g:2933:2: 'initial'
            {
             before(grammarAccess.getRobotAccess().getInitialKeyword_3()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getInitialKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__3__Impl"


    // $ANTLR start "rule__Robot__Group__4"
    // InternalMyDsl.g:2942:1: rule__Robot__Group__4 : rule__Robot__Group__4__Impl rule__Robot__Group__5 ;
    public final void rule__Robot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2946:1: ( rule__Robot__Group__4__Impl rule__Robot__Group__5 )
            // InternalMyDsl.g:2947:2: rule__Robot__Group__4__Impl rule__Robot__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Robot__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__5();

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
    // $ANTLR end "rule__Robot__Group__4"


    // $ANTLR start "rule__Robot__Group__4__Impl"
    // InternalMyDsl.g:2954:1: rule__Robot__Group__4__Impl : ( 'position' ) ;
    public final void rule__Robot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2958:1: ( ( 'position' ) )
            // InternalMyDsl.g:2959:1: ( 'position' )
            {
            // InternalMyDsl.g:2959:1: ( 'position' )
            // InternalMyDsl.g:2960:2: 'position'
            {
             before(grammarAccess.getRobotAccess().getPositionKeyword_4()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getPositionKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__4__Impl"


    // $ANTLR start "rule__Robot__Group__5"
    // InternalMyDsl.g:2969:1: rule__Robot__Group__5 : rule__Robot__Group__5__Impl rule__Robot__Group__6 ;
    public final void rule__Robot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2973:1: ( rule__Robot__Group__5__Impl rule__Robot__Group__6 )
            // InternalMyDsl.g:2974:2: rule__Robot__Group__5__Impl rule__Robot__Group__6
            {
            pushFollow(FOLLOW_36);
            rule__Robot__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__6();

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
    // $ANTLR end "rule__Robot__Group__5"


    // $ANTLR start "rule__Robot__Group__5__Impl"
    // InternalMyDsl.g:2981:1: rule__Robot__Group__5__Impl : ( ( rule__Robot__InitLocAssignment_5 ) ) ;
    public final void rule__Robot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2985:1: ( ( ( rule__Robot__InitLocAssignment_5 ) ) )
            // InternalMyDsl.g:2986:1: ( ( rule__Robot__InitLocAssignment_5 ) )
            {
            // InternalMyDsl.g:2986:1: ( ( rule__Robot__InitLocAssignment_5 ) )
            // InternalMyDsl.g:2987:2: ( rule__Robot__InitLocAssignment_5 )
            {
             before(grammarAccess.getRobotAccess().getInitLocAssignment_5()); 
            // InternalMyDsl.g:2988:2: ( rule__Robot__InitLocAssignment_5 )
            // InternalMyDsl.g:2988:3: rule__Robot__InitLocAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Robot__InitLocAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getRobotAccess().getInitLocAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__5__Impl"


    // $ANTLR start "rule__Robot__Group__6"
    // InternalMyDsl.g:2996:1: rule__Robot__Group__6 : rule__Robot__Group__6__Impl rule__Robot__Group__7 ;
    public final void rule__Robot__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3000:1: ( rule__Robot__Group__6__Impl rule__Robot__Group__7 )
            // InternalMyDsl.g:3001:2: rule__Robot__Group__6__Impl rule__Robot__Group__7
            {
            pushFollow(FOLLOW_37);
            rule__Robot__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__7();

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
    // $ANTLR end "rule__Robot__Group__6"


    // $ANTLR start "rule__Robot__Group__6__Impl"
    // InternalMyDsl.g:3008:1: rule__Robot__Group__6__Impl : ( 'has' ) ;
    public final void rule__Robot__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3012:1: ( ( 'has' ) )
            // InternalMyDsl.g:3013:1: ( 'has' )
            {
            // InternalMyDsl.g:3013:1: ( 'has' )
            // InternalMyDsl.g:3014:2: 'has'
            {
             before(grammarAccess.getRobotAccess().getHasKeyword_6()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getHasKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__6__Impl"


    // $ANTLR start "rule__Robot__Group__7"
    // InternalMyDsl.g:3023:1: rule__Robot__Group__7 : rule__Robot__Group__7__Impl rule__Robot__Group__8 ;
    public final void rule__Robot__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3027:1: ( rule__Robot__Group__7__Impl rule__Robot__Group__8 )
            // InternalMyDsl.g:3028:2: rule__Robot__Group__7__Impl rule__Robot__Group__8
            {
            pushFollow(FOLLOW_16);
            rule__Robot__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__8();

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
    // $ANTLR end "rule__Robot__Group__7"


    // $ANTLR start "rule__Robot__Group__7__Impl"
    // InternalMyDsl.g:3035:1: rule__Robot__Group__7__Impl : ( 'velocity' ) ;
    public final void rule__Robot__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3039:1: ( ( 'velocity' ) )
            // InternalMyDsl.g:3040:1: ( 'velocity' )
            {
            // InternalMyDsl.g:3040:1: ( 'velocity' )
            // InternalMyDsl.g:3041:2: 'velocity'
            {
             before(grammarAccess.getRobotAccess().getVelocityKeyword_7()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getVelocityKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__7__Impl"


    // $ANTLR start "rule__Robot__Group__8"
    // InternalMyDsl.g:3050:1: rule__Robot__Group__8 : rule__Robot__Group__8__Impl rule__Robot__Group__9 ;
    public final void rule__Robot__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3054:1: ( rule__Robot__Group__8__Impl rule__Robot__Group__9 )
            // InternalMyDsl.g:3055:2: rule__Robot__Group__8__Impl rule__Robot__Group__9
            {
            pushFollow(FOLLOW_38);
            rule__Robot__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__9();

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
    // $ANTLR end "rule__Robot__Group__8"


    // $ANTLR start "rule__Robot__Group__8__Impl"
    // InternalMyDsl.g:3062:1: rule__Robot__Group__8__Impl : ( ( rule__Robot__VelocityAssignment_8 ) ) ;
    public final void rule__Robot__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3066:1: ( ( ( rule__Robot__VelocityAssignment_8 ) ) )
            // InternalMyDsl.g:3067:1: ( ( rule__Robot__VelocityAssignment_8 ) )
            {
            // InternalMyDsl.g:3067:1: ( ( rule__Robot__VelocityAssignment_8 ) )
            // InternalMyDsl.g:3068:2: ( rule__Robot__VelocityAssignment_8 )
            {
             before(grammarAccess.getRobotAccess().getVelocityAssignment_8()); 
            // InternalMyDsl.g:3069:2: ( rule__Robot__VelocityAssignment_8 )
            // InternalMyDsl.g:3069:3: rule__Robot__VelocityAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Robot__VelocityAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getRobotAccess().getVelocityAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__8__Impl"


    // $ANTLR start "rule__Robot__Group__9"
    // InternalMyDsl.g:3077:1: rule__Robot__Group__9 : rule__Robot__Group__9__Impl rule__Robot__Group__10 ;
    public final void rule__Robot__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3081:1: ( rule__Robot__Group__9__Impl rule__Robot__Group__10 )
            // InternalMyDsl.g:3082:2: rule__Robot__Group__9__Impl rule__Robot__Group__10
            {
            pushFollow(FOLLOW_39);
            rule__Robot__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__10();

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
    // $ANTLR end "rule__Robot__Group__9"


    // $ANTLR start "rule__Robot__Group__9__Impl"
    // InternalMyDsl.g:3089:1: rule__Robot__Group__9__Impl : ( 'with' ) ;
    public final void rule__Robot__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3093:1: ( ( 'with' ) )
            // InternalMyDsl.g:3094:1: ( 'with' )
            {
            // InternalMyDsl.g:3094:1: ( 'with' )
            // InternalMyDsl.g:3095:2: 'with'
            {
             before(grammarAccess.getRobotAccess().getWithKeyword_9()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getWithKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__9__Impl"


    // $ANTLR start "rule__Robot__Group__10"
    // InternalMyDsl.g:3104:1: rule__Robot__Group__10 : rule__Robot__Group__10__Impl rule__Robot__Group__11 ;
    public final void rule__Robot__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3108:1: ( rule__Robot__Group__10__Impl rule__Robot__Group__11 )
            // InternalMyDsl.g:3109:2: rule__Robot__Group__10__Impl rule__Robot__Group__11
            {
            pushFollow(FOLLOW_14);
            rule__Robot__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__11();

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
    // $ANTLR end "rule__Robot__Group__10"


    // $ANTLR start "rule__Robot__Group__10__Impl"
    // InternalMyDsl.g:3116:1: rule__Robot__Group__10__Impl : ( 'capabilities' ) ;
    public final void rule__Robot__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3120:1: ( ( 'capabilities' ) )
            // InternalMyDsl.g:3121:1: ( 'capabilities' )
            {
            // InternalMyDsl.g:3121:1: ( 'capabilities' )
            // InternalMyDsl.g:3122:2: 'capabilities'
            {
             before(grammarAccess.getRobotAccess().getCapabilitiesKeyword_10()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getCapabilitiesKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__10__Impl"


    // $ANTLR start "rule__Robot__Group__11"
    // InternalMyDsl.g:3131:1: rule__Robot__Group__11 : rule__Robot__Group__11__Impl rule__Robot__Group__12 ;
    public final void rule__Robot__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3135:1: ( rule__Robot__Group__11__Impl rule__Robot__Group__12 )
            // InternalMyDsl.g:3136:2: rule__Robot__Group__11__Impl rule__Robot__Group__12
            {
            pushFollow(FOLLOW_9);
            rule__Robot__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__12();

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
    // $ANTLR end "rule__Robot__Group__11"


    // $ANTLR start "rule__Robot__Group__11__Impl"
    // InternalMyDsl.g:3143:1: rule__Robot__Group__11__Impl : ( '(' ) ;
    public final void rule__Robot__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3147:1: ( ( '(' ) )
            // InternalMyDsl.g:3148:1: ( '(' )
            {
            // InternalMyDsl.g:3148:1: ( '(' )
            // InternalMyDsl.g:3149:2: '('
            {
             before(grammarAccess.getRobotAccess().getLeftParenthesisKeyword_11()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getLeftParenthesisKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__11__Impl"


    // $ANTLR start "rule__Robot__Group__12"
    // InternalMyDsl.g:3158:1: rule__Robot__Group__12 : rule__Robot__Group__12__Impl rule__Robot__Group__13 ;
    public final void rule__Robot__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3162:1: ( rule__Robot__Group__12__Impl rule__Robot__Group__13 )
            // InternalMyDsl.g:3163:2: rule__Robot__Group__12__Impl rule__Robot__Group__13
            {
            pushFollow(FOLLOW_18);
            rule__Robot__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__13();

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
    // $ANTLR end "rule__Robot__Group__12"


    // $ANTLR start "rule__Robot__Group__12__Impl"
    // InternalMyDsl.g:3170:1: rule__Robot__Group__12__Impl : ( ( rule__Robot__CapabilitiesAssignment_12 ) ) ;
    public final void rule__Robot__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3174:1: ( ( ( rule__Robot__CapabilitiesAssignment_12 ) ) )
            // InternalMyDsl.g:3175:1: ( ( rule__Robot__CapabilitiesAssignment_12 ) )
            {
            // InternalMyDsl.g:3175:1: ( ( rule__Robot__CapabilitiesAssignment_12 ) )
            // InternalMyDsl.g:3176:2: ( rule__Robot__CapabilitiesAssignment_12 )
            {
             before(grammarAccess.getRobotAccess().getCapabilitiesAssignment_12()); 
            // InternalMyDsl.g:3177:2: ( rule__Robot__CapabilitiesAssignment_12 )
            // InternalMyDsl.g:3177:3: rule__Robot__CapabilitiesAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Robot__CapabilitiesAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getRobotAccess().getCapabilitiesAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__12__Impl"


    // $ANTLR start "rule__Robot__Group__13"
    // InternalMyDsl.g:3185:1: rule__Robot__Group__13 : rule__Robot__Group__13__Impl rule__Robot__Group__14 ;
    public final void rule__Robot__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3189:1: ( rule__Robot__Group__13__Impl rule__Robot__Group__14 )
            // InternalMyDsl.g:3190:2: rule__Robot__Group__13__Impl rule__Robot__Group__14
            {
            pushFollow(FOLLOW_18);
            rule__Robot__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group__14();

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
    // $ANTLR end "rule__Robot__Group__13"


    // $ANTLR start "rule__Robot__Group__13__Impl"
    // InternalMyDsl.g:3197:1: rule__Robot__Group__13__Impl : ( ( rule__Robot__Group_13__0 )* ) ;
    public final void rule__Robot__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3201:1: ( ( ( rule__Robot__Group_13__0 )* ) )
            // InternalMyDsl.g:3202:1: ( ( rule__Robot__Group_13__0 )* )
            {
            // InternalMyDsl.g:3202:1: ( ( rule__Robot__Group_13__0 )* )
            // InternalMyDsl.g:3203:2: ( rule__Robot__Group_13__0 )*
            {
             before(grammarAccess.getRobotAccess().getGroup_13()); 
            // InternalMyDsl.g:3204:2: ( rule__Robot__Group_13__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==32) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalMyDsl.g:3204:3: rule__Robot__Group_13__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Robot__Group_13__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getRobotAccess().getGroup_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__13__Impl"


    // $ANTLR start "rule__Robot__Group__14"
    // InternalMyDsl.g:3212:1: rule__Robot__Group__14 : rule__Robot__Group__14__Impl ;
    public final void rule__Robot__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3216:1: ( rule__Robot__Group__14__Impl )
            // InternalMyDsl.g:3217:2: rule__Robot__Group__14__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Robot__Group__14__Impl();

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
    // $ANTLR end "rule__Robot__Group__14"


    // $ANTLR start "rule__Robot__Group__14__Impl"
    // InternalMyDsl.g:3223:1: rule__Robot__Group__14__Impl : ( ')' ) ;
    public final void rule__Robot__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3227:1: ( ( ')' ) )
            // InternalMyDsl.g:3228:1: ( ')' )
            {
            // InternalMyDsl.g:3228:1: ( ')' )
            // InternalMyDsl.g:3229:2: ')'
            {
             before(grammarAccess.getRobotAccess().getRightParenthesisKeyword_14()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getRightParenthesisKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group__14__Impl"


    // $ANTLR start "rule__Robot__Group_13__0"
    // InternalMyDsl.g:3239:1: rule__Robot__Group_13__0 : rule__Robot__Group_13__0__Impl rule__Robot__Group_13__1 ;
    public final void rule__Robot__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3243:1: ( rule__Robot__Group_13__0__Impl rule__Robot__Group_13__1 )
            // InternalMyDsl.g:3244:2: rule__Robot__Group_13__0__Impl rule__Robot__Group_13__1
            {
            pushFollow(FOLLOW_9);
            rule__Robot__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Robot__Group_13__1();

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
    // $ANTLR end "rule__Robot__Group_13__0"


    // $ANTLR start "rule__Robot__Group_13__0__Impl"
    // InternalMyDsl.g:3251:1: rule__Robot__Group_13__0__Impl : ( ',' ) ;
    public final void rule__Robot__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3255:1: ( ( ',' ) )
            // InternalMyDsl.g:3256:1: ( ',' )
            {
            // InternalMyDsl.g:3256:1: ( ',' )
            // InternalMyDsl.g:3257:2: ','
            {
             before(grammarAccess.getRobotAccess().getCommaKeyword_13_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getRobotAccess().getCommaKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group_13__0__Impl"


    // $ANTLR start "rule__Robot__Group_13__1"
    // InternalMyDsl.g:3266:1: rule__Robot__Group_13__1 : rule__Robot__Group_13__1__Impl ;
    public final void rule__Robot__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3270:1: ( rule__Robot__Group_13__1__Impl )
            // InternalMyDsl.g:3271:2: rule__Robot__Group_13__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Robot__Group_13__1__Impl();

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
    // $ANTLR end "rule__Robot__Group_13__1"


    // $ANTLR start "rule__Robot__Group_13__1__Impl"
    // InternalMyDsl.g:3277:1: rule__Robot__Group_13__1__Impl : ( ( rule__Robot__CapabilitiesAssignment_13_1 ) ) ;
    public final void rule__Robot__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3281:1: ( ( ( rule__Robot__CapabilitiesAssignment_13_1 ) ) )
            // InternalMyDsl.g:3282:1: ( ( rule__Robot__CapabilitiesAssignment_13_1 ) )
            {
            // InternalMyDsl.g:3282:1: ( ( rule__Robot__CapabilitiesAssignment_13_1 ) )
            // InternalMyDsl.g:3283:2: ( rule__Robot__CapabilitiesAssignment_13_1 )
            {
             before(grammarAccess.getRobotAccess().getCapabilitiesAssignment_13_1()); 
            // InternalMyDsl.g:3284:2: ( rule__Robot__CapabilitiesAssignment_13_1 )
            // InternalMyDsl.g:3284:3: rule__Robot__CapabilitiesAssignment_13_1
            {
            pushFollow(FOLLOW_2);
            rule__Robot__CapabilitiesAssignment_13_1();

            state._fsp--;


            }

             after(grammarAccess.getRobotAccess().getCapabilitiesAssignment_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__Group_13__1__Impl"


    // $ANTLR start "rule__Capability__Group__0"
    // InternalMyDsl.g:3293:1: rule__Capability__Group__0 : rule__Capability__Group__0__Impl rule__Capability__Group__1 ;
    public final void rule__Capability__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3297:1: ( rule__Capability__Group__0__Impl rule__Capability__Group__1 )
            // InternalMyDsl.g:3298:2: rule__Capability__Group__0__Impl rule__Capability__Group__1
            {
            pushFollow(FOLLOW_40);
            rule__Capability__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capability__Group__1();

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
    // $ANTLR end "rule__Capability__Group__0"


    // $ANTLR start "rule__Capability__Group__0__Impl"
    // InternalMyDsl.g:3305:1: rule__Capability__Group__0__Impl : ( ( rule__Capability__AtAssignment_0 ) ) ;
    public final void rule__Capability__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3309:1: ( ( ( rule__Capability__AtAssignment_0 ) ) )
            // InternalMyDsl.g:3310:1: ( ( rule__Capability__AtAssignment_0 ) )
            {
            // InternalMyDsl.g:3310:1: ( ( rule__Capability__AtAssignment_0 ) )
            // InternalMyDsl.g:3311:2: ( rule__Capability__AtAssignment_0 )
            {
             before(grammarAccess.getCapabilityAccess().getAtAssignment_0()); 
            // InternalMyDsl.g:3312:2: ( rule__Capability__AtAssignment_0 )
            // InternalMyDsl.g:3312:3: rule__Capability__AtAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Capability__AtAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCapabilityAccess().getAtAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__Group__0__Impl"


    // $ANTLR start "rule__Capability__Group__1"
    // InternalMyDsl.g:3320:1: rule__Capability__Group__1 : rule__Capability__Group__1__Impl rule__Capability__Group__2 ;
    public final void rule__Capability__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3324:1: ( rule__Capability__Group__1__Impl rule__Capability__Group__2 )
            // InternalMyDsl.g:3325:2: rule__Capability__Group__1__Impl rule__Capability__Group__2
            {
            pushFollow(FOLLOW_41);
            rule__Capability__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capability__Group__2();

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
    // $ANTLR end "rule__Capability__Group__1"


    // $ANTLR start "rule__Capability__Group__1__Impl"
    // InternalMyDsl.g:3332:1: rule__Capability__Group__1__Impl : ( '-required' ) ;
    public final void rule__Capability__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3336:1: ( ( '-required' ) )
            // InternalMyDsl.g:3337:1: ( '-required' )
            {
            // InternalMyDsl.g:3337:1: ( '-required' )
            // InternalMyDsl.g:3338:2: '-required'
            {
             before(grammarAccess.getCapabilityAccess().getRequiredKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getCapabilityAccess().getRequiredKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__Group__1__Impl"


    // $ANTLR start "rule__Capability__Group__2"
    // InternalMyDsl.g:3347:1: rule__Capability__Group__2 : rule__Capability__Group__2__Impl rule__Capability__Group__3 ;
    public final void rule__Capability__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3351:1: ( rule__Capability__Group__2__Impl rule__Capability__Group__3 )
            // InternalMyDsl.g:3352:2: rule__Capability__Group__2__Impl rule__Capability__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__Capability__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capability__Group__3();

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
    // $ANTLR end "rule__Capability__Group__2"


    // $ANTLR start "rule__Capability__Group__2__Impl"
    // InternalMyDsl.g:3359:1: rule__Capability__Group__2__Impl : ( 'time:' ) ;
    public final void rule__Capability__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3363:1: ( ( 'time:' ) )
            // InternalMyDsl.g:3364:1: ( 'time:' )
            {
            // InternalMyDsl.g:3364:1: ( 'time:' )
            // InternalMyDsl.g:3365:2: 'time:'
            {
             before(grammarAccess.getCapabilityAccess().getTimeKeyword_2()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getCapabilityAccess().getTimeKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__Group__2__Impl"


    // $ANTLR start "rule__Capability__Group__3"
    // InternalMyDsl.g:3374:1: rule__Capability__Group__3 : rule__Capability__Group__3__Impl rule__Capability__Group__4 ;
    public final void rule__Capability__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3378:1: ( rule__Capability__Group__3__Impl rule__Capability__Group__4 )
            // InternalMyDsl.g:3379:2: rule__Capability__Group__3__Impl rule__Capability__Group__4
            {
            pushFollow(FOLLOW_31);
            rule__Capability__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capability__Group__4();

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
    // $ANTLR end "rule__Capability__Group__3"


    // $ANTLR start "rule__Capability__Group__3__Impl"
    // InternalMyDsl.g:3386:1: rule__Capability__Group__3__Impl : ( ( rule__Capability__TimeAssignment_3 ) ) ;
    public final void rule__Capability__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3390:1: ( ( ( rule__Capability__TimeAssignment_3 ) ) )
            // InternalMyDsl.g:3391:1: ( ( rule__Capability__TimeAssignment_3 ) )
            {
            // InternalMyDsl.g:3391:1: ( ( rule__Capability__TimeAssignment_3 ) )
            // InternalMyDsl.g:3392:2: ( rule__Capability__TimeAssignment_3 )
            {
             before(grammarAccess.getCapabilityAccess().getTimeAssignment_3()); 
            // InternalMyDsl.g:3393:2: ( rule__Capability__TimeAssignment_3 )
            // InternalMyDsl.g:3393:3: rule__Capability__TimeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Capability__TimeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCapabilityAccess().getTimeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__Group__3__Impl"


    // $ANTLR start "rule__Capability__Group__4"
    // InternalMyDsl.g:3401:1: rule__Capability__Group__4 : rule__Capability__Group__4__Impl rule__Capability__Group__5 ;
    public final void rule__Capability__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3405:1: ( rule__Capability__Group__4__Impl rule__Capability__Group__5 )
            // InternalMyDsl.g:3406:2: rule__Capability__Group__4__Impl rule__Capability__Group__5
            {
            pushFollow(FOLLOW_42);
            rule__Capability__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capability__Group__5();

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
    // $ANTLR end "rule__Capability__Group__4"


    // $ANTLR start "rule__Capability__Group__4__Impl"
    // InternalMyDsl.g:3413:1: rule__Capability__Group__4__Impl : ( ',' ) ;
    public final void rule__Capability__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3417:1: ( ( ',' ) )
            // InternalMyDsl.g:3418:1: ( ',' )
            {
            // InternalMyDsl.g:3418:1: ( ',' )
            // InternalMyDsl.g:3419:2: ','
            {
             before(grammarAccess.getCapabilityAccess().getCommaKeyword_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getCapabilityAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__Group__4__Impl"


    // $ANTLR start "rule__Capability__Group__5"
    // InternalMyDsl.g:3428:1: rule__Capability__Group__5 : rule__Capability__Group__5__Impl rule__Capability__Group__6 ;
    public final void rule__Capability__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3432:1: ( rule__Capability__Group__5__Impl rule__Capability__Group__6 )
            // InternalMyDsl.g:3433:2: rule__Capability__Group__5__Impl rule__Capability__Group__6
            {
            pushFollow(FOLLOW_43);
            rule__Capability__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capability__Group__6();

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
    // $ANTLR end "rule__Capability__Group__5"


    // $ANTLR start "rule__Capability__Group__5__Impl"
    // InternalMyDsl.g:3440:1: rule__Capability__Group__5__Impl : ( 'success' ) ;
    public final void rule__Capability__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3444:1: ( ( 'success' ) )
            // InternalMyDsl.g:3445:1: ( 'success' )
            {
            // InternalMyDsl.g:3445:1: ( 'success' )
            // InternalMyDsl.g:3446:2: 'success'
            {
             before(grammarAccess.getCapabilityAccess().getSuccessKeyword_5()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getCapabilityAccess().getSuccessKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__Group__5__Impl"


    // $ANTLR start "rule__Capability__Group__6"
    // InternalMyDsl.g:3455:1: rule__Capability__Group__6 : rule__Capability__Group__6__Impl rule__Capability__Group__7 ;
    public final void rule__Capability__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3459:1: ( rule__Capability__Group__6__Impl rule__Capability__Group__7 )
            // InternalMyDsl.g:3460:2: rule__Capability__Group__6__Impl rule__Capability__Group__7
            {
            pushFollow(FOLLOW_16);
            rule__Capability__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capability__Group__7();

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
    // $ANTLR end "rule__Capability__Group__6"


    // $ANTLR start "rule__Capability__Group__6__Impl"
    // InternalMyDsl.g:3467:1: rule__Capability__Group__6__Impl : ( 'rate:' ) ;
    public final void rule__Capability__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3471:1: ( ( 'rate:' ) )
            // InternalMyDsl.g:3472:1: ( 'rate:' )
            {
            // InternalMyDsl.g:3472:1: ( 'rate:' )
            // InternalMyDsl.g:3473:2: 'rate:'
            {
             before(grammarAccess.getCapabilityAccess().getRateKeyword_6()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getCapabilityAccess().getRateKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__Group__6__Impl"


    // $ANTLR start "rule__Capability__Group__7"
    // InternalMyDsl.g:3482:1: rule__Capability__Group__7 : rule__Capability__Group__7__Impl rule__Capability__Group__8 ;
    public final void rule__Capability__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3486:1: ( rule__Capability__Group__7__Impl rule__Capability__Group__8 )
            // InternalMyDsl.g:3487:2: rule__Capability__Group__7__Impl rule__Capability__Group__8
            {
            pushFollow(FOLLOW_44);
            rule__Capability__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capability__Group__8();

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
    // $ANTLR end "rule__Capability__Group__7"


    // $ANTLR start "rule__Capability__Group__7__Impl"
    // InternalMyDsl.g:3494:1: rule__Capability__Group__7__Impl : ( ( rule__Capability__SuccessAssignment_7 ) ) ;
    public final void rule__Capability__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3498:1: ( ( ( rule__Capability__SuccessAssignment_7 ) ) )
            // InternalMyDsl.g:3499:1: ( ( rule__Capability__SuccessAssignment_7 ) )
            {
            // InternalMyDsl.g:3499:1: ( ( rule__Capability__SuccessAssignment_7 ) )
            // InternalMyDsl.g:3500:2: ( rule__Capability__SuccessAssignment_7 )
            {
             before(grammarAccess.getCapabilityAccess().getSuccessAssignment_7()); 
            // InternalMyDsl.g:3501:2: ( rule__Capability__SuccessAssignment_7 )
            // InternalMyDsl.g:3501:3: rule__Capability__SuccessAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Capability__SuccessAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getCapabilityAccess().getSuccessAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__Group__7__Impl"


    // $ANTLR start "rule__Capability__Group__8"
    // InternalMyDsl.g:3509:1: rule__Capability__Group__8 : rule__Capability__Group__8__Impl ;
    public final void rule__Capability__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3513:1: ( rule__Capability__Group__8__Impl )
            // InternalMyDsl.g:3514:2: rule__Capability__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Capability__Group__8__Impl();

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
    // $ANTLR end "rule__Capability__Group__8"


    // $ANTLR start "rule__Capability__Group__8__Impl"
    // InternalMyDsl.g:3520:1: rule__Capability__Group__8__Impl : ( '%' ) ;
    public final void rule__Capability__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3524:1: ( ( '%' ) )
            // InternalMyDsl.g:3525:1: ( '%' )
            {
            // InternalMyDsl.g:3525:1: ( '%' )
            // InternalMyDsl.g:3526:2: '%'
            {
             before(grammarAccess.getCapabilityAccess().getPercentSignKeyword_8()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getCapabilityAccess().getPercentSignKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__Group__8__Impl"


    // $ANTLR start "rule__Mission__Group__0"
    // InternalMyDsl.g:3536:1: rule__Mission__Group__0 : rule__Mission__Group__0__Impl rule__Mission__Group__1 ;
    public final void rule__Mission__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3540:1: ( rule__Mission__Group__0__Impl rule__Mission__Group__1 )
            // InternalMyDsl.g:3541:2: rule__Mission__Group__0__Impl rule__Mission__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__Mission__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group__1();

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
    // $ANTLR end "rule__Mission__Group__0"


    // $ANTLR start "rule__Mission__Group__0__Impl"
    // InternalMyDsl.g:3548:1: rule__Mission__Group__0__Impl : ( ( rule__Mission__MissionTaskAssignment_0 ) ) ;
    public final void rule__Mission__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3552:1: ( ( ( rule__Mission__MissionTaskAssignment_0 ) ) )
            // InternalMyDsl.g:3553:1: ( ( rule__Mission__MissionTaskAssignment_0 ) )
            {
            // InternalMyDsl.g:3553:1: ( ( rule__Mission__MissionTaskAssignment_0 ) )
            // InternalMyDsl.g:3554:2: ( rule__Mission__MissionTaskAssignment_0 )
            {
             before(grammarAccess.getMissionAccess().getMissionTaskAssignment_0()); 
            // InternalMyDsl.g:3555:2: ( rule__Mission__MissionTaskAssignment_0 )
            // InternalMyDsl.g:3555:3: rule__Mission__MissionTaskAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Mission__MissionTaskAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getMissionTaskAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group__0__Impl"


    // $ANTLR start "rule__Mission__Group__1"
    // InternalMyDsl.g:3563:1: rule__Mission__Group__1 : rule__Mission__Group__1__Impl rule__Mission__Group__2 ;
    public final void rule__Mission__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3567:1: ( rule__Mission__Group__1__Impl rule__Mission__Group__2 )
            // InternalMyDsl.g:3568:2: rule__Mission__Group__1__Impl rule__Mission__Group__2
            {
            pushFollow(FOLLOW_45);
            rule__Mission__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group__2();

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
    // $ANTLR end "rule__Mission__Group__1"


    // $ANTLR start "rule__Mission__Group__1__Impl"
    // InternalMyDsl.g:3575:1: rule__Mission__Group__1__Impl : ( ( rule__Mission__Group_1__0 )* ) ;
    public final void rule__Mission__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3579:1: ( ( ( rule__Mission__Group_1__0 )* ) )
            // InternalMyDsl.g:3580:1: ( ( rule__Mission__Group_1__0 )* )
            {
            // InternalMyDsl.g:3580:1: ( ( rule__Mission__Group_1__0 )* )
            // InternalMyDsl.g:3581:2: ( rule__Mission__Group_1__0 )*
            {
             before(grammarAccess.getMissionAccess().getGroup_1()); 
            // InternalMyDsl.g:3582:2: ( rule__Mission__Group_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==32) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalMyDsl.g:3582:3: rule__Mission__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Mission__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getMissionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group__1__Impl"


    // $ANTLR start "rule__Mission__Group__2"
    // InternalMyDsl.g:3590:1: rule__Mission__Group__2 : rule__Mission__Group__2__Impl rule__Mission__Group__3 ;
    public final void rule__Mission__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3594:1: ( rule__Mission__Group__2__Impl rule__Mission__Group__3 )
            // InternalMyDsl.g:3595:2: rule__Mission__Group__2__Impl rule__Mission__Group__3
            {
            pushFollow(FOLLOW_46);
            rule__Mission__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group__3();

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
    // $ANTLR end "rule__Mission__Group__2"


    // $ANTLR start "rule__Mission__Group__2__Impl"
    // InternalMyDsl.g:3602:1: rule__Mission__Group__2__Impl : ( 'objectives:' ) ;
    public final void rule__Mission__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3606:1: ( ( 'objectives:' ) )
            // InternalMyDsl.g:3607:1: ( 'objectives:' )
            {
            // InternalMyDsl.g:3607:1: ( 'objectives:' )
            // InternalMyDsl.g:3608:2: 'objectives:'
            {
             before(grammarAccess.getMissionAccess().getObjectivesKeyword_2()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getMissionAccess().getObjectivesKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group__2__Impl"


    // $ANTLR start "rule__Mission__Group__3"
    // InternalMyDsl.g:3617:1: rule__Mission__Group__3 : rule__Mission__Group__3__Impl rule__Mission__Group__4 ;
    public final void rule__Mission__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3621:1: ( rule__Mission__Group__3__Impl rule__Mission__Group__4 )
            // InternalMyDsl.g:3622:2: rule__Mission__Group__3__Impl rule__Mission__Group__4
            {
            pushFollow(FOLLOW_47);
            rule__Mission__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group__4();

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
    // $ANTLR end "rule__Mission__Group__3"


    // $ANTLR start "rule__Mission__Group__3__Impl"
    // InternalMyDsl.g:3629:1: rule__Mission__Group__3__Impl : ( ( rule__Mission__ObjAssignment_3 ) ) ;
    public final void rule__Mission__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3633:1: ( ( ( rule__Mission__ObjAssignment_3 ) ) )
            // InternalMyDsl.g:3634:1: ( ( rule__Mission__ObjAssignment_3 ) )
            {
            // InternalMyDsl.g:3634:1: ( ( rule__Mission__ObjAssignment_3 ) )
            // InternalMyDsl.g:3635:2: ( rule__Mission__ObjAssignment_3 )
            {
             before(grammarAccess.getMissionAccess().getObjAssignment_3()); 
            // InternalMyDsl.g:3636:2: ( rule__Mission__ObjAssignment_3 )
            // InternalMyDsl.g:3636:3: rule__Mission__ObjAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Mission__ObjAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getObjAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group__3__Impl"


    // $ANTLR start "rule__Mission__Group__4"
    // InternalMyDsl.g:3644:1: rule__Mission__Group__4 : rule__Mission__Group__4__Impl rule__Mission__Group__5 ;
    public final void rule__Mission__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3648:1: ( rule__Mission__Group__4__Impl rule__Mission__Group__5 )
            // InternalMyDsl.g:3649:2: rule__Mission__Group__4__Impl rule__Mission__Group__5
            {
            pushFollow(FOLLOW_47);
            rule__Mission__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group__5();

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
    // $ANTLR end "rule__Mission__Group__4"


    // $ANTLR start "rule__Mission__Group__4__Impl"
    // InternalMyDsl.g:3656:1: rule__Mission__Group__4__Impl : ( ( rule__Mission__Group_4__0 )* ) ;
    public final void rule__Mission__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3660:1: ( ( ( rule__Mission__Group_4__0 )* ) )
            // InternalMyDsl.g:3661:1: ( ( rule__Mission__Group_4__0 )* )
            {
            // InternalMyDsl.g:3661:1: ( ( rule__Mission__Group_4__0 )* )
            // InternalMyDsl.g:3662:2: ( rule__Mission__Group_4__0 )*
            {
             before(grammarAccess.getMissionAccess().getGroup_4()); 
            // InternalMyDsl.g:3663:2: ( rule__Mission__Group_4__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==32) ) {
                    int LA28_2 = input.LA(2);

                    if ( ((LA28_2>=15 && LA28_2<=17)) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // InternalMyDsl.g:3663:3: rule__Mission__Group_4__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Mission__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getMissionAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group__4__Impl"


    // $ANTLR start "rule__Mission__Group__5"
    // InternalMyDsl.g:3671:1: rule__Mission__Group__5 : rule__Mission__Group__5__Impl rule__Mission__Group__6 ;
    public final void rule__Mission__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3675:1: ( rule__Mission__Group__5__Impl rule__Mission__Group__6 )
            // InternalMyDsl.g:3676:2: rule__Mission__Group__5__Impl rule__Mission__Group__6
            {
            pushFollow(FOLLOW_47);
            rule__Mission__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group__6();

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
    // $ANTLR end "rule__Mission__Group__5"


    // $ANTLR start "rule__Mission__Group__5__Impl"
    // InternalMyDsl.g:3683:1: rule__Mission__Group__5__Impl : ( ( rule__Mission__Group_5__0 )? ) ;
    public final void rule__Mission__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3687:1: ( ( ( rule__Mission__Group_5__0 )? ) )
            // InternalMyDsl.g:3688:1: ( ( rule__Mission__Group_5__0 )? )
            {
            // InternalMyDsl.g:3688:1: ( ( rule__Mission__Group_5__0 )? )
            // InternalMyDsl.g:3689:2: ( rule__Mission__Group_5__0 )?
            {
             before(grammarAccess.getMissionAccess().getGroup_5()); 
            // InternalMyDsl.g:3690:2: ( rule__Mission__Group_5__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==58) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMyDsl.g:3690:3: rule__Mission__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Mission__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMissionAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group__5__Impl"


    // $ANTLR start "rule__Mission__Group__6"
    // InternalMyDsl.g:3698:1: rule__Mission__Group__6 : rule__Mission__Group__6__Impl ;
    public final void rule__Mission__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3702:1: ( rule__Mission__Group__6__Impl )
            // InternalMyDsl.g:3703:2: rule__Mission__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group__6__Impl();

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
    // $ANTLR end "rule__Mission__Group__6"


    // $ANTLR start "rule__Mission__Group__6__Impl"
    // InternalMyDsl.g:3709:1: rule__Mission__Group__6__Impl : ( ( rule__Mission__Group_6__0 )? ) ;
    public final void rule__Mission__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3713:1: ( ( ( rule__Mission__Group_6__0 )? ) )
            // InternalMyDsl.g:3714:1: ( ( rule__Mission__Group_6__0 )? )
            {
            // InternalMyDsl.g:3714:1: ( ( rule__Mission__Group_6__0 )? )
            // InternalMyDsl.g:3715:2: ( rule__Mission__Group_6__0 )?
            {
             before(grammarAccess.getMissionAccess().getGroup_6()); 
            // InternalMyDsl.g:3716:2: ( rule__Mission__Group_6__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==59) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMyDsl.g:3716:3: rule__Mission__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Mission__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMissionAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group__6__Impl"


    // $ANTLR start "rule__Mission__Group_1__0"
    // InternalMyDsl.g:3725:1: rule__Mission__Group_1__0 : rule__Mission__Group_1__0__Impl rule__Mission__Group_1__1 ;
    public final void rule__Mission__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3729:1: ( rule__Mission__Group_1__0__Impl rule__Mission__Group_1__1 )
            // InternalMyDsl.g:3730:2: rule__Mission__Group_1__0__Impl rule__Mission__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__Mission__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_1__1();

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
    // $ANTLR end "rule__Mission__Group_1__0"


    // $ANTLR start "rule__Mission__Group_1__0__Impl"
    // InternalMyDsl.g:3737:1: rule__Mission__Group_1__0__Impl : ( ',' ) ;
    public final void rule__Mission__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3741:1: ( ( ',' ) )
            // InternalMyDsl.g:3742:1: ( ',' )
            {
            // InternalMyDsl.g:3742:1: ( ',' )
            // InternalMyDsl.g:3743:2: ','
            {
             before(grammarAccess.getMissionAccess().getCommaKeyword_1_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getMissionAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_1__0__Impl"


    // $ANTLR start "rule__Mission__Group_1__1"
    // InternalMyDsl.g:3752:1: rule__Mission__Group_1__1 : rule__Mission__Group_1__1__Impl ;
    public final void rule__Mission__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3756:1: ( rule__Mission__Group_1__1__Impl )
            // InternalMyDsl.g:3757:2: rule__Mission__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group_1__1__Impl();

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
    // $ANTLR end "rule__Mission__Group_1__1"


    // $ANTLR start "rule__Mission__Group_1__1__Impl"
    // InternalMyDsl.g:3763:1: rule__Mission__Group_1__1__Impl : ( ( rule__Mission__MissionTaskAssignment_1_1 ) ) ;
    public final void rule__Mission__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3767:1: ( ( ( rule__Mission__MissionTaskAssignment_1_1 ) ) )
            // InternalMyDsl.g:3768:1: ( ( rule__Mission__MissionTaskAssignment_1_1 ) )
            {
            // InternalMyDsl.g:3768:1: ( ( rule__Mission__MissionTaskAssignment_1_1 ) )
            // InternalMyDsl.g:3769:2: ( rule__Mission__MissionTaskAssignment_1_1 )
            {
             before(grammarAccess.getMissionAccess().getMissionTaskAssignment_1_1()); 
            // InternalMyDsl.g:3770:2: ( rule__Mission__MissionTaskAssignment_1_1 )
            // InternalMyDsl.g:3770:3: rule__Mission__MissionTaskAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Mission__MissionTaskAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getMissionTaskAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_1__1__Impl"


    // $ANTLR start "rule__Mission__Group_4__0"
    // InternalMyDsl.g:3779:1: rule__Mission__Group_4__0 : rule__Mission__Group_4__0__Impl rule__Mission__Group_4__1 ;
    public final void rule__Mission__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3783:1: ( rule__Mission__Group_4__0__Impl rule__Mission__Group_4__1 )
            // InternalMyDsl.g:3784:2: rule__Mission__Group_4__0__Impl rule__Mission__Group_4__1
            {
            pushFollow(FOLLOW_46);
            rule__Mission__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_4__1();

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
    // $ANTLR end "rule__Mission__Group_4__0"


    // $ANTLR start "rule__Mission__Group_4__0__Impl"
    // InternalMyDsl.g:3791:1: rule__Mission__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Mission__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3795:1: ( ( ',' ) )
            // InternalMyDsl.g:3796:1: ( ',' )
            {
            // InternalMyDsl.g:3796:1: ( ',' )
            // InternalMyDsl.g:3797:2: ','
            {
             before(grammarAccess.getMissionAccess().getCommaKeyword_4_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getMissionAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_4__0__Impl"


    // $ANTLR start "rule__Mission__Group_4__1"
    // InternalMyDsl.g:3806:1: rule__Mission__Group_4__1 : rule__Mission__Group_4__1__Impl ;
    public final void rule__Mission__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3810:1: ( rule__Mission__Group_4__1__Impl )
            // InternalMyDsl.g:3811:2: rule__Mission__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group_4__1__Impl();

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
    // $ANTLR end "rule__Mission__Group_4__1"


    // $ANTLR start "rule__Mission__Group_4__1__Impl"
    // InternalMyDsl.g:3817:1: rule__Mission__Group_4__1__Impl : ( ( rule__Mission__ObjAssignment_4_1 ) ) ;
    public final void rule__Mission__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3821:1: ( ( ( rule__Mission__ObjAssignment_4_1 ) ) )
            // InternalMyDsl.g:3822:1: ( ( rule__Mission__ObjAssignment_4_1 ) )
            {
            // InternalMyDsl.g:3822:1: ( ( rule__Mission__ObjAssignment_4_1 ) )
            // InternalMyDsl.g:3823:2: ( rule__Mission__ObjAssignment_4_1 )
            {
             before(grammarAccess.getMissionAccess().getObjAssignment_4_1()); 
            // InternalMyDsl.g:3824:2: ( rule__Mission__ObjAssignment_4_1 )
            // InternalMyDsl.g:3824:3: rule__Mission__ObjAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Mission__ObjAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getObjAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_4__1__Impl"


    // $ANTLR start "rule__Mission__Group_5__0"
    // InternalMyDsl.g:3833:1: rule__Mission__Group_5__0 : rule__Mission__Group_5__0__Impl rule__Mission__Group_5__1 ;
    public final void rule__Mission__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3837:1: ( rule__Mission__Group_5__0__Impl rule__Mission__Group_5__1 )
            // InternalMyDsl.g:3838:2: rule__Mission__Group_5__0__Impl rule__Mission__Group_5__1
            {
            pushFollow(FOLLOW_48);
            rule__Mission__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_5__1();

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
    // $ANTLR end "rule__Mission__Group_5__0"


    // $ANTLR start "rule__Mission__Group_5__0__Impl"
    // InternalMyDsl.g:3845:1: rule__Mission__Group_5__0__Impl : ( 'constraints:' ) ;
    public final void rule__Mission__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3849:1: ( ( 'constraints:' ) )
            // InternalMyDsl.g:3850:1: ( 'constraints:' )
            {
            // InternalMyDsl.g:3850:1: ( 'constraints:' )
            // InternalMyDsl.g:3851:2: 'constraints:'
            {
             before(grammarAccess.getMissionAccess().getConstraintsKeyword_5_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getMissionAccess().getConstraintsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_5__0__Impl"


    // $ANTLR start "rule__Mission__Group_5__1"
    // InternalMyDsl.g:3860:1: rule__Mission__Group_5__1 : rule__Mission__Group_5__1__Impl rule__Mission__Group_5__2 ;
    public final void rule__Mission__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3864:1: ( rule__Mission__Group_5__1__Impl rule__Mission__Group_5__2 )
            // InternalMyDsl.g:3865:2: rule__Mission__Group_5__1__Impl rule__Mission__Group_5__2
            {
            pushFollow(FOLLOW_31);
            rule__Mission__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_5__2();

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
    // $ANTLR end "rule__Mission__Group_5__1"


    // $ANTLR start "rule__Mission__Group_5__1__Impl"
    // InternalMyDsl.g:3872:1: rule__Mission__Group_5__1__Impl : ( ( rule__Mission__ConstraintsAssignment_5_1 ) ) ;
    public final void rule__Mission__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3876:1: ( ( ( rule__Mission__ConstraintsAssignment_5_1 ) ) )
            // InternalMyDsl.g:3877:1: ( ( rule__Mission__ConstraintsAssignment_5_1 ) )
            {
            // InternalMyDsl.g:3877:1: ( ( rule__Mission__ConstraintsAssignment_5_1 ) )
            // InternalMyDsl.g:3878:2: ( rule__Mission__ConstraintsAssignment_5_1 )
            {
             before(grammarAccess.getMissionAccess().getConstraintsAssignment_5_1()); 
            // InternalMyDsl.g:3879:2: ( rule__Mission__ConstraintsAssignment_5_1 )
            // InternalMyDsl.g:3879:3: rule__Mission__ConstraintsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Mission__ConstraintsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getConstraintsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_5__1__Impl"


    // $ANTLR start "rule__Mission__Group_5__2"
    // InternalMyDsl.g:3887:1: rule__Mission__Group_5__2 : rule__Mission__Group_5__2__Impl ;
    public final void rule__Mission__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3891:1: ( rule__Mission__Group_5__2__Impl )
            // InternalMyDsl.g:3892:2: rule__Mission__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group_5__2__Impl();

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
    // $ANTLR end "rule__Mission__Group_5__2"


    // $ANTLR start "rule__Mission__Group_5__2__Impl"
    // InternalMyDsl.g:3898:1: rule__Mission__Group_5__2__Impl : ( ( rule__Mission__Group_5_2__0 )* ) ;
    public final void rule__Mission__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3902:1: ( ( ( rule__Mission__Group_5_2__0 )* ) )
            // InternalMyDsl.g:3903:1: ( ( rule__Mission__Group_5_2__0 )* )
            {
            // InternalMyDsl.g:3903:1: ( ( rule__Mission__Group_5_2__0 )* )
            // InternalMyDsl.g:3904:2: ( rule__Mission__Group_5_2__0 )*
            {
             before(grammarAccess.getMissionAccess().getGroup_5_2()); 
            // InternalMyDsl.g:3905:2: ( rule__Mission__Group_5_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==32) ) {
                    int LA31_2 = input.LA(2);

                    if ( (LA31_2==EOF||LA31_2==12||(LA31_2>=31 && LA31_2<=32)||LA31_2==59||LA31_2==63||(LA31_2>=65 && LA31_2<=66)||(LA31_2>=72 && LA31_2<=73)||LA31_2==76||LA31_2==83) ) {
                        alt31=1;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // InternalMyDsl.g:3905:3: rule__Mission__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Mission__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getMissionAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_5__2__Impl"


    // $ANTLR start "rule__Mission__Group_5_2__0"
    // InternalMyDsl.g:3914:1: rule__Mission__Group_5_2__0 : rule__Mission__Group_5_2__0__Impl rule__Mission__Group_5_2__1 ;
    public final void rule__Mission__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3918:1: ( rule__Mission__Group_5_2__0__Impl rule__Mission__Group_5_2__1 )
            // InternalMyDsl.g:3919:2: rule__Mission__Group_5_2__0__Impl rule__Mission__Group_5_2__1
            {
            pushFollow(FOLLOW_48);
            rule__Mission__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_5_2__1();

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
    // $ANTLR end "rule__Mission__Group_5_2__0"


    // $ANTLR start "rule__Mission__Group_5_2__0__Impl"
    // InternalMyDsl.g:3926:1: rule__Mission__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__Mission__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3930:1: ( ( ',' ) )
            // InternalMyDsl.g:3931:1: ( ',' )
            {
            // InternalMyDsl.g:3931:1: ( ',' )
            // InternalMyDsl.g:3932:2: ','
            {
             before(grammarAccess.getMissionAccess().getCommaKeyword_5_2_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getMissionAccess().getCommaKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_5_2__0__Impl"


    // $ANTLR start "rule__Mission__Group_5_2__1"
    // InternalMyDsl.g:3941:1: rule__Mission__Group_5_2__1 : rule__Mission__Group_5_2__1__Impl ;
    public final void rule__Mission__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3945:1: ( rule__Mission__Group_5_2__1__Impl )
            // InternalMyDsl.g:3946:2: rule__Mission__Group_5_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group_5_2__1__Impl();

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
    // $ANTLR end "rule__Mission__Group_5_2__1"


    // $ANTLR start "rule__Mission__Group_5_2__1__Impl"
    // InternalMyDsl.g:3952:1: rule__Mission__Group_5_2__1__Impl : ( ( rule__Mission__ConstraintsAssignment_5_2_1 ) ) ;
    public final void rule__Mission__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3956:1: ( ( ( rule__Mission__ConstraintsAssignment_5_2_1 ) ) )
            // InternalMyDsl.g:3957:1: ( ( rule__Mission__ConstraintsAssignment_5_2_1 ) )
            {
            // InternalMyDsl.g:3957:1: ( ( rule__Mission__ConstraintsAssignment_5_2_1 ) )
            // InternalMyDsl.g:3958:2: ( rule__Mission__ConstraintsAssignment_5_2_1 )
            {
             before(grammarAccess.getMissionAccess().getConstraintsAssignment_5_2_1()); 
            // InternalMyDsl.g:3959:2: ( rule__Mission__ConstraintsAssignment_5_2_1 )
            // InternalMyDsl.g:3959:3: rule__Mission__ConstraintsAssignment_5_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Mission__ConstraintsAssignment_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getConstraintsAssignment_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_5_2__1__Impl"


    // $ANTLR start "rule__Mission__Group_6__0"
    // InternalMyDsl.g:3968:1: rule__Mission__Group_6__0 : rule__Mission__Group_6__0__Impl rule__Mission__Group_6__1 ;
    public final void rule__Mission__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3972:1: ( rule__Mission__Group_6__0__Impl rule__Mission__Group_6__1 )
            // InternalMyDsl.g:3973:2: rule__Mission__Group_6__0__Impl rule__Mission__Group_6__1
            {
            pushFollow(FOLLOW_49);
            rule__Mission__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_6__1();

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
    // $ANTLR end "rule__Mission__Group_6__0"


    // $ANTLR start "rule__Mission__Group_6__0__Impl"
    // InternalMyDsl.g:3980:1: rule__Mission__Group_6__0__Impl : ( 'parameters:' ) ;
    public final void rule__Mission__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3984:1: ( ( 'parameters:' ) )
            // InternalMyDsl.g:3985:1: ( 'parameters:' )
            {
            // InternalMyDsl.g:3985:1: ( 'parameters:' )
            // InternalMyDsl.g:3986:2: 'parameters:'
            {
             before(grammarAccess.getMissionAccess().getParametersKeyword_6_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getMissionAccess().getParametersKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6__0__Impl"


    // $ANTLR start "rule__Mission__Group_6__1"
    // InternalMyDsl.g:3995:1: rule__Mission__Group_6__1 : rule__Mission__Group_6__1__Impl rule__Mission__Group_6__2 ;
    public final void rule__Mission__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3999:1: ( rule__Mission__Group_6__1__Impl rule__Mission__Group_6__2 )
            // InternalMyDsl.g:4000:2: rule__Mission__Group_6__1__Impl rule__Mission__Group_6__2
            {
            pushFollow(FOLLOW_49);
            rule__Mission__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_6__2();

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
    // $ANTLR end "rule__Mission__Group_6__1"


    // $ANTLR start "rule__Mission__Group_6__1__Impl"
    // InternalMyDsl.g:4007:1: rule__Mission__Group_6__1__Impl : ( ( rule__Mission__Group_6_1__0 )? ) ;
    public final void rule__Mission__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4011:1: ( ( ( rule__Mission__Group_6_1__0 )? ) )
            // InternalMyDsl.g:4012:1: ( ( rule__Mission__Group_6_1__0 )? )
            {
            // InternalMyDsl.g:4012:1: ( ( rule__Mission__Group_6_1__0 )? )
            // InternalMyDsl.g:4013:2: ( rule__Mission__Group_6_1__0 )?
            {
             before(grammarAccess.getMissionAccess().getGroup_6_1()); 
            // InternalMyDsl.g:4014:2: ( rule__Mission__Group_6_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==53) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:4014:3: rule__Mission__Group_6_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Mission__Group_6_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMissionAccess().getGroup_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6__1__Impl"


    // $ANTLR start "rule__Mission__Group_6__2"
    // InternalMyDsl.g:4022:1: rule__Mission__Group_6__2 : rule__Mission__Group_6__2__Impl rule__Mission__Group_6__3 ;
    public final void rule__Mission__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4026:1: ( rule__Mission__Group_6__2__Impl rule__Mission__Group_6__3 )
            // InternalMyDsl.g:4027:2: rule__Mission__Group_6__2__Impl rule__Mission__Group_6__3
            {
            pushFollow(FOLLOW_49);
            rule__Mission__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_6__3();

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
    // $ANTLR end "rule__Mission__Group_6__2"


    // $ANTLR start "rule__Mission__Group_6__2__Impl"
    // InternalMyDsl.g:4034:1: rule__Mission__Group_6__2__Impl : ( ( rule__Mission__Group_6_2__0 )? ) ;
    public final void rule__Mission__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4038:1: ( ( ( rule__Mission__Group_6_2__0 )? ) )
            // InternalMyDsl.g:4039:1: ( ( rule__Mission__Group_6_2__0 )? )
            {
            // InternalMyDsl.g:4039:1: ( ( rule__Mission__Group_6_2__0 )? )
            // InternalMyDsl.g:4040:2: ( rule__Mission__Group_6_2__0 )?
            {
             before(grammarAccess.getMissionAccess().getGroup_6_2()); 
            // InternalMyDsl.g:4041:2: ( rule__Mission__Group_6_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==60) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMyDsl.g:4041:3: rule__Mission__Group_6_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Mission__Group_6_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMissionAccess().getGroup_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6__2__Impl"


    // $ANTLR start "rule__Mission__Group_6__3"
    // InternalMyDsl.g:4049:1: rule__Mission__Group_6__3 : rule__Mission__Group_6__3__Impl rule__Mission__Group_6__4 ;
    public final void rule__Mission__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4053:1: ( rule__Mission__Group_6__3__Impl rule__Mission__Group_6__4 )
            // InternalMyDsl.g:4054:2: rule__Mission__Group_6__3__Impl rule__Mission__Group_6__4
            {
            pushFollow(FOLLOW_49);
            rule__Mission__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_6__4();

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
    // $ANTLR end "rule__Mission__Group_6__3"


    // $ANTLR start "rule__Mission__Group_6__3__Impl"
    // InternalMyDsl.g:4061:1: rule__Mission__Group_6__3__Impl : ( ( rule__Mission__Group_6_3__0 )? ) ;
    public final void rule__Mission__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4065:1: ( ( ( rule__Mission__Group_6_3__0 )? ) )
            // InternalMyDsl.g:4066:1: ( ( rule__Mission__Group_6_3__0 )? )
            {
            // InternalMyDsl.g:4066:1: ( ( rule__Mission__Group_6_3__0 )? )
            // InternalMyDsl.g:4067:2: ( rule__Mission__Group_6_3__0 )?
            {
             before(grammarAccess.getMissionAccess().getGroup_6_3()); 
            // InternalMyDsl.g:4068:2: ( rule__Mission__Group_6_3__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==61) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMyDsl.g:4068:3: rule__Mission__Group_6_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Mission__Group_6_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMissionAccess().getGroup_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6__3__Impl"


    // $ANTLR start "rule__Mission__Group_6__4"
    // InternalMyDsl.g:4076:1: rule__Mission__Group_6__4 : rule__Mission__Group_6__4__Impl ;
    public final void rule__Mission__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4080:1: ( rule__Mission__Group_6__4__Impl )
            // InternalMyDsl.g:4081:2: rule__Mission__Group_6__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group_6__4__Impl();

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
    // $ANTLR end "rule__Mission__Group_6__4"


    // $ANTLR start "rule__Mission__Group_6__4__Impl"
    // InternalMyDsl.g:4087:1: rule__Mission__Group_6__4__Impl : ( ( rule__Mission__Group_6_4__0 )? ) ;
    public final void rule__Mission__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4091:1: ( ( ( rule__Mission__Group_6_4__0 )? ) )
            // InternalMyDsl.g:4092:1: ( ( rule__Mission__Group_6_4__0 )? )
            {
            // InternalMyDsl.g:4092:1: ( ( rule__Mission__Group_6_4__0 )? )
            // InternalMyDsl.g:4093:2: ( rule__Mission__Group_6_4__0 )?
            {
             before(grammarAccess.getMissionAccess().getGroup_6_4()); 
            // InternalMyDsl.g:4094:2: ( rule__Mission__Group_6_4__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==62) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMyDsl.g:4094:3: rule__Mission__Group_6_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Mission__Group_6_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMissionAccess().getGroup_6_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6__4__Impl"


    // $ANTLR start "rule__Mission__Group_6_1__0"
    // InternalMyDsl.g:4103:1: rule__Mission__Group_6_1__0 : rule__Mission__Group_6_1__0__Impl rule__Mission__Group_6_1__1 ;
    public final void rule__Mission__Group_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4107:1: ( rule__Mission__Group_6_1__0__Impl rule__Mission__Group_6_1__1 )
            // InternalMyDsl.g:4108:2: rule__Mission__Group_6_1__0__Impl rule__Mission__Group_6_1__1
            {
            pushFollow(FOLLOW_22);
            rule__Mission__Group_6_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_6_1__1();

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
    // $ANTLR end "rule__Mission__Group_6_1__0"


    // $ANTLR start "rule__Mission__Group_6_1__0__Impl"
    // InternalMyDsl.g:4115:1: rule__Mission__Group_6_1__0__Impl : ( 'time:' ) ;
    public final void rule__Mission__Group_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4119:1: ( ( 'time:' ) )
            // InternalMyDsl.g:4120:1: ( 'time:' )
            {
            // InternalMyDsl.g:4120:1: ( 'time:' )
            // InternalMyDsl.g:4121:2: 'time:'
            {
             before(grammarAccess.getMissionAccess().getTimeKeyword_6_1_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getMissionAccess().getTimeKeyword_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6_1__0__Impl"


    // $ANTLR start "rule__Mission__Group_6_1__1"
    // InternalMyDsl.g:4130:1: rule__Mission__Group_6_1__1 : rule__Mission__Group_6_1__1__Impl ;
    public final void rule__Mission__Group_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4134:1: ( rule__Mission__Group_6_1__1__Impl )
            // InternalMyDsl.g:4135:2: rule__Mission__Group_6_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group_6_1__1__Impl();

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
    // $ANTLR end "rule__Mission__Group_6_1__1"


    // $ANTLR start "rule__Mission__Group_6_1__1__Impl"
    // InternalMyDsl.g:4141:1: rule__Mission__Group_6_1__1__Impl : ( ( rule__Mission__TimeAssignment_6_1_1 ) ) ;
    public final void rule__Mission__Group_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4145:1: ( ( ( rule__Mission__TimeAssignment_6_1_1 ) ) )
            // InternalMyDsl.g:4146:1: ( ( rule__Mission__TimeAssignment_6_1_1 ) )
            {
            // InternalMyDsl.g:4146:1: ( ( rule__Mission__TimeAssignment_6_1_1 ) )
            // InternalMyDsl.g:4147:2: ( rule__Mission__TimeAssignment_6_1_1 )
            {
             before(grammarAccess.getMissionAccess().getTimeAssignment_6_1_1()); 
            // InternalMyDsl.g:4148:2: ( rule__Mission__TimeAssignment_6_1_1 )
            // InternalMyDsl.g:4148:3: rule__Mission__TimeAssignment_6_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Mission__TimeAssignment_6_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getTimeAssignment_6_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6_1__1__Impl"


    // $ANTLR start "rule__Mission__Group_6_2__0"
    // InternalMyDsl.g:4157:1: rule__Mission__Group_6_2__0 : rule__Mission__Group_6_2__0__Impl rule__Mission__Group_6_2__1 ;
    public final void rule__Mission__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4161:1: ( rule__Mission__Group_6_2__0__Impl rule__Mission__Group_6_2__1 )
            // InternalMyDsl.g:4162:2: rule__Mission__Group_6_2__0__Impl rule__Mission__Group_6_2__1
            {
            pushFollow(FOLLOW_22);
            rule__Mission__Group_6_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_6_2__1();

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
    // $ANTLR end "rule__Mission__Group_6_2__0"


    // $ANTLR start "rule__Mission__Group_6_2__0__Impl"
    // InternalMyDsl.g:4169:1: rule__Mission__Group_6_2__0__Impl : ( 'numAllocation:' ) ;
    public final void rule__Mission__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4173:1: ( ( 'numAllocation:' ) )
            // InternalMyDsl.g:4174:1: ( 'numAllocation:' )
            {
            // InternalMyDsl.g:4174:1: ( 'numAllocation:' )
            // InternalMyDsl.g:4175:2: 'numAllocation:'
            {
             before(grammarAccess.getMissionAccess().getNumAllocationKeyword_6_2_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getMissionAccess().getNumAllocationKeyword_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6_2__0__Impl"


    // $ANTLR start "rule__Mission__Group_6_2__1"
    // InternalMyDsl.g:4184:1: rule__Mission__Group_6_2__1 : rule__Mission__Group_6_2__1__Impl ;
    public final void rule__Mission__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4188:1: ( rule__Mission__Group_6_2__1__Impl )
            // InternalMyDsl.g:4189:2: rule__Mission__Group_6_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group_6_2__1__Impl();

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
    // $ANTLR end "rule__Mission__Group_6_2__1"


    // $ANTLR start "rule__Mission__Group_6_2__1__Impl"
    // InternalMyDsl.g:4195:1: rule__Mission__Group_6_2__1__Impl : ( ( rule__Mission__NumAllocAssignment_6_2_1 ) ) ;
    public final void rule__Mission__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4199:1: ( ( ( rule__Mission__NumAllocAssignment_6_2_1 ) ) )
            // InternalMyDsl.g:4200:1: ( ( rule__Mission__NumAllocAssignment_6_2_1 ) )
            {
            // InternalMyDsl.g:4200:1: ( ( rule__Mission__NumAllocAssignment_6_2_1 ) )
            // InternalMyDsl.g:4201:2: ( rule__Mission__NumAllocAssignment_6_2_1 )
            {
             before(grammarAccess.getMissionAccess().getNumAllocAssignment_6_2_1()); 
            // InternalMyDsl.g:4202:2: ( rule__Mission__NumAllocAssignment_6_2_1 )
            // InternalMyDsl.g:4202:3: rule__Mission__NumAllocAssignment_6_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Mission__NumAllocAssignment_6_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getNumAllocAssignment_6_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6_2__1__Impl"


    // $ANTLR start "rule__Mission__Group_6_3__0"
    // InternalMyDsl.g:4211:1: rule__Mission__Group_6_3__0 : rule__Mission__Group_6_3__0__Impl rule__Mission__Group_6_3__1 ;
    public final void rule__Mission__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4215:1: ( rule__Mission__Group_6_3__0__Impl rule__Mission__Group_6_3__1 )
            // InternalMyDsl.g:4216:2: rule__Mission__Group_6_3__0__Impl rule__Mission__Group_6_3__1
            {
            pushFollow(FOLLOW_22);
            rule__Mission__Group_6_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_6_3__1();

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
    // $ANTLR end "rule__Mission__Group_6_3__0"


    // $ANTLR start "rule__Mission__Group_6_3__0__Impl"
    // InternalMyDsl.g:4223:1: rule__Mission__Group_6_3__0__Impl : ( 'population:' ) ;
    public final void rule__Mission__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4227:1: ( ( 'population:' ) )
            // InternalMyDsl.g:4228:1: ( 'population:' )
            {
            // InternalMyDsl.g:4228:1: ( 'population:' )
            // InternalMyDsl.g:4229:2: 'population:'
            {
             before(grammarAccess.getMissionAccess().getPopulationKeyword_6_3_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getMissionAccess().getPopulationKeyword_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6_3__0__Impl"


    // $ANTLR start "rule__Mission__Group_6_3__1"
    // InternalMyDsl.g:4238:1: rule__Mission__Group_6_3__1 : rule__Mission__Group_6_3__1__Impl ;
    public final void rule__Mission__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4242:1: ( rule__Mission__Group_6_3__1__Impl )
            // InternalMyDsl.g:4243:2: rule__Mission__Group_6_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group_6_3__1__Impl();

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
    // $ANTLR end "rule__Mission__Group_6_3__1"


    // $ANTLR start "rule__Mission__Group_6_3__1__Impl"
    // InternalMyDsl.g:4249:1: rule__Mission__Group_6_3__1__Impl : ( ( rule__Mission__PopulationAssignment_6_3_1 ) ) ;
    public final void rule__Mission__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4253:1: ( ( ( rule__Mission__PopulationAssignment_6_3_1 ) ) )
            // InternalMyDsl.g:4254:1: ( ( rule__Mission__PopulationAssignment_6_3_1 ) )
            {
            // InternalMyDsl.g:4254:1: ( ( rule__Mission__PopulationAssignment_6_3_1 ) )
            // InternalMyDsl.g:4255:2: ( rule__Mission__PopulationAssignment_6_3_1 )
            {
             before(grammarAccess.getMissionAccess().getPopulationAssignment_6_3_1()); 
            // InternalMyDsl.g:4256:2: ( rule__Mission__PopulationAssignment_6_3_1 )
            // InternalMyDsl.g:4256:3: rule__Mission__PopulationAssignment_6_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Mission__PopulationAssignment_6_3_1();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getPopulationAssignment_6_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6_3__1__Impl"


    // $ANTLR start "rule__Mission__Group_6_4__0"
    // InternalMyDsl.g:4265:1: rule__Mission__Group_6_4__0 : rule__Mission__Group_6_4__0__Impl rule__Mission__Group_6_4__1 ;
    public final void rule__Mission__Group_6_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4269:1: ( rule__Mission__Group_6_4__0__Impl rule__Mission__Group_6_4__1 )
            // InternalMyDsl.g:4270:2: rule__Mission__Group_6_4__0__Impl rule__Mission__Group_6_4__1
            {
            pushFollow(FOLLOW_22);
            rule__Mission__Group_6_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mission__Group_6_4__1();

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
    // $ANTLR end "rule__Mission__Group_6_4__0"


    // $ANTLR start "rule__Mission__Group_6_4__0__Impl"
    // InternalMyDsl.g:4277:1: rule__Mission__Group_6_4__0__Impl : ( 'evaluation:' ) ;
    public final void rule__Mission__Group_6_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4281:1: ( ( 'evaluation:' ) )
            // InternalMyDsl.g:4282:1: ( 'evaluation:' )
            {
            // InternalMyDsl.g:4282:1: ( 'evaluation:' )
            // InternalMyDsl.g:4283:2: 'evaluation:'
            {
             before(grammarAccess.getMissionAccess().getEvaluationKeyword_6_4_0()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getMissionAccess().getEvaluationKeyword_6_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6_4__0__Impl"


    // $ANTLR start "rule__Mission__Group_6_4__1"
    // InternalMyDsl.g:4292:1: rule__Mission__Group_6_4__1 : rule__Mission__Group_6_4__1__Impl ;
    public final void rule__Mission__Group_6_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4296:1: ( rule__Mission__Group_6_4__1__Impl )
            // InternalMyDsl.g:4297:2: rule__Mission__Group_6_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mission__Group_6_4__1__Impl();

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
    // $ANTLR end "rule__Mission__Group_6_4__1"


    // $ANTLR start "rule__Mission__Group_6_4__1__Impl"
    // InternalMyDsl.g:4303:1: rule__Mission__Group_6_4__1__Impl : ( ( rule__Mission__EvaluationsAssignment_6_4_1 ) ) ;
    public final void rule__Mission__Group_6_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4307:1: ( ( ( rule__Mission__EvaluationsAssignment_6_4_1 ) ) )
            // InternalMyDsl.g:4308:1: ( ( rule__Mission__EvaluationsAssignment_6_4_1 ) )
            {
            // InternalMyDsl.g:4308:1: ( ( rule__Mission__EvaluationsAssignment_6_4_1 ) )
            // InternalMyDsl.g:4309:2: ( rule__Mission__EvaluationsAssignment_6_4_1 )
            {
             before(grammarAccess.getMissionAccess().getEvaluationsAssignment_6_4_1()); 
            // InternalMyDsl.g:4310:2: ( rule__Mission__EvaluationsAssignment_6_4_1 )
            // InternalMyDsl.g:4310:3: rule__Mission__EvaluationsAssignment_6_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Mission__EvaluationsAssignment_6_4_1();

            state._fsp--;


            }

             after(grammarAccess.getMissionAccess().getEvaluationsAssignment_6_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__Group_6_4__1__Impl"


    // $ANTLR start "rule__MissionTask__Group__0"
    // InternalMyDsl.g:4319:1: rule__MissionTask__Group__0 : rule__MissionTask__Group__0__Impl rule__MissionTask__Group__1 ;
    public final void rule__MissionTask__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4323:1: ( rule__MissionTask__Group__0__Impl rule__MissionTask__Group__1 )
            // InternalMyDsl.g:4324:2: rule__MissionTask__Group__0__Impl rule__MissionTask__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__MissionTask__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissionTask__Group__1();

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
    // $ANTLR end "rule__MissionTask__Group__0"


    // $ANTLR start "rule__MissionTask__Group__0__Impl"
    // InternalMyDsl.g:4331:1: rule__MissionTask__Group__0__Impl : ( () ) ;
    public final void rule__MissionTask__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4335:1: ( ( () ) )
            // InternalMyDsl.g:4336:1: ( () )
            {
            // InternalMyDsl.g:4336:1: ( () )
            // InternalMyDsl.g:4337:2: ()
            {
             before(grammarAccess.getMissionTaskAccess().getMissionTaskAction_0()); 
            // InternalMyDsl.g:4338:2: ()
            // InternalMyDsl.g:4338:3: 
            {
            }

             after(grammarAccess.getMissionTaskAccess().getMissionTaskAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group__0__Impl"


    // $ANTLR start "rule__MissionTask__Group__1"
    // InternalMyDsl.g:4346:1: rule__MissionTask__Group__1 : rule__MissionTask__Group__1__Impl rule__MissionTask__Group__2 ;
    public final void rule__MissionTask__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4350:1: ( rule__MissionTask__Group__1__Impl rule__MissionTask__Group__2 )
            // InternalMyDsl.g:4351:2: rule__MissionTask__Group__1__Impl rule__MissionTask__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__MissionTask__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissionTask__Group__2();

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
    // $ANTLR end "rule__MissionTask__Group__1"


    // $ANTLR start "rule__MissionTask__Group__1__Impl"
    // InternalMyDsl.g:4358:1: rule__MissionTask__Group__1__Impl : ( ( rule__MissionTask__NameAssignment_1 ) ) ;
    public final void rule__MissionTask__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4362:1: ( ( ( rule__MissionTask__NameAssignment_1 ) ) )
            // InternalMyDsl.g:4363:1: ( ( rule__MissionTask__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:4363:1: ( ( rule__MissionTask__NameAssignment_1 ) )
            // InternalMyDsl.g:4364:2: ( rule__MissionTask__NameAssignment_1 )
            {
             before(grammarAccess.getMissionTaskAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:4365:2: ( rule__MissionTask__NameAssignment_1 )
            // InternalMyDsl.g:4365:3: rule__MissionTask__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MissionTask__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMissionTaskAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group__1__Impl"


    // $ANTLR start "rule__MissionTask__Group__2"
    // InternalMyDsl.g:4373:1: rule__MissionTask__Group__2 : rule__MissionTask__Group__2__Impl rule__MissionTask__Group__3 ;
    public final void rule__MissionTask__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4377:1: ( rule__MissionTask__Group__2__Impl rule__MissionTask__Group__3 )
            // InternalMyDsl.g:4378:2: rule__MissionTask__Group__2__Impl rule__MissionTask__Group__3
            {
            pushFollow(FOLLOW_50);
            rule__MissionTask__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissionTask__Group__3();

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
    // $ANTLR end "rule__MissionTask__Group__2"


    // $ANTLR start "rule__MissionTask__Group__2__Impl"
    // InternalMyDsl.g:4385:1: rule__MissionTask__Group__2__Impl : ( ':' ) ;
    public final void rule__MissionTask__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4389:1: ( ( ':' ) )
            // InternalMyDsl.g:4390:1: ( ':' )
            {
            // InternalMyDsl.g:4390:1: ( ':' )
            // InternalMyDsl.g:4391:2: ':'
            {
             before(grammarAccess.getMissionTaskAccess().getColonKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getMissionTaskAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group__2__Impl"


    // $ANTLR start "rule__MissionTask__Group__3"
    // InternalMyDsl.g:4400:1: rule__MissionTask__Group__3 : rule__MissionTask__Group__3__Impl rule__MissionTask__Group__4 ;
    public final void rule__MissionTask__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4404:1: ( rule__MissionTask__Group__3__Impl rule__MissionTask__Group__4 )
            // InternalMyDsl.g:4405:2: rule__MissionTask__Group__3__Impl rule__MissionTask__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__MissionTask__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissionTask__Group__4();

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
    // $ANTLR end "rule__MissionTask__Group__3"


    // $ANTLR start "rule__MissionTask__Group__3__Impl"
    // InternalMyDsl.g:4412:1: rule__MissionTask__Group__3__Impl : ( ( rule__MissionTask__Alternatives_3 ) ) ;
    public final void rule__MissionTask__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4416:1: ( ( ( rule__MissionTask__Alternatives_3 ) ) )
            // InternalMyDsl.g:4417:1: ( ( rule__MissionTask__Alternatives_3 ) )
            {
            // InternalMyDsl.g:4417:1: ( ( rule__MissionTask__Alternatives_3 ) )
            // InternalMyDsl.g:4418:2: ( rule__MissionTask__Alternatives_3 )
            {
             before(grammarAccess.getMissionTaskAccess().getAlternatives_3()); 
            // InternalMyDsl.g:4419:2: ( rule__MissionTask__Alternatives_3 )
            // InternalMyDsl.g:4419:3: rule__MissionTask__Alternatives_3
            {
            pushFollow(FOLLOW_2);
            rule__MissionTask__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getMissionTaskAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group__3__Impl"


    // $ANTLR start "rule__MissionTask__Group__4"
    // InternalMyDsl.g:4427:1: rule__MissionTask__Group__4 : rule__MissionTask__Group__4__Impl ;
    public final void rule__MissionTask__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4431:1: ( rule__MissionTask__Group__4__Impl )
            // InternalMyDsl.g:4432:2: rule__MissionTask__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MissionTask__Group__4__Impl();

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
    // $ANTLR end "rule__MissionTask__Group__4"


    // $ANTLR start "rule__MissionTask__Group__4__Impl"
    // InternalMyDsl.g:4438:1: rule__MissionTask__Group__4__Impl : ( ( rule__MissionTask__Group_4__0 )? ) ;
    public final void rule__MissionTask__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4442:1: ( ( ( rule__MissionTask__Group_4__0 )? ) )
            // InternalMyDsl.g:4443:1: ( ( rule__MissionTask__Group_4__0 )? )
            {
            // InternalMyDsl.g:4443:1: ( ( rule__MissionTask__Group_4__0 )? )
            // InternalMyDsl.g:4444:2: ( rule__MissionTask__Group_4__0 )?
            {
             before(grammarAccess.getMissionTaskAccess().getGroup_4()); 
            // InternalMyDsl.g:4445:2: ( rule__MissionTask__Group_4__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==40) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMyDsl.g:4445:3: rule__MissionTask__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MissionTask__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMissionTaskAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group__4__Impl"


    // $ANTLR start "rule__MissionTask__Group_3_0__0"
    // InternalMyDsl.g:4454:1: rule__MissionTask__Group_3_0__0 : rule__MissionTask__Group_3_0__0__Impl rule__MissionTask__Group_3_0__1 ;
    public final void rule__MissionTask__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4458:1: ( rule__MissionTask__Group_3_0__0__Impl rule__MissionTask__Group_3_0__1 )
            // InternalMyDsl.g:4459:2: rule__MissionTask__Group_3_0__0__Impl rule__MissionTask__Group_3_0__1
            {
            pushFollow(FOLLOW_51);
            rule__MissionTask__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissionTask__Group_3_0__1();

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
    // $ANTLR end "rule__MissionTask__Group_3_0__0"


    // $ANTLR start "rule__MissionTask__Group_3_0__0__Impl"
    // InternalMyDsl.g:4466:1: rule__MissionTask__Group_3_0__0__Impl : ( 'atomic' ) ;
    public final void rule__MissionTask__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4470:1: ( ( 'atomic' ) )
            // InternalMyDsl.g:4471:1: ( 'atomic' )
            {
            // InternalMyDsl.g:4471:1: ( 'atomic' )
            // InternalMyDsl.g:4472:2: 'atomic'
            {
             before(grammarAccess.getMissionTaskAccess().getAtomicKeyword_3_0_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getMissionTaskAccess().getAtomicKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group_3_0__0__Impl"


    // $ANTLR start "rule__MissionTask__Group_3_0__1"
    // InternalMyDsl.g:4481:1: rule__MissionTask__Group_3_0__1 : rule__MissionTask__Group_3_0__1__Impl rule__MissionTask__Group_3_0__2 ;
    public final void rule__MissionTask__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4485:1: ( rule__MissionTask__Group_3_0__1__Impl rule__MissionTask__Group_3_0__2 )
            // InternalMyDsl.g:4486:2: rule__MissionTask__Group_3_0__1__Impl rule__MissionTask__Group_3_0__2
            {
            pushFollow(FOLLOW_9);
            rule__MissionTask__Group_3_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissionTask__Group_3_0__2();

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
    // $ANTLR end "rule__MissionTask__Group_3_0__1"


    // $ANTLR start "rule__MissionTask__Group_3_0__1__Impl"
    // InternalMyDsl.g:4493:1: rule__MissionTask__Group_3_0__1__Impl : ( 'task' ) ;
    public final void rule__MissionTask__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4497:1: ( ( 'task' ) )
            // InternalMyDsl.g:4498:1: ( 'task' )
            {
            // InternalMyDsl.g:4498:1: ( 'task' )
            // InternalMyDsl.g:4499:2: 'task'
            {
             before(grammarAccess.getMissionTaskAccess().getTaskKeyword_3_0_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getMissionTaskAccess().getTaskKeyword_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group_3_0__1__Impl"


    // $ANTLR start "rule__MissionTask__Group_3_0__2"
    // InternalMyDsl.g:4508:1: rule__MissionTask__Group_3_0__2 : rule__MissionTask__Group_3_0__2__Impl ;
    public final void rule__MissionTask__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4512:1: ( rule__MissionTask__Group_3_0__2__Impl )
            // InternalMyDsl.g:4513:2: rule__MissionTask__Group_3_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MissionTask__Group_3_0__2__Impl();

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
    // $ANTLR end "rule__MissionTask__Group_3_0__2"


    // $ANTLR start "rule__MissionTask__Group_3_0__2__Impl"
    // InternalMyDsl.g:4519:1: rule__MissionTask__Group_3_0__2__Impl : ( ( rule__MissionTask__AtAssignment_3_0_2 ) ) ;
    public final void rule__MissionTask__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4523:1: ( ( ( rule__MissionTask__AtAssignment_3_0_2 ) ) )
            // InternalMyDsl.g:4524:1: ( ( rule__MissionTask__AtAssignment_3_0_2 ) )
            {
            // InternalMyDsl.g:4524:1: ( ( rule__MissionTask__AtAssignment_3_0_2 ) )
            // InternalMyDsl.g:4525:2: ( rule__MissionTask__AtAssignment_3_0_2 )
            {
             before(grammarAccess.getMissionTaskAccess().getAtAssignment_3_0_2()); 
            // InternalMyDsl.g:4526:2: ( rule__MissionTask__AtAssignment_3_0_2 )
            // InternalMyDsl.g:4526:3: rule__MissionTask__AtAssignment_3_0_2
            {
            pushFollow(FOLLOW_2);
            rule__MissionTask__AtAssignment_3_0_2();

            state._fsp--;


            }

             after(grammarAccess.getMissionTaskAccess().getAtAssignment_3_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group_3_0__2__Impl"


    // $ANTLR start "rule__MissionTask__Group_3_1__0"
    // InternalMyDsl.g:4535:1: rule__MissionTask__Group_3_1__0 : rule__MissionTask__Group_3_1__0__Impl rule__MissionTask__Group_3_1__1 ;
    public final void rule__MissionTask__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4539:1: ( rule__MissionTask__Group_3_1__0__Impl rule__MissionTask__Group_3_1__1 )
            // InternalMyDsl.g:4540:2: rule__MissionTask__Group_3_1__0__Impl rule__MissionTask__Group_3_1__1
            {
            pushFollow(FOLLOW_51);
            rule__MissionTask__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissionTask__Group_3_1__1();

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
    // $ANTLR end "rule__MissionTask__Group_3_1__0"


    // $ANTLR start "rule__MissionTask__Group_3_1__0__Impl"
    // InternalMyDsl.g:4547:1: rule__MissionTask__Group_3_1__0__Impl : ( 'compound' ) ;
    public final void rule__MissionTask__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4551:1: ( ( 'compound' ) )
            // InternalMyDsl.g:4552:1: ( 'compound' )
            {
            // InternalMyDsl.g:4552:1: ( 'compound' )
            // InternalMyDsl.g:4553:2: 'compound'
            {
             before(grammarAccess.getMissionTaskAccess().getCompoundKeyword_3_1_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getMissionTaskAccess().getCompoundKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group_3_1__0__Impl"


    // $ANTLR start "rule__MissionTask__Group_3_1__1"
    // InternalMyDsl.g:4562:1: rule__MissionTask__Group_3_1__1 : rule__MissionTask__Group_3_1__1__Impl rule__MissionTask__Group_3_1__2 ;
    public final void rule__MissionTask__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4566:1: ( rule__MissionTask__Group_3_1__1__Impl rule__MissionTask__Group_3_1__2 )
            // InternalMyDsl.g:4567:2: rule__MissionTask__Group_3_1__1__Impl rule__MissionTask__Group_3_1__2
            {
            pushFollow(FOLLOW_9);
            rule__MissionTask__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissionTask__Group_3_1__2();

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
    // $ANTLR end "rule__MissionTask__Group_3_1__1"


    // $ANTLR start "rule__MissionTask__Group_3_1__1__Impl"
    // InternalMyDsl.g:4574:1: rule__MissionTask__Group_3_1__1__Impl : ( 'task' ) ;
    public final void rule__MissionTask__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4578:1: ( ( 'task' ) )
            // InternalMyDsl.g:4579:1: ( 'task' )
            {
            // InternalMyDsl.g:4579:1: ( 'task' )
            // InternalMyDsl.g:4580:2: 'task'
            {
             before(grammarAccess.getMissionTaskAccess().getTaskKeyword_3_1_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getMissionTaskAccess().getTaskKeyword_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group_3_1__1__Impl"


    // $ANTLR start "rule__MissionTask__Group_3_1__2"
    // InternalMyDsl.g:4589:1: rule__MissionTask__Group_3_1__2 : rule__MissionTask__Group_3_1__2__Impl ;
    public final void rule__MissionTask__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4593:1: ( rule__MissionTask__Group_3_1__2__Impl )
            // InternalMyDsl.g:4594:2: rule__MissionTask__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MissionTask__Group_3_1__2__Impl();

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
    // $ANTLR end "rule__MissionTask__Group_3_1__2"


    // $ANTLR start "rule__MissionTask__Group_3_1__2__Impl"
    // InternalMyDsl.g:4600:1: rule__MissionTask__Group_3_1__2__Impl : ( ( rule__MissionTask__CtAssignment_3_1_2 ) ) ;
    public final void rule__MissionTask__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4604:1: ( ( ( rule__MissionTask__CtAssignment_3_1_2 ) ) )
            // InternalMyDsl.g:4605:1: ( ( rule__MissionTask__CtAssignment_3_1_2 ) )
            {
            // InternalMyDsl.g:4605:1: ( ( rule__MissionTask__CtAssignment_3_1_2 ) )
            // InternalMyDsl.g:4606:2: ( rule__MissionTask__CtAssignment_3_1_2 )
            {
             before(grammarAccess.getMissionTaskAccess().getCtAssignment_3_1_2()); 
            // InternalMyDsl.g:4607:2: ( rule__MissionTask__CtAssignment_3_1_2 )
            // InternalMyDsl.g:4607:3: rule__MissionTask__CtAssignment_3_1_2
            {
            pushFollow(FOLLOW_2);
            rule__MissionTask__CtAssignment_3_1_2();

            state._fsp--;


            }

             after(grammarAccess.getMissionTaskAccess().getCtAssignment_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group_3_1__2__Impl"


    // $ANTLR start "rule__MissionTask__Group_4__0"
    // InternalMyDsl.g:4616:1: rule__MissionTask__Group_4__0 : rule__MissionTask__Group_4__0__Impl rule__MissionTask__Group_4__1 ;
    public final void rule__MissionTask__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4620:1: ( rule__MissionTask__Group_4__0__Impl rule__MissionTask__Group_4__1 )
            // InternalMyDsl.g:4621:2: rule__MissionTask__Group_4__0__Impl rule__MissionTask__Group_4__1
            {
            pushFollow(FOLLOW_26);
            rule__MissionTask__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissionTask__Group_4__1();

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
    // $ANTLR end "rule__MissionTask__Group_4__0"


    // $ANTLR start "rule__MissionTask__Group_4__0__Impl"
    // InternalMyDsl.g:4628:1: rule__MissionTask__Group_4__0__Impl : ( 'at' ) ;
    public final void rule__MissionTask__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4632:1: ( ( 'at' ) )
            // InternalMyDsl.g:4633:1: ( 'at' )
            {
            // InternalMyDsl.g:4633:1: ( 'at' )
            // InternalMyDsl.g:4634:2: 'at'
            {
             before(grammarAccess.getMissionTaskAccess().getAtKeyword_4_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getMissionTaskAccess().getAtKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group_4__0__Impl"


    // $ANTLR start "rule__MissionTask__Group_4__1"
    // InternalMyDsl.g:4643:1: rule__MissionTask__Group_4__1 : rule__MissionTask__Group_4__1__Impl rule__MissionTask__Group_4__2 ;
    public final void rule__MissionTask__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4647:1: ( rule__MissionTask__Group_4__1__Impl rule__MissionTask__Group_4__2 )
            // InternalMyDsl.g:4648:2: rule__MissionTask__Group_4__1__Impl rule__MissionTask__Group_4__2
            {
            pushFollow(FOLLOW_9);
            rule__MissionTask__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissionTask__Group_4__2();

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
    // $ANTLR end "rule__MissionTask__Group_4__1"


    // $ANTLR start "rule__MissionTask__Group_4__1__Impl"
    // InternalMyDsl.g:4655:1: rule__MissionTask__Group_4__1__Impl : ( 'location' ) ;
    public final void rule__MissionTask__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4659:1: ( ( 'location' ) )
            // InternalMyDsl.g:4660:1: ( 'location' )
            {
            // InternalMyDsl.g:4660:1: ( 'location' )
            // InternalMyDsl.g:4661:2: 'location'
            {
             before(grammarAccess.getMissionTaskAccess().getLocationKeyword_4_1()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getMissionTaskAccess().getLocationKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group_4__1__Impl"


    // $ANTLR start "rule__MissionTask__Group_4__2"
    // InternalMyDsl.g:4670:1: rule__MissionTask__Group_4__2 : rule__MissionTask__Group_4__2__Impl ;
    public final void rule__MissionTask__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4674:1: ( rule__MissionTask__Group_4__2__Impl )
            // InternalMyDsl.g:4675:2: rule__MissionTask__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MissionTask__Group_4__2__Impl();

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
    // $ANTLR end "rule__MissionTask__Group_4__2"


    // $ANTLR start "rule__MissionTask__Group_4__2__Impl"
    // InternalMyDsl.g:4681:1: rule__MissionTask__Group_4__2__Impl : ( ( rule__MissionTask__LocAssignment_4_2 ) ) ;
    public final void rule__MissionTask__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4685:1: ( ( ( rule__MissionTask__LocAssignment_4_2 ) ) )
            // InternalMyDsl.g:4686:1: ( ( rule__MissionTask__LocAssignment_4_2 ) )
            {
            // InternalMyDsl.g:4686:1: ( ( rule__MissionTask__LocAssignment_4_2 ) )
            // InternalMyDsl.g:4687:2: ( rule__MissionTask__LocAssignment_4_2 )
            {
             before(grammarAccess.getMissionTaskAccess().getLocAssignment_4_2()); 
            // InternalMyDsl.g:4688:2: ( rule__MissionTask__LocAssignment_4_2 )
            // InternalMyDsl.g:4688:3: rule__MissionTask__LocAssignment_4_2
            {
            pushFollow(FOLLOW_2);
            rule__MissionTask__LocAssignment_4_2();

            state._fsp--;


            }

             after(grammarAccess.getMissionTaskAccess().getLocAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__Group_4__2__Impl"


    // $ANTLR start "rule__RateSucc__Group__0"
    // InternalMyDsl.g:4697:1: rule__RateSucc__Group__0 : rule__RateSucc__Group__0__Impl rule__RateSucc__Group__1 ;
    public final void rule__RateSucc__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4701:1: ( rule__RateSucc__Group__0__Impl rule__RateSucc__Group__1 )
            // InternalMyDsl.g:4702:2: rule__RateSucc__Group__0__Impl rule__RateSucc__Group__1
            {
            pushFollow(FOLLOW_52);
            rule__RateSucc__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RateSucc__Group__1();

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
    // $ANTLR end "rule__RateSucc__Group__0"


    // $ANTLR start "rule__RateSucc__Group__0__Impl"
    // InternalMyDsl.g:4709:1: rule__RateSucc__Group__0__Impl : ( () ) ;
    public final void rule__RateSucc__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4713:1: ( ( () ) )
            // InternalMyDsl.g:4714:1: ( () )
            {
            // InternalMyDsl.g:4714:1: ( () )
            // InternalMyDsl.g:4715:2: ()
            {
             before(grammarAccess.getRateSuccAccess().getRateSuccAction_0()); 
            // InternalMyDsl.g:4716:2: ()
            // InternalMyDsl.g:4716:3: 
            {
            }

             after(grammarAccess.getRateSuccAccess().getRateSuccAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RateSucc__Group__0__Impl"


    // $ANTLR start "rule__RateSucc__Group__1"
    // InternalMyDsl.g:4724:1: rule__RateSucc__Group__1 : rule__RateSucc__Group__1__Impl ;
    public final void rule__RateSucc__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4728:1: ( rule__RateSucc__Group__1__Impl )
            // InternalMyDsl.g:4729:2: rule__RateSucc__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RateSucc__Group__1__Impl();

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
    // $ANTLR end "rule__RateSucc__Group__1"


    // $ANTLR start "rule__RateSucc__Group__1__Impl"
    // InternalMyDsl.g:4735:1: rule__RateSucc__Group__1__Impl : ( ( rule__RateSucc__Group_1__0 )? ) ;
    public final void rule__RateSucc__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4739:1: ( ( ( rule__RateSucc__Group_1__0 )? ) )
            // InternalMyDsl.g:4740:1: ( ( rule__RateSucc__Group_1__0 )? )
            {
            // InternalMyDsl.g:4740:1: ( ( rule__RateSucc__Group_1__0 )? )
            // InternalMyDsl.g:4741:2: ( rule__RateSucc__Group_1__0 )?
            {
             before(grammarAccess.getRateSuccAccess().getGroup_1()); 
            // InternalMyDsl.g:4742:2: ( rule__RateSucc__Group_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==66) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalMyDsl.g:4742:3: rule__RateSucc__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RateSucc__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRateSuccAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RateSucc__Group__1__Impl"


    // $ANTLR start "rule__RateSucc__Group_1__0"
    // InternalMyDsl.g:4751:1: rule__RateSucc__Group_1__0 : rule__RateSucc__Group_1__0__Impl rule__RateSucc__Group_1__1 ;
    public final void rule__RateSucc__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4755:1: ( rule__RateSucc__Group_1__0__Impl rule__RateSucc__Group_1__1 )
            // InternalMyDsl.g:4756:2: rule__RateSucc__Group_1__0__Impl rule__RateSucc__Group_1__1
            {
            pushFollow(FOLLOW_53);
            rule__RateSucc__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RateSucc__Group_1__1();

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
    // $ANTLR end "rule__RateSucc__Group_1__0"


    // $ANTLR start "rule__RateSucc__Group_1__0__Impl"
    // InternalMyDsl.g:4763:1: rule__RateSucc__Group_1__0__Impl : ( 'rate' ) ;
    public final void rule__RateSucc__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4767:1: ( ( 'rate' ) )
            // InternalMyDsl.g:4768:1: ( 'rate' )
            {
            // InternalMyDsl.g:4768:1: ( 'rate' )
            // InternalMyDsl.g:4769:2: 'rate'
            {
             before(grammarAccess.getRateSuccAccess().getRateKeyword_1_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getRateSuccAccess().getRateKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RateSucc__Group_1__0__Impl"


    // $ANTLR start "rule__RateSucc__Group_1__1"
    // InternalMyDsl.g:4778:1: rule__RateSucc__Group_1__1 : rule__RateSucc__Group_1__1__Impl rule__RateSucc__Group_1__2 ;
    public final void rule__RateSucc__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4782:1: ( rule__RateSucc__Group_1__1__Impl rule__RateSucc__Group_1__2 )
            // InternalMyDsl.g:4783:2: rule__RateSucc__Group_1__1__Impl rule__RateSucc__Group_1__2
            {
            pushFollow(FOLLOW_42);
            rule__RateSucc__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RateSucc__Group_1__2();

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
    // $ANTLR end "rule__RateSucc__Group_1__1"


    // $ANTLR start "rule__RateSucc__Group_1__1__Impl"
    // InternalMyDsl.g:4790:1: rule__RateSucc__Group_1__1__Impl : ( 'of' ) ;
    public final void rule__RateSucc__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4794:1: ( ( 'of' ) )
            // InternalMyDsl.g:4795:1: ( 'of' )
            {
            // InternalMyDsl.g:4795:1: ( 'of' )
            // InternalMyDsl.g:4796:2: 'of'
            {
             before(grammarAccess.getRateSuccAccess().getOfKeyword_1_1()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getRateSuccAccess().getOfKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RateSucc__Group_1__1__Impl"


    // $ANTLR start "rule__RateSucc__Group_1__2"
    // InternalMyDsl.g:4805:1: rule__RateSucc__Group_1__2 : rule__RateSucc__Group_1__2__Impl rule__RateSucc__Group_1__3 ;
    public final void rule__RateSucc__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4809:1: ( rule__RateSucc__Group_1__2__Impl rule__RateSucc__Group_1__3 )
            // InternalMyDsl.g:4810:2: rule__RateSucc__Group_1__2__Impl rule__RateSucc__Group_1__3
            {
            pushFollow(FOLLOW_54);
            rule__RateSucc__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RateSucc__Group_1__3();

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
    // $ANTLR end "rule__RateSucc__Group_1__2"


    // $ANTLR start "rule__RateSucc__Group_1__2__Impl"
    // InternalMyDsl.g:4817:1: rule__RateSucc__Group_1__2__Impl : ( 'success' ) ;
    public final void rule__RateSucc__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4821:1: ( ( 'success' ) )
            // InternalMyDsl.g:4822:1: ( 'success' )
            {
            // InternalMyDsl.g:4822:1: ( 'success' )
            // InternalMyDsl.g:4823:2: 'success'
            {
             before(grammarAccess.getRateSuccAccess().getSuccessKeyword_1_2()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getRateSuccAccess().getSuccessKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RateSucc__Group_1__2__Impl"


    // $ANTLR start "rule__RateSucc__Group_1__3"
    // InternalMyDsl.g:4832:1: rule__RateSucc__Group_1__3 : rule__RateSucc__Group_1__3__Impl rule__RateSucc__Group_1__4 ;
    public final void rule__RateSucc__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4836:1: ( rule__RateSucc__Group_1__3__Impl rule__RateSucc__Group_1__4 )
            // InternalMyDsl.g:4837:2: rule__RateSucc__Group_1__3__Impl rule__RateSucc__Group_1__4
            {
            pushFollow(FOLLOW_55);
            rule__RateSucc__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RateSucc__Group_1__4();

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
    // $ANTLR end "rule__RateSucc__Group_1__3"


    // $ANTLR start "rule__RateSucc__Group_1__3__Impl"
    // InternalMyDsl.g:4844:1: rule__RateSucc__Group_1__3__Impl : ( 'greater' ) ;
    public final void rule__RateSucc__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4848:1: ( ( 'greater' ) )
            // InternalMyDsl.g:4849:1: ( 'greater' )
            {
            // InternalMyDsl.g:4849:1: ( 'greater' )
            // InternalMyDsl.g:4850:2: 'greater'
            {
             before(grammarAccess.getRateSuccAccess().getGreaterKeyword_1_3()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getRateSuccAccess().getGreaterKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RateSucc__Group_1__3__Impl"


    // $ANTLR start "rule__RateSucc__Group_1__4"
    // InternalMyDsl.g:4859:1: rule__RateSucc__Group_1__4 : rule__RateSucc__Group_1__4__Impl rule__RateSucc__Group_1__5 ;
    public final void rule__RateSucc__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4863:1: ( rule__RateSucc__Group_1__4__Impl rule__RateSucc__Group_1__5 )
            // InternalMyDsl.g:4864:2: rule__RateSucc__Group_1__4__Impl rule__RateSucc__Group_1__5
            {
            pushFollow(FOLLOW_16);
            rule__RateSucc__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RateSucc__Group_1__5();

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
    // $ANTLR end "rule__RateSucc__Group_1__4"


    // $ANTLR start "rule__RateSucc__Group_1__4__Impl"
    // InternalMyDsl.g:4871:1: rule__RateSucc__Group_1__4__Impl : ( 'than' ) ;
    public final void rule__RateSucc__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4875:1: ( ( 'than' ) )
            // InternalMyDsl.g:4876:1: ( 'than' )
            {
            // InternalMyDsl.g:4876:1: ( 'than' )
            // InternalMyDsl.g:4877:2: 'than'
            {
             before(grammarAccess.getRateSuccAccess().getThanKeyword_1_4()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getRateSuccAccess().getThanKeyword_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RateSucc__Group_1__4__Impl"


    // $ANTLR start "rule__RateSucc__Group_1__5"
    // InternalMyDsl.g:4886:1: rule__RateSucc__Group_1__5 : rule__RateSucc__Group_1__5__Impl ;
    public final void rule__RateSucc__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4890:1: ( rule__RateSucc__Group_1__5__Impl )
            // InternalMyDsl.g:4891:2: rule__RateSucc__Group_1__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RateSucc__Group_1__5__Impl();

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
    // $ANTLR end "rule__RateSucc__Group_1__5"


    // $ANTLR start "rule__RateSucc__Group_1__5__Impl"
    // InternalMyDsl.g:4897:1: rule__RateSucc__Group_1__5__Impl : ( ( rule__RateSucc__RateSuccAssignment_1_5 ) ) ;
    public final void rule__RateSucc__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4901:1: ( ( ( rule__RateSucc__RateSuccAssignment_1_5 ) ) )
            // InternalMyDsl.g:4902:1: ( ( rule__RateSucc__RateSuccAssignment_1_5 ) )
            {
            // InternalMyDsl.g:4902:1: ( ( rule__RateSucc__RateSuccAssignment_1_5 ) )
            // InternalMyDsl.g:4903:2: ( rule__RateSucc__RateSuccAssignment_1_5 )
            {
             before(grammarAccess.getRateSuccAccess().getRateSuccAssignment_1_5()); 
            // InternalMyDsl.g:4904:2: ( rule__RateSucc__RateSuccAssignment_1_5 )
            // InternalMyDsl.g:4904:3: rule__RateSucc__RateSuccAssignment_1_5
            {
            pushFollow(FOLLOW_2);
            rule__RateSucc__RateSuccAssignment_1_5();

            state._fsp--;


            }

             after(grammarAccess.getRateSuccAccess().getRateSuccAssignment_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RateSucc__Group_1__5__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group__0"
    // InternalMyDsl.g:4913:1: rule__SpaceXYRobot__Group__0 : rule__SpaceXYRobot__Group__0__Impl rule__SpaceXYRobot__Group__1 ;
    public final void rule__SpaceXYRobot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4917:1: ( rule__SpaceXYRobot__Group__0__Impl rule__SpaceXYRobot__Group__1 )
            // InternalMyDsl.g:4918:2: rule__SpaceXYRobot__Group__0__Impl rule__SpaceXYRobot__Group__1
            {
            pushFollow(FOLLOW_56);
            rule__SpaceXYRobot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group__1();

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
    // $ANTLR end "rule__SpaceXYRobot__Group__0"


    // $ANTLR start "rule__SpaceXYRobot__Group__0__Impl"
    // InternalMyDsl.g:4925:1: rule__SpaceXYRobot__Group__0__Impl : ( ( rule__SpaceXYRobot__Alternatives_0 ) ) ;
    public final void rule__SpaceXYRobot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4929:1: ( ( ( rule__SpaceXYRobot__Alternatives_0 ) ) )
            // InternalMyDsl.g:4930:1: ( ( rule__SpaceXYRobot__Alternatives_0 ) )
            {
            // InternalMyDsl.g:4930:1: ( ( rule__SpaceXYRobot__Alternatives_0 ) )
            // InternalMyDsl.g:4931:2: ( rule__SpaceXYRobot__Alternatives_0 )
            {
             before(grammarAccess.getSpaceXYRobotAccess().getAlternatives_0()); 
            // InternalMyDsl.g:4932:2: ( rule__SpaceXYRobot__Alternatives_0 )
            // InternalMyDsl.g:4932:3: rule__SpaceXYRobot__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getSpaceXYRobotAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group__0__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group__1"
    // InternalMyDsl.g:4940:1: rule__SpaceXYRobot__Group__1 : rule__SpaceXYRobot__Group__1__Impl rule__SpaceXYRobot__Group__2 ;
    public final void rule__SpaceXYRobot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4944:1: ( rule__SpaceXYRobot__Group__1__Impl rule__SpaceXYRobot__Group__2 )
            // InternalMyDsl.g:4945:2: rule__SpaceXYRobot__Group__1__Impl rule__SpaceXYRobot__Group__2
            {
            pushFollow(FOLLOW_57);
            rule__SpaceXYRobot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group__2();

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
    // $ANTLR end "rule__SpaceXYRobot__Group__1"


    // $ANTLR start "rule__SpaceXYRobot__Group__1__Impl"
    // InternalMyDsl.g:4952:1: rule__SpaceXYRobot__Group__1__Impl : ( 'work' ) ;
    public final void rule__SpaceXYRobot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4956:1: ( ( 'work' ) )
            // InternalMyDsl.g:4957:1: ( 'work' )
            {
            // InternalMyDsl.g:4957:1: ( 'work' )
            // InternalMyDsl.g:4958:2: 'work'
            {
             before(grammarAccess.getSpaceXYRobotAccess().getWorkKeyword_1()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getSpaceXYRobotAccess().getWorkKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group__1__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group__2"
    // InternalMyDsl.g:4967:1: rule__SpaceXYRobot__Group__2 : rule__SpaceXYRobot__Group__2__Impl rule__SpaceXYRobot__Group__3 ;
    public final void rule__SpaceXYRobot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4971:1: ( rule__SpaceXYRobot__Group__2__Impl rule__SpaceXYRobot__Group__3 )
            // InternalMyDsl.g:4972:2: rule__SpaceXYRobot__Group__2__Impl rule__SpaceXYRobot__Group__3
            {
            pushFollow(FOLLOW_58);
            rule__SpaceXYRobot__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group__3();

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
    // $ANTLR end "rule__SpaceXYRobot__Group__2"


    // $ANTLR start "rule__SpaceXYRobot__Group__2__Impl"
    // InternalMyDsl.g:4979:1: rule__SpaceXYRobot__Group__2__Impl : ( 'in' ) ;
    public final void rule__SpaceXYRobot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4983:1: ( ( 'in' ) )
            // InternalMyDsl.g:4984:1: ( 'in' )
            {
            // InternalMyDsl.g:4984:1: ( 'in' )
            // InternalMyDsl.g:4985:2: 'in'
            {
             before(grammarAccess.getSpaceXYRobotAccess().getInKeyword_2()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getSpaceXYRobotAccess().getInKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group__2__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group__3"
    // InternalMyDsl.g:4994:1: rule__SpaceXYRobot__Group__3 : rule__SpaceXYRobot__Group__3__Impl rule__SpaceXYRobot__Group__4 ;
    public final void rule__SpaceXYRobot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4998:1: ( rule__SpaceXYRobot__Group__3__Impl rule__SpaceXYRobot__Group__4 )
            // InternalMyDsl.g:4999:2: rule__SpaceXYRobot__Group__3__Impl rule__SpaceXYRobot__Group__4
            {
            pushFollow(FOLLOW_59);
            rule__SpaceXYRobot__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group__4();

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
    // $ANTLR end "rule__SpaceXYRobot__Group__3"


    // $ANTLR start "rule__SpaceXYRobot__Group__3__Impl"
    // InternalMyDsl.g:5006:1: rule__SpaceXYRobot__Group__3__Impl : ( ( rule__SpaceXYRobot__CoordinateAssignment_3 ) ) ;
    public final void rule__SpaceXYRobot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5010:1: ( ( ( rule__SpaceXYRobot__CoordinateAssignment_3 ) ) )
            // InternalMyDsl.g:5011:1: ( ( rule__SpaceXYRobot__CoordinateAssignment_3 ) )
            {
            // InternalMyDsl.g:5011:1: ( ( rule__SpaceXYRobot__CoordinateAssignment_3 ) )
            // InternalMyDsl.g:5012:2: ( rule__SpaceXYRobot__CoordinateAssignment_3 )
            {
             before(grammarAccess.getSpaceXYRobotAccess().getCoordinateAssignment_3()); 
            // InternalMyDsl.g:5013:2: ( rule__SpaceXYRobot__CoordinateAssignment_3 )
            // InternalMyDsl.g:5013:3: rule__SpaceXYRobot__CoordinateAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__CoordinateAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSpaceXYRobotAccess().getCoordinateAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group__3__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group__4"
    // InternalMyDsl.g:5021:1: rule__SpaceXYRobot__Group__4 : rule__SpaceXYRobot__Group__4__Impl rule__SpaceXYRobot__Group__5 ;
    public final void rule__SpaceXYRobot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5025:1: ( rule__SpaceXYRobot__Group__4__Impl rule__SpaceXYRobot__Group__5 )
            // InternalMyDsl.g:5026:2: rule__SpaceXYRobot__Group__4__Impl rule__SpaceXYRobot__Group__5
            {
            pushFollow(FOLLOW_55);
            rule__SpaceXYRobot__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group__5();

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
    // $ANTLR end "rule__SpaceXYRobot__Group__4"


    // $ANTLR start "rule__SpaceXYRobot__Group__4__Impl"
    // InternalMyDsl.g:5033:1: rule__SpaceXYRobot__Group__4__Impl : ( ( rule__SpaceXYRobot__LowerGreaterAssignment_4 ) ) ;
    public final void rule__SpaceXYRobot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5037:1: ( ( ( rule__SpaceXYRobot__LowerGreaterAssignment_4 ) ) )
            // InternalMyDsl.g:5038:1: ( ( rule__SpaceXYRobot__LowerGreaterAssignment_4 ) )
            {
            // InternalMyDsl.g:5038:1: ( ( rule__SpaceXYRobot__LowerGreaterAssignment_4 ) )
            // InternalMyDsl.g:5039:2: ( rule__SpaceXYRobot__LowerGreaterAssignment_4 )
            {
             before(grammarAccess.getSpaceXYRobotAccess().getLowerGreaterAssignment_4()); 
            // InternalMyDsl.g:5040:2: ( rule__SpaceXYRobot__LowerGreaterAssignment_4 )
            // InternalMyDsl.g:5040:3: rule__SpaceXYRobot__LowerGreaterAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__LowerGreaterAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSpaceXYRobotAccess().getLowerGreaterAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group__4__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group__5"
    // InternalMyDsl.g:5048:1: rule__SpaceXYRobot__Group__5 : rule__SpaceXYRobot__Group__5__Impl rule__SpaceXYRobot__Group__6 ;
    public final void rule__SpaceXYRobot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5052:1: ( rule__SpaceXYRobot__Group__5__Impl rule__SpaceXYRobot__Group__6 )
            // InternalMyDsl.g:5053:2: rule__SpaceXYRobot__Group__5__Impl rule__SpaceXYRobot__Group__6
            {
            pushFollow(FOLLOW_16);
            rule__SpaceXYRobot__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group__6();

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
    // $ANTLR end "rule__SpaceXYRobot__Group__5"


    // $ANTLR start "rule__SpaceXYRobot__Group__5__Impl"
    // InternalMyDsl.g:5060:1: rule__SpaceXYRobot__Group__5__Impl : ( 'than' ) ;
    public final void rule__SpaceXYRobot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5064:1: ( ( 'than' ) )
            // InternalMyDsl.g:5065:1: ( 'than' )
            {
            // InternalMyDsl.g:5065:1: ( 'than' )
            // InternalMyDsl.g:5066:2: 'than'
            {
             before(grammarAccess.getSpaceXYRobotAccess().getThanKeyword_5()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getSpaceXYRobotAccess().getThanKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group__5__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group__6"
    // InternalMyDsl.g:5075:1: rule__SpaceXYRobot__Group__6 : rule__SpaceXYRobot__Group__6__Impl ;
    public final void rule__SpaceXYRobot__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5079:1: ( rule__SpaceXYRobot__Group__6__Impl )
            // InternalMyDsl.g:5080:2: rule__SpaceXYRobot__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group__6__Impl();

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
    // $ANTLR end "rule__SpaceXYRobot__Group__6"


    // $ANTLR start "rule__SpaceXYRobot__Group__6__Impl"
    // InternalMyDsl.g:5086:1: rule__SpaceXYRobot__Group__6__Impl : ( ( rule__SpaceXYRobot__ValAssignment_6 ) ) ;
    public final void rule__SpaceXYRobot__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5090:1: ( ( ( rule__SpaceXYRobot__ValAssignment_6 ) ) )
            // InternalMyDsl.g:5091:1: ( ( rule__SpaceXYRobot__ValAssignment_6 ) )
            {
            // InternalMyDsl.g:5091:1: ( ( rule__SpaceXYRobot__ValAssignment_6 ) )
            // InternalMyDsl.g:5092:2: ( rule__SpaceXYRobot__ValAssignment_6 )
            {
             before(grammarAccess.getSpaceXYRobotAccess().getValAssignment_6()); 
            // InternalMyDsl.g:5093:2: ( rule__SpaceXYRobot__ValAssignment_6 )
            // InternalMyDsl.g:5093:3: rule__SpaceXYRobot__ValAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__ValAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getSpaceXYRobotAccess().getValAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group__6__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group_0_0__0"
    // InternalMyDsl.g:5102:1: rule__SpaceXYRobot__Group_0_0__0 : rule__SpaceXYRobot__Group_0_0__0__Impl rule__SpaceXYRobot__Group_0_0__1 ;
    public final void rule__SpaceXYRobot__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5106:1: ( rule__SpaceXYRobot__Group_0_0__0__Impl rule__SpaceXYRobot__Group_0_0__1 )
            // InternalMyDsl.g:5107:2: rule__SpaceXYRobot__Group_0_0__0__Impl rule__SpaceXYRobot__Group_0_0__1
            {
            pushFollow(FOLLOW_9);
            rule__SpaceXYRobot__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group_0_0__1();

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
    // $ANTLR end "rule__SpaceXYRobot__Group_0_0__0"


    // $ANTLR start "rule__SpaceXYRobot__Group_0_0__0__Impl"
    // InternalMyDsl.g:5114:1: rule__SpaceXYRobot__Group_0_0__0__Impl : ( 'robot' ) ;
    public final void rule__SpaceXYRobot__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5118:1: ( ( 'robot' ) )
            // InternalMyDsl.g:5119:1: ( 'robot' )
            {
            // InternalMyDsl.g:5119:1: ( 'robot' )
            // InternalMyDsl.g:5120:2: 'robot'
            {
             before(grammarAccess.getSpaceXYRobotAccess().getRobotKeyword_0_0_0()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getSpaceXYRobotAccess().getRobotKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group_0_0__0__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group_0_0__1"
    // InternalMyDsl.g:5129:1: rule__SpaceXYRobot__Group_0_0__1 : rule__SpaceXYRobot__Group_0_0__1__Impl ;
    public final void rule__SpaceXYRobot__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5133:1: ( rule__SpaceXYRobot__Group_0_0__1__Impl )
            // InternalMyDsl.g:5134:2: rule__SpaceXYRobot__Group_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group_0_0__1__Impl();

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
    // $ANTLR end "rule__SpaceXYRobot__Group_0_0__1"


    // $ANTLR start "rule__SpaceXYRobot__Group_0_0__1__Impl"
    // InternalMyDsl.g:5140:1: rule__SpaceXYRobot__Group_0_0__1__Impl : ( ( rule__SpaceXYRobot__RobotAssignment_0_0_1 ) ) ;
    public final void rule__SpaceXYRobot__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5144:1: ( ( ( rule__SpaceXYRobot__RobotAssignment_0_0_1 ) ) )
            // InternalMyDsl.g:5145:1: ( ( rule__SpaceXYRobot__RobotAssignment_0_0_1 ) )
            {
            // InternalMyDsl.g:5145:1: ( ( rule__SpaceXYRobot__RobotAssignment_0_0_1 ) )
            // InternalMyDsl.g:5146:2: ( rule__SpaceXYRobot__RobotAssignment_0_0_1 )
            {
             before(grammarAccess.getSpaceXYRobotAccess().getRobotAssignment_0_0_1()); 
            // InternalMyDsl.g:5147:2: ( rule__SpaceXYRobot__RobotAssignment_0_0_1 )
            // InternalMyDsl.g:5147:3: rule__SpaceXYRobot__RobotAssignment_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__RobotAssignment_0_0_1();

            state._fsp--;


            }

             after(grammarAccess.getSpaceXYRobotAccess().getRobotAssignment_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group_0_0__1__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group_0_1__0"
    // InternalMyDsl.g:5156:1: rule__SpaceXYRobot__Group_0_1__0 : rule__SpaceXYRobot__Group_0_1__0__Impl rule__SpaceXYRobot__Group_0_1__1 ;
    public final void rule__SpaceXYRobot__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5160:1: ( rule__SpaceXYRobot__Group_0_1__0__Impl rule__SpaceXYRobot__Group_0_1__1 )
            // InternalMyDsl.g:5161:2: rule__SpaceXYRobot__Group_0_1__0__Impl rule__SpaceXYRobot__Group_0_1__1
            {
            pushFollow(FOLLOW_60);
            rule__SpaceXYRobot__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group_0_1__1();

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
    // $ANTLR end "rule__SpaceXYRobot__Group_0_1__0"


    // $ANTLR start "rule__SpaceXYRobot__Group_0_1__0__Impl"
    // InternalMyDsl.g:5168:1: rule__SpaceXYRobot__Group_0_1__0__Impl : ( ( rule__SpaceXYRobot__AllrobotsAssignment_0_1_0 ) ) ;
    public final void rule__SpaceXYRobot__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5172:1: ( ( ( rule__SpaceXYRobot__AllrobotsAssignment_0_1_0 ) ) )
            // InternalMyDsl.g:5173:1: ( ( rule__SpaceXYRobot__AllrobotsAssignment_0_1_0 ) )
            {
            // InternalMyDsl.g:5173:1: ( ( rule__SpaceXYRobot__AllrobotsAssignment_0_1_0 ) )
            // InternalMyDsl.g:5174:2: ( rule__SpaceXYRobot__AllrobotsAssignment_0_1_0 )
            {
             before(grammarAccess.getSpaceXYRobotAccess().getAllrobotsAssignment_0_1_0()); 
            // InternalMyDsl.g:5175:2: ( rule__SpaceXYRobot__AllrobotsAssignment_0_1_0 )
            // InternalMyDsl.g:5175:3: rule__SpaceXYRobot__AllrobotsAssignment_0_1_0
            {
            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__AllrobotsAssignment_0_1_0();

            state._fsp--;


            }

             after(grammarAccess.getSpaceXYRobotAccess().getAllrobotsAssignment_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group_0_1__0__Impl"


    // $ANTLR start "rule__SpaceXYRobot__Group_0_1__1"
    // InternalMyDsl.g:5183:1: rule__SpaceXYRobot__Group_0_1__1 : rule__SpaceXYRobot__Group_0_1__1__Impl ;
    public final void rule__SpaceXYRobot__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5187:1: ( rule__SpaceXYRobot__Group_0_1__1__Impl )
            // InternalMyDsl.g:5188:2: rule__SpaceXYRobot__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SpaceXYRobot__Group_0_1__1__Impl();

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
    // $ANTLR end "rule__SpaceXYRobot__Group_0_1__1"


    // $ANTLR start "rule__SpaceXYRobot__Group_0_1__1__Impl"
    // InternalMyDsl.g:5194:1: rule__SpaceXYRobot__Group_0_1__1__Impl : ( 'robots' ) ;
    public final void rule__SpaceXYRobot__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5198:1: ( ( 'robots' ) )
            // InternalMyDsl.g:5199:1: ( 'robots' )
            {
            // InternalMyDsl.g:5199:1: ( 'robots' )
            // InternalMyDsl.g:5200:2: 'robots'
            {
             before(grammarAccess.getSpaceXYRobotAccess().getRobotsKeyword_0_1_1()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getSpaceXYRobotAccess().getRobotsKeyword_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__Group_0_1__1__Impl"


    // $ANTLR start "rule__TaskTime__Group__0"
    // InternalMyDsl.g:5210:1: rule__TaskTime__Group__0 : rule__TaskTime__Group__0__Impl rule__TaskTime__Group__1 ;
    public final void rule__TaskTime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5214:1: ( rule__TaskTime__Group__0__Impl rule__TaskTime__Group__1 )
            // InternalMyDsl.g:5215:2: rule__TaskTime__Group__0__Impl rule__TaskTime__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__TaskTime__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TaskTime__Group__1();

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
    // $ANTLR end "rule__TaskTime__Group__0"


    // $ANTLR start "rule__TaskTime__Group__0__Impl"
    // InternalMyDsl.g:5222:1: rule__TaskTime__Group__0__Impl : ( ( rule__TaskTime__Alternatives_0 ) ) ;
    public final void rule__TaskTime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5226:1: ( ( ( rule__TaskTime__Alternatives_0 ) ) )
            // InternalMyDsl.g:5227:1: ( ( rule__TaskTime__Alternatives_0 ) )
            {
            // InternalMyDsl.g:5227:1: ( ( rule__TaskTime__Alternatives_0 ) )
            // InternalMyDsl.g:5228:2: ( rule__TaskTime__Alternatives_0 )
            {
             before(grammarAccess.getTaskTimeAccess().getAlternatives_0()); 
            // InternalMyDsl.g:5229:2: ( rule__TaskTime__Alternatives_0 )
            // InternalMyDsl.g:5229:3: rule__TaskTime__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTaskTimeAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group__0__Impl"


    // $ANTLR start "rule__TaskTime__Group__1"
    // InternalMyDsl.g:5237:1: rule__TaskTime__Group__1 : rule__TaskTime__Group__1__Impl rule__TaskTime__Group__2 ;
    public final void rule__TaskTime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5241:1: ( rule__TaskTime__Group__1__Impl rule__TaskTime__Group__2 )
            // InternalMyDsl.g:5242:2: rule__TaskTime__Group__1__Impl rule__TaskTime__Group__2
            {
            pushFollow(FOLLOW_61);
            rule__TaskTime__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TaskTime__Group__2();

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
    // $ANTLR end "rule__TaskTime__Group__1"


    // $ANTLR start "rule__TaskTime__Group__1__Impl"
    // InternalMyDsl.g:5249:1: rule__TaskTime__Group__1__Impl : ( 'with' ) ;
    public final void rule__TaskTime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5253:1: ( ( 'with' ) )
            // InternalMyDsl.g:5254:1: ( 'with' )
            {
            // InternalMyDsl.g:5254:1: ( 'with' )
            // InternalMyDsl.g:5255:2: 'with'
            {
             before(grammarAccess.getTaskTimeAccess().getWithKeyword_1()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getTaskTimeAccess().getWithKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group__1__Impl"


    // $ANTLR start "rule__TaskTime__Group__2"
    // InternalMyDsl.g:5264:1: rule__TaskTime__Group__2 : rule__TaskTime__Group__2__Impl rule__TaskTime__Group__3 ;
    public final void rule__TaskTime__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5268:1: ( rule__TaskTime__Group__2__Impl rule__TaskTime__Group__3 )
            // InternalMyDsl.g:5269:2: rule__TaskTime__Group__2__Impl rule__TaskTime__Group__3
            {
            pushFollow(FOLLOW_62);
            rule__TaskTime__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TaskTime__Group__3();

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
    // $ANTLR end "rule__TaskTime__Group__2"


    // $ANTLR start "rule__TaskTime__Group__2__Impl"
    // InternalMyDsl.g:5276:1: rule__TaskTime__Group__2__Impl : ( ( rule__TaskTime__StartEndAssignment_2 ) ) ;
    public final void rule__TaskTime__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5280:1: ( ( ( rule__TaskTime__StartEndAssignment_2 ) ) )
            // InternalMyDsl.g:5281:1: ( ( rule__TaskTime__StartEndAssignment_2 ) )
            {
            // InternalMyDsl.g:5281:1: ( ( rule__TaskTime__StartEndAssignment_2 ) )
            // InternalMyDsl.g:5282:2: ( rule__TaskTime__StartEndAssignment_2 )
            {
             before(grammarAccess.getTaskTimeAccess().getStartEndAssignment_2()); 
            // InternalMyDsl.g:5283:2: ( rule__TaskTime__StartEndAssignment_2 )
            // InternalMyDsl.g:5283:3: rule__TaskTime__StartEndAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__StartEndAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTaskTimeAccess().getStartEndAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group__2__Impl"


    // $ANTLR start "rule__TaskTime__Group__3"
    // InternalMyDsl.g:5291:1: rule__TaskTime__Group__3 : rule__TaskTime__Group__3__Impl rule__TaskTime__Group__4 ;
    public final void rule__TaskTime__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5295:1: ( rule__TaskTime__Group__3__Impl rule__TaskTime__Group__4 )
            // InternalMyDsl.g:5296:2: rule__TaskTime__Group__3__Impl rule__TaskTime__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__TaskTime__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TaskTime__Group__4();

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
    // $ANTLR end "rule__TaskTime__Group__3"


    // $ANTLR start "rule__TaskTime__Group__3__Impl"
    // InternalMyDsl.g:5303:1: rule__TaskTime__Group__3__Impl : ( 'time' ) ;
    public final void rule__TaskTime__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5307:1: ( ( 'time' ) )
            // InternalMyDsl.g:5308:1: ( 'time' )
            {
            // InternalMyDsl.g:5308:1: ( 'time' )
            // InternalMyDsl.g:5309:2: 'time'
            {
             before(grammarAccess.getTaskTimeAccess().getTimeKeyword_3()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getTaskTimeAccess().getTimeKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group__3__Impl"


    // $ANTLR start "rule__TaskTime__Group__4"
    // InternalMyDsl.g:5318:1: rule__TaskTime__Group__4 : rule__TaskTime__Group__4__Impl ;
    public final void rule__TaskTime__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5322:1: ( rule__TaskTime__Group__4__Impl )
            // InternalMyDsl.g:5323:2: rule__TaskTime__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__Group__4__Impl();

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
    // $ANTLR end "rule__TaskTime__Group__4"


    // $ANTLR start "rule__TaskTime__Group__4__Impl"
    // InternalMyDsl.g:5329:1: rule__TaskTime__Group__4__Impl : ( ( rule__TaskTime__TimeAssignment_4 ) ) ;
    public final void rule__TaskTime__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5333:1: ( ( ( rule__TaskTime__TimeAssignment_4 ) ) )
            // InternalMyDsl.g:5334:1: ( ( rule__TaskTime__TimeAssignment_4 ) )
            {
            // InternalMyDsl.g:5334:1: ( ( rule__TaskTime__TimeAssignment_4 ) )
            // InternalMyDsl.g:5335:2: ( rule__TaskTime__TimeAssignment_4 )
            {
             before(grammarAccess.getTaskTimeAccess().getTimeAssignment_4()); 
            // InternalMyDsl.g:5336:2: ( rule__TaskTime__TimeAssignment_4 )
            // InternalMyDsl.g:5336:3: rule__TaskTime__TimeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__TimeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTaskTimeAccess().getTimeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group__4__Impl"


    // $ANTLR start "rule__TaskTime__Group_0_0__0"
    // InternalMyDsl.g:5345:1: rule__TaskTime__Group_0_0__0 : rule__TaskTime__Group_0_0__0__Impl rule__TaskTime__Group_0_0__1 ;
    public final void rule__TaskTime__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5349:1: ( rule__TaskTime__Group_0_0__0__Impl rule__TaskTime__Group_0_0__1 )
            // InternalMyDsl.g:5350:2: rule__TaskTime__Group_0_0__0__Impl rule__TaskTime__Group_0_0__1
            {
            pushFollow(FOLLOW_51);
            rule__TaskTime__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TaskTime__Group_0_0__1();

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
    // $ANTLR end "rule__TaskTime__Group_0_0__0"


    // $ANTLR start "rule__TaskTime__Group_0_0__0__Impl"
    // InternalMyDsl.g:5357:1: rule__TaskTime__Group_0_0__0__Impl : ( 'atomic' ) ;
    public final void rule__TaskTime__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5361:1: ( ( 'atomic' ) )
            // InternalMyDsl.g:5362:1: ( 'atomic' )
            {
            // InternalMyDsl.g:5362:1: ( 'atomic' )
            // InternalMyDsl.g:5363:2: 'atomic'
            {
             before(grammarAccess.getTaskTimeAccess().getAtomicKeyword_0_0_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getTaskTimeAccess().getAtomicKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group_0_0__0__Impl"


    // $ANTLR start "rule__TaskTime__Group_0_0__1"
    // InternalMyDsl.g:5372:1: rule__TaskTime__Group_0_0__1 : rule__TaskTime__Group_0_0__1__Impl rule__TaskTime__Group_0_0__2 ;
    public final void rule__TaskTime__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5376:1: ( rule__TaskTime__Group_0_0__1__Impl rule__TaskTime__Group_0_0__2 )
            // InternalMyDsl.g:5377:2: rule__TaskTime__Group_0_0__1__Impl rule__TaskTime__Group_0_0__2
            {
            pushFollow(FOLLOW_9);
            rule__TaskTime__Group_0_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TaskTime__Group_0_0__2();

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
    // $ANTLR end "rule__TaskTime__Group_0_0__1"


    // $ANTLR start "rule__TaskTime__Group_0_0__1__Impl"
    // InternalMyDsl.g:5384:1: rule__TaskTime__Group_0_0__1__Impl : ( 'task' ) ;
    public final void rule__TaskTime__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5388:1: ( ( 'task' ) )
            // InternalMyDsl.g:5389:1: ( 'task' )
            {
            // InternalMyDsl.g:5389:1: ( 'task' )
            // InternalMyDsl.g:5390:2: 'task'
            {
             before(grammarAccess.getTaskTimeAccess().getTaskKeyword_0_0_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getTaskTimeAccess().getTaskKeyword_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group_0_0__1__Impl"


    // $ANTLR start "rule__TaskTime__Group_0_0__2"
    // InternalMyDsl.g:5399:1: rule__TaskTime__Group_0_0__2 : rule__TaskTime__Group_0_0__2__Impl ;
    public final void rule__TaskTime__Group_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5403:1: ( rule__TaskTime__Group_0_0__2__Impl )
            // InternalMyDsl.g:5404:2: rule__TaskTime__Group_0_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__Group_0_0__2__Impl();

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
    // $ANTLR end "rule__TaskTime__Group_0_0__2"


    // $ANTLR start "rule__TaskTime__Group_0_0__2__Impl"
    // InternalMyDsl.g:5410:1: rule__TaskTime__Group_0_0__2__Impl : ( ( rule__TaskTime__AtAssignment_0_0_2 ) ) ;
    public final void rule__TaskTime__Group_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5414:1: ( ( ( rule__TaskTime__AtAssignment_0_0_2 ) ) )
            // InternalMyDsl.g:5415:1: ( ( rule__TaskTime__AtAssignment_0_0_2 ) )
            {
            // InternalMyDsl.g:5415:1: ( ( rule__TaskTime__AtAssignment_0_0_2 ) )
            // InternalMyDsl.g:5416:2: ( rule__TaskTime__AtAssignment_0_0_2 )
            {
             before(grammarAccess.getTaskTimeAccess().getAtAssignment_0_0_2()); 
            // InternalMyDsl.g:5417:2: ( rule__TaskTime__AtAssignment_0_0_2 )
            // InternalMyDsl.g:5417:3: rule__TaskTime__AtAssignment_0_0_2
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__AtAssignment_0_0_2();

            state._fsp--;


            }

             after(grammarAccess.getTaskTimeAccess().getAtAssignment_0_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group_0_0__2__Impl"


    // $ANTLR start "rule__TaskTime__Group_0_1__0"
    // InternalMyDsl.g:5426:1: rule__TaskTime__Group_0_1__0 : rule__TaskTime__Group_0_1__0__Impl rule__TaskTime__Group_0_1__1 ;
    public final void rule__TaskTime__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5430:1: ( rule__TaskTime__Group_0_1__0__Impl rule__TaskTime__Group_0_1__1 )
            // InternalMyDsl.g:5431:2: rule__TaskTime__Group_0_1__0__Impl rule__TaskTime__Group_0_1__1
            {
            pushFollow(FOLLOW_51);
            rule__TaskTime__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TaskTime__Group_0_1__1();

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
    // $ANTLR end "rule__TaskTime__Group_0_1__0"


    // $ANTLR start "rule__TaskTime__Group_0_1__0__Impl"
    // InternalMyDsl.g:5438:1: rule__TaskTime__Group_0_1__0__Impl : ( 'compound' ) ;
    public final void rule__TaskTime__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5442:1: ( ( 'compound' ) )
            // InternalMyDsl.g:5443:1: ( 'compound' )
            {
            // InternalMyDsl.g:5443:1: ( 'compound' )
            // InternalMyDsl.g:5444:2: 'compound'
            {
             before(grammarAccess.getTaskTimeAccess().getCompoundKeyword_0_1_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getTaskTimeAccess().getCompoundKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group_0_1__0__Impl"


    // $ANTLR start "rule__TaskTime__Group_0_1__1"
    // InternalMyDsl.g:5453:1: rule__TaskTime__Group_0_1__1 : rule__TaskTime__Group_0_1__1__Impl rule__TaskTime__Group_0_1__2 ;
    public final void rule__TaskTime__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5457:1: ( rule__TaskTime__Group_0_1__1__Impl rule__TaskTime__Group_0_1__2 )
            // InternalMyDsl.g:5458:2: rule__TaskTime__Group_0_1__1__Impl rule__TaskTime__Group_0_1__2
            {
            pushFollow(FOLLOW_9);
            rule__TaskTime__Group_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TaskTime__Group_0_1__2();

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
    // $ANTLR end "rule__TaskTime__Group_0_1__1"


    // $ANTLR start "rule__TaskTime__Group_0_1__1__Impl"
    // InternalMyDsl.g:5465:1: rule__TaskTime__Group_0_1__1__Impl : ( 'task' ) ;
    public final void rule__TaskTime__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5469:1: ( ( 'task' ) )
            // InternalMyDsl.g:5470:1: ( 'task' )
            {
            // InternalMyDsl.g:5470:1: ( 'task' )
            // InternalMyDsl.g:5471:2: 'task'
            {
             before(grammarAccess.getTaskTimeAccess().getTaskKeyword_0_1_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getTaskTimeAccess().getTaskKeyword_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group_0_1__1__Impl"


    // $ANTLR start "rule__TaskTime__Group_0_1__2"
    // InternalMyDsl.g:5480:1: rule__TaskTime__Group_0_1__2 : rule__TaskTime__Group_0_1__2__Impl ;
    public final void rule__TaskTime__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5484:1: ( rule__TaskTime__Group_0_1__2__Impl )
            // InternalMyDsl.g:5485:2: rule__TaskTime__Group_0_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__Group_0_1__2__Impl();

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
    // $ANTLR end "rule__TaskTime__Group_0_1__2"


    // $ANTLR start "rule__TaskTime__Group_0_1__2__Impl"
    // InternalMyDsl.g:5491:1: rule__TaskTime__Group_0_1__2__Impl : ( ( rule__TaskTime__CtAssignment_0_1_2 ) ) ;
    public final void rule__TaskTime__Group_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5495:1: ( ( ( rule__TaskTime__CtAssignment_0_1_2 ) ) )
            // InternalMyDsl.g:5496:1: ( ( rule__TaskTime__CtAssignment_0_1_2 ) )
            {
            // InternalMyDsl.g:5496:1: ( ( rule__TaskTime__CtAssignment_0_1_2 ) )
            // InternalMyDsl.g:5497:2: ( rule__TaskTime__CtAssignment_0_1_2 )
            {
             before(grammarAccess.getTaskTimeAccess().getCtAssignment_0_1_2()); 
            // InternalMyDsl.g:5498:2: ( rule__TaskTime__CtAssignment_0_1_2 )
            // InternalMyDsl.g:5498:3: rule__TaskTime__CtAssignment_0_1_2
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__CtAssignment_0_1_2();

            state._fsp--;


            }

             after(grammarAccess.getTaskTimeAccess().getCtAssignment_0_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group_0_1__2__Impl"


    // $ANTLR start "rule__TaskTime__Group_0_2__0"
    // InternalMyDsl.g:5507:1: rule__TaskTime__Group_0_2__0 : rule__TaskTime__Group_0_2__0__Impl rule__TaskTime__Group_0_2__1 ;
    public final void rule__TaskTime__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5511:1: ( rule__TaskTime__Group_0_2__0__Impl rule__TaskTime__Group_0_2__1 )
            // InternalMyDsl.g:5512:2: rule__TaskTime__Group_0_2__0__Impl rule__TaskTime__Group_0_2__1
            {
            pushFollow(FOLLOW_51);
            rule__TaskTime__Group_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TaskTime__Group_0_2__1();

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
    // $ANTLR end "rule__TaskTime__Group_0_2__0"


    // $ANTLR start "rule__TaskTime__Group_0_2__0__Impl"
    // InternalMyDsl.g:5519:1: rule__TaskTime__Group_0_2__0__Impl : ( 'mission' ) ;
    public final void rule__TaskTime__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5523:1: ( ( 'mission' ) )
            // InternalMyDsl.g:5524:1: ( 'mission' )
            {
            // InternalMyDsl.g:5524:1: ( 'mission' )
            // InternalMyDsl.g:5525:2: 'mission'
            {
             before(grammarAccess.getTaskTimeAccess().getMissionKeyword_0_2_0()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getTaskTimeAccess().getMissionKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group_0_2__0__Impl"


    // $ANTLR start "rule__TaskTime__Group_0_2__1"
    // InternalMyDsl.g:5534:1: rule__TaskTime__Group_0_2__1 : rule__TaskTime__Group_0_2__1__Impl rule__TaskTime__Group_0_2__2 ;
    public final void rule__TaskTime__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5538:1: ( rule__TaskTime__Group_0_2__1__Impl rule__TaskTime__Group_0_2__2 )
            // InternalMyDsl.g:5539:2: rule__TaskTime__Group_0_2__1__Impl rule__TaskTime__Group_0_2__2
            {
            pushFollow(FOLLOW_9);
            rule__TaskTime__Group_0_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TaskTime__Group_0_2__2();

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
    // $ANTLR end "rule__TaskTime__Group_0_2__1"


    // $ANTLR start "rule__TaskTime__Group_0_2__1__Impl"
    // InternalMyDsl.g:5546:1: rule__TaskTime__Group_0_2__1__Impl : ( 'task' ) ;
    public final void rule__TaskTime__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5550:1: ( ( 'task' ) )
            // InternalMyDsl.g:5551:1: ( 'task' )
            {
            // InternalMyDsl.g:5551:1: ( 'task' )
            // InternalMyDsl.g:5552:2: 'task'
            {
             before(grammarAccess.getTaskTimeAccess().getTaskKeyword_0_2_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getTaskTimeAccess().getTaskKeyword_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group_0_2__1__Impl"


    // $ANTLR start "rule__TaskTime__Group_0_2__2"
    // InternalMyDsl.g:5561:1: rule__TaskTime__Group_0_2__2 : rule__TaskTime__Group_0_2__2__Impl ;
    public final void rule__TaskTime__Group_0_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5565:1: ( rule__TaskTime__Group_0_2__2__Impl )
            // InternalMyDsl.g:5566:2: rule__TaskTime__Group_0_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__Group_0_2__2__Impl();

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
    // $ANTLR end "rule__TaskTime__Group_0_2__2"


    // $ANTLR start "rule__TaskTime__Group_0_2__2__Impl"
    // InternalMyDsl.g:5572:1: rule__TaskTime__Group_0_2__2__Impl : ( ( rule__TaskTime__MtAssignment_0_2_2 ) ) ;
    public final void rule__TaskTime__Group_0_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5576:1: ( ( ( rule__TaskTime__MtAssignment_0_2_2 ) ) )
            // InternalMyDsl.g:5577:1: ( ( rule__TaskTime__MtAssignment_0_2_2 ) )
            {
            // InternalMyDsl.g:5577:1: ( ( rule__TaskTime__MtAssignment_0_2_2 ) )
            // InternalMyDsl.g:5578:2: ( rule__TaskTime__MtAssignment_0_2_2 )
            {
             before(grammarAccess.getTaskTimeAccess().getMtAssignment_0_2_2()); 
            // InternalMyDsl.g:5579:2: ( rule__TaskTime__MtAssignment_0_2_2 )
            // InternalMyDsl.g:5579:3: rule__TaskTime__MtAssignment_0_2_2
            {
            pushFollow(FOLLOW_2);
            rule__TaskTime__MtAssignment_0_2_2();

            state._fsp--;


            }

             after(grammarAccess.getTaskTimeAccess().getMtAssignment_0_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__Group_0_2__2__Impl"


    // $ANTLR start "rule__AllocateT__Group__0"
    // InternalMyDsl.g:5588:1: rule__AllocateT__Group__0 : rule__AllocateT__Group__0__Impl rule__AllocateT__Group__1 ;
    public final void rule__AllocateT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5592:1: ( rule__AllocateT__Group__0__Impl rule__AllocateT__Group__1 )
            // InternalMyDsl.g:5593:2: rule__AllocateT__Group__0__Impl rule__AllocateT__Group__1
            {
            pushFollow(FOLLOW_63);
            rule__AllocateT__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllocateT__Group__1();

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
    // $ANTLR end "rule__AllocateT__Group__0"


    // $ANTLR start "rule__AllocateT__Group__0__Impl"
    // InternalMyDsl.g:5600:1: rule__AllocateT__Group__0__Impl : ( 'allocate' ) ;
    public final void rule__AllocateT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5604:1: ( ( 'allocate' ) )
            // InternalMyDsl.g:5605:1: ( 'allocate' )
            {
            // InternalMyDsl.g:5605:1: ( 'allocate' )
            // InternalMyDsl.g:5606:2: 'allocate'
            {
             before(grammarAccess.getAllocateTAccess().getAllocateKeyword_0()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getAllocateTAccess().getAllocateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group__0__Impl"


    // $ANTLR start "rule__AllocateT__Group__1"
    // InternalMyDsl.g:5615:1: rule__AllocateT__Group__1 : rule__AllocateT__Group__1__Impl rule__AllocateT__Group__2 ;
    public final void rule__AllocateT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5619:1: ( rule__AllocateT__Group__1__Impl rule__AllocateT__Group__2 )
            // InternalMyDsl.g:5620:2: rule__AllocateT__Group__1__Impl rule__AllocateT__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__AllocateT__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllocateT__Group__2();

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
    // $ANTLR end "rule__AllocateT__Group__1"


    // $ANTLR start "rule__AllocateT__Group__1__Impl"
    // InternalMyDsl.g:5627:1: rule__AllocateT__Group__1__Impl : ( ( rule__AllocateT__Alternatives_1 ) ) ;
    public final void rule__AllocateT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5631:1: ( ( ( rule__AllocateT__Alternatives_1 ) ) )
            // InternalMyDsl.g:5632:1: ( ( rule__AllocateT__Alternatives_1 ) )
            {
            // InternalMyDsl.g:5632:1: ( ( rule__AllocateT__Alternatives_1 ) )
            // InternalMyDsl.g:5633:2: ( rule__AllocateT__Alternatives_1 )
            {
             before(grammarAccess.getAllocateTAccess().getAlternatives_1()); 
            // InternalMyDsl.g:5634:2: ( rule__AllocateT__Alternatives_1 )
            // InternalMyDsl.g:5634:3: rule__AllocateT__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__AllocateT__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getAllocateTAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group__1__Impl"


    // $ANTLR start "rule__AllocateT__Group__2"
    // InternalMyDsl.g:5642:1: rule__AllocateT__Group__2 : rule__AllocateT__Group__2__Impl rule__AllocateT__Group__3 ;
    public final void rule__AllocateT__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5646:1: ( rule__AllocateT__Group__2__Impl rule__AllocateT__Group__3 )
            // InternalMyDsl.g:5647:2: rule__AllocateT__Group__2__Impl rule__AllocateT__Group__3
            {
            pushFollow(FOLLOW_64);
            rule__AllocateT__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllocateT__Group__3();

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
    // $ANTLR end "rule__AllocateT__Group__2"


    // $ANTLR start "rule__AllocateT__Group__2__Impl"
    // InternalMyDsl.g:5654:1: rule__AllocateT__Group__2__Impl : ( 'to' ) ;
    public final void rule__AllocateT__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5658:1: ( ( 'to' ) )
            // InternalMyDsl.g:5659:1: ( 'to' )
            {
            // InternalMyDsl.g:5659:1: ( 'to' )
            // InternalMyDsl.g:5660:2: 'to'
            {
             before(grammarAccess.getAllocateTAccess().getToKeyword_2()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getAllocateTAccess().getToKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group__2__Impl"


    // $ANTLR start "rule__AllocateT__Group__3"
    // InternalMyDsl.g:5669:1: rule__AllocateT__Group__3 : rule__AllocateT__Group__3__Impl rule__AllocateT__Group__4 ;
    public final void rule__AllocateT__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5673:1: ( rule__AllocateT__Group__3__Impl rule__AllocateT__Group__4 )
            // InternalMyDsl.g:5674:2: rule__AllocateT__Group__3__Impl rule__AllocateT__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__AllocateT__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllocateT__Group__4();

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
    // $ANTLR end "rule__AllocateT__Group__3"


    // $ANTLR start "rule__AllocateT__Group__3__Impl"
    // InternalMyDsl.g:5681:1: rule__AllocateT__Group__3__Impl : ( 'robot' ) ;
    public final void rule__AllocateT__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5685:1: ( ( 'robot' ) )
            // InternalMyDsl.g:5686:1: ( 'robot' )
            {
            // InternalMyDsl.g:5686:1: ( 'robot' )
            // InternalMyDsl.g:5687:2: 'robot'
            {
             before(grammarAccess.getAllocateTAccess().getRobotKeyword_3()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getAllocateTAccess().getRobotKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group__3__Impl"


    // $ANTLR start "rule__AllocateT__Group__4"
    // InternalMyDsl.g:5696:1: rule__AllocateT__Group__4 : rule__AllocateT__Group__4__Impl ;
    public final void rule__AllocateT__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5700:1: ( rule__AllocateT__Group__4__Impl )
            // InternalMyDsl.g:5701:2: rule__AllocateT__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AllocateT__Group__4__Impl();

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
    // $ANTLR end "rule__AllocateT__Group__4"


    // $ANTLR start "rule__AllocateT__Group__4__Impl"
    // InternalMyDsl.g:5707:1: rule__AllocateT__Group__4__Impl : ( ( rule__AllocateT__RobotAssignment_4 ) ) ;
    public final void rule__AllocateT__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5711:1: ( ( ( rule__AllocateT__RobotAssignment_4 ) ) )
            // InternalMyDsl.g:5712:1: ( ( rule__AllocateT__RobotAssignment_4 ) )
            {
            // InternalMyDsl.g:5712:1: ( ( rule__AllocateT__RobotAssignment_4 ) )
            // InternalMyDsl.g:5713:2: ( rule__AllocateT__RobotAssignment_4 )
            {
             before(grammarAccess.getAllocateTAccess().getRobotAssignment_4()); 
            // InternalMyDsl.g:5714:2: ( rule__AllocateT__RobotAssignment_4 )
            // InternalMyDsl.g:5714:3: rule__AllocateT__RobotAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__AllocateT__RobotAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getAllocateTAccess().getRobotAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group__4__Impl"


    // $ANTLR start "rule__AllocateT__Group_1_0__0"
    // InternalMyDsl.g:5723:1: rule__AllocateT__Group_1_0__0 : rule__AllocateT__Group_1_0__0__Impl rule__AllocateT__Group_1_0__1 ;
    public final void rule__AllocateT__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5727:1: ( rule__AllocateT__Group_1_0__0__Impl rule__AllocateT__Group_1_0__1 )
            // InternalMyDsl.g:5728:2: rule__AllocateT__Group_1_0__0__Impl rule__AllocateT__Group_1_0__1
            {
            pushFollow(FOLLOW_51);
            rule__AllocateT__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllocateT__Group_1_0__1();

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
    // $ANTLR end "rule__AllocateT__Group_1_0__0"


    // $ANTLR start "rule__AllocateT__Group_1_0__0__Impl"
    // InternalMyDsl.g:5735:1: rule__AllocateT__Group_1_0__0__Impl : ( 'atomic' ) ;
    public final void rule__AllocateT__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5739:1: ( ( 'atomic' ) )
            // InternalMyDsl.g:5740:1: ( 'atomic' )
            {
            // InternalMyDsl.g:5740:1: ( 'atomic' )
            // InternalMyDsl.g:5741:2: 'atomic'
            {
             before(grammarAccess.getAllocateTAccess().getAtomicKeyword_1_0_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getAllocateTAccess().getAtomicKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group_1_0__0__Impl"


    // $ANTLR start "rule__AllocateT__Group_1_0__1"
    // InternalMyDsl.g:5750:1: rule__AllocateT__Group_1_0__1 : rule__AllocateT__Group_1_0__1__Impl rule__AllocateT__Group_1_0__2 ;
    public final void rule__AllocateT__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5754:1: ( rule__AllocateT__Group_1_0__1__Impl rule__AllocateT__Group_1_0__2 )
            // InternalMyDsl.g:5755:2: rule__AllocateT__Group_1_0__1__Impl rule__AllocateT__Group_1_0__2
            {
            pushFollow(FOLLOW_9);
            rule__AllocateT__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllocateT__Group_1_0__2();

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
    // $ANTLR end "rule__AllocateT__Group_1_0__1"


    // $ANTLR start "rule__AllocateT__Group_1_0__1__Impl"
    // InternalMyDsl.g:5762:1: rule__AllocateT__Group_1_0__1__Impl : ( 'task' ) ;
    public final void rule__AllocateT__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5766:1: ( ( 'task' ) )
            // InternalMyDsl.g:5767:1: ( 'task' )
            {
            // InternalMyDsl.g:5767:1: ( 'task' )
            // InternalMyDsl.g:5768:2: 'task'
            {
             before(grammarAccess.getAllocateTAccess().getTaskKeyword_1_0_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getAllocateTAccess().getTaskKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group_1_0__1__Impl"


    // $ANTLR start "rule__AllocateT__Group_1_0__2"
    // InternalMyDsl.g:5777:1: rule__AllocateT__Group_1_0__2 : rule__AllocateT__Group_1_0__2__Impl ;
    public final void rule__AllocateT__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5781:1: ( rule__AllocateT__Group_1_0__2__Impl )
            // InternalMyDsl.g:5782:2: rule__AllocateT__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AllocateT__Group_1_0__2__Impl();

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
    // $ANTLR end "rule__AllocateT__Group_1_0__2"


    // $ANTLR start "rule__AllocateT__Group_1_0__2__Impl"
    // InternalMyDsl.g:5788:1: rule__AllocateT__Group_1_0__2__Impl : ( ( rule__AllocateT__AtAssignment_1_0_2 ) ) ;
    public final void rule__AllocateT__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5792:1: ( ( ( rule__AllocateT__AtAssignment_1_0_2 ) ) )
            // InternalMyDsl.g:5793:1: ( ( rule__AllocateT__AtAssignment_1_0_2 ) )
            {
            // InternalMyDsl.g:5793:1: ( ( rule__AllocateT__AtAssignment_1_0_2 ) )
            // InternalMyDsl.g:5794:2: ( rule__AllocateT__AtAssignment_1_0_2 )
            {
             before(grammarAccess.getAllocateTAccess().getAtAssignment_1_0_2()); 
            // InternalMyDsl.g:5795:2: ( rule__AllocateT__AtAssignment_1_0_2 )
            // InternalMyDsl.g:5795:3: rule__AllocateT__AtAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__AllocateT__AtAssignment_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getAllocateTAccess().getAtAssignment_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group_1_0__2__Impl"


    // $ANTLR start "rule__AllocateT__Group_1_1__0"
    // InternalMyDsl.g:5804:1: rule__AllocateT__Group_1_1__0 : rule__AllocateT__Group_1_1__0__Impl rule__AllocateT__Group_1_1__1 ;
    public final void rule__AllocateT__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5808:1: ( rule__AllocateT__Group_1_1__0__Impl rule__AllocateT__Group_1_1__1 )
            // InternalMyDsl.g:5809:2: rule__AllocateT__Group_1_1__0__Impl rule__AllocateT__Group_1_1__1
            {
            pushFollow(FOLLOW_51);
            rule__AllocateT__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllocateT__Group_1_1__1();

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
    // $ANTLR end "rule__AllocateT__Group_1_1__0"


    // $ANTLR start "rule__AllocateT__Group_1_1__0__Impl"
    // InternalMyDsl.g:5816:1: rule__AllocateT__Group_1_1__0__Impl : ( 'compound' ) ;
    public final void rule__AllocateT__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5820:1: ( ( 'compound' ) )
            // InternalMyDsl.g:5821:1: ( 'compound' )
            {
            // InternalMyDsl.g:5821:1: ( 'compound' )
            // InternalMyDsl.g:5822:2: 'compound'
            {
             before(grammarAccess.getAllocateTAccess().getCompoundKeyword_1_1_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getAllocateTAccess().getCompoundKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group_1_1__0__Impl"


    // $ANTLR start "rule__AllocateT__Group_1_1__1"
    // InternalMyDsl.g:5831:1: rule__AllocateT__Group_1_1__1 : rule__AllocateT__Group_1_1__1__Impl rule__AllocateT__Group_1_1__2 ;
    public final void rule__AllocateT__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5835:1: ( rule__AllocateT__Group_1_1__1__Impl rule__AllocateT__Group_1_1__2 )
            // InternalMyDsl.g:5836:2: rule__AllocateT__Group_1_1__1__Impl rule__AllocateT__Group_1_1__2
            {
            pushFollow(FOLLOW_9);
            rule__AllocateT__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllocateT__Group_1_1__2();

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
    // $ANTLR end "rule__AllocateT__Group_1_1__1"


    // $ANTLR start "rule__AllocateT__Group_1_1__1__Impl"
    // InternalMyDsl.g:5843:1: rule__AllocateT__Group_1_1__1__Impl : ( 'task' ) ;
    public final void rule__AllocateT__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5847:1: ( ( 'task' ) )
            // InternalMyDsl.g:5848:1: ( 'task' )
            {
            // InternalMyDsl.g:5848:1: ( 'task' )
            // InternalMyDsl.g:5849:2: 'task'
            {
             before(grammarAccess.getAllocateTAccess().getTaskKeyword_1_1_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getAllocateTAccess().getTaskKeyword_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group_1_1__1__Impl"


    // $ANTLR start "rule__AllocateT__Group_1_1__2"
    // InternalMyDsl.g:5858:1: rule__AllocateT__Group_1_1__2 : rule__AllocateT__Group_1_1__2__Impl ;
    public final void rule__AllocateT__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5862:1: ( rule__AllocateT__Group_1_1__2__Impl )
            // InternalMyDsl.g:5863:2: rule__AllocateT__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AllocateT__Group_1_1__2__Impl();

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
    // $ANTLR end "rule__AllocateT__Group_1_1__2"


    // $ANTLR start "rule__AllocateT__Group_1_1__2__Impl"
    // InternalMyDsl.g:5869:1: rule__AllocateT__Group_1_1__2__Impl : ( ( rule__AllocateT__CtAssignment_1_1_2 ) ) ;
    public final void rule__AllocateT__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5873:1: ( ( ( rule__AllocateT__CtAssignment_1_1_2 ) ) )
            // InternalMyDsl.g:5874:1: ( ( rule__AllocateT__CtAssignment_1_1_2 ) )
            {
            // InternalMyDsl.g:5874:1: ( ( rule__AllocateT__CtAssignment_1_1_2 ) )
            // InternalMyDsl.g:5875:2: ( rule__AllocateT__CtAssignment_1_1_2 )
            {
             before(grammarAccess.getAllocateTAccess().getCtAssignment_1_1_2()); 
            // InternalMyDsl.g:5876:2: ( rule__AllocateT__CtAssignment_1_1_2 )
            // InternalMyDsl.g:5876:3: rule__AllocateT__CtAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__AllocateT__CtAssignment_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAllocateTAccess().getCtAssignment_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group_1_1__2__Impl"


    // $ANTLR start "rule__AllocateT__Group_1_2__0"
    // InternalMyDsl.g:5885:1: rule__AllocateT__Group_1_2__0 : rule__AllocateT__Group_1_2__0__Impl rule__AllocateT__Group_1_2__1 ;
    public final void rule__AllocateT__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5889:1: ( rule__AllocateT__Group_1_2__0__Impl rule__AllocateT__Group_1_2__1 )
            // InternalMyDsl.g:5890:2: rule__AllocateT__Group_1_2__0__Impl rule__AllocateT__Group_1_2__1
            {
            pushFollow(FOLLOW_51);
            rule__AllocateT__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllocateT__Group_1_2__1();

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
    // $ANTLR end "rule__AllocateT__Group_1_2__0"


    // $ANTLR start "rule__AllocateT__Group_1_2__0__Impl"
    // InternalMyDsl.g:5897:1: rule__AllocateT__Group_1_2__0__Impl : ( 'mission' ) ;
    public final void rule__AllocateT__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5901:1: ( ( 'mission' ) )
            // InternalMyDsl.g:5902:1: ( 'mission' )
            {
            // InternalMyDsl.g:5902:1: ( 'mission' )
            // InternalMyDsl.g:5903:2: 'mission'
            {
             before(grammarAccess.getAllocateTAccess().getMissionKeyword_1_2_0()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getAllocateTAccess().getMissionKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group_1_2__0__Impl"


    // $ANTLR start "rule__AllocateT__Group_1_2__1"
    // InternalMyDsl.g:5912:1: rule__AllocateT__Group_1_2__1 : rule__AllocateT__Group_1_2__1__Impl rule__AllocateT__Group_1_2__2 ;
    public final void rule__AllocateT__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5916:1: ( rule__AllocateT__Group_1_2__1__Impl rule__AllocateT__Group_1_2__2 )
            // InternalMyDsl.g:5917:2: rule__AllocateT__Group_1_2__1__Impl rule__AllocateT__Group_1_2__2
            {
            pushFollow(FOLLOW_9);
            rule__AllocateT__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllocateT__Group_1_2__2();

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
    // $ANTLR end "rule__AllocateT__Group_1_2__1"


    // $ANTLR start "rule__AllocateT__Group_1_2__1__Impl"
    // InternalMyDsl.g:5924:1: rule__AllocateT__Group_1_2__1__Impl : ( 'task' ) ;
    public final void rule__AllocateT__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5928:1: ( ( 'task' ) )
            // InternalMyDsl.g:5929:1: ( 'task' )
            {
            // InternalMyDsl.g:5929:1: ( 'task' )
            // InternalMyDsl.g:5930:2: 'task'
            {
             before(grammarAccess.getAllocateTAccess().getTaskKeyword_1_2_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getAllocateTAccess().getTaskKeyword_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group_1_2__1__Impl"


    // $ANTLR start "rule__AllocateT__Group_1_2__2"
    // InternalMyDsl.g:5939:1: rule__AllocateT__Group_1_2__2 : rule__AllocateT__Group_1_2__2__Impl ;
    public final void rule__AllocateT__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5943:1: ( rule__AllocateT__Group_1_2__2__Impl )
            // InternalMyDsl.g:5944:2: rule__AllocateT__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AllocateT__Group_1_2__2__Impl();

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
    // $ANTLR end "rule__AllocateT__Group_1_2__2"


    // $ANTLR start "rule__AllocateT__Group_1_2__2__Impl"
    // InternalMyDsl.g:5950:1: rule__AllocateT__Group_1_2__2__Impl : ( ( rule__AllocateT__MtAssignment_1_2_2 ) ) ;
    public final void rule__AllocateT__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5954:1: ( ( ( rule__AllocateT__MtAssignment_1_2_2 ) ) )
            // InternalMyDsl.g:5955:1: ( ( rule__AllocateT__MtAssignment_1_2_2 ) )
            {
            // InternalMyDsl.g:5955:1: ( ( rule__AllocateT__MtAssignment_1_2_2 ) )
            // InternalMyDsl.g:5956:2: ( rule__AllocateT__MtAssignment_1_2_2 )
            {
             before(grammarAccess.getAllocateTAccess().getMtAssignment_1_2_2()); 
            // InternalMyDsl.g:5957:2: ( rule__AllocateT__MtAssignment_1_2_2 )
            // InternalMyDsl.g:5957:3: rule__AllocateT__MtAssignment_1_2_2
            {
            pushFollow(FOLLOW_2);
            rule__AllocateT__MtAssignment_1_2_2();

            state._fsp--;


            }

             after(grammarAccess.getAllocateTAccess().getMtAssignment_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__Group_1_2__2__Impl"


    // $ANTLR start "rule__Closest__Group__0"
    // InternalMyDsl.g:5966:1: rule__Closest__Group__0 : rule__Closest__Group__0__Impl rule__Closest__Group__1 ;
    public final void rule__Closest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5970:1: ( rule__Closest__Group__0__Impl rule__Closest__Group__1 )
            // InternalMyDsl.g:5971:2: rule__Closest__Group__0__Impl rule__Closest__Group__1
            {
            pushFollow(FOLLOW_65);
            rule__Closest__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group__1();

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
    // $ANTLR end "rule__Closest__Group__0"


    // $ANTLR start "rule__Closest__Group__0__Impl"
    // InternalMyDsl.g:5978:1: rule__Closest__Group__0__Impl : ( () ) ;
    public final void rule__Closest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5982:1: ( ( () ) )
            // InternalMyDsl.g:5983:1: ( () )
            {
            // InternalMyDsl.g:5983:1: ( () )
            // InternalMyDsl.g:5984:2: ()
            {
             before(grammarAccess.getClosestAccess().getClosestAction_0()); 
            // InternalMyDsl.g:5985:2: ()
            // InternalMyDsl.g:5985:3: 
            {
            }

             after(grammarAccess.getClosestAccess().getClosestAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group__0__Impl"


    // $ANTLR start "rule__Closest__Group__1"
    // InternalMyDsl.g:5993:1: rule__Closest__Group__1 : rule__Closest__Group__1__Impl rule__Closest__Group__2 ;
    public final void rule__Closest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5997:1: ( rule__Closest__Group__1__Impl rule__Closest__Group__2 )
            // InternalMyDsl.g:5998:2: rule__Closest__Group__1__Impl rule__Closest__Group__2
            {
            pushFollow(FOLLOW_66);
            rule__Closest__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group__2();

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
    // $ANTLR end "rule__Closest__Group__1"


    // $ANTLR start "rule__Closest__Group__1__Impl"
    // InternalMyDsl.g:6005:1: rule__Closest__Group__1__Impl : ( 'allocate' ) ;
    public final void rule__Closest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6009:1: ( ( 'allocate' ) )
            // InternalMyDsl.g:6010:1: ( 'allocate' )
            {
            // InternalMyDsl.g:6010:1: ( 'allocate' )
            // InternalMyDsl.g:6011:2: 'allocate'
            {
             before(grammarAccess.getClosestAccess().getAllocateKeyword_1()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getAllocateKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group__1__Impl"


    // $ANTLR start "rule__Closest__Group__2"
    // InternalMyDsl.g:6020:1: rule__Closest__Group__2 : rule__Closest__Group__2__Impl rule__Closest__Group__3 ;
    public final void rule__Closest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6024:1: ( rule__Closest__Group__2__Impl rule__Closest__Group__3 )
            // InternalMyDsl.g:6025:2: rule__Closest__Group__2__Impl rule__Closest__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Closest__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group__3();

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
    // $ANTLR end "rule__Closest__Group__2"


    // $ANTLR start "rule__Closest__Group__2__Impl"
    // InternalMyDsl.g:6032:1: rule__Closest__Group__2__Impl : ( ( rule__Closest__Alternatives_2 ) ) ;
    public final void rule__Closest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6036:1: ( ( ( rule__Closest__Alternatives_2 ) ) )
            // InternalMyDsl.g:6037:1: ( ( rule__Closest__Alternatives_2 ) )
            {
            // InternalMyDsl.g:6037:1: ( ( rule__Closest__Alternatives_2 ) )
            // InternalMyDsl.g:6038:2: ( rule__Closest__Alternatives_2 )
            {
             before(grammarAccess.getClosestAccess().getAlternatives_2()); 
            // InternalMyDsl.g:6039:2: ( rule__Closest__Alternatives_2 )
            // InternalMyDsl.g:6039:3: rule__Closest__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__Closest__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getClosestAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group__2__Impl"


    // $ANTLR start "rule__Closest__Group__3"
    // InternalMyDsl.g:6047:1: rule__Closest__Group__3 : rule__Closest__Group__3__Impl rule__Closest__Group__4 ;
    public final void rule__Closest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6051:1: ( rule__Closest__Group__3__Impl rule__Closest__Group__4 )
            // InternalMyDsl.g:6052:2: rule__Closest__Group__3__Impl rule__Closest__Group__4
            {
            pushFollow(FOLLOW_67);
            rule__Closest__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group__4();

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
    // $ANTLR end "rule__Closest__Group__3"


    // $ANTLR start "rule__Closest__Group__3__Impl"
    // InternalMyDsl.g:6059:1: rule__Closest__Group__3__Impl : ( 'to' ) ;
    public final void rule__Closest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6063:1: ( ( 'to' ) )
            // InternalMyDsl.g:6064:1: ( 'to' )
            {
            // InternalMyDsl.g:6064:1: ( 'to' )
            // InternalMyDsl.g:6065:2: 'to'
            {
             before(grammarAccess.getClosestAccess().getToKeyword_3()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getToKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group__3__Impl"


    // $ANTLR start "rule__Closest__Group__4"
    // InternalMyDsl.g:6074:1: rule__Closest__Group__4 : rule__Closest__Group__4__Impl rule__Closest__Group__5 ;
    public final void rule__Closest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6078:1: ( rule__Closest__Group__4__Impl rule__Closest__Group__5 )
            // InternalMyDsl.g:6079:2: rule__Closest__Group__4__Impl rule__Closest__Group__5
            {
            pushFollow(FOLLOW_64);
            rule__Closest__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group__5();

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
    // $ANTLR end "rule__Closest__Group__4"


    // $ANTLR start "rule__Closest__Group__4__Impl"
    // InternalMyDsl.g:6086:1: rule__Closest__Group__4__Impl : ( 'closest' ) ;
    public final void rule__Closest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6090:1: ( ( 'closest' ) )
            // InternalMyDsl.g:6091:1: ( 'closest' )
            {
            // InternalMyDsl.g:6091:1: ( 'closest' )
            // InternalMyDsl.g:6092:2: 'closest'
            {
             before(grammarAccess.getClosestAccess().getClosestKeyword_4()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getClosestKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group__4__Impl"


    // $ANTLR start "rule__Closest__Group__5"
    // InternalMyDsl.g:6101:1: rule__Closest__Group__5 : rule__Closest__Group__5__Impl ;
    public final void rule__Closest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6105:1: ( rule__Closest__Group__5__Impl )
            // InternalMyDsl.g:6106:2: rule__Closest__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Closest__Group__5__Impl();

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
    // $ANTLR end "rule__Closest__Group__5"


    // $ANTLR start "rule__Closest__Group__5__Impl"
    // InternalMyDsl.g:6112:1: rule__Closest__Group__5__Impl : ( 'robot' ) ;
    public final void rule__Closest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6116:1: ( ( 'robot' ) )
            // InternalMyDsl.g:6117:1: ( 'robot' )
            {
            // InternalMyDsl.g:6117:1: ( 'robot' )
            // InternalMyDsl.g:6118:2: 'robot'
            {
             before(grammarAccess.getClosestAccess().getRobotKeyword_5()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getRobotKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group__5__Impl"


    // $ANTLR start "rule__Closest__Group_2_0__0"
    // InternalMyDsl.g:6128:1: rule__Closest__Group_2_0__0 : rule__Closest__Group_2_0__0__Impl rule__Closest__Group_2_0__1 ;
    public final void rule__Closest__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6132:1: ( rule__Closest__Group_2_0__0__Impl rule__Closest__Group_2_0__1 )
            // InternalMyDsl.g:6133:2: rule__Closest__Group_2_0__0__Impl rule__Closest__Group_2_0__1
            {
            pushFollow(FOLLOW_68);
            rule__Closest__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_0__1();

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
    // $ANTLR end "rule__Closest__Group_2_0__0"


    // $ANTLR start "rule__Closest__Group_2_0__0__Impl"
    // InternalMyDsl.g:6140:1: rule__Closest__Group_2_0__0__Impl : ( ( rule__Closest__AllAssignment_2_0_0 ) ) ;
    public final void rule__Closest__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6144:1: ( ( ( rule__Closest__AllAssignment_2_0_0 ) ) )
            // InternalMyDsl.g:6145:1: ( ( rule__Closest__AllAssignment_2_0_0 ) )
            {
            // InternalMyDsl.g:6145:1: ( ( rule__Closest__AllAssignment_2_0_0 ) )
            // InternalMyDsl.g:6146:2: ( rule__Closest__AllAssignment_2_0_0 )
            {
             before(grammarAccess.getClosestAccess().getAllAssignment_2_0_0()); 
            // InternalMyDsl.g:6147:2: ( rule__Closest__AllAssignment_2_0_0 )
            // InternalMyDsl.g:6147:3: rule__Closest__AllAssignment_2_0_0
            {
            pushFollow(FOLLOW_2);
            rule__Closest__AllAssignment_2_0_0();

            state._fsp--;


            }

             after(grammarAccess.getClosestAccess().getAllAssignment_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_0__0__Impl"


    // $ANTLR start "rule__Closest__Group_2_0__1"
    // InternalMyDsl.g:6155:1: rule__Closest__Group_2_0__1 : rule__Closest__Group_2_0__1__Impl ;
    public final void rule__Closest__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6159:1: ( rule__Closest__Group_2_0__1__Impl )
            // InternalMyDsl.g:6160:2: rule__Closest__Group_2_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_0__1__Impl();

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
    // $ANTLR end "rule__Closest__Group_2_0__1"


    // $ANTLR start "rule__Closest__Group_2_0__1__Impl"
    // InternalMyDsl.g:6166:1: rule__Closest__Group_2_0__1__Impl : ( 'tasks' ) ;
    public final void rule__Closest__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6170:1: ( ( 'tasks' ) )
            // InternalMyDsl.g:6171:1: ( 'tasks' )
            {
            // InternalMyDsl.g:6171:1: ( 'tasks' )
            // InternalMyDsl.g:6172:2: 'tasks'
            {
             before(grammarAccess.getClosestAccess().getTasksKeyword_2_0_1()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getTasksKeyword_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_0__1__Impl"


    // $ANTLR start "rule__Closest__Group_2_1__0"
    // InternalMyDsl.g:6182:1: rule__Closest__Group_2_1__0 : rule__Closest__Group_2_1__0__Impl rule__Closest__Group_2_1__1 ;
    public final void rule__Closest__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6186:1: ( rule__Closest__Group_2_1__0__Impl rule__Closest__Group_2_1__1 )
            // InternalMyDsl.g:6187:2: rule__Closest__Group_2_1__0__Impl rule__Closest__Group_2_1__1
            {
            pushFollow(FOLLOW_51);
            rule__Closest__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_1__1();

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
    // $ANTLR end "rule__Closest__Group_2_1__0"


    // $ANTLR start "rule__Closest__Group_2_1__0__Impl"
    // InternalMyDsl.g:6194:1: rule__Closest__Group_2_1__0__Impl : ( 'atomic' ) ;
    public final void rule__Closest__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6198:1: ( ( 'atomic' ) )
            // InternalMyDsl.g:6199:1: ( 'atomic' )
            {
            // InternalMyDsl.g:6199:1: ( 'atomic' )
            // InternalMyDsl.g:6200:2: 'atomic'
            {
             before(grammarAccess.getClosestAccess().getAtomicKeyword_2_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getAtomicKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_1__0__Impl"


    // $ANTLR start "rule__Closest__Group_2_1__1"
    // InternalMyDsl.g:6209:1: rule__Closest__Group_2_1__1 : rule__Closest__Group_2_1__1__Impl rule__Closest__Group_2_1__2 ;
    public final void rule__Closest__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6213:1: ( rule__Closest__Group_2_1__1__Impl rule__Closest__Group_2_1__2 )
            // InternalMyDsl.g:6214:2: rule__Closest__Group_2_1__1__Impl rule__Closest__Group_2_1__2
            {
            pushFollow(FOLLOW_9);
            rule__Closest__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_1__2();

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
    // $ANTLR end "rule__Closest__Group_2_1__1"


    // $ANTLR start "rule__Closest__Group_2_1__1__Impl"
    // InternalMyDsl.g:6221:1: rule__Closest__Group_2_1__1__Impl : ( 'task' ) ;
    public final void rule__Closest__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6225:1: ( ( 'task' ) )
            // InternalMyDsl.g:6226:1: ( 'task' )
            {
            // InternalMyDsl.g:6226:1: ( 'task' )
            // InternalMyDsl.g:6227:2: 'task'
            {
             before(grammarAccess.getClosestAccess().getTaskKeyword_2_1_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getTaskKeyword_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_1__1__Impl"


    // $ANTLR start "rule__Closest__Group_2_1__2"
    // InternalMyDsl.g:6236:1: rule__Closest__Group_2_1__2 : rule__Closest__Group_2_1__2__Impl ;
    public final void rule__Closest__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6240:1: ( rule__Closest__Group_2_1__2__Impl )
            // InternalMyDsl.g:6241:2: rule__Closest__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_1__2__Impl();

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
    // $ANTLR end "rule__Closest__Group_2_1__2"


    // $ANTLR start "rule__Closest__Group_2_1__2__Impl"
    // InternalMyDsl.g:6247:1: rule__Closest__Group_2_1__2__Impl : ( ( rule__Closest__AtAssignment_2_1_2 ) ) ;
    public final void rule__Closest__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6251:1: ( ( ( rule__Closest__AtAssignment_2_1_2 ) ) )
            // InternalMyDsl.g:6252:1: ( ( rule__Closest__AtAssignment_2_1_2 ) )
            {
            // InternalMyDsl.g:6252:1: ( ( rule__Closest__AtAssignment_2_1_2 ) )
            // InternalMyDsl.g:6253:2: ( rule__Closest__AtAssignment_2_1_2 )
            {
             before(grammarAccess.getClosestAccess().getAtAssignment_2_1_2()); 
            // InternalMyDsl.g:6254:2: ( rule__Closest__AtAssignment_2_1_2 )
            // InternalMyDsl.g:6254:3: rule__Closest__AtAssignment_2_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Closest__AtAssignment_2_1_2();

            state._fsp--;


            }

             after(grammarAccess.getClosestAccess().getAtAssignment_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_1__2__Impl"


    // $ANTLR start "rule__Closest__Group_2_2__0"
    // InternalMyDsl.g:6263:1: rule__Closest__Group_2_2__0 : rule__Closest__Group_2_2__0__Impl rule__Closest__Group_2_2__1 ;
    public final void rule__Closest__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6267:1: ( rule__Closest__Group_2_2__0__Impl rule__Closest__Group_2_2__1 )
            // InternalMyDsl.g:6268:2: rule__Closest__Group_2_2__0__Impl rule__Closest__Group_2_2__1
            {
            pushFollow(FOLLOW_51);
            rule__Closest__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_2__1();

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
    // $ANTLR end "rule__Closest__Group_2_2__0"


    // $ANTLR start "rule__Closest__Group_2_2__0__Impl"
    // InternalMyDsl.g:6275:1: rule__Closest__Group_2_2__0__Impl : ( 'compound' ) ;
    public final void rule__Closest__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6279:1: ( ( 'compound' ) )
            // InternalMyDsl.g:6280:1: ( 'compound' )
            {
            // InternalMyDsl.g:6280:1: ( 'compound' )
            // InternalMyDsl.g:6281:2: 'compound'
            {
             before(grammarAccess.getClosestAccess().getCompoundKeyword_2_2_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getCompoundKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_2__0__Impl"


    // $ANTLR start "rule__Closest__Group_2_2__1"
    // InternalMyDsl.g:6290:1: rule__Closest__Group_2_2__1 : rule__Closest__Group_2_2__1__Impl rule__Closest__Group_2_2__2 ;
    public final void rule__Closest__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6294:1: ( rule__Closest__Group_2_2__1__Impl rule__Closest__Group_2_2__2 )
            // InternalMyDsl.g:6295:2: rule__Closest__Group_2_2__1__Impl rule__Closest__Group_2_2__2
            {
            pushFollow(FOLLOW_9);
            rule__Closest__Group_2_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_2__2();

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
    // $ANTLR end "rule__Closest__Group_2_2__1"


    // $ANTLR start "rule__Closest__Group_2_2__1__Impl"
    // InternalMyDsl.g:6302:1: rule__Closest__Group_2_2__1__Impl : ( 'task' ) ;
    public final void rule__Closest__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6306:1: ( ( 'task' ) )
            // InternalMyDsl.g:6307:1: ( 'task' )
            {
            // InternalMyDsl.g:6307:1: ( 'task' )
            // InternalMyDsl.g:6308:2: 'task'
            {
             before(grammarAccess.getClosestAccess().getTaskKeyword_2_2_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getTaskKeyword_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_2__1__Impl"


    // $ANTLR start "rule__Closest__Group_2_2__2"
    // InternalMyDsl.g:6317:1: rule__Closest__Group_2_2__2 : rule__Closest__Group_2_2__2__Impl ;
    public final void rule__Closest__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6321:1: ( rule__Closest__Group_2_2__2__Impl )
            // InternalMyDsl.g:6322:2: rule__Closest__Group_2_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_2__2__Impl();

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
    // $ANTLR end "rule__Closest__Group_2_2__2"


    // $ANTLR start "rule__Closest__Group_2_2__2__Impl"
    // InternalMyDsl.g:6328:1: rule__Closest__Group_2_2__2__Impl : ( ( rule__Closest__CtAssignment_2_2_2 ) ) ;
    public final void rule__Closest__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6332:1: ( ( ( rule__Closest__CtAssignment_2_2_2 ) ) )
            // InternalMyDsl.g:6333:1: ( ( rule__Closest__CtAssignment_2_2_2 ) )
            {
            // InternalMyDsl.g:6333:1: ( ( rule__Closest__CtAssignment_2_2_2 ) )
            // InternalMyDsl.g:6334:2: ( rule__Closest__CtAssignment_2_2_2 )
            {
             before(grammarAccess.getClosestAccess().getCtAssignment_2_2_2()); 
            // InternalMyDsl.g:6335:2: ( rule__Closest__CtAssignment_2_2_2 )
            // InternalMyDsl.g:6335:3: rule__Closest__CtAssignment_2_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Closest__CtAssignment_2_2_2();

            state._fsp--;


            }

             after(grammarAccess.getClosestAccess().getCtAssignment_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_2__2__Impl"


    // $ANTLR start "rule__Closest__Group_2_3__0"
    // InternalMyDsl.g:6344:1: rule__Closest__Group_2_3__0 : rule__Closest__Group_2_3__0__Impl rule__Closest__Group_2_3__1 ;
    public final void rule__Closest__Group_2_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6348:1: ( rule__Closest__Group_2_3__0__Impl rule__Closest__Group_2_3__1 )
            // InternalMyDsl.g:6349:2: rule__Closest__Group_2_3__0__Impl rule__Closest__Group_2_3__1
            {
            pushFollow(FOLLOW_51);
            rule__Closest__Group_2_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_3__1();

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
    // $ANTLR end "rule__Closest__Group_2_3__0"


    // $ANTLR start "rule__Closest__Group_2_3__0__Impl"
    // InternalMyDsl.g:6356:1: rule__Closest__Group_2_3__0__Impl : ( 'mission' ) ;
    public final void rule__Closest__Group_2_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6360:1: ( ( 'mission' ) )
            // InternalMyDsl.g:6361:1: ( 'mission' )
            {
            // InternalMyDsl.g:6361:1: ( 'mission' )
            // InternalMyDsl.g:6362:2: 'mission'
            {
             before(grammarAccess.getClosestAccess().getMissionKeyword_2_3_0()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getMissionKeyword_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_3__0__Impl"


    // $ANTLR start "rule__Closest__Group_2_3__1"
    // InternalMyDsl.g:6371:1: rule__Closest__Group_2_3__1 : rule__Closest__Group_2_3__1__Impl rule__Closest__Group_2_3__2 ;
    public final void rule__Closest__Group_2_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6375:1: ( rule__Closest__Group_2_3__1__Impl rule__Closest__Group_2_3__2 )
            // InternalMyDsl.g:6376:2: rule__Closest__Group_2_3__1__Impl rule__Closest__Group_2_3__2
            {
            pushFollow(FOLLOW_9);
            rule__Closest__Group_2_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_3__2();

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
    // $ANTLR end "rule__Closest__Group_2_3__1"


    // $ANTLR start "rule__Closest__Group_2_3__1__Impl"
    // InternalMyDsl.g:6383:1: rule__Closest__Group_2_3__1__Impl : ( 'task' ) ;
    public final void rule__Closest__Group_2_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6387:1: ( ( 'task' ) )
            // InternalMyDsl.g:6388:1: ( 'task' )
            {
            // InternalMyDsl.g:6388:1: ( 'task' )
            // InternalMyDsl.g:6389:2: 'task'
            {
             before(grammarAccess.getClosestAccess().getTaskKeyword_2_3_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getTaskKeyword_2_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_3__1__Impl"


    // $ANTLR start "rule__Closest__Group_2_3__2"
    // InternalMyDsl.g:6398:1: rule__Closest__Group_2_3__2 : rule__Closest__Group_2_3__2__Impl ;
    public final void rule__Closest__Group_2_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6402:1: ( rule__Closest__Group_2_3__2__Impl )
            // InternalMyDsl.g:6403:2: rule__Closest__Group_2_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Closest__Group_2_3__2__Impl();

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
    // $ANTLR end "rule__Closest__Group_2_3__2"


    // $ANTLR start "rule__Closest__Group_2_3__2__Impl"
    // InternalMyDsl.g:6409:1: rule__Closest__Group_2_3__2__Impl : ( ( rule__Closest__MtAssignment_2_3_2 ) ) ;
    public final void rule__Closest__Group_2_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6413:1: ( ( ( rule__Closest__MtAssignment_2_3_2 ) ) )
            // InternalMyDsl.g:6414:1: ( ( rule__Closest__MtAssignment_2_3_2 ) )
            {
            // InternalMyDsl.g:6414:1: ( ( rule__Closest__MtAssignment_2_3_2 ) )
            // InternalMyDsl.g:6415:2: ( rule__Closest__MtAssignment_2_3_2 )
            {
             before(grammarAccess.getClosestAccess().getMtAssignment_2_3_2()); 
            // InternalMyDsl.g:6416:2: ( rule__Closest__MtAssignment_2_3_2 )
            // InternalMyDsl.g:6416:3: rule__Closest__MtAssignment_2_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Closest__MtAssignment_2_3_2();

            state._fsp--;


            }

             after(grammarAccess.getClosestAccess().getMtAssignment_2_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__Group_2_3__2__Impl"


    // $ANTLR start "rule__MaxTasks__Group__0"
    // InternalMyDsl.g:6425:1: rule__MaxTasks__Group__0 : rule__MaxTasks__Group__0__Impl rule__MaxTasks__Group__1 ;
    public final void rule__MaxTasks__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6429:1: ( rule__MaxTasks__Group__0__Impl rule__MaxTasks__Group__1 )
            // InternalMyDsl.g:6430:2: rule__MaxTasks__Group__0__Impl rule__MaxTasks__Group__1
            {
            pushFollow(FOLLOW_69);
            rule__MaxTasks__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group__1();

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
    // $ANTLR end "rule__MaxTasks__Group__0"


    // $ANTLR start "rule__MaxTasks__Group__0__Impl"
    // InternalMyDsl.g:6437:1: rule__MaxTasks__Group__0__Impl : ( 'limit' ) ;
    public final void rule__MaxTasks__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6441:1: ( ( 'limit' ) )
            // InternalMyDsl.g:6442:1: ( 'limit' )
            {
            // InternalMyDsl.g:6442:1: ( 'limit' )
            // InternalMyDsl.g:6443:2: 'limit'
            {
             before(grammarAccess.getMaxTasksAccess().getLimitKeyword_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getMaxTasksAccess().getLimitKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group__0__Impl"


    // $ANTLR start "rule__MaxTasks__Group__1"
    // InternalMyDsl.g:6452:1: rule__MaxTasks__Group__1 : rule__MaxTasks__Group__1__Impl rule__MaxTasks__Group__2 ;
    public final void rule__MaxTasks__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6456:1: ( rule__MaxTasks__Group__1__Impl rule__MaxTasks__Group__2 )
            // InternalMyDsl.g:6457:2: rule__MaxTasks__Group__1__Impl rule__MaxTasks__Group__2
            {
            pushFollow(FOLLOW_70);
            rule__MaxTasks__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group__2();

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
    // $ANTLR end "rule__MaxTasks__Group__1"


    // $ANTLR start "rule__MaxTasks__Group__1__Impl"
    // InternalMyDsl.g:6464:1: rule__MaxTasks__Group__1__Impl : ( 'max' ) ;
    public final void rule__MaxTasks__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6468:1: ( ( 'max' ) )
            // InternalMyDsl.g:6469:1: ( 'max' )
            {
            // InternalMyDsl.g:6469:1: ( 'max' )
            // InternalMyDsl.g:6470:2: 'max'
            {
             before(grammarAccess.getMaxTasksAccess().getMaxKeyword_1()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getMaxTasksAccess().getMaxKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group__1__Impl"


    // $ANTLR start "rule__MaxTasks__Group__2"
    // InternalMyDsl.g:6479:1: rule__MaxTasks__Group__2 : rule__MaxTasks__Group__2__Impl rule__MaxTasks__Group__3 ;
    public final void rule__MaxTasks__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6483:1: ( rule__MaxTasks__Group__2__Impl rule__MaxTasks__Group__3 )
            // InternalMyDsl.g:6484:2: rule__MaxTasks__Group__2__Impl rule__MaxTasks__Group__3
            {
            pushFollow(FOLLOW_53);
            rule__MaxTasks__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group__3();

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
    // $ANTLR end "rule__MaxTasks__Group__2"


    // $ANTLR start "rule__MaxTasks__Group__2__Impl"
    // InternalMyDsl.g:6491:1: rule__MaxTasks__Group__2__Impl : ( 'number' ) ;
    public final void rule__MaxTasks__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6495:1: ( ( 'number' ) )
            // InternalMyDsl.g:6496:1: ( 'number' )
            {
            // InternalMyDsl.g:6496:1: ( 'number' )
            // InternalMyDsl.g:6497:2: 'number'
            {
             before(grammarAccess.getMaxTasksAccess().getNumberKeyword_2()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getMaxTasksAccess().getNumberKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group__2__Impl"


    // $ANTLR start "rule__MaxTasks__Group__3"
    // InternalMyDsl.g:6506:1: rule__MaxTasks__Group__3 : rule__MaxTasks__Group__3__Impl rule__MaxTasks__Group__4 ;
    public final void rule__MaxTasks__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6510:1: ( rule__MaxTasks__Group__3__Impl rule__MaxTasks__Group__4 )
            // InternalMyDsl.g:6511:2: rule__MaxTasks__Group__3__Impl rule__MaxTasks__Group__4
            {
            pushFollow(FOLLOW_68);
            rule__MaxTasks__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group__4();

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
    // $ANTLR end "rule__MaxTasks__Group__3"


    // $ANTLR start "rule__MaxTasks__Group__3__Impl"
    // InternalMyDsl.g:6518:1: rule__MaxTasks__Group__3__Impl : ( 'of' ) ;
    public final void rule__MaxTasks__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6522:1: ( ( 'of' ) )
            // InternalMyDsl.g:6523:1: ( 'of' )
            {
            // InternalMyDsl.g:6523:1: ( 'of' )
            // InternalMyDsl.g:6524:2: 'of'
            {
             before(grammarAccess.getMaxTasksAccess().getOfKeyword_3()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getMaxTasksAccess().getOfKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group__3__Impl"


    // $ANTLR start "rule__MaxTasks__Group__4"
    // InternalMyDsl.g:6533:1: rule__MaxTasks__Group__4 : rule__MaxTasks__Group__4__Impl rule__MaxTasks__Group__5 ;
    public final void rule__MaxTasks__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6537:1: ( rule__MaxTasks__Group__4__Impl rule__MaxTasks__Group__5 )
            // InternalMyDsl.g:6538:2: rule__MaxTasks__Group__4__Impl rule__MaxTasks__Group__5
            {
            pushFollow(FOLLOW_71);
            rule__MaxTasks__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group__5();

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
    // $ANTLR end "rule__MaxTasks__Group__4"


    // $ANTLR start "rule__MaxTasks__Group__4__Impl"
    // InternalMyDsl.g:6545:1: rule__MaxTasks__Group__4__Impl : ( 'tasks' ) ;
    public final void rule__MaxTasks__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6549:1: ( ( 'tasks' ) )
            // InternalMyDsl.g:6550:1: ( 'tasks' )
            {
            // InternalMyDsl.g:6550:1: ( 'tasks' )
            // InternalMyDsl.g:6551:2: 'tasks'
            {
             before(grammarAccess.getMaxTasksAccess().getTasksKeyword_4()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getMaxTasksAccess().getTasksKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group__4__Impl"


    // $ANTLR start "rule__MaxTasks__Group__5"
    // InternalMyDsl.g:6560:1: rule__MaxTasks__Group__5 : rule__MaxTasks__Group__5__Impl rule__MaxTasks__Group__6 ;
    public final void rule__MaxTasks__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6564:1: ( rule__MaxTasks__Group__5__Impl rule__MaxTasks__Group__6 )
            // InternalMyDsl.g:6565:2: rule__MaxTasks__Group__5__Impl rule__MaxTasks__Group__6
            {
            pushFollow(FOLLOW_20);
            rule__MaxTasks__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group__6();

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
    // $ANTLR end "rule__MaxTasks__Group__5"


    // $ANTLR start "rule__MaxTasks__Group__5__Impl"
    // InternalMyDsl.g:6572:1: rule__MaxTasks__Group__5__Impl : ( ( rule__MaxTasks__Alternatives_5 ) ) ;
    public final void rule__MaxTasks__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6576:1: ( ( ( rule__MaxTasks__Alternatives_5 ) ) )
            // InternalMyDsl.g:6577:1: ( ( rule__MaxTasks__Alternatives_5 ) )
            {
            // InternalMyDsl.g:6577:1: ( ( rule__MaxTasks__Alternatives_5 ) )
            // InternalMyDsl.g:6578:2: ( rule__MaxTasks__Alternatives_5 )
            {
             before(grammarAccess.getMaxTasksAccess().getAlternatives_5()); 
            // InternalMyDsl.g:6579:2: ( rule__MaxTasks__Alternatives_5 )
            // InternalMyDsl.g:6579:3: rule__MaxTasks__Alternatives_5
            {
            pushFollow(FOLLOW_2);
            rule__MaxTasks__Alternatives_5();

            state._fsp--;


            }

             after(grammarAccess.getMaxTasksAccess().getAlternatives_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group__5__Impl"


    // $ANTLR start "rule__MaxTasks__Group__6"
    // InternalMyDsl.g:6587:1: rule__MaxTasks__Group__6 : rule__MaxTasks__Group__6__Impl rule__MaxTasks__Group__7 ;
    public final void rule__MaxTasks__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6591:1: ( rule__MaxTasks__Group__6__Impl rule__MaxTasks__Group__7 )
            // InternalMyDsl.g:6592:2: rule__MaxTasks__Group__6__Impl rule__MaxTasks__Group__7
            {
            pushFollow(FOLLOW_22);
            rule__MaxTasks__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group__7();

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
    // $ANTLR end "rule__MaxTasks__Group__6"


    // $ANTLR start "rule__MaxTasks__Group__6__Impl"
    // InternalMyDsl.g:6599:1: rule__MaxTasks__Group__6__Impl : ( 'to' ) ;
    public final void rule__MaxTasks__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6603:1: ( ( 'to' ) )
            // InternalMyDsl.g:6604:1: ( 'to' )
            {
            // InternalMyDsl.g:6604:1: ( 'to' )
            // InternalMyDsl.g:6605:2: 'to'
            {
             before(grammarAccess.getMaxTasksAccess().getToKeyword_6()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getMaxTasksAccess().getToKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group__6__Impl"


    // $ANTLR start "rule__MaxTasks__Group__7"
    // InternalMyDsl.g:6614:1: rule__MaxTasks__Group__7 : rule__MaxTasks__Group__7__Impl ;
    public final void rule__MaxTasks__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6618:1: ( rule__MaxTasks__Group__7__Impl )
            // InternalMyDsl.g:6619:2: rule__MaxTasks__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group__7__Impl();

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
    // $ANTLR end "rule__MaxTasks__Group__7"


    // $ANTLR start "rule__MaxTasks__Group__7__Impl"
    // InternalMyDsl.g:6625:1: rule__MaxTasks__Group__7__Impl : ( ( rule__MaxTasks__NumAssignment_7 ) ) ;
    public final void rule__MaxTasks__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6629:1: ( ( ( rule__MaxTasks__NumAssignment_7 ) ) )
            // InternalMyDsl.g:6630:1: ( ( rule__MaxTasks__NumAssignment_7 ) )
            {
            // InternalMyDsl.g:6630:1: ( ( rule__MaxTasks__NumAssignment_7 ) )
            // InternalMyDsl.g:6631:2: ( rule__MaxTasks__NumAssignment_7 )
            {
             before(grammarAccess.getMaxTasksAccess().getNumAssignment_7()); 
            // InternalMyDsl.g:6632:2: ( rule__MaxTasks__NumAssignment_7 )
            // InternalMyDsl.g:6632:3: rule__MaxTasks__NumAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__MaxTasks__NumAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getMaxTasksAccess().getNumAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group__7__Impl"


    // $ANTLR start "rule__MaxTasks__Group_5_0__0"
    // InternalMyDsl.g:6641:1: rule__MaxTasks__Group_5_0__0 : rule__MaxTasks__Group_5_0__0__Impl rule__MaxTasks__Group_5_0__1 ;
    public final void rule__MaxTasks__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6645:1: ( rule__MaxTasks__Group_5_0__0__Impl rule__MaxTasks__Group_5_0__1 )
            // InternalMyDsl.g:6646:2: rule__MaxTasks__Group_5_0__0__Impl rule__MaxTasks__Group_5_0__1
            {
            pushFollow(FOLLOW_64);
            rule__MaxTasks__Group_5_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group_5_0__1();

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
    // $ANTLR end "rule__MaxTasks__Group_5_0__0"


    // $ANTLR start "rule__MaxTasks__Group_5_0__0__Impl"
    // InternalMyDsl.g:6653:1: rule__MaxTasks__Group_5_0__0__Impl : ( ( rule__MaxTasks__AllAssignment_5_0_0 ) ) ;
    public final void rule__MaxTasks__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6657:1: ( ( ( rule__MaxTasks__AllAssignment_5_0_0 ) ) )
            // InternalMyDsl.g:6658:1: ( ( rule__MaxTasks__AllAssignment_5_0_0 ) )
            {
            // InternalMyDsl.g:6658:1: ( ( rule__MaxTasks__AllAssignment_5_0_0 ) )
            // InternalMyDsl.g:6659:2: ( rule__MaxTasks__AllAssignment_5_0_0 )
            {
             before(grammarAccess.getMaxTasksAccess().getAllAssignment_5_0_0()); 
            // InternalMyDsl.g:6660:2: ( rule__MaxTasks__AllAssignment_5_0_0 )
            // InternalMyDsl.g:6660:3: rule__MaxTasks__AllAssignment_5_0_0
            {
            pushFollow(FOLLOW_2);
            rule__MaxTasks__AllAssignment_5_0_0();

            state._fsp--;


            }

             after(grammarAccess.getMaxTasksAccess().getAllAssignment_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group_5_0__0__Impl"


    // $ANTLR start "rule__MaxTasks__Group_5_0__1"
    // InternalMyDsl.g:6668:1: rule__MaxTasks__Group_5_0__1 : rule__MaxTasks__Group_5_0__1__Impl ;
    public final void rule__MaxTasks__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6672:1: ( rule__MaxTasks__Group_5_0__1__Impl )
            // InternalMyDsl.g:6673:2: rule__MaxTasks__Group_5_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group_5_0__1__Impl();

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
    // $ANTLR end "rule__MaxTasks__Group_5_0__1"


    // $ANTLR start "rule__MaxTasks__Group_5_0__1__Impl"
    // InternalMyDsl.g:6679:1: rule__MaxTasks__Group_5_0__1__Impl : ( 'robot' ) ;
    public final void rule__MaxTasks__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6683:1: ( ( 'robot' ) )
            // InternalMyDsl.g:6684:1: ( 'robot' )
            {
            // InternalMyDsl.g:6684:1: ( 'robot' )
            // InternalMyDsl.g:6685:2: 'robot'
            {
             before(grammarAccess.getMaxTasksAccess().getRobotKeyword_5_0_1()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getMaxTasksAccess().getRobotKeyword_5_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group_5_0__1__Impl"


    // $ANTLR start "rule__MaxTasks__Group_5_1__0"
    // InternalMyDsl.g:6695:1: rule__MaxTasks__Group_5_1__0 : rule__MaxTasks__Group_5_1__0__Impl rule__MaxTasks__Group_5_1__1 ;
    public final void rule__MaxTasks__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6699:1: ( rule__MaxTasks__Group_5_1__0__Impl rule__MaxTasks__Group_5_1__1 )
            // InternalMyDsl.g:6700:2: rule__MaxTasks__Group_5_1__0__Impl rule__MaxTasks__Group_5_1__1
            {
            pushFollow(FOLLOW_64);
            rule__MaxTasks__Group_5_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group_5_1__1();

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
    // $ANTLR end "rule__MaxTasks__Group_5_1__0"


    // $ANTLR start "rule__MaxTasks__Group_5_1__0__Impl"
    // InternalMyDsl.g:6707:1: rule__MaxTasks__Group_5_1__0__Impl : ( 'in' ) ;
    public final void rule__MaxTasks__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6711:1: ( ( 'in' ) )
            // InternalMyDsl.g:6712:1: ( 'in' )
            {
            // InternalMyDsl.g:6712:1: ( 'in' )
            // InternalMyDsl.g:6713:2: 'in'
            {
             before(grammarAccess.getMaxTasksAccess().getInKeyword_5_1_0()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getMaxTasksAccess().getInKeyword_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group_5_1__0__Impl"


    // $ANTLR start "rule__MaxTasks__Group_5_1__1"
    // InternalMyDsl.g:6722:1: rule__MaxTasks__Group_5_1__1 : rule__MaxTasks__Group_5_1__1__Impl rule__MaxTasks__Group_5_1__2 ;
    public final void rule__MaxTasks__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6726:1: ( rule__MaxTasks__Group_5_1__1__Impl rule__MaxTasks__Group_5_1__2 )
            // InternalMyDsl.g:6727:2: rule__MaxTasks__Group_5_1__1__Impl rule__MaxTasks__Group_5_1__2
            {
            pushFollow(FOLLOW_9);
            rule__MaxTasks__Group_5_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group_5_1__2();

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
    // $ANTLR end "rule__MaxTasks__Group_5_1__1"


    // $ANTLR start "rule__MaxTasks__Group_5_1__1__Impl"
    // InternalMyDsl.g:6734:1: rule__MaxTasks__Group_5_1__1__Impl : ( 'robot' ) ;
    public final void rule__MaxTasks__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6738:1: ( ( 'robot' ) )
            // InternalMyDsl.g:6739:1: ( 'robot' )
            {
            // InternalMyDsl.g:6739:1: ( 'robot' )
            // InternalMyDsl.g:6740:2: 'robot'
            {
             before(grammarAccess.getMaxTasksAccess().getRobotKeyword_5_1_1()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getMaxTasksAccess().getRobotKeyword_5_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group_5_1__1__Impl"


    // $ANTLR start "rule__MaxTasks__Group_5_1__2"
    // InternalMyDsl.g:6749:1: rule__MaxTasks__Group_5_1__2 : rule__MaxTasks__Group_5_1__2__Impl ;
    public final void rule__MaxTasks__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6753:1: ( rule__MaxTasks__Group_5_1__2__Impl )
            // InternalMyDsl.g:6754:2: rule__MaxTasks__Group_5_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MaxTasks__Group_5_1__2__Impl();

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
    // $ANTLR end "rule__MaxTasks__Group_5_1__2"


    // $ANTLR start "rule__MaxTasks__Group_5_1__2__Impl"
    // InternalMyDsl.g:6760:1: rule__MaxTasks__Group_5_1__2__Impl : ( ( rule__MaxTasks__RobotAssignment_5_1_2 ) ) ;
    public final void rule__MaxTasks__Group_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6764:1: ( ( ( rule__MaxTasks__RobotAssignment_5_1_2 ) ) )
            // InternalMyDsl.g:6765:1: ( ( rule__MaxTasks__RobotAssignment_5_1_2 ) )
            {
            // InternalMyDsl.g:6765:1: ( ( rule__MaxTasks__RobotAssignment_5_1_2 ) )
            // InternalMyDsl.g:6766:2: ( rule__MaxTasks__RobotAssignment_5_1_2 )
            {
             before(grammarAccess.getMaxTasksAccess().getRobotAssignment_5_1_2()); 
            // InternalMyDsl.g:6767:2: ( rule__MaxTasks__RobotAssignment_5_1_2 )
            // InternalMyDsl.g:6767:3: rule__MaxTasks__RobotAssignment_5_1_2
            {
            pushFollow(FOLLOW_2);
            rule__MaxTasks__RobotAssignment_5_1_2();

            state._fsp--;


            }

             after(grammarAccess.getMaxTasksAccess().getRobotAssignment_5_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__Group_5_1__2__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // InternalMyDsl.g:6776:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6780:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalMyDsl.g:6781:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EInt__Group__1();

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
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // InternalMyDsl.g:6788:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6792:1: ( ( ( '-' )? ) )
            // InternalMyDsl.g:6793:1: ( ( '-' )? )
            {
            // InternalMyDsl.g:6793:1: ( ( '-' )? )
            // InternalMyDsl.g:6794:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalMyDsl.g:6795:2: ( '-' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==79) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalMyDsl.g:6795:3: '-'
                    {
                    match(input,79,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // InternalMyDsl.g:6803:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6807:1: ( rule__EInt__Group__1__Impl )
            // InternalMyDsl.g:6808:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__1__Impl();

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
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // InternalMyDsl.g:6814:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6818:1: ( ( RULE_INT ) )
            // InternalMyDsl.g:6819:1: ( RULE_INT )
            {
            // InternalMyDsl.g:6819:1: ( RULE_INT )
            // InternalMyDsl.g:6820:2: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__EDouble__Group__0"
    // InternalMyDsl.g:6830:1: rule__EDouble__Group__0 : rule__EDouble__Group__0__Impl rule__EDouble__Group__1 ;
    public final void rule__EDouble__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6834:1: ( rule__EDouble__Group__0__Impl rule__EDouble__Group__1 )
            // InternalMyDsl.g:6835:2: rule__EDouble__Group__0__Impl rule__EDouble__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__EDouble__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__1();

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
    // $ANTLR end "rule__EDouble__Group__0"


    // $ANTLR start "rule__EDouble__Group__0__Impl"
    // InternalMyDsl.g:6842:1: rule__EDouble__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6846:1: ( ( ( '-' )? ) )
            // InternalMyDsl.g:6847:1: ( ( '-' )? )
            {
            // InternalMyDsl.g:6847:1: ( ( '-' )? )
            // InternalMyDsl.g:6848:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
            // InternalMyDsl.g:6849:2: ( '-' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==79) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMyDsl.g:6849:3: '-'
                    {
                    match(input,79,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__0__Impl"


    // $ANTLR start "rule__EDouble__Group__1"
    // InternalMyDsl.g:6857:1: rule__EDouble__Group__1 : rule__EDouble__Group__1__Impl rule__EDouble__Group__2 ;
    public final void rule__EDouble__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6861:1: ( rule__EDouble__Group__1__Impl rule__EDouble__Group__2 )
            // InternalMyDsl.g:6862:2: rule__EDouble__Group__1__Impl rule__EDouble__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__EDouble__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__2();

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
    // $ANTLR end "rule__EDouble__Group__1"


    // $ANTLR start "rule__EDouble__Group__1__Impl"
    // InternalMyDsl.g:6869:1: rule__EDouble__Group__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__EDouble__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6873:1: ( ( ( RULE_INT )? ) )
            // InternalMyDsl.g:6874:1: ( ( RULE_INT )? )
            {
            // InternalMyDsl.g:6874:1: ( ( RULE_INT )? )
            // InternalMyDsl.g:6875:2: ( RULE_INT )?
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
            // InternalMyDsl.g:6876:2: ( RULE_INT )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_INT) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalMyDsl.g:6876:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__1__Impl"


    // $ANTLR start "rule__EDouble__Group__2"
    // InternalMyDsl.g:6884:1: rule__EDouble__Group__2 : rule__EDouble__Group__2__Impl rule__EDouble__Group__3 ;
    public final void rule__EDouble__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6888:1: ( rule__EDouble__Group__2__Impl rule__EDouble__Group__3 )
            // InternalMyDsl.g:6889:2: rule__EDouble__Group__2__Impl rule__EDouble__Group__3
            {
            pushFollow(FOLLOW_72);
            rule__EDouble__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__3();

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
    // $ANTLR end "rule__EDouble__Group__2"


    // $ANTLR start "rule__EDouble__Group__2__Impl"
    // InternalMyDsl.g:6896:1: rule__EDouble__Group__2__Impl : ( '.' ) ;
    public final void rule__EDouble__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6900:1: ( ( '.' ) )
            // InternalMyDsl.g:6901:1: ( '.' )
            {
            // InternalMyDsl.g:6901:1: ( '.' )
            // InternalMyDsl.g:6902:2: '.'
            {
             before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__2__Impl"


    // $ANTLR start "rule__EDouble__Group__3"
    // InternalMyDsl.g:6911:1: rule__EDouble__Group__3 : rule__EDouble__Group__3__Impl rule__EDouble__Group__4 ;
    public final void rule__EDouble__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6915:1: ( rule__EDouble__Group__3__Impl rule__EDouble__Group__4 )
            // InternalMyDsl.g:6916:2: rule__EDouble__Group__3__Impl rule__EDouble__Group__4
            {
            pushFollow(FOLLOW_73);
            rule__EDouble__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__4();

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
    // $ANTLR end "rule__EDouble__Group__3"


    // $ANTLR start "rule__EDouble__Group__3__Impl"
    // InternalMyDsl.g:6923:1: rule__EDouble__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6927:1: ( ( RULE_INT ) )
            // InternalMyDsl.g:6928:1: ( RULE_INT )
            {
            // InternalMyDsl.g:6928:1: ( RULE_INT )
            // InternalMyDsl.g:6929:2: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__3__Impl"


    // $ANTLR start "rule__EDouble__Group__4"
    // InternalMyDsl.g:6938:1: rule__EDouble__Group__4 : rule__EDouble__Group__4__Impl ;
    public final void rule__EDouble__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6942:1: ( rule__EDouble__Group__4__Impl )
            // InternalMyDsl.g:6943:2: rule__EDouble__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group__4__Impl();

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
    // $ANTLR end "rule__EDouble__Group__4"


    // $ANTLR start "rule__EDouble__Group__4__Impl"
    // InternalMyDsl.g:6949:1: rule__EDouble__Group__4__Impl : ( ( rule__EDouble__Group_4__0 )? ) ;
    public final void rule__EDouble__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6953:1: ( ( ( rule__EDouble__Group_4__0 )? ) )
            // InternalMyDsl.g:6954:1: ( ( rule__EDouble__Group_4__0 )? )
            {
            // InternalMyDsl.g:6954:1: ( ( rule__EDouble__Group_4__0 )? )
            // InternalMyDsl.g:6955:2: ( rule__EDouble__Group_4__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_4()); 
            // InternalMyDsl.g:6956:2: ( rule__EDouble__Group_4__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=13 && LA41_0<=14)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalMyDsl.g:6956:3: rule__EDouble__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EDouble__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__4__Impl"


    // $ANTLR start "rule__EDouble__Group_4__0"
    // InternalMyDsl.g:6965:1: rule__EDouble__Group_4__0 : rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 ;
    public final void rule__EDouble__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6969:1: ( rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 )
            // InternalMyDsl.g:6970:2: rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1
            {
            pushFollow(FOLLOW_22);
            rule__EDouble__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__1();

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
    // $ANTLR end "rule__EDouble__Group_4__0"


    // $ANTLR start "rule__EDouble__Group_4__0__Impl"
    // InternalMyDsl.g:6977:1: rule__EDouble__Group_4__0__Impl : ( ( rule__EDouble__Alternatives_4_0 ) ) ;
    public final void rule__EDouble__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6981:1: ( ( ( rule__EDouble__Alternatives_4_0 ) ) )
            // InternalMyDsl.g:6982:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            {
            // InternalMyDsl.g:6982:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            // InternalMyDsl.g:6983:2: ( rule__EDouble__Alternatives_4_0 )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 
            // InternalMyDsl.g:6984:2: ( rule__EDouble__Alternatives_4_0 )
            // InternalMyDsl.g:6984:3: rule__EDouble__Alternatives_4_0
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Alternatives_4_0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__0__Impl"


    // $ANTLR start "rule__EDouble__Group_4__1"
    // InternalMyDsl.g:6992:1: rule__EDouble__Group_4__1 : rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 ;
    public final void rule__EDouble__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6996:1: ( rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 )
            // InternalMyDsl.g:6997:2: rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2
            {
            pushFollow(FOLLOW_22);
            rule__EDouble__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__2();

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
    // $ANTLR end "rule__EDouble__Group_4__1"


    // $ANTLR start "rule__EDouble__Group_4__1__Impl"
    // InternalMyDsl.g:7004:1: rule__EDouble__Group_4__1__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7008:1: ( ( ( '-' )? ) )
            // InternalMyDsl.g:7009:1: ( ( '-' )? )
            {
            // InternalMyDsl.g:7009:1: ( ( '-' )? )
            // InternalMyDsl.g:7010:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
            // InternalMyDsl.g:7011:2: ( '-' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==79) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMyDsl.g:7011:3: '-'
                    {
                    match(input,79,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__1__Impl"


    // $ANTLR start "rule__EDouble__Group_4__2"
    // InternalMyDsl.g:7019:1: rule__EDouble__Group_4__2 : rule__EDouble__Group_4__2__Impl ;
    public final void rule__EDouble__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7023:1: ( rule__EDouble__Group_4__2__Impl )
            // InternalMyDsl.g:7024:2: rule__EDouble__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__2__Impl();

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
    // $ANTLR end "rule__EDouble__Group_4__2"


    // $ANTLR start "rule__EDouble__Group_4__2__Impl"
    // InternalMyDsl.g:7030:1: rule__EDouble__Group_4__2__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7034:1: ( ( RULE_INT ) )
            // InternalMyDsl.g:7035:1: ( RULE_INT )
            {
            // InternalMyDsl.g:7035:1: ( RULE_INT )
            // InternalMyDsl.g:7036:2: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__2__Impl"


    // $ANTLR start "rule__ProblemSpecification__WorldModelAssignment_4"
    // InternalMyDsl.g:7046:1: rule__ProblemSpecification__WorldModelAssignment_4 : ( ruleWorldModel ) ;
    public final void rule__ProblemSpecification__WorldModelAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7050:1: ( ( ruleWorldModel ) )
            // InternalMyDsl.g:7051:2: ( ruleWorldModel )
            {
            // InternalMyDsl.g:7051:2: ( ruleWorldModel )
            // InternalMyDsl.g:7052:3: ruleWorldModel
            {
             before(grammarAccess.getProblemSpecificationAccess().getWorldModelWorldModelParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleWorldModel();

            state._fsp--;

             after(grammarAccess.getProblemSpecificationAccess().getWorldModelWorldModelParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__WorldModelAssignment_4"


    // $ANTLR start "rule__ProblemSpecification__WorldModelAssignment_5"
    // InternalMyDsl.g:7061:1: rule__ProblemSpecification__WorldModelAssignment_5 : ( ruleWorldModel ) ;
    public final void rule__ProblemSpecification__WorldModelAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7065:1: ( ( ruleWorldModel ) )
            // InternalMyDsl.g:7066:2: ( ruleWorldModel )
            {
            // InternalMyDsl.g:7066:2: ( ruleWorldModel )
            // InternalMyDsl.g:7067:3: ruleWorldModel
            {
             before(grammarAccess.getProblemSpecificationAccess().getWorldModelWorldModelParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleWorldModel();

            state._fsp--;

             after(grammarAccess.getProblemSpecificationAccess().getWorldModelWorldModelParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__WorldModelAssignment_5"


    // $ANTLR start "rule__ProblemSpecification__TasksModelAssignment_8"
    // InternalMyDsl.g:7076:1: rule__ProblemSpecification__TasksModelAssignment_8 : ( ruleTasksModel ) ;
    public final void rule__ProblemSpecification__TasksModelAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7080:1: ( ( ruleTasksModel ) )
            // InternalMyDsl.g:7081:2: ( ruleTasksModel )
            {
            // InternalMyDsl.g:7081:2: ( ruleTasksModel )
            // InternalMyDsl.g:7082:3: ruleTasksModel
            {
             before(grammarAccess.getProblemSpecificationAccess().getTasksModelTasksModelParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleTasksModel();

            state._fsp--;

             after(grammarAccess.getProblemSpecificationAccess().getTasksModelTasksModelParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__TasksModelAssignment_8"


    // $ANTLR start "rule__ProblemSpecification__TasksModelAssignment_9_1"
    // InternalMyDsl.g:7091:1: rule__ProblemSpecification__TasksModelAssignment_9_1 : ( ruleTasksModel ) ;
    public final void rule__ProblemSpecification__TasksModelAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7095:1: ( ( ruleTasksModel ) )
            // InternalMyDsl.g:7096:2: ( ruleTasksModel )
            {
            // InternalMyDsl.g:7096:2: ( ruleTasksModel )
            // InternalMyDsl.g:7097:3: ruleTasksModel
            {
             before(grammarAccess.getProblemSpecificationAccess().getTasksModelTasksModelParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTasksModel();

            state._fsp--;

             after(grammarAccess.getProblemSpecificationAccess().getTasksModelTasksModelParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__TasksModelAssignment_9_1"


    // $ANTLR start "rule__ProblemSpecification__RobotsModelAssignment_12"
    // InternalMyDsl.g:7106:1: rule__ProblemSpecification__RobotsModelAssignment_12 : ( ruleRobot ) ;
    public final void rule__ProblemSpecification__RobotsModelAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7110:1: ( ( ruleRobot ) )
            // InternalMyDsl.g:7111:2: ( ruleRobot )
            {
            // InternalMyDsl.g:7111:2: ( ruleRobot )
            // InternalMyDsl.g:7112:3: ruleRobot
            {
             before(grammarAccess.getProblemSpecificationAccess().getRobotsModelRobotParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleRobot();

            state._fsp--;

             after(grammarAccess.getProblemSpecificationAccess().getRobotsModelRobotParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__RobotsModelAssignment_12"


    // $ANTLR start "rule__ProblemSpecification__RobotsModelAssignment_13_1"
    // InternalMyDsl.g:7121:1: rule__ProblemSpecification__RobotsModelAssignment_13_1 : ( ruleRobot ) ;
    public final void rule__ProblemSpecification__RobotsModelAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7125:1: ( ( ruleRobot ) )
            // InternalMyDsl.g:7126:2: ( ruleRobot )
            {
            // InternalMyDsl.g:7126:2: ( ruleRobot )
            // InternalMyDsl.g:7127:3: ruleRobot
            {
             before(grammarAccess.getProblemSpecificationAccess().getRobotsModelRobotParserRuleCall_13_1_0()); 
            pushFollow(FOLLOW_2);
            ruleRobot();

            state._fsp--;

             after(grammarAccess.getProblemSpecificationAccess().getRobotsModelRobotParserRuleCall_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__RobotsModelAssignment_13_1"


    // $ANTLR start "rule__ProblemSpecification__MissionAssignment_16"
    // InternalMyDsl.g:7136:1: rule__ProblemSpecification__MissionAssignment_16 : ( ruleMission ) ;
    public final void rule__ProblemSpecification__MissionAssignment_16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7140:1: ( ( ruleMission ) )
            // InternalMyDsl.g:7141:2: ( ruleMission )
            {
            // InternalMyDsl.g:7141:2: ( ruleMission )
            // InternalMyDsl.g:7142:3: ruleMission
            {
             before(grammarAccess.getProblemSpecificationAccess().getMissionMissionParserRuleCall_16_0()); 
            pushFollow(FOLLOW_2);
            ruleMission();

            state._fsp--;

             after(grammarAccess.getProblemSpecificationAccess().getMissionMissionParserRuleCall_16_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__MissionAssignment_16"


    // $ANTLR start "rule__ProblemSpecification__MissionAssignment_17_1"
    // InternalMyDsl.g:7151:1: rule__ProblemSpecification__MissionAssignment_17_1 : ( ruleMission ) ;
    public final void rule__ProblemSpecification__MissionAssignment_17_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7155:1: ( ( ruleMission ) )
            // InternalMyDsl.g:7156:2: ( ruleMission )
            {
            // InternalMyDsl.g:7156:2: ( ruleMission )
            // InternalMyDsl.g:7157:3: ruleMission
            {
             before(grammarAccess.getProblemSpecificationAccess().getMissionMissionParserRuleCall_17_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMission();

            state._fsp--;

             after(grammarAccess.getProblemSpecificationAccess().getMissionMissionParserRuleCall_17_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProblemSpecification__MissionAssignment_17_1"


    // $ANTLR start "rule__Location__NameAssignment_0"
    // InternalMyDsl.g:7166:1: rule__Location__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Location__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7170:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7171:2: ( ruleEString )
            {
            // InternalMyDsl.g:7171:2: ( ruleEString )
            // InternalMyDsl.g:7172:3: ruleEString
            {
             before(grammarAccess.getLocationAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLocationAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__NameAssignment_0"


    // $ANTLR start "rule__Location__XAssignment_4"
    // InternalMyDsl.g:7181:1: rule__Location__XAssignment_4 : ( ruleEDouble ) ;
    public final void rule__Location__XAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7185:1: ( ( ruleEDouble ) )
            // InternalMyDsl.g:7186:2: ( ruleEDouble )
            {
            // InternalMyDsl.g:7186:2: ( ruleEDouble )
            // InternalMyDsl.g:7187:3: ruleEDouble
            {
             before(grammarAccess.getLocationAccess().getXEDoubleParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getLocationAccess().getXEDoubleParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__XAssignment_4"


    // $ANTLR start "rule__Location__YAssignment_6"
    // InternalMyDsl.g:7196:1: rule__Location__YAssignment_6 : ( ruleEDouble ) ;
    public final void rule__Location__YAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7200:1: ( ( ruleEDouble ) )
            // InternalMyDsl.g:7201:2: ( ruleEDouble )
            {
            // InternalMyDsl.g:7201:2: ( ruleEDouble )
            // InternalMyDsl.g:7202:3: ruleEDouble
            {
             before(grammarAccess.getLocationAccess().getYEDoubleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getLocationAccess().getYEDoubleParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__YAssignment_6"


    // $ANTLR start "rule__Location__DescriptionAssignment_7_2"
    // InternalMyDsl.g:7211:1: rule__Location__DescriptionAssignment_7_2 : ( ruleEString ) ;
    public final void rule__Location__DescriptionAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7215:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7216:2: ( ruleEString )
            {
            // InternalMyDsl.g:7216:2: ( ruleEString )
            // InternalMyDsl.g:7217:3: ruleEString
            {
             before(grammarAccess.getLocationAccess().getDescriptionEStringParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLocationAccess().getDescriptionEStringParserRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Location__DescriptionAssignment_7_2"


    // $ANTLR start "rule__Paths__Loc1Assignment_1"
    // InternalMyDsl.g:7226:1: rule__Paths__Loc1Assignment_1 : ( ( ruleEString ) ) ;
    public final void rule__Paths__Loc1Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7230:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7231:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7231:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7232:3: ( ruleEString )
            {
             before(grammarAccess.getPathsAccess().getLoc1LocationCrossReference_1_0()); 
            // InternalMyDsl.g:7233:3: ( ruleEString )
            // InternalMyDsl.g:7234:4: ruleEString
            {
             before(grammarAccess.getPathsAccess().getLoc1LocationEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPathsAccess().getLoc1LocationEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPathsAccess().getLoc1LocationCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paths__Loc1Assignment_1"


    // $ANTLR start "rule__Paths__Loc2Assignment_3"
    // InternalMyDsl.g:7245:1: rule__Paths__Loc2Assignment_3 : ( ( ruleEString ) ) ;
    public final void rule__Paths__Loc2Assignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7249:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7250:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7250:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7251:3: ( ruleEString )
            {
             before(grammarAccess.getPathsAccess().getLoc2LocationCrossReference_3_0()); 
            // InternalMyDsl.g:7252:3: ( ruleEString )
            // InternalMyDsl.g:7253:4: ruleEString
            {
             before(grammarAccess.getPathsAccess().getLoc2LocationEStringParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPathsAccess().getLoc2LocationEStringParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getPathsAccess().getLoc2LocationCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paths__Loc2Assignment_3"


    // $ANTLR start "rule__Paths__DistanceAssignment_5"
    // InternalMyDsl.g:7264:1: rule__Paths__DistanceAssignment_5 : ( ruleEDouble ) ;
    public final void rule__Paths__DistanceAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7268:1: ( ( ruleEDouble ) )
            // InternalMyDsl.g:7269:2: ( ruleEDouble )
            {
            // InternalMyDsl.g:7269:2: ( ruleEDouble )
            // InternalMyDsl.g:7270:3: ruleEDouble
            {
             before(grammarAccess.getPathsAccess().getDistanceEDoubleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getPathsAccess().getDistanceEDoubleParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Paths__DistanceAssignment_5"


    // $ANTLR start "rule__AtomicTask__NameAssignment_0"
    // InternalMyDsl.g:7279:1: rule__AtomicTask__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__AtomicTask__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7283:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7284:2: ( ruleEString )
            {
            // InternalMyDsl.g:7284:2: ( ruleEString )
            // InternalMyDsl.g:7285:3: ruleEString
            {
             before(grammarAccess.getAtomicTaskAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAtomicTaskAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__NameAssignment_0"


    // $ANTLR start "rule__AtomicTask__RobotsAssignment_2"
    // InternalMyDsl.g:7294:1: rule__AtomicTask__RobotsAssignment_2 : ( ruleEInt ) ;
    public final void rule__AtomicTask__RobotsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7298:1: ( ( ruleEInt ) )
            // InternalMyDsl.g:7299:2: ( ruleEInt )
            {
            // InternalMyDsl.g:7299:2: ( ruleEInt )
            // InternalMyDsl.g:7300:3: ruleEInt
            {
             before(grammarAccess.getAtomicTaskAccess().getRobotsEIntParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getAtomicTaskAccess().getRobotsEIntParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__RobotsAssignment_2"


    // $ANTLR start "rule__AtomicTask__LocAssignment_7"
    // InternalMyDsl.g:7309:1: rule__AtomicTask__LocAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__AtomicTask__LocAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7313:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7314:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7314:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7315:3: ( ruleEString )
            {
             before(grammarAccess.getAtomicTaskAccess().getLocLocationCrossReference_7_0()); 
            // InternalMyDsl.g:7316:3: ( ruleEString )
            // InternalMyDsl.g:7317:4: ruleEString
            {
             before(grammarAccess.getAtomicTaskAccess().getLocLocationEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAtomicTaskAccess().getLocLocationEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getAtomicTaskAccess().getLocLocationCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicTask__LocAssignment_7"


    // $ANTLR start "rule__CompoundTask__NameAssignment_0"
    // InternalMyDsl.g:7328:1: rule__CompoundTask__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__CompoundTask__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7332:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7333:2: ( ruleEString )
            {
            // InternalMyDsl.g:7333:2: ( ruleEString )
            // InternalMyDsl.g:7334:3: ruleEString
            {
             before(grammarAccess.getCompoundTaskAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCompoundTaskAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__NameAssignment_0"


    // $ANTLR start "rule__CompoundTask__CanDoTaskAssignment_4_0"
    // InternalMyDsl.g:7343:1: rule__CompoundTask__CanDoTaskAssignment_4_0 : ( ( ruleEString ) ) ;
    public final void rule__CompoundTask__CanDoTaskAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7347:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7348:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7348:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7349:3: ( ruleEString )
            {
             before(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelCrossReference_4_0_0()); 
            // InternalMyDsl.g:7350:3: ( ruleEString )
            // InternalMyDsl.g:7351:4: ruleEString
            {
             before(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelEStringParserRuleCall_4_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelEStringParserRuleCall_4_0_0_1()); 

            }

             after(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelCrossReference_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__CanDoTaskAssignment_4_0"


    // $ANTLR start "rule__CompoundTask__CanDoTaskAssignment_4_1_1"
    // InternalMyDsl.g:7362:1: rule__CompoundTask__CanDoTaskAssignment_4_1_1 : ( ( ruleEString ) ) ;
    public final void rule__CompoundTask__CanDoTaskAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7366:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7367:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7367:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7368:3: ( ruleEString )
            {
             before(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelCrossReference_4_1_1_0()); 
            // InternalMyDsl.g:7369:3: ( ruleEString )
            // InternalMyDsl.g:7370:4: ruleEString
            {
             before(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelEStringParserRuleCall_4_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelEStringParserRuleCall_4_1_1_0_1()); 

            }

             after(grammarAccess.getCompoundTaskAccess().getCanDoTaskTasksModelCrossReference_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__CanDoTaskAssignment_4_1_1"


    // $ANTLR start "rule__CompoundTask__OrderedAssignment_6_0_1"
    // InternalMyDsl.g:7381:1: rule__CompoundTask__OrderedAssignment_6_0_1 : ( ( 'ordered' ) ) ;
    public final void rule__CompoundTask__OrderedAssignment_6_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7385:1: ( ( ( 'ordered' ) ) )
            // InternalMyDsl.g:7386:2: ( ( 'ordered' ) )
            {
            // InternalMyDsl.g:7386:2: ( ( 'ordered' ) )
            // InternalMyDsl.g:7387:3: ( 'ordered' )
            {
             before(grammarAccess.getCompoundTaskAccess().getOrderedOrderedKeyword_6_0_1_0()); 
            // InternalMyDsl.g:7388:3: ( 'ordered' )
            // InternalMyDsl.g:7389:4: 'ordered'
            {
             before(grammarAccess.getCompoundTaskAccess().getOrderedOrderedKeyword_6_0_1_0()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getCompoundTaskAccess().getOrderedOrderedKeyword_6_0_1_0()); 

            }

             after(grammarAccess.getCompoundTaskAccess().getOrderedOrderedKeyword_6_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__OrderedAssignment_6_0_1"


    // $ANTLR start "rule__CompoundTask__ConsecutiveAssignment_6_1_1"
    // InternalMyDsl.g:7400:1: rule__CompoundTask__ConsecutiveAssignment_6_1_1 : ( ( 'consecutive' ) ) ;
    public final void rule__CompoundTask__ConsecutiveAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7404:1: ( ( ( 'consecutive' ) ) )
            // InternalMyDsl.g:7405:2: ( ( 'consecutive' ) )
            {
            // InternalMyDsl.g:7405:2: ( ( 'consecutive' ) )
            // InternalMyDsl.g:7406:3: ( 'consecutive' )
            {
             before(grammarAccess.getCompoundTaskAccess().getConsecutiveConsecutiveKeyword_6_1_1_0()); 
            // InternalMyDsl.g:7407:3: ( 'consecutive' )
            // InternalMyDsl.g:7408:4: 'consecutive'
            {
             before(grammarAccess.getCompoundTaskAccess().getConsecutiveConsecutiveKeyword_6_1_1_0()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getCompoundTaskAccess().getConsecutiveConsecutiveKeyword_6_1_1_0()); 

            }

             after(grammarAccess.getCompoundTaskAccess().getConsecutiveConsecutiveKeyword_6_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompoundTask__ConsecutiveAssignment_6_1_1"


    // $ANTLR start "rule__Robot__NameAssignment_0"
    // InternalMyDsl.g:7419:1: rule__Robot__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Robot__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7423:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7424:2: ( ruleEString )
            {
            // InternalMyDsl.g:7424:2: ( ruleEString )
            // InternalMyDsl.g:7425:3: ruleEString
            {
             before(grammarAccess.getRobotAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRobotAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__NameAssignment_0"


    // $ANTLR start "rule__Robot__InitLocAssignment_5"
    // InternalMyDsl.g:7434:1: rule__Robot__InitLocAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Robot__InitLocAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7438:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7439:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7439:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7440:3: ( ruleEString )
            {
             before(grammarAccess.getRobotAccess().getInitLocLocationCrossReference_5_0()); 
            // InternalMyDsl.g:7441:3: ( ruleEString )
            // InternalMyDsl.g:7442:4: ruleEString
            {
             before(grammarAccess.getRobotAccess().getInitLocLocationEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRobotAccess().getInitLocLocationEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getRobotAccess().getInitLocLocationCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__InitLocAssignment_5"


    // $ANTLR start "rule__Robot__VelocityAssignment_8"
    // InternalMyDsl.g:7453:1: rule__Robot__VelocityAssignment_8 : ( ruleEDouble ) ;
    public final void rule__Robot__VelocityAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7457:1: ( ( ruleEDouble ) )
            // InternalMyDsl.g:7458:2: ( ruleEDouble )
            {
            // InternalMyDsl.g:7458:2: ( ruleEDouble )
            // InternalMyDsl.g:7459:3: ruleEDouble
            {
             before(grammarAccess.getRobotAccess().getVelocityEDoubleParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getRobotAccess().getVelocityEDoubleParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__VelocityAssignment_8"


    // $ANTLR start "rule__Robot__CapabilitiesAssignment_12"
    // InternalMyDsl.g:7468:1: rule__Robot__CapabilitiesAssignment_12 : ( ruleCapability ) ;
    public final void rule__Robot__CapabilitiesAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7472:1: ( ( ruleCapability ) )
            // InternalMyDsl.g:7473:2: ( ruleCapability )
            {
            // InternalMyDsl.g:7473:2: ( ruleCapability )
            // InternalMyDsl.g:7474:3: ruleCapability
            {
             before(grammarAccess.getRobotAccess().getCapabilitiesCapabilityParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleCapability();

            state._fsp--;

             after(grammarAccess.getRobotAccess().getCapabilitiesCapabilityParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__CapabilitiesAssignment_12"


    // $ANTLR start "rule__Robot__CapabilitiesAssignment_13_1"
    // InternalMyDsl.g:7483:1: rule__Robot__CapabilitiesAssignment_13_1 : ( ruleCapability ) ;
    public final void rule__Robot__CapabilitiesAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7487:1: ( ( ruleCapability ) )
            // InternalMyDsl.g:7488:2: ( ruleCapability )
            {
            // InternalMyDsl.g:7488:2: ( ruleCapability )
            // InternalMyDsl.g:7489:3: ruleCapability
            {
             before(grammarAccess.getRobotAccess().getCapabilitiesCapabilityParserRuleCall_13_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCapability();

            state._fsp--;

             after(grammarAccess.getRobotAccess().getCapabilitiesCapabilityParserRuleCall_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Robot__CapabilitiesAssignment_13_1"


    // $ANTLR start "rule__Capability__AtAssignment_0"
    // InternalMyDsl.g:7498:1: rule__Capability__AtAssignment_0 : ( ( ruleEString ) ) ;
    public final void rule__Capability__AtAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7502:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7503:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7503:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7504:3: ( ruleEString )
            {
             before(grammarAccess.getCapabilityAccess().getAtAtomicTaskCrossReference_0_0()); 
            // InternalMyDsl.g:7505:3: ( ruleEString )
            // InternalMyDsl.g:7506:4: ruleEString
            {
             before(grammarAccess.getCapabilityAccess().getAtAtomicTaskEStringParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getCapabilityAccess().getAtAtomicTaskEStringParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getCapabilityAccess().getAtAtomicTaskCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__AtAssignment_0"


    // $ANTLR start "rule__Capability__TimeAssignment_3"
    // InternalMyDsl.g:7517:1: rule__Capability__TimeAssignment_3 : ( ruleEDouble ) ;
    public final void rule__Capability__TimeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7521:1: ( ( ruleEDouble ) )
            // InternalMyDsl.g:7522:2: ( ruleEDouble )
            {
            // InternalMyDsl.g:7522:2: ( ruleEDouble )
            // InternalMyDsl.g:7523:3: ruleEDouble
            {
             before(grammarAccess.getCapabilityAccess().getTimeEDoubleParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getCapabilityAccess().getTimeEDoubleParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__TimeAssignment_3"


    // $ANTLR start "rule__Capability__SuccessAssignment_7"
    // InternalMyDsl.g:7532:1: rule__Capability__SuccessAssignment_7 : ( ruleEDouble ) ;
    public final void rule__Capability__SuccessAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7536:1: ( ( ruleEDouble ) )
            // InternalMyDsl.g:7537:2: ( ruleEDouble )
            {
            // InternalMyDsl.g:7537:2: ( ruleEDouble )
            // InternalMyDsl.g:7538:3: ruleEDouble
            {
             before(grammarAccess.getCapabilityAccess().getSuccessEDoubleParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getCapabilityAccess().getSuccessEDoubleParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capability__SuccessAssignment_7"


    // $ANTLR start "rule__Mission__MissionTaskAssignment_0"
    // InternalMyDsl.g:7547:1: rule__Mission__MissionTaskAssignment_0 : ( ruleMissionTask ) ;
    public final void rule__Mission__MissionTaskAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7551:1: ( ( ruleMissionTask ) )
            // InternalMyDsl.g:7552:2: ( ruleMissionTask )
            {
            // InternalMyDsl.g:7552:2: ( ruleMissionTask )
            // InternalMyDsl.g:7553:3: ruleMissionTask
            {
             before(grammarAccess.getMissionAccess().getMissionTaskMissionTaskParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMissionTask();

            state._fsp--;

             after(grammarAccess.getMissionAccess().getMissionTaskMissionTaskParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__MissionTaskAssignment_0"


    // $ANTLR start "rule__Mission__MissionTaskAssignment_1_1"
    // InternalMyDsl.g:7562:1: rule__Mission__MissionTaskAssignment_1_1 : ( ruleMissionTask ) ;
    public final void rule__Mission__MissionTaskAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7566:1: ( ( ruleMissionTask ) )
            // InternalMyDsl.g:7567:2: ( ruleMissionTask )
            {
            // InternalMyDsl.g:7567:2: ( ruleMissionTask )
            // InternalMyDsl.g:7568:3: ruleMissionTask
            {
             before(grammarAccess.getMissionAccess().getMissionTaskMissionTaskParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMissionTask();

            state._fsp--;

             after(grammarAccess.getMissionAccess().getMissionTaskMissionTaskParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__MissionTaskAssignment_1_1"


    // $ANTLR start "rule__Mission__ObjAssignment_3"
    // InternalMyDsl.g:7577:1: rule__Mission__ObjAssignment_3 : ( ruleObjective ) ;
    public final void rule__Mission__ObjAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7581:1: ( ( ruleObjective ) )
            // InternalMyDsl.g:7582:2: ( ruleObjective )
            {
            // InternalMyDsl.g:7582:2: ( ruleObjective )
            // InternalMyDsl.g:7583:3: ruleObjective
            {
             before(grammarAccess.getMissionAccess().getObjObjectiveEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleObjective();

            state._fsp--;

             after(grammarAccess.getMissionAccess().getObjObjectiveEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__ObjAssignment_3"


    // $ANTLR start "rule__Mission__ObjAssignment_4_1"
    // InternalMyDsl.g:7592:1: rule__Mission__ObjAssignment_4_1 : ( ruleObjective ) ;
    public final void rule__Mission__ObjAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7596:1: ( ( ruleObjective ) )
            // InternalMyDsl.g:7597:2: ( ruleObjective )
            {
            // InternalMyDsl.g:7597:2: ( ruleObjective )
            // InternalMyDsl.g:7598:3: ruleObjective
            {
             before(grammarAccess.getMissionAccess().getObjObjectiveEnumRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleObjective();

            state._fsp--;

             after(grammarAccess.getMissionAccess().getObjObjectiveEnumRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__ObjAssignment_4_1"


    // $ANTLR start "rule__Mission__ConstraintsAssignment_5_1"
    // InternalMyDsl.g:7607:1: rule__Mission__ConstraintsAssignment_5_1 : ( ruleConstraints ) ;
    public final void rule__Mission__ConstraintsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7611:1: ( ( ruleConstraints ) )
            // InternalMyDsl.g:7612:2: ( ruleConstraints )
            {
            // InternalMyDsl.g:7612:2: ( ruleConstraints )
            // InternalMyDsl.g:7613:3: ruleConstraints
            {
             before(grammarAccess.getMissionAccess().getConstraintsConstraintsParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraints();

            state._fsp--;

             after(grammarAccess.getMissionAccess().getConstraintsConstraintsParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__ConstraintsAssignment_5_1"


    // $ANTLR start "rule__Mission__ConstraintsAssignment_5_2_1"
    // InternalMyDsl.g:7622:1: rule__Mission__ConstraintsAssignment_5_2_1 : ( ruleConstraints ) ;
    public final void rule__Mission__ConstraintsAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7626:1: ( ( ruleConstraints ) )
            // InternalMyDsl.g:7627:2: ( ruleConstraints )
            {
            // InternalMyDsl.g:7627:2: ( ruleConstraints )
            // InternalMyDsl.g:7628:3: ruleConstraints
            {
             before(grammarAccess.getMissionAccess().getConstraintsConstraintsParserRuleCall_5_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraints();

            state._fsp--;

             after(grammarAccess.getMissionAccess().getConstraintsConstraintsParserRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__ConstraintsAssignment_5_2_1"


    // $ANTLR start "rule__Mission__TimeAssignment_6_1_1"
    // InternalMyDsl.g:7637:1: rule__Mission__TimeAssignment_6_1_1 : ( ruleEInt ) ;
    public final void rule__Mission__TimeAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7641:1: ( ( ruleEInt ) )
            // InternalMyDsl.g:7642:2: ( ruleEInt )
            {
            // InternalMyDsl.g:7642:2: ( ruleEInt )
            // InternalMyDsl.g:7643:3: ruleEInt
            {
             before(grammarAccess.getMissionAccess().getTimeEIntParserRuleCall_6_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getMissionAccess().getTimeEIntParserRuleCall_6_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__TimeAssignment_6_1_1"


    // $ANTLR start "rule__Mission__NumAllocAssignment_6_2_1"
    // InternalMyDsl.g:7652:1: rule__Mission__NumAllocAssignment_6_2_1 : ( ruleEInt ) ;
    public final void rule__Mission__NumAllocAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7656:1: ( ( ruleEInt ) )
            // InternalMyDsl.g:7657:2: ( ruleEInt )
            {
            // InternalMyDsl.g:7657:2: ( ruleEInt )
            // InternalMyDsl.g:7658:3: ruleEInt
            {
             before(grammarAccess.getMissionAccess().getNumAllocEIntParserRuleCall_6_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getMissionAccess().getNumAllocEIntParserRuleCall_6_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__NumAllocAssignment_6_2_1"


    // $ANTLR start "rule__Mission__PopulationAssignment_6_3_1"
    // InternalMyDsl.g:7667:1: rule__Mission__PopulationAssignment_6_3_1 : ( ruleEInt ) ;
    public final void rule__Mission__PopulationAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7671:1: ( ( ruleEInt ) )
            // InternalMyDsl.g:7672:2: ( ruleEInt )
            {
            // InternalMyDsl.g:7672:2: ( ruleEInt )
            // InternalMyDsl.g:7673:3: ruleEInt
            {
             before(grammarAccess.getMissionAccess().getPopulationEIntParserRuleCall_6_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getMissionAccess().getPopulationEIntParserRuleCall_6_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__PopulationAssignment_6_3_1"


    // $ANTLR start "rule__Mission__EvaluationsAssignment_6_4_1"
    // InternalMyDsl.g:7682:1: rule__Mission__EvaluationsAssignment_6_4_1 : ( ruleEInt ) ;
    public final void rule__Mission__EvaluationsAssignment_6_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7686:1: ( ( ruleEInt ) )
            // InternalMyDsl.g:7687:2: ( ruleEInt )
            {
            // InternalMyDsl.g:7687:2: ( ruleEInt )
            // InternalMyDsl.g:7688:3: ruleEInt
            {
             before(grammarAccess.getMissionAccess().getEvaluationsEIntParserRuleCall_6_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getMissionAccess().getEvaluationsEIntParserRuleCall_6_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mission__EvaluationsAssignment_6_4_1"


    // $ANTLR start "rule__MissionTask__NameAssignment_1"
    // InternalMyDsl.g:7697:1: rule__MissionTask__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__MissionTask__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7701:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7702:2: ( ruleEString )
            {
            // InternalMyDsl.g:7702:2: ( ruleEString )
            // InternalMyDsl.g:7703:3: ruleEString
            {
             before(grammarAccess.getMissionTaskAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMissionTaskAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__NameAssignment_1"


    // $ANTLR start "rule__MissionTask__AtAssignment_3_0_2"
    // InternalMyDsl.g:7712:1: rule__MissionTask__AtAssignment_3_0_2 : ( ( ruleEString ) ) ;
    public final void rule__MissionTask__AtAssignment_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7716:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7717:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7717:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7718:3: ( ruleEString )
            {
             before(grammarAccess.getMissionTaskAccess().getAtAtomicTaskCrossReference_3_0_2_0()); 
            // InternalMyDsl.g:7719:3: ( ruleEString )
            // InternalMyDsl.g:7720:4: ruleEString
            {
             before(grammarAccess.getMissionTaskAccess().getAtAtomicTaskEStringParserRuleCall_3_0_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMissionTaskAccess().getAtAtomicTaskEStringParserRuleCall_3_0_2_0_1()); 

            }

             after(grammarAccess.getMissionTaskAccess().getAtAtomicTaskCrossReference_3_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__AtAssignment_3_0_2"


    // $ANTLR start "rule__MissionTask__CtAssignment_3_1_2"
    // InternalMyDsl.g:7731:1: rule__MissionTask__CtAssignment_3_1_2 : ( ( ruleEString ) ) ;
    public final void rule__MissionTask__CtAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7735:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7736:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7736:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7737:3: ( ruleEString )
            {
             before(grammarAccess.getMissionTaskAccess().getCtCompoundTaskCrossReference_3_1_2_0()); 
            // InternalMyDsl.g:7738:3: ( ruleEString )
            // InternalMyDsl.g:7739:4: ruleEString
            {
             before(grammarAccess.getMissionTaskAccess().getCtCompoundTaskEStringParserRuleCall_3_1_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMissionTaskAccess().getCtCompoundTaskEStringParserRuleCall_3_1_2_0_1()); 

            }

             after(grammarAccess.getMissionTaskAccess().getCtCompoundTaskCrossReference_3_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__CtAssignment_3_1_2"


    // $ANTLR start "rule__MissionTask__LocAssignment_4_2"
    // InternalMyDsl.g:7750:1: rule__MissionTask__LocAssignment_4_2 : ( ( ruleEString ) ) ;
    public final void rule__MissionTask__LocAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7754:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7755:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7755:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7756:3: ( ruleEString )
            {
             before(grammarAccess.getMissionTaskAccess().getLocLocationCrossReference_4_2_0()); 
            // InternalMyDsl.g:7757:3: ( ruleEString )
            // InternalMyDsl.g:7758:4: ruleEString
            {
             before(grammarAccess.getMissionTaskAccess().getLocLocationEStringParserRuleCall_4_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMissionTaskAccess().getLocLocationEStringParserRuleCall_4_2_0_1()); 

            }

             after(grammarAccess.getMissionTaskAccess().getLocLocationCrossReference_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissionTask__LocAssignment_4_2"


    // $ANTLR start "rule__RateSucc__RateSuccAssignment_1_5"
    // InternalMyDsl.g:7769:1: rule__RateSucc__RateSuccAssignment_1_5 : ( ruleEDouble ) ;
    public final void rule__RateSucc__RateSuccAssignment_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7773:1: ( ( ruleEDouble ) )
            // InternalMyDsl.g:7774:2: ( ruleEDouble )
            {
            // InternalMyDsl.g:7774:2: ( ruleEDouble )
            // InternalMyDsl.g:7775:3: ruleEDouble
            {
             before(grammarAccess.getRateSuccAccess().getRateSuccEDoubleParserRuleCall_1_5_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getRateSuccAccess().getRateSuccEDoubleParserRuleCall_1_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RateSucc__RateSuccAssignment_1_5"


    // $ANTLR start "rule__SpaceXYRobot__RobotAssignment_0_0_1"
    // InternalMyDsl.g:7784:1: rule__SpaceXYRobot__RobotAssignment_0_0_1 : ( ( ruleEString ) ) ;
    public final void rule__SpaceXYRobot__RobotAssignment_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7788:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7789:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7789:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7790:3: ( ruleEString )
            {
             before(grammarAccess.getSpaceXYRobotAccess().getRobotRobotCrossReference_0_0_1_0()); 
            // InternalMyDsl.g:7791:3: ( ruleEString )
            // InternalMyDsl.g:7792:4: ruleEString
            {
             before(grammarAccess.getSpaceXYRobotAccess().getRobotRobotEStringParserRuleCall_0_0_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSpaceXYRobotAccess().getRobotRobotEStringParserRuleCall_0_0_1_0_1()); 

            }

             after(grammarAccess.getSpaceXYRobotAccess().getRobotRobotCrossReference_0_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__RobotAssignment_0_0_1"


    // $ANTLR start "rule__SpaceXYRobot__AllrobotsAssignment_0_1_0"
    // InternalMyDsl.g:7803:1: rule__SpaceXYRobot__AllrobotsAssignment_0_1_0 : ( ( 'all' ) ) ;
    public final void rule__SpaceXYRobot__AllrobotsAssignment_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7807:1: ( ( ( 'all' ) ) )
            // InternalMyDsl.g:7808:2: ( ( 'all' ) )
            {
            // InternalMyDsl.g:7808:2: ( ( 'all' ) )
            // InternalMyDsl.g:7809:3: ( 'all' )
            {
             before(grammarAccess.getSpaceXYRobotAccess().getAllrobotsAllKeyword_0_1_0_0()); 
            // InternalMyDsl.g:7810:3: ( 'all' )
            // InternalMyDsl.g:7811:4: 'all'
            {
             before(grammarAccess.getSpaceXYRobotAccess().getAllrobotsAllKeyword_0_1_0_0()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getSpaceXYRobotAccess().getAllrobotsAllKeyword_0_1_0_0()); 

            }

             after(grammarAccess.getSpaceXYRobotAccess().getAllrobotsAllKeyword_0_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__AllrobotsAssignment_0_1_0"


    // $ANTLR start "rule__SpaceXYRobot__CoordinateAssignment_3"
    // InternalMyDsl.g:7822:1: rule__SpaceXYRobot__CoordinateAssignment_3 : ( ruleXY ) ;
    public final void rule__SpaceXYRobot__CoordinateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7826:1: ( ( ruleXY ) )
            // InternalMyDsl.g:7827:2: ( ruleXY )
            {
            // InternalMyDsl.g:7827:2: ( ruleXY )
            // InternalMyDsl.g:7828:3: ruleXY
            {
             before(grammarAccess.getSpaceXYRobotAccess().getCoordinateXYEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleXY();

            state._fsp--;

             after(grammarAccess.getSpaceXYRobotAccess().getCoordinateXYEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__CoordinateAssignment_3"


    // $ANTLR start "rule__SpaceXYRobot__LowerGreaterAssignment_4"
    // InternalMyDsl.g:7837:1: rule__SpaceXYRobot__LowerGreaterAssignment_4 : ( ruleLowerGreater ) ;
    public final void rule__SpaceXYRobot__LowerGreaterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7841:1: ( ( ruleLowerGreater ) )
            // InternalMyDsl.g:7842:2: ( ruleLowerGreater )
            {
            // InternalMyDsl.g:7842:2: ( ruleLowerGreater )
            // InternalMyDsl.g:7843:3: ruleLowerGreater
            {
             before(grammarAccess.getSpaceXYRobotAccess().getLowerGreaterLowerGreaterEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleLowerGreater();

            state._fsp--;

             after(grammarAccess.getSpaceXYRobotAccess().getLowerGreaterLowerGreaterEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__LowerGreaterAssignment_4"


    // $ANTLR start "rule__SpaceXYRobot__ValAssignment_6"
    // InternalMyDsl.g:7852:1: rule__SpaceXYRobot__ValAssignment_6 : ( ruleEDouble ) ;
    public final void rule__SpaceXYRobot__ValAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7856:1: ( ( ruleEDouble ) )
            // InternalMyDsl.g:7857:2: ( ruleEDouble )
            {
            // InternalMyDsl.g:7857:2: ( ruleEDouble )
            // InternalMyDsl.g:7858:3: ruleEDouble
            {
             before(grammarAccess.getSpaceXYRobotAccess().getValEDoubleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getSpaceXYRobotAccess().getValEDoubleParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpaceXYRobot__ValAssignment_6"


    // $ANTLR start "rule__TaskTime__AtAssignment_0_0_2"
    // InternalMyDsl.g:7867:1: rule__TaskTime__AtAssignment_0_0_2 : ( ( ruleEString ) ) ;
    public final void rule__TaskTime__AtAssignment_0_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7871:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7872:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7872:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7873:3: ( ruleEString )
            {
             before(grammarAccess.getTaskTimeAccess().getAtAtomicTaskCrossReference_0_0_2_0()); 
            // InternalMyDsl.g:7874:3: ( ruleEString )
            // InternalMyDsl.g:7875:4: ruleEString
            {
             before(grammarAccess.getTaskTimeAccess().getAtAtomicTaskEStringParserRuleCall_0_0_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTaskTimeAccess().getAtAtomicTaskEStringParserRuleCall_0_0_2_0_1()); 

            }

             after(grammarAccess.getTaskTimeAccess().getAtAtomicTaskCrossReference_0_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__AtAssignment_0_0_2"


    // $ANTLR start "rule__TaskTime__CtAssignment_0_1_2"
    // InternalMyDsl.g:7886:1: rule__TaskTime__CtAssignment_0_1_2 : ( ( ruleEString ) ) ;
    public final void rule__TaskTime__CtAssignment_0_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7890:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7891:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7891:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7892:3: ( ruleEString )
            {
             before(grammarAccess.getTaskTimeAccess().getCtCompoundTaskCrossReference_0_1_2_0()); 
            // InternalMyDsl.g:7893:3: ( ruleEString )
            // InternalMyDsl.g:7894:4: ruleEString
            {
             before(grammarAccess.getTaskTimeAccess().getCtCompoundTaskEStringParserRuleCall_0_1_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTaskTimeAccess().getCtCompoundTaskEStringParserRuleCall_0_1_2_0_1()); 

            }

             after(grammarAccess.getTaskTimeAccess().getCtCompoundTaskCrossReference_0_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__CtAssignment_0_1_2"


    // $ANTLR start "rule__TaskTime__MtAssignment_0_2_2"
    // InternalMyDsl.g:7905:1: rule__TaskTime__MtAssignment_0_2_2 : ( ( ruleEString ) ) ;
    public final void rule__TaskTime__MtAssignment_0_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7909:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7910:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7910:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7911:3: ( ruleEString )
            {
             before(grammarAccess.getTaskTimeAccess().getMtMissionTaskCrossReference_0_2_2_0()); 
            // InternalMyDsl.g:7912:3: ( ruleEString )
            // InternalMyDsl.g:7913:4: ruleEString
            {
             before(grammarAccess.getTaskTimeAccess().getMtMissionTaskEStringParserRuleCall_0_2_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTaskTimeAccess().getMtMissionTaskEStringParserRuleCall_0_2_2_0_1()); 

            }

             after(grammarAccess.getTaskTimeAccess().getMtMissionTaskCrossReference_0_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__MtAssignment_0_2_2"


    // $ANTLR start "rule__TaskTime__StartEndAssignment_2"
    // InternalMyDsl.g:7924:1: rule__TaskTime__StartEndAssignment_2 : ( ruleStartEnd ) ;
    public final void rule__TaskTime__StartEndAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7928:1: ( ( ruleStartEnd ) )
            // InternalMyDsl.g:7929:2: ( ruleStartEnd )
            {
            // InternalMyDsl.g:7929:2: ( ruleStartEnd )
            // InternalMyDsl.g:7930:3: ruleStartEnd
            {
             before(grammarAccess.getTaskTimeAccess().getStartEndStartEndEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStartEnd();

            state._fsp--;

             after(grammarAccess.getTaskTimeAccess().getStartEndStartEndEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__StartEndAssignment_2"


    // $ANTLR start "rule__TaskTime__TimeAssignment_4"
    // InternalMyDsl.g:7939:1: rule__TaskTime__TimeAssignment_4 : ( ruleEDouble ) ;
    public final void rule__TaskTime__TimeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7943:1: ( ( ruleEDouble ) )
            // InternalMyDsl.g:7944:2: ( ruleEDouble )
            {
            // InternalMyDsl.g:7944:2: ( ruleEDouble )
            // InternalMyDsl.g:7945:3: ruleEDouble
            {
             before(grammarAccess.getTaskTimeAccess().getTimeEDoubleParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getTaskTimeAccess().getTimeEDoubleParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskTime__TimeAssignment_4"


    // $ANTLR start "rule__AllocateT__AtAssignment_1_0_2"
    // InternalMyDsl.g:7954:1: rule__AllocateT__AtAssignment_1_0_2 : ( ( ruleEString ) ) ;
    public final void rule__AllocateT__AtAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7958:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7959:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7959:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7960:3: ( ruleEString )
            {
             before(grammarAccess.getAllocateTAccess().getAtAtomicTaskCrossReference_1_0_2_0()); 
            // InternalMyDsl.g:7961:3: ( ruleEString )
            // InternalMyDsl.g:7962:4: ruleEString
            {
             before(grammarAccess.getAllocateTAccess().getAtAtomicTaskEStringParserRuleCall_1_0_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAllocateTAccess().getAtAtomicTaskEStringParserRuleCall_1_0_2_0_1()); 

            }

             after(grammarAccess.getAllocateTAccess().getAtAtomicTaskCrossReference_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__AtAssignment_1_0_2"


    // $ANTLR start "rule__AllocateT__CtAssignment_1_1_2"
    // InternalMyDsl.g:7973:1: rule__AllocateT__CtAssignment_1_1_2 : ( ( ruleEString ) ) ;
    public final void rule__AllocateT__CtAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7977:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7978:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7978:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7979:3: ( ruleEString )
            {
             before(grammarAccess.getAllocateTAccess().getCtCompoundTaskCrossReference_1_1_2_0()); 
            // InternalMyDsl.g:7980:3: ( ruleEString )
            // InternalMyDsl.g:7981:4: ruleEString
            {
             before(grammarAccess.getAllocateTAccess().getCtCompoundTaskEStringParserRuleCall_1_1_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAllocateTAccess().getCtCompoundTaskEStringParserRuleCall_1_1_2_0_1()); 

            }

             after(grammarAccess.getAllocateTAccess().getCtCompoundTaskCrossReference_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__CtAssignment_1_1_2"


    // $ANTLR start "rule__AllocateT__MtAssignment_1_2_2"
    // InternalMyDsl.g:7992:1: rule__AllocateT__MtAssignment_1_2_2 : ( ( ruleEString ) ) ;
    public final void rule__AllocateT__MtAssignment_1_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7996:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7997:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7997:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7998:3: ( ruleEString )
            {
             before(grammarAccess.getAllocateTAccess().getMtMissionTaskCrossReference_1_2_2_0()); 
            // InternalMyDsl.g:7999:3: ( ruleEString )
            // InternalMyDsl.g:8000:4: ruleEString
            {
             before(grammarAccess.getAllocateTAccess().getMtMissionTaskEStringParserRuleCall_1_2_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAllocateTAccess().getMtMissionTaskEStringParserRuleCall_1_2_2_0_1()); 

            }

             after(grammarAccess.getAllocateTAccess().getMtMissionTaskCrossReference_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__MtAssignment_1_2_2"


    // $ANTLR start "rule__AllocateT__RobotAssignment_4"
    // InternalMyDsl.g:8011:1: rule__AllocateT__RobotAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__AllocateT__RobotAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8015:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8016:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8016:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8017:3: ( ruleEString )
            {
             before(grammarAccess.getAllocateTAccess().getRobotRobotCrossReference_4_0()); 
            // InternalMyDsl.g:8018:3: ( ruleEString )
            // InternalMyDsl.g:8019:4: ruleEString
            {
             before(grammarAccess.getAllocateTAccess().getRobotRobotEStringParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAllocateTAccess().getRobotRobotEStringParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getAllocateTAccess().getRobotRobotCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllocateT__RobotAssignment_4"


    // $ANTLR start "rule__Closest__AllAssignment_2_0_0"
    // InternalMyDsl.g:8030:1: rule__Closest__AllAssignment_2_0_0 : ( ( 'all' ) ) ;
    public final void rule__Closest__AllAssignment_2_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8034:1: ( ( ( 'all' ) ) )
            // InternalMyDsl.g:8035:2: ( ( 'all' ) )
            {
            // InternalMyDsl.g:8035:2: ( ( 'all' ) )
            // InternalMyDsl.g:8036:3: ( 'all' )
            {
             before(grammarAccess.getClosestAccess().getAllAllKeyword_2_0_0_0()); 
            // InternalMyDsl.g:8037:3: ( 'all' )
            // InternalMyDsl.g:8038:4: 'all'
            {
             before(grammarAccess.getClosestAccess().getAllAllKeyword_2_0_0_0()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getClosestAccess().getAllAllKeyword_2_0_0_0()); 

            }

             after(grammarAccess.getClosestAccess().getAllAllKeyword_2_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__AllAssignment_2_0_0"


    // $ANTLR start "rule__Closest__AtAssignment_2_1_2"
    // InternalMyDsl.g:8049:1: rule__Closest__AtAssignment_2_1_2 : ( ( ruleEString ) ) ;
    public final void rule__Closest__AtAssignment_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8053:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8054:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8054:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8055:3: ( ruleEString )
            {
             before(grammarAccess.getClosestAccess().getAtAtomicTaskCrossReference_2_1_2_0()); 
            // InternalMyDsl.g:8056:3: ( ruleEString )
            // InternalMyDsl.g:8057:4: ruleEString
            {
             before(grammarAccess.getClosestAccess().getAtAtomicTaskEStringParserRuleCall_2_1_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getClosestAccess().getAtAtomicTaskEStringParserRuleCall_2_1_2_0_1()); 

            }

             after(grammarAccess.getClosestAccess().getAtAtomicTaskCrossReference_2_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__AtAssignment_2_1_2"


    // $ANTLR start "rule__Closest__CtAssignment_2_2_2"
    // InternalMyDsl.g:8068:1: rule__Closest__CtAssignment_2_2_2 : ( ( ruleEString ) ) ;
    public final void rule__Closest__CtAssignment_2_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8072:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8073:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8073:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8074:3: ( ruleEString )
            {
             before(grammarAccess.getClosestAccess().getCtCompoundTaskCrossReference_2_2_2_0()); 
            // InternalMyDsl.g:8075:3: ( ruleEString )
            // InternalMyDsl.g:8076:4: ruleEString
            {
             before(grammarAccess.getClosestAccess().getCtCompoundTaskEStringParserRuleCall_2_2_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getClosestAccess().getCtCompoundTaskEStringParserRuleCall_2_2_2_0_1()); 

            }

             after(grammarAccess.getClosestAccess().getCtCompoundTaskCrossReference_2_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__CtAssignment_2_2_2"


    // $ANTLR start "rule__Closest__MtAssignment_2_3_2"
    // InternalMyDsl.g:8087:1: rule__Closest__MtAssignment_2_3_2 : ( ( ruleEString ) ) ;
    public final void rule__Closest__MtAssignment_2_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8091:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8092:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8092:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8093:3: ( ruleEString )
            {
             before(grammarAccess.getClosestAccess().getMtMissionTaskCrossReference_2_3_2_0()); 
            // InternalMyDsl.g:8094:3: ( ruleEString )
            // InternalMyDsl.g:8095:4: ruleEString
            {
             before(grammarAccess.getClosestAccess().getMtMissionTaskEStringParserRuleCall_2_3_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getClosestAccess().getMtMissionTaskEStringParserRuleCall_2_3_2_0_1()); 

            }

             after(grammarAccess.getClosestAccess().getMtMissionTaskCrossReference_2_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Closest__MtAssignment_2_3_2"


    // $ANTLR start "rule__MaxTasks__AllAssignment_5_0_0"
    // InternalMyDsl.g:8106:1: rule__MaxTasks__AllAssignment_5_0_0 : ( ( 'per' ) ) ;
    public final void rule__MaxTasks__AllAssignment_5_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8110:1: ( ( ( 'per' ) ) )
            // InternalMyDsl.g:8111:2: ( ( 'per' ) )
            {
            // InternalMyDsl.g:8111:2: ( ( 'per' ) )
            // InternalMyDsl.g:8112:3: ( 'per' )
            {
             before(grammarAccess.getMaxTasksAccess().getAllPerKeyword_5_0_0_0()); 
            // InternalMyDsl.g:8113:3: ( 'per' )
            // InternalMyDsl.g:8114:4: 'per'
            {
             before(grammarAccess.getMaxTasksAccess().getAllPerKeyword_5_0_0_0()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getMaxTasksAccess().getAllPerKeyword_5_0_0_0()); 

            }

             after(grammarAccess.getMaxTasksAccess().getAllPerKeyword_5_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__AllAssignment_5_0_0"


    // $ANTLR start "rule__MaxTasks__RobotAssignment_5_1_2"
    // InternalMyDsl.g:8125:1: rule__MaxTasks__RobotAssignment_5_1_2 : ( ( ruleEString ) ) ;
    public final void rule__MaxTasks__RobotAssignment_5_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8129:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8130:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8130:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8131:3: ( ruleEString )
            {
             before(grammarAccess.getMaxTasksAccess().getRobotRobotCrossReference_5_1_2_0()); 
            // InternalMyDsl.g:8132:3: ( ruleEString )
            // InternalMyDsl.g:8133:4: ruleEString
            {
             before(grammarAccess.getMaxTasksAccess().getRobotRobotEStringParserRuleCall_5_1_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMaxTasksAccess().getRobotRobotEStringParserRuleCall_5_1_2_0_1()); 

            }

             after(grammarAccess.getMaxTasksAccess().getRobotRobotCrossReference_5_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__RobotAssignment_5_1_2"


    // $ANTLR start "rule__MaxTasks__NumAssignment_7"
    // InternalMyDsl.g:8144:1: rule__MaxTasks__NumAssignment_7 : ( ruleEInt ) ;
    public final void rule__MaxTasks__NumAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8148:1: ( ( ruleEInt ) )
            // InternalMyDsl.g:8149:2: ( ruleEInt )
            {
            // InternalMyDsl.g:8149:2: ( ruleEInt )
            // InternalMyDsl.g:8150:3: ruleEInt
            {
             before(grammarAccess.getMaxTasksAccess().getNumEIntParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getMaxTasksAccess().getNumEIntParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MaxTasks__NumAssignment_7"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String dfa_1s = "\25\uffff";
    static final String dfa_2s = "\1\1\24\uffff";
    static final String dfa_3s = "\1\14\3\uffff\1\77\1\uffff\3\100\1\uffff\3\4\6\45\1\14\1\uffff";
    static final String dfa_4s = "\1\123\3\uffff\1\123\1\uffff\3\100\1\uffff\3\5\6\45\1\112\1\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\3\uffff\1\5\12\uffff\1\4";
    static final String dfa_6s = "\25\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\22\uffff\2\1\32\uffff\1\1\3\uffff\1\3\1\uffff\1\3\1\1\5\uffff\1\3\1\4\2\uffff\1\5\6\uffff\1\2",
            "",
            "",
            "",
            "\1\6\1\uffff\1\7\6\uffff\1\10\12\uffff\1\11",
            "",
            "\1\12",
            "\1\13",
            "\1\14",
            "",
            "\1\15\1\16",
            "\1\17\1\20",
            "\1\21\1\22",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\24\75\uffff\1\11",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "746:1: rule__Constraints__Alternatives : ( ( ruleRateSucc ) | ( ruleSpaceXYRobot ) | ( ruleTaskTime ) | ( ruleAllocateT ) | ( ruleClosest ) | ( ruleMaxTasks ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000001000000030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000001010000030L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000001000000032L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000120000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000040L,0x0000000000018000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000040L,0x0000000000008000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000100000000030L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0200000100000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0C00000100000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x8000000000001000L,0x0000000000081306L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x7020000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000102L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x8000000000000000L,0x0000000000080102L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100040L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000006000L});

}