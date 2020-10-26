import logging
import build_utils

###################################################################
#                           BASE STAGE                            #
###################################################################
class Stages:
    def __init__(self, stage_name):
        self.stage_name = stage_name

    # def __repr__(self):
    #     print("repr: [name:{0}]".format(__name__))

    def run(self):
        pass


###################################################################
#                       BUILD                                     #
###################################################################
class Build(Stages):
    __name__ = 'build'
    def __init__(self, _files):
        super().__init__(stage_name=__name__)
        self._files = _files

    def run(self):
        pass


###################################################################
#                       TEST                                      #
###################################################################
class Test(Stages):
    def __init__(self):
        __name__ = 'test'
        super().__init__(__name__)

    def run(self):
        pass


###################################################################
#                         COMPILE                                 #
###################################################################
class Compile(Stages):
    _name = 'compile'

    def __init__(self, _files):
        super().__init__(stage_name=__name__)
        self._files = _files

    def compile(self):
        import os
        print('Setting current working directory\t{}'.format(os.getcwd()))
        try:
            failed_files = []
            for _dir in self._files:
                for _f in self._files[_dir]:
                    try:
                        if '.java' in _f:
                            if (os.system('javac {}'.format(_f)) != 0):
                                failed_files.append(_f)
                                print('failed files length: \t{0}'.format(len(failed_files)))
                            print('Compiled files:\t {}'.format(_f))
                    except Exception as e:
                        continue
        except Exception as e:
            raise
        finally:
            with open('failed_compilations', 'w') as ff:
                ff.write('\n'.join(failed_files))
            print('Files failed compilation:\t {}'.format(len(failed_files)))

    def run(self):
        print("Stage Running :\t {}".format(Compile._name))
        #TODO Compile/Run then one by one
        self.compile()
        #TODO Use a logger
        print('Compilation done')

###################################################################
#                      STAGES RUNNER                              #
###################################################################
class StageRunner:
    def __init__(self, *args):
        """
        :param kwargs: dictionary of stages inheriting Stages class
        """
        assert args is not  None and len(args) != 0
        self.stages = [stage(args[1]) for stage in args[0]]
        self._files = args[1]

    def run(self):
        for stage in self.stages:
            stage.run()

    def validate(self):
        for stage in self.stages:
            stage.run()


###################################################################
#
###################################################################
if __name__ == '__main__':
    stage_runner = StageRunner([Compile, Build], build_utils.get_dirs())
    stage_runner.run()