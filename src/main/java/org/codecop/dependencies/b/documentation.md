# Einleitung

Ziel dieser Aufgabe war es, die nicht-deterministische Logik der Klasse `MarketingCampaign` testbar zu machen und
die bestehenden Business Rules zuverlässig durch Tests abzudecken. Der ursprüngliche Code war eng an die
Systemzeit gekoppelt, sodass ohne geeignete Seams keine kontrollierbaren Tests möglich waren.

# Commits

## Commit 9265ece0

Zunächst habe ich einen schnellen, aber letztlich unbrauchbaren Ansatz ausprobiert: Die gesamte Logik wurde in einen
Seam ausgelagert, wodurch zwar sofort 100 % Testabdeckung erreichbar war, aber die Tests keine Produktionslogik mehr
überprüften. Damit war klar, dass dieser Weg verworfen werden muss.

## Commit 9ab8097a

Im zweiten Ansatz habe ich die nicht-deterministischen Stellen gezielt isoliert. Dazu wurde die Zeit- und Datumslogik
über ein `Clock`-Seam entkoppelt. Die `FakeClock` erlaubt es nun, sowohl den Wochentag als auch die verwendete
Systemzeit präzise zu steuern. Dieser Ansatz entspricht auch dem Vorgehen, das wir in der CSS produktiv einsetzen.
Damit liessen sich die Business Rules («Crazy Sales Day am Freitag» und «Campaign aktiv bei geraden Millisekunden»)
klar, stabil und vollständig testen.

# Fazit

Durch das Einführen des `Clock`-Seams konnte die ursprünglich untestbare Logik sauber isoliert werden, ohne die
öffentliche API zu verändern. Die Tests decken nun alle relevanten Pfade ab und sind vollständig deterministisch.
Die Aufgabe zeigt gut, wie wichtig klar definierte Abhängigkeitsstellen sind, wenn Legacy Code Schritt für Schritt
mithilfe kleiner, sicherer Transformationen unter Test gebracht werden soll.