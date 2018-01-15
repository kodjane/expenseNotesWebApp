/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author AIK
 */
@Entity
@Table(name = "people")
@NamedQueries({
    @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p")})
public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PEOPLE_ID")
    private Long peopleId;
    @Column(name = "ABSENCEALLOWANCESTARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date absenceallowancestartdate;
    @Size(max = 50)
    @Column(name = "ABSENTEEISMSCHEME")
    private String absenteeismscheme;
    @Size(max = 50)
    @Column(name = "ADDRESS1")
    private String address1;
    @Size(max = 50)
    @Column(name = "ADDRESS2")
    private String address2;
    @Size(max = 50)
    @Column(name = "ADDRESS3")
    private String address3;
    @Column(name = "AGE")
    private Integer age;
    @Size(max = 50)
    @Column(name = "AGECALCULATED")
    private String agecalculated;
    @Column(name = "ALIENREGISTRATIONCARD")
    private Character alienregistrationcard;
    @Column(name = "ANNIVERSARYDOJ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anniversarydoj;
    @Column(name = "APPRAISALUPDATE")
    private Character appraisalupdate;
    @Column(name = "ATTACHEDCRIMINALRECORD")
    private Character attachedcriminalrecord;
    @Column(name = "ATTACHEDCV")
    private Character attachedcv;
    @Column(name = "ATTACHEDID")
    private Character attachedid;
    @Column(name = "ATTACHEDPICTURE")
    private Character attachedpicture;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "BEBONOTES")
    private String bebonotes;
    @Size(max = 20)
    @Column(name = "BEBOPROFILE")
    private String beboprofile;
    @Size(max = 11)
    @Column(name = "BENATIONALREGISTERID")
    private String benationalregisterid;
    @Size(max = 15)
    @Column(name = "BESOCIALSECURITYOVERSEAS")
    private String besocialsecurityoverseas;
    @Size(max = 50)
    @Column(name = "BIRTHCOUNTRY")
    private String birthcountry;
    @Size(max = 50)
    @Column(name = "BIRTHPLACE")
    private String birthplace;
    @Column(name = "BLACKBERRY")
    private Character blackberry;
    @Column(name = "BLOCKEDBYSHU")
    private Character blockedbyshu;
    @Column(name = "CANDIDATEFLAG")
    private Character candidateflag;
    @Column(name = "CARPARKPASS")
    private Character carparkpass;
    @Size(max = 50)
    @Column(name = "CARSELECTED")
    private String carselected;
    @Column(name = "CERTIFICATEOFBIRTHABROAD")
    private Character certificateofbirthabroad;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Column(name = "COACHFLAG")
    private Character coachflag;
    @Size(max = 50)
    @Column(name = "CONTRACTINGSECTION")
    private String contractingsection;
    @Column(name = "CONTRACTORFLAG")
    private Character contractorflag;
    @Size(max = 20)
    @Column(name = "CONTRACTSTATUS")
    private String contractstatus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COUNT")
    private BigDecimal count;
    @Size(max = 50)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 50)
    @Column(name = "COUNTY")
    private String county;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "COVERINGABOUT")
    private String coveringabout;
    @Size(max = 50)
    @Column(name = "CPD")
    private String cpd;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "CREATEDBY")
    private String createdby;
    @Column(name = "CURRENTBIRTHDAY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currentbirthday;
    @Column(name = "DATEACCESSMENTCENTER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateaccessmentcenter;
    @Column(name = "DATECREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Column(name = "DATEJOINEDOVERSEASOFFICE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datejoinedoverseasoffice;
    @Column(name = "DATELASTMODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastmodified;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofbirth;
    @Column(name = "DATEOFDEATH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofdeath;
    @Column(name = "DATEOFJOIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofjoin;
    @Column(name = "DATEOFLEAVING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofleaving;
    @Column(name = "DATEOFRETIREMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofretirement;
    @Column(name = "DATERECRUITED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daterecruited;
    @Column(name = "DATEWHEN60")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datewhen60;
    @Column(name = "DAYOFBIRTHDAY")
    private Integer dayofbirthday;
    @Column(name = "DBPEOPLENUMBER")
    private Integer dbpeoplenumber;
    @Column(name = "DEL")
    private Character del;
    @Column(name = "DIRECTOR")
    private Character director;
    @Column(name = "DIRECTORTAXWEEK")
    private Integer directortaxweek;
    @Size(max = 20)
    @Column(name = "DISABILITYREGNUMBER")
    private String disabilityregnumber;
    @Column(name = "DISABLED")
    private Character disabled;
    @Column(name = "DOJPLUS6MONTHS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dojplus6months;
    @Size(max = 20)
    @Column(name = "DOVETAILNUMBER")
    private String dovetailnumber;
    @Column(name = "DRIVERSLICENCE")
    private Character driverslicence;
    @Size(max = 50)
    @Column(name = "DRIVINGLICENCE")
    private String drivinglicence;
    @Size(max = 20)
    @Column(name = "DRIVINGLICENCENO")
    private String drivinglicenceno;
    @Size(max = 50)
    @Column(name = "EEOCATEGORY")
    private String eeocategory;
    @Size(max = 20)
    @Column(name = "EEOCODE")
    private String eeocode;
    @Size(max = 255)
    @Column(name = "EMAILPRIMARY")
    private String emailprimary;
    @Size(max = 255)
    @Column(name = "EMAILSECONDARY")
    private String emailsecondary;
    @Size(max = 255)
    @Column(name = "EMAILWORKFLOW")
    private String emailworkflow;
    @Column(name = "EMPLOYEEFLAG")
    private Character employeeflag;
    @Size(max = 7)
    @Column(name = "EMPLOYEESTATUS")
    private String employeestatus;
    @Size(max = 50)
    @Column(name = "EMPLOYEETYPE")
    private String employeetype;
    @Column(name = "EMPLOYMENTAUTHENTICATION")
    private Character employmentauthentication;
    @Column(name = "ENDOFPROBATIONCALC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endofprobationcalc;
    @Column(name = "ENDOFPROBATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endofprobationdate;
    @Size(max = 50)
    @Column(name = "ETHNICITY")
    private String ethnicity;
    @Column(name = "EXPECTEDRETIREMENTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedretirementdate;
    @Column(name = "FATHERSDATEOFBIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fathersdateofbirth;
    @Size(max = 50)
    @Column(name = "FATHERSFIRSTNAME")
    private String fathersfirstname;
    @Size(max = 50)
    @Column(name = "FATHERSLASTNAME")
    private String fatherslastname;
    @Size(max = 30)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "FLAGREPORTSTO")
    private Character flagreportsto;
    @Size(max = 50)
    @Column(name = "FLEETSELECTION")
    private String fleetselection;
    @Size(max = 112)
    @Column(name = "FORMALNAME")
    private String formalname;
    @Size(max = 61)
    @Column(name = "FULLNAME")
    private String fullname;
    @Size(max = 50)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 20)
    @Column(name = "HINDIFIRSTNAME")
    private String hindifirstname;
    @Size(max = 20)
    @Column(name = "HINDILASTNAME")
    private String hindilastname;
    @Size(max = 50)
    @Column(name = "HOMETELEPHONE")
    private String hometelephone;
    @Column(name = "I9RENEWALDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date i9renewaldate;
    @Column(name = "IDCARD")
    private Character idcard;
    @Size(max = 50)
    @Column(name = "IDCARDNUM")
    private String idcardnum;
    @Size(max = 10)
    @Column(name = "INITIALS")
    private String initials;
    @Size(max = 100)
    @Column(name = "Job")
    private String job;
    @Size(max = 30)
    @Column(name = "KNOWNAS")
    private String knownas;
    @Column(name = "LAPTOP")
    private Character laptop;
    @Column(name = "LASTDAYINOFFICE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastdayinoffice;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "LASTMODIFIEDBY")
    private String lastmodifiedby;
    @Size(max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "LAWSOCIETYADMISSIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lawsocietyadmissiondate;
    @Size(max = 20)
    @Column(name = "LAWSOCIETYMEMBERSHIPNUMBER")
    private String lawsocietymembershipnumber;
    @Size(max = 50)
    @Column(name = "LAWSOCIETYSTATUS")
    private String lawsocietystatus;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "LEAVINGDETAILS")
    private String leavingdetails;
    @Size(max = 50)
    @Column(name = "LEGALLANGUAGE")
    private String legallanguage;
    @Column(name = "LENGTHOFSERVICE")
    private Integer lengthofservice;
    @Size(max = 50)
    @Column(name = "LENGTHOFSERVICECUSTOM")
    private String lengthofservicecustom;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "LINKEDINNOTES")
    private String linkedinnotes;
    @Size(max = 50)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 30)
    @Column(name = "MAIDENNAME")
    private String maidenname;
    @Size(max = 10)
    @Column(name = "MAILBOX")
    private String mailbox;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "MAINFUNCTIONABOUT")
    private String mainfunctionabout;
    @Size(max = 50)
    @Column(name = "MARITALSTATUS")
    private String maritalstatus;
    @Size(max = 50)
    @Column(name = "MARITALSTATUSVALUE")
    private String maritalstatusvalue;
    @Column(name = "MARRIAGEGIFT")
    private Character marriagegift;
    @Column(name = "MENTORFLAG")
    private Character mentorflag;
    @Size(max = 50)
    @Column(name = "MGRDELEGATOR")
    private String mgrdelegator;
    @Column(name = "MGRDELEGATORENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mgrdelegatorenddate;
    @Column(name = "MGRDELEGATORSTARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mgrdelegatorstartdate;
    @Size(max = 50)
    @Column(name = "MIDDLENAMES")
    private String middlenames;
    @Size(max = 20)
    @Column(name = "MISSIONTAG")
    private String missiontag;
    @Column(name = "MOBILE")
    private Character mobile;
    @Size(max = 50)
    @Column(name = "MOBILETELEPHONE")
    private String mobiletelephone;
    @Size(max = 50)
    @Column(name = "MOBILITY")
    private String mobility;
    @Size(max = 50)
    @Column(name = "MOBILITYAREAPREFERENCE1")
    private String mobilityareapreference1;
    @Size(max = 50)
    @Column(name = "MOBILITYAREAPREFERENCE2")
    private String mobilityareapreference2;
    @Size(max = 50)
    @Column(name = "MOBILITYAREAPREFERENCE3")
    private String mobilityareapreference3;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "MOBILITYNOTES")
    private String mobilitynotes;
    @Size(max = 50)
    @Column(name = "MOBILITYREGIONPREFERENCE1")
    private String mobilityregionpreference1;
    @Size(max = 50)
    @Column(name = "MOBILITYREGIONPREFERENCE2")
    private String mobilityregionpreference2;
    @Size(max = 50)
    @Column(name = "MOBILITYREGIONPREFERENCE3")
    private String mobilityregionpreference3;
    @Column(name = "MONTHOFBIRTHDAY")
    private Integer monthofbirthday;
    @Column(name = "MOTHERSDATEOFBIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mothersdateofbirth;
    @Size(max = 50)
    @Column(name = "MOTHERSFIRSTNAME")
    private String mothersfirstname;
    @Size(max = 50)
    @Column(name = "MOTHERSLASTNAME")
    private String motherslastname;
    @Size(max = 255)
    @Column(name = "MSFEMAIL")
    private String msfemail;
    @Size(max = 50)
    @Column(name = "MSFLANGUAGE")
    private String msflanguage;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "MYSPACENOTES")
    private String myspacenotes;
    @Size(max = 74)
    @Column(name = "NAMEPLUSREFNO")
    private String nameplusrefno;
    @Size(max = 50)
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "NATIONALSTAFF")
    private Character nationalstaff;
    @Column(name = "NATIVEAMERICANTRIBALDOCUMENT")
    private Character nativeamericantribaldocument;
    @Column(name = "NEXTBIRTHDAY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextbirthday;
    @Column(name = "NEXTBIRTHDAYPLUS1YEAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextbirthdayplus1year;
    @Size(max = 20)
    @Column(name = "NINUMBER")
    private String ninumber;
    @Size(max = 50)
    @Column(name = "NIRATE")
    private String nirate;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "NOTESLAW")
    private String noteslaw;
    @Size(max = 50)
    @Column(name = "NOTICEPERIOD")
    private String noticeperiod;
    @Column(name = "NUMBEROFCHILDREN")
    private Integer numberofchildren;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "OTHERROLESABOUT")
    private String otherrolesabout;
    @Size(max = 50)
    @Column(name = "OUTCOMEOFPROBATION")
    private String outcomeofprobation;
    @Size(max = 20)
    @Column(name = "PAGER")
    private String pager;
    @Size(max = 50)
    @Column(name = "PAYMENTMETHOD")
    private String paymentmethod;
    @Size(max = 50)
    @Column(name = "PAYRANGES")
    private String payranges;
    @Size(max = 50)
    @Column(name = "PAYROLL")
    private String payroll;
    @Size(max = 20)
    @Column(name = "PAYROLLNUMBER")
    private String payrollnumber;
    @Column(name = "PERMANENTRESIDENCECARD")
    private Character permanentresidencecard;
    @Size(max = 50)
    @Column(name = "PERSONALNOTES")
    private String personalnotes;
    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;
    @Size(max = 50)
    @Column(name = "PMISELECTION")
    private String pmiselection;
    @Column(name = "POOLFLAG")
    private Character poolflag;
    @Size(max = 10)
    @Column(name = "POSTCODE")
    private String postcode;
    @Size(max = 20)
    @Column(name = "PREVIOUSEMPLOYEEREFERENCE")
    private String previousemployeereference;
    @Size(max = 30)
    @Column(name = "PREVIOUSLASTNAME")
    private String previouslastname;
    @Column(name = "PROBATIONDATECALCULATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date probationdatecalculated;
    @Column(name = "PROBATIONEXTENDEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date probationextendeddate;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "PROBATIONNOTES")
    private String probationnotes;
    @Size(max = 50)
    @Column(name = "PSYFPOFOFFICE")
    private String psyfpofoffice;
    @Size(max = 50)
    @Column(name = "PSYFPOFSECTION")
    private String psyfpofsection;
    @Size(max = 50)
    @Column(name = "PUBLICHOLIDAYSCHEME")
    private String publicholidayscheme;
    @Size(max = 50)
    @Column(name = "QLTTBYWHOM")
    private String qlttbywhom;
    @Column(name = "QLTTCERTIFICATESEEN")
    private Character qlttcertificateseen;
    @Column(name = "QLTTCOMPLETED")
    private Character qlttcompleted;
    @Column(name = "QLTTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date qlttdate;
    @Size(max = 50)
    @Column(name = "REASONFORLEAVING")
    private String reasonforleaving;
    @Size(max = 50)
    @Column(name = "RECRUITEDAS")
    private String recruitedas;
    @Size(max = 50)
    @Column(name = "RECRUITEDBY")
    private String recruitedby;
    @Size(max = 50)
    @Column(name = "RECRUITEROFOFFICE")
    private String recruiterofoffice;
    @Size(max = 50)
    @Column(name = "RECRUITEROFSECTION")
    private String recruiterofsection;
    @Column(name = "RECRUITINGDOCSCERTIFMEDICAL")
    private Character recruitingdocscertifmedical;
    @Column(name = "RECRUITINGDOCSDEPENDANTS")
    private Character recruitingdocsdependants;
    @Column(name = "RECRUITINGDOCSEDUCATION")
    private Character recruitingdocseducation;
    @Column(name = "RECRUITINGDOCSMEDICAL")
    private Character recruitingdocsmedical;
    @Column(name = "RECRUITINGDOCSPASSPORT")
    private Character recruitingdocspassport;
    @Column(name = "RECRUITINGDOCSPERSONAL")
    private Character recruitingdocspersonal;
    @Column(name = "RECRUITINGDOCSPREVEMPLOYMENT")
    private Character recruitingdocsprevemployment;
    @Size(max = 50)
    @Column(name = "RECRUITINGOFFICE")
    private String recruitingoffice;
    @Size(max = 50)
    @Column(name = "RECRUITINGSECTION")
    private String recruitingsection;
    @Column(name = "REFERENCEHERO")
    private Integer referencehero;
    @Size(max = 10)
    @Column(name = "REFERENCENUMBER")
    private String referencenumber;
    @Size(max = 50)
    @Column(name = "RELIGION")
    private String religion;
    @Size(max = 50)
    @Column(name = "REPORTSTO")
    private String reportsto;
    @Size(max = 50)
    @Column(name = "REPORTSTOBEFOREDELEGATION")
    private String reportstobeforedelegation;
    @Size(max = 30)
    @Column(name = "REPORTSTOFIRSTNAME")
    private String reportstofirstname;
    @Size(max = 61)
    @Column(name = "REPORTSTOFULLNAME")
    private String reportstofullname;
    @Size(max = 30)
    @Column(name = "REPORTSTOLASTNAME")
    private String reportstolastname;
    @Column(name = "RETIREMENTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retirementdate;
    @Size(max = 30)
    @Column(name = "REVIEW")
    private String review;
    @Size(max = 50)
    @Column(name = "RISKOFLEAVING")
    private String riskofleaving;
    @Size(max = 3)
    @Column(name = "RPAPPROACHINGRETIREMENT")
    private String rpapproachingretirement;
    @Column(name = "SCANNEDW4DOCUMENT")
    private Character scannedw4document;
    @Size(max = 50)
    @Column(name = "SCNDADDRESS1")
    private String scndaddress1;
    @Size(max = 50)
    @Column(name = "SCNDADDRESS2")
    private String scndaddress2;
    @Size(max = 50)
    @Column(name = "SCNDADDRESS3")
    private String scndaddress3;
    @Size(max = 50)
    @Column(name = "SCNDCITY")
    private String scndcity;
    @Size(max = 50)
    @Column(name = "SCNDCOUNTRY")
    private String scndcountry;
    @Size(max = 10)
    @Column(name = "SCNDMAILBOX")
    private String scndmailbox;
    @Size(max = 10)
    @Column(name = "SCNDPOSTCODE")
    private String scndpostcode;
    @Size(max = 10)
    @Column(name = "SCNDSTREETNUMBER")
    private String scndstreetnumber;
    @Size(max = 20)
    @Column(name = "SCONNO")
    private String sconno;
    @Size(max = 50)
    @Column(name = "SECONDNATIONALITY")
    private String secondnationality;
    @Size(max = 50)
    @Column(name = "SECRETARY")
    private String secretary;
    @Column(name = "SENDAPPRAISALNOTIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendappraisalnotification;
    @Column(name = "SENDBIRTHDAYREMINDER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendbirthdayreminder;
    @Size(max = 50)
    @Column(name = "SEXUALORIENTATION")
    private String sexualorientation;
    @Size(max = 50)
    @Column(name = "SICKALLOW")
    private String sickallow;
    @Size(max = 50)
    @Column(name = "SKYPE")
    private String skype;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "SPINALPOINT")
    private String spinalpoint;
    @Size(max = 50)
    @Column(name = "SSDATE")
    private String ssdate;
    @Column(name = "SSP")
    private Character ssp;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Size(max = 50)
    @Column(name = "STARTTYPE")
    private String starttype;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 10)
    @Column(name = "STREETNUMBER")
    private String streetnumber;
    @Size(max = 50)
    @Column(name = "STUDYLEVEL")
    private String studylevel;
    @Size(max = 50)
    @Column(name = "SUBMITTINGUSER")
    private String submittinguser;
    @Size(max = 50)
    @Column(name = "SUPERVISOR")
    private String supervisor;
    @Column(name = "SUPPLIER")
    private Character supplier;
    @Column(name = "SWIPECARD")
    private Character swipecard;
    @Size(max = 10)
    @Column(name = "TAXCODE")
    private String taxcode;
    @Size(max = 92)
    @Column(name = "TEXTDATEOFBIRTH")
    private String textdateofbirth;
    @Size(max = 92)
    @Column(name = "TEXTDATEOFJOIN")
    private String textdateofjoin;
    @Size(max = 92)
    @Column(name = "TEXTDATEOFLEAVING")
    private String textdateofleaving;
    @Size(max = 50)
    @Column(name = "TEXTPAYMENTMETHOD")
    private String textpaymentmethod;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "TRAINERFLAG")
    private Character trainerflag;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "UpChain")
    private String upChain;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "up_chain")
    private String upChain1;
    @Column(name = "USAC")
    private Character usac;
    @Column(name = "USCITIZENIDCARD")
    private Character uscitizenidcard;
    @Column(name = "USERBYADMIN")
    private Character userbyadmin;
    @Column(name = "USERBYPOOLMANAGER")
    private Character userbypoolmanager;
    @Column(name = "USERBYRECRUITER")
    private Character userbyrecruiter;
    @Column(name = "USERDATECREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userdatecreated;
    @Size(max = 20)
    @Column(name = "USERID")
    private String userid;
    @Column(name = "USPASSPORT")
    private Character uspassport;
    @Column(name = "USSOCIALSECURITYCARD")
    private Character ussocialsecuritycard;
    @Size(max = 50)
    @Column(name = "VACANCY")
    private String vacancy;
    @Column(name = "VOLUNTEER")
    private Character volunteer;
    @Size(max = 50)
    @Column(name = "W4STATUS")
    private String w4status;
    @Column(name = "WK1MT1")
    private Character wk1mt1;
    @Size(max = 20)
    @Column(name = "WORKEXT")
    private String workext;
    @Size(max = 20)
    @Column(name = "WORKTELEPHONE")
    private String worktelephone;
    @Column(name = "WTDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date wtddate;
    @Column(name = "WTDOPTOUT")
    private Character wtdoptout;
    @Column(name = "YEARCURRENT")
    private Integer yearcurrent;
    @Size(max = 50)
    @Column(name = "YEARPICKLIST")
    private String yearpicklist;
    @Column(name = "YEARSOFSERVICE")
    private Integer yearsofservice;
    @Size(max = 35)
    @Column(name = "ZROOMNUMBER")
    private String zroomnumber;

    public People() {
    }

    public People(Long peopleId) {
        this.peopleId = peopleId;
    }

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public Date getAbsenceallowancestartdate() {
        return absenceallowancestartdate;
    }

    public void setAbsenceallowancestartdate(Date absenceallowancestartdate) {
        this.absenceallowancestartdate = absenceallowancestartdate;
    }

    public String getAbsenteeismscheme() {
        return absenteeismscheme;
    }

    public void setAbsenteeismscheme(String absenteeismscheme) {
        this.absenteeismscheme = absenteeismscheme;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAgecalculated() {
        return agecalculated;
    }

    public void setAgecalculated(String agecalculated) {
        this.agecalculated = agecalculated;
    }

    public Character getAlienregistrationcard() {
        return alienregistrationcard;
    }

    public void setAlienregistrationcard(Character alienregistrationcard) {
        this.alienregistrationcard = alienregistrationcard;
    }

    public Date getAnniversarydoj() {
        return anniversarydoj;
    }

    public void setAnniversarydoj(Date anniversarydoj) {
        this.anniversarydoj = anniversarydoj;
    }

    public Character getAppraisalupdate() {
        return appraisalupdate;
    }

    public void setAppraisalupdate(Character appraisalupdate) {
        this.appraisalupdate = appraisalupdate;
    }

    public Character getAttachedcriminalrecord() {
        return attachedcriminalrecord;
    }

    public void setAttachedcriminalrecord(Character attachedcriminalrecord) {
        this.attachedcriminalrecord = attachedcriminalrecord;
    }

    public Character getAttachedcv() {
        return attachedcv;
    }

    public void setAttachedcv(Character attachedcv) {
        this.attachedcv = attachedcv;
    }

    public Character getAttachedid() {
        return attachedid;
    }

    public void setAttachedid(Character attachedid) {
        this.attachedid = attachedid;
    }

    public Character getAttachedpicture() {
        return attachedpicture;
    }

    public void setAttachedpicture(Character attachedpicture) {
        this.attachedpicture = attachedpicture;
    }

    public String getBebonotes() {
        return bebonotes;
    }

    public void setBebonotes(String bebonotes) {
        this.bebonotes = bebonotes;
    }

    public String getBeboprofile() {
        return beboprofile;
    }

    public void setBeboprofile(String beboprofile) {
        this.beboprofile = beboprofile;
    }

    public String getBenationalregisterid() {
        return benationalregisterid;
    }

    public void setBenationalregisterid(String benationalregisterid) {
        this.benationalregisterid = benationalregisterid;
    }

    public String getBesocialsecurityoverseas() {
        return besocialsecurityoverseas;
    }

    public void setBesocialsecurityoverseas(String besocialsecurityoverseas) {
        this.besocialsecurityoverseas = besocialsecurityoverseas;
    }

    public String getBirthcountry() {
        return birthcountry;
    }

    public void setBirthcountry(String birthcountry) {
        this.birthcountry = birthcountry;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Character getBlackberry() {
        return blackberry;
    }

    public void setBlackberry(Character blackberry) {
        this.blackberry = blackberry;
    }

    public Character getBlockedbyshu() {
        return blockedbyshu;
    }

    public void setBlockedbyshu(Character blockedbyshu) {
        this.blockedbyshu = blockedbyshu;
    }

    public Character getCandidateflag() {
        return candidateflag;
    }

    public void setCandidateflag(Character candidateflag) {
        this.candidateflag = candidateflag;
    }

    public Character getCarparkpass() {
        return carparkpass;
    }

    public void setCarparkpass(Character carparkpass) {
        this.carparkpass = carparkpass;
    }

    public String getCarselected() {
        return carselected;
    }

    public void setCarselected(String carselected) {
        this.carselected = carselected;
    }

    public Character getCertificateofbirthabroad() {
        return certificateofbirthabroad;
    }

    public void setCertificateofbirthabroad(Character certificateofbirthabroad) {
        this.certificateofbirthabroad = certificateofbirthabroad;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Character getCoachflag() {
        return coachflag;
    }

    public void setCoachflag(Character coachflag) {
        this.coachflag = coachflag;
    }

    public String getContractingsection() {
        return contractingsection;
    }

    public void setContractingsection(String contractingsection) {
        this.contractingsection = contractingsection;
    }

    public Character getContractorflag() {
        return contractorflag;
    }

    public void setContractorflag(Character contractorflag) {
        this.contractorflag = contractorflag;
    }

    public String getContractstatus() {
        return contractstatus;
    }

    public void setContractstatus(String contractstatus) {
        this.contractstatus = contractstatus;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCoveringabout() {
        return coveringabout;
    }

    public void setCoveringabout(String coveringabout) {
        this.coveringabout = coveringabout;
    }

    public String getCpd() {
        return cpd;
    }

    public void setCpd(String cpd) {
        this.cpd = cpd;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCurrentbirthday() {
        return currentbirthday;
    }

    public void setCurrentbirthday(Date currentbirthday) {
        this.currentbirthday = currentbirthday;
    }

    public Date getDateaccessmentcenter() {
        return dateaccessmentcenter;
    }

    public void setDateaccessmentcenter(Date dateaccessmentcenter) {
        this.dateaccessmentcenter = dateaccessmentcenter;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getDatejoinedoverseasoffice() {
        return datejoinedoverseasoffice;
    }

    public void setDatejoinedoverseasoffice(Date datejoinedoverseasoffice) {
        this.datejoinedoverseasoffice = datejoinedoverseasoffice;
    }

    public Date getDatelastmodified() {
        return datelastmodified;
    }

    public void setDatelastmodified(Date datelastmodified) {
        this.datelastmodified = datelastmodified;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Date getDateofdeath() {
        return dateofdeath;
    }

    public void setDateofdeath(Date dateofdeath) {
        this.dateofdeath = dateofdeath;
    }

    public Date getDateofjoin() {
        return dateofjoin;
    }

    public void setDateofjoin(Date dateofjoin) {
        this.dateofjoin = dateofjoin;
    }

    public Date getDateofleaving() {
        return dateofleaving;
    }

    public void setDateofleaving(Date dateofleaving) {
        this.dateofleaving = dateofleaving;
    }

    public Date getDateofretirement() {
        return dateofretirement;
    }

    public void setDateofretirement(Date dateofretirement) {
        this.dateofretirement = dateofretirement;
    }

    public Date getDaterecruited() {
        return daterecruited;
    }

    public void setDaterecruited(Date daterecruited) {
        this.daterecruited = daterecruited;
    }

    public Date getDatewhen60() {
        return datewhen60;
    }

    public void setDatewhen60(Date datewhen60) {
        this.datewhen60 = datewhen60;
    }

    public Integer getDayofbirthday() {
        return dayofbirthday;
    }

    public void setDayofbirthday(Integer dayofbirthday) {
        this.dayofbirthday = dayofbirthday;
    }

    public Integer getDbpeoplenumber() {
        return dbpeoplenumber;
    }

    public void setDbpeoplenumber(Integer dbpeoplenumber) {
        this.dbpeoplenumber = dbpeoplenumber;
    }

    public Character getDel() {
        return del;
    }

    public void setDel(Character del) {
        this.del = del;
    }

    public Character getDirector() {
        return director;
    }

    public void setDirector(Character director) {
        this.director = director;
    }

    public Integer getDirectortaxweek() {
        return directortaxweek;
    }

    public void setDirectortaxweek(Integer directortaxweek) {
        this.directortaxweek = directortaxweek;
    }

    public String getDisabilityregnumber() {
        return disabilityregnumber;
    }

    public void setDisabilityregnumber(String disabilityregnumber) {
        this.disabilityregnumber = disabilityregnumber;
    }

    public Character getDisabled() {
        return disabled;
    }

    public void setDisabled(Character disabled) {
        this.disabled = disabled;
    }

    public Date getDojplus6months() {
        return dojplus6months;
    }

    public void setDojplus6months(Date dojplus6months) {
        this.dojplus6months = dojplus6months;
    }

    public String getDovetailnumber() {
        return dovetailnumber;
    }

    public void setDovetailnumber(String dovetailnumber) {
        this.dovetailnumber = dovetailnumber;
    }

    public Character getDriverslicence() {
        return driverslicence;
    }

    public void setDriverslicence(Character driverslicence) {
        this.driverslicence = driverslicence;
    }

    public String getDrivinglicence() {
        return drivinglicence;
    }

    public void setDrivinglicence(String drivinglicence) {
        this.drivinglicence = drivinglicence;
    }

    public String getDrivinglicenceno() {
        return drivinglicenceno;
    }

    public void setDrivinglicenceno(String drivinglicenceno) {
        this.drivinglicenceno = drivinglicenceno;
    }

    public String getEeocategory() {
        return eeocategory;
    }

    public void setEeocategory(String eeocategory) {
        this.eeocategory = eeocategory;
    }

    public String getEeocode() {
        return eeocode;
    }

    public void setEeocode(String eeocode) {
        this.eeocode = eeocode;
    }

    public String getEmailprimary() {
        return emailprimary;
    }

    public void setEmailprimary(String emailprimary) {
        this.emailprimary = emailprimary;
    }

    public String getEmailsecondary() {
        return emailsecondary;
    }

    public void setEmailsecondary(String emailsecondary) {
        this.emailsecondary = emailsecondary;
    }

    public String getEmailworkflow() {
        return emailworkflow;
    }

    public void setEmailworkflow(String emailworkflow) {
        this.emailworkflow = emailworkflow;
    }

    public Character getEmployeeflag() {
        return employeeflag;
    }

    public void setEmployeeflag(Character employeeflag) {
        this.employeeflag = employeeflag;
    }

    public String getEmployeestatus() {
        return employeestatus;
    }

    public void setEmployeestatus(String employeestatus) {
        this.employeestatus = employeestatus;
    }

    public String getEmployeetype() {
        return employeetype;
    }

    public void setEmployeetype(String employeetype) {
        this.employeetype = employeetype;
    }

    public Character getEmploymentauthentication() {
        return employmentauthentication;
    }

    public void setEmploymentauthentication(Character employmentauthentication) {
        this.employmentauthentication = employmentauthentication;
    }

    public Date getEndofprobationcalc() {
        return endofprobationcalc;
    }

    public void setEndofprobationcalc(Date endofprobationcalc) {
        this.endofprobationcalc = endofprobationcalc;
    }

    public Date getEndofprobationdate() {
        return endofprobationdate;
    }

    public void setEndofprobationdate(Date endofprobationdate) {
        this.endofprobationdate = endofprobationdate;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Date getExpectedretirementdate() {
        return expectedretirementdate;
    }

    public void setExpectedretirementdate(Date expectedretirementdate) {
        this.expectedretirementdate = expectedretirementdate;
    }

    public Date getFathersdateofbirth() {
        return fathersdateofbirth;
    }

    public void setFathersdateofbirth(Date fathersdateofbirth) {
        this.fathersdateofbirth = fathersdateofbirth;
    }

    public String getFathersfirstname() {
        return fathersfirstname;
    }

    public void setFathersfirstname(String fathersfirstname) {
        this.fathersfirstname = fathersfirstname;
    }

    public String getFatherslastname() {
        return fatherslastname;
    }

    public void setFatherslastname(String fatherslastname) {
        this.fatherslastname = fatherslastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Character getFlagreportsto() {
        return flagreportsto;
    }

    public void setFlagreportsto(Character flagreportsto) {
        this.flagreportsto = flagreportsto;
    }

    public String getFleetselection() {
        return fleetselection;
    }

    public void setFleetselection(String fleetselection) {
        this.fleetselection = fleetselection;
    }

    public String getFormalname() {
        return formalname;
    }

    public void setFormalname(String formalname) {
        this.formalname = formalname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHindifirstname() {
        return hindifirstname;
    }

    public void setHindifirstname(String hindifirstname) {
        this.hindifirstname = hindifirstname;
    }

    public String getHindilastname() {
        return hindilastname;
    }

    public void setHindilastname(String hindilastname) {
        this.hindilastname = hindilastname;
    }

    public String getHometelephone() {
        return hometelephone;
    }

    public void setHometelephone(String hometelephone) {
        this.hometelephone = hometelephone;
    }

    public Date getI9renewaldate() {
        return i9renewaldate;
    }

    public void setI9renewaldate(Date i9renewaldate) {
        this.i9renewaldate = i9renewaldate;
    }

    public Character getIdcard() {
        return idcard;
    }

    public void setIdcard(Character idcard) {
        this.idcard = idcard;
    }

    public String getIdcardnum() {
        return idcardnum;
    }

    public void setIdcardnum(String idcardnum) {
        this.idcardnum = idcardnum;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getKnownas() {
        return knownas;
    }

    public void setKnownas(String knownas) {
        this.knownas = knownas;
    }

    public Character getLaptop() {
        return laptop;
    }

    public void setLaptop(Character laptop) {
        this.laptop = laptop;
    }

    public Date getLastdayinoffice() {
        return lastdayinoffice;
    }

    public void setLastdayinoffice(Date lastdayinoffice) {
        this.lastdayinoffice = lastdayinoffice;
    }

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getLawsocietyadmissiondate() {
        return lawsocietyadmissiondate;
    }

    public void setLawsocietyadmissiondate(Date lawsocietyadmissiondate) {
        this.lawsocietyadmissiondate = lawsocietyadmissiondate;
    }

    public String getLawsocietymembershipnumber() {
        return lawsocietymembershipnumber;
    }

    public void setLawsocietymembershipnumber(String lawsocietymembershipnumber) {
        this.lawsocietymembershipnumber = lawsocietymembershipnumber;
    }

    public String getLawsocietystatus() {
        return lawsocietystatus;
    }

    public void setLawsocietystatus(String lawsocietystatus) {
        this.lawsocietystatus = lawsocietystatus;
    }

    public String getLeavingdetails() {
        return leavingdetails;
    }

    public void setLeavingdetails(String leavingdetails) {
        this.leavingdetails = leavingdetails;
    }

    public String getLegallanguage() {
        return legallanguage;
    }

    public void setLegallanguage(String legallanguage) {
        this.legallanguage = legallanguage;
    }

    public Integer getLengthofservice() {
        return lengthofservice;
    }

    public void setLengthofservice(Integer lengthofservice) {
        this.lengthofservice = lengthofservice;
    }

    public String getLengthofservicecustom() {
        return lengthofservicecustom;
    }

    public void setLengthofservicecustom(String lengthofservicecustom) {
        this.lengthofservicecustom = lengthofservicecustom;
    }

    public String getLinkedinnotes() {
        return linkedinnotes;
    }

    public void setLinkedinnotes(String linkedinnotes) {
        this.linkedinnotes = linkedinnotes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaidenname() {
        return maidenname;
    }

    public void setMaidenname(String maidenname) {
        this.maidenname = maidenname;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getMainfunctionabout() {
        return mainfunctionabout;
    }

    public void setMainfunctionabout(String mainfunctionabout) {
        this.mainfunctionabout = mainfunctionabout;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getMaritalstatusvalue() {
        return maritalstatusvalue;
    }

    public void setMaritalstatusvalue(String maritalstatusvalue) {
        this.maritalstatusvalue = maritalstatusvalue;
    }

    public Character getMarriagegift() {
        return marriagegift;
    }

    public void setMarriagegift(Character marriagegift) {
        this.marriagegift = marriagegift;
    }

    public Character getMentorflag() {
        return mentorflag;
    }

    public void setMentorflag(Character mentorflag) {
        this.mentorflag = mentorflag;
    }

    public String getMgrdelegator() {
        return mgrdelegator;
    }

    public void setMgrdelegator(String mgrdelegator) {
        this.mgrdelegator = mgrdelegator;
    }

    public Date getMgrdelegatorenddate() {
        return mgrdelegatorenddate;
    }

    public void setMgrdelegatorenddate(Date mgrdelegatorenddate) {
        this.mgrdelegatorenddate = mgrdelegatorenddate;
    }

    public Date getMgrdelegatorstartdate() {
        return mgrdelegatorstartdate;
    }

    public void setMgrdelegatorstartdate(Date mgrdelegatorstartdate) {
        this.mgrdelegatorstartdate = mgrdelegatorstartdate;
    }

    public String getMiddlenames() {
        return middlenames;
    }

    public void setMiddlenames(String middlenames) {
        this.middlenames = middlenames;
    }

    public String getMissiontag() {
        return missiontag;
    }

    public void setMissiontag(String missiontag) {
        this.missiontag = missiontag;
    }

    public Character getMobile() {
        return mobile;
    }

    public void setMobile(Character mobile) {
        this.mobile = mobile;
    }

    public String getMobiletelephone() {
        return mobiletelephone;
    }

    public void setMobiletelephone(String mobiletelephone) {
        this.mobiletelephone = mobiletelephone;
    }

    public String getMobility() {
        return mobility;
    }

    public void setMobility(String mobility) {
        this.mobility = mobility;
    }

    public String getMobilityareapreference1() {
        return mobilityareapreference1;
    }

    public void setMobilityareapreference1(String mobilityareapreference1) {
        this.mobilityareapreference1 = mobilityareapreference1;
    }

    public String getMobilityareapreference2() {
        return mobilityareapreference2;
    }

    public void setMobilityareapreference2(String mobilityareapreference2) {
        this.mobilityareapreference2 = mobilityareapreference2;
    }

    public String getMobilityareapreference3() {
        return mobilityareapreference3;
    }

    public void setMobilityareapreference3(String mobilityareapreference3) {
        this.mobilityareapreference3 = mobilityareapreference3;
    }

    public String getMobilitynotes() {
        return mobilitynotes;
    }

    public void setMobilitynotes(String mobilitynotes) {
        this.mobilitynotes = mobilitynotes;
    }

    public String getMobilityregionpreference1() {
        return mobilityregionpreference1;
    }

    public void setMobilityregionpreference1(String mobilityregionpreference1) {
        this.mobilityregionpreference1 = mobilityregionpreference1;
    }

    public String getMobilityregionpreference2() {
        return mobilityregionpreference2;
    }

    public void setMobilityregionpreference2(String mobilityregionpreference2) {
        this.mobilityregionpreference2 = mobilityregionpreference2;
    }

    public String getMobilityregionpreference3() {
        return mobilityregionpreference3;
    }

    public void setMobilityregionpreference3(String mobilityregionpreference3) {
        this.mobilityregionpreference3 = mobilityregionpreference3;
    }

    public Integer getMonthofbirthday() {
        return monthofbirthday;
    }

    public void setMonthofbirthday(Integer monthofbirthday) {
        this.monthofbirthday = monthofbirthday;
    }

    public Date getMothersdateofbirth() {
        return mothersdateofbirth;
    }

    public void setMothersdateofbirth(Date mothersdateofbirth) {
        this.mothersdateofbirth = mothersdateofbirth;
    }

    public String getMothersfirstname() {
        return mothersfirstname;
    }

    public void setMothersfirstname(String mothersfirstname) {
        this.mothersfirstname = mothersfirstname;
    }

    public String getMotherslastname() {
        return motherslastname;
    }

    public void setMotherslastname(String motherslastname) {
        this.motherslastname = motherslastname;
    }

    public String getMsfemail() {
        return msfemail;
    }

    public void setMsfemail(String msfemail) {
        this.msfemail = msfemail;
    }

    public String getMsflanguage() {
        return msflanguage;
    }

    public void setMsflanguage(String msflanguage) {
        this.msflanguage = msflanguage;
    }

    public String getMyspacenotes() {
        return myspacenotes;
    }

    public void setMyspacenotes(String myspacenotes) {
        this.myspacenotes = myspacenotes;
    }

    public String getNameplusrefno() {
        return nameplusrefno;
    }

    public void setNameplusrefno(String nameplusrefno) {
        this.nameplusrefno = nameplusrefno;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Character getNationalstaff() {
        return nationalstaff;
    }

    public void setNationalstaff(Character nationalstaff) {
        this.nationalstaff = nationalstaff;
    }

    public Character getNativeamericantribaldocument() {
        return nativeamericantribaldocument;
    }

    public void setNativeamericantribaldocument(Character nativeamericantribaldocument) {
        this.nativeamericantribaldocument = nativeamericantribaldocument;
    }

    public Date getNextbirthday() {
        return nextbirthday;
    }

    public void setNextbirthday(Date nextbirthday) {
        this.nextbirthday = nextbirthday;
    }

    public Date getNextbirthdayplus1year() {
        return nextbirthdayplus1year;
    }

    public void setNextbirthdayplus1year(Date nextbirthdayplus1year) {
        this.nextbirthdayplus1year = nextbirthdayplus1year;
    }

    public String getNinumber() {
        return ninumber;
    }

    public void setNinumber(String ninumber) {
        this.ninumber = ninumber;
    }

    public String getNirate() {
        return nirate;
    }

    public void setNirate(String nirate) {
        this.nirate = nirate;
    }

    public String getNoteslaw() {
        return noteslaw;
    }

    public void setNoteslaw(String noteslaw) {
        this.noteslaw = noteslaw;
    }

    public String getNoticeperiod() {
        return noticeperiod;
    }

    public void setNoticeperiod(String noticeperiod) {
        this.noticeperiod = noticeperiod;
    }

    public Integer getNumberofchildren() {
        return numberofchildren;
    }

    public void setNumberofchildren(Integer numberofchildren) {
        this.numberofchildren = numberofchildren;
    }

    public String getOtherrolesabout() {
        return otherrolesabout;
    }

    public void setOtherrolesabout(String otherrolesabout) {
        this.otherrolesabout = otherrolesabout;
    }

    public String getOutcomeofprobation() {
        return outcomeofprobation;
    }

    public void setOutcomeofprobation(String outcomeofprobation) {
        this.outcomeofprobation = outcomeofprobation;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getPayranges() {
        return payranges;
    }

    public void setPayranges(String payranges) {
        this.payranges = payranges;
    }

    public String getPayroll() {
        return payroll;
    }

    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }

    public String getPayrollnumber() {
        return payrollnumber;
    }

    public void setPayrollnumber(String payrollnumber) {
        this.payrollnumber = payrollnumber;
    }

    public Character getPermanentresidencecard() {
        return permanentresidencecard;
    }

    public void setPermanentresidencecard(Character permanentresidencecard) {
        this.permanentresidencecard = permanentresidencecard;
    }

    public String getPersonalnotes() {
        return personalnotes;
    }

    public void setPersonalnotes(String personalnotes) {
        this.personalnotes = personalnotes;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPmiselection() {
        return pmiselection;
    }

    public void setPmiselection(String pmiselection) {
        this.pmiselection = pmiselection;
    }

    public Character getPoolflag() {
        return poolflag;
    }

    public void setPoolflag(Character poolflag) {
        this.poolflag = poolflag;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPreviousemployeereference() {
        return previousemployeereference;
    }

    public void setPreviousemployeereference(String previousemployeereference) {
        this.previousemployeereference = previousemployeereference;
    }

    public String getPreviouslastname() {
        return previouslastname;
    }

    public void setPreviouslastname(String previouslastname) {
        this.previouslastname = previouslastname;
    }

    public Date getProbationdatecalculated() {
        return probationdatecalculated;
    }

    public void setProbationdatecalculated(Date probationdatecalculated) {
        this.probationdatecalculated = probationdatecalculated;
    }

    public Date getProbationextendeddate() {
        return probationextendeddate;
    }

    public void setProbationextendeddate(Date probationextendeddate) {
        this.probationextendeddate = probationextendeddate;
    }

    public String getProbationnotes() {
        return probationnotes;
    }

    public void setProbationnotes(String probationnotes) {
        this.probationnotes = probationnotes;
    }

    public String getPsyfpofoffice() {
        return psyfpofoffice;
    }

    public void setPsyfpofoffice(String psyfpofoffice) {
        this.psyfpofoffice = psyfpofoffice;
    }

    public String getPsyfpofsection() {
        return psyfpofsection;
    }

    public void setPsyfpofsection(String psyfpofsection) {
        this.psyfpofsection = psyfpofsection;
    }

    public String getPublicholidayscheme() {
        return publicholidayscheme;
    }

    public void setPublicholidayscheme(String publicholidayscheme) {
        this.publicholidayscheme = publicholidayscheme;
    }

    public String getQlttbywhom() {
        return qlttbywhom;
    }

    public void setQlttbywhom(String qlttbywhom) {
        this.qlttbywhom = qlttbywhom;
    }

    public Character getQlttcertificateseen() {
        return qlttcertificateseen;
    }

    public void setQlttcertificateseen(Character qlttcertificateseen) {
        this.qlttcertificateseen = qlttcertificateseen;
    }

    public Character getQlttcompleted() {
        return qlttcompleted;
    }

    public void setQlttcompleted(Character qlttcompleted) {
        this.qlttcompleted = qlttcompleted;
    }

    public Date getQlttdate() {
        return qlttdate;
    }

    public void setQlttdate(Date qlttdate) {
        this.qlttdate = qlttdate;
    }

    public String getReasonforleaving() {
        return reasonforleaving;
    }

    public void setReasonforleaving(String reasonforleaving) {
        this.reasonforleaving = reasonforleaving;
    }

    public String getRecruitedas() {
        return recruitedas;
    }

    public void setRecruitedas(String recruitedas) {
        this.recruitedas = recruitedas;
    }

    public String getRecruitedby() {
        return recruitedby;
    }

    public void setRecruitedby(String recruitedby) {
        this.recruitedby = recruitedby;
    }

    public String getRecruiterofoffice() {
        return recruiterofoffice;
    }

    public void setRecruiterofoffice(String recruiterofoffice) {
        this.recruiterofoffice = recruiterofoffice;
    }

    public String getRecruiterofsection() {
        return recruiterofsection;
    }

    public void setRecruiterofsection(String recruiterofsection) {
        this.recruiterofsection = recruiterofsection;
    }

    public Character getRecruitingdocscertifmedical() {
        return recruitingdocscertifmedical;
    }

    public void setRecruitingdocscertifmedical(Character recruitingdocscertifmedical) {
        this.recruitingdocscertifmedical = recruitingdocscertifmedical;
    }

    public Character getRecruitingdocsdependants() {
        return recruitingdocsdependants;
    }

    public void setRecruitingdocsdependants(Character recruitingdocsdependants) {
        this.recruitingdocsdependants = recruitingdocsdependants;
    }

    public Character getRecruitingdocseducation() {
        return recruitingdocseducation;
    }

    public void setRecruitingdocseducation(Character recruitingdocseducation) {
        this.recruitingdocseducation = recruitingdocseducation;
    }

    public Character getRecruitingdocsmedical() {
        return recruitingdocsmedical;
    }

    public void setRecruitingdocsmedical(Character recruitingdocsmedical) {
        this.recruitingdocsmedical = recruitingdocsmedical;
    }

    public Character getRecruitingdocspassport() {
        return recruitingdocspassport;
    }

    public void setRecruitingdocspassport(Character recruitingdocspassport) {
        this.recruitingdocspassport = recruitingdocspassport;
    }

    public Character getRecruitingdocspersonal() {
        return recruitingdocspersonal;
    }

    public void setRecruitingdocspersonal(Character recruitingdocspersonal) {
        this.recruitingdocspersonal = recruitingdocspersonal;
    }

    public Character getRecruitingdocsprevemployment() {
        return recruitingdocsprevemployment;
    }

    public void setRecruitingdocsprevemployment(Character recruitingdocsprevemployment) {
        this.recruitingdocsprevemployment = recruitingdocsprevemployment;
    }

    public String getRecruitingoffice() {
        return recruitingoffice;
    }

    public void setRecruitingoffice(String recruitingoffice) {
        this.recruitingoffice = recruitingoffice;
    }

    public String getRecruitingsection() {
        return recruitingsection;
    }

    public void setRecruitingsection(String recruitingsection) {
        this.recruitingsection = recruitingsection;
    }

    public Integer getReferencehero() {
        return referencehero;
    }

    public void setReferencehero(Integer referencehero) {
        this.referencehero = referencehero;
    }

    public String getReferencenumber() {
        return referencenumber;
    }

    public void setReferencenumber(String referencenumber) {
        this.referencenumber = referencenumber;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getReportsto() {
        return reportsto;
    }

    public void setReportsto(String reportsto) {
        this.reportsto = reportsto;
    }

    public String getReportstobeforedelegation() {
        return reportstobeforedelegation;
    }

    public void setReportstobeforedelegation(String reportstobeforedelegation) {
        this.reportstobeforedelegation = reportstobeforedelegation;
    }

    public String getReportstofirstname() {
        return reportstofirstname;
    }

    public void setReportstofirstname(String reportstofirstname) {
        this.reportstofirstname = reportstofirstname;
    }

    public String getReportstofullname() {
        return reportstofullname;
    }

    public void setReportstofullname(String reportstofullname) {
        this.reportstofullname = reportstofullname;
    }

    public String getReportstolastname() {
        return reportstolastname;
    }

    public void setReportstolastname(String reportstolastname) {
        this.reportstolastname = reportstolastname;
    }

    public Date getRetirementdate() {
        return retirementdate;
    }

    public void setRetirementdate(Date retirementdate) {
        this.retirementdate = retirementdate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRiskofleaving() {
        return riskofleaving;
    }

    public void setRiskofleaving(String riskofleaving) {
        this.riskofleaving = riskofleaving;
    }

    public String getRpapproachingretirement() {
        return rpapproachingretirement;
    }

    public void setRpapproachingretirement(String rpapproachingretirement) {
        this.rpapproachingretirement = rpapproachingretirement;
    }

    public Character getScannedw4document() {
        return scannedw4document;
    }

    public void setScannedw4document(Character scannedw4document) {
        this.scannedw4document = scannedw4document;
    }

    public String getScndaddress1() {
        return scndaddress1;
    }

    public void setScndaddress1(String scndaddress1) {
        this.scndaddress1 = scndaddress1;
    }

    public String getScndaddress2() {
        return scndaddress2;
    }

    public void setScndaddress2(String scndaddress2) {
        this.scndaddress2 = scndaddress2;
    }

    public String getScndaddress3() {
        return scndaddress3;
    }

    public void setScndaddress3(String scndaddress3) {
        this.scndaddress3 = scndaddress3;
    }

    public String getScndcity() {
        return scndcity;
    }

    public void setScndcity(String scndcity) {
        this.scndcity = scndcity;
    }

    public String getScndcountry() {
        return scndcountry;
    }

    public void setScndcountry(String scndcountry) {
        this.scndcountry = scndcountry;
    }

    public String getScndmailbox() {
        return scndmailbox;
    }

    public void setScndmailbox(String scndmailbox) {
        this.scndmailbox = scndmailbox;
    }

    public String getScndpostcode() {
        return scndpostcode;
    }

    public void setScndpostcode(String scndpostcode) {
        this.scndpostcode = scndpostcode;
    }

    public String getScndstreetnumber() {
        return scndstreetnumber;
    }

    public void setScndstreetnumber(String scndstreetnumber) {
        this.scndstreetnumber = scndstreetnumber;
    }

    public String getSconno() {
        return sconno;
    }

    public void setSconno(String sconno) {
        this.sconno = sconno;
    }

    public String getSecondnationality() {
        return secondnationality;
    }

    public void setSecondnationality(String secondnationality) {
        this.secondnationality = secondnationality;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }

    public Date getSendappraisalnotification() {
        return sendappraisalnotification;
    }

    public void setSendappraisalnotification(Date sendappraisalnotification) {
        this.sendappraisalnotification = sendappraisalnotification;
    }

    public Date getSendbirthdayreminder() {
        return sendbirthdayreminder;
    }

    public void setSendbirthdayreminder(Date sendbirthdayreminder) {
        this.sendbirthdayreminder = sendbirthdayreminder;
    }

    public String getSexualorientation() {
        return sexualorientation;
    }

    public void setSexualorientation(String sexualorientation) {
        this.sexualorientation = sexualorientation;
    }

    public String getSickallow() {
        return sickallow;
    }

    public void setSickallow(String sickallow) {
        this.sickallow = sickallow;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getSpinalpoint() {
        return spinalpoint;
    }

    public void setSpinalpoint(String spinalpoint) {
        this.spinalpoint = spinalpoint;
    }

    public String getSsdate() {
        return ssdate;
    }

    public void setSsdate(String ssdate) {
        this.ssdate = ssdate;
    }

    public Character getSsp() {
        return ssp;
    }

    public void setSsp(Character ssp) {
        this.ssp = ssp;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getStarttype() {
        return starttype;
    }

    public void setStarttype(String starttype) {
        this.starttype = starttype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getStudylevel() {
        return studylevel;
    }

    public void setStudylevel(String studylevel) {
        this.studylevel = studylevel;
    }

    public String getSubmittinguser() {
        return submittinguser;
    }

    public void setSubmittinguser(String submittinguser) {
        this.submittinguser = submittinguser;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Character getSupplier() {
        return supplier;
    }

    public void setSupplier(Character supplier) {
        this.supplier = supplier;
    }

    public Character getSwipecard() {
        return swipecard;
    }

    public void setSwipecard(Character swipecard) {
        this.swipecard = swipecard;
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode;
    }

    public String getTextdateofbirth() {
        return textdateofbirth;
    }

    public void setTextdateofbirth(String textdateofbirth) {
        this.textdateofbirth = textdateofbirth;
    }

    public String getTextdateofjoin() {
        return textdateofjoin;
    }

    public void setTextdateofjoin(String textdateofjoin) {
        this.textdateofjoin = textdateofjoin;
    }

    public String getTextdateofleaving() {
        return textdateofleaving;
    }

    public void setTextdateofleaving(String textdateofleaving) {
        this.textdateofleaving = textdateofleaving;
    }

    public String getTextpaymentmethod() {
        return textpaymentmethod;
    }

    public void setTextpaymentmethod(String textpaymentmethod) {
        this.textpaymentmethod = textpaymentmethod;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Character getTrainerflag() {
        return trainerflag;
    }

    public void setTrainerflag(Character trainerflag) {
        this.trainerflag = trainerflag;
    }

    public String getUpChain() {
        return upChain;
    }

    public void setUpChain(String upChain) {
        this.upChain = upChain;
    }

    public String getUpChain1() {
        return upChain1;
    }

    public void setUpChain1(String upChain1) {
        this.upChain1 = upChain1;
    }

    public Character getUsac() {
        return usac;
    }

    public void setUsac(Character usac) {
        this.usac = usac;
    }

    public Character getUscitizenidcard() {
        return uscitizenidcard;
    }

    public void setUscitizenidcard(Character uscitizenidcard) {
        this.uscitizenidcard = uscitizenidcard;
    }

    public Character getUserbyadmin() {
        return userbyadmin;
    }

    public void setUserbyadmin(Character userbyadmin) {
        this.userbyadmin = userbyadmin;
    }

    public Character getUserbypoolmanager() {
        return userbypoolmanager;
    }

    public void setUserbypoolmanager(Character userbypoolmanager) {
        this.userbypoolmanager = userbypoolmanager;
    }

    public Character getUserbyrecruiter() {
        return userbyrecruiter;
    }

    public void setUserbyrecruiter(Character userbyrecruiter) {
        this.userbyrecruiter = userbyrecruiter;
    }

    public Date getUserdatecreated() {
        return userdatecreated;
    }

    public void setUserdatecreated(Date userdatecreated) {
        this.userdatecreated = userdatecreated;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Character getUspassport() {
        return uspassport;
    }

    public void setUspassport(Character uspassport) {
        this.uspassport = uspassport;
    }

    public Character getUssocialsecuritycard() {
        return ussocialsecuritycard;
    }

    public void setUssocialsecuritycard(Character ussocialsecuritycard) {
        this.ussocialsecuritycard = ussocialsecuritycard;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public Character getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Character volunteer) {
        this.volunteer = volunteer;
    }

    public String getW4status() {
        return w4status;
    }

    public void setW4status(String w4status) {
        this.w4status = w4status;
    }

    public Character getWk1mt1() {
        return wk1mt1;
    }

    public void setWk1mt1(Character wk1mt1) {
        this.wk1mt1 = wk1mt1;
    }

    public String getWorkext() {
        return workext;
    }

    public void setWorkext(String workext) {
        this.workext = workext;
    }

    public String getWorktelephone() {
        return worktelephone;
    }

    public void setWorktelephone(String worktelephone) {
        this.worktelephone = worktelephone;
    }

    public Date getWtddate() {
        return wtddate;
    }

    public void setWtddate(Date wtddate) {
        this.wtddate = wtddate;
    }

    public Character getWtdoptout() {
        return wtdoptout;
    }

    public void setWtdoptout(Character wtdoptout) {
        this.wtdoptout = wtdoptout;
    }

    public Integer getYearcurrent() {
        return yearcurrent;
    }

    public void setYearcurrent(Integer yearcurrent) {
        this.yearcurrent = yearcurrent;
    }

    public String getYearpicklist() {
        return yearpicklist;
    }

    public void setYearpicklist(String yearpicklist) {
        this.yearpicklist = yearpicklist;
    }

    public Integer getYearsofservice() {
        return yearsofservice;
    }

    public void setYearsofservice(Integer yearsofservice) {
        this.yearsofservice = yearsofservice;
    }

    public String getZroomnumber() {
        return zroomnumber;
    }

    public void setZroomnumber(String zroomnumber) {
        this.zroomnumber = zroomnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peopleId != null ? peopleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.peopleId == null && other.peopleId != null) || (this.peopleId != null && !this.peopleId.equals(other.peopleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.People[ peopleId=" + peopleId + " ]";
    }
    
}
