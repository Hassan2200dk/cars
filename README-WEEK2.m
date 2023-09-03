What are the benefits of using a RESTful API


Fordelen ved at anvende et RESTful API er at det først og fremmest af simpelt at bruge. Der gøres brug af simple http metoder (GET, POST, PUT, DELETE) som gør det nemt at udføre CRUD. Derudover er der andre fordele
såsom at der er stateless, fleksibel og scalable.


- What is JSON, and why does JSON fit so well with REST?

JSON (JavaScript Object Notation) er en Data format der bruges til at kommunikere på tværs af internettet, og bruges tit til at få info fra en specifik api. 
Det der gør JSON smart er at der er letlæselig sprog, som de fleste programmeringssprog kan tolke og arbejde på. På samme måde er det smart med REST grundet den simplicitet den medbringer 


- How you have designed simple CRUD endpoints using spring boot and DTOs to separate api from data  -> Focus on your use of DTO's
  Jeg har udformet klasser of dtos and entities. Det der binder dem sammen eller i andre ord konvertere entities til dtos er gennem mit servicelag. 
  Derefter anvender jeg controller klassen til at skabe min CRUD metoder, hvor jeg benytter DTO'erne.

-  What is the advantage of using using DTOs to separate api from data structure when designing rest endpoints
   En af de primære fortrin ved at applicere DTO'er er simpelt at du kan tilpasse den data du sender eller modtager. 
   Altså skal en client kun få den nødvendige data fra clienten og ikke alt muligt såsom hvor meget han maksimalt tilbud han kan få.
   

- Explain shortly the concept mocking in relation to software testing
  Ideen med mocking er, at man prøver at lave data der ser ægte ud så man kan teste på det. Det kan gøre det lettere at teste koden, uden der kommer påvirkelse fra eksterne komponenter.

- How did you mock database access in your tests, using an in-memory database and/or mockito → Refer to your code
  Jeg brugte @DataJpaTest så jeg in-memory database, men jeg mockede også min data. Det gjorde jeg i min @BeforeEach
      
    void setUp() {
        m1 = memberRepository.save(new Member("user1", "pw1", "email1", "fn1", "ln1",  "street1", "city1", "zip1"));
        m2 = memberRepository.save(new Member("user2", "pw2", "email1", "fn2", "ln2", "street2", "city2", "zip2"));
       // Member m3 = m1;
        //m3.setCity("xxxxxxxx");
        //System.out.println(m1.getCity());
        memberService = new MemberService(memberRepository); //Set up memberService with the mock (H2) database
    }
    Så udførte jeg nogle testS. Et eksempel var hvis størrelsen var 2.
  

- Explain the concept Build Server and the role Github Actions play here
  Build Server er en komponent der har til opgave at automatisere processer såsom building, testing og deploying. Github Actions er et eksempel på et program der virker som en Build Server. 

