package example

import com.deflatedpickle.ducknroll.common.api.`object`.Object
import com.deflatedpickle.ducknroll.common.api.component.IComponent
import com.deflatedpickle.ducknroll.common.api.matrix.MutableListMatrix
import com.deflatedpickle.ducknroll.common.api.property.StringProperty
import com.deflatedpickle.ducknroll.common.api.util.CommonProperties
import com.deflatedpickle.ducknroll.common.area.Area
import com.deflatedpickle.ducknroll.common.clock.StepTickClock
import com.deflatedpickle.ducknroll.common.command.HelpCommand
import com.deflatedpickle.ducknroll.common.command.MapCommand
import com.deflatedpickle.ducknroll.common.component.InventoryComponent
import com.deflatedpickle.ducknroll.common.component.TimeDateComponent
import com.deflatedpickle.ducknroll.common.dimension.Dimension
import com.deflatedpickle.ducknroll.common.entity.Player
import com.deflatedpickle.ducknroll.common.parser.CommandParser
import com.deflatedpickle.ducknroll.common.registry.Registries
import com.deflatedpickle.ducknroll.common.world.World

fun main() {
    // As funny rat man says, this should be *automated*
    Registries.command.register("help", ::HelpCommand)
    Registries.command.register("map", ::MapCommand)

    val world = World()

    val player = Player()

    var input: String?
    val timeDate = TimeDateComponent()
    // We want to do different things on update,
    // so we need to extend it
    world.clock = object : StepTickClock<Object>(world = world) {
        override fun update() {
            // This line or any usage of player from the functions it's passed into
            // All result in a crash.
            // I thought it might be a scoping issue, so I put it in a static, thread local object
            // Same error!
            // println(player)

            print("> ")

            // JS: Unresolved reference
            input = readLine()

            input?.let { input ->
                if (input.trim() != "") {
                    CommandParser.parse(input)?.let {
                        when (it) {
                            is HelpCommand -> it.run(player)
                            is MapCommand -> it.run(player)
                            else -> {
                                this.step(20)
                                println(timeDate.getTime())
                            }
                        }
                    }
                }
            }

            super.update()
        }
    }
    world.addComponent(timeDate)

    // We need to add a general dimension
    // Think of these like the overworld, nether and end in Minecraft
    // These will contain areas
    val normalDimension = Dimension(4, 4)

    // We add an area to put things in
    // Think of these like a land mass
    // They will have a map and will contain entities and structures
    val spawnArea = Area(18, 10)

    val tinyForest = Area(5, 5)

    normalDimension.addArea(tinyForest, 0, 1)
    normalDimension.addArea(spawnArea, 1, 1)

    world.addDimension(normalDimension)

    // Give them a name
    player.putProperty(CommonProperties.NAME, StringProperty("Kevin"))
    // Add a pre-made component
    player.addComponent(InventoryComponent())
    // Add a custom component
    player.addComponent(object : IComponent {
        override fun update() {
            println("My custom component (update)")
        }

        override fun catchup() {
            println("My custom component (catchup)")
        }
    })
    spawnArea.spawn(player)

    world.clock?.start()
}