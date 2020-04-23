package example

import com.deflatedpickle.ducknroll.common.common.area.Area
import com.deflatedpickle.ducknroll.common.common.clock.StepTickClock
import com.deflatedpickle.ducknroll.common.api.component.IComponent
import com.deflatedpickle.ducknroll.common.api.registry.IHasRegistry
import com.deflatedpickle.ducknroll.common.common.command.HelpCommand
import com.deflatedpickle.ducknroll.common.common.parser.CommandParser
import com.deflatedpickle.ducknroll.common.common.dimension.Dimension
import com.deflatedpickle.ducknroll.common.common.entity.Player
import com.deflatedpickle.ducknroll.common.common.registry.Registries
import com.deflatedpickle.ducknroll.common.common.world.World
import com.deflatedpickle.ducknroll.common.common.world.WorldTimeDate
import kotlin.reflect.KFunction2

fun main() {
    // As funny rat man says, this should be *automated*
    // Also, get rid of that cast
    Registries.command.register("help", HelpCommand::create as KFunction2<IHasRegistry, List<Any>, Unit>)

    val world = World()

    var input: String?
    val timeDate = WorldTimeDate()
    world.clock = StepTickClock(
        world = world,
        updateCallback = { clock ->
            print("> ")

            input = readLine()

            input?.let { input ->
                if (input.trim() != "") {
                    CommandParser.parse(input)?.let {
                        when (it) {
                            is HelpCommand -> it.run()
                            else -> {
                                clock.step(20)
                                println(timeDate.getTime())
                            }
                        }
                    }
                }
            }

            clock.update()
        }
    )
    world.addComponent(timeDate)

    // We need to add a general dimension
    // Think of these like the overworld, nether and end in Minecraft
    // These will contain areas
    val normalDimension = Dimension()

    // We add an area to put things in
    // Think of these like a land mass
    // They will have a map and will contain entities and structures
    val spawnArea = Area()
    normalDimension.getFirstPropertyOfType<MutableList<Area>>().getValue().add(spawnArea)
    world.getFirstPropertyOfType<MutableList<Dimension>>().getValue().add(normalDimension)

    val player = Player("Kevin")
    player.addComponent(object : IComponent {
        override fun update() {
        }

        override fun catchup() {
        }
    })
    spawnArea.spawn(player)

    world.clock?.start()
}