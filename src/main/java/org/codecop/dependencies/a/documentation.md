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

Auslagerung der zuvor in der Testklasse definierten Seams in eigene Dateien, um die Tests übersichtlicher und klarer
strukturiert zu halten.

## Commit 991be226

Ergänzung weiterer Tests: ein parametrized Test für die Grenzwerte (100 / 1000) sowie ein Test, der sicherstellt, dass
der Crazy-Sales-Day alle regulären Rabattregeln überschreibt.

# Fazit

Durch das Einführen eines klaren Seams über den erweiterten Konstruktor und das gezielte Trennen testrelevanter
Varianten konnte die ursprünglich schwer testbare Rabattlogik sicher isoliert und vollständig abgedeckt werden.
Die Struktur ist nun besser verständlich, die Tests reproduzierbar und stabil. Die Übung unterstreicht, wie wichtig
entkoppelte Abhängigkeiten für testbaren und langfristig wartbaren Code sind.
