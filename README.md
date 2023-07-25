# Avioane_JocJava

**Povestea jocului:**
În cadrul orelor de limba și literatura română din liceu, doi elevi de clasa a XI-a decid ca în timpul în care colega lor, Iulia, este ascultată din eseul “Ion”, să alunge plictiseala. Aceștia se satură în scurt timp de jocul “x și o” și decid să facă lucrurile interesante, ajungând la avioane. Cristi și Robert încep jocul, dar, șoptind pozițiile în care fiecare atacă avionul oponentului, profesoara aude și le spune că dacă nu vor înceta, se vor ridica în picioare și vor prezenta conflictul intern al personajului principal. Băieții de la mate-info au decis astfel să implementeze un joc în java, cu toate că ei la vremea aceea făceau puțin backtracking și metoda greedy în C++. Pentru a nu mai fi nevoiți să șoptească în timpul orei, ei își propun să o indice pe un radar auxiliar. Încântați de această idee, cei doi o roagă și pe Iulia să-i ajute fiindcă le era cea mai dragă colegă, dar și pentru a o consola că luase doar 7.

**Prezentare joc:**
Aplicația implementată de cei doi băieți face trimitere la cunoscutul joc al copilăriei, “Avioane”, cunoscut de unii și sub numele de “Vapoare”. Acesta presupune să elimini toate avioanele/navele adversarului, neștiind poziția acestora. Jocul de strategie testează atât norocul jucătorului, cât și ingeniozitatea acestuia.

**Reguli joc:**
La începutul jocului, participantul trebuie să își aleagă caracterul cu care va juca (Cristi sau Robert) și să- și plaseze propriile avioane integral în interiorul tabelei de joc (tabela diferă în funcție de nivelul dat). În cele ce urmează, acesta trebuie să mute caracterul ales pe radarul auxiliar și să-l plaseze pe poziția în care dorește să realizeze atacul asupra oponentului. În cazul în care nu se atinge niciun avion, se va considera “aer” și poziția va fi marcată pe radarul asociat cu un punct verde. Dacă se va reuși un atac satisfăcător, în funcție de zona lovită, avionul este considerat “mort” sau “lovit”. Avionul “mort” (lovit în cap) va apărea integral pe radar, colorat în roșu (regula se respectă și în cazul în care avionul nu e lovit în alte părți, ci doar în cap). În caz contrar, oricare altă parte a avionului este considerată lovită. De la nivelul doi, jucătorul va trebui să se încadreze într-un interval de timp, iar lipsa unui caștigător în timpul dat conduce la un scor de egalitate (cu toate că numărul avioanelor omorâte poate fi mai mare pentru unul dintre jucători). Problema egalității este rezolvată doar la nivelul trei, unde se va da cu banul.

**Personajele jocului:**
<img width="659" alt="Screenshot 2023-07-25 at 20 11 32" src="https://github.com/FilipIulia/Avioane_JocJava/assets/107275521/05f00fe1-3ac6-42ba-9b18-c16aa83982e2">
- Cristi este brunet, înalt și are ochii căprui. Acesta se remarcă prin simțul umorului, are o personalitate prietenoasă și este deosebit de competitiv, iubind să fie provocat la dueluri strategice.”Avioane” e unul dintre jocurile lui preferate din copilărie, deoarece, înainte să descopere programarea, acesta se visa pilot. Pentru a da o notă techno jocului, acesta se transforma într-un băiețel albastru.


**Tabla de joc:
• Tabela de joc din nivelul 1**

<img width="1169" alt="Screenshot 2023-07-25 at 20 12 18" src="https://github.com/FilipIulia/Avioane_JocJava/assets/107275521/9a4af656-2d0c-4178-a677-fe5cfe95d100">

• **Tabela de joc din nivelul 2**

<img width="1169" alt="Screenshot 2023-07-25 at 20 12 29" src="https://github.com/FilipIulia/Avioane_JocJava/assets/107275521/81197e1c-4933-408b-b9df-56a46a4c3aa0">


**-structura tablei de joc:**
• În primul nivel, tabla de joc constă în două tabele de 1-7 x a-g : tabela proprie pe care se găsește propriul avion, dar și a unui radar în care plasezi atacul, al cărui rezultat poate fi “aer” sau vătămarea avionului inamicului. Inamic constă dintr-un singur avion.

<img width="1169" alt="Screenshot 2023-07-25 at 20 12 39" src="https://github.com/FilipIulia/Avioane_JocJava/assets/107275521/4b8fb381-9724-47ff-97f8-4817b2df4e67">

• În următorul nivel, tabla de joc presupune două tabele de 1-14 x a-m (tabela proprie cât și radarul). Spre deosebire de prima etapă, background-ul se va schimba iar numărul de avioane pe care trebuie să le ataci devine 3.

<img width="1169" alt="Screenshot 2023-07-25 at 20 12 57" src="https://github.com/FilipIulia/Avioane_JocJava/assets/107275521/3318d83a-e5f7-47ea-a98b-5f00a3d2ed95">


**Metoda de victorie
Se urmărește să se elimine toate avioanele inamicului. Când s -a realizat acest lucru, câștigi și în rest se declară învingerea.**

<img width="1169" alt="Screenshot 2023-07-25 at 20 13 04" src="https://github.com/FilipIulia/Avioane_JocJava/assets/107275521/b9ebbe4d-f2ea-4c64-ab09-dca5b5748971">
<img width="1169" alt="Screenshot 2023-07-25 at 20 13 14" src="https://github.com/FilipIulia/Avioane_JocJava/assets/107275521/5fe14079-0d8a-474c-8aab-1cc8e51f5be0">
