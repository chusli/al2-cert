# Einleitung

Für diese Aufgabe stand das Ziel im Vordergrund, die bestehende Codebasis des Assignments zu testen und schrittweise in
einen zustand zu bringen, der sowohl testbar als auch nachvollziehbar ist. Die ersten Commits dienten ausschliesslich
dazu, das Projekt aus dem öffentlichen Repository sauber in ein eigenes Repository zu übernehmen. Anders als in der
vorherigen Aufgabe wurde diesmal jeder Schritt commit- und pushbar ausgeführt, was den Arbeitsfluss transparenter machte
und Rückverfolgbarkeit sicherstellte.

# Commits

## Commit 51aaf321

Der erste inhaltliche Schritt bestand darin, die vorhandenen Tests auszuführen. Dabei zeigte sich direkt, dass ein
Import überflüssig war und der Testname nicht der Konvention entsprach. Beides wurde entsprechend angepasst, um eine
saubere Ausgangslage zu schaffen (Pfadfinder Prinzip).

## Commit 07995904

Wie bereits in der vorherigen Kata wurde ein Seam eingeführt, um die Klasse testbar zu machen. Dies war hier etwas
aufwändiger, da die Marketing-Logik über den Konstruktor in die Discount Klasse injiziert werden musste. Durch das
automatisierte Hinzufügen (alt + Insert) eines zusätzlichen Konstruktors konnte der notwendige Seam geschaffen werden.
Anschliessend
liess sich die Testabdeckung auf 100% erhöhen. Da der Originalcode schwer vorhersehbares Verhalten zeigt, wurden in der
Testklasse zwei einfache Subklassen für Discount und MarketingCampaign angelegt, um die verschiedenen Pfade stabil
prüfen zu können.

## Commit d536024a

Zuletzt habe ich die beiden Seams extrahiert und in eigene Dateien verschoben. Es war etwas störend, in einer Testklasse
gleich zwei Subklassen zu haben.

# Fazit

Durch das Einführen des Seams über einen erweiterten Konstruktor und das klare Trennen der testrelevanten Varianten
mittels Subklassen konnte der zuvor schwer testbare Code effektiv isoliert und vollständig abgedeckt werden. Die
Struktur ist nun nachvollziehbarer, und die Tests bilden das Verhalten zuverlässig ab. Die Aufgabe zeigt erneut, wie
zentral kontrollierte Abhängigkeiten für testbaren Code sind und wie kleine strukturelle Anpassungen grossen Einfluss
auf die Wartbarkeit haben.